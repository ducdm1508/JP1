package Controller;

import Entity.Staff;
import Service.StaffService;

import java.util.List;
import java.util.Optional;

public class StaffController {

    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    public Optional<Staff> getStaffById(int id) {
        return staffService.getStaffById(id);
    }

    public Optional<Staff> getStaffByCode(String code) {
        return staffService.getStaffByCode(code);
    }

    public List<Staff> getStaffByName(String name) {
        return staffService.getStaffByName(name);
    }
}
