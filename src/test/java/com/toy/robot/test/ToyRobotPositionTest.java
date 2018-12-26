package com.toy.robot.test;

import org.junit.Assert;
import org.junit.Test;

import com.toy.robot.position.Position;

public class ToyRobotPositionTest {

    @Test
    public void testGetNextPosition() throws Exception {

        Position position = new Position(0, 0);

        position.incrementPosition(1, 0);
        Assert.assertEquals(position.getX(), 1);
        Assert.assertEquals(position.getY(), 0);

        position.incrementPosition(1, 0);
        Assert.assertNotEquals(position.getX(), 3);
        Assert.assertEquals(position.getY(), 0);

        position.incrementPosition(0, 1);
        Assert.assertNotEquals(position.getX(), 4);
        Assert.assertEquals(position.getY(), 1);

    }
}
