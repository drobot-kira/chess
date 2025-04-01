package ua.kpi.chess;

import java.util.LinkedList;

public class Piece {
    public static LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords) {
        LinkedList<Byte> possibleMoves;
        byte pieceId = field[PieceCoords / 10][PieceCoords % 10];
        Piece piece = new Piece();
        piece = switch (pieceId % 10) {
            case 1 -> new Pawn();
            case 2 -> new Knight();
            case 3 -> new Bishop();
            case 4 -> new Rook();
            case 5 -> new Queen();
            case 6 -> new King();
            default -> piece;
        };
        possibleMoves = piece.FindPossibleMovesItem(field, PieceCoords, (byte) (pieceId / 10 % 10), true);
        return possibleMoves;
    }


    public static boolean IsMovePossible(byte[][] field, byte PieceCoords, byte SquareCoords) {
        LinkedList<Byte> possibleMoves = FindPossibleMoves(field, PieceCoords);
        for (byte item : possibleMoves) {
            if (item == SquareCoords) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Byte> FindPossibleMovesItem(byte[][] field, byte PieceCoords, byte Color, boolean check) {
        return null;
    }
}