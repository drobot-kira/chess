package ua.kpi.chess;

import java.util.LinkedList;

public class Rook extends Piece {
    public LinkedList<Byte> FindPossibleMovesItem(byte[][] field, byte PieceCoords, byte colorRook, boolean check) {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesRookI = (byte) (PieceCoords / 10);
        byte coordinatesRookJ = (byte) (PieceCoords % 10);

        for (byte j = (byte) (coordinatesRookJ + 1); j <= 7; j++) {
            if (field[coordinatesRookI][j] / 10 % 10 == colorRook) {
                break;
            } else if (field[coordinatesRookI][j] != 30) {
                if (!check || !Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
                }
                break;
            }
            if (!check || !Position.IsThereACheck(field)) {
                listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
            }
        }

        for (byte j = (byte) (coordinatesRookJ - 1); j >= 0; j--) {
            if (field[coordinatesRookI][j] / 10 % 10 == colorRook) {
                break;
            } else if (field[coordinatesRookI][j] != 30) {
                if (!check || !Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
                }
                break;
            }
            if (!check || !Position.IsThereACheck(field)) {
                listPossibleMoves.add((byte) ((coordinatesRookI * 10) + j));
            }
        }

        for (byte i = (byte) (coordinatesRookI + 1); i <= 7; i++) {
            if (field[i][coordinatesRookJ] / 10 % 10 == colorRook) {
                break;
            } else if (field[i][coordinatesRookJ] != 30) {
                if (!check || !Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
                }
                break;
            }
            if (!check || !Position.IsThereACheck(field)) {
                listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
            }
        }

        for (byte i = (byte) (coordinatesRookI - 1); i >= 0; i--) {
            if (field[i][coordinatesRookJ] / 10 % 10 == colorRook) {
                break;
            } else if (field[i][coordinatesRookJ] != 30) {
                if (!check || !Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
                }
                break;
            }
            if (!check || !Position.IsThereACheck(field)) {
                listPossibleMoves.add((byte) ((i * 10) + coordinatesRookJ));
            }
        }

        return listPossibleMoves;
    }
}
