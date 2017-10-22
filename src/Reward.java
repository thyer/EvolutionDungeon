
public class Reward implements CellContents {

	@Override
	public int interact(RPGCharacter c) throws Exception {
		return 10;
	}

	@Override
	public boolean canMoveIntoSpace(RPGCharacter c) {
		return true;
	}

}
