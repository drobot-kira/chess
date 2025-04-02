package ua.kpi.chess.server;

import java.util.LinkedList;

public class King extends Piece {
    private boolean IsCastle(byte[][] field, byte whereIsCastleJ, byte colorKing) {
        byte i = 7;
        if (colorKing == 2) {
            i = 0;
        }

        byte j = (byte) (4 + whereIsCastleJ);
        while (j >= 2 && j <= 6) {

            if (field[i][j] != 30) {
                return false;
            }

            field[i][j] = field[i][4];
            field[i][4] = 30;

            if (Position.IsThereACheck(field)) {
                return false;

            }

            field[i][4] = field[i][j];
            field[i][j] = 30;

            j += whereIsCastleJ;
        }

        return true;
    }

    public LinkedList<Byte> FindPossibleMovesItem(byte[][] startField, byte PieceCoords, byte colorKing) {
        byte[][] field = startField.clone();
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesKingI = (byte) (PieceCoords / 10);
        byte coordinatesKingJ = (byte) (PieceCoords % 10);

        byte[][] Delta = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (byte[] delta : Delta) {
            if (coordinatesKingI + delta[0] >= 0 && coordinatesKingJ + delta[1] >= 0 &&
                    coordinatesKingI + delta[0] < 8 && coordinatesKingJ + delta[1] < 8 &&
                    field[coordinatesKingI + delta[0]][coordinatesKingJ + delta[1]] / 10 % 10 != colorKing) {
                if (!Piece.IsThereACheck(field, PieceCoords,
                        (byte) ((coordinatesKingI + delta[0]) * 10 + coordinatesKingJ + delta[1]))) {
                    listPossibleMoves.add((byte) ((coordinatesKingI + delta[0]) * 10 + coordinatesKingJ + delta[1]));
                }
            }
        }

        if (field[8][colorKing] % 10 == 1) {
            if (IsCastle(field, (byte) 1, colorKing)) {
                listPossibleMoves.add(colorKing == 1 ? (byte) 76 : (byte) 6);
            }
        }
        if (field[8][colorKing] >= 10) {
            if (IsCastle(field, (byte) -1, colorKing)) {
                listPossibleMoves.add(colorKing == 1 ? (byte) 72 : (byte) 2);
            }
        }


        return listPossibleMoves;
    }
}
