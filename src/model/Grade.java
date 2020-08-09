package model;

/**
 * @author ismail 2020
 * @project LMD university system
 **/
public class Grade {

    private int id;
    private String code;

    public Grade(int id, String code) {
        this.id = id;
        this.code = code;
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
}
