import java.util.Scanner;

public class TicTacToe {
    // Define the number of rows and columns in the game board

    private static final int ROW = 3;
    private static final int COL = 3;

    // Create a 2D array to represent the game board

    private static String[][] board = new String[ROW][COL];

    // Set the starting player to X

    private static String player = "X";

    // Defining isTie
    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Initialize the game board with empty spaces

        clearBoard();

        // Display the initial state of the game board

        display();

        // Loop until a player wins or the game ends in a tie

        while (!isWin(player) && !isTie()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Player " + player + "'s turn");
            System.out.print("Enter row number (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter column number (1-3): ");
            int col = scanner.nextInt() - 1;
            // Check if the move is valid

            if (isValidMove(row, col)) {
                board[row][col] = player;
                player = player.equals("X") ? "O" : "X";
                display();
            } else {
                // If the move is not valid, prompt the player to try again

                System.out.println("Invalid move. Please try again.");
            }
        }
        // Display the outcome of the game

        if (isWin(player)) {
            System.out.println("Player " + player + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
    // Set all cells of the game board to empty spaces

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }
    // Display the current state of the game board

    private static void display() {
        System.out.println("  1 2 3");
        for (int i = 0; i < ROW; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j]);
                if (j < COL - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < ROW - 1) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }
    // Check if a given move is valid

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            // If the specified row and column are out of bounds, the move is not valid

            return false;
        }
        return board[row][col].equals(" ");
        // If the specified cell is already occupied, the move is not valid

    }
    // Check if the specified player has won the game

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }
// This method checks if the player has won by checking for a win condition in each column.

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }
// This method checks if the player has won by checking for a win condition in each row.

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
// This method checks if the player has won by checking for a win condition in each diagonal.

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
}