import java.util.ArrayList;

import processing.core.PApplet;

public class CombatManager implements DestroyListener{
	private ArrayList<Hitbox> hitboxes;

	private Manager manager;
	
	
	

	
	public CombatManager(Manager m)
	{
		hitboxes = new ArrayList<Hitbox>();
		manager = m;

	}
	
	public void actObjects()
	{	
		for (int i = hitboxes.size()-1; i>= 0; i--) {
			hitboxes.get(i).act();
		}
	}
	
	public void drawObjects(PApplet g)
	{
		
		for(Hitbox obj: hitboxes)
		{
			obj.draw(g);
		}
	}
	
	public void checkHits() {
		ArrayList<Damagable> list = manager.getgObjects().getDmg();
		
//		if (hitboxes.size() >0)
//		hitboxes.get(0).collide(manager.getPlayer());
		for (int i = hitboxes.size()-1; i >= 0; i--) {
			Hitbox a = hitboxes.get(i);
			if (!a.getFriendly()) {
				a.collide(manager.getPlayer());
			} else {
				for (int j = list.size()-1; j>= 0; j--) {
					a.collide(list.get(j));
				}
			}
		}
	}
	
	public void destroy(Object a) {
		for (int i = hitboxes.size()-1; i >= 0; i--) {
			if (a == hitboxes.get(i))
				hitboxes.remove(i);
		}
	}
	
	public void addHitbox(Hitbox a) {
		hitboxes.add(a);
	}
}
