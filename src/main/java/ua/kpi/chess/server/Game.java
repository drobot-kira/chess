package ua.kpi.chess.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Game {
    private byte[][] getField(int GameId) {
        File file = new File("src/main/java/ua/kpi/chess/server/field.txt");

        List<byte[]> matrixList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/main/java/ua/kpi/chess/server/field.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+"); // Розбиваємо по пробілах
                byte[] row = new byte[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    row[i] = Byte.parseByte(numbers[i]); // Конвертуємо у byte
                }
                matrixList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrixList.toArray(new byte[0][]);
    }

    private int getWhiteId(int GameId) {
        return 1;
    }

    private void writeTheEnd() {
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
        writeMove(1, field);
    }

    private void writeMove(int GameId, byte[][] field) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter
                ("src/main/java/ua/kpi/chess/server/field.txt"))) {
            for (byte[] row : field) {
                for (byte num : row) {
                    writer.write(num + " ");
                }
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[][] SquareClicked(int GameId, byte SquareId, int UserId) {
        byte[][] field = getField(GameId);
        UserId = field[8][0];
        int WhiteId = getWhiteId(GameId);

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
                        // ****врахувати перетворення
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

                    for (byte a = 0; a < 9; a++)
                    {
                        for (byte b = 0; b < 8; b++)
                        {
                            fieldCopy[a][b] = field[a][b];
                        }
                    }

                    byte theEnd = Position.IsGameEnded(fieldCopy);
                    if (theEnd != 0) // the game is ended
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
                        writeTheEnd();
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

        writeMove(GameId, field);

        return field;
    }
}