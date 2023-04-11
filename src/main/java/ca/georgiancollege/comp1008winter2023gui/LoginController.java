package ca.georgiancollege.comp1008winter2023gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label error;

    @FXML
    void onLogin(ActionEvent event) {

        System.out.println("Clicked on login button");
        error.setText("");
        System.out.println(username.getText());
        System.out.println(password.getText());
        System.out.println("-".repeat(10));

        //determine if username = user & password = pass, output a congrats message
        //else, set the error label to "incorrect credentials"

        if(username.getText().equals("user") && password.getText().equals("pass")){
            System.out.println("Congrats!");

            //create a pop-up message

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congrats");
            alert.setContentText("You shall pass!");
            alert.show();

            //open a new page: tic-tac game

            //attempt to implement the code to open a new page, given the starter code in HelloApplication.java file

            try{
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("memory-matching-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Memory Matching");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();



            }
            catch (Exception e){

                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Error!");
                alert1.setContentText("Could not load Game");
                alert1.show();
            }

        }
        else{
            error.setText("Incorrect Credentials");
        }

    }

    @FXML
    void onRegister(ActionEvent event) {
        System.out.println("Clicked on register button");
        System.out.println("-".repeat(10));

    }
    @FXML
    void initialize(){
        //like the windows.onoload method
        // method will execute right before the stage is shown

        error.setText("");

    }

}
