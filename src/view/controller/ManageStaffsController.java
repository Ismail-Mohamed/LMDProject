package view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import db.DBConnection;
import dbController.StaffController;
import dbController.StudentController;
import model.Staff;
import model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ismail
 * @project LMD university system
 **/
public class ManageStaffsController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane root;

    @FXML
    private TextField empNoField;

    @FXML
    private TextField teacherNameField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField doaField;


    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;


    @FXML
    private JFXButton deleteStaff;

    @FXML
    private JFXButton update;

    @FXML
    private TextField genderField;

    @FXML
    private TextField EmpNo;

    @FXML
    private JFXButton searchStaff;

    @FXML
    private TextField empName;

    @FXML
    private JFXButton searchByName;


    @FXML
    private JFXButton printStaff;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void searchByName(ActionEvent event) {
        try {
            String teacherName = empName.getText();
            Staff s = StaffController.searchStaffByName(teacherName);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                dobField.setText(s.getDob());
                doaField.setText(s.getDoa());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                dobField.setText(null);
                doaField.setText(null);
                genderField.setText(null);
                emailField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(EmpNo.getText());
            Staff s = StaffController.searchStaff(empNo);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                dobField.setText(s.getDob());
                doaField.setText(s.getDoa());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                dobField.setText(null);
                doaField.setText(null);
                genderField.setText(null);
                emailField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deleteStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(empNoField.getText());

            if(!empNoField.getText().isEmpty()){

                int deleteStaff = StaffController.deleteStaff(empNo);
                if (deleteStaff > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff " + empNo + " Has Been Deleted Sucessfully..!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    genderField.setText(null);
                    emailField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There is an error deleting Staff..!");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Delete Student");
                alert.setHeaderText(null);
                alert.setContentText("you should fill the Student ID field");
                alert.showAndWait();
            }
        } catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void printStaff(ActionEvent event) {/*
        try {
            String empNo = empNoField.getText();

            InputStream report1 = getClass().getResourceAsStream("/Reports/StaffInfo.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/StaffInfoPast.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            if(empNoOld.getText().isEmpty()){

                JasperDesign jd = JRXmlLoader.load(report1);
                query.setText("select * from staffs where empNo = '" + empNo + "'");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);
            }

        } catch (JRException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    void update(ActionEvent event) {
        try {

            ValidationController v = new ValidationController();

            if(v.validateEmpty(empNoField)&& v.validateEmpty(teacherNameField)&& v.validateEmpty(dobField)
                    && v.validateEmpty(doaField)&& v.validateEmpty(phoneField)&& v.validateDate(dobField)&& v.validateDate(doaField)&& v.validatePhone(phoneField)&& v.numbersOnly(empNoField)&& v.numbersOnly(phoneField)){


                int empNo = Integer.parseInt(empNoField.getText());
                String teacherName = teacherNameField.getText();
                String dob = dobField.getText();
                String doa = doaField.getText();
                String gender = genderField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Staff s = new Staff(empNo, teacherName, dob, doa, gender, email, phone, address);
                int i = StaffController.updateStaff(s);

                if (i > 0){

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff Informations Updated Successfully..!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    genderField.setText(null);
                    emailField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPS there is an error updating Staff..!");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

