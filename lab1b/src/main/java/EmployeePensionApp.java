import org.json.JSONArray;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EmployeePensionApp {
    public static void main(String[] args) {
        PensionPlan EX1089 = new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00);
        PensionPlan SM2307 = new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50);
        Employee employee1 = new Employee(1L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50);
        employee1.setPensionPlan(EX1089);
        Employee employee2 = new Employee(3L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75);
        employee2.setPensionPlan(SM2307);
        Employee[] employees = {
                employee1, employee2,
                new Employee(2L, "Benard", "Shaw", LocalDate.of(2022, 9, 3), 197750.00),
                new Employee(4L, "Wesley", "Schneider", LocalDate.of(2022, 7, 21), 74500.00),
                new Employee(5L, "Anna", "Wiltord", LocalDate.of(2022, 6, 15), 85750.00),
                new Employee(6L, "Yosef", "Tesfalem", LocalDate.of(2022, 10, 31), 100000.00)
        };
//        printEmployees(employees);

        quarterlyEnrollee(employees);

    }

    public static void printEmployees(Employee[] employees) {
        if (employees != null) {
            List<Employee> employeeList = Arrays.stream(employees)
                    .sorted(Comparator.comparing(Employee::getYearlySalary, Comparator.reverseOrder())
                            .thenComparing(Employee::getLastName))
                    .toList();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(employeeList);
            System.out.println(jsonArray.toString(4));
        }
    }

    public static void quarterlyEnrollee(Employee[] employees) {
        LocalDate quarterStart = LocalDate.of(2025, 6, 30);
        LocalDate quarterEnd = quarterStart.plusMonths(3);
        if (employees != null) {
            List<Employee> employeeList = Arrays.stream(employees)
                    .filter(e -> e.getPensionPlan() == null)
                    .filter(e -> {
                                Period employmentPeriod = Period.between(e.getEmploymentDate(), quarterEnd);
                                return employmentPeriod.getYears() >= 3;
                            }
                    ).sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                    .toList();
            System.out.println(employeeList);
        }
    }
}
