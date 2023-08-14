package org.alexmacniven;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePredicateServiceTest {

    @Test
    void getOriginalSalesEmployees() {
        // Given
        List<Employee> employees = givenEmployeeList();
        // When
        List<Employee> originalSalesEmployees = EmployeePredicateService.getOriginalSalesEmployees(employees);
        // Then
        assertEquals(1, originalSalesEmployees.size());

    }

    List<Employee> givenEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().name("Joe Bloggs").role(Role.SALES).staff_id(1).build());
        employeeList.add(Employee.builder().name("Jane Bloggs").role(Role.ASSISTANT_TO_THE_REGIONAL_MANAGER).staff_id(0).build());
        employeeList.add(Employee.builder().name("Joan Bloggs").role(Role.SALES).staff_id(10).build());
        employeeList.add(Employee.builder().name("Jack Doe").role(Role.REGIONAL_MANAGER).staff_id(2).build());
        return employeeList;
    }

    @Test
    void getRegionalManager() {
        // Given
        List<Employee> employees = givenEmployeeList();
        // When
        Optional<Employee> employee = EmployeePredicateService.getRegionalManager(employees);
        // Then
        employee.ifPresent(e -> assertEquals(Role.REGIONAL_MANAGER, e.getRole()));
    }
}