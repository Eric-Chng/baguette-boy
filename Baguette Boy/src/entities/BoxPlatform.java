package entities;

public class BoxPlatform {
	private int x, y;
	private int width, height;
	
	/*
	 * x and y is upper left corner
	 * width is width from left side to right
	 * height is from top to bottom
	 */
	public BoxPlatform(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//boolean is important
	/*
	 * in collision checking, have bool change to true if obj collides with any platform (given by this method)
	 * if bool stays false, grounded turns off and gravity re-enabled
	 */
	public boolean collideTest(int otherX, int otherY) {
		//check collision
		//check other's location relative to this (ex: y above certain amount and collided:  grounded = true)
		
		if(otherX>x&&otherX<x+width&&otherY>y&&otherY<y+height)
		{
			return true;
		}
		return false;
	}
}
