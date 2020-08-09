package model;

/**
 * @author ismail 2020
 * @project LMD university system
 **/
public class Staff {

    private int id;
    private int idNum;
    private String firstName;
    private String lastName;
    private String DOB;
    private String gender;
    private String educationGrade;
    private int departmentID;
    private String phone;
    private String address;

    public Staff(int id, int idNum, String firstName, String lastName, String DOB, String gender, String educationGrade, int departmentID, String phone, String address) {
        this.id = id;
        this.idNum = idNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.gender = gender;
        this.educationGrade = educationGrade;
        this.departmentID = departmentID;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducationGrade() {
        return educationGrade;
    }

    public void setEducationGrade(String educationGrade) {
        this.educationGrade = educationGrade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
}
