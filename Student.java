public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int gradYear;
	private Course[] courses;

	public Student (String firstName, String lastName, int id, int gradYear) {
		this.firstName = firstName;

		this.lastName = lastName;

		this.id = id;

		this.gradYear = gradYear;

		this.courses = new Course[6];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	public int getGradYear() {
		return gradYear;
	}

	public Course[] getSchedule() {
		return courses;
	}

	public String toString() {
		return Integer.toString(id) + ": " + lastName + ", " + firstName + " - " + Integer.toString(gradYear);
	}

	public boolean equals (Student other) {
		if (id == other.id) {
			return true;
		}

		return false;
	}
}