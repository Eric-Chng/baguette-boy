import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * @author Eric Cheng
 *
 */
public class MeleeWeapon extends Item{
	public static PImage sword;
	
	public static final int ATT_DMG = 38;
	public static final int ATT_DELAY = 500;
	private long lastHit;
	
	/**
	 * Creates a new MeleeWeapon object
	 * @param x Pickup location x
	 * @param y Pickup location y
	 * @param type Type of melee weapon
	 */
	public MeleeWeapon(int x, int y, String type) {
		super(type, x, y);
		width = 60;
		height = 105;
		lastHit = 0;
		
	}
	
	/**
	 * Draws the melee weapon for an inventory display
	 * @param g Initialized PApplet
	 * @param x X to draw at
	 * @param y Y to draw at
	 * @param ratio Opacity ratio
	 * @param fill Fill greyscale
	 */
	public void display(PApplet g, int x, int y, float ratio, int fill) {
		g.pushStyle();
		g.tint(255, fill);
		sword.resize((int)(ratio*80), (int)(ratio*140));
		g.image(sword, x, y);
		//attack cooldown bar
		float cooldown = 1.0f - (System.currentTimeMillis() - lastHit)/(float)ATT_DELAY;
		if (cooldown >0) {
			g.fill(200, 150);
			g.rect(x, y, (ratio)*width * cooldown,(ratio)* height);
		}
		g.popStyle();
	}
	
	/**
	 * Draws the melee weapon in the environment
	 * @param g Initialized PApplet
	 */
	public void draw(PApplet g) { 
		if(!pickedUp) {
			sword.resize(width, height);
			g.image(sword, x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)));
			g.text("Damage: " + ATT_DMG, x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0) - 20));
			g.text("Reload: " + ATT_DELAY/1000., x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)));
		}
	}
	
	/**
	 * Specifies whether the melee weapon is able to attack again
	 * @return True if it can attack, false otherwise
	 */
	public boolean attack() {
		if (lastHit + ATT_DELAY <= System.currentTimeMillis()) {
			lastHit = System.currentTimeMillis();
			return true;
		}
		return false;
	}
}
