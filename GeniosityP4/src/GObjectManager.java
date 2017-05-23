import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 * @author David McAllister
 *
 */
public class GObjectManager implements DestroyListener{

	private ArrayList<GravitisedObj> objects;
	private Manager manager;
	
	/**
	 * Constructs a new manager for gravitised objects
	 * @param m General manager
	 */
	public GObjectManager(Manager m)
	{
		objects = new ArrayList<GravitisedObj>();
		manager = m;
		objects.add(new Charger(3000,100,10,100,100, manager));
		objects.add(new Turret(5700, 0, 10, 100, 100, manager));
		objects.add(new FinalBoss(10000, -800, 10,59, 191, manager));
		//objects.add(new FinalBoss(m));

	}
	
	/**
	 * Calls the act methods of all gravitised objects
	 * @param ratio Frame ratio (based on 60 FPS)
	 */
	public void actObjects(double ratio)
	{
		for(GravitisedObj obj: objects)
		{
			obj.act(ratio);
		}
	}
	
	/**
	 * Draws all gravitised objects
	 * @param g Initialized PApplet
	 */
	public void drawObjects(PApplet g)
	{
		for(GravitisedObj obj: objects)
		{
			obj.draw(g);
		}
	}
	
	/**
	 * Destroys the specified gravitised object
	 * @param a Gravitised object to destroy
	 */
	public void destroy(Object a) {
		for (int i = objects.size()-1; i >= 0; i--) {
			if (a == objects.get(i))
				objects.remove(i);
		}
	}
	
	/**
	 * Checks collision for all gravitised objects
	 * @param x X value to check
	 * @param y Y value to check
	 * @param side Whether the detection is vertical or horizontal(1 for horizontal, 2 for vertical)
	 * @param isPlayer Whether the object checking detection is the player
	 * @param other Object checking collision
	 * @return Distance to nearest gravitised object
	 */
	public int checkCollision(int x, int y, int side, boolean isPlayer, GravitisedObj other)
	{
		//boolean collides = false;
		int min = 20000;
		for(GravitisedObj obj: objects)
		{
			if(obj!=other)
			{
				int current = obj.collideTest(x, y, side);
				if(current<min)
				{
					min=current;
				}
				if(current<0)                                                                                                                                                                                       
				{
					return -1;
				}
			}
		}
		if(side==2&&min<20000)
		{
			//manager.sendPlatformY(min+y);
		}
		return min;

	}
	
	/**
	 * Returns the health of the final boss
	 * @return Integer representation of health
	 */
	public int getBossHealth()
	{
		for(GravitisedObj obj:objects)
		{
			if(obj instanceof FinalBoss)
			{
				//System.out.println("Health: "+((FinalBoss)obj).getHealth());
				return ((FinalBoss)obj).getHealth();
			}
		}
		return 0;
	}
	
	/**
	 * Gets all damageable gravitised objects
	 * @return ArrayList of gObjects
	 */
	public ArrayList<Damagable> getDmg() {
		ArrayList<Damagable> d = new ArrayList<Damagable>();
		
		for(GravitisedObj obj: objects)
		{
			if (obj instanceof Damagable)
				d.add((Damagable)obj);
		}
		
		//do it for every array it contains
		
		
		
		return d;
	}
	
	
}
