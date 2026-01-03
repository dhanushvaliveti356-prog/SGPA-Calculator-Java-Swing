import javax.swing.*;          // Swing components
import java.awt.*;             // Layouts and Color
import java.awt.event.*;       // Event handling

// SGPA Calculator class
class SgpaCalculator implements ActionListener
{
    // ComboBoxes for selecting grades of each subject
    JComboBox t1, t2, t3, t4, t5, t6, t7, t8, t9;

    // TextField to display CGPA result
    JTextField y;

    // Button to calculate CGPA
    JButton b1;

    // Constructor to design the GUI
    SgpaCalculator()
    {
        // Create main frame
        JFrame f = new JFrame("SGPA CALCULATOR");

        // Grade options
        String[] p = {"A+","A","B","C","D","E"};

        // Set background color
        f.getContentPane().setBackground(new Color(173, 216, 230));

        // Subject labels
        JLabel l1 = new JLabel("CS211");
        JLabel l2 = new JLabel("CS212");
        JLabel l3 = new JLabel("CS213");
        JLabel l4 = new JLabel("CS214");
        JLabel l5 = new JLabel("CS215");
        JLabel l6 = new JLabel("CS216");
        JLabel l7 = new JLabel("CS251");
        JLabel l8 = new JLabel("CS252");
        JLabel l9 = new JLabel("CS253");
        JLabel l10 = new JLabel("Result");

        // ComboBoxes for grades
        t1 = new JComboBox(p);
        t2 = new JComboBox(p);
        t3 = new JComboBox(p);
        t4 = new JComboBox(p);
        t5 = new JComboBox(p);
        t6 = new JComboBox(p);
        t7 = new JComboBox(p);
        t8 = new JComboBox(p);
        t9 = new JComboBox(p);

        // Button and result TextField
        b1 = new JButton("CGPA");
        y = new JTextField();
        y.setEditable(false);   // Result should not be edited by user

        // Set layout of frame
        f.setLayout(new GridLayout(11, 2, 5, 7));

        // Add components to frame
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(t4);
        f.add(l5); f.add(t5);
        f.add(l6); f.add(t6);
        f.add(l7); f.add(t7);
        f.add(l8); f.add(t8);
        f.add(l9); f.add(t9);
        f.add(l10); f.add(b1);
        f.add(y);

        // Frame settings
        f.setSize(400, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Register button click event
        b1.addActionListener(this);
    }

    // Method to convert grade to grade point
    int grade(String s)
    {
        if (s.equals("A+")) return 10;
        if (s.equals("A"))  return 9;
        if (s.equals("B"))  return 8;
        if (s.equals("C"))  return 7;
        if (s.equals("D"))  return 6;
        if (s.equals("E"))  return 5;
        return 0;
    }

    // Event handler for button click
    public void actionPerformed(ActionEvent e)
    {
        // Store all ComboBoxes in an array
        JComboBox[] arr = {t1, t2, t3, t4, t5, t6, t7, t8, t9};

        // Credits for each subject
        double[] c = {3, 2, 3, 3, 3, 3, 2, 1.5, 1.5};

        double sum = 0;     // Total grade points
        double to = 0;      // Total credits (must be double)

        // Calculate weighted grade points
        for (int i = 0; i < arr.length; i++)
        {
            int k = grade((String) arr[i].getSelectedItem());
            sum += k * c[i];
            to  += c[i];
        }

        // Calculate CGPA
        double cg = sum / to;

        // Round off CGPA to 2 decimal places
        String sp = String.format("%.2f", cg);

        // Display result
        y.setText(sp);
    }

    // Main method
    public static void main(String[] args)
    {
        new SgpaCalculator();
    }
}


