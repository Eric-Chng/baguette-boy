import java.awt.Color;

import processing.core.PApplet;

public class Bullet extends Hitbox{

	private Manager m;

	/**
	 * Creates a new bullet object
	 * @param fromPlayer Whether the bullet was released by the player
	 * @param damage Damage the bullet deals
	 * @param x X value of bullet
	 * @param y Y value of bullet
	 * @param width Width of bullet
	 * @param height Height of bullet
	 * @param DurationInMS Duration of bullet's existence
	 * @param xVelocity X velocity component
	 * @param yVelocity Y velocity component
	 * @param man Manager Object
	 * @param color Color to draw with
	 */
	public Bullet(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS, float xVelocity, float yVelocity, Manager man, Color color) {

		//(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS, float xVelocity, float yVelocity)

		super(fromPlayer, damage, x, y, width, height, DurationInMS,xVelocity,yVelocity, color);
		m=man;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Acts the bullet object
	 */
	public void act()
	{
		super.act();
		if(m.checkPlatformCollision((int)x, (int)y, 1, false, null)<0&&m.checkPlatformCollision((int)x, (int)y, 2, false, null)<0)
		{
			destruction.destroy(this);
		}
	}

	/**
	 * Draws the bullet
	 * @param g Initialize PApplet
	 */
	public void draw(PApplet g) {
		g.ellipseMode(g.CORNER);
		g.fill(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
		g.ellipse(x, y, width, height);
	}

}
