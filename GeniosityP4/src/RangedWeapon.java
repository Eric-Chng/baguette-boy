import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;

public class RangedWeapon extends Item{
	public static PImage gun;

	public static final int ATT_DMG = 20;
	public static final int ATT_DELAY = 1500;
	public static final int BULLET_SPD = 20;
	private long lastHit;

	/**
	 * Creates a new RangedWeapon object
	 * @param x Pickup location x
	 * @param y Pickup location y
	 * @param type Type of ranged weapon
	 */
	public RangedWeapon(int x, int y, String type) {
		super(type, x, y);
		width = 80;
		height = 80;
		lastHit = 0;

	}

	/**
	 * Draws the ranged weapon for an inventory display
	 * @param g Initialized PApplet
	 * @param x X to draw at
	 * @param y Y to draw at
	 * @param ratio Opacity ratio
	 * @param fill Fill greyscale
	 */
	public void display(PApplet g, int x, int y, float ratio, int fill) {
		g.pushStyle();
		g.tint(255, fill);
		gun.resize((int)(ratio*80), (int)(ratio*80));
		g.image(gun, x, y);
		//attack cooldown bar
		float cooldown = 1.0f - (System.currentTimeMillis() - lastHit)/(float)ATT_DELAY;
		if (cooldown >0) {
			g.fill(200, 150);
			g.rect(x, y, (ratio)*width * cooldown,(ratio)* height);
		}
		g.popStyle();
	}

	public void draw(PApplet g) { 
		if(!pickedUp) {
			gun.resize(width, height);
			g.image(gun, x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)));
			g.text("Damage: " + ATT_DMG, x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0) - 20));
			g.text("Reload: " + ATT_DELAY/1000., x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)));
		}
	}

	/**
	 * Draws the ranged weapon in the environment
	 * @param g Initialized PApplet
	 */
	public boolean rangeAttack(Player p) {
		if (lastHit + ATT_DELAY <= System.currentTimeMillis()) {
			lastHit = System.currentTimeMillis();
			Bullet test;
			float tempProjxV;
			if (p.getRightFacing()) {
				tempProjxV = (float)p.xSpeed + BULLET_SPD;
			} else {
				tempProjxV = (float)p.xSpeed - BULLET_SPD;
			}

			if (p.getRightFacing())
				test = new Bullet(true, ATT_DMG, p.getX(), p.getY() +10, 60, p.height * 0.75f, 1000, tempProjxV, 0, p.getManager(), Color.CYAN);
			else
				test = new Bullet(true, ATT_DMG, p.getX(), p.getY() +10, 60, p.height * 0.75f, 1000, tempProjxV, 0, p.getManager(), Color.CYAN);


			test.addDestroyListener(p.getManager().getCombat());
			p.getManager().getCombat().addHitbox(test);
			return true;
		}
		return false;
	}
}
