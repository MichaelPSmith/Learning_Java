/*
 * a example of a human encounter using the Creature abstract class
 */
public class Human extends Creature {
	public Human(){
		this.setAgressiveness((double) generateRandomNum(100,50));
		this.setMaxHealth((int) generateRandomNum(20,1));
		this.setHealth(this.getMaxHealth());
		this.setInteligent(true);
		this.setMovementSpeed(generateRandomNum(10,5));
		this.setName(generateName());
		this.setLevel((int) generateRandomNum(10,1));
		this.setExperianceValue((long) generateRandomNum(10*this.getLevel(),5*this.getLevel()));
		System.out.println("I am a human, and i have the following stats");
		System.out.println("I am a " + this.getSex());
		System.out.println("My health is " + this.getHealth());
		System.out.println("My movement speed is " + this.getMovementSpeed() + ",");
		System.out.println("and i am level: " + this.getLevel() + ",");
		System.out.println("and my name is " + this.getName());
	}

	public void update(){
		
	}

}
