package Entity;

public class Technician extends Staff {
    private double overtimePay;

    public Technician() {;}
    public Technician(String name, double salary, double overtimePay) {
        super(name, salary);
        this.overtimePay = overtimePay;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    @Override
    public double getPaid(){
        return super.getSalary() + this.overtimePay;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + ", Salary: " + super.getSalary() + ", OvertimePay: " + this.overtimePay + ", Paid: " + getPaid();
    }
}