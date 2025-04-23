package ua.kpi.chess.game;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;

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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 54, (byte) 65, (byte) 76, (byte) 32, (byte) 21, (byte) 10, (byte) 52, (byte) 61, (byte) 70, (byte) 34, (byte) 25, (byte) 16, (byte) 7));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 54, (byte) 65, (byte) 32, (byte) 34, (byte) 25, (byte) 16));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 54, (byte) 65, (byte) 76, (byte) 32, (byte) 21, (byte) 52, (byte) 34, (byte) 25, (byte) 16, (byte) 7));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)0), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 0, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)10), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 10, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)70))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 70));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)17), eq((byte)71))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 71));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 17, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)70), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 70, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)60), eq((byte)6))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 6));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 60, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)0))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 0));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 77, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)67), eq((byte)1))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 1));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 67, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 54, (byte) 65, (byte) 76, (byte) 32, (byte) 21, (byte) 10, (byte) 52, (byte) 61, (byte) 70, (byte) 34, (byte) 25, (byte) 16, (byte) 7));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 54, (byte) 65, (byte) 32, (byte) 34, (byte) 25, (byte) 16));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 54, (byte) 65, (byte) 76, (byte) 32, (byte) 21, (byte) 52, (byte) 34, (byte) 25, (byte) 16, (byte) 7));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)0), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 0, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)10), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 10, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)70))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 70));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)17), eq((byte)71))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 71));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 17, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)70), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 70, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)60), eq((byte)6))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 6));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 60, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)0))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 0));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 77, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)67), eq((byte)1))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 1));
            //Act
            var bishop = new Bishop();
            LinkedList<Byte> testList = bishop.FindPossibleMovesItem(field, (byte) 67, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
}