//Engin Canik && Barış Kaan Bayram - TicTacToe with JAVA!
import java.util.*;

public class TicTacToe {
    public static int[] gameStatistics = {0,0};
    private ArrayList<Integer> playerPositions;
    private ArrayList<Integer> cpuPositions;
    private String state;
    private GUI gui;
    private String result;
    private char [][] gameBoard = {{' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '}};

    public TicTacToe(){
        playerPositions = new ArrayList<>();
        cpuPositions = new ArrayList<>();
        state = "on";
    }

    public void startGame(){
        gui = new GUI(this);
        if(gameStatistics[0] == 0)
            gui.executeThreads();
        else
            gui.start();
        gameStatistics[0]+=1;
    }

    public String[] singleTurn(int location){
        List<Integer> positionsList = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        signChooser(gameBoard, location, "player");
        result = checkWinner();
        if(state.equals("off"))
            return new String[]{state, result};
        signChooser(gameBoard, cpuRandomPosition(playerPositions, cpuPositions, positionsList), "cpu");
        result = checkWinner();
        if(state.equals("off"))
            return new String[]{state, result};
        return new String[]{state, result};
    }

    private int cpuRandomPosition(ArrayList<Integer> playerPositions,ArrayList<Integer> cpuPositions,List<Integer> positionsList){
        Random rand = new Random();
        int cpuPos = positionsList.get(rand.nextInt(positionsList.size()));
        while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
            cpuPos = positionsList.get(rand.nextInt(positionsList.size()));
        }
        return cpuPos;
    }

    private void signChooser (char[][] gameBoard,int pos,String user){
        char moveSign;
        if (user.equals("player")){
            moveSign = 'X';
            playerPositions.add(pos);
            placeSign(gameBoard,pos, moveSign);
        }else {
            moveSign = 'O';
            placeSign(gameBoard,pos,moveSign);
            cpuPositions.add(pos);
            gui.changeButtonForCpuChoice(pos);
        }
    }

    private void placeSign(char[][] gameBoard, int pos, char moveSign){
        switch (pos) {
            case 1:
                gameBoard[0][0] = moveSign;
                break;
            case 2:
                gameBoard[0][2] = moveSign;
                break;
            case 3:
                gameBoard[0][4] = moveSign;
                break;
            case 4:
                gameBoard[2][0] = moveSign;
                break;
            case 5:
                gameBoard[2][2] = moveSign;
                break;
            case 6:
                gameBoard[2][4] = moveSign;
                break;
            case 7:
                gameBoard[4][0] = moveSign;
                break;
            case 8:
                gameBoard[4][2] = moveSign;
                break;
            case 9:
                gameBoard[4][4] = moveSign;
                break;
            default:
                break;
        }
    }

    private String checkWinner(){
        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);
        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> rightCol = Arrays.asList(3,6,9);
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(7,5,3);

        List<List<Integer>> winConditions = new ArrayList<>();
        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(botRow);
        winConditions.add(leftCol);
        winConditions.add(midCol);
        winConditions.add(rightCol);
        winConditions.add(cross1);
        winConditions.add(cross2);

        for (List<Integer> l : winConditions){
            if (playerPositions.containsAll(l)){
                state = "off";
                return "Congrats You Won!";
            }else if(cpuPositions.containsAll(l)){
                state = "off";
                return "You lost!";
            }
        }
        if (playerPositions.size() + cpuPositions.size() == 9){
            state = "off";
            return "Draw!";
        }
        return "on";
    }
}
