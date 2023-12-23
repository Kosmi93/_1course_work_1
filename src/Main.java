import pojo.Department;
import pojo.Employee;

import java.util.ArrayList;

public class Main {
    private static final String line ="\n====================================================";
    private static Department[] departments = new Department[5];
    private static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        departments[0]= new Department("Отдел IT");
        departments[1]= new Department("Отдел бухгалтерии");
        departments[2]= new Department("Отдел продаж");
        departments[3]= new Department("Отдел закупок");

        employees[0] = new Employee("Иванов","Иван","Иванович",50_000d,departments[2]);
        employees[1] = new Employee("Петров","Петр","Петрович",50_000d,departments[1]);
        employees[2] = new Employee("Пушкин","Александр","Сергеевич",45_000d,departments[3]);
        employees[3] = new Employee("Чапаев","Василий","Иванович",105000d,departments[0]);
        System.out.println(departmensToString()+line);
        System.out.println(employeeToString()+line);
        System.out.println(getAllSalary()+line);
        System.out.println(getMinSalary()+line);
        System.out.println(getMaxSalary()+line);
        System.out.println(getAverageSalary()+line);
        System.out.println(employeeToStringFullName()+line);
    }
   static String departmensToString(){
       String result="";
       for (int i = 0; i < departments.length; i++) {
           if (departments[i]!=null)
               result+= departments[i].getId() + " "
                       + departments[i].getTitle()+ "\n";
           else break;
       }
       return result;
    }
   static String employeeToString(){
       String result="";
       for (int i = 0; i < employees.length; i++) {
           if (employees[i]!=null)
               result += employees[i].getId() + " "
                       + employees[i].getSecondName() + " "
                       + employees[i].getName() + " "
                       + employees[i].getSurname() + " "
                       + employees[i].getSalary() + " "
                       + employees[i].getDepartment() + "\n";
           else break;
       }
       return result;
   }
    static Double getAllSalary(){
        Double sum=0d;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null)
                sum+=employees[i].getSalary();
            else break;
        }
        return sum;
    }

    static Employee getMinSalary(){
        Double min=0d;
        int searchEmployee=0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null)
                searchEmployee =min<employees[i].getSalary()?searchEmployee:i;
            else break;
        }
        return employees[searchEmployee];
    }

    static Employee getMaxSalary(){
        Double max=0d;
        int searchEmployee=0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null)
                searchEmployee =max>employees[i].getSalary()?searchEmployee:i;
            else  break;
        }
        return employees[searchEmployee];
    }

    static Double getAverageSalary(){
        int count = 0;
        if(employees.length==0)
            return 0d;
        else{
            for (int i = 0; i < employees.length; i++) {
                if (employees[i]!=null)
                    count++;
            }
        }
            return getAllSalary()/count;
    }

    static String employeeToStringFullName(){
       String result="";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null)
                result += employees[i].getSecondName() + " "
                   + employees[i].getName() + " "
                   + employees[i].getSurname() + "\n";
            else break;
        }
        return result;
    }


}