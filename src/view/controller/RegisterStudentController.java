package view.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import dbController.GradeController;
import dbController.StudentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Student;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Ismail
 * @project LMD university system
 **/

public class RegisterStudentController implements Initializable {
    @FXML
    private TextField adNoField;

    @FXML
    private TextField fullNameField;


    @FXML
    private TextField dobField;

    @FXML
    private TextField doaField;

    @FXML
    private ComboBox<String> loadGrades;

    @FXML
    private ComboBox<Character> loadSections;

    @FXML
    private ComboBox<String> loadGroups;

    @FXML
    private JFXRadioButton genderField;

    @FXML
    private ToggleGroup g;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton Back;

    @FXML
    private AnchorPane root;



    @Override
    public void initialize(URL location, ResourceBundle resources){
        loadGrades();
        loadGroups();
        loadSections();
    }

    @FXML
    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/StudentManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void AddStudent(ActionEvent event) {
        try {

            ValidationController v = new ValidationController();

           // if(ValidationController.validateEmpty(adNoField)) //This can be used for Static Methods

            if (v.validateEmpty(adNoField) && v.validateEmpty(dobField) && v.validateEmpty(doaField) && v.validateEmpty(phoneField) && v.numbersOnly(adNoField)
                    && v.validatePhone(phoneField) && v.validateDate(doaField) && v.validateDate(dobField)) {


                int adNo = Integer.parseInt(adNoField.getText());
                String fullName = fullNameField.getText();
                String dob = dobField.getText();
                String doa = doaField.getText();
                RadioButton selectedRadioButton = (RadioButton) g.getSelectedToggle(); //Getting Selected Radio Button
                String gender  = selectedRadioButton.getText();
                int grade   = getIdGrade(loadGrades.getValue());
                int group   = getIdOfGroup(loadGroups.getValue());
                int section = getIdOfSection(loadSections.getValue());
                String phone   = phoneField.getText();
                String address = addressField.getText();

                Student s = new Student(adNo, fullName, dob, doa, gender, grade, section, group, phone, address);
                int i = StudentController.AddStudent(s);

                if (i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID " + adNo + " Registered Successfully..!");
                    alert.showAndWait();

                    adNoField.setText(null);
                    fullNameField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    loadGrades.setValue(null);
                    loadSections.setValue(null);
                    loadGroups.setValue(null);
                    adNoField.setText(null);
                    phoneField.setText(null);
                    fullNameField.setText(null);
                    addressField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Student Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPs there is an error adding Student");
                    alert.showAndWait();
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void reset() {

        adNoField.setText(null);
        fullNameField.setText(null);
        dobField.setText(null);
        doaField.setText(null);
        loadGrades.setValue(null);
        loadSections.setValue(null);
        loadGroups.setValue(null);
        adNoField.setText(null);
        phoneField.setText(null);
        fullNameField.setText(null);
        addressField.setText(null);
    }

    @FXML
    private void loadGrades(){
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null){
            loadGrades.setItems(observableArray);
        }

    }
    @FXML
    private void loadGroups(){
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null){
            loadGroups.setItems(observableArray);
        }

    }
    @FXML
    private void loadSections(){
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null){
            loadSections.setItems(observableArray);
        }

    }
    private int getIdOfSection(char sectoinChar) {
        int ascii = (int) sectoinChar;
        int shift = ascii > 90 ? ascii-96 : ascii-64;
        return shift;
    }
    private int getIdOfGroup(String groupStr) {
        groupStr   =  groupStr.substring(1);
        return Integer.parseInt(groupStr);
    }
    private int getIdGrade(String gradeStr) {
        boolean chek_M = gradeStr.charAt(0) == 'M';
        gradeStr       = gradeStr.substring(1);

        if(chek_M) {
            return Integer.parseInt(gradeStr) + 3;
        } else {
            return Integer.parseInt(gradeStr);
        }
    }


}



