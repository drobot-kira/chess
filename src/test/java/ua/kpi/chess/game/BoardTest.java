    package ua.kpi.chess.game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{

    @Test
    void testRemoveMarksSelectedPiece()
    {
        //Arrange
        byte[][] field = {
             {24, 22, 23, 25, 26, 23, 22, 24},
             {21, 21, 21, -21, 21, 21, 21, 21},
             {30, 30, 30, -30, 30, 30, 30, 30},
             {30, 30, 30, -30, 30, 30, 30, 30},
             {11, -30, -30, 114, -30, -30, -30, -30},
             {30, 30, 30, -30, 30, 30, 30, 30},
             {30, 11, 11, 11, 11, 11, 11, 11},
             {30, 12, 13, 15, 16, 13, 12, 14},
             {1, 11, 11, 0, 0, 0, 0, 0}
        };
        byte[][] expectedResult = {
             {24, 22, 23, 25, 26, 23, 22, 24},
             {21, 21, 21, 21, 21, 21, 21, 21},
             {30, 30, 30, 30, 30, 30, 30, 30},
             {30, 30, 30, 30, 30, 30, 30, 30},
             {11, 30, 30, 14, 30, 30, 30, 30},
             {30, 30, 30, 30, 30, 30, 30, 30},
             {30, 11, 11, 11, 11, 11, 11, 11},
             {30, 12, 13, 15, 16, 13, 12, 14},
             {1, 11, 11, 0, 0, 0, 0, 0}
        };

        //Act
        byte[][] result = Board.RemoveMarks(field);

        //Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testRemoveMarksNotSelectedPiece()
    {
        //Arrange
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 14, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 11, 11, 11, 11, 11, 11},
                {30, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };
        byte[][] expectedResult = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 14, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 11, 11, 11, 11, 11, 11},
                {30, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };

        //Act
        byte[][] result = Board.RemoveMarks(field);

        //Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testAddMarksNotEmptyList()
    {
        //Arrange
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 14, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 11, 11, 11, 11, 11, 11},
                {30, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };
        byte SquareId = 43;
        var possibleMoves = new LinkedList<Byte>();
        possibleMoves.add((byte)33);
        possibleMoves.add((byte)23);
        possibleMoves.add((byte)13);
        possibleMoves.add((byte)42);
        possibleMoves.add((byte)41);
        possibleMoves.add((byte)44);
        possibleMoves.add((byte)45);
        possibleMoves.add((byte)46);
        possibleMoves.add((byte)47);
        possibleMoves.add((byte)53);

        var pieceMockedStatic = Mockito.mockStatic(Piece.class);
        pieceMockedStatic.when(() -> Piece.FindPossibleMoves(field, SquareId)).thenReturn(possibleMoves);

        byte[][] expectedResult = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, -21, 21, 21, 21, 21},
                {30, 30, 30, -30, 30, 30, 30, 30},
                {30, 30, 30, -30, 30, 30, 30, 30},
                {11, -30, -30, 114, -30, -30, -30, -30},
                {30, 30, 30, -30, 30, 30, 30, 30},
                {30, 11, 11, 11, 11, 11, 11, 11},
                {30, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };

        //Act
        byte[][] result = Board.AddMarks(field, SquareId);
        pieceMockedStatic.close();

        //Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testAddMarksEmptyList()
    {
        //Arrange
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 11, 11, 11, 11, 11, 11, 11},
                {14, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };
        byte SquareId = 70;
        var possibleMoves = new LinkedList<Byte>();


        var pieceMockedStatic = Mockito.mockStatic(Piece.class);
        pieceMockedStatic.when(() -> Piece.FindPossibleMoves(field, SquareId)).thenReturn(possibleMoves);

        byte[][] expectedResult = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 11, 11, 11, 11, 11, 11, 11},
                {114, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };

        //Act
        byte[][] result = Board.AddMarks(field, SquareId);
        pieceMockedStatic.close();

        //Assert
        assertArrayEquals(expectedResult, result);

    }
    
    @Test
    void testIsThereAMarkedPieceMarked()
    {
        //Arrange
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 30, 30, 114, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 11, 11, 11, 11, 11, 11},
                {30, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };
        byte expectedResult = 45;
        //Act
        byte result = Board.IsThereAMarkedPiece(field);

        //Assert
        assertEquals(expectedResult, result);

    }

    @Test
    void testIsThereAMarkedPieceNotMarked()
    {
        //Arrange
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 30, 30, 30, 30, 14, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 11, 11, 11, 11, 11, 11, 11},
                {30, 12, 13, 15, 16, 13, 12, 14},
                {1, 11, 11, 0, 0, 0, 0, 0}
        };
        byte expectedResult = -1;
        //Act
        byte result = Board.IsThereAMarkedPiece(field);

        //Assert
        assertEquals(expectedResult, result);

    }
}