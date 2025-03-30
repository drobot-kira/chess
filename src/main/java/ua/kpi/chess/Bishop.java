package ua.kpi.chess;

import java.util.ArrayList;
import java.util.List;

public class  Bishop extends Piece
{
    public boolean IsMovePossible(byte[][] field, byte SquareCoords, byte PieceCoords)
    {
        byte coordinatesBishopI = (byte)(PieceCoords/10);
        byte coordinatesBishopJ = (byte)(PieceCoords%10);
        byte coordinatesBishopMoveI = (byte)(SquareCoords/10);
        byte coordinatesBishopMoveJ = (byte)(SquareCoords%10);
        byte colorBishop = (byte)(field[coordinatesBishopI][coordinatesBishopJ]/10);
        colorBishop = (byte)(colorBishop%10);

        if(coordinatesBishopI - coordinatesBishopJ != coordinatesBishopMoveI - coordinatesBishopMoveJ)
        {
            if(coordinatesBishopI + coordinatesBishopJ != coordinatesBishopMoveI + coordinatesBishopMoveJ)
            {
                return false;
            }
        }

        if(coordinatesBishopI < coordinatesBishopMoveI && coordinatesBishopJ < coordinatesBishopMoveJ) //рухаємося правий нижній кут
        {
            for(int i = coordinatesBishopI + 1, j = coordinatesBishopJ + 1; i <= coordinatesBishopMoveI && j <=coordinatesBishopMoveJ; i++, j++)
            {
                if(field[i][j]/10 == colorBishop)
                {
                    return false;
                }
                else if(i == coordinatesBishopMoveI && j == coordinatesBishopMoveJ)
                {
                    return true;
                }
                else if(field[i][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesBishopI > coordinatesBishopMoveI && coordinatesBishopJ > coordinatesBishopMoveJ) //рухаємося лівий верхній кут
        {
            for(int i = coordinatesBishopI - 1, j = coordinatesBishopJ - 1; i >= coordinatesBishopMoveI && j >= coordinatesBishopMoveJ; i--, j--)
            {
                if(field[i][j]/10 == colorBishop)
                {
                    return false;
                }
                else if(i == coordinatesBishopMoveI && j == coordinatesBishopMoveJ)
                {
                    return true;
                }
                else if(field[i][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesBishopI < coordinatesBishopMoveI && coordinatesBishopJ > coordinatesBishopMoveJ) //рухаємося лівий нижній кут
        {
            for(int i = coordinatesBishopI + 1, j = coordinatesBishopJ - 1; i <= coordinatesBishopMoveI && j >= coordinatesBishopMoveJ; i++, j--)
            {
                if(field[i][j]/10 == colorBishop)
                {
                    return false;
                }
                else if(i == coordinatesBishopMoveI && j == coordinatesBishopMoveJ)
                {
                    return true;
                }
                else if(field[i][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesBishopI > coordinatesBishopMoveI && coordinatesBishopJ < coordinatesBishopMoveJ) //рухаємося правий верхній кут
        {
            for(int i = coordinatesBishopI - 1, j = coordinatesBishopJ + 1; i >= coordinatesBishopMoveI && j <= coordinatesBishopMoveJ; i--, j++)
            {
                if(field[i][j]/10 == colorBishop)
                {
                    return false;
                }
                else if(i == coordinatesBishopMoveI && j == coordinatesBishopMoveJ)
                {
                    return true;
                }
                else if(field[i][j] != 30)
                {
                    return false;
                }
            }
        }

        return false;
    }
    public List<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords)
    {
        List<Byte> listPossibleMoves = new ArrayList<>();

        var position = new Position();
        if(position.IsThereACheck(field))
        {
            return listPossibleMoves;
        }

        byte coordinatesBishopI = (byte)(PieceCoords/10);
        byte coordinatesBishopJ = (byte)(PieceCoords%10);
        byte coordinatesBishopMoveI = (byte)7;
        byte coordinatesBishopMoveJ = (byte)7;
        byte colorBishop = (byte)(field[coordinatesBishopI][coordinatesBishopJ]/10);
        colorBishop = (byte)(colorBishop%10);

        byte coordinatesPossibleMoves = 0;
        for(int i = coordinatesBishopI + 1, j = coordinatesBishopJ + 1; i <= coordinatesBishopMoveI && j <=coordinatesBishopMoveJ; i++, j++) //рухаємося правий нижній кут
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

        coordinatesBishopMoveI = 0;
        coordinatesBishopMoveJ = 0;
        for(int i = coordinatesBishopI - 1, j = coordinatesBishopJ - 1; i >= coordinatesBishopMoveI && j >= coordinatesBishopMoveJ; i--, j--) //рухаємося лівий верхній кут
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

        coordinatesBishopMoveI = 7;
        coordinatesBishopMoveJ = 0;
        for(int i = coordinatesBishopI + 1, j = coordinatesBishopJ - 1; i <= coordinatesBishopMoveI && j >= coordinatesBishopMoveJ; i++, j--) //рухаємося лівий нижній кут
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

        coordinatesBishopMoveI = 0;
        coordinatesBishopMoveJ = 7;
        for(int i = coordinatesBishopI - 1, j = coordinatesBishopJ + 1; i >= coordinatesBishopMoveI && j <= coordinatesBishopMoveJ; i--, j++) //рухаємося правий верхній кут
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

