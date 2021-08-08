import java.util.LinkedList;


public class Toilet {
    private final LinkedList<Employee> employeesInToilet = new LinkedList<>();

    public void addMen() {

        synchronized (this) {
            while (employeesInToilet.size() >= 3 || isWomenIn()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            addEmployeeInToilet(Gender.MALE);
            notifyAll();

        }
    }

    public void addWoman() {

        synchronized (this) {
            while (employeesInToilet.size() >= 3 || isManIn()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            addEmployeeInToilet(Gender.FEMALE);
            notifyAll();

        }
    }

    private void addEmployeeInToilet(Gender gender) {
        Employee current = new Employee(gender);
        employeesInToilet.add(current);
        System.out.println("entered:" + current + ": Now  in toilet:" + employeesInToilet);
    }

    private synchronized boolean isManIn() {
        for (Employee employee : employeesInToilet) {
            if (employee.getGender().equals(Gender.MALE)) return true;
        }
        return false;
    }

    private synchronized boolean isWomenIn() {
        for (Employee employee : employeesInToilet) {
            if (employee.getGender().equals(Gender.FEMALE)) return true;
        }
        return false;
    }

    public void getEmployeeOut() {
        synchronized (this) {
            while (employeesInToilet.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Employee deleted = employeesInToilet.pop();
            System.out.println("get out:" + deleted + ": now in toilet:" + employeesInToilet);
            notifyAll();
        }
    }
}
