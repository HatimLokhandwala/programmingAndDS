package misc;

public class DiagonalTraverse {

    public static boolean isValid(int x, int y, int row, int col) {
        if (x < 0 || x >= row) {
            return false;
        }
        return y >= 0 && y < col;
    }
    public static int[] findDiagonalOrder(int[][] matrix) {
        int index = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] output = new int[row * col];
        int dir = 1;
        int x = 0;
        int y = 0;
        while (index < (row * col)) {
            if (dir == 1) {
                while (isValid(x, y, row, col)) {
                    output[index++] = matrix[x][y];
                    x--;
                    y++;
                }
                if (isValid(x + 1, y, row, col)) {
                    x++;
                } else {
                    x += 2;
                    y--;
                }
                dir = 0;
            } else {
                while (isValid(x,y, row, col)) {
                    output[index++] = matrix[x][y];
                    x++;
                    y--;
                }
                if (isValid(x, y + 1, row, col)) {
                    y++;
                } else {
                    x--;
                    y += 2;
                }
                dir = 1;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] res = findDiagonalOrder(matrix);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
