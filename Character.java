public abstract class Character {
	private int health;
	private int mana;
	private	final String type;

	public Character (int health, int mana, String type) {
		this.health = health;
		this.mana = mana;
		this.type = type;
	}


	//accesors
	public int getHealth() {
		return health;
	}
	public int getMana() {
		return mana;
	}
	public String getType() {
		return type;
	}

	//setters
	public void setHealth(int amount) {
		health = amount;
	}
	public void setMana(int amount) {
		mana = amount;
	}

	//other methods
	public void attack(Character target, int amount) {
		int health = target.getHealth();
		target.setHealth(health-amount);
	}
	public void healSelfBy(int amount) {
		health += amount;
	}
	public void rechargeManaBy(int amount) {
		mana += amount;
	}
}
