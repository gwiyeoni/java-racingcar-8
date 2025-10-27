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
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}
