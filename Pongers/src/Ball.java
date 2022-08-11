import java.awt.Color;

public class Ball extends Sprite{
	
//Ball variables
	private static final int BALL_WIDTH = 25;
	private static final int BALL_HEIGHT = 25;
	private static final Color BALL_COLOUR = Color.white;

//Ball constructor
public Ball(int panelWidth, int panelHeight) {
	setWidth(BALL_WIDTH);
	setHeight(BALL_HEIGHT);
	setColour(BALL_COLOUR);
	
	
	setInitialXPos(panelWidth/2 - getWidth()/2);
	setInitialYPos(panelHeight/2 - getHeight()/2);
	resetToInitialPosition(getInitialXPos(), getInitialYPos());

}

//Ball Methods
	
	public void resetToInitialPosition(int xPos, int yPos) {
		setNewXPos(getInitialXPos());
	}

}
