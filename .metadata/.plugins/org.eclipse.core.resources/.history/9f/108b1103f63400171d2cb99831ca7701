import java.awt.event.KeyEvent;

import processing.core.PApplet;

//import entities.*;

public class Manager implements DestroyListener{

	private GObjectManager gObjects;
	private PlatformManager platforms;
	private Player player;
	
	public Manager() 
	{
		gObjects = new GObjectManager(this);
		platforms = new PlatformManager(this);
		player = new Player(100, 50, 10, 100, 100, this);
		
		
	}
	
	public int checkPlatformCollision(int x, int y, int side)
	{
		return platforms.checkCollision(x, y, side);
	}
	
	public void draw(PApplet g)
	{
		gObjects.drawObjects(g);
		player.draw(g);
		platforms.draw(g);
	}
	
	public void act(double ratio)
	{
		player.act(ratio);
	}
	
	public void mouseWheelMoved(int i)
	{
		player.getWheelMove(i);
	}
	
	public void sendKeyCode(char e)
	{
		player.sendKeyCode(e);
	}
	
	public void releaseKeyCode(char e)
	{
		player.releaseKeyCode(e);
	}

	@Override
	public void destroy(Object a) {
		gObjects.destroy(a);
		platforms.destroy(a);
		
	}
	
	public int getPlayerX()
	{
		return player.getX();
	}
	
}