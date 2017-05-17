import java.awt.Rectangle;


import processing.core.PApplet;

public class Item {
	public final String type;
	private int x, y;
	private boolean pickedUp;

	public Item(String property, int x, int y) {
		type = property;
		pickedUp = false;
		this.x = x;
		this.y = y;
	}

	public void draw(PApplet g) { //TURN DRAW INTO AN IMAGE LATER
		if(!pickedUp) {
			g.fill(128, 60, 60, 100);
			g.rect(x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)), 50, 50);
		}
	}
	
	public void display(PApplet g, int x, int y, float ratio, int fill) {
		g.fill(fill);
		g.rect(x, y, ratio * 80, ratio * 80);
		g.fill(0);
		
		g.text(type, x, y+40*ratio);
	}

	public void collide(Player a) {
		if (!pickedUp) {
			Rectangle myself = new Rectangle(x, y, 50, 50);
			if (myself.intersects(a.getRect())) {
				a.addItem(this);
				pickedUp = true;
			}
		}
	}
}