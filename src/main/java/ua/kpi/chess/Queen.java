<<<<<<< Updated upstream
﻿package ua.kpi.chess;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece
{
    public boolean IsMovePossible(byte[][] field, byte SquareCoords, byte PieceCoords)
    {
        byte coordinatesQueenI = (byte)(PieceCoords/10);
        byte coordinatesQueenJ = (byte)(PieceCoords%10);
        byte coordinatesQueenMoveI = (byte)(SquareCoords/10);
        byte coordinatesQueenMoveJ = (byte)(SquareCoords%10);
        byte colorQueen = (byte)(field[coordinatesQueenI][coordinatesQueenJ]/10);
        colorQueen = (byte)(colorQueen%10);

        if(coordinatesQueenI != coordinatesQueenMoveI)
        {
            if(coordinatesQueenJ != coordinatesQueenMoveJ)
            {
                if(coordinatesQueenI - coordinatesQueenJ != coordinatesQueenMoveI - coordinatesQueenMoveJ)
                {
                    if(coordinatesQueenI + coordinatesQueenJ != coordinatesQueenMoveI + coordinatesQueenMoveJ)
                    {
                        return false;
                    }
                }
            }
        }

        if(coordinatesQueenI == coordinatesQueenMoveI && coordinatesQueenJ < coordinatesQueenMoveJ) //рухаємося праворуч
        {
            for(int j = coordinatesQueenJ + 1; j <= coordinatesQueenMoveJ; j++)
            {
                if(field[coordinatesQueenI][j]/10 == colorQueen)
                {
                    return false;
                }
                else if(j == coordinatesQueenMoveJ)
                {
                    return true;
                }
                else if(field[coordinatesQueenI][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesQueenI == coordinatesQueenMoveI && coordinatesQueenJ > coordinatesQueenMoveJ) //рухаємося ліворуч
        {
            for(int j = coordinatesQueenJ - 1; j >= coordinatesQueenMoveJ; j--)
            {
                if(field[coordinatesQueenI][j]/10 == colorQueen)
                {
                    return false;
                }
                else if(j == coordinatesQueenMoveJ)
                {
                    return true;
                }
                else if(field[coordinatesQueenI][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesQueenI < coordinatesQueenMoveI && coordinatesQueenJ == coordinatesQueenMoveJ) //рухаємося вниз
        {
            for(int i = coordinatesQueenI + 1; i <= coordinatesQueenMoveI; i++)
            {
                if (field[i][coordinatesQueenJ] / 10 == colorQueen)
                {
                    return false;
                }
                else if (i == coordinatesQueenMoveI)
                {
                    return true;
                }
                else if (field[i][coordinatesQueenJ] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesQueenI > coordinatesQueenMoveI && coordinatesQueenJ == coordinatesQueenMoveJ) //рухаємося вгору
        {
            for(int i = coordinatesQueenI - 1; i >= coordinatesQueenMoveI; i--)
            {
                if (field[i][coordinatesQueenJ] / 10 == colorQueen)
                {
                    return false;
                }
                else if (i == coordinatesQueenMoveI)
                {
                    return true;
                }
                else if (field[i][coordinatesQueenJ] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesQueenI < coordinatesQueenMoveI && coordinatesQueenJ < coordinatesQueenMoveJ) //рухаємося правий нижній кут
        {
            for(int i = coordinatesQueenI + 1, j = coordinatesQueenJ + 1; i <= coordinatesQueenMoveI && j <=coordinatesQueenMoveJ; i++, j++)
            {
                if(field[i][j]/10 == colorQueen)
                {
                    return false;
                }
                else if(i == coordinatesQueenMoveI && j == coordinatesQueenMoveJ)
                {
                    return true;
                }
                else if(field[i][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesQueenI > coordinatesQueenMoveI && coordinatesQueenJ > coordinatesQueenMoveJ) //рухаємося лівий верхній кут
        {
            for(int i = coordinatesQueenI - 1, j = coordinatesQueenJ - 1; i >= coordinatesQueenMoveI && j >= coordinatesQueenMoveJ; i--, j--)
            {
                if(field[i][j]/10 == colorQueen)
                {
                    return false;
                }
                else if(i == coordinatesQueenMoveI && j == coordinatesQueenMoveJ)
                {
                    return true;
                }
                else if(field[i][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesQueenI < coordinatesQueenMoveI && coordinatesQueenJ > coordinatesQueenMoveJ) //рухаємося лівий нижній кут
        {
            for(int i = coordinatesQueenI + 1, j = coordinatesQueenJ - 1; i <= coordinatesQueenMoveI && j >= coordinatesQueenMoveJ; i++, j--)
            {
                if(field[i][j]/10 == colorQueen)
                {
                    return false;
                }
                else if(i == coordinatesQueenMoveI && j == coordinatesQueenMoveJ)
                {
                    return true;
                }
                else if(field[i][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesQueenI > coordinatesQueenMoveI && coordinatesQueenJ < coordinatesQueenMoveJ) //рухаємося правий верхній кут
        {
            for(int i = coordinatesQueenI - 1, j = coordinatesQueenJ + 1; i >= coordinatesQueenMoveI && j <= coordinatesQueenMoveJ; i--, j++)
            {
                if(field[i][j]/10 == colorQueen)
                {
                    return false;
                }
                else if(i == coordinatesQueenMoveI && j == coordinatesQueenMoveJ)
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

        byte coordinatesQueenI = (byte)(PieceCoords/10);
        byte coordinatesQueenJ = (byte)(PieceCoords%10);
        byte coordinatesQueenMoveI = (coordinatesQueenI);
        byte coordinatesQueenMoveJ = (byte)7;
        byte colorQueen = (byte)(field[coordinatesQueenI][coordinatesQueenJ]/10);
        colorQueen = (byte)(colorQueen%10);

        byte coordinatesPossibleMoves = 0;
        for(int j = coordinatesQueenJ + 1; j <= coordinatesQueenMoveJ; j++) //рухаємося праворуч
=======
package main.java.org.example;

import java.util.LinkedList;

public class Queen extends Piece
{
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorQueen)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesQueenI = (byte)(PieceCoords/10);
        byte coordinatesQueenJ = (byte)(PieceCoords%10);

        byte coordinatesPossibleMoves = 0;
        for(byte j = (byte)(coordinatesQueenJ + 1); j <= 7; j++) //рухаємося праворуч
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesQueenMoveJ = 0;
        for(int j = coordinatesQueenJ - 1; j >= coordinatesQueenMoveJ; j--) //рухаємося ліворуч
=======
        for(byte j = (byte)(coordinatesQueenJ - 1); j >= 0; j--) //рухаємося ліворуч
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesQueenMoveI = 7;
        for(int i = coordinatesQueenI + 1; i <= coordinatesQueenMoveI; i++) //рухаємося вниз
=======
        for(byte i = (byte)(coordinatesQueenI + 1); i <= 7; i++) //рухаємося вниз
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesQueenMoveI = 0;
        for(int i = coordinatesQueenI - 1; i >= coordinatesQueenMoveI; i--) //рухаємося вгору
=======
        for(byte i = (byte)(coordinatesQueenI - 1); i >= 0; i--) //рухаємося вгору
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesQueenMoveI = 7;
        coordinatesQueenMoveJ = 7;
        for(int i = coordinatesQueenI + 1, j = coordinatesQueenJ + 1; i <= coordinatesQueenMoveI && j <=coordinatesQueenMoveJ; i++, j++) //рухаємося правий нижній кут
=======
        for(byte i = (byte)(coordinatesQueenI + 1), j = (byte)(coordinatesQueenJ + 1); i <= 7 && j <=7; i++, j++) //рухаємося правий нижній кут
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesQueenMoveI = 0;
        coordinatesQueenMoveJ = 0;
        for(int i = coordinatesQueenI - 1, j = coordinatesQueenJ - 1; i >= coordinatesQueenMoveI && j >= coordinatesQueenMoveJ; i--, j--) //рухаємося лівий верхній кут
=======
        for(byte i = (byte)(coordinatesQueenI - 1), j = (byte)(coordinatesQueenJ - 1); i >= 0 && j >= 0; i--, j--) //рухаємося лівий верхній кут
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesQueenMoveI = 7;
        coordinatesQueenMoveJ = 0;
        for(int i = coordinatesQueenI + 1, j = coordinatesQueenJ - 1; i <= coordinatesQueenMoveI && j >= coordinatesQueenMoveJ; i++, j--) //рухаємося лівий нижній кут
=======
        for(byte i = (byte)(coordinatesQueenI + 1), j = (byte)(coordinatesQueenJ - 1); i <= 7 && j >= 0; i++, j--) //рухаємося лівий нижній кут
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesQueenMoveI = 0;
        coordinatesQueenMoveJ = 7;
        for(int i = coordinatesQueenI - 1, j = coordinatesQueenJ + 1; i >= coordinatesQueenMoveI && j <= coordinatesQueenMoveJ; i--, j++) //рухаємося правий верхній кут
=======
        for(byte i = (byte)(coordinatesQueenI - 1), j = (byte)(coordinatesQueenJ + 1); i >= 0 && j <= 7; i--, j++) //рухаємося правий верхній кут
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
