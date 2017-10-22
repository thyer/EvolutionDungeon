
public class Space implements CellContents {

	@Override
	public int interact(RPGCharacter c) {
		return 0;
	}

	@Override
	public boolean canMoveIntoSpace(RPGCharacter c) {
		return true;
	}

}
