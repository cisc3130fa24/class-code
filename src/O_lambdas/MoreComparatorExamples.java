package O_lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

public class MoreComparatorExamples {
    public static void main(String[] args) {
        List<Employee> employees = getList();

        Collections.shuffle(employees);
        System.out.println("\nemployees sorted by id:");
        employees.sort(Comparator.comparing(Employee::id));
        employees.forEach(System.out::println);

        Collections.shuffle(employees);
        System.out.println("\nemployees sorted by salary:");
        // employees.sort((emp1, emp2) -> Integer.compare(emp1.getSalary(), emp2.getSalary()));
        employees.sort(Comparator.comparingInt(Employee::salary));
        employees.forEach(System.out::println);

        Collections.shuffle(employees);
        System.out.println("\nemployees sorted by salary and then by id:");
        // employees.sort(((emp1, emp2) -> {
        //   if (emp1.getSalary() != emp2.getSalary()) {
        //     return Integer.compare(emp1.getSalary(), emp2.getSalary());
        //   } else {
        //     return emp1.getId().compareTo(emp2.getId());
        //   }
        // }));
        employees.sort(Comparator.comparingInt(Employee::salary).thenComparing(Employee::id));
        employees.forEach(System.out::println);

        Collections.shuffle(employees);
        System.out.println("\nemployees sorted by salary then by first name and then by last name:");
        Comparator<Employee> bySalaryThenFirstThenLast =
                Comparator.comparingInt(Employee::salary)
                        .thenComparing(emp -> emp.name().first())
                        .thenComparing(emp -> emp.name().last());
        employees.sort(bySalaryThenFirstThenLast);
        employees.forEach(System.out::println);
    }

    private static List<Employee> getList() {
        return new ArrayList<>(List.of(
                new Employee(new Name("John", "Adams"), "1234", 50_000),
                new Employee(new Name("John", "Doe"), "2345", 50_000),
                new Employee(new Name("Bob", "Doe"), "6754", 50_000),
                new Employee(new Name("Bob", "Adams"), "5432", 40_000),
                new Employee(new Name("Jane", "Smith"), "7845", 55_000),
                new Employee(new Name("Jane", "Smith"), "7890", 45_000),
                new Employee(new Name("Julia", "Adams"), "8945", 50_000)
        ));
    }

}