import java.awt.Rectangle;

/**
 * Denotes implementing classes as being able to take damage
 * @author Eric Cheng
 *
 */
public interface Damagable {

	Rectangle getRect();
	void takeDamage(int damage);
}
