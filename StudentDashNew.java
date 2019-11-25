import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;

import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;


public class StudentDashNew {

	private JFrame frame;

	String usn , pass ;
	String name ,year , branchId , classId , phoneNo , email , subjectId , teacherId , dob;
	private JTable table;
	private JTable marksTable;
	private JTable atnSub1Tab;
	private JTable atnSub3Tab;
	private JTable atnSub2Tab;
	private JTable detailedAtnTab;
	private JTable facDetailTab;
	private JPasswordField currentPasswordf;
	private JPasswordField newPasswordf;
	private final JDesktopPane desktopPane_6 = new JDesktopPane();


	/**
	 * Launch the application.
	 */
	public static void main(String usn , String pass) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashNew window = new StudentDashNew(usn,pass);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentDashNew(String usn , String pass) 
	{
		this.usn = usn;
		this.pass = pass;

		System.out.println("I am"+usn+" "+pass);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1373, 729);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(new Rectangle(0, 0, 1327, 519));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabbedPane.setBorder(null);
		tabbedPane.setAlignmentY(2.0f);
		tabbedPane.setForeground(new Color(255, 51, 102));
		tabbedPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Segoe Print", Font.BOLD, 30));
		tabbedPane.setBounds(10, 160, 1526, 560);
		frame.getContentPane().add(tabbedPane);

		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from student where usn='"+usn+"'");

			while(rs.next())
			{		
				usn = rs.getString(1);
				name = rs.getString(2);
				year = rs.getString(3);
				branchId = rs.getString(4);
				classId = rs.getString(5);
				teacherId = rs.getString(6);
				dob = rs.getString(7);
				phoneNo = rs.getString(8);
				email = rs.getString(9);
				subjectId = rs.getString(10);
				pass = rs.getString(12);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}



		String teacherName = "";
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select name from teacher where teacher_id = '"+teacherId+"'");

			while(rs.next())
			{
				teacherName += rs.getString(1);
			}

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		/* Attendance */

		JPanel atnPan = new JPanel();
		atnPan.setBackground(Color.WHITE);
		tabbedPane.addTab("Attendance", null, atnPan, null);
		atnPan.setLayout(null);

		String subjectName [] = new String [3];
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select sb1 , sb2 , sb3 from subject where subjectid = '"+subjectId+"' ");

			while(rs.next())
			{
				subjectName[0] = rs.getString(1);
				subjectName[1] = rs.getString(2);
				subjectName[2] = rs.getString(3);

			}

			JScrollPane atnSubScroll1 = new JScrollPane();
			atnSubScroll1.setFont(new Font("Tahoma", Font.PLAIN, 8));
			atnSubScroll1.setSize(new Dimension(20, 20));
			atnSubScroll1.setBounds(40, 90, 418, 105);
			atnPan.add(atnSubScroll1);

			ResultSet rsStatus1=stmt.executeQuery("select status  FROM attendance where usn = '"+usn+"' and subjectId = '"+subjectName[0]+"' ORDER BY date ASC");

			int countDates = 0;
			int countP = 0;
			int countA = 0;
			float atnPerct = 0;

			while(rsStatus1.next())
			{
				countDates++;

				if(rsStatus1.getString(1).toLowerCase().equals("p"))
					countP++;
				else
					countA++;
			}
			if(countDates != 0 )
				atnPerct = (float)(countP *100 )/countDates;

			DefaultTableModel modelAtnSub1 = new DefaultTableModel();

			modelAtnSub1.addColumn("Class Done");
			modelAtnSub1.addColumn("Class Attended");
			modelAtnSub1.addColumn("Class Missed");
			modelAtnSub1.addColumn("Percentage (%)");
			modelAtnSub1.addRow(new Object [] {countDates , countP , countA , atnPerct});

