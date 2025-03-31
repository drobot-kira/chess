package ua.kpi.chess.server;

import java.io.FileWriter;
import java.io.IOException;

public class Game
{
    public byte[][] SquareClicked(int GameId, int SquareId, int UserId) {
        byte[][] field = {
                {24, 22, 23, 25, 26, 23, 22, 24},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {30, 30, 30, 30, 30, 30, 30, 30},
                {11, 11, 11, 11, 11, 11, 11, 11},
                {14, 12, 13, 15, 16, 13, 12, 14},
                { 1,  0,  0,  0,  0,  0,  0,  0}
        };
        return field;
    }
}