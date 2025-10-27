package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] carNameArr = carName.split(",");

        exceptionCarName(carNameArr);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();



    }

    private static void exceptionCarName(String[] carNameArr) {
        for (String carName : carNameArr) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과하면 안됩니다");
            }
        }
    }
}
