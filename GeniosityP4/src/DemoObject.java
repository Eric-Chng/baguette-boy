import processing.core.PApplet;

public class DemoObject {

	private int x =600, y=300;
	private double angle = 0;
	
	public DemoObject()
	{
		
		
	}
	
	public void draw(PApplet g)
	{
		g.rect((float)(300+Math.cos(angle)*100), (float)(300+Math.sin(angle)*100), (float)50, (float)50);
	}
	
	public void act(long time)
	{
		double ratio = 16.0/time;
		angle+=ratio*0.1;
	}
}
