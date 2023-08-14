package org.alexmacniven;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class EmployeePredicateService {

    public static List<Employee> getOriginalSalesEmployees(List<Employee> employees) {
        Predicate<Employee> salesIsRole = employee -> employee.getRole().equals(Role.SALES);
        Predicate<Employee> originalIsStaff = employee -> employee.getStaff_id() < 10;

        return filterEmployeesOnPredicate(employees, salesIsRole.and(originalIsStaff));
    }

    public static Optional<Employee> getRegionalManager(List<Employee> employees) {
        RegionalManagerIsRole regionalManagerIsRole = new RegionalManagerIsRole();
        return firstEmployeeOnPredicate(employees, regionalManagerIsRole);
    }

    private static List<Employee> filterEmployeesOnPredicate(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).toList();
    }

    private static Optional<Employee> firstEmployeeOnPredicate(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).findFirst();
    }
}
