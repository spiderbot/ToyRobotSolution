package com.toy.robot.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.toy.robot.direction.Directions;
import com.toy.robot.direction.ToyRobot;
import com.toy.robot.exceptions.toyrobotexception.ToyRobotException;
import com.toy.robot.position.Position;

public class ToyRobotTest {

    @Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMovement() throws ToyRobotException {

        ToyRobot robot = new ToyRobot(1L, "toy1", new Position(0, 0), Directions.NORTH);

        Assert.assertTrue(robot.move());
        Assert.assertEquals(0, robot.getPosition().getX());
        Assert.assertEquals(1, robot.getPosition().getY());
        Assert.assertEquals(Directions.NORTH, robot.getDirection());

        robot.setPosition(new Position(1, 2));
        robot.move();
        robot.move();
        robot.rotateLeft();
        robot.move();

        Assert.assertEquals(0, robot.getPosition().getX());
        Assert.assertEquals(4, robot.getPosition().getY());
        Assert.assertEquals(Directions.WEST, robot.getDirection());

        robot.setPosition(new Position(0, 0));
        robot.rotateRight();
        Assert.assertEquals(Directions.NORTH, robot.getDirection());
        robot.rotateRight();
        Assert.assertEquals(Directions.EAST, robot.getDirection());
        robot.rotateRight();
        Assert.assertEquals(Directions.SOUTH, robot.getDirection());
        robot.rotateRight();
        Assert.assertEquals(Directions.WEST, robot.getDirection());
        robot.rotateRight();
        Assert.assertEquals(Directions.NORTH, robot.getDirection());
    }

}
