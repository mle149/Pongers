import java.awt.Color;

public class Paddle extends Sprite{
	
	//Paddle variables
	private static final int PADDLE_WIDTH = 10;
	private static final int PADDLE_HEIGHT = 100;
	private static final Color PADDLE_COLOUR = Color.cyan;
	private static final int DISTANCE_FROM_EDGE = 40;
	
	//Paddle constructor
	public Paddle(Player player, int panelWidth, int panelHeight) {
		setWidth(PADDLE_WIDTH);
		setHeight(PADDLE_HEIGHT);
		setColour(PADDLE_COLOUR);
		
		if(player == Player.One) {
			setInitialPos(DISTANCE_FROM_EDGE, panelHeight/2 - getHeight()/2);
			resetToInitialPosition();
		}
		else if (player == Player.Two) {
			setInitialPos(panelWidth - DISTANCE_FROM_EDGE- getWidth(), panelHeight/2 - getHeight()/2);
			resetToInitialPosition();
		}
	}
}
