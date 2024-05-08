package a9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates a dialog for user login.
 */
class LoginFrame extends JDialog {

    private ExerciseTrackerGUI parent;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    /**
     * Constructs a LoginFrame.
     * @param parent | The parent ExerciseTrackerGUI frame.
     */
    public LoginFrame(ExerciseTrackerGUI parent) {
        this.parent = parent;
        initializeComponents();
    }

    //initializes components of the frame
    private void initializeComponents() {
        setTitle("Login");
        setSize(300, 150);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");

        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JButton btnCancel = new JButton("Cancel");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnLogin);
        btnPanel.add(btnCancel);

        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        btnLogin.addActionListener(e -> {
            performLogin();
        });

        btnCancel.addActionListener(e -> {
            clearFields();
        });
    }

    public boolean loggedIn = false;

    /**
     * Checks if the user is logged in.
     * @return True if the user is logged in, false otherwise.
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    private void performLogin() {
        String enteredUsername = txtUsername.getText().trim();
        String enteredPassword = new String(txtPassword.getPassword());

        //expected credentials for login
        String expectedUsername = "healthy";
        String expectedPassword = "donut";

        if (enteredUsername.equals(expectedUsername) && enteredPassword.equals(expectedPassword)) {
            loggedIn = true;
            parent.setVisible(true);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect username/password", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //method to clear all fields
    private void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    /**
     * Displays the login dialog.
     * @param parent | The parent JFrame.
     * @return True if the login was successful, false otherwise.
     */
    public static boolean showDialog(JFrame parent) {
        LoginFrame loginFrame = new LoginFrame((ExerciseTrackerGUI) parent);
        loginFrame.setModal(true);
        loginFrame.setVisible(true);
        boolean loggedIn = loginFrame.isLoggedIn();
        ExerciseTrackerGUI exerciseTrackerGUI = (ExerciseTrackerGUI) parent;
        if (exerciseTrackerGUI != null) {
            exerciseTrackerGUI.enableAll(loggedIn);
        }
        return loggedIn;
    }
}
