public class World {
	private int width;
	private int height;
	private int attempts = 0;
	private boolean[][] worldMap;
	private int features = 0;
	
	//World constructor. Create a 2D map of false's given x & y dimensions
	World(int x, int y){
		this.setWidth(x);
		this.setHight(y);
		worldMap = new boolean[x][y]; 
		for(int i = 0; i <= y-1; i++){
			for(int j = 0; j <= x-1; j++){
				worldMap[j][i] = false;
			}
		}
		GenerateWorld();
	}
	
	// get world map. useful for AI
	public boolean[][] getWorldMap()
	{
		return this.worldMap;
	}
	private void setWidth(int x){
		this.width = x;
	}
	public int getWidth(){
		return this.width;
	}
	public int getHeight(){
		return this.height;
	}
	private void setHight(int y){
		this.height = y;
	}	
		
	private void GenerateWorld(){
		//Generate central chamber in the world. 3x3 room.		 
		generateFirstRoom(width/2, height/2);
		while(this.features <= (this.width + this.height)
				&& attempts <  (this.width * this.height)){
			boolean featureType = (boolean)(Math.random() < 0.5);
			
			int randX = (int)((Math.random() * (this.width - 1) + 1));
			int randY = (int)((Math.random() * (this.height - 1) + 1));
			if(featureType){
				generateRoom(randX, randY);
			}
			else{
				generateCorridor(randX, randY);
			}
			attempts++;
		}
		
	}
	private void generateFirstRoom(int x, int y){
		boolean invalidRoom = false;
		
		//check that room is inside of map  not attached to more than 2 other features.
		for (int i = y-2; i <= y+2; i++){
			for(int j = x-2; j <= x+2; j++){
				if(i < 0 || i > this.height-1)
				{
					invalidRoom = true;
					break;
				}
				else if(j < 0 || j > this.width-1)
				{
					invalidRoom = true;
					break;
				}
			}
		}
		if(!invalidRoom){
			worldMap[x][y] = true;
			worldMap[x][y+1] = true;
			worldMap[x][y-1] = true;
			
			worldMap[x+1][y] = true;
			worldMap[x+1][y+1] = true;
			worldMap[x+1][y-1] = true;
			
			worldMap[x-1][y] = true;
			worldMap[x-1][y+1] = true;
			worldMap[x-1][y-1] = true;
			this.features++;
		}
	}
	
	private void generateExit(){
		
	}
	
	private void generateRoom(int x, int y){
		int attachmentCount = 0;
		boolean invalidRoom = false;
		
		//check that room is inside of map  not attached to more than 2 other features.
		for (int i = y-2; i <= y+2; i++){
			for(int j = x-2; j <= x+2; j++){
				if(i < 0 || i > this.height-1)
				{
					invalidRoom = true;
					break;
				}
				else if(j < 0 || j > this.width-1)
				{
					invalidRoom = true;
					break;
				}
			}
		}
		if(!invalidRoom)
		{
			if(worldMap[x+2][y] == true){
				attachmentCount++;
			}
			if(worldMap[x-2][y] == true){
				attachmentCount++;
			}
			if(worldMap[x][y+2] == true){
				attachmentCount++;
			}
			if(worldMap[x][y-2] == true){
				attachmentCount++;
			}
			if(worldMap[x+1][y-2] == true){
				attachmentCount++;
			}
			if(worldMap[x+1][y+2] == true){
				attachmentCount++;
			}
			if(worldMap[x-1][y-2] == true){
				attachmentCount++;
			}
			if(worldMap[x-1][y+2] == true){
				attachmentCount++;
			}
			//////////////////////
			if(worldMap[x+2][y-1] == true){
				attachmentCount++;
			}
			if(worldMap[x+2][y+1] == true){
				attachmentCount++;
			}
			if(worldMap[x-2][y-1] == true){
				attachmentCount++;
			}
			if(worldMap[x-2][y+1] == true){
				attachmentCount++;
			}


		}
		if(!invalidRoom && attachmentCount < 3 && attachmentCount > 0){
			worldMap[x][y] = true;
			worldMap[x][y+1] = true;
			worldMap[x][y-1] = true;
			
			worldMap[x+1][y] = true;
			worldMap[x+1][y+1] = true;
			worldMap[x+1][y-1] = true;
			
			worldMap[x-1][y] = true;
			worldMap[x-1][y+1] = true;
			worldMap[x-1][y-1] = true;
			this.features++;
			this.attempts = 0;
		}
	}
	private void generateCorridor(int x, int y){
		int attachmentCount = 0;
		boolean invalidRoom = false;
		boolean direction = (boolean)(Math.random() < 0.5);
		if(direction){			
			//check that corridor is inside of map  not attached to more than 2 other features.
			for (int i = y-2; i <= y+2; i++){
				for(int j = x-1; j <= x+1; j++){
					if(i < 0 || i > this.height-1)
					{
						invalidRoom = true;
						break;
					}
					else if(j < 0 || j > this.width-1)
					{
						invalidRoom = true;
						break;
					}
				}
			}
			if(!invalidRoom)
			{
				if(worldMap[x][y+2] == true){
					attachmentCount++;
				}
				if(worldMap[x][y-2] == true){
					attachmentCount++;
				}
				if(worldMap[x+1][y+1] == true){
					attachmentCount++;
				}
				if(worldMap[x+1][y-1] == true){
					attachmentCount++;
				}
				if(worldMap[x-1][y+1] == true){
					attachmentCount++;
				}
				if(worldMap[x-1][y-1] == true){
					attachmentCount++;
				}
				
			}
			if(!invalidRoom && attachmentCount < 3 && attachmentCount > 0){
				worldMap[x][y] = true;
				worldMap[x][y+1] = true;
				worldMap[x][y-1] = true;
				this.attempts = 0;
			}
		}
		else{
			//check that corridor is inside of map  not attached to more than 2 other features.
			for (int i = y-1; i <= y+1; i++){
				for(int j = x-2; j <= x+2; j++){
					if(i < 0 || i >= this.height-2)
					{
						invalidRoom = true;
						break;
					}
					else if(j < 0 || j >= this.width-1)
					{
						invalidRoom = true;
						break;
					}
				}
			}
			if(!invalidRoom)
			{
				if(worldMap[x+2][y] == true){
					attachmentCount++;
				}
				if(worldMap[x-2][y] == true){
					attachmentCount++;
				}
				if(worldMap[x+1][y+1] == true){
					attachmentCount++;
				}
				if(worldMap[x+1][y-1] == true){
					attachmentCount++;
				}
				if(worldMap[x-1][y+1] == true){
					attachmentCount++;
				}
				if(worldMap[x-1][y-1] == true){
					attachmentCount++;
				}			
			}
			if(!invalidRoom && attachmentCount < 3 && attachmentCount > 0){
				worldMap[x][y] = true;
				worldMap[x+1][y] = true;
				worldMap[x-1][y] = true;
				this.attempts = 0;
			}
		}
	}
	
	public String displayMap(){
		String map = "";
		for(int i = 0; i <= (this.height-1); i++){
			for(int j = 0; j <= (this.width-1); j++){
				if(worldMap[j][i] == true){
					map += " "; 
				}
				else{
					map += "\u2588";
				}
			}
			map += "\n";			
		}
		return map;
	}
	public String transferMap(int x, int y){
		String map;
		if(worldMap[x][y] == true){
			map = " "; 
		}
		else{
			map = "\u2588";
		}
		return map;
	}
	
}
