package org.example.lambdas.ex4;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {


    }
    Map<Integer, List<Employee>> getEmployeesByAge(Company company) {
        List<Employee> employees = new ArrayList<>();
        for (Department department : company.getDepartments()) {
            for (Employee employee : department.getEmployees()) {
                if (employee != null) {
                    employees.add(employee);
                }
            }
        }

        Map<Integer, List<Employee>> employeesByAge = new HashMap<>();
        for (Employee employee : employees) {
            int age = employee.getAge();
            if (!employeesByAge.containsKey(age)) {
                employeesByAge.put(age, new ArrayList<>());
            }
            employeesByAge.get(age).add(employee);
        }

        return employeesByAge;
    }
    Map<Integer, List<Employee>> getEmployeesByAge2(Company company) {
        return company.getDepartments()
                .stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Employee::getAge));
    }


}
class Company {
    List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }
}

class Department {
    public List<Employee> getEmployees() {
        return employees;
    }

    List<Employee> employees;
}

class Employee {
    public int getAge() {
        return age;
    }

    int age;
}
