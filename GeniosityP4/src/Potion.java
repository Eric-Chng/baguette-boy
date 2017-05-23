import processing.core.PApplet;
import processing.core.PImage;

public class Potion extends Item{

	private int amt;
	public static PImage imagePath;
	private PImage self;
	
	/**
	 * Constructs a new potion object
	 * @param x X value of the potion in the environment
	 * @param y Y value of the potion in the environment
	 * @param healAmt Amount the potion will heal
	 */
	public Potion(int x, int y, int healAmt) {
		super("hp", x, y);
		amt = healAmt;
		width = 60;
		height = 105;
		
		self = imagePath.copy();
		
	}
	
	/**
	 * Returns the amount the potion heals
	 * @return Integer representation of health to heal
	 */
	public int getHeal() {
		return amt;
	}
	
	
	/**
	 * Draws the potion for an inventory display
	 * @param g Initialized PApplet
	 * @param x X to draw at
	 * @param y Y to draw at
	 * @param ratio Opacity ratio
	 * @param fill Fill greyscale
	 */
	public void display(PApplet g, int x, int y, float ratio, int fill) {
		g.pushStyle();
		g.tint(255, fill);
		self.resize((int)(ratio*80), (int)(ratio*140));
		g.image(self, x, y);
		g.popStyle();
		
		
		g.text(amt, x + 29*ratio, y+90*ratio);
	}
	
	/**
	 * Draws the potion in the environment
	 * @param g Initialized PApplet
	 */
	public void draw(PApplet g) { 
		if(!pickedUp) {
			self.resize(width, height);
			g.image(self, x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)));
			g.text("Heals: " + amt, x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)));
		}
	}

}
