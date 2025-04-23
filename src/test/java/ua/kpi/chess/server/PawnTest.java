package ua.kpi.chess.server;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;

public class PawnTest {
    @Test
    void testWhitePawnJustMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53, (byte) 43));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 63, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnJustMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 43));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 53, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 53, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnJustMoveTwoStepThatNotDestroyedOwnPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 63, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnJustMoveTwoStepThatNotDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 63, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnJustMoveOneStepThatNotDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 63, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnJustMoveOneStepThatNotDestroyedBack(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 25, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 33));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 43, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 21, 30, 21, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 43, (byte) 44, (byte) 42));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 53, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnWithCheckMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)66), eq((byte)56))).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)66), eq((byte)57))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 56, (byte) 57));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 66, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testWhitePawnWithCheckMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {16, 30, 30, 30, 30, 30, 30, 25},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 11, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)66), eq((byte)46))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 46));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 66, (byte) 1);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnJustMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
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
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 23, (byte) 33));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 13, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnJustMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 33));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 23, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnMoveWithPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 23, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnJustMoveTwoStepThatNotDestroyedOwnPiece(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 23));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 13, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnJustMoveTwoStepThatNotDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 23));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 13, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnJustMoveOneStepThatNotDestroyedEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 11, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>();
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 13, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnJustMoveOneStepThatNotDestroyedBack(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 15, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 53));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 43, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnMoveWithEnemy(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 21, 30, 30, 30, 30},
                {30, 30, 11, 30, 11, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 33, (byte) 34, (byte) 32));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 23, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnWithCheckMoveOneStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)46), eq((byte)56))).thenReturn(false);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)46), eq((byte)57))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 56, (byte) 57));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 46, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
    @Test
    void testBlackPawnWithCheckMoveTwoStep(){
        //Arrange
        byte[][] field = {
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 21, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {26, 30, 30, 30, 30, 30, 30, 15},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                { 2,  0,  0,  0,  0,  0,  0,  0}
        };

        try (MockedStatic<Piece> pieceMock = Mockito.mockStatic(Piece.class)) {
            pieceMock.when(() -> Piece.IsThereACheck(any(), anyByte(), anyByte())).thenReturn(true);
            pieceMock.when(() -> Piece.IsThereACheck(any(), eq((byte)16), eq((byte)36))).thenReturn(false);
            LinkedList<Byte> correctList =  new LinkedList<>(List.of((byte) 36));
            //Act
            var pawn = new Pawn();
            LinkedList<Byte> testList = pawn.FindPossibleMovesItem(field, (byte) 16, (byte) 2);
            //Assert
            assertEquals(correctList, testList);
        }
    }
}
