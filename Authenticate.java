import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Authenticate extends JFrame {

	JLabel l1, l2, l3;
	int c=0;
	JTextField tf1;
	JButton btn1;
	JPasswordField p1;
	private JPanel contentPane,contentPane2;
	String text = "Hello";
	JLabel label;
	int charIndex = 0;;
	int counter=0;
	int counter2=0;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	private boolean succeeded;
	static Authenticate frame; 
	private JTextField idf;
	private JPasswordField passf;
	int counterteacher=0;
	int counterstudent=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new Authenticate();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Authenticate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1334, 692);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(102, 204, 204));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reetik\\Desktop\\tenorgif.gif"));
		lblNewLabel.setBounds(817, 33, 516, 468);
		contentPane.add(lblNewLabel);

		JLabel lblEmuds = new JLabel("EMUDS");
		lblEmuds.setFont(new Font("Berlin Sans FB", Font.BOLD, 35));
		lblEmuds.setBounds(31, 33, 179, 57);
		contentPane.add(lblEmuds);


		JLabel lblId = new JLabel("ID");
		lblId.setBounds(247, 293, 46, 14);
		contentPane.add(lblId);

		idf = new JTextField();
		idf.setBounds(303, 287, 104, 20);
		contentPane.add(idf);
		idf.setColumns(10);

		JLabel lblpass = new JLabel("Passowrd");
		lblpass.setBounds(227, 358, 66, 14);
		contentPane.add(lblpass);

		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setFont(new Font("Poor Richard", Font.PLAIN, 25));
		lblLogin_1.setBounds(303, 220, 104, 31);
		contentPane.add(lblLogin_1);

		passf = new JPasswordField();
		passf.setBounds(303, 355, 104, 20);
		contentPane.add(passf);
		JLabel lblIAm = new JLabel("I AM");
		lblIAm.setFont(new Font("Snap ITC", Font.PLAIN, 55));
		lblIAm.setBounds(595, 164, 212, 71);
		contentPane.add(lblIAm);


		lblId.setVisible(false);
		lblpass.setVisible(false);
		idf.setVisible(false);
		passf.setVisible(false);
		lblLogin_1.setVisible(false);


		JPanel panelteacher = new JPanel();
		contentPane.add(panelteacher);
		panelteacher.setSize(400,350);
		panelteacher.setBounds(165, 175, 352, 316);
		panelteacher.setLayout(null);

		JButton btnLogin_1 = new JButton("LoginT");
		btnLogin_1.setBounds(146, 239, 72, 23);
		panelteacher.add(btnLogin_1);

		btnLogin_1.setOpaque(false);
		btnLogin_1.setForeground(Color.GREEN);
		btnLogin_1.setBackground(Color.PINK);
		btnLogin_1.setIcon(null);

		JLabel epass = new JLabel("Enter ID and Password");
		epass.setForeground(Color.RED);
		epass.setBounds(130, 291, 131, 14);
		JLabel epass2 = new JLabel("Enter ID and Password");
		epass2.setForeground(Color.RED);
		epass2.setBounds(130, 291, 135, 14);
		panelteacher.add(epass);

		btnLogin_1.setVisible(false);
		epass.setVisible(false);
		panelteacher.setVisible(false);
		JPanel panelstudent = new JPanel();
		contentPane.add(panelstudent);
		panelstudent .setSize(400,350);
		panelstudent .setBounds(165, 175, 352, 316);

		panelstudent.setLayout(null);

		panelstudent .setVisible(false);
		JButton btnLogin_2 = new JButton("LoginS");
		btnLogin_2.setBounds(146, 239, 80, 23);
		panelstudent.add(btnLogin_2);
		panelstudent.add(epass2);
		btnLogin_2.setOpaque(false);
		btnLogin_2.setForeground(Color.GREEN);
		btnLogin_2.setBackground(Color.PINK);
		btnLogin_2.setIcon(null);
		btnLogin_2.setVisible(false);

		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {

			int counter=0;	
			public void actionPerformed(ActionEvent arg0) {
				epass.setVisible(false);
				counter++;
				idf.setText("");
				passf.setText("");
				if(counter%2!=0)
				{

					//panel.setBackground(new Color(0,0,0,60));
					panelteacher.setVisible(true);
					JLabel lblLogin = new JLabel("Login(Teacher)");
					lblLogin.setForeground(new Color(204, 51, 51));
					lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
					lblLogin.setBounds(290, 160, 137, 61);
					contentPane.add(lblLogin);
					lblLogin.setVisible(false);

					lblId.setVisible(true);
					lblpass.setVisible(true);
					idf.setVisible(true);
					passf.setVisible(true);
					lblLogin_1.setVisible(true);
					btnLogin_1.setVisible(true);
					btnLogin_2.setVisible(false);
					JLabel lblNewLabel = new JLabel(" ");
					lblNewLabel.setForeground(new Color(128, 0, 0));
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
					lblNewLabel.setBounds(10, 11, 399, 61);
					contentPane.add(lblNewLabel);
				}
				else
				{

					//panel.getContentPane().setBackground(Color.red);
					panelteacher.setVisible(false);
					lblId.setVisible(false);
					panelstudent.setVisible(false);
					lblpass.setVisible(false);
					idf.setVisible(false);
					passf.setVisible(false);
					lblLogin_1.setVisible(false);
					btnLogin_1.setVisible(false);
					btnLogin_2.setVisible(false);

				}

				btnLogin_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						epass.setVisible(false);
						if(idf.getText().equals("")||passf.getText().equals(""))
						{
							epass.setVisible(true);

						}
						else

						{

							try {
								epass2.setVisible(false);
								Class.forName("com.mysql.jdbc.Driver");
								System.out.println("Driver loaded successfully");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
								Statement stmt=con.createStatement();

								ResultSet rs=stmt.executeQuery("select * from teacher where teacher_id='"+idf.getText()+"'and (password='"+passf.getText()+"')");


								int j=0;
								while(rs.next())
								{
									counterteacher++;


									teachDashNew obj=new teachDashNew(idf.getText(),passf.getText());
									obj.main(idf.getText(),passf.getText());
									frame.setVisible(false);

								}

								if(counterteacher==0)
									JOptionPane.showMessageDialog(null," Username or Password Incorrect");


							}
							catch(Exception ee)
							{
								System.out.println(" "+ee.getMessage());
							}


						}}


				});







				btnLogin.setBackground(new Color(0, 139, 139));
				btnLogin.setBounds(1036, 478, 109, 40);
				contentPane.add(btnLogin);

			}
		});

		btnTeacher.setBackground(new Color(51, 204, 204));
		btnTeacher.setBounds(572, 322, 201, 42);
		contentPane.add(btnTeacher);

		JButton btnStudent = new JButton("Student");

		btnStudent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				epass2.setVisible(false);
				counter2++;
				idf.setText("");
				passf.setText("");
				if(counter2%2!=0)
				{

					//panel.setBackground(new Color(0,0,0,60));
					panelstudent.setVisible(true);
					panelteacher.setVisible(false);
					JLabel lblLogin = new JLabel("Login");
					lblLogin.setForeground(new Color(204, 51, 51));
					lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
					lblLogin.setBounds(290, 160, 137, 61);
					contentPane.add(lblLogin);
					lblLogin.setVisible(false);

					lblId.setVisible(true);
					lblpass.setVisible(true);
					idf.setVisible(true);
					passf.setVisible(true);
					lblLogin_1.setVisible(true);
					btnLogin_2.setVisible(true);
					btnLogin_1.setVisible(false);
					JLabel lblNewLabel = new JLabel(" ");
					lblNewLabel.setForeground(new Color(128, 0, 0));
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
					lblNewLabel.setBounds(10, 11, 399, 61);
					contentPane.add(lblNewLabel);


					btnLogin_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {



							if(idf.getText().equals("")||passf.getText().equals(""))
							{
								epass2.setVisible(true);

							}
							else

							{
								try {
									epass2.setVisible(false);
									Class.forName("com.mysql.jdbc.Driver");
									System.out.println("Driver loaded successfully");
									Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
									Statement stmt=con.createStatement();

									ResultSet rs=stmt.executeQuery("select * from student where usn='"+idf.getText()+"'and (student.Password='"+passf.getText()+"')");


									while(rs.next())
									{
										counterstudent++;


										//								 teachDashNew obj=new teachDashNew(idf.getText(),passf.getText());
										//								 obj.main(idf.getText(),passf.getText());

									}

									if(counterstudent==0)
										JOptionPane.showMessageDialog(null," Username or Password Incorrect");



								}
								catch(Exception ee)
								{
									System.out.println(" "+ee.getMessage());
								}

							}
						}


					});

				}
				else
				{

					//panel.getContentPane().setBackground(Color.red);
					panelstudent.setVisible(false);
					panelteacher.setVisible(false);
					lblId.setVisible(false);
					lblpass.setVisible(false);
					idf.setVisible(false);
					passf.setVisible(false);
					lblLogin_1.setVisible(false);
					btnLogin_2.setVisible(false);
					btnLogin_1.setVisible(false);

				}
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});

				btnLogin.setBackground(new Color(0, 139, 139));
				btnLogin.setBounds(1036, 478, 109, 40);
				contentPane.add(btnLogin);

			}
		});
		btnStudent.setBackground(new Color(51, 204, 204));
		btnStudent.setBounds(572, 427, 201, 42);
		contentPane.add(btnStudent);


		btnTeacher.addMouseListener(new MouseAdapter() {
			Color oldcolor = btnTeacher.getBackground();
			Color oldcolor1 = btnTeacher.getForeground();
			public void mouseEntered(MouseEvent me) {
				oldcolor = btnTeacher.getBackground();
				btnTeacher.setBackground(Color.white);
				//	            oldcolor1 = btnTeacher.getForeground();
				//	            btnTeacher.setForeground(Color.cyan);
			}
			public void mouseExited(MouseEvent me) {
				btnTeacher.setBackground(oldcolor);
				//	        	 btnTeacher.setForeground(oldcolor1);
			}
		});
		btnStudent.addMouseListener(new MouseAdapter() {
			Color oldcolor = btnStudent.getBackground();
			public void mouseEntered(MouseEvent me) {
				oldcolor = btnStudent.getBackground();
				btnStudent.setBackground(Color.white);
			}
			public void mouseExited(MouseEvent me) {
				btnStudent.setBackground(oldcolor);
			}
		});



	}
}
