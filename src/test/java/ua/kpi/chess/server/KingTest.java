package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;

public class KingTest {
    @Test
    void testWhiteKingJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 32, (byte) 33, (byte) 34, (byte) 42, (byte) 44, (byte) 52, (byte) 53, (byte) 54));
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKingWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 11, 11, 11, 30, 30, 30},
                {30, 30, 11, 16, 11, 30, 30, 30},
                {30, 30, 11, 11, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKingMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 16, 21, 30, 30, 30},
                {30, 30, 21, 21, 21, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)43), eq((byte)53))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 32, (byte) 33, (byte) 34, (byte) 42, (byte) 44, (byte) 52, (byte) 54));
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKingWithCheck(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)43), eq((byte)42))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)43), eq((byte)44))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 32, (byte) 33, (byte) 34, (byte) 52, (byte) 53,(byte) 54));
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKingWithCheckmate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 16, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)2))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)4))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)12))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)13))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)14))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 3, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKingWithStalemate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 16},
                {30, 30, 30, 30, 30, 30, 30, 11},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 25, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)6))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)16))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 7, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKingJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 32, (byte) 33, (byte) 34, (byte) 42, (byte) 44, (byte) 52, (byte) 53, (byte) 54));
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKingWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 21, 21, 30, 30, 30},
                {30, 30, 21, 26, 21, 30, 30, 30},
                {30, 30, 21, 21, 21, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKingMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 11, 11, 11, 30, 30, 30},
                {30, 30, 11, 26, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)43), eq((byte)53))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 32, (byte) 33, (byte) 34, (byte) 42, (byte) 44, (byte) 52, (byte) 54));
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKingWithCheck(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)43), eq((byte)42))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)43), eq((byte)44))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 32, (byte) 33, (byte) 34, (byte) 52, (byte) 53,(byte) 54));
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKingWithCheckmate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 26, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)2))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)4))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)12))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)13))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)3), eq((byte)14))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 3, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKingWithStalemate(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 26},
                {30, 30, 30, 30, 30, 30, 30, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 15, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)6))).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)7), eq((byte)16))).thenReturn(true);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var king = new King();
            LinkedList<Byte> testList = king.FindPossibleMovesItem(field, (byte) 7, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
}
