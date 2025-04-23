package ua.kpi.chess.game;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;

public class KnightTest {
    @Test
    void testWhiteKnightJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 12, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 24, (byte) 35, (byte) 55, (byte) 64, (byte) 62, (byte) 51, (byte) 31, (byte) 22));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 11, 30, 11, 30, 30, 30},
                {30, 11, 30, 30, 30, 11, 30, 30},
                {30, 30, 30, 12, 30, 30, 30, 30},
                {30, 11, 30, 30, 30, 11, 30, 30},
                {30, 30, 11, 30, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 30, 21, 30, 30, 30},
                {30, 21, 30, 30, 30, 21, 30, 30},
                {30, 30, 30, 12, 30, 30, 30, 30},
                {30, 21, 30, 30, 30, 21, 30, 30},
                {30, 30, 21, 30, 21, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 24, (byte) 35, (byte) 55, (byte) 64, (byte) 62, (byte) 51, (byte) 31, (byte) 22));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpDestroyedEnemy1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 12, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)74), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 74, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpProtected1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 12, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)74), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 74, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpDestroyedEnemy2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 12, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)72), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 72, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpProtected2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 12, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)72), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 72, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpDestroyedEnemy3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 12, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)75), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 75, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpProtected3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 12, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)75), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 75, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpDestroyedEnemy4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 12, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)71), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 71, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveUpProtected4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 12, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)71), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 71, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownDestroyedEnemy1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 12, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)34), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 34, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownProtected1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 12, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)44), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 44, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownDestroyedEnemy2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 12, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)32), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 32, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownProtected2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 12, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)42), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 42, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownDestroyedEnemy3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 12, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)55), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 55, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownProtected3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 12, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)55), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 55, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownDestroyedEnemy4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 12, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)41), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 41, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhiteKnightWithCheckMoveDownProtected4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 12, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 16, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)51), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 51, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightJustMove(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 22, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 24, (byte) 35, (byte) 55, (byte) 64, (byte) 62, (byte) 51, (byte) 31, (byte) 22));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 30, 21, 30, 30, 30},
                {30, 21, 30, 30, 30, 21, 30, 30},
                {30, 30, 30, 22, 30, 30, 30, 30},
                {30, 21, 30, 30, 30, 21, 30, 30},
                {30, 30, 21, 30, 21, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 11, 30, 11, 30, 30, 30},
                {30, 11, 30, 30, 30, 11, 30, 30},
                {30, 30, 30, 22, 30, 30, 30, 30},
                {30, 11, 30, 30, 30, 11, 30, 30},
                {30, 30, 11, 30, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 24, (byte) 35, (byte) 55, (byte) 64, (byte) 62, (byte) 51, (byte) 31, (byte) 22));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpDestroyedEnemy1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 22, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)74), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 74, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpProtected1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 22, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)74), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 74, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpDestroyedEnemy2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 22, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)72), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 72, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpProtected2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 22, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)72), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 72, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpDestroyedEnemy3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 22, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)75), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 75, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpProtected3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 22, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)75), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 75, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpDestroyedEnemy4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 22, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)71), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 71, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveUpProtected4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 22, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)71), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 71, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownDestroyedEnemy1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 22, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)34), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 34, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownProtected1(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 22, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)44), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 44, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownDestroyedEnemy2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 22, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)32), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 32, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownProtected2(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 22, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)42), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 42, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownDestroyedEnemy3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 22, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)55), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 55, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownProtected3(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 22, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)55), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 55, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownDestroyedEnemy4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 22, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)41), eq((byte)53))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 41, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackKnightWithCheckMoveDownProtected4(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 22, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 26, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)51), eq((byte)63))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 63));
            //Act
            var knight = new Knight();
            LinkedList<Byte> testList = knight.FindPossibleMovesItem(field, (byte) 51, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
}
