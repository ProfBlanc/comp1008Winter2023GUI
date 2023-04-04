module ca.georgiancollege.comp1008winter2023gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.comp1008winter2023gui to javafx.fxml;
    exports ca.georgiancollege.comp1008winter2023gui;
}