package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int pos;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int rand = Randoms.pickNumberInRange(0, 9);
        if (rand >= 4) {
            this.pos = this.pos + 1;
        }
    }
}
