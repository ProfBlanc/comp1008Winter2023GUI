package ca.georgiancollege.comp1008winter2023gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MemoryMatchingController {

    private String[] colors = {"red", "blue", "green"};
    private final String defaultBox = "black";
    private final String defaultCorrectlyGuessedBox = "grey";

    private ArrayList<ImageView> listOfBoxes = new ArrayList<>();
    private String[] listOfColors = {"","","","","",""};

    private final int MAX_NUM_BOXES = 6;

    private Random random = new Random();


    private final Path rootImageDirectory = Paths.get("src/main/resources/ca/georgiancollege/" +
            "comp1008winter2023gui/images") ;



    @FXML
    private ImageView b1,b2,b3,b4,b5,b6;

    @FXML
    private Label error;

    private int numberOfUserClicks = 0;

    private ArrayList<String> whichBoxesUserClickedOn = new ArrayList<>();
    private ArrayList<ImageView> historyOfImageViewClicked = new ArrayList<>();

    @FXML
    void onBoxClick(MouseEvent event) throws Exception{
        if(numberOfUserClicks == 2){
            //determine if two colors chosen match
            if(whichBoxesUserClickedOn.get(0).equals(whichBoxesUserClickedOn.get(1))){
                System.out.println("Correctly Guessed!");
                error.setText("");

                for(ImageView current : historyOfImageViewClicked){

                    current.setImage(new Image(new FileInputStream(rootImageDirectory + "/" + "grey.png")));
                    current.setDisable(true);
                }
            }
            else{
                error.setText("Incorrect guess");
                for(ImageView current : historyOfImageViewClicked){
                    current.setImage(new Image(new FileInputStream(rootImageDirectory + "/" + "black.png")));
                }
            }

            //reset number of user clicks
            numberOfUserClicks = 0;
            whichBoxesUserClickedOn.clear();
            historyOfImageViewClicked.clear();
            return;
        }
        numberOfUserClicks++;



        System.out.println(rootImageDirectory);

        ImageView clicked = (ImageView) event.getSource();

        historyOfImageViewClicked.add(clicked);

        System.out.println(clicked.getId());
        String clickedId = clicked.getId();
        int clickedIndex = Integer.parseInt(clickedId.substring(1));
        clickedIndex--;

        System.out.println("image path = " + clicked.getImage().getUrl());

        String colorToSet = listOfColors[clickedIndex];

        whichBoxesUserClickedOn.add(colorToSet);




            clicked.setImage(
                    new Image(
                            new FileInputStream(
                                    rootImageDirectory + "/" + colorToSet + ".png")));

        System.out.println("Guesses Count = " + numberOfUserClicks);

    }

    @FXML
    void initialize(){

        error.setText("");
        listOfBoxes.add(b1);
        listOfBoxes.add(b2);
        listOfBoxes.add(b3);
        listOfBoxes.add(b4);
        listOfBoxes.add(b5);
        listOfBoxes.add(b6);


        for(String currentColor : colors){
            int tracker = 0;

            while(true){
                //choose random index
                int randomIndex = random.nextInt(MAX_NUM_BOXES);
                //determine if random index of listOfColors is filled
                if(listOfColors[randomIndex].length() == 0){
                    listOfColors[randomIndex] = currentColor;
                    tracker++;
                    if(tracker == 2)
                        break;
                }

            }

        }

        for(String val : listOfColors){
            System.out.println(val);
        }

    }

}
