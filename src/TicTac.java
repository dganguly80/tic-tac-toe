//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;
public class TicTac {


   /* public void finalResult(String winner){
        out.println("Winner is: " +  winner);
    } */

    public static int[] checkWinner(String[] updatedGrid, int playerNumber){
        String playerChar;
        int[] playerMovements={-1, -1, -1, -1, -1, -1, -1, -1, -1};
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
        System.out.println(Arrays.toString(playerMovements));
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

    public static boolean winChecker(int[] moveTracker, int[] winPattern){
        int winFlag=0;
        Arrays.sort(moveTracker);
             for(int myMove=0,patternIndex=0;myMove<moveTracker.length;myMove++){
                 if(moveTracker[myMove]==winPattern[patternIndex]){
                        patternIndex++;
                        winFlag++;
                        if (winFlag==3){
                            System.out.println("Winner");
                            return true;
                        }
                 }
             }
             return false;
    }




    public  static void main(String[] args) {

        int[][] winPattern={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        String[] gridTicTac = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        int[] solution = new int[gridTicTac.length];
        //int[] movement = new int[9];
        System.out.println("hello - Starting the tic-tac-toe game");

        boolean gameFinish=false;
        while(!gameFinish){
            gridTicTac = playerMove(1, gridTicTac);
            int[] movement1= checkWinner(gridTicTac,1);
            //check win for player 1
            for(int j=0;j<8;j++){
                boolean isResult=winChecker(movement1,winPattern[j]);
                if(isResult){
                    gameFinish=true;
                    System.out.println("Winner is player 1");
                    exit(0);
                    break;
                }
            }

            gridTicTac = playerMove(2, gridTicTac);
            int[] movement2= checkWinner(gridTicTac,2);
            //check Win for player 2
            for(int j=0;j<8;j++){
                boolean isResult=winChecker(movement2,winPattern[j]);
                if(isResult){
                    gameFinish=true;
                    System.out.println("Winner is player 2");
                    break;
                }
            }

        }

    }

}
