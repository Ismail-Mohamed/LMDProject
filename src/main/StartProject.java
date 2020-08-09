package main;

import dbController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
//=====================================================================
import model.*;
/*

public class StartProject extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        launch(args);


    }

}

*/

public class StartProject extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // test data manipulation only



        HashMap<String,String> a = GroupController.getGroups();

        System.out.println(a);

    }

}
