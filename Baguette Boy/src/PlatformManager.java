import java.util.ArrayList;

import entities.*;

public class PlatformManager {

	private ArrayList<BoxPlatform> platforms;
	
	public PlatformManager()
	{
		platforms = new ArrayList<BoxPlatform>();
	}
	
	public boolean checkCollision(int x, int y)
	{
		boolean collides = false;
		for(BoxPlatform obj: platforms)
		{
			if(obj.collideTest(x,y))
			{
				return true;
			}
		}
		return false;
		
	}
	
	
	
}
