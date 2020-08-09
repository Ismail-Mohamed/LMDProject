package view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import dbController.LoginController;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author ismail 2020
 * @project LMD university system
 **/

public class LoginFormController implements Initializable {

    double x,y;

    @FXML
    private AnchorPane login;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField pwdField;

    @FXML
    private JFXButton Login;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    LoginController log = new LoginController();

    @FXML
    public void Login() {

        String username = usernameField.getText();
        String password = pwdField.getText();

        if(username.isEmpty() || password.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Username & Password Required..!");
            alert.showAndWait();
        }
        else {
                try {
                    if (log.Login(username, password)){

                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/view/fxml/MainDashboard.fxml")));
                        login.getChildren().setAll(user);

                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid Username or Password..!");
                        alert.showAndWait();
                    }

                    } catch(SQLException e){
                        e.printStackTrace();
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    } catch(IOException e){
                        e.printStackTrace();
                    }

                }

    }
    @FXML
    void draged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() -x);
        stage.setY(event.getScreenY() -y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void max(MouseEvent event) {
    /*
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint(" ");
        stage.setFullScreen(true);
    */
    }

    @FXML
    void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

}

