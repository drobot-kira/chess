package ua.kpi.chess;

import java.util.LinkedList;

public class Queen extends Piece
{
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorQueen)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesQueenI = (byte)(PieceCoords/10);
        byte coordinatesQueenJ = (byte)(PieceCoords%10);

        byte coordinatesPossibleMoves = 0;
        for(byte j = (byte)(coordinatesQueenJ + 1); j <= 7; j++)
        {
            if(field[coordinatesQueenI][j]/10 == colorQueen)
            {
                break;
            }
            else if(field[coordinatesQueenI][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((coordinatesQueenI*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((coordinatesQueenI*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte j = (byte)(coordinatesQueenJ - 1); j >= 0; j--)
        {
            if(field[coordinatesQueenI][j]/10 == colorQueen)
            {
                break;
            }
            else if(field[coordinatesQueenI][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((coordinatesQueenI*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((coordinatesQueenI*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesQueenI + 1); i <= 7; i++)
        {
            if (field[i][coordinatesQueenJ] / 10 == colorQueen)
            {
                break;
            }
            else if (field[i][coordinatesQueenJ] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + coordinatesQueenJ);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + coordinatesQueenJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesQueenI - 1); i >= 0; i--)
        {
            if (field[i][coordinatesQueenJ] / 10 == colorQueen)
            {
                break;
            }
            else if (field[i][coordinatesQueenJ] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + coordinatesQueenJ);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + coordinatesQueenJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesQueenI + 1), j = (byte)(coordinatesQueenJ + 1); i <= 7 && j <= 7; i++, j++)
        {
            if(field[i][j]/10 == colorQueen)
            {
                break;
            }
            else if(field[i][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesQueenI - 1), j = (byte)(coordinatesQueenJ - 1); i >= 0 && j >= 0; i--, j--)
        {
            if(field[i][j]/10 == colorQueen)
            {
                break;
            }
            else if(field[i][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesQueenI + 1), j = (byte)(coordinatesQueenJ - 1); i <= 7 && j >= 0; i++, j--)
        {
            if(field[i][j]/10 == colorQueen)
            {
                break;
            }
            else if(field[i][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesQueenI - 1), j = (byte)(coordinatesQueenJ + 1); i >= 0 && j <= 7; i--, j++)
        {
            if(field[i][j]/10 == colorQueen)
            {
                break;
            }
            else if(field[i][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        return listPossibleMoves;
    }
}
