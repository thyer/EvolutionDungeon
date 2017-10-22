import java.util.Random;

public class DungeonEvaluator {

	public static Random rand;
	public static final int GENERATIONS = 100000;
	
	public static void main (String[] args) throws Exception{
				// genetic algorithm to go through dungeon (GeneManager),(Gene Sequence), (enum MoveType - up, down, left, right), Fitness Function
		System.out.println("hello!");
		
		Dungeon dungeon = new Dungeon(20,20);
		System.out.println("" + dungeon.toString());
		
		GeneManager genes = new GeneManager(dungeon, new RPGCharacter());
		for(int i = 0; i < GENERATIONS; ++i){
			genes.evolve();
		}
		
		System.out.println("Our best solution: ");
		System.out.println("\t" + genes.printBestSolution());
		
	}

}
