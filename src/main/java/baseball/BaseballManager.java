package baseball;

import baseball.utils.StringUtil;
import nextstep.utils.Console;

public class BaseballManager {
	private int START_INCURSIVE = 1;
	private int END_INCURSIVE = 9;
	private int NUMBER_LENGTH = 3;
	
	private BaseballMachine baseballMachine = new BaseballMachine(START_INCURSIVE, END_INCURSIVE, NUMBER_LENGTH);
	
	public void playGame() {
		String targetNumber = baseballMachine.generateTargetNumber();
		BallCount ballCount = null;
		do {
			String number = guessNumber();
			ballCount = BallCount.countWith(number, targetNumber);
			ballCount.printResult();
		} while (!ballCount.isStrikeOut());
		System.out.println("게임 끝");
	}
	
	public String guessNumber() {
		String number = null;
		do {
			System.out.println("숫자를 입력해주세요:");
			number = Console.readLine();
		} while (!validatePlayerInput(number));
		return number;
	}
	
	public boolean validatePlayerInput(String value) {
		return isNotEmpty(value) && isNumber(value) && isSameLength(value);
	}
	
	public boolean isNotEmpty(String value) {
		if (StringUtil.isEmpty(value)) {
			System.out.println("[ERROR] 빈값을 입력하셨습니다.");
			return false;
		}
		return true;
	}
	
	public boolean isNumber(String value) {
		if (!StringUtil.isNumber(value)) {
			System.out.println("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
			return false;
		}
		return true;
	}
	
	public boolean isSameLength(String value) {
		if (value.length() != NUMBER_LENGTH) {
			System.out.println("[ERROR] 숫자는 3자리를 입력해주세요.");
			return false;
		}
		return true;
	}
	
	public boolean isReplayGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String value = Console.readLine();
		if (value.equals("1")) {
			return true;
		}
		return false;
	}	
}
