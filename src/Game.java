/*
 * the main class for the game world.
 */
public class Game {
	int worldWidth = 40;
	int worldHeight = 15;
	String[][] currentMap;
	int denizens = (int)((Math.random()*9)+1);
	Creature[] worldInhabitants = new Creature[denizens];
	/*
	 * alter denizens to fit the number of denizens likely to be needed
	 */
	public Game() {
		currentMap = new String [worldWidth][worldHeight];
		World current = new World(40,15);
		for(int y = 0; y < worldHeight; y++){
			for(int x = 0; x < worldWidth; x++){
				currentMap[x][y] = current.transferMap(x, y);
			}
		}
		for(int i = 0; i < denizens; i++){
			worldInhabitants[i] = new Human(current.getWorldMap());
			currentMap[worldInhabitants[i].getxCoord()][worldInhabitants[i].getyCoord()] = "C";
		}
		
	}
	public String displayMap(){
		String map = "";
		for(int i = 0; i <= this.worldHeight-1; i++){
			for(int j = 0; j <= (this.worldWidth-1); j++)			{ 
					map += currentMap[j][i]; 
			}
			map += "\n";			
		}
		return map;
	}
	
	
	public static void main(String[] args) {
		Game main = new Game();
		System.out.println(main.displayMap());
	}
}
