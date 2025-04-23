package ua.kpi.chess.game;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;

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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte)44, (byte)45, (byte)46, (byte)47, (byte)42, (byte)41, (byte)40, (byte)53, (byte)63, (byte)73, (byte)33, (byte)23, (byte)13, (byte)3, (byte)54, (byte)65, (byte)76, (byte)32, (byte)21, (byte)10, (byte)52, (byte)61, (byte)70, (byte)34, (byte)25, (byte)16, (byte)7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte)44, (byte)45, (byte)46, (byte)42, (byte)41, (byte)33, (byte)54, (byte)65, (byte)32, (byte)34, (byte)25, (byte)16));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte)44, (byte)45, (byte)46, (byte)47, (byte)42, (byte)41, (byte)40, (byte)53, (byte)33, (byte)23, (byte)54, (byte)65, (byte)76, (byte)32, (byte)21, (byte)52, (byte)34, (byte)25, (byte)16, (byte)7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)0), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 0, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteQueenWithCheckMoveRightDownProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)10), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 10, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteQueenWithCheckMoveRightUpDestroyedEnemy() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)70), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 70, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteQueenWithCheckMoveRightUpProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)10), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 10, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)6), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 6, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteQueenWithCheckMoveLeftDownDestroyedEnemy() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)70))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 70));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteQueenWithCheckMoveLeftDownProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)17), eq((byte)71))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 71));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 17, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteQueenWithCheckMoveLeftUpDestroyedEnemy() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)0))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 0));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteQueenWithCheckMoveLeftUpProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)67), eq((byte)1))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 1));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 67, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)76), eq((byte)6))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 6));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 76, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte)44, (byte)45, (byte)46, (byte)47, (byte)42, (byte)41, (byte)40, (byte)53, (byte)63, (byte)73, (byte)33, (byte)23, (byte)13, (byte)3, (byte)54, (byte)65, (byte)76, (byte)32, (byte)21, (byte)10, (byte)52, (byte)61, (byte)70, (byte)34, (byte)25, (byte)16, (byte)7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte)44, (byte)45, (byte)46, (byte)42, (byte)41, (byte)33, (byte)54, (byte)65, (byte)32, (byte)34, (byte)25, (byte)16));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte)44, (byte)45, (byte)46, (byte)47, (byte)42, (byte)41, (byte)40, (byte)53, (byte)33, (byte)23, (byte)54, (byte)65, (byte)76, (byte)32, (byte)21, (byte)52, (byte)34, (byte)25, (byte)16, (byte)7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 40, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)0), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 0, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackQueenWithCheckMoveRightDownProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)10), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 10, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackQueenWithCheckMoveRightUpDestroyedEnemy() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)70), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 70, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackQueenWithCheckMoveRightUpProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)10), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 10, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 47, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)6), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 6, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackQueenWithCheckMoveLeftDownDestroyedEnemy() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)70))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 70));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackQueenWithCheckMoveLeftDownProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)17), eq((byte)71))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 71));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 17, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackQueenWithCheckMoveLeftUpDestroyedEnemy() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)0))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 0));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackQueenWithCheckMoveLeftUpProtected() {
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)67), eq((byte)1))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 1));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 67, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 77, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
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

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)76), eq((byte)6))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 6));
            //Act
            var queen = new Queen();
            LinkedList<Byte> testList = queen.FindPossibleMovesItem(field, (byte) 76, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
}