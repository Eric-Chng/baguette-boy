/*
 * Properties of this object:
 *   -affected by gravity
 *   -collides with all platforms
 */
public class GravitisedObj {
	public static final int GRAVITY_POWER = 10;

	public final int mass;
	private int x, y;
	private int width, height;
	private double xSpeed, ySpeed;
	public boolean grounded;

	/*
	 * x and y from top left corner of box
	 * width is left side to right side
	 * height is top to bottom
	 */
	public GravitisedObj(int x, int y, int mass, int width, int height) {
		this.x = x;
		this.y = y;
		this.mass = mass;
		this.width = width;
		this.height = height;
		xSpeed = 0;
		ySpeed = 0;
		grounded = false;
	}

	public void posUpdate() {
		x += xSpeed;
		y += ySpeed;
		if (!grounded)
			y += GRAVITY_POWER * mass;
	}


}
