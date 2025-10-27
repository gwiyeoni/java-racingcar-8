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

        printWinner();
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

    private int findMaxPos() {
        int maxPos = 0;
        for (Car car : cars) {
            if (car.getPos() > maxPos) {
                maxPos = car.getPos();
            }
        }
        return maxPos;
    }

    private List<String> findWinners(int maxPos) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPos() == maxPos) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void printWinner() {
        int maxPos = findMaxPos();
        List<String> winners = findWinners(maxPos);

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
