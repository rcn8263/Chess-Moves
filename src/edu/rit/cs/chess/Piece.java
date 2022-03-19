package edu.rit.cs.chess;

/*
 * This tiny skeleton of code is put here only to get the code we
 * give you to compile.
 * You basically must implement this class from scratch.
 */

import edu.rit.cs.util.ActionResult;
import edu.rit.cs.util.Coordinates;

/**
 * Abstract class for all chess pieces.
 * @author Ryan Nowak
 */
public abstract class Piece {
    private String name;
    private Coordinates pos;
    private Game board;

    /**
     * Initializes new chess piece
     * @param name Name of chess piece
     * @param pos Position of piece on board
     * @param board Board to place the piece on
     */
    public Piece(String name, Coordinates pos, Game board) {
        this.name = name;
        this.pos = pos;
        this.board = board;
    }

    /**
     * Gets the board that the piece is on
     * @return board that piece is on
     */
    protected Game getBoard() {
        return this.board;
    }

    /**
     * Abstract method that checks if a move to the specified location is legal.
     * @param newPos New position to move the piece to
     * @return ActionResult.OK if move is legal.
     * Else, returns ActionResult w/ error message.
     */
    protected abstract ActionResult isLegalMove(Coordinates newPos);

    /**
     * Moves the piece if the move is legal. Otherwise, the piece stays put
     * @param end Position to move piece to
     * @return ActionResult based on success or failure of the move
     */
    public ActionResult makeMove( Coordinates end ) {
        ActionResult result = isLegalMove(end);
        if (result.ok) {
            setPos(end);
        }
        return result;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Gets the current position of the piece
     * @return position of piece
     */
    protected Coordinates getPos() {
        return this.pos;
    }

    /**
     * Sets the current position of the piece
     * @param newPos New position to set the piece to
     */
    public void setPos(Coordinates newPos) {
        this.pos = newPos;
    }
}
