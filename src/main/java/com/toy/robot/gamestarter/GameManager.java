package com.toy.robot.gamestarter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.toy.robot.board.Board;
import com.toy.robot.board.RectangleBoard;
import com.toy.robot.direction.ToyRobot;
import com.toy.robot.exceptions.toyrobotexception.ToyRobotException;

public class GameManager {

    public static void main(String[] args) {

        BufferedReader reader = null;
        boolean continueRunning = true;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            Board squareBoard = new RectangleBoard(4, 4);
            //            Position position = new Position(0, 0);
            ToyRobot robot = new ToyRobot(1L, "piyush", null, null);
            Game game = new Game(squareBoard, robot);
            boolean takeTypeOfInput = true;
            System.out.println("Select Type Of Input");
            System.out.println("1 : Console");
            System.out.println("2 : File");
            while (takeTypeOfInput) {
                String typeOfInput = reader.readLine().trim();
                if ("1".equalsIgnoreCase(typeOfInput)) {
                    takeTypeOfInput = false;
                    System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");
                    System.out
                            .println("Enter commands, Press Enter after each command,  Last Command should be REPORT");
                    continueRunning = true;
                    while (continueRunning) {
                        String inputString = reader.readLine();
                        if (!"EXIT".equalsIgnoreCase(inputString)) {
                            checkInputAndMoveRobot(game, inputString);
                        } else {
                            continueRunning = false;
                        }
                    }
                } else if ("2".equalsIgnoreCase(typeOfInput)) {
                    takeTypeOfInput = false;
                    System.out.println("Please provide the path of input file..");
                    String path = reader.readLine();
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
                    continueRunning = true;
                    while (continueRunning) {
                        String input = reader.readLine();
                        if (input != null && !"".equalsIgnoreCase(input) && !"EXIT".equalsIgnoreCase(input)) {
                            checkInputAndMoveRobot(game, input);
                        } else {
                            continueRunning = false;
                        }
                    }
                } else {
                    System.out.println("Invalid Input. Input either of 1 or 2..");
                }
            }
        } catch (IOException exception) {

        }

    }

    private static void checkInputAndMoveRobot(Game game, String inputString) {
        try {
            String outputValue = game.placeAndMoveRobot(inputString);
            if (Boolean.parseBoolean(outputValue)) {
                System.out.println("ACTION : " + inputString + ", RESULT : performed successfully");
            } else {
                System.out.println("ACTION : " + inputString + ", RESULT : " + outputValue);
            }
        } catch (ToyRobotException e) {
            System.out.println(e.getMessage());
        }
    }

}
