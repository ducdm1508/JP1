package Controller;

import Entity.Gender;
import Entity.Staff;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StaffController {

    private static List<Staff> staffs;
    public StaffController(List<Staff> staffs) {
        StaffController.staffs = staffs;
    }

    public  Optional<Staff> getFByPay() {
        Optional<Staff> femaleByPay =  staffs.stream()
                .filter(s ->s.getGender() == Gender.F)
                .max(Comparator.comparingDouble(Staff::getPay));
        return femaleByPay;
    }

    public static List<Staff> getStaffsById(String keyword) {
        return staffs.stream()
                .filter(staff -> staff.getStaffID().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
    public static List<Staff> getStaffsByName(String keyword) {
        return staffs.stream()
                .filter(staff -> staff.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public static void changeName(String staffId, String newName) {
        staffs.stream()
                .filter(staff -> staff.getStaffID().equalsIgnoreCase(staffId))
                .forEach(staff -> staff.setName(newName));
    }
}
