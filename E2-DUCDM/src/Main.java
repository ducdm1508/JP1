import Entity.Employee;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(8, "Peter", "Tan", 2500);
        System.out.println(e1);

        e1.setSalary(999);
        System.out.println(e1);

        System.out.println("Id is: " + e1.getId());
        System.out.println("Firt name is: " + e1.getFirst_name());
        System.out.println("Last name is: " + e1.getLast_name());
        System.out.println("Salary is: " + e1.getSalary());

        System.out.println("Name is: " + e1.getName());
        System.out.println("Annual salaty is: " + e1.getAnnulSalary());

        System.out.println(e1.raiseSalary(10));
        System.out.println(e1);

        Employee[] employees = {
                new Employee(1, "Elon", "Mush", 3000),
                new Employee(2, "Bill", "Gate", 5000),
                new Employee(3, "Jack", "Ma", 2000)
        };
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("Annual salaty is: " + employee.getAnnulSalary());
        }

        Employee maxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getAnnulSalary() > maxSalary.getAnnulSalary()) {
                maxSalary = employee;
            }
        }
        System.out.println("Max annul salary: \n" + maxSalary);


    }
}