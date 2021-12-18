public abstract class Character {
	private int health;
	private int mana;
	private	final String type;
	private boolean isBlocking;

	public Character (int health, int mana, String type) {
		this.health = health;
		this.mana = mana;
		this.type = type;

		this.isBlocking = false;
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
	public boolean isBlocking() {
		return isBlocking;
	}

	//setters
	public void setHealthTo(int amount) {
		health = amount;
	}
	public void setManaTo(int amount) {
		mana = amount;
	}
	public void setBlockingTo(boolean blockStatus) {
		isBlocking = blockStatus;
	}
	public void block() {
		isBlocking = true;
	}
	public void unBlock() {
		isBlocking = false;
	}


	//other methods
	public void attack(Character target, int amount, String attackType) {
		int health = target.getHealth();
		target.setHealthTo(health-amount);
	}

	public void healSelfBy(int amount) {
		health += amount;
	}
	public void rechargeManaBy(int amount) {
		mana += amount;
	}
}
