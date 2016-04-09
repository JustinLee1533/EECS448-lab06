import javax.swing.JFrame;


public class diceDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Temperature Converter");
		dice demo = new dice();
		
		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}