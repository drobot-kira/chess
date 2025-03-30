package ua.kpi.chess;
import java.util.List;

public class Board
{
    public byte[][] RemoveMarks(byte[][] field)
    {
        for(int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (field[i][j] > 100)
                {
                    field[i][j] -= 100;
                }
                else if (field[i][j] < 0)
                {
                    field[i][j] = (byte) Math.abs(field[i][j]);
                }
            }
        }
        return field;
    }
    public byte[][] AddMarks(byte[][] field, byte SquareId)
    {
        List<Byte> possibleMoves = Piece.FindPossibleMoves(field, SquareId);

        for(int i = 0; i < possibleMoves.size(); i++)
        {
            byte possibleMoveCoord = possibleMoves.get(i);
            byte fieldI = (byte) (possibleMoveCoord / 10);
            byte fieldJ = (byte) (possibleMoveCoord % 10);
            field[fieldI][fieldJ] *= -1;
        }
        return field;
    }
    public byte IsThereAMarkedPiece(byte[][]  field)
    {
        for(int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if(field[i][j] > 100)
                {
                    return (byte)(i * 10 + j);
                }
            }
        }
        return -1;
    }
}

