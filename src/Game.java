/*
 * the main class for the game world.
 */
public class Game {
	int worldWidth = 0;
	int worldHeight = 0;
	int denizens = 0;
	Creature[] worldInhabitants = new Creature[denizens];
	String[][] currentMap;
	/*
	 * alter denizens to fit the number of denizens likely to be needed
	 */
	public Game(int worldWidthTemp, int worldHeightTemp, int denizensTemp) {
		worldWidth = worldWidthTemp;
		worldHeight = worldHeightTemp;
		denizens = denizensTemp;
		Creature[] worldInhabitants = new Creature[denizens];
		System.out.println(worldHeight + " " + worldWidth + " " + denizens);
		
		currentMap = new String [worldWidth][worldHeight];
		World current = new World(worldWidth,worldHeight);
		for(int y = 0; y < worldHeight; y++){
			for(int x = 0; x < worldWidth; x++){
				currentMap[x][y] = current.transferMap(x, y);
			}
		}
		for(int i = 0; i < denizens; i++){
			worldInhabitants[i] = new Human(current.getWorldMap());
			currentMap[worldInhabitants[i].getxCoord()][worldInhabitants[i].getyCoord()] = "C";
		}		
		System.out.println(displayMap());
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
}

