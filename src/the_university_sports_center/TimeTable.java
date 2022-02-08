package the_university_sports_centre;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author md19acb
 */
public class TimeTable extends Exercise {
	
	private String id = "";
	private String slot = "";
	private String date ="";
    private int vacancy = 4;
     TimeTable(int exercise_id,String name,double price,String id,String date,String slot){
		super(exercise_id,name,price);
		this.id=id;
		this.slot = slot;
        this.date = date;
		
	}
	public String getSlotId() {
		return id;
	}
	public String getSlot() {
		return slot;
	}
	public String getDate() {
		return date;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void decreaseVacancy() {
		this.vacancy--;
	}
	public void increaseVacancy() {
		this.vacancy++;
	}
//private String [] exersiseClass = {"Yoga","Zumba","Aquacise","Box Fit","Body Blitz","sport"};





}
