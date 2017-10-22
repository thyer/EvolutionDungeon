import java.util.ArrayList;
import java.util.List;

public class GeneManager {
	private List<GeneSequence> genes; // the current 50 genes being evaluated
	private GeneSequence currentBest; // our current best gene of the series
	private final Dungeon dungeon;
	private final RPGCharacter character;
	private static final int MAX_GENES = 50;
	private int evolutions = 0;
	GeneManager(Dungeon d, RPGCharacter c) throws Exception{
		character = c;
		dungeon = d;
		genes = new ArrayList<GeneSequence>();
		currentBest = new GeneSequence();
		System.out.println("Initial score:  " + currentBest.evaluateGeneSequence(d, c));
		genes.add(currentBest);
	}
	
	public void evolve() throws Exception{
		// create new genes
		genes = new ArrayList<GeneSequence>();
		genes.add(currentBest);
		while(genes.size() <= MAX_GENES){
			genes.add(new GeneSequence(currentBest));
		}
		
		// see which one is best
		for(GeneSequence gs : genes){
			if(gs.evaluateGeneSequence(dungeon, character) > currentBest.evaluateGeneSequence(dungeon, character)){
				currentBest = gs;
				System.out.println("Evolution: " + evolutions);
				System.out.println("Current best score: " + currentBest.evaluateGeneSequence(dungeon, character));
			}
		}
		evolutions++;
	}
	
	/**
	 * This is a gene that has 50 moves inside of it
	 * It can be created randomly or by mutating an existing gene
	 * @author Trent
	 *
	 */
	private class GeneSequence{
		private int fitness = 0;
		private List<Gene> gs;
		GeneSequence(){
			gs = new ArrayList<Gene>();
			while(gs.size() < MAX_GENES){
				gs.add(Gene.getRandGene());
			}
		}
		
		GeneSequence(GeneSequence oldGene){
			gs = new ArrayList<Gene>();
			//random replace, FUTURE: combine two old ones, split and rewrite
			for(int i = 0; i < MAX_GENES; ++i){
				if(DungeonEvaluator.rand.nextDouble() > .6){
					gs.add(Gene.getRandGene());
				}
				else{
					gs.add(oldGene.at(i));
				}
			}
		}
		
		public Gene at(int i){
			return gs.get(i);
		}
		
		public int evaluateGeneSequence(Dungeon d, RPGCharacter character) throws Exception{
			if(fitness != 0){
				return fitness;
			}
			
			character.setFoundExit(false);
			int curX = 0;
			int curY = 0;
			for(int i = 0; i < gs.size(); ++i){
				if(character.foundExit()){
					continue;
				}
				
				int X = curX;
				int Y = curY;
				Gene currentMove = gs.get(i);
				if(currentMove == Gene.up){
					Y++;
				}
				else if(currentMove == Gene.down){
					Y--;
				}
				else if(currentMove == Gene.left){
					X--;
				}
				else if(currentMove == Gene.right){
					X++;
				}

				// System.out.println("Currently in (" + curX + ", " + curY + "), moving into (" + X + ", " + Y + ").");
				CellContents c = dungeon.getContents(X, Y);

				//System.out.println("Found a " + c.getClass().getName());
				fitness += c.interact(character);
				if(c.canMoveIntoSpace(character)){
					curX = X;
					curY = Y;
				}
				
			}
			
			//System.out.println("Our fitness was:  " + fitness);
			return fitness;
		}
	}

	public String printBestSolution() throws Exception {
		return "" + currentBest.evaluateGeneSequence(dungeon, character);
	}
}
