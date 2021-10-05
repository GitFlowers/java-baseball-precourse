package baseball;

class BallCount {
	private int strikeCnt = 0;
	private int ballCnt = 0;
	private int totalCnt = 0;
	
	private BallCount(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	public static BallCount countWith(String numberStr, String targetNumberStr) {
		BallCount ballCount = new BallCount(targetNumberStr.length());
		if (numberStr.equals(targetNumberStr)) {
			ballCount.strikeCnt = ballCount.totalCnt;
			return ballCount;
		}
		String[] numberArr = numberStr.split("");
		for (int index = 0; index < numberArr.length; index++) {
			ballCount.calculateBallCount(index, numberArr[index], targetNumberStr);
		}
		return ballCount;
	}
	
	private void addOneStrikeCount() {
		this.strikeCnt += 1;
	}
	
	private void addOneBallCount() {
		this.ballCnt += 1;
	}
	
	private void calculateBallCount(int index, String number, String targetNumberStr) {
		if (isStrike(index, number, targetNumberStr)) {
			this.addOneStrikeCount();
			return;
		}
		if (isBall(index, number, targetNumberStr)) {
			this.addOneBallCount();
		}
	}
	
	private boolean isStrike(int index, String number, String targetNumberStr) {
		return targetNumberStr.indexOf(number) == index;
	}
	
	private boolean isBall(int index, String number, String targetNumberStr) {
		int _index = targetNumberStr.indexOf(number);
		return (_index != -1) && (_index != index);
	}
	
	public boolean isStrikeOut() {
		return strikeCnt == totalCnt;
	}
	
	public void printResult() {
		if (strikeCnt > 0) {
			System.out.print(strikeCnt + "스트라이크 ");
		}
		if (ballCnt > 0) {
			System.out.print(ballCnt + "볼");
		}
		if (strikeCnt == 0 && ballCnt == 0) {
			System.out.print("낫싱") ;
		}
		System.out.println();
	}
}
