package Entity;

public class Staff extends Person {
    private String staffID;
    private String school;
    private Gender gender;
    private double pay;

    public Staff(){;}
    public Staff(String staffID, String name, String school, Gender gender, double pay, String address) {

        super(name, address);
        this.staffID = staffID;
        this.school = school;
        this.gender = gender;
        this.pay = pay;

    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
    @Override
    public String getAddress() {
        return super.getAddress();
    }
    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID + '\'' +
                ", name= " + this.getName() +
                ", school='" + school + '\'' +
                ", gender=" + gender +
                ", pay=" + pay +
                ", address = " + this.getAddress() +
                '}';
    }
}
