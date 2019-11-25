import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class startLogo {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					startLogo window = new startLogo();
					window.frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public startLogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		Timer time = new Timer();
		time.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				
				Authenticate lobj = new Authenticate();
				lobj.main(null);
				frame.dispose();
			}
		}, 3200);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\emuds2.png"));
		lblNewLabel.setBounds(0, 0, 500, 500);
		frame.getContentPane().add(lblNewLabel);
	
	
	}
}