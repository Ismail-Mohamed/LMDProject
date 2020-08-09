package model;

public class Department {

      private int id ;
      private String code;
      private String name;
      private String description;
      private String admin;

    public Department(int id, String code, String name, String description, String admin) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.admin = admin;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
