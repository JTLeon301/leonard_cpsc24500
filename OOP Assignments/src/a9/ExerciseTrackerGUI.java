package a9;

/**
 * NAME: Jaiden Leonard
 * DATE: 5/7/2024
 * CLASS: Object-Oriented Programming
 * ASSIGNMET 7
 * 
 * PURPUSE: The purpose of this program is to allow the user to add different exercise to a list
 * with different specifications and allows them to save the exercises to a doc on the user's
 * hard drive. It contains a GUI so it is easy to navigate and has numerous menubar features like
 * save, login, logout, and close. It also has an about menu.
 * 
 * STRUGGLES: I struggled a decent amount on certain things because my methods were not correctly calling
 * each other and actually creating the panels like the directions show took quite a bit of time since
 * this assignment is my first time doing GUI stuff in java.
 * 
 * NOTE: If you notice anything that I can improve upon, please let me know. All feedback is welcome,
 * both good and bad. Thank you!
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.util.Collections;

/**
 * GUI for an Exercise Tracker application.
 */
public class ExerciseTrackerGUI extends JFrame {

    private LoginFrame loginFrame;
    private JTextField txtName, txtDate, txtDuration, txtDistance, txtComments;
    private JTextArea txtAreaExercises;
    private JComboBox<String> cbxType;
    private List<Exercise> exercises;
    private JButton btnAddExercise;

