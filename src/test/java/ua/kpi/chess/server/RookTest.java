package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    void testWhiteRookJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 14, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)44);
        correctList.add((byte)45);
        correctList.add((byte)46);
        correctList.add((byte)47);
        correctList.add((byte)42);
        correctList.add((byte)41);
        correctList.add((byte)40);
        correctList.add((byte)53);
        correctList.add((byte)63);
        correctList.add((byte)73);
        correctList.add((byte)33);
        correctList.add((byte)23);
        correctList.add((byte)13);
        correctList.add((byte)3);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 14, 30, 30, 30, 11},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)44);
        correctList.add((byte)45);
        correctList.add((byte)46);
        correctList.add((byte)42);
        correctList.add((byte)41);
        correctList.add((byte)33);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {21, 30, 30, 14, 30, 30, 30, 21},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)44);
        correctList.add((byte)45);
        correctList.add((byte)46);
        correctList.add((byte)47);
        correctList.add((byte)42);
        correctList.add((byte)41);
        correctList.add((byte)40);
        correctList.add((byte)53);
        correctList.add((byte)33);
        correctList.add((byte)23);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)43, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveRightDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {14, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 16},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)47);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)40, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveRightProtected(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {14, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 16},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)47);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)40, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveLeftDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 14},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)40);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)47, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveLeftProtected(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 14},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)40);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)47, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveDownDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 14},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)77);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)7, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveDownProtected(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 14, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)76);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)6, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveUpDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 14},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)7);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)77, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testWhiteRookWithCheckMoveUpProtected(){
        //Arrange
        byte[][] field = {
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 14, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)6);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)76, (byte)1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 24, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)44);
        correctList.add((byte)45);
        correctList.add((byte)46);
        correctList.add((byte)47);
        correctList.add((byte)42);
        correctList.add((byte)41);
        correctList.add((byte)40);
        correctList.add((byte)53);
        correctList.add((byte)63);
        correctList.add((byte)73);
        correctList.add((byte)33);
        correctList.add((byte)23);
        correctList.add((byte)13);
        correctList.add((byte)3);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)43, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {21, 30, 30, 24, 30, 30, 30, 21},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)44);
        correctList.add((byte)45);
        correctList.add((byte)46);
        correctList.add((byte)42);
        correctList.add((byte)41);
        correctList.add((byte)33);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)43, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 24, 30, 30, 30, 11},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)44);
        correctList.add((byte)45);
        correctList.add((byte)46);
        correctList.add((byte)47);
        correctList.add((byte)42);
        correctList.add((byte)41);
        correctList.add((byte)40);
        correctList.add((byte)53);
        correctList.add((byte)33);
        correctList.add((byte)23);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)43, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveRightDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {24, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 26},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)47);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)40, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveRightProtected(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {24, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 26},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)47);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)40, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveLeftDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)40);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)47, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveLeftProtected(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)40);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)47, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveDownDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)77);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)7, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveDownProtected(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 24, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)76);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)6, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveUpDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 24},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)7);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)77, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackRookWithCheckMoveUpProtected(){
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 24, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte)6);

        LinkedList<Byte> testList;
        var rook = new Rook();
        //Act
        testList = rook.FindPossibleMovesItem(field, (byte)76, (byte)2);
        //Assert
        assertEquals(correctList, testList);
    }
}