package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    @Test
    void testWhiteBishopJustMove() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 13, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopMoveWithPiece() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 11},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 13, 30, 30, 30, 30},
                {30, 30, 11, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 32);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopMoveWithEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 21, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 13, 30, 30, 30, 30},
                {30, 30, 21, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveRightDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {13, 30, 30, 30, 30, 30, 30, 30},
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 0, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveRightDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {13, 30, 30, 30, 30, 30, 30, 30},
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 10, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveLeftDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 13},
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testWhiteBishopWithCheckMoveLeftDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 13},
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 17, (byte) 1);
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
                {13, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 70, (byte) 1);
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
                {13, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 6);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 60, (byte) 1);
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
                {30, 30, 30, 30, 30, 30, 30, 13},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 0);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 77, (byte) 1);
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
                {30, 30, 30, 30, 30, 30, 30, 13},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 1);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 67, (byte) 1);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopJustMove() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 23, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopMoveWithPiece() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 21, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 23, 30, 30, 30, 30},
                {30, 30, 21, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 54);
        correctList.add((byte) 65);
        correctList.add((byte) 32);
        correctList.add((byte) 34);
        correctList.add((byte) 25);
        correctList.add((byte) 16);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }

    @Test
    void testBlackBishopMoveWithEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 11},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 23, 30, 30, 30, 30},
                {30, 30, 11, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackBishopWithCheckMoveRightDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {23, 30, 30, 30, 30, 30, 30, 30},
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 0, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackBishopWithCheckMoveRightDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {23, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                { 2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 76);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 10, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackBishopWithCheckMoveLeftDownDestroyedEnemy() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 23},
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }
    @Test
    void testBlackBishopWithCheckMoveLeftDownProtected() {
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 23},
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
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 17, (byte) 2);
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
                {23, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 7);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 70, (byte) 2);
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
                {23, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 6);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 60, (byte) 2);
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
                {30, 30, 30, 30, 30, 30, 30, 23},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 0);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 77, (byte) 2);
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
                {30, 30, 30, 30, 30, 30, 30, 23},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        LinkedList<Byte> correctList = new LinkedList<>();
        correctList.add((byte) 1);

        LinkedList<Byte> testList;
        var bishop = new Bishop();
        //Act
        testList = bishop.FindPossibleMovesItem(field, (byte) 67, (byte) 2);
        //Assert
        assertEquals(correctList, testList);
    }
}