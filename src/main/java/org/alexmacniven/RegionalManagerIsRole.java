package org.alexmacniven;

import java.util.function.Predicate;

public class RegionalManagerIsRole implements Predicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getRole().equals(Role.REGIONAL_MANAGER);
    }
}
