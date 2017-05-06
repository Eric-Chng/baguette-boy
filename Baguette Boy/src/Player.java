

import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class Player extends GravitisedObj{

	public static final int MAX_HP = 100;
	private int hp;
	private int currentInvSpot;
	private Manager manager;
	private boolean rightWalkCode;
	private boolean leftWalkCode;
	private boolean hasJumped;



	public Player(int x, int y, int mass, int width, int height, Manager m) {
		super(x, y, mass, width, height,m);
		hp = MAX_HP;
		currentInvSpot = 0;
		manager = m;
		rightWalkCode=false;
		hasJumped = true;
		leftWalkCode = false;
	}

	public void act(double ratio)
	{
		//ySpeed+=1;
		if(grounded)
		{
			hasJumped = false;
		}
		if(!rightWalkCode&&!leftWalkCode)
		{
			if(xSpeed>0)

			{
				xSpeed-=2;
			}
			else if(xSpeed<0)
			{
				xSpeed+=2;
			}
		}
	
	if(!rightWalkCode||!leftWalkCode)
	{
		if(rightWalkCode&&xSpeed<10)
		{
			xSpeed+=2;
		}
		else if(leftWalkCode&&xSpeed>-10)
		{
			xSpeed-=2;
		}
	}
	else
	{
		if(xSpeed>0)

		{
			xSpeed-=2;
		}
		else if(xSpeed<0)
		{
			xSpeed+=2;
		}
	}
	posUpdate(ratio);

}

public void draw(PApplet g)
{
	g.pushStyle();
	g.fill(255,0,0);
	g.rect(x, y, width, height);
	g.text(""+currentInvSpot, x, y-20);
	g.popStyle();
}

public void sendKeyCode(KeyEvent e)
{
	if(e.getKeyCode()==e.VK_UP)
	{
		if(grounded||!hasJumped)
		{
			hasJumped = true;
			grounded=false;
			ySpeed=-30;
		}
	}
	else if(e.getKeyCode()==e.VK_LEFT)
	{
		this.leftWalkCode = true;
	}
	else if(e.getKeyCode()==e.VK_RIGHT)
	{
		this.rightWalkCode = true;
	}
}

public void releaseKeyCode(KeyEvent e)
{
	System.out.println("hi");
	if(e.getKeyCode()==e.VK_RIGHT)
	{
		this.rightWalkCode = false;
	}
	else if(e.getKeyCode()==e.VK_LEFT)
	{
		this.leftWalkCode = false;
	}



}



public void getWheelMove(int move)
{
	currentInvSpot+=move;
}


}