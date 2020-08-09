package model;

/**
 * @author ismail 2020
 * @project LMD university system
 **/
public class Student {

    private int id;
    private String idNum;
    private String firstName;
    private String lastName;
    private String DOB;
    private String gender;
    private int grade;
    private int section;
    private int group;
    private int department;
    private String phone;
    private String address;

    public Student(int id, String idNum, String firstName, String lastName, String DOB, String gender, int grade, int section, int group, int department, String phone, String address) {
        this.id = id;
        this.idNum = idNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.gender = gender;
        this.grade = grade;
        this.section = section;
        this.group = group;
        this.department = department;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
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

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}