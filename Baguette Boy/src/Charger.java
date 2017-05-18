import processing.core.PApplet;
import processing.core.PImage;

public class Charger extends Enemy{

	private Manager m;
	private boolean stunned;
	private double stunTimer;
	private boolean charging;
	private int dir;
	private int saveY;
	private PImage star;

	private final int AttTmr = 25;

	public Charger(int x, int y, int mass, int width, int height, Manager m) {
		super(x, y, 6, width, height, m, 100);
		this.m=m;
		stunned = true;
		star=new PImage();


		//System.out.println(x);
		//System.out.println(y);
		//System.out.println(width);
		//System.out.println(height);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Performs an action based on the charger AI
	 */
	public void act(double ratio)
	{
		//ATTACKING WORK
		if (Math.abs(m.getPlayerX()-x) < width+5 && Math.abs(m.getPlayerY() - y) < height + 5) {
			if (attackDelay <= 0) {
				Hitbox test = new Hitbox(false, 20, super.getX(), super.getY()+20, super.width, super.height-20, AttTmr, (float) super.xSpeed, (float)super.ySpeed);
				test.addDestroyListener(super.getManager().getCombat());
				super.getManager().getCombat().addHitbox(test);
				attackDelay = AttTmr;
			}
		}
		attackDelay--;

		//ENEMY BEHAVIOR
		int playerX=m.getPlayerX();
		int playerY=m.getPlayerY();

		if(stunned)
		{
			//System.out.println("stunned");
			stunTimer-=ratio;
			if(stunTimer>2.0)
				y=saveY;
			if(stunTimer<1)
			{
				stunned =false;
			}
		}
		else
		{
			//System.out.println("not stunned");
			//System.out.println(Math.abs(playerY-y));
			if(Math.abs(playerY-y)<200&&!charging)
			{
				//System.out.println("CHARGE");
				charging = true;
				ySpeed=-14;
				if(playerX>x)
				{
					dir=1;
				}
				else
				{
					dir=-1;
				}
			}


		}
		if(Math.abs(playerX-x)>850)
		{
			stun(2);
		}

		if(charging)
		{
			xSpeed+=dir;
		}






		super.posUpdate(ratio);

		if(xSpeed==0&&charging)
		{
			dir=0;
			charging=false;
			stun(100);
			saveY=y;
		}

	}

	private void stun(int time)
	{
		stunned = true;
		stunTimer = time;

	}

	public void draw(PApplet g)
	{
		g.pushStyle();

		star = g.loadImage("star.png");
		if(stunned)
		{
			g.tint(255,(float)stunTimer*2);
			g.image(star, x+width/2-10, y-30,20,20);
		}
		g.fill(255,0,255);
		//System.out.println(x+", " + y+", "+xSpeed+", "+ySpeed);
		g.rect(x, y, width, height-10);
		g.fill(0,0,255);

		g.ellipse(x+width/4, y+height-20, 40, 40);
		g.ellipse(x+width*3/4, y+height-20, 40, 40);

		g.popStyle();
	}



}
