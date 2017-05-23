

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.Event;

public class Player extends GravitisedObj implements Damagable{


	public static final int MAX_HP = 100;
	private final int ATT_DELAY = 20;
	private final int ATT_DMG = 18;
	private int hp;
	private Manager manager;
	private boolean rightWalkCode;
	private boolean leftWalkCode;
	private boolean hasJumped;
	private boolean spacePressed;
	private boolean rightFacing;
	private int attTmr;
	public static PImage[] idle;
	public static PImage[] running;
	public static PImage[] slashing;
	private int slashTimer;
	private int animationTimer;
	private int state; //1=idle, 2=running, 3=slashing



	private Inventory inventory;



	public Player(int x, int y, int mass, int width, int height, Manager m) {
		super(x, y, mass, width, height,m);
		hp = MAX_HP;
		manager = m;
		rightWalkCode=false;
		hasJumped = true;
		leftWalkCode = false;
		spacePressed = false;
		rightFacing = true;
		attTmr = 0;
		state=1;

		inventory = new Inventory();
	}

	public void act(double ratio)
	{
		if(slashTimer>0)
		{
			slashTimer--;
		}
		else
		{
			state=1;
			if(state!=1)
				animationTimer=0;
		}
		if(grounded)
		{
			hasJumped = false;
		}
		if(!rightWalkCode&&!leftWalkCode)
		{
			if(xSpeed>0)

			{
				xSpeed-=2;
			}
			else if(xSpeed<0)
			{
				xSpeed+=2;
			}
		}
		else
		{
			state=2;
			if(state!=2)
				animationTimer=0;
		}

		if(!rightWalkCode||!leftWalkCode)
		{
			if(rightWalkCode&&(xSpeed<10))
			{
				rightFacing=true;
				if(onCurve)
				{
					xSpeed+=2;
				}
				xSpeed+=2;
			}
			else if(leftWalkCode&&(xSpeed>-10))
			{
				rightFacing=false;
				xSpeed-=2;
				if(onCurve)
				{
					xSpeed-=2;
				}
			}
		}
		else
		{
			if(xSpeed>0)

			{
				xSpeed-=2;
			}
			else if(xSpeed<0)
			{
				xSpeed+=2;
			}
		}

		if(spacePressed) {
			int tempAttack = inventory.weaponDamage();
			if (tempAttack != 0) {
				Hitbox test;
				float tempProjxV;
				if (xSpeed >=0) {
					tempProjxV = (float)Math.sqrt(xSpeed);
				} else {
					tempProjxV = -1f * (float)Math.sqrt(-xSpeed);
				}
				if (rightFacing)
					test = new Hitbox(true, ATT_DMG, super.getX() + width, super.getY()+super.height/4, 40, super.height/2, 250, tempProjxV, 0);
				else
					test = new Hitbox(true, ATT_DMG, super.getX() -80, super.getY()+super.height/4, 40, super.height/2, 250, tempProjxV, 0);


				test.addDestroyListener(super.getManager().getCombat());
				super.getManager().getCombat().addHitbox(test);
				slashTimer=20;
				animationTimer=0;
				state=3;
			} else if (inventory.rangedWeapon(this)) {
				((RangedWeapon)inventory.getItem()).rangeAttack(this);
			}
			else {
				int tempHeal = inventory.useItem();
				if (tempHeal != 0) {
					hp += tempHeal;
					if (hp > MAX_HP)
						hp = MAX_HP;
				}
			}

			//System.out.println(hp);
		}
		//attTmr--;


		posUpdate(ratio);

	}

	public void draw(PApplet g)
	{
		g.pushMatrix();
		g.pushStyle();
		g.fill(255,0,0);
		//g.rect(x, y, width, height);
		//g.text(""+currentInvSpot, x, y-20);
		g.popStyle();
		if(!rightFacing)
		{
			g.scale(-1,1);
		}


		if(slashTimer>0)
		{
			if(animationTimer==36)
			{

				animationTimer=0;
			}
			if(animationTimer<3)
			{
				//System.out.println(slashing[0]);
				if(rightFacing)
					g.image(slashing[0], x, y, width,height);
				else
					g.image(slashing[0], -x, y, -width,height);

			}
			else if(animationTimer<6)
			{
				width+=15;

				if(rightFacing)
					g.image(slashing[1], x, y, width,height);
				else
					g.image(slashing[1], -x+15, y, -width,height);
				width-=15;
			}
			else
			{
				width+=15;

				if(rightFacing)
					g.image(slashing[2], x, y, width,height);
				else
					g.image(slashing[2],-x+15,y, -width,height);
				width-=15;

			}
			//g.image(slashing, x, y,100,100);
		}
		else if(state==2)
		{

			if(rightFacing)
				g.image(running[(animationTimer%20)/4], x, y, width,height);
			else
				g.image(running[(animationTimer%20)/4],-x,y, -width,height);
		}
		else
		{
			if(rightFacing)
				g.image(idle[(animationTimer%60)/6], x, y, width,height);
			else
				g.image(idle[(animationTimer%60)/6],-x,y, -width,height);
		}
		g.popMatrix();
		animationTimer++;
	}

	public void sendKeyCode(char e)
	{
		if(e=='w')
		{
			if(grounded||!hasJumped||onCurve)
			{
				hasJumped = true;
				grounded=false;
				ySpeed=-40;
				if(onCurve)
				{
					y-=10;
				}
			}
		}
		else if(e=='a')
		{
			this.leftWalkCode = true;
			rightFacing = false;
		}
		else if(e=='d')
		{
			this.rightWalkCode = true;
			rightFacing = true;
		}
		else if (e == ' ') {
			this.spacePressed = true;
		}
	}

	public void releaseKeyCode(char e)
	{
		if(e=='d')
		{
			this.rightWalkCode = false;
		}
		else if(e=='a')
		{
			this.leftWalkCode = false;
		}
		else if(e == ' ') {
			this.spacePressed = false;
		}



	}

	public void sendSpecialKeyCode(int code) {
		if (code == PApplet.SHIFT) {
			inventory.moveInventory(1);
		} else {
			System.out.println(code);
			code += 32;
			if(code =='w')
			{
				if(grounded||!hasJumped||onCurve)
				{
					hasJumped = true;
					grounded=false;
					ySpeed=-30;
					if(onCurve)
					{
						y-=10;
					}
				}
			}
			else if(code=='a')
			{
				this.leftWalkCode = true;
				rightFacing = false;
			}
			else if(code=='d')
			{
				this.rightWalkCode = true;
				rightFacing = true;
			}
			else if (code == ' ' + 32) {
				this.spacePressed = true;
			}
		}

	}



	public void getWheelMove(int move)
	{
		//currentInvSpot+=move;
		inventory.moveInventory(move);
	}

	public int getInvSpot() {
		return inventory.getCurrentPos();
	}

	public ArrayList<Item> getInv() {
		return inventory.getInventory();
	}

	@Override
	public Rectangle getRect() {
		return new Rectangle(getX(),getY(), getWidth(),getHeight());
	}

	@Override
	public void takeDamage(int damage) {
		hp-= damage;
		System.out.println("takes damage");

	}

	public int getHP() {
		return hp;
	}

	public boolean getRightFacing() {
		return rightFacing;
	}

	public void addItem (Item a) {
		inventory.addItem(a);
	}


}
