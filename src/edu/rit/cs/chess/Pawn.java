package edu.rit.cs.chess;

import edu.rit.cs.util.ActionResult;
import edu.rit.cs.util.Coordinates;

/**
 * This is the class representing the pawn.
 * @author Ryan Nowak
 */
public class Pawn extends Piece{

    /**
     * Constructs a new pawn
     * @param name Name of chess piece
     * @param pos Position of piece on board
     * @param board Board to place the piece on
     */
    public Pawn(String name, Coordinates pos, Game board) {
        super(name, pos, board);
    }

    /**
     * Checks if move is legal for pawn
     * @param newPos Coordinates of new position
     * @return ActionResult.OK if move is legal.
     * Else, returns ActionResult w/ error message.
     */
    public ActionResult isLegalMove(Coordinates newPos) {
        Coordinates pos = this.getPos();
        if (newPos.row() == pos.row()-1 && newPos.column() == pos.column()) {
            return ActionResult.OK;
        }
        else {
            return new ActionResult("Illegal pawn move " + newPos);
        }
    }
}
