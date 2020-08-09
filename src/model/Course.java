package model;

public class Course {

    private int id;
    private String code;
    private String name;
    private int coefficient;
    private int credit;
    private int unit;
    private int semesterID;
    private int gradeID;

    public Course(int id, String code, String name, int coefficient, int credit, int unit, int semesterID, int gradeID) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.coefficient = coefficient;
        this.credit = credit;
        this.unit = unit;
        this.semesterID = semesterID;
        this.gradeID = gradeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }
}
