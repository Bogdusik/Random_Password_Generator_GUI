import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Renders the GUI components (frontend)
// This class inherits from JFrame
public class PasswordGeneratorGUI extends JFrame {
    private final PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        // create a frame and add a title
        super("Password Generator");

        // set the size of the GUI
        setSize(540, 570);

        // prevent GUI from being resized
        setResizable(false);

        // use absolute positioning for all components
        setLayout(null);

        // terminate the program when the GUI is closed (ends the process)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // center the GUI on the screen
        setLocationRelativeTo(null);

        // init password generator
        passwordGenerator = new PasswordGenerator();

        // render GUI components
        addGuiComponents();

    }

    private void addGuiComponents(){
        // create title text
        JLabel titleLabel = new JLabel("Password Generator");

        // increase the font size and make it bold
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        // center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // set x,y coordinates and width/height values
        titleLabel.setBounds(0, 10, 540, 39);

        // add to GUI
        add(titleLabel);

        //create result text area
        JTextArea passwordOutput = new JTextArea();

        // prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        // add scrollability in case output becomes too big
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 76);


        // create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // create password length label
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        // create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder((BorderFactory.createLineBorder(Color.BLACK)));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);

        // create toggle buttons
        // upper letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        // lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        // number toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        //symbol toggle
        JToggleButton symbolToggle = new JToggleButton("Symbol");
        symbolToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolToggle.setBounds(282,373,225,56);
        add(symbolToggle);

        // create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // generate a password only when length > 0 and one toggle button is pressed
                if(passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || numbersToggle.isSelected() || symbolToggle.isSelected();

                // generate password
                int passwordLength;
                try {
                    passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PasswordGeneratorGUI.this, "Invalid length", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatePassword(
                            passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolToggle.isSelected());

                    // display password back to the user
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);

    }
}
