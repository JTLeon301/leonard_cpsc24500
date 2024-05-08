package a9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Utility class for writing exercise data to a file and displaying exercise summaries.
 */
public class ExerciseWriter {
	/**
     * Saves the list of exercises to a file.
     * @param exercises | The list of exercises to save.
     * @param filename | The name of the file to save to.
     */
    public static void saveToFile(List<Exercise> exercises, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Exercise exercise : exercises) {
                writer.write(exercise.toString());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Exercises saved to file: " + filename);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving exercises to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays a summary of the exercises in a dialog box.
     * @param exercises | The list of exercises to summarize.
     */
    public static void tabulateSummary(List<Exercise> exercises) {
        StringBuilder summary = new StringBuilder("Exercise Summary:\n");
        summary.append("Type\tName\tDate\tCalories Burned\n");
        for (Exercise exercise : exercises) {
            summary.append(exercise.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, summary.toString(), "Exercise Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}

