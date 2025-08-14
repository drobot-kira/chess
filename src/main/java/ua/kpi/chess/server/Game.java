package ua.kpi.chess.server;

import ua.kpi.chess.databaseinteraction.DatabaseHandler;


public class Game {
    public byte[][] getField(int GameId) {
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 11, 11, 11, 11, 11, 11, 11},
                {14, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}};

        DatabaseHandler dbFieldString = new DatabaseHandler();
        String moves = dbFieldString.GetMoves(GameId);

        int index = 0;
        if (moves.charAt(index) == ' ') {
            index++;
        }
        while (index < moves.length()) {
            if (moves.charAt(index) == '*') {
                break;
            }
            byte iPrev = (byte) (8 - (byte) (moves.charAt(index + 1)) + '0');
            byte jPrev = (byte) ((byte) (moves.charAt(index)) - 97);
            byte iNext = (byte) (8 - (byte) (moves.charAt(index + 4)) + '0');
            byte jNext = (byte) ((byte) (moves.charAt(index + 3)) - 97);
            byte selectedPiece = (byte) (iPrev * 10 + jPrev);
            byte SquareId = (byte) (iNext * 10 + jNext);

            boolean willBeEnPassant = false;
            if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 1) // pawn is moving
            {
                if (field[8][0] == 1) {
                    if (SquareId == field[8][3]) {
                        field[SquareId / 10 + 1][SquareId % 10] = 30;
                    } else if (SquareId == selectedPiece - 20) {
                        field[8][3] = (byte) (selectedPiece - 10);
                        willBeEnPassant = true;
                    }
                } else if (field[8][0] == 2) {
                    if (SquareId == field[8][3]) {
                        field[SquareId / 10 - 1][SquareId % 10] = 30;
                    } else if (SquareId == selectedPiece + 20) {
                        field[8][3] = (byte) (selectedPiece + 10);
                        willBeEnPassant = true;
                    }
                }
            } else if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 4) // rook is moving
            {
                if (field[8][0] / 10 == 1) {
                    if (SquareId % 10 == 0 && field[8][1] >= 10) {
                        field[8][1] -= 10;
                    } else if (SquareId % 10 == 7 && field[8][1] % 10 >= 1) {
                        field[8][1] -= 1;
                    }
                } else {
                    if (SquareId % 10 == 0 && field[8][2] >= 10) {
                        field[8][2] -= 10;
                    } else if (SquareId % 10 == 7 && field[8][2] % 10 >= 1) {
                        field[8][2] -= 1;
                    }
                }
            } else if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 6) // king is moving
            {
                if (selectedPiece - 2 == SquareId) // long castle
                {
                    field[selectedPiece / 10][selectedPiece % 10 - 1] = field[selectedPiece / 10][0];
                    field[selectedPiece / 10][0] = 30;
                } else if (selectedPiece + 2 == SquareId) // short castle
                {
                    field[selectedPiece / 10][selectedPiece % 10 + 1] = field[selectedPiece / 10][7];
                    field[selectedPiece / 10][7] = 30;
                }

                if (field[8][0] == 1) {
                    field[8][1] = 0;
                } else if (field[8][0] == 2) {
                    field[8][2] = 0;
                }
            }
            field[iNext][jNext] = field[selectedPiece / 10][selectedPiece % 10];
            field[selectedPiece / 10][selectedPiece % 10] = 30;
            field[8][0] = field[8][0] == 1 ? (byte) 2 : (byte) 1;
            if (!willBeEnPassant) {
                field[8][3] = 0;
            }
            if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 1 ||
                    field[SquareId / 10][SquareId % 10] != 30) {
                field[8][4] = 0;
            } else {
                field[8][4] += 1;
            }
            if (field[8][0] == 2) {
                field[8][5] += 1;
            }

            if (field[8][0] == 2)
            {
                byte pawn = -1;

                for (byte i = 0; i < 8; i++) {
                    if (field[0][i] == 11)
                    {
                        pawn = i;
                        break;
                    }
                }

                if (pawn != -1)
                {
                    char type = moves.charAt(index + 5);
                    field[0][pawn] = switch (type)
                    {
                        case 'N' -> 12;
                        case 'B' -> 13;
                        case 'R' -> 14;
                        case 'Q' -> 15;
                        default -> field[0][pawn];
                    };
                    index++;
                }
            } else {
                byte pawn = -1;

                for (byte i = 0; i < 8; i++) {
                    if (field[7][i] == 21)
                    {
                        pawn = i;
                        break;
                    }
                }

                if (pawn != -1)
                {
                    char type = moves.charAt(index + 5);
                    field[7][pawn] = switch (type)
                    {
                        case 'N' -> 22;
                        case 'B' -> 23;
                        case 'R' -> 24;
                        case 'Q' -> 25;
                        default -> field[7][pawn];
                    };
                    index++;
                }
            }

            index += 6;
            if (moves.charAt(index - 1) == '*') {
                index--;
                break;
            }
        }
        if (moves.length() < 4) {
            return field;
        }
        index++;
        while (moves.charAt(index) != '*') {
            byte iCurrent = (byte) (8 - (byte) (moves.charAt(index + 1)) + '0');
            byte jCurrent = (byte) ((byte) (moves.charAt(index)) - 97);

            field[iCurrent][jCurrent] = (byte) (field[iCurrent][jCurrent] * -1);

            if (moves.charAt(index + 2) == '*' || moves.charAt(index + 1) == '*') {
                break;
            }
            index += 3;
        }

        index = Math.min(index + 3, moves.length() - 1);
        if (moves.charAt(index) != '*') {
            if (moves.charAt(index + 1) != '*') {
                byte iCurrent = (byte) ((moves.charAt(index)) - '0');
                byte jCurrent = (byte) (moves.charAt(index + 1) - '0');

                field[iCurrent][jCurrent] += 100;
            } else {
                byte iCurrent = 0;
                byte jCurrent = (byte) (moves.charAt(index) - '0');
                field[iCurrent][jCurrent] += 100;
            }
        }

        return field;
    }

    private String getWhiteId(int GameId) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String whiteName = dbHandler.GetWhiteId(GameId);
        return whiteName;
    }

    public void WriteMove(int GameId, byte PieceCoords, byte SquareCoords) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        String oldMoves = databaseHandler.GetMoves(GameId);
        String newMoves = "";

        int index = 0;
        boolean movesIsWritten = false;
        while (index < oldMoves.length()) {
            if (oldMoves.charAt(index) == '*' && !movesIsWritten) {
                movesIsWritten = true;
                byte iCoords = (byte) (8 - PieceCoords / 10);
                char jCoords = (char) (PieceCoords % 10 + 97);
                byte iNewCoords = (byte) (8 - SquareCoords / 10);
                char jNewCoords = (char) (SquareCoords % 10 + 97);
                newMoves += " " + jCoords + iCoords + "-" + jNewCoords + iNewCoords + "*";
            }
            newMoves += oldMoves.charAt(index);
            index++;
        }
        databaseHandler.WriteMoves(GameId, newMoves);
    }

    public void WriteMarks(int GameId, byte[][] field) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        String oldMoves = databaseHandler.GetMoves(GameId);
        String newMoves = "";
        int index = 0;
        while (index < oldMoves.length()) {
            if (oldMoves.charAt(index) == '*') {
                newMoves += "*";
                break;
            }
            newMoves += oldMoves.charAt(index);
            index++;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] < 0) {
                    byte iCoords = (byte) (8 - i);
                    char jCoords = (char) (j % 10 + 97);
                    if (newMoves.charAt(newMoves.length() - 1) == '*') {
                        newMoves += jCoords;
                        newMoves += iCoords;
                    } else {
                        newMoves += " " + jCoords + iCoords;
                    }
                }
            }
        }
        newMoves += "*";
        byte selected = Board.IsThereAMarkedPiece(field);
        if (selected != -1) {
            newMoves += selected;
        }
        newMoves += "*";
        databaseHandler.WriteMoves(GameId, newMoves);
    }

    public byte[][] SquareClicked(int GameId, byte SquareId, String UserId) {
        byte[][] field = getField(GameId);
        String WhiteId = getWhiteId(GameId);

        byte i = (byte) (SquareId / 10);
        byte j = (byte) (SquareId % 10);

        if (field[8][0] == 1 && !UserId.equals(WhiteId) || field[8][0] == 2 && UserId.equals(WhiteId)) {
            return field;
        }

        if ((field[SquareId / 10][SquareId % 10] / 10 % 10 == 1 && WhiteId.equals(UserId)) ||
                (field[SquareId / 10][SquareId % 10] / 10 % 10 == 2 && !WhiteId.equals(UserId))) // user's piece
        {
            field = Board.AddMarks(Board.RemoveMarks(field), SquareId);
        } else // not user's piece
        {
            byte selectedPiece = Board.IsThereAMarkedPiece(field);
            if (selectedPiece != -1) // there is a selected piece
            {
                if (field[SquareId / 10][SquareId % 10] < 0) // the move is possible
                {
                    if (Board.IsThereAMarkedPiece(field) != -1) {
                        WriteMove(GameId, Board.IsThereAMarkedPiece(field), SquareId);
                    }
                    field = Board.RemoveMarks(field);
                    boolean willBeEnPassant = false;
                    boolean willBePromotion = false;
                    if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 1) // pawn is moving
                    {
                        if (field[8][0] == 1) {
                            if (SquareId == field[8][3]) {
                                field[SquareId / 10 + 1][SquareId % 10] = 30;
                            } else if (SquareId == selectedPiece - 20) {
                                field[8][3] = (byte) (selectedPiece - 10);
                                willBeEnPassant = true;
                            } else if (SquareId / 10 == 0) {
                                field[8][6] = selectedPiece;
                                field[8][7] = field[SquareId / 10][SquareId % 10];
                                willBePromotion = true;
                            }
                        } else if (field[8][0] == 2) {
                            if (SquareId == field[8][3]) {
                                field[SquareId / 10 - 1][SquareId % 10] = 30;
                            } else if (SquareId == selectedPiece + 20) {
                                field[8][3] = (byte) (selectedPiece + 10);
                                willBeEnPassant = true;
                            } else if (SquareId / 10 == 7) {
                                field[8][6] = selectedPiece;
                                field[8][7] = field[SquareId / 10][SquareId % 10];
                                willBePromotion = true;
                            }
                        }
                    } else if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 4) // rook is moving
                    {
                        if (field[8][0] / 10 == 1) {
                            if (SquareId % 10 == 0 && field[8][1] >= 10) {
                                field[8][1] -= 10;
                            } else if (SquareId % 10 == 7 && field[8][1] % 10 >= 1) {
                                field[8][1] -= 1;
                            }
                        } else {
                            if (SquareId % 10 == 0 && field[8][2] >= 10) {
                                field[8][2] -= 10;
                            } else if (SquareId % 10 == 7 && field[8][2] % 10 >= 1) {
                                field[8][2] -= 1;
                            }
                        }
                    } else if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 6) // king is moving
                    {
                        if (selectedPiece - 2 == SquareId) // long castle
                        {
                            field[selectedPiece / 10][selectedPiece % 10 - 1] = field[selectedPiece / 10][0];
                            field[selectedPiece / 10][0] = 30;
                        } else if (selectedPiece + 2 == SquareId) // short castle
                        {
                            field[selectedPiece / 10][selectedPiece % 10 + 1] = field[selectedPiece / 10][7];
                            field[selectedPiece / 10][7] = 30;
                        }

                        if (field[8][0] == 1) {
                            field[8][1] = 0;
                        } else if (field[8][0] == 2) {
                            field[8][2] = 0;
                        }
                    }
                    field[i][j] = field[selectedPiece / 10][selectedPiece % 10];
                    field[selectedPiece / 10][selectedPiece % 10] = 30;
                    if (!willBeEnPassant) {
                        field[8][3] = 0;
                    }
                    if (!willBePromotion) {
                        field[8][6] = 0;
                        field[8][7] = 0;
                        field[8][0] = field[8][0] == 1 ? (byte) 2 : (byte) 1;
                        if (field[selectedPiece / 10][selectedPiece % 10] % 10 == 1 ||
                                field[SquareId / 10][SquareId % 10] != 30) {
                            field[8][4] = 0;
                        } else {
                            field[8][4] += 1;
                        }
                        if (field[8][0] == 2) {
                            field[8][5] += 1;
                        }

                        byte[][] fieldCopy = new byte[9][8];

                        for (byte a = 0; a < 9; a++) {
                            for (byte b = 0; b < 8; b++) {
                                fieldCopy[a][b] = field[a][b];
                            }
                        }

                        byte theEnd = Position.IsGameEnded(fieldCopy, GameId);
                        if (theEnd != 0)
                        {
                            DatabaseHandler databaseHandler = new DatabaseHandler();
                            databaseHandler.EndGame(GameId, theEnd);
                        }
                    }
                } else // the move is not possible
                {
                    field = Board.RemoveMarks(field);
                }
            } else // there is not a selected piece
            {
                field = Board.RemoveMarks(field);
            }
        }

        byte PieceCoords = Board.IsThereAMarkedPiece(field);
        if (PieceCoords == -1) {
            PieceCoords = SquareId;
        }

        WriteMarks(GameId, field);
        return field;
    }

    public byte[][] PawnPromotion(int gameId, byte squareId, String color, String pieceType) {
        byte[][] field = getField(gameId);
        byte piece = switch (pieceType) {
            case "queen" -> 5;
            case "knight" -> 2;
            case "bishop" -> 3;
            case "rook" -> 4;
            default -> 0;
        };

        if (color.equals("white")) {
            piece += 10;
            field[8][0] = 2;
            field[0][squareId % 10] = piece;
        }
        else if (color.equals("black")) {
            piece += 20;
            field[8][0] = 1;
            field[8][5] += 1;
            field[7][squareId % 10] = piece;
        }

        field[8][3] = 0;
        field[8][4] += 1;
        field[8][6] = 0;
        field[8][7] = 0;

        byte[][] fieldCopy = new byte[9][8];

        for (byte a = 0; a < 9; a++) {
            for (byte b = 0; b < 8; b++) {
                fieldCopy[a][b] = field[a][b];
            }
        }

        byte theEnd = Position.IsGameEnded(fieldCopy, gameId);
        if (theEnd != 0)
        {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            databaseHandler.EndGame(gameId, theEnd);
        }

        DatabaseHandler databaseHandler = new DatabaseHandler();
        String oldMoves = databaseHandler.GetMoves(gameId);
        String newMoves = "";

        boolean promotionIsWritten = false;
        for (int i = 0; i < oldMoves.length(); i++) {
            if (oldMoves.charAt(i) == '*' && !promotionIsWritten) {
                promotionIsWritten = true;
                if (pieceType.equals("knight"))
                {
                    newMoves += "N";
                } else if (pieceType.equals("bishop"))
                {
                    newMoves += "B";
                } else if (pieceType.equals("rook"))
                {
                    newMoves += "R";
                } else if (pieceType.equals("queen"))
                {
                    newMoves += "Q";
                }
            }
            newMoves += oldMoves.charAt(i);
        }

        databaseHandler.WriteMoves(gameId, newMoves);
        return field;
    }

    public byte[][] PawnPromotionCancellation(int gameId)
    {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        String oldMoves = databaseHandler.GetMoves(gameId);
        String newMoves = "";

        for (int i = 0; i < oldMoves.length() - 9; i++) {
            newMoves += oldMoves.charAt(i);
        }

        newMoves += "***";

        databaseHandler.WriteMoves(gameId, newMoves);

        byte[][] field = getField(gameId);

        return field;
    }
}