package ua.kpi.chess.server;

import java.util.LinkedList;

public class Pawn extends Piece
{
    /*private void IsPromotion(byte[][] field, byte SquareId)
   {

   }*/
    public LinkedList<Byte> FindPossibleMovesItem(byte[][] field, byte PieceCoords, byte colorPawn)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesPawnI = (byte)(PieceCoords/10);
        byte coordinatesPawnJ = (byte)(PieceCoords%10);

        byte deltaI = -1;
        if(colorPawn == 2)
        {
            deltaI = 1;
        }

        if((-1 < coordinatesPawnI + deltaI && coordinatesPawnI + deltaI < 8) &&
                field[coordinatesPawnI + deltaI][coordinatesPawnJ] == 30) // рух вперед
        {
            if (!Position.IsThereACheck(field)) {
                listPossibleMoves.add((byte) (((coordinatesPawnI + deltaI) * 10) + coordinatesPawnJ));
            }

            if(coordinatesPawnI == 6 && colorPawn == 1 && field[coordinatesPawnI - 2][coordinatesPawnJ] == 30) // рух на два ходи для білих
            {
                if (!Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) (((coordinatesPawnI - 2) * 10) + coordinatesPawnJ));
                }
            }
            else if(coordinatesPawnI == 1 && colorPawn == 2 && field[coordinatesPawnI + 2][coordinatesPawnJ] == 30) // рух на два ходи для чорних
            {
                if (!Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) (((coordinatesPawnI + 2) * 10) + coordinatesPawnJ));
                }
            }
        }
        if((-1 < coordinatesPawnI + deltaI && coordinatesPawnI + deltaI < 8) && (coordinatesPawnJ < 7) &&
                field[coordinatesPawnI + deltaI][coordinatesPawnJ + 1]/10 != colorPawn) //б'ємо право
        {
            if (field[8][3] == (byte) (((coordinatesPawnI + deltaI) * 10) + (coordinatesPawnJ + 1)) ||
                    field[coordinatesPawnI + deltaI][coordinatesPawnJ + 1] != 30) {
                if (!Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) (((coordinatesPawnI + deltaI) * 10) + (coordinatesPawnJ + 1)));
                }
            }
        }
        if((-1 < coordinatesPawnI + deltaI && coordinatesPawnI + deltaI < 8) && (0 < coordinatesPawnJ) &&
                field[coordinatesPawnI + deltaI][coordinatesPawnJ - 1]/10 != colorPawn) //б'ємо ліво
        {
            if (field[8][3] == (byte) (((coordinatesPawnI + deltaI) * 10) + (coordinatesPawnJ - 1)) ||
                    field[coordinatesPawnI + deltaI][coordinatesPawnJ - 1] != 30) {
                if (!Position.IsThereACheck(field)) {
                    listPossibleMoves.add((byte) (((coordinatesPawnI + deltaI) * 10) + (coordinatesPawnJ - 1)));
                }
            }
        }

        return listPossibleMoves;
    }
}