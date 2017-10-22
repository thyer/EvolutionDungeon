
public class Monster implements CellContents {
	private int pointsForBeating;
	private int pointsForLosing;
	private int level;
	
	Monster(){
		pointsForBeating = DungeonEvaluator.rand.nextInt(10) + 1;
		pointsForLosing = DungeonEvaluator.rand.nextInt(5) + 1;
		level = DungeonEvaluator.rand.nextInt(10) + 1;
	}

	@Override
	public int interact(RPGCharacter c) throws Exception {
		int result = c.getLevel() - this.level;
		if(result >= 0){
			return pointsForBeating;
		}
		else if(result < 0){
			return 0 - pointsForLosing;
		}
		
		throw new Exception("Somehow result wasn't greater than, less than, or equal to 0????");
	}

	@Override
	public boolean canMoveIntoSpace(RPGCharacter c) {
		boolean result = c.getLevel() >= level;
		//System.out.println("Character's level was " + c.getLevel() + ", monster's level was: " + level);
		//System.out.println("We return: " + result);
		return result;
	}

}
