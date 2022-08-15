import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener,KeyListener{
	//variables
	private static final int POINTS_TO_WIN = 3;
	private static final int BALL_SPEED = 10;
	int Player1Score = 0;
	int Player2Score = 0;
	Player gameWinner;
	private static final int TIMER_DELAY = 5;
	Timer timer = new Timer(TIMER_DELAY, this);
	Ball ball;
	GameState gameState = GameState.Initialising;
	Paddle paddle1;
	Paddle paddle2;
	private final static int WINNER_TEXT_X = 200;
    private final static int WINNER_TEXT_Y = 200;
    private final static int WINNER_FONT_SIZE = 40;
    private final static String WINNER_FONT_FAMILY = "Serif";
    private final static String WINNER_TEXT = "WIN!";
	
	// Panel constructor
	public Panel() {
	setBackground(Color.BLACK);
	timer.start();
	addKeyListener(this);
	setFocusable(true);
	}
	
	public void createObjects() {
		ball = new Ball(getWidth(), getHeight());
		paddle1 = new Paddle(Player.One,getWidth(), getHeight());
		paddle2 = new Paddle(Player.Two,getWidth(), getHeight());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		Graphics2D g2d = (Graphics2D) g;
		//g2d.setStroke(new BasicStroke(10));
		BasicStroke bs = new BasicStroke(5.0f, // Width 
							BasicStroke.CAP_SQUARE, // End cap 
							BasicStroke.JOIN_MITER, // Join style 
							10.0f, // Miter limit 
							new float[] {16.0f,20.0f}, // Dash pattern 
							0.0f); //
		g2d.setStroke(bs);
		g2d.setColor(Color.WHITE);
		g2d.drawLine( (getWidth()/2), 0, (getWidth()/2), getHeight() );
		if(gameState != GameState.Initialising) {
			paintSprite(g, ball);
			paintSprite(g, paddle1);
			paintSprite(g, paddle2);
			paintScores(g);
			paintWinner(g);
		}
		
	}
	
	private void paintScores(Graphics g) {
        int xPadding = 100;
        int yPadding = 100;
        int fontSize = 50; 
        Font scoreFont = new Font("Serif", Font.BOLD, fontSize);
        String leftScore = Integer.toString(Player1Score);
        String rightScore = Integer.toString(Player2Score);
        g.setFont(scoreFont);
        g.drawString(leftScore, xPadding, yPadding);
       g.drawString(rightScore, getWidth()-xPadding, yPadding);
	}		 

	private void paintWinner(Graphics g) {

         if(gameWinner != null) {
            Font winnerFont = new Font(WINNER_FONT_FAMILY, Font.BOLD, WINNER_FONT_SIZE);
            g.setFont(winnerFont);
            int xPosition = getWidth() / 2;
            if(gameWinner == Player.One) {
                xPosition -= WINNER_TEXT_X;
            } else if(gameWinner == Player.Two) {
                xPosition += WINNER_TEXT_X;
            }
            g.drawString(WINNER_TEXT, xPosition, WINNER_TEXT_Y);
        }
    }
	
	private void moveObject(Sprite sprite) {
		sprite.setXPos(sprite.getXPos() + sprite.getXVelocity(), getWidth());
		sprite.setYPos(sprite.getYPos() + sprite.getYVelocity(), getHeight());
	}
	
	private void checkPaddleBounce(Sprite sprite) {
		if(sprite.getXVelocity() < 0 && ball.getRectangle().intersects(paddle1.getRectangle())) {
			sprite.setXVelocity(-(sprite.getXVelocity()));
		}
		if(sprite.getXVelocity() > 0 && ball.getRectangle().intersects(paddle2.getRectangle())) {
			sprite.setXVelocity(-(sprite.getXVelocity()));
		}
	}

	private void checkWallBounce(Sprite sprite) {
		//check if hits LEFT wall
		if(sprite.getXPos() <= 0) {
			sprite.setXVelocity(-(sprite.getXVelocity()));			
			addScore(Player.Two);
			resetBall();		
		}
		//check if hits RIGHT wall
		else if(sprite.getXPos() >= getWidth() - sprite.getWidth() ) {
			sprite.setXVelocity(-(sprite.getXVelocity()));
			addScore(Player.One);
			resetBall();
		}
		//check if hits TOP wall
		else if(sprite.getYPos() <= 0) {
			sprite.setYVelocity(-(sprite.getYVelocity()));
		}
		//check if hits BOTTOM wall
		else if(sprite.getYPos() >= getHeight() - sprite.getHeight()) {
			sprite.setYVelocity(-(sprite.getYVelocity()));
		}
	}
	
	private void resetBall() {
		ball.resetToInitialPosition();
	}
	
	private void addScore(Player player) {
		if(player == Player.One) {
			Player1Score++;
		}
		else {
			Player2Score++;
		}
	}
	
	private void checkIfGameOver() {
		if (Player1Score == POINTS_TO_WIN) {			
			gameWinner = Player.One;
			gameState = GameState.GameOver;
		}
		else if (Player2Score == POINTS_TO_WIN) {
			gameWinner = Player.Two;
			gameState = GameState.GameOver;			
		}
	}
	
	private void update(){
		switch(gameState) {
			case Initialising: {
				createObjects();
				gameState = gameState.Playing;
				ball.setXVelocity(BALL_SPEED);
				ball.setYVelocity(BALL_SPEED);			
				break;
			}
			case Playing: {
				moveObject(paddle1);
				moveObject(paddle2);
				moveObject(ball);
				checkWallBounce(ball);
				checkPaddleBounce(ball);
				checkIfGameOver();
				break;
			}
			case GameOver: {			
				break;
			}
		}
	}
	
	public void paintSprite(Graphics g, Sprite sprite){
		g.setColor(sprite.getColour());
		g.fillRect(sprite.getXPos(), sprite.getYPos(), sprite.getWidth(), sprite.getHeight());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			paddle2.setYVelocity(-5);
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			paddle2.setYVelocity(5);
		}
		if(e.getKeyCode()== KeyEvent.VK_W) {
			paddle1.setYVelocity(-5);
		}
		if(e.getKeyCode()== KeyEvent.VK_S) {
			paddle1.setYVelocity(5);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			paddle2.setYVelocity(0);
		}
		else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			paddle2.setYVelocity(0);
		}
		if(e.getKeyCode()== KeyEvent.VK_W) {
			paddle1.setYVelocity(0);
		}
		else if(e.getKeyCode()== KeyEvent.VK_S) {
			paddle1.setYVelocity(0);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
}
