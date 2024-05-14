package org.example.examples;

import org.example.entities.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employees {

    public static void main(String[] args) {

        // Generate a list of Employees
        List<Employee> employees = Arrays.asList(
                new Employee("Jose", "Monterrey", 35, "CL12"),
                new Employee("Juan", "Ciudad de Mexico", 25, "CL8"),
                new Employee("Pedro", "Monterrey", 19, "CL10"),
                new Employee("Ivan", "Merida", 23, "CL11"),
                new Employee("Kevin", "Merida", 40, "CL12"),
                new Employee("Mariana", "Monterrey", 39, "CL10"),
                new Employee("Ernesto", "Monterrey", 21, "CL9"),
                new Employee("Josh", "Merida", 42, "CL7"),
                new Employee("Karen", "Ciudad de Mexico", 21, "CL9"),
                new Employee("Viridiana", "Merida", 42, "CL7")
        );

        // Example 1 results
        //System.out.println(getEmployeesFromMonterrey(employees));

        // Example 2 results
        //System.out.println(getEmployeesYoungerThan30(employees));

        // Example 3 results
        //System.out.println(groupEmployeesByCity(employees));

        // Example 4 results
        //System.out.format("%d employees are from Merida.", getNumberEmployeesFromMerida(employees));

        // Example 5 results
        //System.out.println(orderEmployeesByAgeDESC(employees));

        // Example 6 results
        //System.out.println(orderEmployeesByCarrerLevelASC(employees));

        // Example 7 results
        //System.out.println(getEmployeeNamesFromMonterreyCL129(employees));

        //Example 8 results
        System.out.println(getAllCiies(employees));
    }

    // Example 1. Return a list of employees from Monterrey
    public static List<Employee> getEmployeesFromMonterrey(List<Employee> employees){
        return employees.stream().filter(e -> e.getCity().equals("Monterrey")).toList();
    }

    // Example 2. Return a list of employees younger than 30
    public static List<Employee> getEmployeesYoungerThan30(List<Employee> employees){
        return employees.stream().filter(e -> e.getAge() < 30).toList();
    }

    // Example 3. Return a map of employees, group by city and save their names as value
    public static Map<String, List<String>> groupEmployeesByCity(List<Employee> employees){
        return employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));
    }

    // Example 4. Return the number of employees from Merida
    public static int getNumberEmployeesFromMerida(List<Employee> employees){
        return (int) employees.stream().filter(e -> e.getCity().equals("Merida")).count();
    }

    // Example 5. Return the full list of employees ordered by age DESC
    public static List<Employee> orderEmployeesByAgeDESC(List<Employee> employees){
        return employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).toList();
    }

    // Example 6. Return the full list of employees ordered by CL ASC
    public static List<Employee> orderEmployeesByCarrerLevelASC(List<Employee> employees){
        return employees.stream().sorted(Comparator.comparing(e -> Integer.parseInt(e.getCarrerLevel().split("CL")[1]))).toList();
    }

    // Example 7. Return a list of names (only the name) of employees from Monterrey, the condition here is
    // only CL 12 and 9 will be considered
    public static List<String> getEmployeeNamesFromMonterreyCL129(List<Employee> employees){
        return employees.stream().filter(e -> e.getCity().equals("Monterrey")).filter(e -> e.getCarrerLevel().equals("CL9") || e.getCarrerLevel().equals("CL12")).map(Employee::getName).toList();
    }

    public static List<String> getAllCiies(List<Employee> employees){
        return employees.stream().map(Employee::getCity).distinct().toList();
    }
}
