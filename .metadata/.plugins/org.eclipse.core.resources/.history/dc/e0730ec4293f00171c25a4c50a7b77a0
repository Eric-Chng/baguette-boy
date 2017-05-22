import java.util.ArrayList;

public class Inventory {

	private ArrayList<Item> inventory;
	private int invPos;

	public Inventory() {
		inventory = new ArrayList<Item>();
		invPos = 0;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public int getCurrentPos() {
		return invPos;
	}


	public void addItem(Item a) {
		inventory.add(a);
		invPos %= inventory.size();
	}

	public void moveInventory() {
		invPos++;
		if (!inventory.isEmpty())
			invPos %= inventory.size();
	}
	
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
	
	public boolean rangedWeapon(Player p) {
		if (inventory.size() == 0)
			return false;
		if (inventory.get(invPos) instanceof RangedWeapon)
			return true;
		return false;
	}
	
	public Item getItem() {
		return inventory.get(invPos);
	}
}
