package Entity;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private int salary;

    public Employee(int id, String first_name, String last_name, int salary) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }
    public String getFirst_name() {
        return this.first_name;
    }
    public String getLast_name() {
        return this.last_name;
    }
    public String getName(){
        return this.first_name + " " + this.last_name;
    }
    public int getSalary() {
        return this.salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAnnulSalary(){
        return salary*12;
    }
    public int raiseSalary(int percent){
        salary += salary * percent/100;
        return salary;
    }

    @Override
    public String toString() {
        return "{Id: " + this.getId() + ", Name: " + this.getName() + ", Salary: " + this.getSalary() + "}" ;
    }
}
