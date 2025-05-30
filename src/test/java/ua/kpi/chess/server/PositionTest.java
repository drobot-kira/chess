package ua.kpi.chess.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyByte;

public class PositionTest {
    @Test
    void testWhiteKingVsBlackKing() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingAndKnightVsBlackKing() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {12, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingAndKnightAndKnightVsBlackKing() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {12, 12, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingAndBishopVsBlackKing() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {13, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingAndBishopAndKnightVsBlackKing() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {13, 12, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingAndBishopVsBlackKingAndBishopWhiteField() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 13, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 23},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingAndBishopVsBlackKingAndBishopDifferentField() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 13, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 23},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingVsBlackKingAndKnight() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {22, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingVsBlackKingAndKnightAndKnight() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {22, 22, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 12, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingVsBlackKingAndBishop() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {23, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingVsBlackKingAndBishopAndKnight() {
        //Arrange
        byte[][] field = {
                {26, 30, 30, 30, 30, 30, 30, 30},
                {22, 23, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testWhiteKingAndBishopVsBlackKingAndBishopBlackField() {
        //Arrange
        byte[][] field = {
                {26, 23, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 13, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            boolean correct = true;
            //Act
            var position = new Position();
            boolean test = position.IsThereAnInsufficientMaterial(field);
            //Assert
            assertEquals(correct, test);
        }
    }

    @Test
    void testKingNoInCheck() {
        byte[][] field = new byte[][]{{30, 30, 30, 26, 30, 30, 30, 30}, {30, 30, 21, 11, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 11, 15, 30, 30, 30, 30}, {30, 30, 30, 16, 30, 30, 30, 30}, {2, 0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertFalse(Position.IsThereACheck(field));
    }

    @Test
    void testKingInCheckByPawn() {
        byte[][] field = new byte[][]{{30, 30, 26, 30, 30, 30, 30, 30}, {30, 30, 30, 11, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 16, 30, 30, 30, 30, 30}, {2, 0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertTrue(Position.IsThereACheck(field));
    }

    @Test
    void testKingInCheckByKnight() {
        byte[][] field = new byte[][]{{30, 30, 30, 26, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 12, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 21, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 16, 30, 30, 30, 30}, {2, 0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertTrue(Position.IsThereACheck(field));
    }

    @Test
    void testKingInCheckByKing() {
        byte[][] field = new byte[][]{{30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 26, 30, 30, 30, 30}, {30, 30, 30, 16, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {2, 0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertTrue(Position.IsThereACheck(field));
    }

    @Test
    void testKingInCheckByQueen() {
        byte[][] field = new byte[][]{{30, 30, 30, 25, 26, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 16, 30, 30, 30, 30}, {1, 0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertTrue(Position.IsThereACheck(field));
    }

    @Test
    void testKingInCheckByRook() {
        byte[][] field = new byte[][]{{30, 30, 30, 26, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 14, 30, 30, 30, 30}, {30, 30, 30, 16, 30, 30, 30, 30}, {2, 0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertTrue(Position.IsThereACheck(field));
    }

    @Test
    void testKingInCheckByBishop() {
        byte[][] field = new byte[][]{{13, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 26, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 30, 30, 30, 30, 30}, {30, 30, 30, 16, 30, 30, 30, 30}, {2, 0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertTrue(Position.IsThereACheck(field));
    }


}
