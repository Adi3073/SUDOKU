package com.sudoku.model;

import java.util.List;

public class SudokuSolver {
    public boolean isPossible(int[][] sudoku, int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value || sudoku[i][col] == value || 
                sudoku[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value) {
                return false;
            }
        }
        return true;
    }

    public boolean solve(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isPossible(sudoku, i, j, k)) {
                            sudoku[i][j] = k;
                            if (solve(sudoku)) {
                                return true;
                            } else {
                                sudoku[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
