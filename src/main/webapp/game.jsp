<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sudoku Game</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h1>Sudoku Game</h1>
    <form action="game" method="post">
        <table>
            <% 
                int[][] sudoku = (int[][]) request.getAttribute("sudoku");
                if (sudoku == null) {
                    sudoku = new int[9][9];
                }
                for (int i = 0; i < 9; i++) {
                    out.print("<tr>");
                    for (int j = 0; j < 9; j++) {
                        out.print("<td><input type='number' name='cell_" + i + "_" + j + "' value='" + sudoku[i][j] + "' min='1' max='9'></td>");
                    }
                    out.print("</tr>");
                }
            %>
        </table>
        <input type="submit" value="Solve">
    </form>
</body>
</html>
