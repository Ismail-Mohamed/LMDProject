package view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import db.DBConnection;
import dbController.StudentController;
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
 * @author ismail 2020
 **/

public class ManageStudentsController implements Initializable {

    public ManageStudentsController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane manageStudents;

    @FXML
    private TextField AdNo;

    @FXML
    private TextField adNoField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField doaField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField gradeField;


    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton searchStudent;

    @FXML
    private JFXButton btnPrint;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/StudentManagement.fxml")));
            manageStudents.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }
// Delete Method
    @FXML
    void btnDelete(ActionEvent event) {
        try {
            String adNo = adNoField.getText();

            if(!AdNo.getText().isEmpty()){


                    int deleteStudent = StudentController.deleteStudent(adNo);
                    if (deleteStudent > 0) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Delete Student");
                        alert.setHeaderText(null);
                        alert.setContentText("Student " + adNo + " has been deleted sucessfully..!");
                        alert.showAndWait();

                        AdNo.setText(null);
                        adNoField.setText(null);
                        fullNameField.setText(null);
                        dobField.setText(null);
                        doaField.setText(null);
                        gradeField.setText(null);
                        genderField.setText(null);
                        phoneField.setText(null);
                        addressField.setText(null);


                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Delete Student");
                        alert.setHeaderText(null);
                        alert.setContentText("There is an error deleting Student");
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
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    void btnPrint(ActionEvent event) {

        String adNo = adNoField.getText();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            InputStream report1 = getClass().getResourceAsStream("/Reports/StudentAdmission.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            JasperDesign jd = JRXmlLoader.load(report1);
            query.setText("select * from students where adNo = '" + adNo + "'");
            jd.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    //Update Method
    @FXML
    void btnUpdate(ActionEvent event) throws SQLException {
        try {

            ValidationController v = new ValidationController();


            if ( v.numbersOnly(adNoField) && v.validatePhone(phoneField)) {

                int adNo = Integer.parseInt(adNoField.getText());
                String fullName = fullNameField.getText();
                String dob = dobField.getText();
                String doa = doaField.getText();
                String gender = genderField.getText();
                String grade = gradeField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Student s = new Student(adNo, fullName, dob, doa, gender, grade, section, group, phone, address);
                int i = StudentController.updateStudent(s);

                if (i > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Student " + adNo + " Updated Successfully..!");
                    alert.showAndWait();

                    AdNo.setText(null);
                    adNoField.setText(null);
                    fullNameField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    gradeField.setText(null);
                    genderField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Student Management");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPs there is an error updating Student..!");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    //Search Method
    @FXML
    void searchStudent(ActionEvent event) {
        try {
            int adNo = Integer.parseInt(AdNo.getText());
            Student s = StudentController.searchStudent(adNo);
            if (s != null) {
                adNoField.setText(String.valueOf(s.getAdNo()));
                fullNameField.setText(s.getFullName());
                dobField.setText(s.getDob());
                doaField.setText(s.getDoa());
                genderField.setText(s.getGender());
                gradeField.setText(s.getGrade());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();

                AdNo.setText(null);
                adNoField.setText(null);
                fullNameField.setText(null);
                dobField.setText(null);
                doaField.setText(null);
                gradeField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




