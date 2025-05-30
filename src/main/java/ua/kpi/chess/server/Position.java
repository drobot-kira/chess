package ua.kpi.chess.server;

import ua.kpi.chess.databaseinteraction.DatabaseHandler;

public class Position {

    public static boolean IsThereACheck(byte[][] field)
    {
        int currentPlayer = field[8][0];
        int kingValue = (currentPlayer == 1) ? 16 : 26;

        byte kingRow = -1, kingCol = -1;

        for (byte r = 0; r < 8; r++) {
            for (byte c = 0; c < 8; c++) {
                if (field[r][c] == kingValue) {
                    kingRow = r;
                    kingCol = c;
                    break;
                }
            }
        }

        if (kingRow == -1 || kingCol == -1) return false;

        int enemyPawn = (currentPlayer == 1) ? 21 : 11;
        int enemyKnight = (currentPlayer == 1) ? 22 : 12;
        int enemyRook = (currentPlayer == 1) ? 24 : 14;
        int enemyBishop = (currentPlayer == 1) ? 23 : 13;
        int enemyQueen = (currentPlayer == 1) ? 25 : 15;
        int enemyKing = (currentPlayer == 1) ? 26 : 16;

        int direction = (currentPlayer == 1) ? -1 : 1;
        if (kingRow + direction >= 0 && kingRow + direction < 8) {
            if (kingCol > 0 && field[kingRow + direction][kingCol - 1] == enemyPawn) return true;
            if (kingCol < 7 && field[kingRow + direction][kingCol + 1] == enemyPawn) return true;
        }

        int[][] knightMoves = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1} };
        for (int[] move : knightMoves) {
            int nr = kingRow + move[0];
            int nc = kingCol + move[1];
            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && field[nr][nc] == enemyKnight) {
                return true;
            }
        }

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };
        for (int i = 0; i < 8; i++) {
            int dr = directions[i][0], dc = directions[i][1];
            int nr = kingRow + dr, nc = kingCol + dc;

            while (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                int piece = field[nr][nc];

                if (piece == 30) {
                    nr += dr;
                    nc += dc;
                    continue;
                }

                if ((i < 4 && (piece == enemyRook || piece == enemyQueen)) ||
                        (i >= 4 && (piece == enemyQueen || piece == enemyBishop))) {
                    return true;
                }

                break;
            }
        }

        int[][] kingMoves = { {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1} };
        for (int[] move : kingMoves) {
            int nr = kingRow + move[0];
            int nc = kingCol + move[1];
            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && field[nr][nc] == enemyKing) {
                return true;
            }
        }

        return false;
    }

    public static boolean IsThereACheckmate(byte[][] field)
    {
        if (!IsThereACheck(field)) return false;

        int currentPlayer = field[8][0]; // 1 - білі, 2 - чорні
        int opponent = (currentPlayer == 1) ? 2 : 1;
        int kingValue = (currentPlayer == 1) ? 16 : 26;
        int kingRow = -1, kingCol = -1;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (field[row][col] == kingValue) {
                    kingRow = row;
                    kingCol = col;
                    break;
                }
            }
        }


        int[][] kingMoves = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };

        for (int[] move : kingMoves) {
            int nr = kingRow + move[0];
            int nc = kingCol + move[1];

            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && field[nr][nc] / 10 != currentPlayer) {
                byte original = field[nr][nc];
                field[kingRow][kingCol] = 30;
                field[nr][nc] = (byte) kingValue;

                if (!IsThereACheck(field)) {
                    field[kingRow][kingCol] = (byte) kingValue;
                    field[nr][nc] = original;
                    return false;
                }

                field[kingRow][kingCol] = (byte) kingValue;
                field[nr][nc] = original;
            }
        }

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (field[r][c] / 10 == currentPlayer) {
                    int type = field[r][c] % 10;
                    int[][] directions;
                    int maxSteps;

                    if (type == 1) {
                        int direction = (currentPlayer == 1) ? -1 : 1;
                        int startRow = (currentPlayer == 1) ? 6 : 1;

                        if (r + direction >= 0 && r + direction < 8 && field[r + direction][c] == 30) {
                            field[r + direction][c] = field[r][c];
                            field[r][c] = 30;
                            if (!IsThereACheck(field)) return false;
                            field[r][c] = field[r + direction][c];
                            field[r + direction][c] = 30;

                            if (r == startRow && field[r + 2 * direction][c] == 30) {
                                field[r + 2 * direction][c] = field[r][c];
                                field[r][c] = 30;
                                if (!IsThereACheck(field)) return false;
                                field[r][c] = field[r + 2 * direction][c];
                                field[r + 2 * direction][c] = 30;
                            }
                        }

                        for (int dc : new int[]{-1, 1}) {
                            int newC = c + dc;
                            if (newC >= 0 && newC < 8 && field[r + direction][newC] / 10 == opponent) {
                                byte captured = field[r + direction][newC];
                                field[r + direction][newC] = field[r][c];
                                field[r][c] = 30;
                                if (!IsThereACheck(field)) return false;
                                field[r][c] = field[r + direction][newC];
                                field[r + direction][newC] = captured;
                            }
                        }

                        continue;
                    }

                    if (type == 2) {
                        directions = new int[][]{
                                {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
                                {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
                        };
                        maxSteps = 1;
                    } else if (type == 3) {
                        directions = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
                        maxSteps = 8;
                    } else if (type == 4) {
                        directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        maxSteps = 8;
                    } else if (type == 5) {
                        directions = new int[][]{
                                {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
                        };
                        maxSteps = 8;
                    } else {
                        directions = new int[][]{
                                {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
                        };
                        maxSteps = 1;
                    }

                    for (int[] dir : directions) {
                        for (int step = 1; step <= maxSteps; step++) {
                            int newR = r + dir[0] * step;
                            int newC = c + dir[1] * step;

                            if (newR < 0 || newR >= 8 || newC < 0 || newC >= 8) break;
                            if (field[newR][newC] / 10 == currentPlayer) break;

                            byte original = field[newR][newC];
                            field[newR][newC] = field[r][c];
                            field[r][c] = 30;

                            if (!IsThereACheck(field)) return false;

                            field[r][c] = field[newR][newC];
                            field[newR][newC] = original;

                            if (type == 2 || type == 6 || field[newR][newC] != 30) break;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean IsThereAStalemate(byte[][] field)
    {
        int currentPlayer = (field[8][0] == 1) ? 10 : 20;

        if (IsThereACheck(field)) return false;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (field[r][c] / 10 == currentPlayer / 10) {
                    int type = field[r][c] % 10;
                    int[][] directions;
                    int maxSteps;

                    if (type == 1) {
                        int direction = (currentPlayer == 10) ? -1 : 1;
                        int startRow = (currentPlayer == 10) ? 6 : 1;

                        if (r + direction >= 0 && r + direction < 8 && field[r + direction][c] == 30) {
                            field[r + direction][c] = field[r][c];
                            field[r][c] = 30;
                            if (!IsThereACheck(field)) return false;
                            field[r][c] = field[r + direction][c];
                            field[r + direction][c] = 30;

                            if (r == startRow && field[r + 2 * direction][c] == 30) {
                                field[r + 2 * direction][c] = field[r][c];
                                field[r][c] = 30;
                                if (!IsThereACheck(field)) return false;
                                field[r][c] = field[r + 2 * direction][c];
                                field[r + 2 * direction][c] = 30;
                            }
                        }

                        for (int dc : new int[]{-1, 1}) {
                            int newC = c + dc;
                            if (r + direction < 0) direction++;
                            if (newC >= 0 && newC < 8 && field[r + direction][newC] / 10 == (currentPlayer == 10 ? 2 : 1)) {
                                byte captured = field[r + direction][newC];
                                field[r + direction][newC] = field[r][c];
                                field[r][c] = 30;
                                if (!IsThereACheck(field)) return false;
                                field[r][c] = field[r + direction][newC];
                                field[r + direction][newC] = captured;
                            }
                        }


                        if (field[8][3] > 0) {
                            int passantRow = field[8][3] / 10;
                            int passantColumn = field[8][3] % 10;

                            int targetRow = (currentPlayer == 10) ? 2 : 5;

                            if (r == passantRow && Math.abs(c - passantColumn) == 1) {
                                byte capturedPawn = field[passantRow][passantColumn];

                                field[targetRow][passantColumn] = field[r][c];
                                field[r][c] = 30;
                                field[passantRow][passantColumn] = 30;

                                if (!IsThereACheck(field)) {
                                    return false;
                                }
                                field[r][c] = field[targetRow][passantColumn];
                                field[targetRow][passantColumn] = 30;
                                field[passantRow][passantColumn] = capturedPawn;
                            }
                        }

                        continue;
                    }

                    if (type == 2) {
                        directions = new int[][]{
                                {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
                                {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
                        };
                        maxSteps = 1;
                    } else if (type == 3) {
                        directions = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
                        maxSteps = 8;
                    } else if (type == 4) {
                        directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        maxSteps = 8;
                    } else if (type == 5) {
                        directions = new int[][]{
                                {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
                        };
                        maxSteps = 8;
                    } else {
                        directions = new int[][]{
                                {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
                        };
                        maxSteps = 1;
                    }

                    for (int[] dir : directions) {
                        for (int step = 1; step <= maxSteps; step++) {
                            int newR = r + dir[0] * step;
                            int newC = c + dir[1] * step;

                            if (newR < 0 || newR >= 8 || newC < 0 || newC >= 8) break;
                            if (field[newR][newC] / 10 == currentPlayer / 10) break;

                            byte original = field[newR][newC];
                            field[newR][newC] = field[r][c];
                            field[r][c] = 30;

                            boolean stillInCheck = IsThereACheck(field);

                            field[r][c] = field[newR][newC];
                            field[newR][newC] = original;

                            if (!stillInCheck) return false;

                            if (type == 2 || type == 6 || field[newR][newC] != 30) break;
                        }
                    }
                }
            }
        }

        return true;
    }


    public static boolean IsThereAThreefoldRepetition(byte[][] field, int GameId)
    {
        for(int i = 1; i < 7; i++){
            field[8][i] = 0;
        }

        String result = "";

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 8; j++){
                result = result + "*" + field[i][j];
            }
        }
        DatabaseHandler dbHandler = new DatabaseHandler();

        int counter = dbHandler.GetRepeatCounter(GameId, result);
        if(counter == -1){
            dbHandler.InsertPosition(GameId, result);
        }
        else{
            dbHandler.UpdatePosition(GameId, result);
            counter++;
        }

        if(counter == 3){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean IsThereAnInsufficientMaterial(byte[][] field) {
        boolean whiteHasMoreThanKing = false, blackHasMoreThanKing = false;
        int whiteBishops = 0, whiteKnights = 0, blackBishops = 0, blackKnights = 0;

        Integer firstWhiteBishopColor = null, firstBlackBishopColor = null;
        boolean allWhiteBishopsSameColor = true, allBlackBishopsSameColor = true;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                int piece = field[r][c];
                if (piece == 30) continue;

                int type = piece % 10;
                int color = piece / 10;

                if (type == 6) continue;

                if (type == 1 || type == 4 || type == 5) return false;

                if (color == 1) {
                    if (type == 2) whiteKnights++;
                    if (type == 3) {
                        whiteBishops++;
                        int bishopColor = (r + c) % 2;
                        if (firstWhiteBishopColor == null) firstWhiteBishopColor = bishopColor;
                        else if (firstWhiteBishopColor != bishopColor) allWhiteBishopsSameColor = false;
                    }
                    whiteHasMoreThanKing = true;
                } else {
                    if (type == 2) blackKnights++;
                    if (type == 3) {
                        blackBishops++;
                        int bishopColor = (r + c) % 2;
                        if (firstBlackBishopColor == null) firstBlackBishopColor = bishopColor;
                        else if (firstBlackBishopColor != bishopColor) allBlackBishopsSameColor = false;
                    }
                    blackHasMoreThanKing = true;
                }
            }
        }

        if (!whiteHasMoreThanKing && !blackHasMoreThanKing) return true;
        if (whiteKnights > 2 || whiteBishops > 2) return false;
        if (blackBishops > 2 || blackKnights > 2) return false;
        if ((whiteBishops > 1 && whiteKnights > 0) || (whiteBishops > 0 && whiteKnights > 1) ) return false;
        if ((blackBishops > 1 && blackKnights > 0) || (blackBishops > 0 && blackKnights > 1) ) return false;
        if ((whiteBishops == 1 || whiteKnights == 1) && !blackHasMoreThanKing) return true;
        if ((blackBishops == 1 || blackKnights == 1) && !whiteHasMoreThanKing) return true;


        return whiteBishops >= 0 && blackBishops >= 0 && allWhiteBishopsSameColor && allBlackBishopsSameColor;
    }


    public static byte IsGameEnded(byte[][] field, int GameId)
    {
        if (IsThereACheckmate(field)) {
            return 1;
        }
        else if (field[8][4] > 69) {
            return 70;
        }
        else if (IsThereAThreefoldRepetition(field, GameId)) {
            return 3;
        }
        else if (IsThereAnInsufficientMaterial(field)) {
            return 2;
        }
        else if (IsThereAStalemate(field)) {
            return 4;
        }
        return 0;
    }
}

