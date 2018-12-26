/**
 * Copyright (c) 2018 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: piyushjoshi
 * Date:  22-Dec-2018
 */
package com.toy.robot.board;

import com.toy.robot.exceptions.boardexception.BoardException;
import com.toy.robot.position.Position;

/**
 *
 */
public class SquareBoard implements Board {

    private int dimension;

    public SquareBoard(int dimension) {
        this.dimension = dimension;
    }

    public boolean isValidPosition(Position position) throws BoardException {
        if (position.getX() > this.dimension || position.getX() < 0 || position.getY() > this.dimension
                || position.getY() < 0) {
            throw new BoardException("position out of bounds of board");
        } else {
            return true;
        }
    }

}
