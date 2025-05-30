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
            { 1, 11, 11,  0,  0,  0,  0,  0}};

        DatabaseHandler dbFieldString = new DatabaseHandler();
        String fieldString = dbFieldString.GetMoves(GameId);

        if(fieldString.length() < 4){
            return field;
        }
        int index = 0;
        while(fieldString.charAt(index) != '*'){
            byte iPrev = (byte)(8 - (byte)(fieldString.charAt(index + 1)) + '0');
            byte jPrev = (byte)((byte)(fieldString.charAt(index)) - 97);
            byte iNext = (byte)(8 - (byte)(fieldString.charAt(index + 4)) + '0');
            byte jNext = (byte)((byte)(fieldString.charAt(index + 3)) - 97);

            field[iNext][jNext] = field[iPrev][jPrev];
            field[iPrev][jPrev] = 30;

            index += 6;
        }

        index++;
        while(fieldString.charAt(index) != '*'){
            byte iCurrent = (byte)(8 - (byte)(fieldString.charAt(index + 1)) + '0');
            byte jCurrent = (byte)((byte)(fieldString.charAt(index)) - 97);

            field[iCurrent][jCurrent] = (byte)(field[iCurrent][jCurrent] * -1);

            index += 3;
        }

        index++;
        if(fieldString.charAt(index) != '*'){
            byte iCurrent = (byte)(8 - (byte)(fieldString.charAt(index + 1)) + '0');
            byte jCurrent = (byte)((byte)(fieldString.charAt(index)) - 97);

            field[iCurrent][jCurrent] += 100;
        }

        return field;
    }

    private String getWhiteId(int GameId) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String whiteName = dbHandler.GetWhiteId(GameId);
        return whiteName;
    }
    public void writeMove(int GameId, byte[][] field, byte PieceCoords, byte SquareCoords ) {
        DatabaseHandler dbFieldString = new DatabaseHandler();
        String fieldString = dbFieldString.GetMoves(GameId);
        String newFieldString = "";

        for(int i = 0; i < fieldString.length(); i++){
            if(fieldString.charAt(i) == '*'){
                newFieldString = " ";
                break;
            }
            newFieldString += fieldString.charAt(i);
        }

        byte iCoords = (byte)(8 - PieceCoords/10);
        char jCoords = (char)(PieceCoords%10 + 97);
        byte iNewCoords = (byte)(8 - SquareCoords/10);
        char jNewCoords = (char)(SquareCoords%10 + 97);

        if(PieceCoords != SquareCoords){
            newFieldString += jCoords;
            newFieldString += iCoords;
            newFieldString += "-";
            newFieldString += iNewCoords;
            newFieldString += jNewCoords;
        }

        newFieldString += " *";

        String byf = "";
        for(byte i = 0; i < field.length; i++){
            for(byte j = 0; j < field[i].length; j++){
                if(field[i][j] < 0){
                    iCoords = (byte)(8 - i);
                    jCoords = (char)(j + 97);
                    newFieldString += jCoords;
                    newFieldString += iCoords + " ";
                }
                else if(field[i][j] > 100){
                    iCoords = (byte)(8 - i);
                    jCoords = (char)(j + 97);
                    byf += jCoords;
                    byf += iCoords;
                }
            }
        }

        newFieldString += "*" + byf + "*";

        DatabaseHandler dbUpdateFieldString = new DatabaseHandler();
        dbUpdateFieldString.WriteMoves(GameId, newFieldString);
    }

    public byte[][] SquareClicked(int GameId, byte SquareId, String UserId) {
        byte[][] field = getField(GameId);
        String WhiteId = getWhiteId(GameId);

        byte i = (byte) (SquareId / 10);
        byte j = (byte) (SquareId % 10);

        if ((field[SquareId / 10][SquareId % 10] / 10 % 10 == 1 && WhiteId == UserId) ||
                (field[SquareId / 10][SquareId % 10] / 10 % 10 == 2 && WhiteId != UserId)) // user's piece
        {
            field = Board.AddMarks(Board.RemoveMarks(field), SquareId);
        } else // not user's piece
        {
            byte selectedPiece = Board.IsThereAMarkedPiece(field);
            if (selectedPiece != -1) // there is a selected piece
            {
                if (field[SquareId / 10][SquareId % 10] < 0) // the move is possible
                {
                    field = Board.RemoveMarks(field);
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
                    field[i][j] = field[selectedPiece / 10][selectedPiece % 10];
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

                    byte[][] fieldCopy = new byte[9][8];

                    for (byte a = 0; a < 9; a++) {
                        for (byte b = 0; b < 8; b++) {
                            fieldCopy[a][b] = field[a][b];
                        }
                    }

                    byte theEnd = Position.IsGameEnded(fieldCopy);
                    if (theEnd != 0) // the server is ended
                    {
                        byte value = 0;
                        if (Math.abs(theEnd) == 1 || Math.abs(theEnd) == 4) {
                            if (theEnd > 0 && field[8][0] == 1 || theEnd < 0 && field[8][0] == 2) {
                                value = 1;
                            } else {
                                value = -1;
                            }
                        }
                        for (byte a = 0; a < 9; a++) {
                            for (byte b = 0; b < 8; b++) {
                                field[a][b] = 0;
                            }
                        }
                        field[0][0] = theEnd;
                        field[0][1] = value;
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
        if(PieceCoords == -1)
        {
            PieceCoords = SquareId;
        }
        writeMove(GameId, field, PieceCoords, SquareId);

        return field;
    }
}