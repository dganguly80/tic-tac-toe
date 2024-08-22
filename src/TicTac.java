import java.util.Scanner;

import static java.lang.System.*;
public class TicTac {

    public void finalResult(String winner){
        out.println("Winner is: " +  winner);
    }

    public static int[] checkWinner(String[] updatedGrid, int playerNumber){
        String playerChar;
        int[] playerMovements=new int[updatedGrid.length];
        if(playerNumber==1)
            {
                playerChar="X";
            }
        else{
            playerChar="O";
        }
        for(int i=0,m=0;i<updatedGrid.length;i++){
            if(updatedGrid[i].equals(playerChar)){
                playerMovements[m]=i;
                m++;
            }
        }
        System.out.println(playerMovements);
        return playerMovements;

    }

//    public void player
    public static void printCurrentGrid(String[] currentGrid){
        out.println(currentGrid[0]+"     |   "+currentGrid[1]+"  |    "+currentGrid[2]);
        out.println("------|------|------");
        out.println(currentGrid[3]+"     |   "+currentGrid[4]+"  |    "+currentGrid[5]);
        out.println("------|------|------");
        out.println(currentGrid[6]+"     |   "+currentGrid[7]+"  |    "+currentGrid[8]);
    }
    public static int mapInput(String userInput) {
        String[] heatmap = {"TopLeft", "TopCenter", "TopRight", "MiddleLeft", "MiddleCenter", "MiddleRight", "BottomLeft", "BottomCenter", "BottomRight"};
        int i;
        for (i = 0; i < heatmap.length; i++) {
            if (userInput.equals(heatmap[i])) {
                break;
            }
        }
        return i;
    }

    public static String[] playerMove(int playerNum, String[] grid){
        Scanner tictacUser=new Scanner(in);
        out.println("Player " +playerNum+" make your move");
        //String myAnswer;
        String playerRes=tictacUser.nextLine();
        //System.out.println(myAnswer);
        switch(playerNum) {
            case 1:
                grid[mapInput(playerRes)] = "X";
                break;

            case 2:
                grid[mapInput(playerRes)]="O";
                break;
        }
        printCurrentGrid(grid);
         return grid;
    }



    public  static void main(String[] args) {


        String[] gridTicTac = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        int[] solution = new int[gridTicTac.length];
        boolean gameFinish;
        System.out.println("hello - Starting the tic-tac-toe game");
//        boolean gameFinish=False;
        //While(!gameFinish){
            gridTicTac = playerMove(1, gridTicTac);
            gridTicTac = playerMove(2, gridTicTac);
            gridTicTac = playerMove(1, gridTicTac);
            solution= checkWinner(gridTicTac,1);

        //}


        /*printCurrentGrid(gridTicTac);
        Scanner tictacUser=new Scanner(System.in);
        System.out.println("Player 1 make your move");
        String myAnswer;
        myAnswer=tictacUser.nextLine();
        System.out.println(myAnswer);
        gridTicTac[mapInput(myAnswer)]="X";
        printCurrentGrid(gridTicTac);
        System.out.println("Player 2 make your move");
        myAnswer=tictacUser.nextLine();
        System.out.println(myAnswer);
        gridTicTac[mapInput(myAnswer)]="O";
        printCurrentGrid(gridTicTac);
        */

    }

}
