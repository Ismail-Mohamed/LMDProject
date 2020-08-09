package model;

public class StaffCourse {

      private int staffID;
      private int courseID;
      private int semesterID;
      private int gradeID;

    public StaffCourse(int staffID, int courseID, int semesterID, int gradeID) {
        this.staffID = staffID;
        this.courseID = courseID;
        this.semesterID = semesterID;
        this.gradeID = gradeID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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
