package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.Mockito.mockStatic;

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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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

        try (MockedStatic<Piece> pieceMock = mockStatic(Piece.class)) {
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
    public void testIsGameEndedCheckmate() {
        byte[][] field = new byte[9][8];

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheckmate(field)).thenReturn(true);
            mocked.when(() -> Position.IsGameEnded(field, 1)).thenCallRealMethod();

            byte result = Position.IsGameEnded(field, 1);
            assertEquals(1, result);
        }
    }

    @Test
    public void testIsGameEndedSecondCase() {
        byte[][] field = new byte[9][8];
        field[8][4] = 70;

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheckmate(field)).thenReturn(false);
            mocked.when(() -> Position.IsGameEnded(field, 1)).thenCallRealMethod();
            byte result = Position.IsGameEnded(field, 1);
            assertEquals(70, result);
        }
    }

    @Test
    public void testIsGameEndedThreefoldRepetition() {
        byte[][] field = new byte[9][8];

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheckmate(field)).thenReturn(false);
            mocked.when(() -> Position.IsThereAThreefoldRepetition(field, 1)).thenReturn(true);
            mocked.when(() -> Position.IsGameEnded(field, 1)).thenCallRealMethod();
            byte result = Position.IsGameEnded(field, 1);
            assertEquals(3, result);
        }
    }

    @Test
    public void testIsGameEndedInsufficientMaterial() {
        byte[][] field = new byte[9][8];

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheckmate(field)).thenReturn(false);
            mocked.when(() -> Position.IsThereAThreefoldRepetition(field, 1)).thenReturn(false);
            mocked.when(() -> Position.IsThereAnInsufficientMaterial(field)).thenReturn(true);
            mocked.when(() -> Position.IsGameEnded(field, 1)).thenCallRealMethod();
            byte result = Position.IsGameEnded(field, 1);
            assertEquals(2, result);
        }
    }

    @Test
    public void testIsGameEndedStalemate() {
        byte[][] field = new byte[9][8];

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheckmate(field)).thenReturn(false);
            mocked.when(() -> Position.IsThereAThreefoldRepetition(field, 1)).thenReturn(false);
            mocked.when(() -> Position.IsThereAnInsufficientMaterial(field)).thenReturn(false);
            mocked.when(() -> Position.IsThereAStalemate(field)).thenReturn(true);
            mocked.when(() -> Position.IsGameEnded(field, 1)).thenCallRealMethod();
            byte result = Position.IsGameEnded(field, 1);
            assertEquals(4, result);
        }
    }

    @Test
    public void testIsGameEndedGameContinues() {
        byte[][] field = new byte[9][8];

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheckmate(field)).thenReturn(false);
            mocked.when(() -> Position.IsThereAThreefoldRepetition(field, 1)).thenReturn(false);
            mocked.when(() -> Position.IsThereAnInsufficientMaterial(field)).thenReturn(false);
            mocked.when(() -> Position.IsThereAStalemate(field)).thenReturn(false);
            byte result = Position.IsGameEnded(field, 1);
            assertEquals(0, result);
        }
    }

    @Test
    public void testIsThereAStalemateHasLegalMove() {
        byte[][] field = new byte[9][8];
        field[8][0] = 2;
        field[0][0] = 26;
        field[7][7] = 16;
        field[1][0] = 20;
        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheck(any())).thenReturn(true, true, false);
            mocked.when(() -> Position.IsThereAStalemate(field)).thenCallRealMethod();
            assertEquals(false, Position.IsThereAStalemate(field));
        }
    }

    @Test
    public void testInCheck() {
        byte[][] field = new byte[9][8];
        field[8][0] = 2;
        field[0][0] = 26;
        field[7][7] = 16;

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheck(any())).thenReturn(true);
            mocked.when(() -> Position.IsThereAStalemate(field)).thenCallRealMethod();

            assertEquals(false, Position.IsThereAStalemate(field));
        }
    }

    @Test
    public void testIsThereACheckmateNoCheck() {
        byte[][] field = new byte[9][8];

        try (MockedStatic<Position> mocked = mockStatic(Position.class)) {
            mocked.when(() -> Position.IsThereACheck(field)).thenReturn(false);

            boolean result = Position.IsThereACheckmate(field);
            assertEquals(false, result);
        }
    }

}
