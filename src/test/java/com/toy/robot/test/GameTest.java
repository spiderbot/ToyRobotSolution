package com.toy.robot.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.toy.robot.board.RectangleBoard;
import com.toy.robot.direction.Directions;
import com.toy.robot.direction.ToyRobot;
import com.toy.robot.exceptions.toyrobotexception.ToyRobotException;
import com.toy.robot.gamestarter.Game;
import com.toy.robot.position.Position;

public class GameTest {

    final int BOARD_ROWS = 5;
    final int BOARD_COLUMNS = 5;
    @Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPlacingRobot() throws ToyRobotException {

        RectangleBoard board = new RectangleBoard(BOARD_COLUMNS, BOARD_ROWS);
        ToyRobot toyRobot = new ToyRobot();
        Game game = new Game(board, toyRobot);

        Assert.assertTrue(game.putToyRobot(Directions.NORTH, new Position(0, 1)));
        Assert.assertTrue(game.putToyRobot(Directions.SOUTH, new Position(2, 2)));
        Assert.assertFalse(game.putToyRobot(Directions.WEST, new Position(6, 6)));
        Assert.assertFalse(game.putToyRobot(Directions.EAST, new Position(-1, 5)));
    }

    @Test
    public void testPlacingExceptions() throws ToyRobotException {

        RectangleBoard board = new RectangleBoard(BOARD_COLUMNS, BOARD_ROWS);
        ToyRobot toyRobot = new ToyRobot();
        Game game = new Game(board, toyRobot);

        thrown.expect(ToyRobotException.class);
        game.putToyRobot(null, null);
        thrown.expect(ToyRobotException.class);
        game.putToyRobot(null, new Position(0, 1));
    }

    @Test
    public void testTakeCommandsAndEvaluate() throws ToyRobotException {

        RectangleBoard board = new RectangleBoard(BOARD_COLUMNS, BOARD_ROWS);
        ToyRobot toyRobot = new ToyRobot();
        Game game = new Game(board, toyRobot);

        game.placeAndMoveRobot("PLACE 0,0,NORTH");
        Assert.assertEquals("0,0,NORTH", game.placeAndMoveRobot("REPORT"));

        game.placeAndMoveRobot("MOVE");
        game.placeAndMoveRobot("RIGHT");
        game.placeAndMoveRobot("MOVE");
        Assert.assertEquals("1,1,EAST", game.placeAndMoveRobot("REPORT"));

        // if it goes out of the board it ignores the command
        for (int i = 0; i < 10; i++) {
            game.placeAndMoveRobot("MOVE");
        }
        Assert.assertEquals("5,1,EAST", game.placeAndMoveRobot("REPORT"));

        //rotate on itself
        for (int i = 0; i < 4; i++) {
            game.placeAndMoveRobot("LEFT");
        }
        Assert.assertEquals("5,1,EAST", game.placeAndMoveRobot("REPORT"));

        // invalid commands
        thrown.expect(ToyRobotException.class);
        Assert.assertEquals("Invalid command", game.placeAndMoveRobot("PLACE12NORTH"));
        thrown.expect(ToyRobotException.class);
        Assert.assertEquals("Invalid command", game.placeAndMoveRobot("LEFFT"));
        thrown.expect(ToyRobotException.class);
        Assert.assertEquals("Invalid command", game.placeAndMoveRobot("RIGHTT"));
    }
}
