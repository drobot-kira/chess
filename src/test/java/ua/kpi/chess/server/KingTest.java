package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {
    @Test
    void testWhiteKingJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)32);
        correctList.add((byte)33);
        correctList.add((byte)34);
        correctList.add((byte)42);
        correctList.add((byte)44);
        correctList.add((byte)52);
        correctList.add((byte)53);
        correctList.add((byte)54);

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteKingWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 11, 11, 11, 30, 30, 30},
                {30, 30, 11, 16, 11, 30, 30, 30},
                {30, 30, 11, 11, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteKingMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 16, 21, 30, 30, 30},
                {30, 30, 21, 21, 21, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)32);
        correctList.add((byte)33);
        correctList.add((byte)34);
        correctList.add((byte)42);
        correctList.add((byte)44);
        correctList.add((byte)52);
        correctList.add((byte)54);

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteKingWithCheck(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)32);
        correctList.add((byte)33);
        correctList.add((byte)34);
        correctList.add((byte)52);
        correctList.add((byte)53);
        correctList.add((byte)54);

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteKingWithCheckmate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 16, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)3, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteKingWithStalemate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 16},
                {30, 30, 30, 30, 30, 30, 30, 11},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 25, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)7, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackKingJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)32);
        correctList.add((byte)33);
        correctList.add((byte)34);
        correctList.add((byte)42);
        correctList.add((byte)44);
        correctList.add((byte)52);
        correctList.add((byte)53);
        correctList.add((byte)54);

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackKingWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 21, 21, 30, 30, 30},
                {30, 30, 21, 26, 21, 30, 30, 30},
                {30, 30, 21, 21, 21, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackKingMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 11, 11, 11, 30, 30, 30},
                {30, 30, 11, 26, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)32);
        correctList.add((byte)34);
        correctList.add((byte)42);
        correctList.add((byte)44);
        correctList.add((byte)52);
        correctList.add((byte)53);
        correctList.add((byte)54);

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackKingWithCheck(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)32);
        correctList.add((byte)33);
        correctList.add((byte)34);
        correctList.add((byte)52);
        correctList.add((byte)53);
        correctList.add((byte)54);

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackKingWithCheckmate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 26, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)3, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackKingWithStalemate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 26},
                {30, 30, 30, 30, 30, 30, 30, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 15, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();

        LinkedList<Byte> testList;
        var king = new King();
        //Act
        testList = king.FindPossibleMovesItem(field, (byte)7, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
}
