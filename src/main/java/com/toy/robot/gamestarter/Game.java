package com.toy.robot.gamestarter;

import com.toy.robot.board.Board;
import com.toy.robot.direction.Directions;
import com.toy.robot.direction.ToyRobot;
import com.toy.robot.exceptions.boardexception.BoardException;
import com.toy.robot.exceptions.toyrobotexception.ToyRobotException;
import com.toy.robot.inputcommand.Command;
import com.toy.robot.position.Position;

public class Game {

    Board board;
    ToyRobot robot;

    public Game(Board board, ToyRobot robot) {
        this.board = board;
        this.robot = robot;
    }

    /**
     * Places the robot on the squareBoard  in position X,Y and facing NORTH, SOUTH, EAST or WEST
     *
     * @param position Robot position
     * @return true if placed successfully
     * @throws ToyRobotException
     */
    public boolean putToyRobot(Directions direction, Position position) throws ToyRobotException {

        if (direction == null) {
            throw new ToyRobotException("Invalid direction for the toy robot");
        }
        if (board == null) {
            throw new ToyRobotException("Invalid squareBoard object");
        }

        if (position == null) {
            throw new ToyRobotException("Invalid position object");
        }

        // validate the position
        try {
            if (!board.isValidPosition(position)) {
                return false;
            }
        } catch (BoardException e) {
            return false;
        }

        // if position is valid then assign values to fields
        robot.setDirection(direction);
        robot.setPosition(position);
        return true;
    }

    /**
     * Evals and executes a string command.
     *
     * @param inputString command string
     * @return string value of the executed command
     * @throws com.toy.robot.exceptions.toyrobotexception.ToyRobotException
     *
     */
    public String placeAndMoveRobot(String inputString) throws ToyRobotException {
        String[] args = inputString.split(" ");

        // validate command
        Command command;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new ToyRobotException("Invalid command");
        }
        if (command == Command.PLACE && args.length < 2) {
            throw new ToyRobotException("Invalid command");
        }

        String[] params;
        int x = 0;
        int y = 0;
        Directions commandDirection = null;
        if (command == Command.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandDirection = Directions.valueOf(params[2]);
            } catch (Exception e) {
                throw new ToyRobotException("Invalid command");
            }
        }

        String output;

        switch (command) {
            case PLACE:
                output = String.valueOf(putToyRobot(commandDirection, new Position(x, y)));
                break;
            case MOVE:
                Position newPosition = robot.getNextPosition();
                try {
                    if (!board.isValidPosition(newPosition)) {
                        output = String.valueOf(false);
                    } else {
                        output = String.valueOf(robot.move(newPosition));
                    }
                } catch (BoardException e) {
                    // TODO: piyushjoshi. Write exception handling code
                    System.out.println(e.getMessage());
                    output = String.valueOf(false);
                }
                break;
            case LEFT:
                output = String.valueOf(robot.rotateLeft());
                break;
            case RIGHT:
                output = String.valueOf(robot.rotateRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new ToyRobotException("Invalid command");
        }

        return output;
    }

    /**
     * Returns the X,Y and Direction of the robot
     */
    public String report() {
        if (robot.getPosition() == null) {
            return null;
        }

        return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getDirection().toString();
    }
}
