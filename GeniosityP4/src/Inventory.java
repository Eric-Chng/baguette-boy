import java.util.ArrayList;

/**
 * 
 * @author Eric Cheng
 *
 */
public class Inventory {

	private ArrayList<Item> inventory;
	private int invPos;

	/**
	 * Creates a new player inventory
	 */
	public Inventory() {
		inventory = new ArrayList<Item>();
		invPos = 0;
	}

	/**
	 * Returns an ArrayList representation of the inventory
	 * @return ArrayList of items
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/**
	 * Gets the current inventory position
	 * @return Inventory position
	 */
	public int getCurrentPos() {
		return invPos;
	}

	/**
	 * Adds an item to the inventory
	 * @param a Item to add
	 */
	public void addItem(Item a) {
		inventory.add(a);
		invPos %= inventory.size();
	}

	/**
	 * Adjusts the inventory based on a mouse wheel movement
	 * @param amount Amount to adjust by
	 */
	public void moveInventory(int amount) {
		invPos+= amount;
		if (!inventory.isEmpty())
			invPos = (invPos + inventory.size()) % inventory.size();
	}
	
	/**
	 * Uses currently selected item
	 * @return Returns heal amount
	 */
	public int useItem() {
		if (inventory.size() == 0)
			return 0;
		Item a = inventory.get(invPos);
		if (!(a instanceof Potion))
			return 0;
		inventory.remove(invPos);
		invPos--;
		return ((Potion)a).getHeal();
	}

	/**
	 * Gets the damage of the currently selected weapon
	 * @return Weapon damage
	 */
	public int weaponDamage() {
		if (inventory.size() == 0)
			return 0;
		Item a = inventory.get(invPos);
		if (!(a instanceof MeleeWeapon)) {
			return 0;
		}
		if (((MeleeWeapon)a).attack())
			return ((MeleeWeapon)a).ATT_DMG;
		return 0;
	}
	
	/**
	 * Returns whether the currently selected item is a ranged weapon
	 * @param p
	 * @return
	 */
	public boolean rangedWeapon(Player p) {
		if (inventory.size() == 0)
			return false;
		if (inventory.get(invPos) instanceof RangedWeapon)
			return true;
		return false;
	}
	
	/**
	 * Gets the currently selected item
	 */
	public Item getItem() {
		return inventory.get(invPos);
	}
}
