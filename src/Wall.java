
public class Wall implements CellContents {

	@Override
	public int interact(RPGCharacter c) throws Exception {
		return 0;
	}

	@Override
	public boolean canMoveIntoSpace(RPGCharacter c) {
		return false;
	}

}
