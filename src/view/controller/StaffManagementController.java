package view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ismail
 * @project LMD university system
 **/
public class StaffManagementController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane studentManagement;

    @FXML
    private ImageView StaffMgmt;

    @FXML
    private ImageView StudentMgmt;

    @FXML
    private JFXButton btnStaffReg;

    @FXML
    private JFXButton btnStaffMnge;

    @FXML
    private ImageView StaffMgmt1;

    @FXML
    private JFXButton btnPrintStaff;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/MainDashboard.fxml")));
            studentManagement.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void btnPrintStaff(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/PrintStaffs.fxml")));
            studentManagement.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void btnStaffMnge(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/ManageStaffs.fxml")));
            studentManagement.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void btnStaffReg(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/RegisterStaff.fxml")));
            studentManagement.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }


}
