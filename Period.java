public class Period {
	private char day;
	private int timeSlot;

	public Period (char day, int timeSlot) {
		this.day = day;
		this.timeSlot = timeSlot;
	}

	public char getDay() {
		return day;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public String toString() {
		return "" + day + timeSlot;
	}

	public int compareTo (Period other) {

		char[] dayChar = {'M','T','W','H','F','S'};
		int indexInstant = 0;
		int indexOther = 0;

		for (int i = 0; i < dayChar.length; i++) {
			if (day == dayChar[i]) {
				indexInstant = i;
			}
		}

		for (int k = 0; k < dayChar.length; k++) {
			if (other.day == dayChar[k]) {
				indexOther = k;
			}
		}

		if (indexInstant == indexOther && timeSlot < other.timeSlot) {
			return -1;
		}

		if (indexInstant == indexOther && timeSlot > other.timeSlot) {
			return 1;
		}

		if (indexInstant < indexOther) {
			return -1;
		}

		if (indexInstant > indexOther) {
			return 1;
		}

		return 0;
	}
}