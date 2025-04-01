<<<<<<< Updated upstream
﻿package ua.kpi.chess;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece
{
    private boolean IsCastle(byte[][] field)
    {
=======
package main.java.org.example;

import java.util.LinkedList;

public class King extends Piece
{
    private boolean IsCastle(byte[][] field, byte whereIsCastleJ, byte colorKing)
    {
        byte coordinatesKingDuringIsCastle = 0;
        if(colorKing == 1)
        {
            coordinatesKingDuringIsCastle = 7;
        }

        boolean areThereAnyExtraFigures = false;
        boolean inTwoDirectionsIsCastle = false;
        if(whereIsCastleJ == 1)
        {
            for(byte j = 4 + 1; j < 7; j++)
            {
                if(field[coordinatesKingDuringIsCastle][j] != 30)
                {
                    areThereAnyExtraFigures = true;
                }
            }
        }
        else if(whereIsCastleJ == 10)
        {
            whereIsCastleJ = -1;
            for(byte j = 4 - 1; j > 0; j--)
            {
                if(field[coordinatesKingDuringIsCastle][j] != 30)
                {
                    areThereAnyExtraFigures = true;
                }
            }
        }
        else  if(whereIsCastleJ == 11)
        {
            inTwoDirectionsIsCastle = true;
            whereIsCastleJ = 1;
            for(byte j = 4 + 1; j < 7; j++)
            {
                if(field[coordinatesKingDuringIsCastle][j] != 30)
                {
                    areThereAnyExtraFigures = true;
                }
            }
            for(byte j = 4 - 1; j > 0; j--)
            {
                if(field[coordinatesKingDuringIsCastle][j] != 30)
                {
                    areThereAnyExtraFigures = true;
                }
            }
        }

        if(areThereAnyExtraFigures)
        {
            return false;
        }

>>>>>>> Stashed changes
        var position = new Position();
        if(position.IsThereACheck(field))
        {
            return false;
        }

<<<<<<< Updated upstream
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
=======
        byte buf = 0;

        byte DirectionsIsCastle = 0;
        do
        {
            buf = field[coordinatesKingDuringIsCastle][4];
            field[coordinatesKingDuringIsCastle][4] = field[coordinatesKingDuringIsCastle][4 + whereIsCastleJ];
            field[coordinatesKingDuringIsCastle][4 + whereIsCastleJ] = buf;
            if(position.IsThereACheck(field))
            {
                return false;
            }

            buf = field[coordinatesKingDuringIsCastle][4 + whereIsCastleJ];
            field[coordinatesKingDuringIsCastle][4 + whereIsCastleJ] = field[coordinatesKingDuringIsCastle][4 + (2 * whereIsCastleJ)];
            field[coordinatesKingDuringIsCastle][4 + (2 * whereIsCastleJ)] = buf;
            if(position.IsThereACheck(field))
            {
                return false;
            }

            buf = field[coordinatesKingDuringIsCastle][4 + (2 * whereIsCastleJ)];
            field[coordinatesKingDuringIsCastle][4 + (2 * whereIsCastleJ)] = field[coordinatesKingDuringIsCastle][4];
            field[coordinatesKingDuringIsCastle][4] = buf;

            if(inTwoDirectionsIsCastle)
            {
                whereIsCastleJ = -1;
                DirectionsIsCastle++;
            }

        }while (DirectionsIsCastle == 1);

        return true;
    }
    public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte PieceCoords, byte colorKing)
    {
        LinkedList<Byte> listPossibleMoves = new LinkedList<>();

        byte coordinatesPossibleMoves = 0;

        byte coordinatesKingI = (byte)(PieceCoords/10);
        byte coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI +=1;
        coordinatesKingJ +=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) //рухаємося вниз вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI +=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) // рухаємося вниз
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI +=1;
        coordinatesKingJ -=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) //рухаємося вниз вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI -=1;
        coordinatesKingJ +=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) // рухаємося вгору вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI -=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) // рухаємося вгору
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingI -=1;
        coordinatesKingJ -=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) // рухаємося вгору вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingJ +=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) // рухаємося вправо
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        coordinatesKingI = (byte)(PieceCoords/10);
        coordinatesKingJ = (byte)(PieceCoords%10);
        coordinatesKingJ -=1;
        if((coordinatesKingI >= 0 && coordinatesKingJ >= 0) && (coordinatesKingI <= 7 && coordinatesKingJ <= 7) && field[coordinatesKingI][coordinatesKingJ]/10 != colorKing) // рухаємося вліво
        {
            coordinatesPossibleMoves = (byte)((coordinatesKingI*10) + coordinatesKingJ);
            listPossibleMoves.add(coordinatesPossibleMoves);
        }

        byte colorKingForIsCastle  = 0;
        byte coordinatesKingDuringIsCastle = 7;
        if(colorKing == 2)
        {
            colorKingForIsCastle = 1;
            coordinatesKingDuringIsCastle = 0;
        }

        switch (field[8][1 + colorKingForIsCastle])
        {
            case 11:
                if(IsCastle(field, (byte)11, colorKing))
                {
                    listPossibleMoves.add((byte)((coordinatesKingDuringIsCastle * 10) + 6));
                    listPossibleMoves.add((byte)((coordinatesKingDuringIsCastle * 10) + 2));
                    return listPossibleMoves;
                };
                field[8][1] = 10;
            case 10:
                if(IsCastle(field, (byte)10, colorKing))
                {
                    listPossibleMoves.add((byte)((coordinatesKingDuringIsCastle * 10) + 2));
                    return listPossibleMoves;
                };
                field[8][1] = 1;
            case 1:
                if(IsCastle(field, (byte)1, colorKing))
                {
                    listPossibleMoves.add((byte)((coordinatesKingDuringIsCastle * 10) + 6));
                    return listPossibleMoves;
                };

            case 0:
                return listPossibleMoves;
        }

        return listPossibleMoves;
    }
}
>>>>>>> Stashed changes
