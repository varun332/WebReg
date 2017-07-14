public class WebReg {
	public static Course lookupCourseByName (Course[] catalog, String courseName) {
		for (int i = 0; i < catalog.length; i++) {
			if (catalog[i].getName().equals(courseName)) {
				return catalog[i];
			}
		}

		return null;
	}

	public static Course[] lookupCoursesByDept (Course[] catalog, int department) {
		int count = 0;
		Course[] courseList = new Course[catalog.length];
		for (int i = 0; i < catalog.length; i++) {
			if (department == catalog[i].getDepartment()) {
				courseList[i] = catalog[i];
				count++;
			}

			else {
				courseList[i] = null;
			}
		}

		if (count == 0) {
			return null;
		}

		Course[] finalCourseList = new Course[count];

		int k = 0;

		for (int j = 0; j < courseList.length; j++) {
			if (k == count) {
				return finalCourseList;
			}

			if (courseList[j] != null) {
				finalCourseList[k] = courseList[j];
				k++;
			}
		}

		return finalCourseList;

	}

	public static int countCredits (Student s) {
		int sum = 0;
		for (int i = 0; i < s.getSchedule().length; i++) {
			if (s.getSchedule()[i] == null) {
				sum = sum;
			}

			else {
				sum = sum + s.getSchedule()[i].getCredits();
			}
		}

		return sum;

	}

	public static boolean addCourse (Student s, Course c) {
		for (int i = 0; i < s.getSchedule().length; i++) {
			if (s.getSchedule()[i] != null) {
				if (s.getSchedule()[i].equals(c)) {
					return false;
				}

				if (s.getSchedule()[i].getPeriod().compareTo(c.getPeriod()) == 0) {
					return false;
				}
			}

			if (s.getSchedule()[i] == null) {
				for (int j = 0; j < c.getRoster().length; j++) {
					if (c.getRoster()[j] != null) {
						if (c.getRoster()[j].equals(s)) {
							return false;
						}
					}

					if (c.getRoster()[j] == null) {
						s.getSchedule()[i] = c;
						c.getRoster()[j] = s;
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean dropCourse (Student s, Course c) {
		for (int i = 0; i < s.getSchedule().length; i++) {
			if (s.getSchedule()[i] != null) {
				if (s.getSchedule()[i].equals(c)) {
					for (int j = 0; j < c.getRoster().length; j++) {
						if (c.getRoster()[j] != null) {
							if (c.getRoster()[j].equals(s)) {
								s.getSchedule()[i] = null;
								c.getRoster()[j] = null;

								for (int k = i; k < s.getSchedule().length - 1; k++) {
									if (k == s.getSchedule().length - 1) {
										s.getSchedule()[k] = null;
									}

									else {
										s.getSchedule()[k] = s.getSchedule()[k + 1];
									}
								}

								for (int h = j; h < c.getRoster().length - 1; h++) {
									if (h == c.getRoster().length - 1) {
										c.getRoster()[h] = null;
									}

									else {
										c.getRoster()[h] = c.getRoster()[h + 1];
									}
								}

								return true;

							}
						}
					}
				}
			}
		}

		return false;

	}

	public static Course[] commonCourses (Student one, Student two) {
		int count = 0;
		Course[] comCourses = new Course[6];

		for (int i = 0; i < one.getSchedule().length; i++) {
			if (one.getSchedule()[i] != null) {
				for (int j = 0; j < two.getSchedule().length; j++) {
					if (two.getSchedule()[j] != null) {
						if (one.getSchedule()[i].equals(two.getSchedule()[j])) {
							comCourses[i] = one.getSchedule()[i];
							count++;
						}
					}
				}
			}
		}

		if (count == 0) {
			return null;
		}

		Course[] finalComCourses = new Course[count];

		int k = 0;

		for (int r = 0; r < comCourses.length; r++) {
			if (k == count) {
				return finalComCourses;
			}

			if (comCourses[r] != null) {
				finalComCourses[k] = comCourses[r];
				k++;
			}
		}

		return finalComCourses;

	}

	public static void sortByNumber (Course[] catalog) {
		for (int i = 0; i < catalog.length; i++) {
			int indexOfMinDep = i;
			if (catalog[i] != null) {
				for (int j = i; j < catalog.length; j++) {
					if (catalog[j] != null) {
						if (catalog[j].getDepartment() < catalog[indexOfMinDep].getDepartment()) {
							indexOfMinDep = j;
						}
					}
				}

				Course tempDep = catalog[i];
				catalog[i] = catalog[indexOfMinDep];
				catalog[indexOfMinDep] = tempDep;
			}
		}

		for (int k = 0; k < catalog.length; k++) {
			for (int h = k; h < catalog.length; h++) {
				if (catalog[h].getDepartment() == catalog[k].getDepartment()) {
					if (catalog[h].getCourseNumber() < catalog[k].getCourseNumber()) {
						Course tempCourse = catalog[k];
						catalog[k] = catalog[h];
						catalog[h] = tempCourse;
					}
				}
			}
		}
	}

	public static void sortByTime (Course[] catalog) {
/*		
		for (int i = 0; i < catalog.length; i++) {
			int indexOfMinDay = i;
			String days = "MTWHF";

			if (catalog[i] != null) {
				for (int j = i; j < catalog.length; j++) {
					if (catalog[j] != null) {

						if (days.indexOf(catalog[j].getPeriod().getDay()) < days.indexOf(catalog[indexOfMinDay].getPeriod().getDay())) {
							indexOfMinDay = j;
						}
					}
				}

				Course tempDay = catalog[i];
				catalog[i] = catalog[indexOfMinDay];
				catalog[indexOfMinDay] = tempDay;
			}
		}

		for (int k = 0; k < catalog.length; k++) {
			for (int h = k; h < catalog.length; h++) {
				if (catalog[h].getPeriod().getDay() == catalog[k].getPeriod().getDay()) {
					if (catalog[h].getPeriod().getTimeSlot() < catalog[k].getPeriod().getTimeSlot()) {
						Course tempTime = catalog[k];
						catalog[k] = catalog[h];
						catalog[h] = tempTime;
					}
				}
			}
		}

		for (int f = 0; f < catalog.length; f++) {
			for (int g = f; g < catalog.length; g++) {
				if (catalog[g].getPeriod().compareTo(catalog[f].getPeriod()) == 0) {
					if (Character.getNumericValue((catalog[g].getName()).charAt(0)) < Character.getNumericValue((catalog[f].getName()).charAt(0))) {
						Course tempName = catalog[f];
						catalog[f] = catalog[g];
						catalog[g] = tempName;
					}
				}
			}
*/
		for (int f = 0; f < catalog.length; f++) {
	        for (int g = 1; g < catalog.length; g++) {
	        	if (catalog[g - 1].getPeriod().compareTo(catalog[g].getPeriod()) == 1) {
	        		Course temp = catalog[g - 1];
					catalog[g - 1] = catalog[g];
					catalog[g] = temp; 
	        	}
	        }
    	}
	}	
}