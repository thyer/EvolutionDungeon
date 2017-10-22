import java.util.Random;

public class Dungeon {
	private CellContents[][] grid;
	private boolean createdExit = false;
	Dungeon(int x, int y){
		DungeonEvaluator.rand = new Random();
		grid = new CellContents[x][y];
		for(int i = x - 1; i >=0; --i){
			for(int j = 0; j < y; ++j){
				int randInt = DungeonEvaluator.rand.nextInt(20);
				if((i == 0 && j == 0) || randInt < 15){
					grid[i][j] = new Space();
				}
				else if(randInt < 16){
					grid[i][j] = new Monster();
				}
				else if(randInt < 17 && !createdExit){
					createdExit = true;
					grid[i][j] = new Exit();
				}
				else if(randInt < 18){
					grid[i][j] = new Reward();
				}
				else{
					grid[i][j] = new Wall();
				}
			}
		}
	}
	
	public CellContents getContents(int x, int y){
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
			return new Wall();
		}
		return grid[x][y];
	}
	
	public String toString(){
		String output = "";
		for(int i = 0; i < grid.length; ++i){
			for(int j = 0; j < grid[0].length; ++j){
				output += grid[i][j].getClass().getName() + "\t";
			}
			output += "\n";
		}
		
		return output;
	}

}
