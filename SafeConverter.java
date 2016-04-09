import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class SafeConverter 
{
	private JPanel panel;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JTextField text;
	private JLabel label;
	
	public SafeConverter()
	{
		panel = new JPanel();
		b1 = new JButton("Convert F to C");
		b2 = new JButton("Convert F to K");
		b3 = new JButton("Convert C to K");
		b4 = new JButton("Convert C to F");
		b5 = new JButton("Convert K to F");
		b6 = new JButton("Convert K to C");

		
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature");
		
		//Load the listener
		b1.addActionListener(buttonListener());	
		b2.addActionListener(buttonListener());	
		b3.addActionListener(buttonListener());	
		b4.addActionListener(buttonListener());	
		b5.addActionListener(buttonListener());	
		b6.addActionListener(buttonListener());	

		
		//load the panel
		panel.add(text);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);


		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) // convert F to C
			{
				String input = text.getText();
				
				System.out.println(input);

				String ex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
				
				if(input != ex)
				{
					System.out.println("Not a valid number");
				}else if(e.getActionCommand() == "Convert F to C")
				{
					double tempInF = Double.parseDouble(input);//convert String to double
					double tempInC = (tempInF-32)*(5.0/9.0); //convert F to C
					String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}else if(e.getActionCommand() == "Convert F to K")
				{
					double tempInF = Double.parseDouble(input);//convert String to double
					double tempInK = (tempInF + 459.67)*(5.0/9.0); //convert F to K
					String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}else if(e.getActionCommand() == "Convert C to K")
				{
				
					double tempInF = Double.parseDouble(input);//convert String to double
					double tempInK = (tempInF + 273.15); //convert F to K
					String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}else if(e.getActionCommand() == "Convert C to F")
				{
					double tempInC = Double.parseDouble(input);//convert String to double
					double tempInF = (tempInC*(9.0/5.0))+32; //convert F to C
					String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}else if(e.getActionCommand() == "Convert K to F")
				{
					double tempInK = Double.parseDouble(input);//convert String to double
					double tempInF = (tempInK*(5.0/9.0))-459.67; //convert F to C
					String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}else if(e.getActionCommand() == "Convert K to C")
				{
					double tempInK = Double.parseDouble(input);//convert String to double
					double tempInC = (tempInK)-273.15; //convert F to C
					String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}

			}
		};
		
		return listener;
	}	
}