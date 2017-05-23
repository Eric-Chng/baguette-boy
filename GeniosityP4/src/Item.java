import java.awt.Rectangle;


import processing.core.PApplet;

/**
 * 
 * @author Eric Cheng
 *
 */
public class Item {
	public final String type;
	protected int x, y;
	protected boolean pickedUp;
	protected int width, height;

	/**
	 * Creates a new item object
	 * @param property Type of item
	 * @param x X value of item
	 * @param y Y value of item
	 */
	public Item(String property, int x, int y) {
		type = property;
		pickedUp = false;
		this.x = x;
		this.y = y;
		width = 50;
		height = 50;
	}

	/**
	 * Draws the item object
	 * @param g Initialized PApplet
	 */
	public void draw(PApplet g) { //TURN DRAW INTO AN IMAGE LATER
		if(!pickedUp) {
			g.fill(128, 60, 60, 100);
			g.rect(x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)), 50, 50);
		}
	}
	
	/**
	 * Displays the item for an inventory system
	 * @param g Initialized PApplet
	 * @param x X to draw at
	 * @param y Y to draw at
	 * @param ratio Opacity ratio
	 * @param fill Fill greyscale
	 */
	public void display(PApplet g, int x, int y, float ratio, int fill) {
		g.fill(fill);
		g.rect(x, y, ratio * 80, ratio * 80);
		g.fill(0 + 10* 1f/ratio);
		
		g.text(type, x, y+40*ratio);
	}

	/**
	 * Checks collision of the item with the player
	 * @param a Player to check
	 * @return True if the player picks up the object
	 */
	public boolean collide(Player a) {
		if (!pickedUp) {
			Rectangle myself = new Rectangle(x, y, width, height);
			if (myself.intersects(a.getRect())) {
				a.addItem(this);
				pickedUp = true;
				return true;
			}
		}
		return false;
	}
}
