package edu.rit.cs.chess;

import edu.rit.cs.util.ActionResult;
import edu.rit.cs.util.Coordinates;

/**
 * This is the class representing the queen.
 * @author Ryan Nowak
 */
public class Queen extends Piece{

    /**
     * Constructs a new queen
     * @param name Name of chess piece
     * @param pos Position of piece on board
     * @param board Board to place the piece on
     */
    public Queen(String name, Coordinates pos, Game board) {
        super(name, pos, board);
    }

    /**
     * Checks if move is legal for queen
     * @param newPos Coordinates of new position
     * @return ActionResult.OK if move is legal.
     * Else, returns ActionResult w/ error message.
     */
    public ActionResult isLegalMove(Coordinates newPos) {
        Coordinates pos = this.getPos();
        if ((newPos.row() == pos.row() && newPos.column() != pos.column()) ||
                (newPos.row() != pos.row() && newPos.column() == pos.column()) ||
                (newPos.row() + newPos.column() == pos.row() + pos.column()) ||
                (newPos.row() - pos.row() == newPos.column() - pos.column())) {
            if (!getBoard().isClearPath(pos, newPos)) {
                return new ActionResult("The way is blocked: " + getPos() + " -> " + newPos);
            }
            else {
                return ActionResult.OK;
            }
        }
        else {
            return new ActionResult("Illegal queen move " + newPos);
        }
    }
}
