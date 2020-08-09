package model;

public class StudentCourse {

      private int studentID;
      private  int courseID;
      private float note;

    public StudentCourse(int studentID, int courseID, float note) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.note = note;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
