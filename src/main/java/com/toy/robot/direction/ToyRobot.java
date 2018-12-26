package com.toy.robot.direction;

import com.toy.robot.exceptions.toyrobotexception.ToyRobotException;
import com.toy.robot.position.Position;

public class ToyRobot {

    private Long id;
    private String name;
    private Position position;
    private Directions direction;

    public ToyRobot() {
    }

    public ToyRobot(Long id, String name, Position position, Directions direction) {
        this.position = position;
        this.direction = direction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setPosition(Position position) {
        if (position == null) {
            return false;
        }

        this.position = position;
        return true;
    }

    public boolean move() throws ToyRobotException {
        return move(getNextPosition());
    }

    /**
     * Moves the robot one unit forward in the direction it is currently facing
     *
     * @return true if moved successfully
     */
    public boolean move(Position newPosition) {
        if (newPosition == null) {
            return false;
        }

        // change position
        this.position = newPosition;
        return true;
    }

    public Position getPosition() {
        return this.position;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    /**
     * Rotates the robot 90 degrees LEFT
     *
     * @return true if rotated successfully
     */
    public boolean rotateLeft() {
        if (this.direction == null) {
            return false;
        }

        this.direction = this.direction.leftDirection();
        return true;
    }

    /**
     * Rotates the robot 90 degrees RIGHT
     *
     * @return true if rotated successfully
     */
    public boolean rotateRight() {
        if (this.direction == null) {
            return false;
        }

        this.direction = this.direction.rightDirection();
        return true;
    }

    public Position getNextPosition() throws ToyRobotException {
        if (this.direction == null) {
            throw new ToyRobotException("Invalid robot direction");
        }

        // new position to validate
        Position newPosition = new Position(this.getPosition());
        switch (this.direction) {
            case NORTH:
                newPosition.incrementPosition(0, 1);
                break;
            case EAST:
                newPosition.incrementPosition(1, 0);
                break;
            case SOUTH:
                newPosition.incrementPosition(0, -1);
                break;
            case WEST:
                newPosition.incrementPosition(-1, 0);
                break;
        }
        return newPosition;
    }

}
