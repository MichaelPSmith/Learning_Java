/*
 * the main class for the game world.
 */
public class Game {
	/*
	 * alter denizens to fit the number of denizens likely to be needed
	 */
	private static int denizens = (int)((Math.random()*9)+1);
	public static Creature[] woldInhabitants = new Creature[denizens];
	public static void main(String[] args) {
		for(int i = 0; i < denizens; i++){
			woldInhabitants[i] = new Human();
		}
		World current = new World(20,20);
		System.out.println(current.displayMap());
	}
}
