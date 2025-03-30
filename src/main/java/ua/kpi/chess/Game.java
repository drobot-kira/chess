package ua.kpi.chess;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import javax.swing.*;

public class Game
{
    private byte[][] GetField(int GameId) //Дістати поле з БД за GameId
    {
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 11, 11, 11, 11, 11, 11, 11},
                {14, 12, 13, 16, 15, 13, 12, 14},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };
        return field;

    }

    /*private void GameEnded(byte end)
    {

    }*/

    public byte[][] SquareClicked(int GameId, int SquareId, int UserId) {
        byte[][] field = GetField(GameId); //Дістати поле з БД за GameId
        int UserIdWhite = 105;   //Дістати з БД UserIdWhite
        Board board = new Board();
        int i = SquareId / 10;
        int j = SquareId % 10;
        field[i][j] = (byte) (field[i][j] + 100);
        String temp = Integer.toString(SquareId);
        byte squareId = Byte.parseByte(temp);
        if (UserId == UserIdWhite && field[i][j]/10 == 1){
            board.RemoveMarks(field);
            board.AddMarks(field, squareId);
        }
        else{
            Piece piece = new Piece();
            if (board.IsThereAMarkedPiece(field) != -1){
                if (piece.IsMovePossible(field, squareId)){
                    int k = board.IsThereAMarkedPiece(field)/10;
                    int l = board.IsThereAMarkedPiece(field)%10;
                    if(field[i][j]%10 == 1 || field[k][l]%10 == 1){
                        field[8][4] = 0;
                    }
                    else{
                        field[8][4]++;
                    }
                    int index;
                    if(UserId == UserIdWhite){
                        index = 1;
                    }
                    else{
                        index = 2;
                    }
                    if(board.IsThereAMarkedPiece(field) == 70){
                        field[8][index] = 1;
                    }
                    else if(board.IsThereAMarkedPiece(field) == 77){
                        field[8][index] = 10;
                    }
                    else if(board.IsThereAMarkedPiece(field) == 74){
                        field[8][index] = 0;
                    }
                    if(field[i][j]%10 == 1){
                        if(j - 1 < 0){
                            if(field[i][j+1]%10==1 && field[i][j+1]/10!=field[i][j]/10){
                                field[8][3] = (byte)(i*10+(j+1));
                            }
                        }
                        else if(j + 1 > 7){
                            if(field[i][j-1]%10==1 && field[i][j-1]/10!=field[i][j]/10){
                                field[8][3] = (byte)(i*10+(j-1));
                            }
                        }
                        else{
                            if(field[i][j-1]%10==1 && field[i][j-1]/10!=field[i][j]/10){
                                field[8][3] = (byte)(i*10+(j+1));
                            }
                            else if(field[i][j+1]%10==1 && field[i][j+1]/10!=field[i][j]/10){
                                field[8][3] = (byte)(i*10+(j+1));
                            }
                        }
                    }
                    byte buff = field[k][l];
                    field[k][l] = 30;
                    field[i][j] = buff;
                    field[i][j] = (byte)(buff - 100);
                    board.RemoveMarks(field);
                    if(UserId == UserIdWhite){
                        field[8][0] = 2;
                    }
                    else{
                        field[8][0] = 1;
                        field[8][5]++;
                    }
                    Position position = new Position();
                    if(position.IsGameEnded(field) != 0){
                        for(int x = 0; x < 9; x++){
                            for (int y = 0; y < 8; y++){
                                field[x][y] = 0;
                            }
                        }
                        field[0][0] = position.IsGameEnded(field);
                        if(UserId == UserIdWhite){
                            if (position.IsGameEnded(field) > 0){
                                field[0][1] = 1;
                            }
                            else{
                                field[0][1] = -1;
                            }
                        }
                        else {
                            if (position.IsGameEnded(field) > 0) {
                                field[0][1] = -1;
                            } else {
                                field[0][1] = 1;
                            }
                        }
                        try{
                            FileWriter myWriter = new FileWriter("src\\main\\java\\ua\\kpi\\chess\\field.txt");
                            for(i = 0; i < 9; i++){
                                for(j = 0; j < 8; j++){
                                    myWriter.write(field[i][j] + " ");
                                }
                                myWriter.write("\n");
                            }
                            myWriter.write("UserIdWhite\n");
                            myWriter.write("UserIdBlack");
                            myWriter.close();
                        }
                        catch(IOException e){
                            System.out.println("Error");
                        }
                    }
                }
                else{
                    board.RemoveMarks(field);
                }
            }
        }
        return field;
    }
}