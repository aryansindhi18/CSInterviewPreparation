public class Employee {
    public String name;
    public int age;
    public double salary;

    public Employee(String name, int age, double salary, Location_ENUM location) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }

    Location_ENUM location;

    public void raiseSalary(){
        if(this.salary > 0)
            this.salary *= 1.2;
        else
            this.salary=20;
    }
}
