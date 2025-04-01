<<<<<<< Updated upstream
﻿package ua.kpi.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece
{
    public boolean IsMovePossible(byte[][] field, byte SquareCoords, byte PieceCoords)
    {
        byte coordinatesRookI = (byte)(PieceCoords/10);
        byte coordinatesRookJ = (byte)(PieceCoords%10);
        byte coordinatesRookMoveI = (byte)(SquareCoords/10);
        byte coordinatesRookMoveJ = (byte)(SquareCoords%10);
        byte colorRook = (byte)(field[coordinatesRookI][coordinatesRookJ]/10);
        colorRook = (byte)(colorRook%10);

        if(coordinatesRookI != coordinatesRookMoveI)
        {
            if(coordinatesRookJ != coordinatesRookMoveJ)
            {
                return false;
            }
        }

        if(coordinatesRookI == coordinatesRookMoveI && coordinatesRookJ < coordinatesRookMoveJ) //рухаємося праворуч
        {
            for(int j = coordinatesRookJ + 1; j <= coordinatesRookMoveJ; j++)
            {
                if(field[coordinatesRookI][j]/10 == colorRook)
                {
                    return false;
                }
                else if(j == coordinatesRookMoveJ)
                {
                    return true;
                }
                else if(field[coordinatesRookI][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesRookI == coordinatesRookMoveI && coordinatesRookJ > coordinatesRookMoveJ) //рухаємося ліворуч
        {
            for(int j = coordinatesRookJ - 1; j >= coordinatesRookMoveJ; j--)
            {
                if(field[coordinatesRookI][j]/10 == colorRook)
                {
                    return false;
                }
                else if(j == coordinatesRookMoveJ)
                {
                    return true;
                }
                else if(field[coordinatesRookI][j] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesRookI < coordinatesRookMoveI && coordinatesRookJ == coordinatesRookMoveJ) //рухаємося вниз
        {
            for(int i = coordinatesRookI + 1; i <= coordinatesRookMoveI; i++)
            {
                if (field[i][coordinatesRookJ] / 10 == colorRook)
                {
                    return false;
                }
                else if (i == coordinatesRookMoveI)
                {
                    return true;
                }
                else if (field[i][coordinatesRookJ] != 30)
                {
                    return false;
                }
            }
        }
        else if(coordinatesRookI > coordinatesRookMoveI && coordinatesRookJ == coordinatesRookMoveJ) //рухаємося вгору
        {
            for(int i = coordinatesRookI - 1; i >= coordinatesRookMoveI; i--)
            {
                if (field[i][coordinatesRookJ] / 10 == colorRook)
                {
                    return false;
                }
                else if (i == coordinatesRookMoveI)
                {
                    return true;
                }
                else if (field[i][coordinatesRookJ] != 30)
                {
                    return false;
                }
            }
        }

        return false;
    }
    public List<Byte> FindPossibleMoves(byte[][] field,  byte PieceCoords)
    {
        List<Byte> listPossibleMoves = new ArrayList<>();

        var position = new Position();
        if(position.IsThereACheck(field))
        {
            return listPossibleMoves;
        }

        byte coordinatesRookI = (byte)(PieceCoords/10);
        byte coordinatesRookJ = (byte)(PieceCoords%10);
        byte coordinatesRookMoveI = (byte)(coordinatesRookI);
        byte coordinatesRookMoveJ = (byte)7;
        byte colorRook = (byte)(field[coordinatesRookI][coordinatesRookJ]/10);
        colorRook = (byte)(colorRook%10);

        byte coordinatesPossibleMoves = 0;
        for(int j = coordinatesRookJ + 1; j <= coordinatesRookMoveJ; j++) //рухаємося ліворуч
=======
package main.java.org.example;

import java.util.LinkedList;

public class Rook extends Piece
{
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorRook)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesRookI = (byte)(PieceCoords/10);
        byte coordinatesRookJ = (byte)(PieceCoords%10);

        byte coordinatesPossibleMoves = 0;
        for(byte j = (byte)(coordinatesRookJ + 1); j <= 7; j++) //рухаємося ліворуч
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesRookMoveJ = 0;
        for(int j = coordinatesRookJ - 1; j >= coordinatesRookMoveJ; j--) //рухаємося праворуч
        {
            if(field[coordinatesRookI][j]/10 == colorRook)
            {
                break;
=======
        for(byte j = (byte)(coordinatesRookJ - 1); j >= 0; j--) //рухаємося праворуч
        {
            if(field[coordinatesRookI][j]/10 == colorRook)
            {
               break;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesRookMoveI = 7;
        for(int i = coordinatesRookI + 1; i <= coordinatesRookMoveI; i++) //рухаємося вниз
        {
            if (field[i][coordinatesRookJ] / 10 == colorRook)
            {
                break;
=======
        for(byte i = (byte)(coordinatesRookI + 1); i <= 7; i++) //рухаємося вниз
        {
            if (field[i][coordinatesRookJ] / 10 == colorRook)
            {
               break;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
        coordinatesRookMoveI = 0;
        for(int i = coordinatesRookI - 1; i >= coordinatesRookMoveI; i--) //рухаємося вгору
=======
        for(byte i = (byte)(coordinatesRookI - 1); i >= 0; i--) //рухаємося вгору
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
