package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class ApplicationTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우의 예외 테스트")
    void 이름_5자_초과_예외() {
        String[] input = {"pobi", "woni", "javaji"}; // "javaji"가 6자

        assertThatThrownBy(() -> {
            Application.exceptionCarName(input); // 검증 메서드 직접 호출
        })
                .isInstanceOf(IllegalArgumentException.class) // ...
                .hasMessageContaining("5자 초과"); // ...
    }

    @Test
    @DisplayName("자동차 이름이 공백일 경우의 예외 테스트")
    void 이름_공백_예외() {
        String[] input = {"pobi", "", "woni"}; // 중간에 빈 이름 ""

        assertThatThrownBy(() -> {
            Application.exceptionCarName(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아닐 경우의 예외 테스트")
    void 시도_횟수_숫자_아님_예외() {
        String input = "abc"; // 숫자가 아님

        assertThatThrownBy(() -> {
            Application.exceptionCount(input); // ...
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수");
    }

    @Test
    @DisplayName("시도할 횟수가 1 미만일 경우의 예외 테스트")
    void 시도_횟수_1_미만_예외() {
        String input = "0"; // 1 미만

        assertThatThrownBy(() -> {
            Application.exceptionCount(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }
}