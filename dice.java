import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class dice 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	
	public dice()
	{
		panel = new JPanel();
		button = new JButton("Roll");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a number of sides for the die");
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(button);
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
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				int dieNo = Integer.parseInt(input);//convert String to double
				//TODO roll die here
				int randNo = (int)(Math.random()*dieNo) + 1;
				String newText = "Random no: " + randNo;//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}	
}