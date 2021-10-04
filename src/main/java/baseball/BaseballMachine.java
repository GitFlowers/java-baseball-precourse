package baseball;

import nextstep.utils.Randoms;

class BaseballMachine {
	int startIncursive = 1;
	int endIncursive = 9;
	int numberLength = 3;
	
	public BaseballMachine(int startIncursive, int endIncursive, int numberLength) {
		this.startIncursive = startIncursive;
		this.endIncursive = endIncursive;
		this.numberLength = numberLength;
	}
	
	public String generateTargetNumber() {
		String numberStr = "";
		for (int i = 0; i < numberLength; i++) {
			numberStr += pickNumberNotDuplicateWith(numberStr);
		}
		return numberStr;
	}
	
	private int pickNumberNotDuplicateWith(String numberStr) {
		int num = 0;
		do {
			num = Randoms.pickNumberInRange(startIncursive, endIncursive);
		} while (numberStr.contains("" + num));
		return num;
	}
}
