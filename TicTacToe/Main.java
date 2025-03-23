package TicTacToe;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int turn;
    public static void main(String[] args) {
        System.out.println("Welcome to the game of");
        System.out.println("----------------------");
        System.out.println("------Tic Tac Toe-----");
        System.out.println("----------------------");
        System.out.println("What will you pick (X/O): ");
        char playerChoice = sc.next().charAt(0);
        TicTacToe game = new TicTacToe(playerChoice);
        if (playerChoice=='X'){
            turn = 1;
        } else {
            turn = 0;
        }
        while (game.winner() == 0 && game.possible()==1) {
            game.displayBoard();
            if (turn==1){
                System.out.println("It's Your turn: ");
                int choice = sc.nextInt();
                int possible = game.playerTurn(choice);
                if (possible==-1){
                    turn = 1;
                } else {
                    turn = 0;
                }
            } else {
                System.out.println("It's Computer turn: ");
                game.compTurn();
                turn = 1;
            }
            System.out.println("\033[H\033[2J");
            System.out.flush();
        } 
        game.displayBoard();
        if (game.winner() == 1){
            System.out.println("You Won!!!");
        } else if (game.winner() == -1){
            System.out.println("Computer won!!!");
        } else {
            System.out.println("Draw");
        }

    }
}
