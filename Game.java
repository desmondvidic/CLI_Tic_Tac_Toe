import java.util.Scanner;

public class Game {

    public static void printboard(char[][] fr) {
        System.out.print(' ');
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(fr[i][j] + " | ");
            System.out.print("\n");
            for (int k = 0; k < 3; k++)
                System.out.print("---+");
            System.out.print("\n ");
        }
    }

    public static boolean win(char[][] fr, char player) {

        for (int i = 0; i < 3; i++) {
            // checking for matching row
            if (fr[i][0] == player && fr[i][1] == player && fr[i][2] == player)
                return true;

            // checking for matching colummn
            if (fr[0][i] == player && fr[1][i] == player && fr[2][i] == player)
                return true;
        }
        // checking for left diagonal
        if (fr[0][0] == player && fr[1][1] == player && fr[2][2] == player)
            return true;

        // checking for right diagonal
        if (fr[0][2] == player && fr[1][1] == player && fr[2][0] == player)
            return true;

        return false;
    }

    public static boolean isfull(char[][] fr)
    {
        for (char[] row : fr)
            for (char c : row) 
                if (c == ' ')
                    return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char fr[][] = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                fr[i][j] = ' ';

        char player = 'X';
        boolean game = false;

        System.out.println("Enter Your Position : ");

        while (!game) {
            printboard(fr);
            System.out.print("Player " + player + " Move : ");
            int r = s.nextInt();
            int c = s.nextInt();
            if (fr[r][c] == ' ') {
                fr[r][c] = player;
                game = win(fr, player);
                if (game) {
                    System.out.println("Player " + player + " Wins !");
                    break;
                } else {
                    game = isfull(fr);
                    if(game)
                        System.out.println("Board full. No one Wins!");
                    
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Move.");
            }
        }
    }
}
