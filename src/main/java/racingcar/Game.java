package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int roundCount;

    public Game(String[] carNameArr, int roundCount) {
        this.cars = getCars(carNameArr);
        this.roundCount = roundCount;
    }

    private List<Car> getCars(String[] carNameArr) {
        List<Car> newCars = new ArrayList<>();
        for (String carName : carNameArr) {
            newCars.add(new Car(carName));
        }
        return newCars;
    }

    public void play() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundCount; i++) {
            playRound();
            playResult();
            System.out.println();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void playResult() {
        for (Car car : cars) {
            String carName = car.getName();
            int carPos = car.getPos();

            System.out.print(carName + ":");
            printStick(carPos);
            System.out.println();
        }
    }

    private void printStick(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }

}
