package TicTacToe;
import java.util.Random;

public class TicTacToe{
    int[][] board = {
                     {0,0,0},
                     {0,0,0},
                     {0,0,0}
                    };
    int compChoice;
    int playerChoice;
    int canPlay;
    TicTacToe(char pchoice){
        switch (pchoice) {
            case 'X':
                this.playerChoice = 1;
                this.compChoice = 2;
                this.canPlay = 1;
                break;
            case 'O':
                this.playerChoice = 2;
                this.compChoice = 1;
                this.canPlay = 1;
            default:
                System.out.println("Choice not availabe!!!");
                this.canPlay = 0;
                break;
        }
    }

    void displayBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j]==0){
                    System.out.print(" ");
                } else if (board[i][j]==1){
                    System.out.print("X");
                } else if (board[i][j]==2){
                    System.out.print("O");
                }
                if (j!=2){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i!=2){
                System.out.println("----------");
            }
        }
    }

    void compTurn(){
        Random choose = new Random();
        int choice = choose.nextInt(9);
        int flag = 1;
        while (flag==1) {
            if (board[choice/3][choice%3] == 0){
                flag = 0;
            } else{
                choice = choose.nextInt(9);
            }
        }
        board[choice/3][choice%3] = this.compChoice;
    }

    int playerTurn(int pchoice){
        pchoice = pchoice-1;
        if (board[pchoice/3][pchoice%3]==0){
            board[pchoice/3][pchoice%3] = this.playerChoice;
            return 0;
        } else {
            return -1;
        }
    }

    int winner(){
        int[][] winnning_combos = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
        for (int i = 0; i < winnning_combos.length; i++){
            if (board[winnning_combos[i][0]/3][winnning_combos[i][0]%3]==board[winnning_combos[i][1]/3][winnning_combos[i][1]%3] && board[winnning_combos[i][0]/3][winnning_combos[i][0]%3]==board[winnning_combos[i][2]/3][winnning_combos[i][2]%3]){
                if (board[winnning_combos[i][0]/3][winnning_combos[i][0]%3]==playerChoice){
                    return 1;
                }else if (board[winnning_combos[i][0]/3][winnning_combos[i][0]%3]==compChoice) {
                    return -1;
                }
            }
        }
        return 0;
    }

    int possible(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j]==0){
                    return 1;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        TicTacToe game = new TicTacToe('X');
        game.displayBoard();
        System.out.println();
        System.out.println();
        game.playerTurn(1);
        game.playerTurn(5);
        game.playerTurn(9);
        game.displayBoard();
        System.out.println(game.winner());
    }
}