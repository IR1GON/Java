import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

class Company {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(String name) {
        employees.removeIf(employee -> employee.toString().contains(name));
    }

    public double calculateTotalSalary() {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    public double calculateAverageSalary() {
        return employees.isEmpty() ? 0 : calculateTotalSalary() / employees.size();
    }
}
