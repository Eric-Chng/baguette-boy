import java.awt.Color;
import java.awt.Rectangle;

import processing.core.PApplet;

/**
 * 
 * @author Eric Cheng
 *
 */
public class Hitbox {

	private boolean friendly;
	private int damage;
	protected float x,y;
	protected float width, height;
	private float xV, yV;
	private long lastForMs;
	private long startMS;
	protected DestroyListener destruction;

	protected Color c;

	/**
	 * Creates a new hitbox
	 * @param fromPlayer Whether the hitbox was released by the player
	 * @param damage Damage the hitbox deals
	 * @param x X value of hitbox
	 * @param y Y value of hitbox
	 * @param width Width of hitbox
	 * @param height Height of hitbox
	 * @param DurationInMS Duration of hitbox's existence
	 * @param xVelocity X velocity component
	 * @param yVelocity Y velocity component
	 * 
	 */
	public Hitbox(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS, float xVelocity, float yVelocity) {
		this.friendly = fromPlayer;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this. width = width;
		this.height = height;
		xV = xVelocity;
		yV = yVelocity;
		lastForMs = DurationInMS;
		startMS = System.currentTimeMillis();

		c = new Color(240, 128, 128, 100);
	}

	/**
	 * Creates a new hitbox
	 * @param fromPlayer Whether the hitbox was released by the player
	 * @param damage Damage the hitbox deals
	 * @param x X value of hitbox
	 * @param y Y value of hitbox
	 * @param width Width of hitbox
	 * @param height Height of hitbox
	 * @param DurationInMS Duration of hitbox's existence
	 * @param c Color to draw the hitbox with
	 * 
	 */
	public Hitbox(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS, Color c) {
		this.friendly = fromPlayer;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this. width = width;
		this.height = height;
		xV = 0;
		yV = 0;
		lastForMs = DurationInMS;
		startMS = System.currentTimeMillis();

		c = c;
	}
	
	/**
	 * Creates a new hitbox
	 * @param fromPlayer Whether the hitbox was released by the player
	 * @param damage Damage the hitbox deals
	 * @param x X value of hitbox
	 * @param y Y value of hitbox
	 * @param width Width of hitbox
	 * @param height Height of hitbox
	 * @param DurationInMS Duration of hitbox's existence
	 * 
	 */
	public Hitbox(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS) {
		this.friendly = fromPlayer;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this. width = width;
		this.height = height;
		xV = 0;
		yV = 0;
		lastForMs = DurationInMS;
		startMS = System.currentTimeMillis();

		c = new Color( 240, 128, 128, 100);
	}
	
	/**
	 * Creates a new hitbox
	 * @param fromPlayer Whether the hitbox was released by the player
	 * @param damage Damage the hitbox deals
	 * @param x X value of hitbox
	 * @param y Y value of hitbox
	 * @param width Width of hitbox
	 * @param height Height of hitbox
	 * @param DurationInMS Duration of hitbox's existence
	 * @param xVelocity X velocity component
	 * @param yVelocity Y velocity component
	 * @param c Color to draw the hitbox with
	 */
	public Hitbox(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS, float xVelocity, float yVelocity, Color color) {
		this.friendly = fromPlayer;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this. width = width;
		this.height = height;
		xV = xVelocity;
		yV = yVelocity;
		lastForMs = DurationInMS;
		c = color;
		startMS = System.currentTimeMillis();
	}

	/**
	 * Adds a given DestroyListener to the hitbox
	 * @param a Listener to add
	 */
	public void addDestroyListener(DestroyListener a) {
		destruction = a;
	}

	/**
	 * Acts the hitbox based on game circumstances
	 */
	public void act() {
		if (System.currentTimeMillis() - startMS > lastForMs) {
			System.out.println("test");
			destruction.destroy(this);
		}
		x+= xV;
		y+= yV;
	}

	/**
	 * Draws the hitbox (currently disabled)
	 * @param g Initialized PApplet
	 */
	public void draw(PApplet g) {
		if(c == null)
			return;

		g.fill(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
		g.rect(x, y, width, height);
	}

	/**
	 * Specifies whether the hitbox was created by the player or by an enemy
	 * @return True if from the player, false otherwise
	 */
	public boolean getFriendly() {
		return friendly;
	}

	/**
	 * Checks the hitboxes collision with damageable objects
	 * @param d Damageable object to check
	 */
	public void collide(Damagable d) {
		if (d.getRect().intersects(new Rectangle((int)x,(int)y,(int)width,(int)height))) {
			d.takeDamage(damage);
			destruction.destroy(this);
		}
	}

}
