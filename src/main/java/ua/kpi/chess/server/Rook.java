package ua.kpi.chess.server;

import java.util.LinkedList;

public class Rook extends Piece {
    public LinkedList<Byte> FindPossibleMovesItem(byte[][] startField, byte PieceCoords, byte colorRook) {

        byte[][] field = new byte[9][8];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 8; j++) {
                field[i][j] = startField[i][j];
            }
        }

        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesRookI = (byte) (PieceCoords / 10);
        byte coordinatesRookJ = (byte) (PieceCoords % 10);

        for (byte j = (byte) (coordinatesRookJ + 1); j <= 7; j++) {
            if (field[coordinatesRookI][j] / 10 % 10 == colorRook) {
                break;
            } else if (field[coordinatesRookI][j] != 30) {
                if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((coordinatesRookI * 10) + j))) {
                    listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
                }
                break;
            }
            if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((coordinatesRookI * 10) + j))) {
                listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
            }
        }

        for (byte j = (byte) (coordinatesRookJ - 1); j >= 0; j--) {
            if (field[coordinatesRookI][j] / 10 % 10 == colorRook) {
                break;
            } else if (field[coordinatesRookI][j] != 30) {
                if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((coordinatesRookI * 10) + j))) {
                    listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
                }
                break;
            }
            if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((coordinatesRookI * 10) + j))) {
                listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
            }
        }

        for (byte i = (byte) (coordinatesRookI + 1); i <= 7; i++) {
            if (field[i][coordinatesRookJ] / 10 % 10 == colorRook) {
                break;
            } else if (field[i][coordinatesRookJ] != 30) {
                if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((i * 10) + coordinatesRookJ))) {
                    listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
                }
                break;
            }
            if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((i * 10) + coordinatesRookJ))) {
                listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
            }
        }

        for (byte i = (byte) (coordinatesRookI - 1); i >= 0; i--) {
            if (field[i][coordinatesRookJ] / 10 % 10 == colorRook) {
                break;
            } else if (field[i][coordinatesRookJ] != 30) {
                if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((i * 10) + coordinatesRookJ))) {
                    listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
                }
                break;
            }
            if (!Piece.IsThereACheck(field, PieceCoords, (byte) ((i * 10) + coordinatesRookJ))) {
                listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
            }
        }

        return listPossibleMoves;
    }
}
