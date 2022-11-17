import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.text.DecimalFormat;

public class GUI implements ActionListener {
    public static JFrame frame; 
    public static JPanel panel;
    public static JLabel weightLabel;
    public static JLabel hightLabel;
    public static JButton submitButton;
    public static JLabel summaryLabel;
    public static JTextField weighTextField;
    public static JTextField highTextField;
    public static JButton imperialButton;


    final static double KG_TO_LBS = 2.20462;
	final static double M_TO_IN = 39.3701;
	private static DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat(".##");

    public static void main(String[] Args){
        frame = new JFrame();
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(null);

        frame.add(panel);

        weightLabel = new JLabel("enter weight in KG");
        weightLabel.setBounds(10, 20, 150, 20);
        panel.add(weightLabel);

        weighTextField = new JTextField();
        weighTextField.setBounds(200, 20, 50, 20);
        panel.add(weighTextField);

        hightLabel = new JLabel("enter hight in M");
        hightLabel.setBounds(10, 40, 150, 20);
        panel.add(hightLabel);

        highTextField = new JTextField();
        highTextField.setBounds(200, 40, 50, 20);
        panel.add(highTextField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(80, 60, 100, 20);
        panel.add(submitButton);
        submitButton.addActionListener(new GUI());

        summaryLabel = new JLabel();
        summaryLabel.setBounds(10, 80, 500, 20);
        panel.add(summaryLabel);

        imperialButton = new JButton("Imperial");
        imperialButton.setBounds(200, 60, 100, 20);
        panel.add(imperialButton);
        imperialButton.addActionListener(new GUI());


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        submitButtonListener();
        imperialButtonListener();

    }
    

    public void submitButtonListener(){
        
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                double res = calculate();
                String cat = getCategory(res);
                summaryLabel.setText("your BMI is " + TWO_DECIMAL_PLACES.format(res) + ", your category is " + cat);
                submitButton.setEnabled(false);
            }
        };

        submitButton.addActionListener(buttonListener);   
    }

    public void imperialButtonListener(){
        
        ActionListener buttonListener1 = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                double res = calculate();
                String cat = getCategory(res);
                    summaryLabel.setText("your BMI is " + TWO_DECIMAL_PLACES.format(res * 2.2) + ", your category is " + cat);  
            }
        };
        imperialButton.addActionListener(buttonListener1);   
    }


    public static double calculate() {
		double height, weight;
        double result=0;
		weight = Double.parseDouble(GUI.weighTextField.getText());	
		height = Double.parseDouble(GUI.highTextField.getText());
		result = weight / (Math.pow(height, 2));
		return (result);
		
	}

	// THE BMI CATEGORIES
	public static String getCategory (double result) {
		String category;
		if (result < 15) {
			category = "very severely underweight";
		} else if (result >=15 && result <= 16) {
			category = "severely underweight";
		} else if (result >16 && result <= 18.5) {
			category = "underweight";
		} else if (result >18.5 && result <= 25) {
			category = "normal (healthy weight)";
		} else if (result >25 && result <= 30) {
			category = "overweight";
		} else if (result >30 && result <= 35) {
			category = "moderately obese";
		} else if (result >35 && result <= 40) {
			category = "severely obese";
		} else {
			category ="very severely obese";
		}
		return category;
	}
}