			atnSub1Tab = new JTable(modelAtnSub1);
			atnSub1Tab.setSelectionForeground(new Color(153, 102, 153));
			atnSub1Tab.setSelectionBackground(new Color(255, 255, 255));
			atnSub1Tab.setSize(new Dimension(25, 25));
			atnSub1Tab.setFont(new Font("Tahoma", Font.BOLD, 15));
			atnSub1Tab.setBounds(10,10,10,10);
			atnSubScroll1.setViewportView(atnSub1Tab);

			ResultSet rsStatus2=stmt.executeQuery("select status  FROM attendance where usn = '"+usn+"' and subjectId = '"+subjectName[1]+"' ORDER BY date ASC");

			countDates = 0;
			countP = 0;
			countA = 0;
			atnPerct = 0;

			while(rsStatus2.next())
			{
				countDates++;

				if(rsStatus2.getString(1).toLowerCase().equals("p"))
					countP++;
				else
					countA++;
			}
			if(countDates != 0)
				atnPerct = (float)(countP *100 )/countDates;

			JScrollPane atnSubScroll2 = new JScrollPane();
			atnSubScroll2.setBounds(567, 90, 418, 98);
			atnPan.add(atnSubScroll2);

			DefaultTableModel modelAtnSub2 = new DefaultTableModel();

			modelAtnSub2.addColumn("Class Done");
			modelAtnSub2.addColumn("Class Attended");
			modelAtnSub2.addColumn("Class Missed");
			modelAtnSub2.addColumn("Percentage (%)");
			modelAtnSub2.addRow(new Object [] {countDates , countP , countA , atnPerct});

			atnSub2Tab = new JTable(modelAtnSub2);
			atnSub2Tab.setFont(new Font("Tahoma", Font.BOLD, 15));
			atnSub2Tab.setSelectionForeground(new Color(153, 102, 204));
			atnSub2Tab.setSelectionBackground(new Color(255, 255, 255));
			atnSubScroll2.setViewportView(atnSub2Tab);

			ResultSet rsStatus3=stmt.executeQuery("select status  FROM attendance where usn = '"+usn+"' and subjectId = '"+subjectName[2]+"' ORDER BY date ASC");

			countDates = 0;
			countP = 0;
			countA = 0;
			atnPerct = 0;

			while(rsStatus3.next())
			{
				countDates++;

				if(rsStatus3.getString(1).toLowerCase().equals("p"))
					countP++;
				else
					countA++;
			}
			if(countDates != 0)
				atnPerct = (float)(countP *100 )/countDates;

			JScrollPane atnSubScroll3 = new JScrollPane();
			atnSubScroll3.setBounds(40, 295, 418, 105);
			atnPan.add(atnSubScroll3);

			DefaultTableModel modelAtnSub3 = new DefaultTableModel();

			modelAtnSub3.addColumn("Class Done");
			modelAtnSub3.addColumn("Class Attended");
			modelAtnSub3.addColumn("Class Missed");
			modelAtnSub3.addColumn("Percentage (%)");
			modelAtnSub3.addRow(new Object [] {countDates , countP , countA , atnPerct});

