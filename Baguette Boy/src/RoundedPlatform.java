

public class RoundedPlatform extends BoxPlatform{

	public RoundedPlatform(int x, int y, int width, int height)
	{
		super(x,y,width,height);
	}
	
	
	//not currently a functioning class
	public int collideTest(int otherX, int otherY, int side) {
		//check collision
		//check other's location relative to this (ex: y above certain amount and collided:  grounded = true)
		int min = 20000;
		if(otherX>x&&otherX<x+width&&otherY>y&&otherY<y+height)
		{
			if(side==2);
			//return -1;
		}
		int current = Math.abs(x-otherX);
		if(side==1)
		{
			if(current<min&&otherY>y&&otherY<y+height)
			{
				min=current;
			}
			current = Math.abs(x-otherX+width);
			if(current<min&&otherY>y&&otherY<y+height)
			{
				min = current;
			}
			//System.out.println(min);
		}
		else
		{
			current = (int) Math.abs(y-otherY-height*Math.sin((otherX-x)*2*Math.PI/width));
			if(current<min&&otherX>x&&otherX<x+width)
			{
				min = current;
			}
			current = Math.abs(y-otherY+height);
			if(current<min&&otherX>x&&otherX<x+width)
			{
				min = current;
			}
		}
		
		return min;
	}
	
	
	
	
}