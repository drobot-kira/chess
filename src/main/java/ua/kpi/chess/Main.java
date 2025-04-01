package ua.kpi.chess;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args)
    {
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 11},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1,   0,  0, 46,  0,  0,  0,  0}
        };

        LinkedList<Byte> listPossibleMoves = new LinkedList<>();
        listPossibleMoves = Piece.FindPossibleMoves(field, (byte)57);
        for (byte possibleMove : listPossibleMoves) {
            System.out.println(possibleMove);
        }
    }
}