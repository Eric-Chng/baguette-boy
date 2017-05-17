
public class Turret extends Enemy{

	private final int AttTmr = 100;
	private final double bulletSpd = 20;
	private final int dmg = 20;
	
	private final int range = 1500;
	
	
	public Turret(int x, int y, int mass, int width, int height, Manager m) {
		super(x, y, mass, width, height, m, 1000);
		// TODO Auto-generated constructor stub
	}
	
	public void act(double ratio){
		int playerX = super.getManager().getPlayerX();
		int playerY = super.getManager().getPlayerY();
		if(Math.abs(playerX-super.x) <=range && Math.abs(playerY-super.y) <= range) {
			if (attackDelay <= 0) {
				double hyp = Math.sqrt(Math.pow(playerX-super.x, 2) + Math.pow(playerY - super.y, 2));
				double xV = (playerX-super.x)/(hyp/bulletSpd);
				double yV = (playerY-super.y)/(hyp/bulletSpd);


				Hitbox test = new Hitbox(false, dmg, super.getX(), super.getY()+20, 10, 10, 1000, (float) xV, (float)yV);
				test.addDestroyListener(super.getManager().getCombat());
				super.getManager().getCombat().addHitbox(test);
				attackDelay = AttTmr;
			}
		}
		attackDelay--;
		
		super.posUpdate(ratio);
	}

}