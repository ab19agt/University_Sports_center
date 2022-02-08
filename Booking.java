package the_university_sports_centre;

public class Booking extends Exercise {
	String student_name = "";
	String booked_slot_id = "";
	int rating =0;
	Booking(int exercise_id,String name,double price,String booked_slot_id,String student_name){
		super(exercise_id,name,price);
		this.student_name=student_name;
		this.booked_slot_id=booked_slot_id;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getStudentName() {
		return this.student_name;
	}
	public int getRating() {
		return this.rating;
	}
	public String getBookedSlotId() {
		return this.booked_slot_id;
	}

}
