

import processing.core.PApplet;

public class BoxPlatform implements Comparable{
	protected int x, y;
	protected int width, height;

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
	
	public int getMiddleX()
	{
		return x+width/2;
	}

	//boolean is important
	/*
	 * in collision checking, have bool change to true if obj collides with any platform (given by this method)
	 * if bool stays false, grounded turns off and gravity re-enabled
	 */
	public int collideTest(int otherX, int otherY, int side) {
		//check collision
		//check other's location relative to this (ex: y above certain amount and collided:  grounded = true)
		int min = 20000;
		if(otherX>x&&otherX<x+width&&otherY>y&&otherY<y+height)
		{
			if(side==2);
			return -1;
		}
		int current = Math.abs(x-otherX);
		if(side==1)
		{
			if(current<min&&otherY>y&&otherY<y+height)
			{
				min=current;
			}
			current = Math.abs(x-otherX+width);
			if(current<min&&otherY>y&&otherY<y+height)
			{
				min = current;
			}
			//System.out.println(min);
		}
		else
		{
			current = Math.abs(y-otherY);
			if(current<min&&otherX>x&&otherX<x+width)
			{
				min = current;
			}
			current = Math.abs(y-otherY+height);
			if(current<min&&otherX>x&&otherX<x+width)
			{
				min = current;
			}
		}
		
		return min;
	}


	public void draw(PApplet g)
	{
		g.pushStyle();
		g.fill(0,255,0);
		if(width<40)
		{
			
			g.fill(139,69,19);
		}
		g.rect(x, y, width, height);
		if(width<40)
		{
			g.fill(40);
			g.rect(x, y, width/4, height);
			g.rect(x+3*width/4, y, width/4, height);

		}
		g.popStyle();
	}

	public int compareTo(BoxPlatform other) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	public int getWidth()
	{
		return width;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
