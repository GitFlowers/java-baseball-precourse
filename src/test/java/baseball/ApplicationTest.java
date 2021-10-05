package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.assertj.core.api.Assertions.*;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3)
                    .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }
    
    @Test
    void 중복_없는_3자리_숫자() {
    	int startIncursive = 1;
    	int endIncursive = 9;
    	int numberLength = 3;
    	BaseballMachine b = new BaseballMachine(startIncursive,  endIncursive, numberLength);
    	String numberStr = b.generateTargetNumber();
    	String[] numberArr = numberStr.split("");
    	assertThat(numberStr).containsOnlyOnce(numberArr[0]);
    	assertThat(numberStr).containsOnlyOnce(numberArr[1]);
    	assertThat(numberStr).containsOnlyOnce(numberArr[2]);
    }
    
    @Test
    void 사용자_입력_빈값_체크() {
    	BaseballManager baseballManager = new BaseballManager();
    	assertThat(baseballManager.isEmpty(null)).isTrue();
    	assertThat(baseballManager.isEmpty("")).isTrue();
    }
    
    @Test
    void 숫자_입력값_유효성_체크_성공() {
    	BaseballManager baseballManager = new BaseballManager();
    	assertThat(baseballManager.isNumber("123")).isTrue();
    }
    
    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
