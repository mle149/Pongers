import java.awt.Color;

public class Sprite {
	private int height, width;
	private int xPos, yPos;
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
	public int getxPos() {
		return xPos;
	}
	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}
	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	/**
	 * @return the xVelocity
	 */
	public int getxVelocity() {
		return xVelocity;
	}
	/**
	 * @param xVelocity the xVelocity to set
	 */
	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}
	/**
	 * @return the yVelocity
	 */
	public int getyVelocity() {
		return yVelocity;
	}
	/**
	 * @param yVelocity the yVelocity to set
	 */
	public void setyVelocity(int yVelocity) {
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
	
	
	
}
