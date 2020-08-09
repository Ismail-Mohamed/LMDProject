package model;

public class Unit {

    private int id ;
    private String code ;
    private String name;
    private int coefficient;
    private  int credit ;
    private int semesterId;

    public Unit(int id, String code, String name, int coefficient, int credit, int semesterId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.coefficient = coefficient;
        this.credit = credit;
        this.semesterId = semesterId;
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

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
