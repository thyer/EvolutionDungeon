
public class RPGCharacter {
	private boolean foundExit = false;
	private int level;
	
	RPGCharacter(){
		level = 6;
	}

	public int getLevel() {
		return level;
	}

	public void setFoundExit(boolean b) {
		foundExit = b;
	}
	
	public boolean foundExit(){
		return foundExit;
	}

}
