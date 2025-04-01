package ua.kpi.chess;

import java.util.LinkedList;

public class Rook extends Piece
{
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorRook)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesRookI = (byte)(PieceCoords/10);
        byte coordinatesRookJ = (byte)(PieceCoords%10);

        byte coordinatesPossibleMoves = 0;
        for(byte j = (byte)(coordinatesRookJ + 1); j <= 7; j++)
        {
            if(field[coordinatesRookI][j]/10 == colorRook)
            {
                break;
            }
            else if(field[coordinatesRookI][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((coordinatesRookI*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((coordinatesRookI*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte j = (byte)(coordinatesRookJ - 1); j >= 0; j--)
        {
            if(field[coordinatesRookI][j]/10 == colorRook)
            {
                break;
            }
            else if(field[coordinatesRookI][j] != 30)
            {
                coordinatesPossibleMoves = (byte)((coordinatesRookI*10) + j);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((coordinatesRookI*10) + j);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesRookI + 1); i <= 7; i++)
        {
            if (field[i][coordinatesRookJ] / 10 == colorRook)
            {
                break;
            }
            else if (field[i][coordinatesRookJ] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + coordinatesRookJ);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + coordinatesRookJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        for(byte i = (byte)(coordinatesRookI - 1); i >= 0; i--)
        {
            if (field[i][coordinatesRookJ] / 10 == colorRook)
            {
                break;
            }
            else if (field[i][coordinatesRookJ] != 30)
            {
                coordinatesPossibleMoves = (byte)((i*10) + coordinatesRookJ);
                listPossibleMoves.add(coordinatesPossibleMoves);
                break;
            }
            coordinatesPossibleMoves = (byte)((i*10) + coordinatesRookJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        return listPossibleMoves;
    }
}
