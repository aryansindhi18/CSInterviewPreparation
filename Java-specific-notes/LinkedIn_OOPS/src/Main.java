public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Aryan Sindhi",25,0,Location_ENUM.Gurgaon);
        Employee e2 = new Employee("Arushi Gupta",25,2500000,Location_ENUM.Gurgaon);
        System.out.println(e1.name+"'s salary : "+e1.salary);
        System.out.println(e2.name+"'s salary : "+e2.salary);
        System.out.println("APPRAISALS HAPPENED");
        e1.raiseSalary();
        System.out.println(e1.name+"'s salary : "+e1.salary);
        System.out.println(e2.name+"'s salary : "+e2.salary);
    }
}
