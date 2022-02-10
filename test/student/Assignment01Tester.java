package student;

public class Assignment01Tester {

    private Group group;

	public void createGroup(int i) {
            group = new Group(i);
	}

	public void addStudent(int sNumber, String firstName, String lastName) {
            group.addStudent(sNumber, firstName, lastName);
	}

	public void changeStudent(int sNumber, String firstName, String lastName) {
            group.changeStudent(sNumber, firstName, lastName);
	}

	public String printStudents() {
            return group.groupContents();
	}

}
