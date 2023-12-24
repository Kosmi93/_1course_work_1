import pojo.Department;
import pojo.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeBook {
    private static Employee[] employees = new Employee[10];
    public void print(){
        for (int i = 0; i < employees.length; i++) {
            if (!isNull(employees[i]))
                System.out.println(employees[i]);
        }
    }
    private boolean isNull(Employee employee){
        return employee==null;
    }
    private int searchEm(String secondName, String name, String surname){
        int result =-1;
        for (int i = 0; i < employees.length; i++) {
            if (!isNull(employees[i]))
                if ( secondName.equals(employees[i].getSecondName())
                        &&name.equals(employees[i].getName())
                        &&surname.equals(employees[i].getSurname())){
                    result = i;
                    break;
                }
        }
        return result;
    }
    //добавление
    public void add(Employee employee){
        for (int i = 0; i < employees.length; i++) {
            if (isNull(employees[i])){
                employees[i]=employee;
                break;
            }
            else if(i==employees.length-1)
                System.out.println("В массиве нет места");
        }
    }
    //удаление
    public void remove(Employee employee){
        for (int i = 0; i < employees.length; i++) {
            if (employee.equals(employees[i])){
                employees[i]=null;
                break;
            }
        }
    }
    public void remove(Long id){
        for (int i = 0; i < employees.length; i++) {
            if (!isNull(employees[i]))
                if ( id==employees[i].getId()){
                    employees[i]=null;
                    break;
                }
        }
    }
    public void remove(String secondName, String name, String surname){
        int temp = searchEm(secondName,name,surname);
        if ( temp != -1){
            employees[temp]=null;
        } else
            System.out.println("Такой сотрудник не найден");
    }

    //изменить сотрудника
    public void update(String secondName, String name, String surname, Department department){
        int temp = searchEm(secondName,name,surname);
        if ( temp != -1){
            employees[temp].setDepartment(department);
        } else
            System.out.println("Такой сотрудник не найден");
    }
    public void update(String secondName, String name, String surname, Double salary){
        int temp = searchEm(secondName,name,surname);
        if ( temp != -1){
            employees[temp].setSalary(salary);
        } else
            System.out.println("Такой сотрудник не найден");
    }
    //получить фио по отделам
    public String fullName(List<Department> departments){
        String result="";
        for (Department d: departments){
            result=result + "\t" + d.getTitle()+"\n";
            for (int i = 0; i < employees.length; i++) {
                if (!isNull(employees[i])){
                    if (employees[i].getDepartment().equals(d)){
                        result+=employees[i].getSecondName()+ " "
                                +employees[i].getName() + " "
                                +employees[i].getSurname()+"\n";
                    }
                }
            }
        }
        return result;
    }

    // первая часть

   //Наверное просто нужно было метод toString, не понятно
    public String employeeToString(){
       String result="";
       for (int i = 0; i < employees.length; i++) {
           if (!isNull(employees[i]))
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
    public Double getAllSalary(){
        Double sum=0d;
        for (int i = 0; i < employees.length; i++) {
            if (!isNull(employees[i]))
                sum+=employees[i].getSalary();
            else break;
        }
        return sum;
    }
    public Employee getMinSalary(){
        Double min=0d;
        int searchEmployee=0;
        for (int i = 0; i < employees.length; i++) {
            if (!isNull(employees[i]))
                searchEmployee =min<employees[i].getSalary()?searchEmployee:i;
            else break;
        }
        return employees[searchEmployee];
    }

    public Employee getMaxSalary(){
        Double max=0d;
        int searchEmployee=0;
        for (int i = 0; i < employees.length; i++) {
            if (!isNull(employees[i]))
                searchEmployee =max>employees[i].getSalary()?searchEmployee:i;
            else  break;
        }
        return employees[searchEmployee];
    }

    public Double getAverageSalary(){
        int count = 0;
        if(employees.length==0)
            return 0d;
        else{
            for (int i = 0; i < employees.length; i++) {
                if (!isNull(employees[i]))
                    count++;
            }
        }
            return getAllSalary()/count;
    }

    public String employeeToStringFullName(){
       String result="";
        for (int i = 0; i < employees.length; i++) {
            if (!isNull(employees[i]))
                result += employees[i].getSecondName() + " "
                   + employees[i].getName() + " "
                   + employees[i].getSurname() + "\n";
            else break;
        }
        return result;
    }
    //часть 2
    public void salaryIndexing(Double percent){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null){
                Double salary=employees[i].getSalary();
                employees[i].setSalary(salary+salary/100*percent);
            }

        }
    }

    public int[]filteringByDepartment(Department department){
        int[] filterEmployees = new int[employees.length];
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null && employees[i].getDepartment().equals(department))
                filterEmployees[count++]=i;
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i]=filterEmployees[i];

        }
        return result;
    }

    public Employee getMinSalaryInDepartment(Department department){
        Double min=0d;
        int[] filterEmployees =filteringByDepartment(department);

        int searchEmployee=0;
        for (int i = 0; i < filterEmployees.length; i++) {
            searchEmployee =min<employees[filterEmployees[i]].getSalary()?searchEmployee:i;

        }
        return employees[filterEmployees[searchEmployee]];
    }

    public Employee getMaxSalaryInDepartment(Department department){
        Double max=0d;
        int[] filterEmployees =filteringByDepartment(department);
        int searchEmployee=0;
        for (int i = 0; i < filterEmployees.length; i++) {

                searchEmployee =max>employees[filterEmployees[i]].getSalary()?searchEmployee:i;

        }
        return employees[searchEmployee];
    }

    public Double getAllSalaryDepartment(Department department){
        Double sum=0d;
        int[] filterEmployees =filteringByDepartment(department);

        for (int i = 0; i < filterEmployees.length; i++) {

            sum+=employees[filterEmployees[i]].getSalary();

        }
        return sum;
    }

    public Double getAverageSalaryInDepartment(Department department){

        int[] filterEmployees =filteringByDepartment(department);
        if(filterEmployees.length==0)
            return 0d;
        else{
            return getAllSalaryDepartment(department)/filterEmployees.length;
        }

    }

    public void salaryIndexingToDepartment(Department department,Double percent){
        int[] filterEmployees =filteringByDepartment(department);
        for (int i = 0; i < filterEmployees.length; i++) {
            employees[filterEmployees[i]]
                    .setSalary(employees[filterEmployees[i]].getSalary()/100*percent);

        }
    }

     public String employeeToStringFullNameInDepartment(Department department){
        String result="";
        int[] filterEmployees =filteringByDepartment(department);
        for (int i = 0; i < filterEmployees.length; i++) {
                result += employees[filterEmployees[i]].getSecondName() + " "
                        + employees[filterEmployees[i]].getName() + " "
                        + employees[filterEmployees[i]].getSurname() + "\n";
        }
        return result;
    }


}
