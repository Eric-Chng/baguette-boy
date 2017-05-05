

import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class Player extends GravitisedObj{

	public static final int MAX_HP = 100;
	private int hp;
	private int currentInvSpot;
	private Manager manager;


	public Player(int x, int y, int mass, int width, int height, Manager m) {
		super(x, y, mass, width, height,m);
		hp = MAX_HP;
		currentInvSpot = 0;
		manager = m;
	}

	public void act(double ratio)
	{
		//ySpeed+=1;
		posUpdate();


	}

	public void draw(PApplet g)
	{
		g.pushStyle();
		g.fill(255,0,0);
		g.rect(x, y, width, height);
		g.text(""+currentInvSpot, x, y-20);
		g.popStyle();
	}

	public void sendKeyCode(KeyEvent e)
	{
		if(e.getKeyCode()==e.VK_UP)
		{
			if(grounded)
			{
				grounded=false;
				ySpeed-=20;
			}
		}
	}



	public void getWheelMove(int move)
	{
		currentInvSpot+=move;
	}

	public void posUpdate() {
		super.posUpdate();
		if (hp < 0) {
			//dead
		}
	}
}
