/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_university_sports_centre;

import java.util.*;

/**
 *
 * @author Arun
 */
public class The_University_Sports_Centre {

	/**
	 * @param args the command line arguments
	 */

	static ArrayList<TimeTable> timetable_list = new ArrayList<TimeTable>();
	static Exercise yoga = new Exercise(1, "yoga", 1.50);
	static Exercise zumba = new Exercise(2, "zumba", 2);
	static Exercise aquacise = new Exercise(3, "Aquacise", 5);
	static Exercise box_fit = new Exercise(4, "Box Fit", 3.5);
	static Exercise body_blitz = new Exercise(5, "Body Blitz", 3.75);
	static Exercise sport = new Exercise(6, "sport", 1);
	static Exercise[] exerciseClass = { yoga, zumba, aquacise, box_fit, body_blitz, sport };

	static ArrayList<Booking> booking_lists = new ArrayList<Booking>();

	static private void designTimatable() {

		int year = 2020;
		int month = Calendar.MARCH;
		Calendar cal = new GregorianCalendar(year, month, 1);
		int i = 0;

		while (i < 16) {
			// get the day of the week for the current day
			int day = cal.get(Calendar.DAY_OF_WEEK);
			// check if it is a Saturday or Sunday
			if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
				// print the day - but you could add them to a list or whatever
				String date = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1);
				for (int j = 0; j < 3; j++) {
					int exerciseClassIndex = day == Calendar.SATURDAY ? j : j + 3;
					TimeTable timetable = new TimeTable(exerciseClass[exerciseClassIndex].getId(),
							exerciseClass[exerciseClassIndex].getName(), exerciseClass[exerciseClassIndex].getPrice(),
							i + "" + j, date, j == 0 ? "9:00to11:00" : j == 1 ? "14:00to116:00" : "18:00to20:00");
					timetable_list.add(timetable);

				}

				i++;
			}
			// advance to the next day
			cal.add(Calendar.DAY_OF_YEAR, 1);

		}
	}

	static private void TimetableByDate(String date) {

		Iterator<TimeTable> itr = timetable_list.iterator();
		boolean found = false;
		System.out.println("id " + "date" + "  " + "classes" + "   " + "slot" + "   " + "vacancy");
		while (itr.hasNext()) {
			TimeTable st = (TimeTable) itr.next();
			// System.out.println(date+" "+st.getDate());
			if (st.getDate().equals(date)) {
				found = true;
				System.out.println(st.getSlotId() + "  " + st.getDate() + "  " + st.getName()
						+ "  " + st.getSlot() +
						"     " + st.getVacancy());
			}

		}
		if (!found) {
			System.out.println(
					"sorry there are not any slot available for given Date or you provided wrong input formate try again by using (d-m) formate");
		}

	}

	static private void TimetableByName(String name) {

		Iterator<TimeTable> itr = timetable_list.iterator();
		boolean found = false;
		System.out.println("id " + "date" + "  " + "classes" + "   " + "slot" + "   " + "vacancy");
		while (itr.hasNext()) {
			TimeTable st = (TimeTable) itr.next();
			// System.out.println(date+" "+st.getDate());
			if (st.getName().equals(name)) {
				found = true;
				System.out.println(st.getSlotId() + "  " + st.getDate() + "  " + st.getName()
						+ "  " + st.getSlot() +
						"     " + st.getVacancy());
			}

		}
		if (!found) {
			System.out.println("sorry there are not any slot available for given name");
		}

	}

	static void getTimeTable() {
		Iterator<TimeTable> itr = timetable_list.iterator();
		System.out.println("id " + "date" + "  " + "classes" + "   " + "slot" + "   " + "vacancy");
		// for(int i=0;i<timetable_list.size();i++) {
		//
		// }
		while (itr.hasNext()) {
			TimeTable st = (TimeTable) itr.next();

			System.out.println(st.getSlotId() + "  " + st.getDate() + "  " + st.getName()
					+ "  " + st.getSlot() +
					"     " + st.getVacancy());

		}
	}

	static private void bookingSlot(String name, String slotid) {

		for (int i = 0; i < booking_lists.size(); i++) {
			if (booking_lists.get(i).getBookedSlotId().equals(slotid)
					&& booking_lists.get(i).getStudentName().equals(name)) {
				System.out.println("you already booked given slot,please select other slot, if you want!");
				return;
			}

		}

		Iterator<TimeTable> itr = timetable_list.iterator();
		boolean found = false;
		while (itr.hasNext()) {
			TimeTable st = (TimeTable) itr.next();
			// System.out.println(date+" "+st.getDate());
			if (st.getSlotId().equals(slotid)) {
				if (st.getVacancy() > 0) {
					found = true;
					Booking booking = new Booking(st.getId(), st.getName(), st.getPrice(), st.getSlotId(), name);
					booking_lists.add(booking);
					st.decreaseVacancy();
					System.out.println("your booking has been done");

				} else {
					System.out.println("This class is full please try different class");
					return;
				}
			}

		}
		if (!found) {
			System.out.println("provided slot id is wrong. please try again");
		}

	}

	static private void changeSlot(String name) {
		if (booking_lists.size() == 0) {
			System.out.println("name is not found");
			return;
		}
		System.out.println("Student Name     Slot Id      Date");
		for (int i = 0; i < booking_lists.size(); i++) {
			if (booking_lists.get(i).getStudentName().equals(name)) {
				for (int j = 0; j < timetable_list.size(); j++) {
					if (timetable_list.get(j).getSlotId().equals(booking_lists.get(i).getBookedSlotId())) {
						System.out.println(booking_lists.get(i).getStudentName() + "              "
								+ timetable_list.get(j).getSlotId() + "      " + timetable_list.get(j).getDate());
					}

				}
			} else {
				System.out.println("name is not found");
				return;
			}

		}
		System.out.println();
		System.out.println("Here is your all alocated slot,please enter slotId which you have to change");
		String old_slot_id = scan.next();
		System.out.println("please enter a new SlotId");
		String new_slot_id = scan.next();

		for (int i = 0; i < booking_lists.size(); i++) {
			if (booking_lists.get(i).getStudentName().equals(name)
					&& booking_lists.get(i).getBookedSlotId().equals(old_slot_id)) {
				for (int j = 0; j < timetable_list.size(); j++) {
					if (timetable_list.get(j).getSlotId().equals(old_slot_id)) {
						timetable_list.get(j).increaseVacancy();

						bookingSlot(name, new_slot_id);
						booking_lists.remove(i);
					}

				}
			} else {
				System.out.println("student name and slot id is not match, please try again");
			}

		}

	}

	static void Rating(String name) {
		if (booking_lists.size() == 0) {
			System.out.println("name is not found");
			return;
		}
		System.out.println("Student Name     Slot Id      Date");
		for (int i = 0; i < booking_lists.size(); i++) {
			if (booking_lists.get(i).getStudentName().equals(name)) {
				for (int j = 0; j < timetable_list.size(); j++) {
					if (timetable_list.get(j).getSlotId().equals(booking_lists.get(i).getBookedSlotId())) {
						System.out.println(booking_lists.get(i).getStudentName() + "              "
								+ timetable_list.get(j).getSlotId() + "      " + timetable_list.get(j).getDate());
					}

				}
			} else {
				System.out.println("name is not found");
				return;
			}

		}
		System.out.println("which class would you like to rate, enter SlotId");
		String slot_id = scan.next();
		System.out.println(
				"give rating from ranging from 1 to 5 (1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5: Very Satisfied");

		try {
			int rating = scan.nextInt();
			if (rating > 0 && rating < 6) {
				for (int i = 0; i < booking_lists.size(); i++) {
					if (booking_lists.get(i).getBookedSlotId().equals(slot_id)) {
						booking_lists.get(i).setRating(rating);
					}
				}
			} else {
				System.out.println("something wrong. make sure you provided rating from 1 to 5, and try again ");
				Rating(name);
			}
		} catch (InputMismatchException e) {
			System.out.println("something wrong. make sure you provided rating from 1 to 5, and try again ");
			Rating(name);
		}

	}

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO code application logic here
		designTimatable();
		boolean exit = false;
		String select = "";
		String student_name_find;

		while (!exit) {
			System.out.println("-----------------------------------------");
			System.out.println("Please Select Options");
			System.out.println("1. get full timetable");
			System.out.println("2. find timetable by date ");
			System.out.println("3. find timetable by exercise name ");
			System.out.println("4. book your class by id");
			System.out.println("5. change your class ");
			System.out.println("6. give rating ");
			System.out.println("7. exit ");
			System.out.println("-----------------------------------------");
			select = scan.next();
			switch (select) {
				case "1":
					getTimeTable();
					break;
				case "2":
					System.out.println(
							"Enter date for searching timetable as (d-m) format your classes start from March 2020");
					String date = scan.next();
					System.out.println("-----------------------------------------");
					TimetableByDate(date);

					break;
				case "3":
					System.out.println("Enter name for searching classes. We are providing following classes ");
					for (int i = 0; i < 6; i++) {
						System.out.println(i + "." + exerciseClass[i].getName());
					}
					String name = scan.next();
					System.out.println("-----------------------------------------");
					TimetableByName(name);

					break;
				case "4":
					System.out.println("Enter your Name");
					String student_name = scan.next();
					System.out.println("Enter SlotId");
					String slot_id = scan.next();
					bookingSlot(student_name, slot_id);
					System.out.println("-----------------------------------------");

					break;
				case "5":
					System.out.println("Enter your Name for finding your alocated slot");
					student_name_find = scan.next();
					changeSlot(student_name_find);
					break;
				case "6":
					System.out.println("Give Rating of the class");
					System.out.println("Enter your name so we can find your attended class");
					student_name_find = scan.next();
					Rating(student_name_find);
					break;
				default:
					break;

			}
		}

	}

}
