
public enum Gene {
	up,
	down,
	left,
	right;
	
	public static Gene getRandGene(){
		int RandInt = DungeonEvaluator.rand.nextInt(4);
		if(RandInt == 0){
			return up;
		}
		else if(RandInt == 1){
			return down;
		}
		else if(RandInt == 2){
			return left;
		}
		else if(RandInt == 3){
			return right;
		}
		System.out.println("ERROR ERROR ERROR");
		return up;
	}
}


