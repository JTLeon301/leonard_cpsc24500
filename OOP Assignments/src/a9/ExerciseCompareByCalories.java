package a9;

import java.util.Comparator;

/**
 * Comparator class to compare exercises based on the calories burned.
 */
public class ExerciseCompareByCalories implements Comparator<Exercise> {
	/**
     * Compares two exercises based on the calories burned.
     * @param e1 | The first exercise to compare.
     * @param e2 | The second exercise to compare.
     * @return -1 if the calories burned by the first exercise are less than the second exercise.
     *         1 if the calories burned by the first exercise are greater than the second exercise.
     *         0 if the calories burned by both exercises are equal.
     */
    @Override
    public int compare(Exercise e1, Exercise e2) {
        double calories1 = e1.getCaloriesBurned();
        double calories2 = e2.getCaloriesBurned();

        //compare exercises by calories burned
        if (calories1 < calories2) {
            return -1;
        } else if (calories1 > calories2) {
            return 1;
        } else {
            return 0;
        }
    }
}
