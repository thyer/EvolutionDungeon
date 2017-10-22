
public class Exit implements CellContents {

	@Override
	public int interact(RPGCharacter c) throws Exception {
		c.setFoundExit(true);
		return 5;
	}

	@Override
	public boolean canMoveIntoSpace(RPGCharacter c) {
		return true;
	}

}
