package a9;

import java.util.Date;

/**
 * Creates a WeightLifting exercise.
 */
class WeightLifting extends Exercise {
    //additional attributes
    private double weightLifted;

    /**
     * Constructs a WeightLifting exercise.
     * @param name | The name of the exercise.
     * @param date | The date of the exercise.
     * @param duration | The duration of the exercise.
     * @param comment | Comments about the exercise.
     * @param weightLifted | The amount of weight lifted.
     */
    public WeightLifting(String name, Date date, double duration, String comment, double weightLifted) {
        super(name, date, duration, comment);
        this.weightLifted = weightLifted;
    }

    /**
     * Gets the type of the exercise.
     * @return The type of the exercise.
     */
    public String getType() {
        return "Weightlifting";
    }
    
    /**
     * Calculates the calories burned.
     * @return The number of calories burned.
     */
    public double getCaloriesBurned() {
        return (weightLifted / getDuration()) * 50;
    }

    /**
     * Gets additional information specific to the class.
     * @return A string of the weight lifted.
     */
    public String toStringCustomInfo() {
        return String.valueOf(weightLifted);
    }
}
