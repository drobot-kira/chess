package ua.kpi.chess.server;

import java.util.LinkedList;

public class Piece {

    public static boolean IsThereACheck(byte[][] field, byte PieceCoords, byte SquareCoords) {
        byte piece = field[PieceCoords / 10][PieceCoords % 10];
        byte square = field[SquareCoords / 10][SquareCoords % 10];
        field[SquareCoords / 10][SquareCoords % 10] = piece;
        field[PieceCoords / 10][PieceCoords % 10] = 30;
        boolean result = Position.IsThereACheck(field);
        field[SquareCoords / 10][SquareCoords % 10] = square;
        field[PieceCoords / 10][PieceCoords % 10] = piece;
        return result;
    }

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
        possibleMoves = piece.FindPossibleMovesItem(field, PieceCoords, (byte) (pieceId / 10 % 10));
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

    public LinkedList<Byte> FindPossibleMovesItem(byte[][] field, byte PieceCoords, byte Color) {
        return null;
    }
}