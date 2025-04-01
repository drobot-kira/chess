package main.java.org.example;

import java.util.LinkedList;

public class Pawn extends Piece
{
    /*private void IsPromotion(byte[][] field, byte SquareId)
   {

   }*/
    private boolean IsEnPassant(byte[][] field, byte colorPawn, byte SquareId)
    {
        if(field[8][3] == 0)
        {
            return false;
        }
        else if(field[SquareId/10][SquareId%10] == 30)
        {
            return true;
        }

        return false;
    }
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorPawn)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesPawnI = (byte)(PieceCoords/10);
        byte coordinatesPawnJ = (byte)(PieceCoords%10);

        byte colorPawnForMove = -1;
        if(colorPawn == 2)
        {
            colorPawnForMove = 1;
        }

        byte coordinatesPossibleMoves = 0;
        if((-1 < coordinatesPawnI && coordinatesPawnI < 8) && field[coordinatesPawnI + colorPawnForMove][coordinatesPawnJ] == 30) // рух вперед
        {
            coordinatesPossibleMoves = (byte)(((coordinatesPawnI + colorPawnForMove)*10) + coordinatesPawnJ);
            listPossibleMoves.add(coordinatesPossibleMoves);

            if(coordinatesPawnI == 6 && colorPawn == 1) // рух на два ходи для білих
            {
                coordinatesPossibleMoves = (byte)(((coordinatesPawnI - 2)*10) + coordinatesPawnJ);
                listPossibleMoves.add(coordinatesPossibleMoves);
            }
            else if(coordinatesPawnI == 1 && colorPawn == 2) // рух на два ходи для чорних
            {
                coordinatesPossibleMoves = (byte)(((coordinatesPawnI + 2)*10) + coordinatesPawnJ);
                listPossibleMoves.add(coordinatesPossibleMoves);
            }
        }
        if((-1 < coordinatesPawnI && coordinatesPawnI < 8) && (-1 < coordinatesPawnJ && coordinatesPawnJ < 7) && (field[coordinatesPawnI + colorPawnForMove][coordinatesPawnJ + 1] != 30) && field[coordinatesPawnI + colorPawnForMove][coordinatesPawnJ + 1]/10 != colorPawn) //б'ємо право
        {
            coordinatesPossibleMoves = (byte)(((coordinatesPawnI + colorPawnForMove)*10) + (coordinatesPawnJ + 1));
            listPossibleMoves.add(coordinatesPossibleMoves);
        }
        if((-1 < coordinatesPawnI && coordinatesPawnI < 8) && (0 < coordinatesPawnJ && coordinatesPawnJ < 8) && (field[coordinatesPawnI + colorPawnForMove][coordinatesPawnJ - 1] != 30) && field[coordinatesPawnI + colorPawnForMove][coordinatesPawnJ - 1]/10 != colorPawn) //б'ємо ліво
        {
            coordinatesPossibleMoves = (byte)(((coordinatesPawnI + colorPawnForMove)*10) + (coordinatesPawnJ - 1));
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        if(IsEnPassant(field, colorPawn, field[8][3]))
        {
            coordinatesPossibleMoves = field[8][3];
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        return listPossibleMoves;
    }
}