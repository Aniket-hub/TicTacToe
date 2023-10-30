import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // Initially all spaces empty
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        boolean gameOver = false;
        char player = 'X';

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player: "+player+" Enter coordinates: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = currPlayerHaveOwn(board, player);

                if (gameOver) {
                    System.out.println("Player "+player+" has Own!");
                    return;
                }
                else {
                    player = (player == 'X') ? 'O' : 'X';
                }

            }
            else {
                System.out.println("Invalid Move!");
            }

        }

    }

    private static boolean currPlayerHaveOwn(char[][] board, char player) {
        // Row Check
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        //Column check
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Diagonal Check
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print("| " + board[row][col] + " |");
            }
            System.out.println();
        }
    }
}