    /**
     * Constructs the ExerciseTrackerGUI.
     */
    public ExerciseTrackerGUI() {
        super("Exercise Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createMenuBar();
        createPanels();
        createBottomPanel();
        
        //set minimum size for the JFrame
        setMinimumSize(new Dimension(800, 400)); //minimum width and height

        pack();
        setVisible(true);
        
        this.exercises = new ArrayList<>();

        initializeComponents();
        setAllComponentsEnabled(false);
    }

    /**
     * Creates the menu bar for the GUI.
     */
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenuItem loginMenuItem = new JMenuItem("Login");
        JMenuItem logoutMenuItem = new JMenuItem("Logout");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(loginMenuItem);
        fileMenu.add(logoutMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        loginMenuItem.addActionListener(e -> {
            boolean loggedIn = loginFrame.showDialog(this);
            if (loggedIn) {
            	setAllComponentsEnabled(true);
            }
        });

        logoutMenuItem.addActionListener(e -> {
        	setAllComponentsEnabled(false);
            loginFrame = null; //reset login frame
        });
        
        saveMenuItem.addActionListener(e -> {
            saveExercisesToFile();
        });
        
        exitMenuItem.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(this, 
                        "Are you sure you want to exit?", "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                dispose(); //close the JFrame
            }
        });

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);
        
        aboutMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Exercise Tracker, Spring 2024", "About", JOptionPane.INFORMATION_MESSAGE);
        });
    }
    
    /**
     * Implements the wanted display for the GUI.
     */
    private void createPanels() {
        JPanel leftPanel = createLeftPanel();
        JPanel rightPanel = createRightPanel();
        
        //set preferred sizes for the left and right panels
        leftPanel.setPreferredSize(new Dimension(200, getHeight()));
        rightPanel.setPreferredSize(new Dimension(200, getHeight()));

        //create a JSplitPane to split the panels evenly
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setResizeWeight(0.5); //split panels evenly
        getContentPane().add(splitPane, BorderLayout.CENTER);
    }

    /**
     * Creates the left panel.
     * @return The completed left panel.
     */
    private JPanel createLeftPanel() {
    	JPanel leftPanel = new JPanel(new GridLayout(0, 2, 0, 0));

        JLabel lblType = new JLabel("Type:");
        cbxType = new JComboBox<>(new String[]{"Run/Walk", "Weightlifting", "Rock Climbing"});
        leftPanel.add(lblType);
        leftPanel.add(cbxType);

        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField(20);
        leftPanel.add(lblName);
        leftPanel.add(txtName);

        JLabel lblDate = new JLabel("Date:");
        txtDate = new JTextField(20);
        leftPanel.add(lblDate);
        leftPanel.add(txtDate);

        JLabel lblDuration = new JLabel("Duration:");
        txtDuration = new JTextField(20);
        leftPanel.add(lblDuration);
        leftPanel.add(txtDuration);

        JLabel lblDistance = new JLabel("Distance:");
        txtDistance = new JTextField(20);
        leftPanel.add(lblDistance);
        leftPanel.add(txtDistance);

        JLabel lblComments = new JLabel("Comments:");
        txtComments = new JTextField(20);
        leftPanel.add(lblComments);
        leftPanel.add(txtComments);
        
        return leftPanel;
    }

    /**
     * Creates the right panel.
     * @return The completed right panel.
     */
    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout());
        txtAreaExercises = new JTextArea(10, 40);
        txtAreaExercises.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaExercises);
        rightPanel.add(new JLabel("Exercise Summary"), BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);
        return rightPanel;
    }
    
    /**
     * Creates the bottom panel for the GUI.
     */
    private void createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAddExercise = new JButton("Add Exercise");
        btnAddExercise.addActionListener(e -> {
            addExercise();
        });
        bottomPanel.add(btnAddExercise);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Initializes components of the GUI.
     */
    private void initializeComponents() {
        exercises = new ArrayList<>();
    }

    /**
     * Toggles the state of all components in the container.
     * @param container | The container that needs to be toggled.
     * @param enabled | The state of the components.
     */
    private void toggleComponentsEnabled(Container container, boolean enabled) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                toggleComponentsEnabled((Container) component, enabled); //recursively handle nested containers
            }
            component.setEnabled(enabled);
        }
    }

    /**
     * Sets the enabled state of all components.
     * @param enabled | The state to set.
     */
    public void setAllComponentsEnabled(boolean enabled) {
        toggleComponentsEnabled(this.getContentPane(), enabled);
    }

    /**
     * Adds an exercise based on the user input.
     */
    private void addExercise() {
        String name;
        try {
            name = txtName.getText();
            if (name.isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double duration;
        try {
            duration = Double.parseDouble(txtDuration.getText());
            if (duration <= 0) {
                throw new NumberFormatException("Duration must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid duration. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String comments = txtComments.getText();
        String strDate = txtDate.getText();
        Date date;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            date = dateFormat.parse(strDate);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please enter date in MM/dd/yyyy format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String exerciseType = (String) cbxType.getSelectedItem();
        Exercise exercise = null;

        switch (exerciseType) {
            case "Run/Walk":
                try {
                    double distance = Double.parseDouble(txtDistance.getText());
                    if (distance <= 0) {
                    	throw new NumberFormatException();
                    }
                    exercise = new RunWalk(name, date, duration, comments, distance);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid distance for Run/Walk. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "Weightlifting":
                try {
                    double weightLifted = Double.parseDouble(txtDistance.getText());
                    if (weightLifted <= 0) {
                    	throw new NumberFormatException();
                    }
                    exercise = new WeightLifting(name, date, duration, comments, weightLifted);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid weight lifted for Weightlifting. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "Rock Climbing":
                try {
                    double wallHeight = Double.parseDouble(txtDistance.getText());
                    if (wallHeight <= 0) {
                        throw new NumberFormatException("j");
                    }
                    int repetitions = Integer.parseInt(txtComments.getText());
                    if (repetitions <= 0) {
                        throw new NumberFormatException("k");
                    }
                    exercise = new RockClimbing(name, date, duration, comments, wallHeight, repetitions);
                } catch (NumberFormatException e) {
                    if (e.getMessage().equals("j")) {
                        JOptionPane.showMessageDialog(this, "Invalid wall height. Please enter a valid number greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (e.getMessage().equals("k")) {
                        JOptionPane.showMessageDialog(this, "Invalid repetitions. Please enter a valid number greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid wall height and repetitions for Rock Climbing. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    return;
                }
                break;
            default:
                break;
        }

        if (exercise != null) {
            exercises.add(exercise);
            updateExerciseList();
            sortByCalories();
            clearInputFields();
        }
    }
    
    /**
     * Sorts the exercises by calories burned.
     */
    private void sortByCalories() {
        Collections.sort(exercises, new ExerciseCompareByCalories());
    }

    /**
     * Updates the exercise list.
     */
    private void updateExerciseList() {
        txtAreaExercises.setText("");
        for (Exercise exercise : exercises) {
            txtAreaExercises.append(exercise.toString() + "\n");
        }
    }

    /**
     * Clears input fields after adding an exercise.
     */

    private void clearInputFields() {
        txtName.setText("");
        txtDate.setText("");
        txtDuration.setText("");
        txtDistance.setText("");
        txtComments.setText("");
    }
    
    /**
     * Enables or disables all components in the GUI.
     * @param enabled | The state to set.
     */
    public void enableAll(boolean enabled) {
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            component.setEnabled(enabled);
        }
        btnAddExercise.setEnabled(enabled);
    }
    
    /**
     * Saves exercises to a file.
     */
    private void saveExercisesToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ExerciseWriter.saveToFile(exercises, selectedFile.getAbsolutePath());
        } else if (returnValue == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Save operation canceled.");
        } else if (returnValue == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(this, "Error occurred during save operation.");
        }
    }

    /**
     * Main method to start the program.
     * @param args | Command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExerciseTrackerGUI::new);
    }
}
