import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUI extends JFrame {
    private JPanel mainPanel;
    private JPanel buttonsPanel;
    private JButton button1;
    private JButton button4;
    private JButton button7;
    private JButton button2;
    private JButton button5;
    private JButton button3;
    private JButton button6;
    private JButton button8;
    private JButton button9;
    private JButton restartButton;
    private JLabel label1;
    private JLabel label2;
    private List<JButton> buttonList = new LinkedList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
    private HashMap<JButton,Boolean> buttonMap = new HashMap<>();
    private TicTacToe ticTacToe;
    private String[] status;
    private Image image1;
    private Image image2;
    private Image image3;
    private Player mp3player;

    public GUI(TicTacToe ticTacToe){
        this.ticTacToe = ticTacToe;
        getImage();
        putButtonsToMap();
        putActions();
    }

    private void putButtonsToMap() {
        for (JButton button : buttonList){
            buttonMap.put(button,true);
            button.setIcon(new ImageIcon(image3));
            button.setBackground(Color.WHITE);
        }
        restartButton.setBackground(Color.WHITE);
    }

    private boolean changeButtonBackground(JButton button, String user){
        if(buttonMap.get(button)==false)
            return false;
        else{
            if(user.equals("cpu"))
                button.setIcon(new ImageIcon(image2));
            else
                button.setIcon(new ImageIcon(image1));
        }
        return true;
    }

    public void playMusic() {
        String song = "https://mp3yukleindir.mobi/mp3_files/8b75f51579720a62bcf9442b9b5933aa.mp3";
        mp3player = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new URL(song).openStream());
            mp3player = new Player(in);
            mp3player.play();
        } catch (MalformedURLException ex) {
        } catch (IOException e) {
        } catch (JavaLayerException e) {
        } catch (NullPointerException ex) {
        }
    }

    public void executeThreads(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(this::playMusic);
        executorService.submit(this::start);

        executorService.shutdown();
    }

    private void putActions() {
        button1.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button1,"player"))
                return;
            status = ticTacToe.singleTurn(1);
            buttonMap.put(button1,false);
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        button2.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button2,"player"))
                return;
            status = ticTacToe.singleTurn(2);
            buttonMap.put(button2,false);
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        button3.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button3,"player"))
                return;
            status = ticTacToe.singleTurn(3);
            buttonMap.put(button3,false);
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });
        button4.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button4,"player"))
                return;
            status = ticTacToe.singleTurn(4);
            buttonMap.put(button4,false);
            button4.setIcon(new ImageIcon(image1));
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        button5.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button5,"player"))
                return;
            status = ticTacToe.singleTurn(5);
            buttonMap.put(button5,false);
            button5.setIcon(new ImageIcon(image1));
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        button6.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button6,"player"))
                return;
            status = ticTacToe.singleTurn(6);
            buttonMap.put(button6,false);
            button6.setIcon(new ImageIcon(image1));
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        button7.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button7,"player"))
                return;
            status = ticTacToe.singleTurn(7);
            buttonMap.put(button7,false);
            button7.setIcon(new ImageIcon(image1));
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        button8.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button8,"player"))
                return;
            status = ticTacToe.singleTurn(8);
            buttonMap.put(button8,false);
            button8.setIcon(new ImageIcon(image1));
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        button9.addActionListener(ActionEvent -> {
            if(!changeButtonBackground(button9,"player"))
                return;
            status = ticTacToe.singleTurn(9);
            buttonMap.put(button9,false);
            button9.setIcon(new ImageIcon(image1));
            if(status[0].equals("off")){
                disableButtons();
                label1.setText("Game situtation: " + status[1]);
                label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
            }
        });

        restartButton.addActionListener(ActionEvent -> {
            this.dispose();
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.startGame();
        });
    }

    private void disableButtons() {
        if(status[1] == "Congrats You Won!")
            TicTacToe.gameStatistics[1]+=10;
        else
            TicTacToe.gameStatistics[1]-=20;
        for(JButton button : buttonList){
            buttonMap.put(button,false);
        }
    }

    public void changeButtonForCpuChoice(int location){
        JButton buttonTemp = buttonList.get(location-1);
        changeButtonBackground(buttonTemp,"cpu");
        buttonMap.put(buttonTemp, false);
    }

    private void getImage(){
        try {
            image1 = ImageIO.read(getClass().getResource("image1.jpg"));
            image2 = ImageIO.read(getClass().getResource("image2.jpg"));
            image3 = ImageIO.read(getClass().getResource("image3.jpeg"));
        } catch (Exception ex) {
        }
    }

    public void start() {
        label2.setText("TotalGames/TotalPoints: " + TicTacToe.gameStatistics[0] + "/" + TicTacToe.gameStatistics[1]);
        this.setTitle("TicTacToe");
        this.setLocation(400,150);
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
