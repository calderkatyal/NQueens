import java.util.Scanner;

class CalderKatyalNQueens {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of queens: ");
        int N = scanner.nextInt(); // User inputs the number of queens

        int[][] board = new int[N][N];
        if (!solve(board, 0)) {
            System.out.println("No solution exists");
        }
        scanner.close();
    }

    // Main function to solve the N-Queens problem
    static boolean solve(int board[][], int row){
        if(row >= board.length){
            printBoard(board);
            return true;
        }
        for(int c = 0; c < board.length; c++){
            if(canPlace(board, row, c)){
                board[row][c] = 1;
                if(solve(board, row + 1)){
                    return true; 
                }
                board[row][c] = 0; // backtrack
            }
        }
        return false; 
    }

    // Print the board
    static void printBoard(int[][] board) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                System.out.print(" " + board[r][c]); 
            }
            System.out.println();
        }
    }

    // Helper function to check if a queen can be placed
    static boolean canPlace(int board[][], int row, int column){
        // Check upper left diagonal
        for(int r = row, c = column; r >= 0 && c >= 0; r--, c--){ 
            if(board[r][c] == 1){
                return false; 
            }
        }
        // Check upper right diagonal
        for(int r = row, c = column; r >= 0 && c < board.length; r--, c++){
            if(board[r][c] == 1){
                return false; 
            }
        }
        // Check row
        for(int c = 0; c < column; c++){
            if(board[row][c] == 1){
                return false; 
            }
        }
        // Check column
        for(int r = 0; r < row; r++){
            if(board[r][column] == 1){
                return false; 
            }
        }
        return true; 
    }
}
