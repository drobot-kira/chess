package ua.kpi.chess;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece
{
    private boolean IsCastle(byte[][] field)
    {
        var position = new Position();
        if(position.IsThereACheck(field))
        {
            return false;
        }

        byte byf = 0;
        byf = field[0][1];
        field[0][1] = field[0][2];
        field[0][2] = byf;
        if(position.IsThereACheck(field))
        {
            return false;
        }
        else if(position.IsThereACheck(field))
        {
            return false;
        }
        return false;
    }
    private boolean IsMovePossibleKing(byte[][] field, int coordinatesKingI, int coordinatesKingJ, int coordinatesKingMoveI, int coordinatesKingMoveJ, int colorKing)
    {
        if(coordinatesKingI == coordinatesKingMoveI && coordinatesKingJ == coordinatesKingMoveJ)
        {
            if(field[coordinatesKingI][coordinatesKingJ]/10 != colorKing)
            {
                return true;
            }
        }

        return false;
    }
    public boolean IsMovePossible(byte[][] field, byte SquareCoords, byte PieceCoords)
    {
        byte coordinatesKingI = (byte)(PieceCoords/10);
        byte coordinatesKingJ = (byte)(PieceCoords%10);
        byte coordinatesKingMoveI = (byte)(SquareCoords/10);
        byte coordinatesKingMoveJ = (byte)(SquareCoords%10);
        byte colorKing = (byte)(field[coordinatesKingI][coordinatesKingJ]/10);
        colorKing = (byte)(colorKing%10);

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI +=1;
        coordinatesKingJ +=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) //рухаємося вниз вправо
        {
            return true;
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI +=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) // рухаємося вниз
        {
            return true;
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI +=1;
        coordinatesKingJ -=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) //рухаємося вниз вліво
        {
            return true;
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI -=1;
        coordinatesKingJ +=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) // рухаємося вгору вправо
        {
            return true;
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI -=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) // рухаємося вгору
        {
            return true;
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI -=1;
        coordinatesKingJ -=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) // рухаємося вгору вліво
        {
            return true;
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingJ +=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) // рухаємося вправо
        {
            return true;
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingJ -=1;
        if(IsMovePossibleKing(field, coordinatesKingI, coordinatesKingJ, coordinatesKingMoveI, coordinatesKingMoveJ, colorKing)) // рухаємося вліво
        {
            return true;
        }

        return false;
    }
    public List<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords)
    {
        List<Byte> listPossibleMoves = new ArrayList<>();

        byte coordinatesKnightI = (byte)(PieceCoords/10);
        byte coordinatesKnightJ = (byte)(PieceCoords%10);
        byte colorKnight = (byte)(field[coordinatesKnightI][coordinatesKnightJ]/10);
        colorKnight = (byte)(colorKnight%10);

        byte coordinatesPossibleMoves = 0;

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=1;
        coordinatesKnightJ +=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) //рухаємося вниз вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вниз
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI +=1;
        coordinatesKnightJ -=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) //рухаємося вниз вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=1;
        coordinatesKnightJ +=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вгору вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вгору
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightI -=1;
        coordinatesKnightJ -=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вгору вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightJ +=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKnightI = (byte)(PieceCoords/10);
        coordinatesKnightJ = (byte)(PieceCoords%10);
        coordinatesKnightJ -=1;
        if((coordinatesKnightI >= 0 && coordinatesKnightJ >= 0) && (coordinatesKnightI <= 7 && coordinatesKnightJ <= 7) && field[coordinatesKnightI][coordinatesKnightJ]/10 != colorKnight) // рухаємося вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKnightI*10) + coordinatesKnightJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        return listPossibleMoves;
    }
}
