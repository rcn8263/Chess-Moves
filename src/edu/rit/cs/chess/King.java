package edu.rit.cs.chess;

import edu.rit.cs.util.ActionResult;
import edu.rit.cs.util.Coordinates;

/**
 * This is the class representing the king.
 * @author Ryan Nowak
 */
public class King extends Piece{

    /**
     * Constructs a new king
     * @param name Name of chess piece
     * @param pos Position of piece on board
     * @param board Board to place the piece on
     */
    public King(String name, Coordinates pos, Game board) {
        super(name, pos, board);
    }

    /**
     * Checks if move is legal for king
     * @param newPos Coordinates of new position
     * @return ActionResult.OK if move is legal.
     * Else, returns ActionResult w/ error message.
     */
    public ActionResult isLegalMove(Coordinates newPos) {
        Coordinates pos = this.getPos();
        if ((newPos.row() == pos.row()-1 && newPos.column() == pos.column()) ||
                (newPos.row() == pos.row()-1 && newPos.column() == pos.column()+1) ||
                (newPos.row() == pos.row() && newPos.column() == pos.column()+1) ||
                (newPos.row() == pos.row()+1 && newPos.column() == pos.column()+1) ||
                (newPos.row() == pos.row()+1 && newPos.column() == pos.column()) ||
                (newPos.row() == pos.row()+1 && newPos.column() == pos.column()-1) ||
                (newPos.row() == pos.row() && newPos.column() == pos.column()-1) ||
                (newPos.row() == pos.row()-1 && newPos.column() == pos.column()-1)) {
            return ActionResult.OK;
        }
        else {
            return new ActionResult("Illegal king move " + newPos);
        }
    }
}
