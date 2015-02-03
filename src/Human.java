/*
 * a example of a human encounter using the Creature abstract class
 */
public class Human extends Creature {
	public Human(){
		this.setAgressiveness((double) generateHumanRandomNum());
		this.setExperianceValue((long) generateHumanRandomNum());
		this.setMaxHealth((int) generateHumanRandomNum());
		this.setHealth(this.getMaxHealth());
		this.setInteligent(true);
		this.setMovementSpeed((float)generateHumanRandomNum());
		this.setName(generateHumanName());
		this.setLevel((int) generateHumanRandomNum()/2);
		System.out.println("I am a human, and i have the following stats");
		System.out.println("i am a " + this.getSex());
		System.out.println("my health is " + this.getHealth());
		System.out.println("my movement speed is " + this.getMovementSpeed());
		System.out.println("and i am level: " + this.getLevel());
	}
	public static String generateHumanName(){
		String result = "Bob"; 
		return result;
	}
	public static float generateHumanRandomNum(){
		/*
		 * generate a random number between 1 & 20
		 */
		float result = (float) ((Math.random() * 19) +1 );
		
		return result;
	}
	public void update(){
		
	}

}
