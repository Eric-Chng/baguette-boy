import processing.core.PApplet;
import processing.core.PImage;

public class Potion extends Item{

	private int amt;
	public static PImage hpPotion;
	
	public Potion(int x, int y, int healAmt) {
		super("hp", x, y);
		amt = healAmt;
		width = 60;
		height = 105;
		
	}
	
	public int getHeal() {
		return amt;
	}
	
	public void display(PApplet g, int x, int y, float ratio, int fill) {
		g.pushStyle();
		g.tint(255, fill);
		hpPotion.resize((int)(ratio*80), (int)(ratio*140));
		g.image(hpPotion, x, y);
		g.popStyle();
		
		
		g.text(type, x, y+40*ratio);
	}
	
	public void draw(PApplet g) { 
		if(!pickedUp) {
			hpPotion.resize(width, height);
			g.image(hpPotion, x, y + (float)(15*Math.sin(System.currentTimeMillis()/250.0)));
		}
	}

}
