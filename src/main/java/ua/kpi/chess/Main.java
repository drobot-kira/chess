package main.java.org.example;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args)
    {
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 11, 11, 11, 11, 11, 11, 11},
                {14, 12, 13, 15, 16, 13, 12, 14},
                {0,   0,  0, 52,  0,  0,  0,  0}
        };

        LinkedList<Byte> listPossibleMoves = new LinkedList<>();
        Pawn piece = new Pawn();
        //boolean ckeack = rook.IsMovePossible(field, (byte)40, (byte)43);
        listPossibleMoves = piece.FindPossibleMoves(field, (byte)42, (byte)2);
        System.out.println(listPossibleMoves);
    }
}