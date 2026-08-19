import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * customJFrame makes a GUI for collecting dietary survey data that includes
 * first and last name, phone number, email, sex, how much do they each drink or run in a day adn there weight
 */

public class CustomJFrame extends JFrame {

    private JLabel headingLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel phoneNumberLabel;
    private JLabel emailLabel;
    private JLabel dietaryLabel;
    private JLabel genderLabel;
    private JLabel waterLabel;
    private JLabel mealsLabel;
    private JLabel checkBoxLabel;
    private JLabel walkLabel;
    private JLabel weightLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private JTextField emailTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton preferRadioButton;
    private ButtonGroup radioButtonGroup;
    private JSpinner waterIntakeSpinner;
    private JCheckBox wheatCheckBox;
    private JCheckBox sugarCheckBox;
    private JCheckBox dairyCheckBox;
    private JSlider mealSlider;
    private JComboBox<String> walkComboBox;
    private String[] walkOptions;
    private JFormattedTextField weightFormattedTextField;
    private JButton clearButton;
    private JButton submitButton;
    private FileHandler fileHandler;
    
    /**
     * creates and displays the GUI with all the input needed from the user
     */
    public CustomJFrame() {
        super("Dietary Survey");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(new GridBagLayout());

        fileHandler = new FileHandler();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // creates the header
        headingLabel = new JLabel("Personal Information");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        
        add(headingLabel, gbc);
        gbc.gridwidth = 1;
        
        //creates the first name input section 
        firstNameLabel = new JLabel("First Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(firstNameLabel, gbc);
        firstNameTextField = new JTextField();
        
        gbc.gridx = 1;
        add(firstNameTextField, gbc);

        //creates the last name input section 
        lastNameLabel = new JLabel("Last Name:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lastNameLabel, gbc);
        lastNameTextField = new JTextField();
        
        gbc.gridx = 1;
        add(lastNameTextField, gbc);
        
        //creates the phone number input section 
        phoneNumberLabel = new JLabel("Phone Number:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(phoneNumberLabel, gbc);
        phoneNumberTextField = new JTextField();
        
        gbc.gridx = 1;
        add(phoneNumberTextField, gbc);
        
        //creates the email input section 
        emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(emailLabel, gbc);
        emailTextField = new JTextField();
        
        gbc.gridx = 1;
        add(emailTextField, gbc);
        
        //creates the sex or gender input section 
        genderLabel = new JLabel("Sex:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.NORTH;
        add(genderLabel, gbc);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        preferRadioButton = new JRadioButton("Prefer not to say");

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.Y_AXIS));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderPanel.add(preferRadioButton);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(genderPanel, gbc);
        
        //creates new section about dietary questions 
        dietaryLabel = new JLabel("Dietary Questions");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(dietaryLabel, gbc);
        
        //creates the cups of water input section 
        waterLabel = new JLabel("How many cups of water on average do you drink a day?", SwingConstants.CENTER);
        gbc.gridy = 7;
        add(waterLabel, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));
        
        add(waterIntakeSpinner, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        //creates the meals a day input section 
        mealsLabel = new JLabel("How many meals on average do you eat a day?", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(mealsLabel, gbc);
        
        mealSlider = new JSlider(0, 10, 3);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setPaintTicks(true);
        mealSlider.setPaintLabels(true);
        mealSlider.setSnapToTicks(true);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(mealSlider, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        
        //creates the check box section to see if the food they ate in a day contains certain things 
        checkBoxLabel = new JLabel("Do any of these meals regularly contain dairy, wheat, or sugar?", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(checkBoxLabel, gbc);
        
        wheatCheckBox = new JCheckBox("Wheat");
        sugarCheckBox = new JCheckBox("Sugar");
        dairyCheckBox = new JCheckBox("Dairy");
           
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(wheatCheckBox);
        checkBoxPanel.add(sugarCheckBox);
        checkBoxPanel.add(dairyCheckBox);
        gbc.gridy = 12;
        add(checkBoxPanel, gbc);
        
        //creates a input section to see how much the walk in a day
        walkLabel = new JLabel("On average, how many miles do you walk in a day?", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(walkLabel, gbc);

        gbc.gridy = 14;
        walkOptions = new String[] {
        	    "Less than 1 Mile",
        	    "More than 1 mile but less than 2 miles",
        	    "More than 2 miles but less than 3 miles",
        	    "More than 3 miles"
        	};
       
        walkComboBox = new JComboBox<>(walkOptions);
        add(walkComboBox, gbc);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        
        //creates the weight input section 
        weightLabel = new JLabel("How much do you weigh?", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(weightLabel, gbc);
        gbc.gridy = 16;
        
        weightFormattedTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
        add(weightFormattedTextField, gbc);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        clearButton.setBackground(java.awt.Color.YELLOW);
        submitButton.setBackground(java.awt.Color.GREEN);
        
        //creates the buttons at the bottom of the GUI either submit or clear
        JPanel buttonPanel = new JPanel(new java.awt.BorderLayout());
        buttonPanel.add(clearButton, java.awt.BorderLayout.WEST);
        buttonPanel.add(submitButton, java.awt.BorderLayout.EAST);
        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        InnerActionListener listener = new InnerActionListener();
        submitButton.addActionListener(listener);
        clearButton.addActionListener(listener);

        setVisible(true);
    }

    private class InnerActionListener implements ActionListener {
    	/**
         * handles action performed on runtime of the GUI
         * @param act the ActionEvent triggered by button press
         */
    	public void actionPerformed(ActionEvent act) {
            if (act.getSource() == submitButton) {
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            	String time = LocalDateTime.now().format(formatter);

            	String data = time + "," +
                        firstNameTextField.getText() + "," +
                        lastNameTextField.getText() + "," +
                        phoneNumberTextField.getText() + "," +
                        emailTextField.getText() + "," +
                        getSelectedGender() + "," +
                        waterIntakeSpinner.getValue() + "," +
                        mealSlider.getValue() + "," +
                        wheatCheckBox.isSelected()  + "," +
                        sugarCheckBox.isSelected()  + "," +
                        dairyCheckBox.isSelected()  + "," +
                        walkComboBox.getSelectedItem() + "," +
                        weightFormattedTextField.getText();

                fileHandler.writeResults(data);
            }
            clearForm();
        }
    	
    	/**
         * returns selected gender string from radio buttons to get put into string data
         * @return gender as String
         */
        
    	private String getSelectedGender() {
            if (maleRadioButton.isSelected()) return "Male";
            if (femaleRadioButton.isSelected()) return "Female";
            if (preferRadioButton.isSelected()) return "Prefer not to say";
            return "";
        }
    	
    	/**
         * resets all inputs to their original states
         */
        private void clearForm() {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            phoneNumberTextField.setText("");
            emailTextField.setText("");
            radioButtonGroup.clearSelection();
            waterIntakeSpinner.setValue(15);
            mealSlider.setValue(3);
            wheatCheckBox.setSelected(false);
            sugarCheckBox.setSelected(false);
            dairyCheckBox.setSelected(false);
            walkComboBox.setSelectedIndex(0);
            weightFormattedTextField.setValue(null);
        }
    }
}
