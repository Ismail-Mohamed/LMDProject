package model;

public class Semester {

    private int id ;
    private String name;
    private int gradeID;

    public Semester(int id, String name, int gradeID) {
        this.id = id;
        this.name = name;
        this.gradeID = gradeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }
}
