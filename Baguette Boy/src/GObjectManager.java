import java.util.ArrayList;

import entities.*;
import processing.core.PApplet;

public class GObjectManager {

	private ArrayList<GravitisedObj> objects;
	private ArrayList<GravitisedObj> enemies;
	private Player donkey;

	
	public GObjectManager()
	{
		objects = new ArrayList<GravitisedObj>();

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
	
}