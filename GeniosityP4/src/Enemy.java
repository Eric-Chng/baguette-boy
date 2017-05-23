import java.awt.Rectangle;

import processing.core.PApplet;

/**
 * 
 * @author Eric Cheng
 *
 */
public class Enemy extends GravitisedObj implements Damagable{
	protected int hp;
	protected int attackDelay;

	/**
	 * Creates a new Enemy object
	 * @param x X of the enemy
	 * @param y Y of the enemy
	 * @param mass Mass value of the enemy(affects falling physics)
	 * @param width Pixel width of the enemy
	 * @param height Pixel height of the enemy
	 * @param m Manager object
	 * @param hp Max health of the enemy
	 */
	public Enemy(int x, int y, int mass, int width, int height, Manager m, int hp) {
		super(x, y, mass, width, height, m);
		this.hp = hp;


	}
	
	/**
	 * Draws the enemy if no submethod is provided
	 * @param g Initialized PApplet
	 */
	public void draw(PApplet g) {
		g.pushStyle();

		g.fill(100,10,50);
		g.text(""+hp, x, y-20);
		g.fill(0,0,255);
		g.rect(x, y, width, height);
		g.popStyle();	

	}

	/**
	 * Acts the enemy
	 * @param ratio Frame ratio (based on 60 FPS)
	 */
	@Override
	public void act(double ratio) {
		
		if (Math.abs(getManager().getPlayerX()) - x < 600){
			if (getManager().getPlayerX() > x)
				x+= 5;
			else
				x-= 5;
			if (Math.abs(getManager().getPlayerX()) - x < 100){
				if (attackDelay <= 0) {
					Hitbox test = new Hitbox(false, 1, super.getX(), super.getY(), 100, 100, 10000, null);
					test.addDestroyListener(super.getManager().getCombat());
					super.getManager().getCombat().addHitbox(test);
					attackDelay = 100;
				}
				attackDelay--;
			}
		}
		posUpdate(ratio);
	}


	/**
	 * Returns a rectangle representation of the enemy's dimensions
	 * @return Rectangle object
	 */
	public Rectangle getRect() {
		return new Rectangle(getX(),getY(), getWidth(),getHeight());
	}

	/**
	 * Makes the enemy take the given amount of damage
	 * @param damage Damage to be taken
	 */
	@Override
	public void takeDamage(int damage) {
		hp-= damage;
		if (hp <= 0)
			getManager().destroy(this);

	}






}