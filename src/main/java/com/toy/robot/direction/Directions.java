package com.toy.robot.direction;

import java.util.HashMap;
import java.util.Map;

public enum Directions {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private static Map<Integer, Directions> map = new HashMap<Integer, Directions>();

    static {
        for (Directions directionEnum : Directions.values()) {
            map.put(directionEnum.directionIndex, directionEnum);
        }
    }

    private int directionIndex;

    private Directions(int direction) {
        this.directionIndex = direction;
    }

    public static Directions valueOf(int directionNum) {
        return map.get(directionNum);
    }

    /**
     * Returns the direction on the left of the current one
     */
    public Directions leftDirection() {
        return rotate(-1);
    }

    /**
     * Returns the direction on the right of the current one
     */
    public Directions rightDirection() {
        return rotate(1);
    }

    private Directions rotate(int step) {

        int newIndex = (this.directionIndex + step) < 0 ? map.size() - 1 : (this.directionIndex + step) % map.size();

        return Directions.valueOf(newIndex);
    }

}
