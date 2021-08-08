public class Employee {
    private final Gender gender;

    public Employee(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender.toString();
    }

    public Gender getGender() {
        return gender;
    }
}
