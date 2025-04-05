import org.json.JSONArray;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EmployeePensionApp {
    public static void main(String[] args) {
//        PensionPlan EX1089 = new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00);
//        PensionPlan SM2307 = new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50);
//        Employee employee1 = new Employee(1L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50);
//        employee1.setPensionPlan(EX1089);
//        Employee employee2 = new Employee(3L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75);
//        employee2.setPensionPlan(SM2307);
//        Employee[] employees = {
//                employee1, employee2,
//                new Employee(2L, "Benard", "Shaw", LocalDate.of(2022, 9, 3), 197750.00),
//                new Employee(4L, "Wesley", "Schneider", LocalDate.of(2022, 7, 21), 74500.00),
//                new Employee(5L, "Anna", "Wiltord", LocalDate.of(2022, 6, 15), 85750.00),
//                new Employee(6L, "Yosef", "Tesfalem", LocalDate.of(2022, 10, 31), 100000.00)
//        };
////        printEmployees(employees);
//
//        quarterlyEnrollee(employees);
        ArrayList<Apartment> apartments = new ArrayList<>();
        ArrayList<Lease> leases = new ArrayList<>();
        Apartment B1102 =new Apartment("B1102","The Cameron House",11,790,3);
        Apartment A705 = new Apartment("A705","The Cameron House",7,855,4);
        Apartment C1210 = new Apartment("C1210","Pointe Palace",12,1000,4);
        Apartment A1371 = new Apartment("A1371","Pointe Palace",13,1000,4);
        apartments.add(B1102);
        apartments.add(A705);
        apartments.add(C1210);
        apartments.add(A1371);
        Lease lease1 = new Lease(3128874121L, LocalDate.of(2025,2,1),LocalDate.of(2026,2,1),1750.50,"Micheal Philips",A705);
        Lease lease2 =new Lease(2927458265L, LocalDate.of(2025,4,2),LocalDate.of(2025,10,2),1500.00,"Anna Smith",B1102);
        Lease lease3 = new Lease(9189927460L, LocalDate.of(2025,3,1),LocalDate.of(2026,3,1),2560.75,"Alex Campos",A1371);
        Lease lease4 = new Lease(3128874119L, LocalDate.of(2023,2,1),LocalDate.of(2024,2,1),1650.55,"Michael Philips",A705);
        A705.addLease(lease1);
        B1102.addLease(lease2);
        A1371.addLease(lease3);
        A705.addLease(lease4);
        leases.add(lease1);
        leases.add(lease2);
        leases.add(lease3);
        leases.add(lease4);
        printAllApartment(apartments);

    }
    public static void printAllApartment(ArrayList<Apartment> apartments){
        if ( apartments.size() > 0){
            List<Apartment> sortedApartments =  apartments.stream()
                    .sorted(Comparator.comparingInt(Apartment::getSize).reversed().thenComparing(Apartment::getApartmentNo))
                    .toList();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(sortedApartments);
//            for (Apartment apartment : sortedApartments) {
//                jsonArray.put(apartment);
//            }
            System.out.println(jsonArray.toString(4));
        }
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
