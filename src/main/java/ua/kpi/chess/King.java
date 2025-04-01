package ua.kpi.chess;

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

        var position = new Position();
        if(position.IsThereACheck(field))
        {
            return false;
        }

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
