package a9;

import java.util.Date;

/**
 * Creates a RunWalk exercise.
 */
class RunWalk extends Exercise {
    //additional attributes
    private double distance;

    /**
     * Constructs a RunWalk exercise.
     * @param name | The name of the exercise.
     * @param date | The date of the exercise.
     * @param duration | The duration of the exercise.
     * @param comment | Comments about the exercise.
     * @param distance | The distance of the RunWalk.
     */
    public RunWalk(String name, Date date, double duration, String comment, double distance) {
        super(name, date, duration, comment);
        this.distance = distance;
    }
    
    /**
     * Gets the type of the exercise.
     * @return The type of the exercise.
     */
    public String getType() {
        return "Run/Walk";
    }

    /**
     * Calculates the calories burned.
     * @return The number of calories burned.
     */
    public double getCaloriesBurned() {
        return (distance / getDuration()) * 9000;
    }

    /**
     * Gets additional information specific to the class.
     * @return A string of the distance.
     */
    public String toStringCustomInfo() {
        return String.valueOf(distance);
    }
}
