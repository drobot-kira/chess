package ua.kpi.chess;

import java.util.LinkedList;

public class Knight extends Piece
{
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorKnight)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesPossibleMoves = 0;

        byte coordinatesKnightI = (byte)(PieceCoords/10);
        byte coordinatesKnightJ = (byte)(PieceCoords%10);
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
