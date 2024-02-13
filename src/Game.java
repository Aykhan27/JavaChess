import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner moveChoice = new Scanner(System.in);

        while (true) {
            Board.startGame();

            int turns = 0;
            Color color;

            while (true) {
                Board.printBoard();

                color = turns % 2 == 0 ? Color.WHITE : Color.BLACK;

                if (Board.staleMate(color)) {
                    System.out.println("Game over, stalemate");
                    break;
                }

                if (Board.checkForCheck(color)) {
                    if (Board.mate(color)) {
                        System.out.printf("Checkmate, %s wins\n", color == Color.WHITE ? "Black" : "White");
                        break;
                    }
                    System.out.printf("%s is in Check!\n", color == Color.WHITE ? "White" : "Black");
                }

                System.out.printf("%s's turn\n", color == Color.WHITE ? "White" : "Black");

                String move = moveChoice.nextLine();

                if (Board.processMove(move, color) == 0) {
                    turns++;
                } else {
                    System.out.println("Illegal move");
                }

            }

            System.out.println("Would you like to play again? (y/n)");
            if (!moveChoice.next().equals("y")) {
                moveChoice.close();
                System.exit(0);
            }
        }
    }
}