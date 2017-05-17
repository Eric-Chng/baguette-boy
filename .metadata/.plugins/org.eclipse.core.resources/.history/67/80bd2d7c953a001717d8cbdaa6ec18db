
public class Camera {

	private float zoom;
	private int windowWidth, windowHeight;
	private int x,y;
	private int xSpeed, ySpeed;
	private boolean rightFlag,leftFlag,upFlag,downFlag;
	private boolean cameraLocked;
	private boolean frameCounter;

	/**
	 * Constructs a new camera that sets a level of zoom based on the window width and height
	 * @param windowWidth
	 * @param windowHeight
	 */
	public Camera(int windowWidth, int windowHeight)
	{
		//zoom = (float)((double)windowHeight/1080.0);
		//System.out.println((float)((double)windowHeight/1080.0));
		//zoom=1f;
		this.windowHeight=windowHeight;
		this.windowWidth=windowWidth;
		cameraLocked=true;
		//System.out.println(windowHeight);
		frameCounter = false;
		x=-20;
		y=200;
		xSpeed=0;
		ySpeed=0;

	}

	/**
	 * Set the level of zoom
	 * @param z
	 */
	public void setZoom(float z)
	{
		zoom = z;

		//System.out.println(z);
	}

	/**
	 * Changes the level of zoom
	 * @param i - Positive or negative 1
	 */
	public void changeZoom(int i)
	{
		zoom += i*1.1*zoom;
		//x=(int) ((1.0-zoom)*windowWidth);
		//y=(int) ((1.0-zoom)*windowHeight);
	}

	/**
	 * Updates the camera with the most current player position
	 * @param x - player x
	 * @param y - player y
	 */
	public void sendPlayerPos(int x, int y)
	{
		int difference=this.y+y-600;
		int difference2=this.x-x+200;
		//System.out.println("this: " + this.y);
		//System.out.println(y);
		//System.out.println(y);
		if(Math.abs(difference)>5)
		{

			//System.out.println(difference);

			//if(!frameCounter)
			{
				frameCounter = false;
				if(difference>0)
				{
					this.y-=6;
				}
				else
				{
					this.y+=6;
				}
			}

		}

		else
		{
			//System.out.println("hi");
			this.y=-y+600;
			frameCounter = true;
			//this.y=y-300;
		}
		if(x<420)
		{
			cameraLocked=true;
		}
		else if(x<500)
		{
			cameraLocked=false;
		}
		if(!cameraLocked)
		{
			//int difference = x-this.x;
			//x+=difference/2;
			//System.out.println(difference);
			//if(difference<20)
			if (this.x > -x +500){
				this.x-=5;
				if(this.x > -x +600)
					this.x-=6;
			}
			else if(this.x < -x+450){
				this.x+=5;
				if(this.x < -x +350)
					this.x+=6;
			}

			if(x>2800&&x<3800)
			{
				//lockCamera();
			}
			else
			{
				//unlockCamera();
			}
		}


		/*
		if(x>300)
		this.x=-x+300;
		else
			x=-20;
		 */
		//this.y=y-150;
	}

	/**
	 * Returns the camera's level of zoom
	 * @return
	 */
	public float getZoom()
	{
		return zoom;
	}

	/**
	 * Locks the camera in place
	 */
	public void lockCamera()
	{
		cameraLocked=true;
	}

	/**
	 * Unlocks the camera.
	 */
	public void unlockCamera()
	{
		cameraLocked=false;
	}

	public void act(double ratio)
	{

		if(rightFlag)
		{
			x-=(int)(20*ratio);
		}
		if(leftFlag)
		{
			x+=(int)(20*ratio);
		}
		if(downFlag)
		{
			y-=(int)(10*ratio);
		}
		if(upFlag)
		{
			y+=(int)(10*ratio);
		}
	}

	public void moveCamera(int xChange, int yChange)
	{
		x+=xChange;
		y+=yChange;
	}

	/**
	 * Controls the camera's right movement
	 * @param b
	 */
	public void rightMove(boolean b)
	{
		rightFlag=b;
	}

	/**
	 * Controls the camera's left movement
	 * @param b
	 */
	public void leftMove(boolean b)
	{
		leftFlag=b;
	}

	/**
	 * Controls the camera's up movement
	 * @param b
	 */
	public void upMove(boolean b)
	{
		upFlag=b;
	}

	/**
	 * Controls the camera's down movement
	 * @param b
	 */
	public void downMove(boolean b)
	{
		downFlag = b;
	}


	/**
	 * Returns the x translation of the camera
	 * @return
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Returns the y translation of the camera
	 * @return
	 */
	public int getY()
	{
		return y;
	}





}