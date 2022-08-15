import java.awt.Color;
import java.awt.Rectangle;

public class Sprite {
	private int height;
	private int width;
	private int xPos;
	private int yPos;
	private Color colour;
	private int xVelocity, yVelocity;
	private int initialXPos, initialYPos;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setXPos(int newX, int panelWidth) {
		this.xPos = newX;
		if(xPos < 0) {
			xPos = 0;
		}
		else if (xPos + width > panelWidth) {
			xPos = (panelWidth - width);
		}
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	public void setYPos(int newY, int panelHeight) {
		this.yPos = newY;
		if(yPos < 0) {
			yPos = 0;
		}
		else if (yPos + height > panelHeight) {
			yPos = panelHeight - height;
		}
	}
	

	public int getXVelocity() {
		return xVelocity;
	}

	public void setXVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getYVelocity() {
		return yVelocity;
	}

	public void setYVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	public void setInitialPos(int initialX, int initialY) {
		initialXPos = initialX;
		initialYPos = initialY;
	}
	
	public void resetToInitialPosition() {
		setXPos(initialXPos);
		setYPos(initialYPos);
	}

	public void setNewXPos(int newX) {
		this.xPos = newX;
	}
	
	public void setNewYPos(int newY) {
		this.yPos = newY;
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(getXPos(), getYPos(), getWidth(), getHeight());	
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}
	
}
