package edu.rit.cs.chess;

import edu.rit.cs.util.ActionResult;
import edu.rit.cs.util.Coordinates;

/**
 * This is the class representing the knight.
 * @author Ryan Nowak
 */
public class Knight extends Piece{

    /**
     * Constructs a new knight
     * @param name Name of chess piece
     * @param pos Position of piece on board
     * @param board Board to place the piece on
     */
    public Knight(String name, Coordinates pos, Game board) {
        super(name, pos, board);
    }

    /**
     * Checks if move is legal for knight
     * @param newPos Coordinates of new position
     * @return ActionResult.OK if move is legal.
     * Else, returns ActionResult w/ error message.
     */
    public ActionResult isLegalMove(Coordinates newPos) {
        Coordinates pos = this.getPos();
        if ((newPos.row() == pos.row()-2 && newPos.column() == pos.column()+1) ||
                (newPos.row() == pos.row()-1 && newPos.column() == pos.column()+2) ||
                (newPos.row() == pos.row()+1 && newPos.column() == pos.column()+2) ||
                (newPos.row() == pos.row()+2 && newPos.column() == pos.column()+1) ||
                (newPos.row() == pos.row()+2 && newPos.column() == pos.column()-1) ||
                (newPos.row() == pos.row()+1 && newPos.column() == pos.column()-2) ||
                (newPos.row() == pos.row()-1 && newPos.column() == pos.column()-2) ||
                (newPos.row() == pos.row()-2 && newPos.column() == pos.column()-1)) {
            return ActionResult.OK;
        }
        else {
            return new ActionResult("Illegal knight move " + newPos);        }
    }
}
