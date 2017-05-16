import processing.core.PApplet;

public class Enemy extends GravitisedObj{

	
	
	public Enemy(int x, int y, int mass, int width, int height, Manager m)
	{
		super(x,y,mass,width,height,m);
	}

	@Override
	public void draw(PApplet g) {
		g.pushStyle();
		g.fill(0,0,255);
		//System.out.println(x+", " + y+", "+xSpeed+", "+ySpeed);
		g.rect(x, y, width, height);
		g.popStyle();	
	}

	@Override
	public void act(double ratio) {
		// TODO Auto-generated method stub
		super.posUpdate(ratio);
	}
	
	
}
