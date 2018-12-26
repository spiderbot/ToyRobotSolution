package com.toy.robot.board;

import com.toy.robot.exceptions.boardexception.BoardException;
import com.toy.robot.position.Position;

public class RectangleBoard implements Board {

    private int rows;
    private int columns;

    public RectangleBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean isValidPosition(Position position) throws BoardException {
        if (position.getX() > this.columns || position.getX() < 0 || position.getY() > this.rows
                || position.getY() < 0) {
            throw new BoardException("position out of bounds of board");
        } else {
            return true;
        }
    }
}
