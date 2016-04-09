import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.io.*;

public class Voting 
{
	  private JPanel mainPanel;
	  private JPanel panel;
	  private JPanel message;
	  
	  
	  JComboBox<String> drop;
	  private JButton button;
	  private JTextField fname;
	  private JTextField lname;
	  private JLabel label;
	  private File f;
	  private String text;//whats going to be written to the console
	  
	public Voting()
	{
		mainPanel = new JPanel();
		panel = new JPanel();
	    message = new JPanel();
	    GridLayout layout = new GridLayout(0, 1);//Create with a grid layout of a single column
	    GridLayout mainLayout = new GridLayout(2,1);//Create with a grid layout of a single column
	    panel.setLayout(layout);
	    message.setLayout(layout);
	    mainPanel.setLayout(mainLayout);
		String[] dropdownContents = {"John Cena", "God Emperor Trump", "Based Martin Shkreli", "Al Gore"};
		drop = new JComboBox<String>(dropdownContents);
		
		button = new JButton("submit vote"); //vote button
		fname = new JTextField(5);
	    lname = new JTextField(5);
	    fname.setText("First Name");
	    lname.setText("Last Name");
		label = new JLabel(text);


		//Load the listener
		button.addActionListener(buttonListener());

		//load the panel
	    mainPanel.add(panel);
		panel.add(button);

	    mainPanel.add(message);
	    panel.add(drop);

		panel.add(fname);
	    panel.add(lname);
	    message.add(label);
	}
	
	public Component getContent()
	{
		return(mainPanel);
	}
	
	private ActionListener buttonListener()
	{
		{
			ActionListener listener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					//use a regular expression to see if its just characters and no spaces
		          if((fname.getText().matches("[a-zA-Z0-9]+")) && (fname.getText().matches("[a-zA-Z0-9]+"))) //.matches returns a bool with a regex
		          {
		              try 
		              {
		                String filename = fname.getText() + "_" + lname.getText() + "_ballot.txt";
		                f = new File(filename);
		                boolean filebool = f.createNewFile();
		                if (filebool)
		                {
		                  FileWriter fwriter = new FileWriter(f,true);
		                  BufferedWriter bwriter = new BufferedWriter(fwriter);
		                  
		                  
		                  bwriter.write(drop.getSelectedItem().toString());
		                  bwriter.close();
		                  text = "You voted for " + drop.getSelectedItem().toString();
		                }
		                else
		                {
		                  if(f.exists())
		                  {
		                    BufferedReader breader = null;
		                    FileReader freader = new FileReader(filename);
		                   
		                    String a = "";
		                    
		                    try{
		                      breader = new BufferedReader(freader);
		                      a = breader.readLine();
		                    } catch (IOException g)
		                    {
		                      text = "File Error!";
		                    }
		                    text = "You can't vote twice";
		                  }
		                }
		              }catch (IOException f) 
		              {
		                text = "error";
	
		                f.printStackTrace();
		              }
		          }
		          else
		          {
		            text = "Either the first or last name is not valid";
		          }
		          System.out.println(text);
		          label.setText(text);
				}
			};

			return listener;
		}
	}
}
