

//import davidmc.shapes.Rectangle;
//import davidmc.shapes.RegularPolygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import entities.*;
import processing.core.PApplet;


public class DrawingSurface extends PApplet implements KeyListener, MouseWheelListener{

	//private	RegularPolygon geoff;
	private DemoObject demo;
	private BoxPlatform dooder;
	private GObjectManager objM;
	private long lastTime = 0;
	private Player donkey;
	
	public DrawingSurface() {
		demo = new DemoObject();
		dooder = new BoxPlatform(300, 0, 600, 20);
		objM = new GObjectManager();
		donkey = new Player(100, 300, 5, 100, 100);
		runSketch();

		
	}
	

	public void setup() {

	}
	

	public void draw() { 
		noStroke();
		fill(210);
		this.background(30);
		//Rectangle backRectangle = new Rectangle(0,0,600,600);
		//backRectangle.draw(this);
		donkey.draw(this);
		//donkey.act(System.currentTimeMillis()-lastTime);
		long time = System.currentTimeMillis()-lastTime;
		double ratio = 16.0/time;
		demo.act(time);
		this.objM.actObjects(ratio);
		donkey.act(ratio);
		lastTime = System.currentTimeMillis();
		demo.draw(this);
		stroke(0);
		noFill();
		//geoff = new RegularPolygon(300,300,5,50);

		//geoff.draw(this);
		}
	
	public void getMouseMove(int move)
	{
		donkey.getWheelMove(move);
	}

	public void getKeyPressed(KeyEvent e)
	{
		
	}
	
	public void getKeyReleased(KeyEvent e)
	{
		
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("bonjour");
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		
	
	
}









