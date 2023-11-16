package library;

public class Librarian {

    private String name, employeeId;

    public Librarian(String name, String employeeId) { // constructor
        this.name = name;
        this.employeeId = employeeId;
    }
    
//    Getters and Setter for ensuring encapsulation
     public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}