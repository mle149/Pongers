import java.awt.Color;
import java.awt.Rectangle;

public class Sprite {
	private int height;
	private int width;
	private int xPos;
	private int yPos;
	private Color colour = Color.WHITE;
	private int xVelocity, yVelocity;
	private int initialXPos, initialYPos;
	
	

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the xPos
	 */
	public int getXPos() {
		return xPos;
	}
	/**
	 * @param xPos the xPos to set
	 */
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setXPos(int xPos, int panelWidth) {
		this.xPos = xPos;
		if(xPos - (getWidth()/2) < 0) {
			setNewXPos(getWidth()/2);
		}
		else if (xPos + (getWidth()/2) > panelWidth) {
			setNewXPos(panelWidth - (getWidth()/2) );
		}
	}
	/**
	 * @return the yPos
	 */
	public int getYPos() {
		return yPos;
	}
	/**
	 * @param yPos the yPos to set
	 */
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	public void setYPos(int yPos, int panelHeight) {
		this.yPos = yPos;
		if(yPos - (getHeight()/2) < 0) {
			setNewYPos(getHeight()/2);
		}
		else if (yPos + (getHeight()/2) > panelHeight) {
			setNewYPos(panelHeight - (getHeight()/2) );
		}
	}
	
	/**
	 * @return the xVelocity
	 */
	public int getXVelocity() {
		return xVelocity;
	}
	/**
	 * @param xVelocity the xVelocity to set
	 */
	public void setXVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}
	/**
	 * @return the yVelocity
	 */
	public int getYVelocity() {
		return yVelocity;
	}
	/**
	 * @param yVelocity the yVelocity to set
	 */
	public void setYVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}
	/**
	 * @return the initialXPos
	 */
	public int getInitialXPos() {
		return initialXPos;
	}
	/**
	 * @param initialXPos the initialXPos to set
	 */
	public void setInitialXPos(int initialXPos) {
		this.initialXPos = initialXPos;
	}
	/**
	 * @return the initialYPos
	 */
	public int getInitialYPos() {
		return initialYPos;
	}
	/**
	 * @param initialYPos the initialYPos to set
	 */
	public void setInitialYPos(int initialYPos) {
		this.initialYPos = initialYPos;
	}

	public void setNewXPos(int newX) {
		this.xPos = newX;
	}
	
	public void setNewYPos(int newY) {
		this.yPos = newY;
	}
	
	public Rectangle getRectangle(int xPos, int yPos) {
		Rectangle rect = new Rectangle(getXPos(), getYPos(), getWidth(), getHeight());
		return rect;	
	}
	/**
	 * @return the colour
	 */
	public Color getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}
	
}
