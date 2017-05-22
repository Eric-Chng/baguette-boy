import processing.core.PApplet;
import processing.core.PImage;

public class FinalBoss extends Enemy{

	private int jumpCounter;
	private Manager m;
	private int stunTimer;
	public static PImage baguette;

	//private Player player;

	public FinalBoss(int x, int y, int mass, int width, int height, Manager m)
	{
		super(x, y, 2, width, height, m, 360);
		this.m=m;
		stunTimer=200;
		//player=new Player(10000, 0, 10,140*3/4, 260*3/4, man);
	}



	public void act(double ratio)
	{
		
		
		if((stunTimer>0&&stunTimer%10==0)||super.grounded)
		{
			if(xSpeed>0)
			{
				xSpeed--;
			}
			else if(xSpeed<0)
			{
				xSpeed++;
			}
		}
		if(m.getPlayerX()>8900)
		{
			stunTimer--;

			if(stunTimer<1)
			{
				if(hp>200)
				{
					if(jumpCounter<3)
					{
						stunTimer=90;
						ySpeed=-16;
						jumpCounter++;
						if(x>9800)
						{
							xSpeed=-10;
						}
						else if(x<9200)
						{
							xSpeed=10;
						}
						else
						{
							if(Math.random()>0.5)
							{
								xSpeed=10;
							}
							else
							{
								xSpeed=-10;
							}
						}
					}
					else
					{
						stunTimer=20;
						jumpCounter=0;
					}
				}
				else
				{
					if(jumpCounter<3)
					{
						stunTimer=90;
						ySpeed=-20;
						jumpCounter++;
						if(x>9800)
						{
							xSpeed=-15;
						}
						else if(x<9200)
						{
							xSpeed=15;
						}
						else
						{
							if(Math.random()>0.5)
							{
								xSpeed=15;
							}
							else
							{
								xSpeed=-15;
							}
						}
					}
					else
					{
						stunTimer=90;
						jumpCounter=0;
					}
				}
					
					
					
				}

			}




			super.posUpdate(ratio);
		}
		//System.out.println("acting");
	

	public void draw(PApplet g)
	{

		g.text("Geoff: " + hp,x, y-20);
		//g.fill(255,0,0);
		//g.rect(x, y, width, height);
		//System.out.println("draw");
		g.image(baguette, x, y,width,height);

	}
	public int getHealth()
	{
		return hp;
	}




}
