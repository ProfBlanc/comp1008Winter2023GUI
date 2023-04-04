package ca.georgiancollege.comp1008winter2023gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
