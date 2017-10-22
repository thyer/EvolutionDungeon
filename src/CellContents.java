
public interface CellContents {
	
	// character interacts with cell contents and returns a number of points gained
	public int interact(RPGCharacter c) throws Exception;
	
	public boolean canMoveIntoSpace(RPGCharacter c);
}
