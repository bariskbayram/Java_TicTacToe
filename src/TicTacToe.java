//Engin Canik - TicTacToe with JAVA!
import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
    static String state = "on";
    public static void main(String[] args) {
        char [][] gameBoard = {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        printGameBoard(gameBoard);
        List<Integer> positionsList = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Scanner scanner = new Scanner(System.in);
        while (state.equals("on")){
            System.out.println("Enter your placement (1-9): ");
            int pos = scanner.nextInt();
            signChooser(gameBoard, pos, "player");
            if (checkWinner().equals(""))
            signChooser(gameBoard, cpuRandomPosition(playerPositions,cpuPositions,positionsList), "cpu");
            printGameBoard(gameBoard);
            System.out.println(playerPositions);
            System.out.println(checkWinner());
        }
    }

    public static int cpuRandomPosition(ArrayList<Integer> playerPositions,ArrayList<Integer> cpuPositions,List<Integer> positionsList){
        Random rand = new Random();
        int cpuPos = positionsList.get(rand.nextInt(positionsList.size()));
        while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
            cpuPos = positionsList.get(rand.nextInt(positionsList.size()));
        }
        return cpuPos;
    }

    public static void printGameBoard(char[][] gameBoard){
        for (char[] row : gameBoard){
            for (char column : row){
                System.out.print(column);
            }
            System.out.println();
        }
    }

    public static void signChooser (char[][] gameBoard,int pos,String user){
        char moveSign;
        if (user.equals("player")){
            moveSign = 'X';
            if (!playerPositions.contains(pos) && ! cpuPositions.contains(pos)){
                playerPositions.add(pos);
                placeSign(gameBoard,pos, moveSign);
            }
            else{
                System.out.println("Please select a empty tile!: ");
                Scanner scan = new Scanner(System.in);
                pos = scan.nextInt();
                signChooser(gameBoard,pos,"player");
            }
        }else {
            moveSign = 'O';
            placeSign(gameBoard,pos,moveSign);
            cpuPositions.add(pos);
        }
    }

    public static void placeSign(char[][] gameBoard, int pos, char moveSign){
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

    public static String checkWinner(){
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
            }else if (playerPositions.size() + cpuPositions.size() == 9){
                state = "off";
                return "Draw!";
            }
        }
        return "";
    }

}
