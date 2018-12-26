package com.toy.robot.test;

import org.junit.Assert;
import org.junit.Test;

import com.toy.robot.direction.Directions;

public class ToyRobotDirectionTest {

    @Test
    public void testRotateRobot() throws Exception {
        Directions direction = Directions.EAST;

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Directions.NORTH);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Directions.WEST);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Directions.SOUTH);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Directions.EAST);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Directions.NORTH);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Directions.EAST);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Directions.SOUTH);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Directions.WEST);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Directions.NORTH);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Directions.EAST);
    }
}
