package ua.kpi.chess.server;

import java.util.LinkedList;

public class Knight extends Piece {
    public LinkedList<Byte> FindPossibleMovesItem(byte[][] field, byte PieceCoords, byte colorKnight) {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesKnightI = (byte) (PieceCoords / 10);
        byte coordinatesKnightJ = (byte) (PieceCoords % 10);

        byte[][] Delta = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        for (byte[] delta : Delta) {
            if (coordinatesKnightI + delta[0] >= 0 && coordinatesKnightJ + delta[1] >= 0 &&
                    coordinatesKnightI + delta[0] < 8 && coordinatesKnightJ + delta[1] < 8 &&
                    field[coordinatesKnightI + delta[0]][coordinatesKnightJ + delta[1]] / 10 % 10 != colorKnight) {
                if (!Piece.IsThereACheck(field, PieceCoords,
                        (byte) ((coordinatesKnightI + delta[0]) * 10 + coordinatesKnightJ + delta[1]))) {
                    listPossibleMoves.add((byte) ((coordinatesKnightI + delta[0]) * 10 + coordinatesKnightJ + delta[1]));
                }
            }
        }

        return listPossibleMoves;
    }
}
