<<<<<<< Updated upstream
﻿package ua.kpi.chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece
{
    private boolean IsMovePossibleKnight(byte[][] field, int coordinatesKnightI, int coordinatesKnightJ, int coordinatesKnightMoveI, int coordinatesKnightMoveJ, int colorKnight)
    {
        if(coordinatesKnightI == coordinatesKnightMoveI && coordinatesKnightJ == coordinatesKnightMoveJ)
        {
            if(field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight)
            {
                return true;
            }
        }

        return false;
    }

    public boolean IsMovePossible(byte[][] field, byte SquareCoords, byte PieceCoords)
    {
        byte coordinatesKnightI = (byte)(PieceCoords/10);
        byte coordinatesKnightJ = (byte)(PieceCoords%10);
        byte coordinatesKnightMoveI = (byte)(SquareCoords/10);
        byte coordinatesKnightMoveJ = (byte)(SquareCoords%10);
        byte colorKnight = (byte)(field[coordinatesKnightI][coordinatesKnightJ]/10);
        colorKnight = (byte)(colorKnight%10);

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=2;
        coordinatesKnightJ +=1;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) //рухаємося вниз вправо
        {
            return true;
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=2;
        coordinatesKnightJ -=1;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) // рухаємося вниз вліво
        {
            return true;
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=2;
        coordinatesKnightJ +=1;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) //рухаємося вгору вправо
        {
            return true;
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=2;
        coordinatesKnightJ -=1;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) // рухаємося вгору вліво
        {
            return true;
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=1;
        coordinatesKnightJ +=2;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) // рухаємося вправо вниз
        {
            return true;
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=1;
        coordinatesKnightJ +=2;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) // рухаємося вправо вгору
        {
            return true;
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=1;
        coordinatesKnightJ -=2;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) // рухаємося вліво вниз
        {
            return true;
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=1;
        coordinatesKnightJ -=2;
        if(IsMovePossibleKnight(field, coordinatesKnightI, coordinatesKnightJ, coordinatesKnightMoveI, coordinatesKnightMoveJ, colorKnight)) // рухаємося вліво вгору
        {
            return true;
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

        byte coordinatesKnightI = (byte)(PieceCoords/10);
        byte coordinatesKnightJ = (byte)(PieceCoords%10);
        byte colorKnight = (byte)(field[coordinatesKnightI][coordinatesKnightJ]/10);
        colorKnight = (byte)(colorKnight%10);

        byte coordinatesPossibleMoves = 0;

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
=======
package main.java.org.example;

import java.util.LinkedList;

public class Knight extends Piece
{
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorKnight)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesPossibleMoves = 0;

        byte coordinatesKnightI = (byte)(PieceCoords/10);
        byte coordinatesKnightJ = (byte)(PieceCoords%10);
>>>>>>> Stashed changes
        coordinatesKnightI +=2;
        coordinatesKnightJ +=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) //рухаємося вниз вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=2;
        coordinatesKnightJ -=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вниз вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=2;
        coordinatesKnightJ +=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) //рухаємося вгору вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=2;
        coordinatesKnightJ -=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) //рухаємося вгору вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=1;
        coordinatesKnightJ +=2;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вправо вниз
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=1;
        coordinatesKnightJ +=2;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вправо вгору
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=1;
        coordinatesKnightJ -=2;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вліво вниз
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=1;
        coordinatesKnightJ -=2;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вліво вгору
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        return listPossibleMoves;
    }
}
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
