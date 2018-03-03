package pl.sda.poznan.factory;

import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;
import pl.sda.poznan.factory.writer.CompanyWriter;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Employee dyrektor = new Employee("Jan", "Nowak", "nowak@gmail.com", 10000D);
        Employee kierownik = new Employee("Jan", "Kowalski", "kowalski@gmail.com", 8000D);

        Company company = new Company();
        company.addEmployee(dyrektor);
        company.addEmployee(kierownik);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku do ktorego chcesz zapisac");

        String filename = scanner.next();
        CompanyWriterFactory companyWriterFactory = new CompanyWriterFactory();
        try {
            CompanyWriter writer = companyWriterFactory.create(filename);
            writer.write(company);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
