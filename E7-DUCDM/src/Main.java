import Entity.Manager;
import Entity.Staff;
import Entity.Technician;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Staff> staff = new ArrayList<>();

        staff.add(new Manager("John", 5000, 1000));
        staff.add(new Technician("Jane", 4000, 500));
        staff.add(new Manager("Bob", 5500, 1200));
        staff.forEach(System.out::println);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter staff name to get their pay: ");
        String name = br.readLine();

        staff.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .forEach(s -> System.out.println(s.getName() + " gets paid: " + s.getPaid()));

        System.out.print("Enter 'manager' or 'technician' to display info: ");
        String role = br.readLine().toLowerCase();

        Optional<Staff> display = staff.stream()
                .filter(s -> (role.equals("manager") && s instanceof Manager) ||
                        (role.equals("technician") && s instanceof Technician))
                .findFirst();
        System.out.println(display.get());


    }
}