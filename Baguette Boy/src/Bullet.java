
public class Bullet extends Hitbox{

	private Manager m;
	
	public Bullet(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS, float xVelocity, float yVelocity, Manager man) {
		
			//(boolean fromPlayer, int damage, float x, float y, float width, float height, long DurationInMS, float xVelocity, float yVelocity)
		
		super(fromPlayer, damage, x, y, width, height, DurationInMS,xVelocity,yVelocity);
		m=man;
		// TODO Auto-generated constructor stub
		}
	
	public void act()
	{
		super.act();
		if(m.checkPlatformCollision((int)x, (int)y, 1, false, null)<0&&m.checkPlatformCollision((int)x, (int)y, 2, false, null)<0)
		{
			destruction.destroy(this);
		}
	}

}
