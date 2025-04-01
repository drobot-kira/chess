package ua.kpi.chess;

import java.util.LinkedList;

public class Bishop extends Piece
{
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorBishop)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesBishopI = (byte)(PieceCoords/10);
        byte coordinatesBishopJ = (byte)(PieceCoords%10);

        byte coordinatesPossibleMoves = 0;
        for(byte i = (byte)(coordinatesBishopI + 1), j = (byte)(coordinatesBishopJ + 1); i <= 7 && j <= 7; i++, j++)
        {
            if(field[i][j]/10 == colorBishop)
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

        for(byte i = (byte)(coordinatesBishopI - 1), j = (byte)(coordinatesBishopJ - 1); i >= 0 && j >= 0; i--, j--)
        {
            if(field[i][j]/10 == colorBishop)
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

        for(byte i = (byte)(coordinatesBishopI + 1), j = (byte)(coordinatesBishopJ - 1); i <= 7 && j >= 0; i++, j--)
        {
            if(field[i][j]/10 == colorBishop)
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

        for(byte i = (byte)(coordinatesBishopI - 1), j = (byte)(coordinatesBishopJ + 1); i >= 0 && j <= 7; i--, j++)
        {
            if(field[i][j]/10 == colorBishop)
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
