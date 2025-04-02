package ua.kpi.chess.server;
import java.util.LinkedList;

public class Board
{
    public static byte[][] RemoveMarks(byte[][] field)
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
    public static byte[][] AddMarks(byte[][] field, byte SquareId)
    {    LinkedList<Byte> possibleMoves = Piece.FindPossibleMoves(field, SquareId);
        for (byte possibleMoveCoord : possibleMoves) {
            byte fieldI = (byte) (possibleMoveCoord / 10);
            byte fieldJ = (byte) (possibleMoveCoord % 10);
            if (fieldI >= 0 && fieldI < field.length && fieldJ >= 0 && fieldJ < field[fieldI].length) {
                field[fieldI][fieldJ] *= -1;        }
        }
        field[SquareId / 10][SquareId % 10] += 100;
        return field;
    }
    public static byte IsThereAMarkedPiece(byte[][]  field)
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
