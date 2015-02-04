
public abstract class Creature {
	private boolean inteligent;
	private boolean sex;
	private int health;
	private int maxHealth;
	private int level;
	private int xCoord;
	private int yCoord;
	protected static int numberOfCreatures = 0;
	private double agressiveness;
	private float movementSpeed;
	private long experianceValue;
	private String name;
	
	public Creature() {
		numberOfCreatures++;
		this.sex = (boolean)(Math.random() < 0.5);
		System.out.println("loaded new creature, curent number of creatures  "
		+ numberOfCreatures);
	}
	public boolean reduceHealth (int damage){
		this.health -= damage;
		if(this.health <= 0 ){
			return false;
		}
		else{
			return true;
		}
	}
	public void increaseHealth (int healing){
		if(!(health >= maxHealth) && !(health<=0)){
			this.health += healing;
			if(this.health > this.maxHealth){
				this.health = this.maxHealth;
			}
		}
	}
	public static float generateRandomNum(int min, int max){
		
		float result = (float) ((Math.random() * (max - min) + min));
		
		return result;
	}
	public String generateName(){
		return NameGenerator.generateName();
	}
	public String getSex(){
		String result;
		if(sex){
			result = "Male";
		}
		else{
			result = "Female";
		}
		
		return result;
	}
	public boolean isInteligent() {
		return inteligent;
	}
	public void setInteligent(boolean inteligent) {
		this.inteligent = inteligent;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public int getLevel() {
		return level;
	}	
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public int getyCoord() {
		return yCoord;
	}	
	public void setLevel(int level) {
		this.level = level;
	}
	public double getAgressiveness() {
		return agressiveness;
	}
	public void setAgressiveness(double agressiveness) {
		this.agressiveness = agressiveness;
	}
	public float getMovementSpeed() {
		return movementSpeed;
	}
	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	public long getExperianceValue() {
		return experianceValue;
	}
	public void setExperianceValue(long experianceValue) {
		this.experianceValue = experianceValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract void update();
}

