public class Employee {
    private   Sex sex;

    public Employee(Sex sex) {
     this.sex = sex;
         }

    @Override
    public String toString() {
        return sex.toString();
    }

    public Sex getSex() {
        return sex;
    }
}
