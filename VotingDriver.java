import javax.swing.JFrame;

public class VotingDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Votin' time");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    Voting vote = new Voting();

		frame.getContentPane().add(vote.getContent());
			
		frame.pack();
			
		frame.setVisible(true);
	}
	

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
