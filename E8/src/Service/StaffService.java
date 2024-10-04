package Service;

import Entity.Staff;
import Global.Global;

import java.util.List;
import java.util.Optional;

public class StaffService {
    private final List<Staff> staff;

    public StaffService(List<Staff> staff) {
        this.staff = staff;
    }

    public Optional<Staff> getStaffById(int id) {
        return staff.stream().
                filter(staff -> staff.getId() == id)
                .findFirst();
    }
    public Optional<Staff> getStaffByCode(String code) {
        return staff.stream()
                .filter(staff -> staff.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public List<Staff> getStaffByName(String name) {
        return staff.stream()
                .filter(staff -> Global.ignoreCase(staff.getName(), name))
                .toList();
    }
}
