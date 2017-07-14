public class Course {
	private int department;
	private int courseNum;
	private String name;
	private char day;
	private int timeSlot;
	private int credits;
	private Student[] students = new Student[20];
	private Period period;

	public Course (int department, int courseNum, String name, char day, int timeSlot, int credits) {
		this.department = department;

		this.courseNum = courseNum;

		this.name = name;

		this.day = day;

		this.timeSlot = timeSlot;

		this.credits = credits;
		
		this.period = new Period (day, timeSlot);
	}

	public Course (Student[] students) {
		this.students = students;
	}

	public int getDepartment() {
		return department;
	}

	public int getCourseNumber() {
		return courseNum;
	}

	public String getName() {
		return name;
	}

	public Period getPeriod() {
		return period;
	}

	public int getCredits() {
		return credits;
	}

	public Student[] getRoster() {
		return students;
	}

	public String toString () {
		return Integer.toString(department) + ":" + Integer.toString(courseNum) + " " + "[" + name + "]" + " " + period.getDay() + period.getTimeSlot() + " " + "credits" + ":" + Integer.toString(credits);
	}

	public boolean equals(Course other) {
		if (department == other.department && courseNum == other.courseNum) {
			return true;
		}

		return false;
	}

}