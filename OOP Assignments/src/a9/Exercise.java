package a9;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Abstract class representing an exercise.
 */
public abstract class Exercise implements Comparable<Exercise> {
	private String name;
	private Date date;
	private double duration;
	private String comment;
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
     * Gets the name of the exercise.
     * @return The name of the exercise.
     */
	public String getName() {
		return name;
	}
	
	/**
     * Sets the name of the exercise.
     * @param name | The name of the exercise.
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Gets the date of the exercise.
     * @return The date of the exercise.
     */
	public Date getDate() {
		return date;
	}
	
	/**
     * Sets the date of the exercise.
     * @param date | The date of the exercise.
     */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * sets date to current date
	 */
	public void setDate() {
		this.date = new Date(); // current date
	}
	
	/**
     * Sets the date of the exercise using a string.
     * @param date | The date string in "MM/dd/yyyy" format.
     */
	public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception ex) {
			this.date = new Date(); // now
		}
	}
	
	/**
     * Gets the duration of the exercise.
     * @return duration | The duration of the exercise.
     */
	public double getDuration() {
		return duration;
	}
	
	/**
     * Sets the duration of the exercise.
     * @param duration | The duration of the exercise.
     */
	public void setDuration(double duration) {
		if (duration < 0) {
			this.duration = 0;
		} else {
			this.duration = duration;
		}
	}
	
	/**
     * Gets the comment for the exercise.
     * @return The comment for the exercise.
     */
	public String getComment() {
		return comment;
	}
	
	/**
     * Sets the comment for the exercise.
     * @param comment | The comment for the exercise.
     */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
     * Constructs an Exercise with default values.
     */
	public Exercise() {
		name = "Exercise";
		setDate();
		setDuration(0);
		setComment("Unknown exercise");
	}
	
	/**
     * Constructs an Exercise with specified values.
     * @param name | The name of the exercise.
     * @param date | The date of the exercise.
     * @param duration | The duration of the exercise.
     * @param comment | The comment for the exercise.
     */
	public Exercise(String name, Date date, double duration, String comment) {
		setName(name);
		setDate(date);
		setDuration(duration);
		setComment(comment);
	}
	
	/**
     * Constructs an Exercise with specified values.
     * @param name | The name of the exercise.
     * @param date | The date of the exercise as a string.
     * @param duration | The duration of the exercise.
     * @param comment | The comment for the exercise.
     */
	public Exercise(String name, String date, double duration, String comment) {
		setName(name);
		setDate(date);
		setDuration(duration);
		setComment(comment);
	}
	
	/**
     * Gets the date as a string in "MM/dd/yyyy" format.
     * @return The date as a string.
     */
	private String getDateAsString() {
		return df.format(date);
	}
	
	/**
	 * generates tab-delimited String containing exercise-specific data 
	 * @return tab-delimited String of exercise-specific info
	 */
	public abstract String toStringCustomInfo();
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%.2f\t%s\t%.2f\t%s", name,getType(),getDateAsString(),duration,toStringCustomInfo(),getCaloriesBurned(),comment);
	}
	
	/**
     * Gets the type of exercise.
     * @return The type of exercise.
     */
	public abstract String getType();
	
	/**
     * Calculates the calories burned during the exercise.
     * @return The calories burned.
     */
	public abstract double getCaloriesBurned();
	
	/**
	 * Revised compareTo method
	 */
	@Override
	public int compareTo(Exercise other) {
	    return this.date.compareTo(other.date);
	}
}