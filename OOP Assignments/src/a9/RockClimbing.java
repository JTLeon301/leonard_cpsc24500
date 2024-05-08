package a9;

import java.util.Date;

/**
 * Creates a RockClimbing exercise.
 */
class RockClimbing extends Exercise {
    //additional attributes
    private double wallHeight;
    private int repetitions;

    /**
     * Constructs a RockClimbing exercise.
     * @param name | The name of the exercise.
     * @param date | The date of the exercise.
     * @param duration | The duration of the exercise.
     * @param comment | Comments about the exercise.
     * @param wallHeight | The wallHeight of the climb.
     * @param repetitions | The repetitions done.
     */
    public RockClimbing(String name, Date date, double duration, String comment, double wallHeight, int repetitions) {
        super(name, date, duration, comment);
        this.wallHeight = wallHeight;
        this.repetitions = repetitions;
    }

    /**
     * Gets the type of the exercise.
     * @return The type of the exercise.
     */
    public String getType() {
        return "Rock Climbing";
    }

    /**
     * Calculates the calories burned.
     * @return The number of calories burned.
     */
    public double getCaloriesBurned() {
        return (wallHeight * repetitions / getDuration()) * 100;
    }

    /**
     * Gets additional information specific to the class.
     * @return A string of the wallHeigth and repetitions.
     */
    public String toStringCustomInfo() {
        return String.valueOf(wallHeight)+ " " + String.valueOf(repetitions);
    }
}

