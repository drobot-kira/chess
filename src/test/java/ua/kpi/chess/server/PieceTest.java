package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class PieceTest {
    @Test
    void testOnCheck1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 14, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Position> pieceMock = Mockito.mockStatic(Position.class)) {
            pieceMock.when(() -> Position.IsThereACheck(any())).thenReturn(true);
            //Act
            var piece = new Piece();
            boolean correct = piece.IsThereACheck(field, (byte)4, (byte)14);
            boolean test = true;
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testOnCheck2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 14},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Position> pieceMock = Mockito.mockStatic(Position.class)) {
            pieceMock.when(() -> Position.IsThereACheck(any())).thenReturn(false);
            //Act
            var piece = new Piece();
            boolean correct = piece.IsThereACheck(field, (byte)7, (byte)47);
            boolean test = false;
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testOnCheck3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 14, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Position> pieceMock = Mockito.mockStatic(Position.class)) {
            pieceMock.when(() -> Position.IsThereACheck(any())).thenReturn(false);
            //Act
            var piece = new Piece();
            boolean correct = piece.IsThereACheck(field, (byte)4, (byte)44);
            boolean test = false;
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testOnCheck4(){
        //Arrange
        byte[][] field = {
                {14, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Position> pieceMock = Mockito.mockStatic(Position.class)) {
            pieceMock.when(() -> Position.IsThereACheck(any())).thenReturn(true);
            //Act
            var piece = new Piece();
            boolean correct = piece.IsThereACheck(field, (byte)0, (byte)10);
            boolean test = true;
            //Assert
            assertEquals(correct, test);
        }
    }
    @Test
    void testOnCheck5(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 14, 30, 30, 30, 30, 30, 24},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        try (MockedStatic<Position> pieceMock = Mockito.mockStatic(Position.class)) {
            pieceMock.when(() -> Position.IsThereACheck(any())).thenReturn(false);
            //Act
            var piece = new Piece();
            boolean correct = piece.IsThereACheck(field, (byte)41, (byte)47);
            boolean test = false;
            //Assert
            assertEquals(correct, test);
        }
    }
}
