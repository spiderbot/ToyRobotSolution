package com.toy.robot.board;

import com.toy.robot.exceptions.boardexception.BoardException;
import com.toy.robot.position.Position;

public interface Board {

    public boolean isValidPosition(Position position) throws BoardException;

}
