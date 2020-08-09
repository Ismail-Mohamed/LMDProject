package model;

public class StudentGroup {
      private int studentID;
      private int groupID;
      private int gradeID;

    public StudentGroup(int studentID, int groupID, int gradeID) {
        this.studentID = studentID;
        this.groupID = groupID;
        this.gradeID = gradeID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }
}
