package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    void testWhitePawnJustMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)53);
        correctList.add((byte)43);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)63, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhitePawnJustMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)43);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)53, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhitePawnMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)53, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhitePawnMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 30, 21, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)43);
        correctList.add((byte)44);
        correctList.add((byte)42);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)53, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhitePawnWithCheckMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)56);
        correctList.add((byte)57);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)66, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhitePawnWithCheckMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)46);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)66, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackPawnJustMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)23);
        correctList.add((byte)33);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)13, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackPawnJustMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)33);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)23, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackPawnMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)23, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackPawnMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 11, 30, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)33);
        correctList.add((byte)34);
        correctList.add((byte)32);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)23, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackPawnWithCheckMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)56);
        correctList.add((byte)57);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)46, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackPawnWithCheckMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)36);

        LinkedList<Byte> testList;
        var pawn = new Pawn();
        //Act
        testList = pawn.FindPossibleMovesItem(field, (byte)16, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
}
