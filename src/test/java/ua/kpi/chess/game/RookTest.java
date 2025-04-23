package ua.kpi.chess.game;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class RookTest {
    @Test
    void testWhiteRookJustMove() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 42, (byte) 41, (byte) 40, (byte) 53, (byte) 63, (byte) 73, (byte) 33, (byte) 23, (byte) 13, (byte) 3));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookMoveWithPiece() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 44, (byte) 45, (byte) 46, (byte) 42, (byte) 41, (byte) 33));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookMoveWithEnemy() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 42, (byte) 41, (byte) 40, (byte) 53, (byte) 33, (byte) 23));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveRightDestroyedEnemy() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 40, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveRightProtected() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 40, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveLeftDestroyedEnemy() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 47, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveLeftProtected() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 47, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveDownDestroyedEnemy() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveDownProtected() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)6), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 6, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveUpDestroyedEnemy() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 77, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteRookWithCheckMoveUpProtected() {
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
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)76), eq((byte)6))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 6));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 76, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookJustMove() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList = new LinkedList<>(List.of((byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 42, (byte) 41, (byte) 40, (byte) 53, (byte) 63, (byte) 73, (byte) 33, (byte) 23, (byte) 13, (byte) 3));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookMoveWithPiece() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 44, (byte) 45, (byte) 46, (byte) 42, (byte) 41, (byte) 33));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookMoveWithEnemy() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 42, (byte) 41, (byte) 40, (byte) 53, (byte) 33, (byte) 23));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveRightDestroyedEnemy() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 40, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveRightProtected() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)40), eq((byte)47))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 47));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 40, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveLeftDestroyedEnemy() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 47, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveLeftProtected() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)47), eq((byte)40))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 40));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 47, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveDownDestroyedEnemy() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)77))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 77));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveDownProtected() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)6), eq((byte)76))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 76));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 6, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveUpDestroyedEnemy() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)77), eq((byte)7))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 7));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 77, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackRookWithCheckMoveUpProtected() {
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
                {2, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)76), eq((byte)6))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 6));
            //Act
            var rook = new Rook();
            LinkedList<Byte> testList = rook.FindPossibleMovesItem(field, (byte) 76, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
}