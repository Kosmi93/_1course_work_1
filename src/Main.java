import pojo.Department;
import pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String line ="\n====================================================";

    public static void main(String[] args) {
       List<Department>departments = new ArrayList<>();
        departments.add(new Department("Отдел IT"));
        departments.add(new Department("Отдел бухгалтерии"));
        departments.add(new Department("Отдел продаж"));
        departments.add(new Department("Отдел закупок"));
        departments.add(new Department("Отдел чего то там"));
        EmployeeBook employees =new EmployeeBook();
        employees.add(new Employee("Иванов","Иван","Иванович",55_000d,departments.get(2)));
        employees.add(new Employee("Петров","Петр","Петрович",50_000d,departments.get(1)));
        employees.add(new Employee("Петров","Петр","Петрович",50_000d,departments.get(3)));
        employees.add(new Employee("Чапаев","Василий","Иванович",105_000d,departments.get(0)));
        employees.add(new Employee("Иванов1","Иван","Иванович",65_000d,departments.get(2)));
        employees.add(new Employee("Петров1","Петр","Петрович",60_000d,departments.get(1)));
        employees.add(new Employee("Чапаев1","Василий","Иванович",115_000d,departments.get(0)));



    }


}