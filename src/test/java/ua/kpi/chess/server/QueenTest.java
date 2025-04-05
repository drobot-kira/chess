package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    @Test
    void testWhiteQueenJustMove() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 44);
        correctList.add((byte) 45);
        correctList.add((byte) 46);
        correctList.add((byte) 47);
        correctList.add((byte) 42);
        correctList.add((byte) 41);
        correctList.add((byte) 40);
        correctList.add((byte) 53);
        correctList.add((byte) 63);
        correctList.add((byte) 73);
        correctList.add((byte) 33);
        correctList.add((byte) 23);
        correctList.add((byte) 13);
        correctList.add((byte) 3);
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 76);
        correctList.add((byte) 32);
        correctList.add((byte) 21);
        correctList.add((byte) 10);
        correctList.add((byte) 52);
        correctList.add((byte) 61);
        correctList.add((byte) 70);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenMoveWithPiece() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 11},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 15, 30, 30, 30, 11},
                {30, 30, 11, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 44);
        correctList.add((byte) 45);
        correctList.add((byte) 46);
        correctList.add((byte) 42);
        correctList.add((byte) 41);
        correctList.add((byte) 33);
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 32);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenMoveWithEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 21, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {21, 30, 30, 15, 30, 30, 30, 21},
                {30, 30, 21, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 44);
        correctList.add((byte) 45);
        correctList.add((byte) 46);
        correctList.add((byte) 47);
        correctList.add((byte) 42);
        correctList.add((byte) 41);
        correctList.add((byte) 40);
        correctList.add((byte) 53);
        correctList.add((byte) 33);
        correctList.add((byte) 23);
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 76);
        correctList.add((byte) 32);
        correctList.add((byte) 21);
        correctList.add((byte) 52);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveRightDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 16},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 47);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveRightProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {15, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 16},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 47);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveRightDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {15, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 77);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 0, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveRightDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 76);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 10, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveRightUpDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 70, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveRightUpProtected() {
        //Arrange
        byte[][] field = {
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 6);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 60, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveLeftDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 40);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveLeftProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 40);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 77);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 15, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 76);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 6, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveLeftDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 16},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 70);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveLeftDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 16},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 71);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 17, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveLeftUpDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {25, 30, 30, 30, 30, 30, 30, 16},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 0);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveLeftUpProtected() {
        //Arrange
        byte[][] field = {
                {25, 30, 30, 30, 30, 30, 30, 16},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 1);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 67, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveUpDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteQueenWithCheckMoveUpProtected() {
        //Arrange
        byte[][] field = {
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 15, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 6);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 76, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackQueenJustMove() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 44);
        correctList.add((byte) 45);
        correctList.add((byte) 46);
        correctList.add((byte) 47);
        correctList.add((byte) 42);
        correctList.add((byte) 41);
        correctList.add((byte) 40);
        correctList.add((byte) 53);
        correctList.add((byte) 63);
        correctList.add((byte) 73);
        correctList.add((byte) 33);
        correctList.add((byte) 23);
        correctList.add((byte) 13);
        correctList.add((byte) 3);
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 76);
        correctList.add((byte) 32);
        correctList.add((byte) 21);
        correctList.add((byte) 10);
        correctList.add((byte) 52);
        correctList.add((byte) 61);
        correctList.add((byte) 70);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenMoveWithPiece() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 21, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {21, 30, 30, 25, 30, 30, 30, 21},
                {30, 30, 21, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 44);
        correctList.add((byte) 45);
        correctList.add((byte) 46);
        correctList.add((byte) 42);
        correctList.add((byte) 41);
        correctList.add((byte) 33);
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 32);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenMoveWithEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 11},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 25, 30, 30, 30, 11},
                {30, 30, 11, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 44);
        correctList.add((byte) 45);
        correctList.add((byte) 46);
        correctList.add((byte) 47);
        correctList.add((byte) 42);
        correctList.add((byte) 41);
        correctList.add((byte) 40);
        correctList.add((byte) 53);
        correctList.add((byte) 33);
        correctList.add((byte) 23);
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 76);
        correctList.add((byte) 32);
        correctList.add((byte) 21);
        correctList.add((byte) 52);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveRightDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 26},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 47);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveRightProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {25, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 26},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 47);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveRightDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {25, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 77);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 0, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopWithCheckMoveRightDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 76);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 10, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopWithCheckMoveRightUpDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 70, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopWithCheckMoveRightUpProtected() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {25, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 6);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 60, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveLeftDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 40);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveLeftProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 40);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 77);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 25, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 76);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 6, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopWithCheckMoveLeftDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 26},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 70);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopWithCheckMoveLeftDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {15, 30, 30, 30, 30, 30, 30, 26},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 71);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 17, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopWithCheckMoveLeftUpDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {15, 30, 30, 30, 30, 30, 30, 26},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 0);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopWithCheckMoveLeftUpProtected() {
        //Arrange
        byte[][] field = {
                {15, 30, 30, 30, 30, 30, 30, 26},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 1);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 67, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveUpDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackQueenWithCheckMoveUpProtected() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 25, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 6);

        LinkedList<Byte> testList;
        var queen = new Queen();
        //Act
        testList = queen.FindPossibleMovesItem(field, (byte) 76, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }
}