package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
    	BaseballManager baseballManager = new BaseballManager();
    	do {
    		baseballManager.playGame();
    	} while (baseballManager.isReplayGame());
    }
}
