package ua.kpi.chess;

import java.util.LinkedList;

public class Piece
{
    static public LinkedList<Byte> FindPossibleMoves(byte[][] field, byte coords)
    {
        LinkedList<Byte> list = new LinkedList<>();

        list.add((byte)3); list.add((byte) 13); list.add((byte)23); list.add((byte)33); list.add((byte)40); list.add((byte)41); list.add((byte)42); list.add((byte)44); list.add((byte)45); list.add((byte)46); list.add((byte)53 );
        return list;
    }
}
