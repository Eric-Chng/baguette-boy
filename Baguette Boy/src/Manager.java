import java.awt.event.KeyEvent;

import processing.core.PApplet;

//import entities.*;

public class Manager implements DestroyListener{

	private GObjectManager gObjects;
	private PlatformManager platforms;
	private CombatManager combat;
	private Player player;
	private int platformY;
	
	
	public Manager() 
	{
		gObjects = new GObjectManager(this);
		platforms = new PlatformManager(this);
		player = new Player(100, 50, 10, 100, 100, this);
		combat = new CombatManager(this);
		
		
	}
	
	/**
	 * Returns all gravitised objects
	 * @return
	 */
	public GObjectManager getgObjects() {
		return gObjects;
	}

	/**
	 * Returns all platforms
	 * @return
	 */
	public PlatformManager getPlatforms() {
		return platforms;
	}

	/**
	 * Returns the combat manager
	 * @return
	 */
	public CombatManager getCombat() {
		return combat;
	}
	
	/**
	 * Returns the player object
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Provides an interface for objects in the manager to check collisions
	 * @param x
	 * @param y
	 * @param side
	 * @param isPlayer
	 * @return
	 */
	public int checkPlatformCollision(int x, int y, int side, boolean isPlayer)
	{
		//System.out.println(Math.min(platforms.checkCollision(x, y, side),gObjects.checkCollision(x, y, side)));
		return Math.min(platforms.checkCollision(x, y, side,isPlayer),gObjects.checkCollision(x, y, side, isPlayer));
	}
	
	/**
	 * Draws all objects
	 * @param g
	 */
	public void draw(PApplet g)
	{
		gObjects.drawObjects(g);
		player.draw(g);
		platforms.draw(g);
		combat.drawObjects(g);
	}
	
	/**
	 * Acts all objects
	 * @param ratio
	 */
	public void act(double ratio)
	{
		player.act(ratio);
		gObjects.actObjects(ratio);
		combat.actObjects();
		combat.checkHits();
	}
	
	/**
	 * Sends the mouse wheel movement to the player to the player object
	 * @param i
	 */
	public void mouseWheelMoved(int i)
	{
		player.getWheelMove(i);
	}
	
	/**
	 * Sends a key code to the player object
	 * @param e
	 */
	public void sendKeyCode(char e)
	{
		player.sendKeyCode(e);
	}
	
	/**
	 * Sends a release key code to the player object
	 * @param e
	 */
	public void releaseKeyCode(char e)
	{
		player.releaseKeyCode(e);
	}
	
	/**
	 * Destroys the object in the environment matching the parameter
	 */
	@Override
	public void destroy(Object a) {
		gObjects.destroy(a);
		platforms.destroy(a);
		combat.destroy(a);
		
	}
	
	/**
	 * Returns the x value of the player
	 * @return
	 */
	public int getPlayerX()
	{
		return player.getX();
	}
	
	/**
	 * Returns the y value of the player
	 * @return
	 */
	public int getPlayerY()
	{
		return platformY;
	}
	
	/**
	 * Updates the y value of the platform directly under the player
	 * @param y
	 */
	public void sendPlatformY(int y)
	{
		platformY=y;
		//System.out.println(y);
	}
	
}