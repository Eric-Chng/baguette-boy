import java.util.ArrayList;

import processing.core.PApplet;

public class GObjectManager {

	private ArrayList<GravitisedObj> objects;

	private Manager manager;
	
	
	

	
	public GObjectManager(Manager m)
	{
		objects = new ArrayList<GravitisedObj>();
		manager = m;

	}
	
	public void actObjects(double ratio)
	{
		for(GravitisedObj obj: objects)
		{
			obj.act(ratio);
		}
	}
	
	public void drawObjects(PApplet g)
	{
		for(GravitisedObj obj: objects)
		{
			obj.draw(g);
		}
	}
	
	public void destroy(Object a) {
		for (int i = objects.size(); i >= 0; i--) {
			if (a == objects.get(i))
				objects.remove(i);
		}
	}
	
}
