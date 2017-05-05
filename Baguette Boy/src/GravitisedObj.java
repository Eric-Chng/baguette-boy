

import processing.core.PApplet;

/*
 * Properties of this object:
 *   -affected by gravity
 *   -collides with all platforms
 */
public abstract class GravitisedObj {
	public static final int GRAVITY_POWER = 1;

	public final int mass;
	protected int x, y;
	protected int width, height;
	protected double xSpeed, ySpeed;
	public boolean grounded;
	private Manager m;

	/*
	 * x and y from top left corner of box
	 * width is left side to right side
	 * height is top to bottom
	 */
	public GravitisedObj(int x, int y, int mass, int width, int height, Manager m) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.mass = mass;
		this.width = width;
		this.height = height;
		xSpeed = 0;
		ySpeed = 0;
		grounded = false;
	}

	public void posUpdate() {
		
		x += xSpeed;
		
		int closestPlatform = m.checkPlatformCollision(x+width/2, y+height/2);
		if(closestPlatform<0)
		{
			ySpeed = 0;
			grounded = true;
		}
		else
		{
			//System.out.println(ySpeed);
			if(closestPlatform<ySpeed)
			{
				//System.out.println("Closest" + closestPlatform);
				System.out.println("yes");
				y+=closestPlatform;
				grounded= true;
				ySpeed = 0;
				//grounded = true;
			}
			else
			{
				//System.out.println(ySpeed);
				y += ySpeed;
			}
		}
		
		if (!grounded)
			ySpeed += GRAVITY_POWER;
	}
	public abstract void draw(PApplet g);
	
	public abstract void act(double ratio);

	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

}
