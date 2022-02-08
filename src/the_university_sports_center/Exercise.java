package the_university_sports_centre;

public class Exercise {
	private int exercise_id;
	private String exercise_name;
	private double price;
	
	 Exercise(int exercise_id,String name,double price){ 
		this.exercise_id = exercise_id;
		this.exercise_name=name;
		this.price = price;
	}
	public int getId() {
		return exercise_id;
	}
	public String getName() {
		return exercise_name;
	}
	public double getPrice() {
		return price;
	}
}
