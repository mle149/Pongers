import java.awt.BasicStroke;
import java.awt.Color;
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
	private static final int BALL_SPEED = 3;
	int Player1Score = 0;
	int Player2Score = 0;
	private static final int TIMER_DELAY = 5;
	Timer timer = new Timer(TIMER_DELAY, this);
	Ball ball;
	GameState gameState = GameState.Initialising;
	Paddle paddle1;
	Paddle paddle2;
	
	// Panel constructor
	public Panel() {
	setBackground(Color.BLACK);
	timer.start();
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
		}
		
	}

	private void update(){
		switch(gameState) {
			case Initialising: {
				createObjects();
				gameState = gameState.Playing;
				break;
			}
			case Playing: {
				
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
}