			atnSub3Tab = new JTable(modelAtnSub3);
			atnSub3Tab.setFont(new Font("Tahoma", Font.BOLD, 15));
			atnSubScroll3.setViewportView(atnSub3Tab);
		}
		catch(Exception E)
		{
			JOptionPane.showMessageDialog(null, E.getMessage());
		}

		JScrollPane detailedAtnScroll = new JScrollPane();
		detailedAtnScroll.setFont(new Font("Tahoma", Font.BOLD, 15));
		detailedAtnScroll.setBounds(602, 291, 576, 212);
		atnPan.add(detailedAtnScroll);

		JButton btnDetailAtnSub1 = new JButton("Detailed Attendance");
		btnDetailAtnSub1.setBackground(Color.WHITE);
		btnDetailAtnSub1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

					Statement stmt=con.createStatement();

					DefaultTableModel modelAtnDetail = new DefaultTableModel();

					modelAtnDetail.addColumn("Date");
					modelAtnDetail.addColumn("Class Done");
					modelAtnDetail.addColumn("Status");
					modelAtnDetail.addColumn("Class Attended");
					modelAtnDetail.addColumn("Class Missed");
					modelAtnDetail.addColumn("Percentage");

					int countClass = 0;
					int countClassP = 0;
					int countClassA = 0;
					float atnPerct = 0;

					ResultSet rs=stmt.executeQuery("select date , status  FROM attendance where usn = '"+usn+"' and subjectId = '"+subjectName[0]+"' ORDER BY date ASC ");

					while(rs.next())
					{
						countClass ++;
						if(rs.getString(2).toLowerCase().equals("p"))
							countClassP++;
						else
							countClassA++;

						if(countClass != 0)
							atnPerct = (float)(countClassP * 100)/countClass;

						modelAtnDetail.addRow(new Object [] {rs.getString(1) ,countClass ,rs.getString(2) ,countClassP ,countClassA ,atnPerct});
					}

					detailedAtnTab = new JTable(modelAtnDetail);
					detailedAtnScroll.setViewportView(detailedAtnTab);
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(null, E.getMessage());
				}
			}
		});
		btnDetailAtnSub1.setBounds(40, 206, 154, 34);
		atnPan.add(btnDetailAtnSub1);

		JButton btnDetailAtnSub2 = new JButton("Detailed Attendance");
		btnDetailAtnSub2.setBackground(Color.WHITE);
		btnDetailAtnSub2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

					Statement stmt=con.createStatement();

					DefaultTableModel modelAtnDetail = new DefaultTableModel();

					modelAtnDetail.addColumn("Date");
					modelAtnDetail.addColumn("Class Done");
					modelAtnDetail.addColumn("Status");
					modelAtnDetail.addColumn("Class Attended");
					modelAtnDetail.addColumn("Class Missed");
					modelAtnDetail.addColumn("Percentage");

					int countClass = 0;
					int countClassP = 0;
					int countClassA = 0;
					float atnPerct = 0;

					ResultSet rs=stmt.executeQuery("select date , status  FROM attendance where usn = '"+usn+"' and subjectId = '"+subjectName[1]+"' ORDER BY date ASC ");

					while(rs.next())
					{
						countClass ++;
						if(rs.getString(2).toLowerCase().equals("p"))
							countClassP++;
						else
							countClassA++;

						if(countClass != 0)
							atnPerct = (float)(countClassP * 100)/countClass;

						modelAtnDetail.addRow(new Object [] {rs.getString(1) ,countClass ,rs.getString(2) ,countClassP ,countClassA ,atnPerct});
					}

					detailedAtnTab = new JTable(modelAtnDetail);
					detailedAtnScroll.setViewportView(detailedAtnTab);
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(null, E.getMessage());
				}
			}
		});
		btnDetailAtnSub2.setBounds(567, 199, 154, 34);
		atnPan.add(btnDetailAtnSub2);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		desktopPane.setBackground(new Color(153, 153, 153));
		desktopPane.setBounds(485, 262, 744, 265);
		atnPan.add(desktopPane);

		JLabel lblNewLabel = new JLabel("Detailed View");
		lblNewLabel.setBounds(353, 0, 108, 25);
		desktopPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(153, 153, 204));
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 18));

		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		desktopPane_1.setBackground(new Color(0, 204, 204));
		desktopPane_1.setBounds(28, 54, 447, 197);
		atnPan.add(desktopPane_1);

		JLabel lblSubIdDb1 = new JLabel("<dynamic>");
		lblSubIdDb1.setBounds(154, 0, 120, 34);
		desktopPane_1.add(lblSubIdDb1);
		lblSubIdDb1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblSubIdDb1.setText(subjectName[0]);

		JLabel lblSubIdDb3 = new JLabel("<dynamic>");
		lblSubIdDb3.setBounds(182, 266, 120, 25);
		atnPan.add(lblSubIdDb3);
		lblSubIdDb3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubIdDb3.setText(subjectName[2]);

		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		desktopPane_2.setBackground(new Color(255, 153, 102));
		desktopPane_2.setBounds(28, 262, 447, 197);
		atnPan.add(desktopPane_2);

		JButton btnDetailAtnSub3 = new JButton("Detailed Attendance");
		btnDetailAtnSub3.setBounds(10, 152, 154, 34);
		desktopPane_2.add(btnDetailAtnSub3);
		btnDetailAtnSub3.setBackground(Color.WHITE);

		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		desktopPane_3.setBackground(Color.ORANGE);
		desktopPane_3.setBounds(485, 54, 549, 197);
		atnPan.add(desktopPane_3);

		JLabel label_1 = new JLabel((String) null);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(154, 0, 120, 34);
		desktopPane_3.add(label_1);

		JLabel lblSubIdDb2 = new JLabel("<dynamic>");
		lblSubIdDb2.setBounds(173, 0, 120, 34);
		desktopPane_3.add(lblSubIdDb2);
		lblSubIdDb2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubIdDb2.setText(subjectName[1]);

		JLabel lblNewLabel_1 = new JLabel("EMUDS-Attendance");
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblNewLabel_1.setBounds(28, 11, 237, 25);
		atnPan.add(lblNewLabel_1);
		btnDetailAtnSub3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

					Statement stmt=con.createStatement();

					DefaultTableModel modelAtnDetail = new DefaultTableModel();

					modelAtnDetail.addColumn("Date");
					modelAtnDetail.addColumn("Class Done");
					modelAtnDetail.addColumn("Status");
					modelAtnDetail.addColumn("Class Attended");
					modelAtnDetail.addColumn("Class Missed");
					modelAtnDetail.addColumn("Percentage");

					int countClass = 0;
					int countClassP = 0;
					int countClassA = 0;
					float atnPerct = 0;

					ResultSet rs=stmt.executeQuery("select date , status  FROM attendance where usn = '"+usn+"' and subjectId = '"+subjectName[2]+"' ORDER BY date ASC ");

					while(rs.next())
					{
						countClass ++;
						if(rs.getString(2).toLowerCase().equals("p"))
							countClassP++;
						else
							countClassA++;

						if(countClass != 0)
							atnPerct = (float)(countClassP * 100)/countClass;

						modelAtnDetail.addRow(new Object [] {rs.getString(1) ,countClass ,rs.getString(2) ,countClassP ,countClassA ,atnPerct});
					}

					detailedAtnTab = new JTable(modelAtnDetail);
					detailedAtnScroll.setViewportView(detailedAtnTab);
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(null, E.getMessage());
				}
			}
		});

		JPanel marksPan = new JPanel();
		marksPan.setBackground(Color.WHITE);
		tabbedPane.addTab("Marks", null, marksPan, null);
		marksPan.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 126, 836, 379);
		marksPan.add(scrollPane);
		try
		{
			DefaultTableModel modelMarks = new DefaultTableModel();
			modelMarks.addColumn("Subject ID");
			modelMarks.addColumn("IA 1");
			modelMarks.addColumn("IA 2");
			modelMarks.addColumn("IA 3");
			modelMarks.addColumn("Average");
			modelMarks.addColumn("Status");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			ResultSet rs = stmt.executeQuery("select subjectId  , IA1 , IA2 , IA3 from marks where usn = '"+usn+"' ");



			while(rs.next())
			{
				int countIa = 0;

				float avg = 0;
				if(Integer.parseInt(rs.getString(2)) != -1)
				{
					countIa++;
					avg += Integer.parseInt(rs.getString(2));

					if(Integer.parseInt(rs.getString(3)) != -1)
					{
						countIa++;
						avg += Integer.parseInt(rs.getString(3));

						if(Integer.parseInt(rs.getString(4)) != -1)
						{
							countIa++;
							avg += Integer.parseInt(rs.getString(4));
						}
					}
					if(countIa != 0)
					{
						avg = avg / countIa;
					}
				}

				String marksStatus ;

				if(avg < 21)
					marksStatus = "B.A";
				else
					marksStatus = "A.A";

				int marks[] = new int[3];

				if(rs.getString(2).equals("-1"))
				{
					marks[0] = 0;
				}
				else
					marks[0] = Integer.parseInt(rs.getString(2));

				if(rs.getString(3).equals("-1"))
				{
					marks[1] = 0;
				}
				else
					marks[1] = Integer.parseInt(rs.getString(3));

				if(rs.getString(4).equals("-1"))
				{
					marks[2] = 0;
				}
				else
					marks[2] = Integer.parseInt(rs.getString(4));

				modelMarks.addRow(new Object [] {rs.getString(1),marks[0] ,marks[1] ,marks[2] ,avg ,marksStatus});
			}

			marksTable = new JTable(modelMarks);
			marksTable.setBackground(new Color(204, 204, 204));
			marksTable.setSize(new Dimension(20, 20));
			marksTable.setFont(new Font("Tahoma", Font.BOLD, 20));
			marksTable.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
			marksTable.setModel(modelMarks);
			marksTable.setRowHeight(30);
			marksTable.setBounds(383, 72, 381, 199);

			scrollPane.setViewportView(marksTable);

			JLabel lblNewLabel_4 = new JLabel("EMUDS-Marks Panel");
			lblNewLabel_4.setFont(new Font("Papyrus", Font.BOLD, 40));
			lblNewLabel_4.setBounds(22, 21, 562, 43);
			marksPan.add(lblNewLabel_4);

			JDesktopPane desktopPane_4 = new JDesktopPane();
			desktopPane_4.setBackground(new Color(204, 153, 51));
			desktopPane_4.setBounds(49, 100, 873, 422);
			marksPan.add(desktopPane_4);

			JSeparator separator = new JSeparator();
			separator.setBounds(22, 75, 836, 14);
			marksPan.add(separator);

			JDesktopPane desktopPane_5 = new JDesktopPane();
			desktopPane_5.setBackground(new Color(153, 102, 153));
			desktopPane_5.setBounds(965, 161, 228, 200);
			marksPan.add(desktopPane_5);

			JLabel lblBaBelow = new JLabel("B.A = Below Average");
			lblBaBelow.setBounds(29, 59, 143, 25);
			desktopPane_5.add(lblBaBelow);
			lblBaBelow.setFont(new Font("Sylfaen", Font.PLAIN, 15));

			JLabel lblAaAbove = new JLabel("A.A = Above Average");
			lblAaAbove.setBounds(29, 118, 143, 25);
			desktopPane_5.add(lblAaAbove);
			lblAaAbove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
			desktopPane_6.setBackground(new Color(255, 255, 255));
			desktopPane_6.setBounds(10, 22, 208, 156);
			desktopPane_5.add(desktopPane_6);

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		JPanel facDetailPan = new JPanel();
		facDetailPan.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Faculty Details", null, facDetailPan, null);
		facDetailPan.setLayout(null);

		JScrollPane facDetailScroll = new JScrollPane();
		facDetailScroll.setBounds(89, 116, 1078, 382);
		facDetailPan.add(facDetailScroll);

		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			DefaultTableModel modelFacDetail = new DefaultTableModel();
			modelFacDetail.addColumn("Subject Id");
			modelFacDetail.addColumn("Teacher Name");
			modelFacDetail.addColumn("Phone No");
			modelFacDetail.addColumn("Email ID");

			ResultSet rsTeach1 = stmt.executeQuery("select subjectteachid ,name ,phoneno ,email from teacher where subjectteachid = '"+subjectName[0]+"' and branch_id = '"+branchId+"'  ");

			while(rsTeach1.next())
			{
				modelFacDetail.addRow(new Object [] {rsTeach1.getString(1) ,rsTeach1.getString(2) ,rsTeach1.getString(3) ,rsTeach1.getString(4)});
			}

			ResultSet rsTeach2 = stmt.executeQuery("select subjectteachid ,name ,phoneno ,email from teacher where subjectteachid = '"+subjectName[1]+"' and branch_id = '"+branchId+"'  ");

			while(rsTeach2.next())
			{
				modelFacDetail.addRow(new Object [] {rsTeach2.getString(1) ,rsTeach2.getString(2) ,rsTeach2.getString(3) ,rsTeach2.getString(4)});
			}

			ResultSet rsTeach3 = stmt.executeQuery("select subjectteachid ,name ,phoneno ,email from teacher where subjectteachid = '"+subjectName[2]+"' and branch_id = '"+branchId+"'  ");

			while(rsTeach3.next())
			{
				modelFacDetail.addRow(new Object [] {rsTeach3.getString(1) ,rsTeach3.getString(2) ,rsTeach3.getString(3) ,rsTeach3.getString(4)});
			}

			facDetailTab = new JTable(modelFacDetail);
			facDetailTab.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			facDetailTab.setBackground(new Color(255, 204, 153));
			facDetailTab.setRowHeight(50);
			facDetailScroll.setViewportView(facDetailTab);

			JLabel lblEmudsfacultyDetials = new JLabel("EMUDS-Faculty Detials");
			lblEmudsfacultyDetials.setFont(new Font("Papyrus", Font.BOLD, 40));
			lblEmudsfacultyDetials.setBounds(10, 11, 562, 53);
			facDetailPan.add(lblEmudsfacultyDetials);

			JSeparator separator = new JSeparator();
			separator.setBounds(20, 82, 1, 2);
			facDetailPan.add(separator);

			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(20, 69, 850, 15);
			facDetailPan.add(separator_1);

			JDesktopPane desktopPane_4 = new JDesktopPane();
			desktopPane_4.setBackground(new Color(0, 0, 102));
			desktopPane_4.setBounds(53, 82, 1153, 444);
			facDetailPan.add(desktopPane_4);
		}
		catch(Exception E)
		{
			JOptionPane.showMessageDialog(null, E.getMessage());
		}

		JButton btnlogout = new JButton("Click here to  ->Logout");
		btnlogout.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int inputt = JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout?");
				if(inputt==0)
				{
					Authenticate obj=new Authenticate();
					obj.main(null);
					frame.setVisible(false);
				}
			}
		});

		JPanel profilePan = new JPanel();
		profilePan.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Profile", null, profilePan, null);
		profilePan.setLayout(null);

		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(69, 138, 87, 51);
		profilePan.add(lblName);

		JLabel lblUsn = new JLabel("USN :");
		lblUsn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsn.setBounds(69, 200, 87, 51);
		profilePan.add(lblUsn);

		JLabel lblClasId = new JLabel("Class Id :");
		lblClasId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClasId.setBounds(69, 262, 87, 51);
		profilePan.add(lblClasId);

		JLabel lblDept = new JLabel("Dept. :");
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDept.setBounds(69, 324, 87, 51);
		profilePan.add(lblDept);

		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYear.setBounds(553, 200, 131, 51);
		profilePan.add(lblYear);

		JLabel lblPhone = new JLabel("Phone No :");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(553, 262, 131, 51);
		profilePan.add(lblPhone);

		JLabel lblEmail = new JLabel("Email ID :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(553, 324, 131, 51);
		profilePan.add(lblEmail);

		JLabel lblDob = new JLabel("DOB :");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDob.setBounds(553, 138, 87, 51);
		profilePan.add(lblDob);

		JLabel lblProctor = new JLabel("Proctor :");
		lblProctor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProctor.setBounds(69, 388, 87, 51);
		profilePan.add(lblProctor);

		JLabel lblNameDb = new JLabel("<dynamic>");
		lblNameDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNameDb.setBounds(166, 145, 377, 45);
		profilePan.add(lblNameDb);

		JLabel lblDeptDb = new JLabel("<dynamic>");
		lblDeptDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDeptDb.setBounds(166, 330, 377, 45);
		profilePan.add(lblDeptDb);

		JLabel lblClassIdDb = new JLabel("<dynamic>");
		lblClassIdDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblClassIdDb.setBounds(166, 268, 377, 45);
		profilePan.add(lblClassIdDb);

		JLabel lblUsnDb = new JLabel(usn);
		lblUsnDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblUsnDb.setBounds(166, 206, 377, 45);
		profilePan.add(lblUsnDb);

		JLabel lblProctorDb = new JLabel("<dynamic>");
		lblProctorDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblProctorDb.setBounds(166, 394, 377, 45);
		profilePan.add(lblProctorDb);

		lblNameDb.setText(name);
		lblDeptDb.setText(branchId);
		lblClassIdDb.setText(classId);
		lblUsnDb.setText(usn);
		lblProctorDb.setText(teacherName);

		JLabel lblNewLabel_8 = new JLabel("EMUDS-Your Profile");
		lblNewLabel_8.setFont(new Font("Papyrus", Font.BOLD, 40));
		lblNewLabel_8.setBounds(10, 11, 506, 45);
		profilePan.add(lblNewLabel_8);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 67, 718, 12);
		profilePan.add(separator_1);

		JDesktopPane desktopPane_4 = new JDesktopPane();
		desktopPane_4.setBackground(new Color(0, 204, 255));
		desktopPane_4.setBounds(20, 82, 1003, 401);
		profilePan.add(desktopPane_4);

		JDesktopPane desktopPane_5 = new JDesktopPane();
		desktopPane_5.setBackground(new Color(255, 255, 255));
		desktopPane_5.setBounds(35, 60, 475, 50);
		desktopPane_4.add(desktopPane_5);

		JDesktopPane desktopPane_7 = new JDesktopPane();
		desktopPane_7.setBackground(Color.WHITE);
		desktopPane_7.setBounds(35, 121, 475, 50);
		desktopPane_4.add(desktopPane_7);

		JDesktopPane desktopPane_8 = new JDesktopPane();
		desktopPane_8.setBackground(Color.WHITE);
		desktopPane_8.setBounds(35, 182, 475, 50);
		desktopPane_4.add(desktopPane_8);

		JDesktopPane desktopPane_9 = new JDesktopPane();
		desktopPane_9.setBackground(Color.WHITE);
		desktopPane_9.setBounds(35, 249, 475, 50);
		desktopPane_4.add(desktopPane_9);

		JDesktopPane desktopPane_10 = new JDesktopPane();
		desktopPane_10.setBackground(Color.WHITE);
		desktopPane_10.setBounds(35, 310, 475, 50);
		desktopPane_4.add(desktopPane_10);

		JDesktopPane desktopPane_11 = new JDesktopPane();
		desktopPane_11.setBackground(Color.WHITE);
		desktopPane_11.setBounds(516, 60, 452, 50);
		desktopPane_4.add(desktopPane_11);
		
				JLabel lblDobDb = new JLabel("<dynamic>");
				lblDobDb.setBounds(127, 0, 316, 45);
				desktopPane_11.add(lblDobDb);
				lblDobDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
				lblDobDb.setText(dob);

		JDesktopPane desktopPane_12 = new JDesktopPane();
		desktopPane_12.setBackground(Color.WHITE);
		desktopPane_12.setBounds(516, 121, 452, 50);
		desktopPane_4.add(desktopPane_12);
		
				JLabel lblYearDb = new JLabel("<dynamic>");
				lblYearDb.setBounds(131, 0, 305, 45);
				desktopPane_12.add(lblYearDb);
				lblYearDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
				lblYearDb.setText(year);

		JDesktopPane desktopPane_13 = new JDesktopPane();
		desktopPane_13.setBackground(Color.WHITE);
		desktopPane_13.setBounds(516, 182, 452, 50);
		desktopPane_4.add(desktopPane_13);
		
				JLabel lblPhoneDb = new JLabel("<dynamic>");
				lblPhoneDb.setBounds(121, 0, 305, 45);
				desktopPane_13.add(lblPhoneDb);
				lblPhoneDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
				lblPhoneDb.setText(phoneNo);

		JDesktopPane desktopPane_14 = new JDesktopPane();
		desktopPane_14.setBackground(Color.WHITE);
		desktopPane_14.setBounds(516, 249, 452, 50);
		desktopPane_4.add(desktopPane_14);
		
				JLabel lblEmailDb = new JLabel("<dynamic>");
				lblEmailDb.setBounds(111, 0, 341, 45);
				desktopPane_14.add(lblEmailDb);
				lblEmailDb.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblEmailDb.setText(email);

		JPanel changePassTab = new JPanel();
		changePassTab.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Change Password", null, changePassTab, null);
		changePassTab.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("EMUDS-Change Password");
		lblNewLabel_6.setFont(new Font("Segoe Script", Font.BOLD, 28));
		lblNewLabel_6.setBounds(10, 23, 437, 34);
		changePassTab.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Current Password");
		lblNewLabel_7.setFont(new Font("Sylfaen", Font.PLAIN, 39));
		lblNewLabel_7.setBounds(418, 124, 331, 40);
		changePassTab.add(lblNewLabel_7);

		currentPasswordf = new JPasswordField();
		currentPasswordf.setBounds(469, 196, 195, 34);
		changePassTab.add(currentPasswordf);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Sylfaen", Font.PLAIN, 39));
		lblNewPassword.setBounds(453, 266, 331, 40);
		changePassTab.add(lblNewPassword);

		newPasswordf = new JPasswordField();
		newPasswordf.setBounds(469, 342, 195, 34);
		changePassTab.add(newPasswordf);

		JButton btnNewButton_2 = new JButton("Confirm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

					Statement stmt=con.createStatement();

					if(currentPasswordf.getText().equals("") || newPasswordf.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "1 or both Fields Empty");
					}
					else
					{

						if(currentPasswordf.getText().equals(pass) )
						{
							if(currentPasswordf.getText().equals(newPasswordf.getText()))
							{
								JOptionPane.showMessageDialog(null, "Same Password");
							}
							else
							{	
								String query = "update student set password = '"+newPasswordf.getText()+"' where usn = '"+usn+"' ";
								stmt.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Password Changed");

								frame.setVisible(false);
								Authenticate obj = new Authenticate();
								obj.main(null);								
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong Password");
						}

					}
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(null, E.getMessage());
				}
			}
		});
		btnNewButton_2.setBackground(new Color(102, 204, 255));
		btnNewButton_2.setBounds(526, 434, 98, 34);
		changePassTab.add(btnNewButton_2);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\tenorlogout.gif"));
		lblNewLabel_5.setBounds(441, 11, 207, 60);
		changePassTab.add(lblNewLabel_5);
		btnlogout.setBackground(new Color(204, 102, 153));
		btnlogout.setFont(new Font("Snap ITC", Font.PLAIN, 40));
		tabbedPane.addTab("Logout", null, btnlogout, null);
		tabbedPane.setForegroundAt(5, new Color(204, 0, 102));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\studenttext.gif"));
		lblNewLabel_2.setBounds(1059, 23, 477, 53);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("EMUDS");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Segoe Script", Font.BOLD, 55));
		lblNewLabel_3.setBounds(20, 33, 345, 53);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_9 = new JLabel(name);
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Sylfaen", Font.BOLD, 23));
		lblNewLabel_9.setBounds(1159, 114, 232, 35);
		frame.getContentPane().add(lblNewLabel_9);



		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1536, 799);
		frame.getContentPane().add(label);
		label.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\studentbackgg2.jpg"));

	}
}
