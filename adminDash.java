import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class adminDash {

	private JFrame frame;
	private JTable branch1StudTab;
	private JTable branch1TeachTab;
	private JTable branch2StudTab;
	private JTable branch2TeachTab;
	private JTable branch3StudTab;
	private JTable branch3TeachTab;
	private JTextField txtteacherid;
	private JTextField txttname;
	private JTextField txtdateofjoin;
	private JTextField txttphone;
	private JTextField txtD;
	private JTextField txtM;
	private JTextField txtY;
	private JTextField txtdesig;
	private JTextField txtclassid;
	private JTextField txttemail;
	String AddEmail ="";
	String strDate;
	private JTextField tfQuery;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(int adminId , String adminName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminDash window = new adminDash(adminId,adminName);
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
	public adminDash(int adminId, String adminName) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1373, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);

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
		tabbedPane.setBounds(20, 188, 1327, 519);
		frame.getContentPane().add(tabbedPane);

		String branchId [] = new String[3];
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select branch_id from branch");

			int count = 0;
			while(rs.next())
			{
				branchId[count] = rs.getString(1);
				count++;
			}
		}
		catch(Exception E)
		{
			JOptionPane.showMessageDialog(null, E.getMessage());
		}

		/* branch 1 */

		JPanel subPan1 = new JPanel();
		subPan1.setBackground(new Color(153, 204, 204));
		tabbedPane.addTab(branchId[0], null, subPan1, null);
		subPan1.setLayout(null);

		JScrollPane branch1StudScroll = new JScrollPane();
		branch1StudScroll.setBounds(54, 77, 428, 336);
		subPan1.add(branch1StudScroll);

		JLabel lblStud1Count = new JLabel("Count :");
		lblStud1Count.setBounds(54, 42, 53, 31);
		subPan1.add(lblStud1Count);

		JLabel lblStud1CountDb = new JLabel("<Dynamic>");
		lblStud1CountDb.setBounds(113, 42, 56, 31);
		subPan1.add(lblStud1CountDb);

		JScrollPane branch1TeachScroll = new JScrollPane();
		branch1TeachScroll.setBounds(629, 77, 428, 336);
		subPan1.add(branch1TeachScroll);

		JLabel lblTeach1Count = new JLabel("Count :");
		lblTeach1Count.setBounds(712, 42, 53, 31);
		subPan1.add(lblTeach1Count);

		JLabel lblTeach1CountDb = new JLabel("<Dynamic>");
		lblTeach1CountDb.setBounds(768, 42, 56, 31);
		subPan1.add(lblTeach1CountDb);

		JLabel lblBranch1Hod = new JLabel("HOD :");
		lblBranch1Hod.setBounds(849, 42, 53, 31);
		subPan1.add(lblBranch1Hod);

		JLabel lblBranch1HodDb = new JLabel("<Dynamic>");
		lblBranch1HodDb.setBounds(892, 42, 56, 31);
		subPan1.add(lblBranch1HodDb);

		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			DefaultTableModel studModel1 = new DefaultTableModel();
			studModel1.addColumn("USN");
			studModel1.addColumn("Name");
			studModel1.addColumn("Year");
			studModel1.addColumn("DOB");

			ResultSet rsStud=stmt.executeQuery("select usn , name , year , dob from student where branch_id = '"+branchId[0]+"' ");

			while(rsStud.next())
			{
				studModel1.addRow(new Object[] {rsStud.getString(1) ,rsStud.getString(2) ,rsStud.getString(3) ,rsStud.getString(4)});
			}

			branch1StudTab = new JTable(studModel1);
			branch1StudScroll.setViewportView(branch1StudTab);

			ResultSet rsStudC1 = stmt.executeQuery("select count(usn) from student where branch_id = '"+branchId[0]+"' ");

			while(rsStudC1.next())
				lblStud1CountDb.setText(rsStudC1.getString(1));

			DefaultTableModel teachModel1 = new DefaultTableModel();

			teachModel1.addColumn("ID");
			teachModel1.addColumn("Name");
			teachModel1.addColumn("Email");
			teachModel1.addColumn("D-O-J");

			ResultSet rsTeach1=stmt.executeQuery("select teacher_id , name , email , joiningYear from teacher where branch_id = '"+branchId[0]+"' ");

			while(rsTeach1.next())
			{
				teachModel1.addRow(new Object[] {rsTeach1.getString(1) ,rsTeach1.getString(2) ,rsTeach1.getString(3) ,rsTeach1.getString(4)});
			}
			branch1TeachTab = new JTable(teachModel1);
			branch1TeachScroll.setViewportView(branch1TeachTab);
			
			JDesktopPane desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.WHITE);
			desktopPane.setBounds(24, 30, 1058, 445);
			subPan1.add(desktopPane);

			ResultSet rsTeachC1 = stmt.executeQuery("select count(*) from teacher where branch_id = '"+branchId[0]+"' ");

			while(rsTeachC1.next())
				lblTeach1CountDb.setText(rsTeachC1.getString(1));

			ResultSet rsHod = stmt.executeQuery("select Hod_id from branch where branch_id = '"+branchId[0]+"' ");

			while(rsHod.next())
				lblBranch1HodDb.setText(rsHod.getString(1));

		}
		catch(Exception E)
		{
			JOptionPane.showMessageDialog(null, E.getMessage());
		}

		/* branch 2 */

		JPanel subPan2 = new JPanel();
		subPan2.setBackground(new Color(204, 204, 255));
		tabbedPane.addTab(branchId[1], null, subPan2, null);
		subPan2.setLayout(null);

		JScrollPane branch1StudScrol2 = new JScrollPane();
		branch1StudScrol2.setBounds(54, 77, 428, 336);
		subPan2.add(branch1StudScrol2);


		JLabel lblStud2Count = new JLabel("Count :");
		lblStud2Count.setBounds(54, 42, 53, 31);
		subPan2.add(lblStud2Count);

		JLabel lblStud2CountDb = new JLabel("<Dynamic>");
		lblStud2CountDb.setBounds(113, 42, 56, 31);
		subPan2.add(lblStud2CountDb);

		JScrollPane branch2TeachScroll = new JScrollPane();
		branch2TeachScroll.setBounds(639, 77, 428, 336);
		subPan2.add(branch2TeachScroll);

		JLabel lblTeach2Count = new JLabel("Count :");
		lblTeach2Count.setBounds(738, 42, 53, 31);
		subPan2.add(lblTeach2Count);

		JLabel lblTeach2CountDb = new JLabel("<Dynamic>");
		lblTeach2CountDb.setBounds(794, 42, 56, 31);
		subPan2.add(lblTeach2CountDb);

		JLabel lblBranch2Hod = new JLabel("HOD :");
		lblBranch2Hod.setBounds(875, 42, 53, 31);
		subPan2.add(lblBranch2Hod);

		JLabel lblBranch2HodDb = new JLabel("<Dynamic>");
		lblBranch2HodDb.setBounds(918, 42, 56, 31);
		subPan2.add(lblBranch2HodDb);

		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			DefaultTableModel studModel2 = new DefaultTableModel();
			studModel2.addColumn("USN");
			studModel2.addColumn("Name");
			studModel2.addColumn("Year");
			studModel2.addColumn("DOB");

			ResultSet rsStud=stmt.executeQuery("select usn , name , year , dob from student where branch_id = '"+branchId[1]+"' ");

			while(rsStud.next())
			{
				studModel2.addRow(new Object[] {rsStud.getString(1) ,rsStud.getString(2) ,rsStud.getString(3) ,rsStud.getString(4)});
			}

			branch2StudTab = new JTable(studModel2);
			branch1StudScrol2.setViewportView(branch2StudTab);


			ResultSet rsStudC = stmt.executeQuery("select count(usn) from student where branch_id = '"+branchId[1]+"' ");

			while(rsStudC.next())
				lblStud2CountDb.setText(rsStudC.getString(1));

			DefaultTableModel teachModel2 = new DefaultTableModel();

			teachModel2.addColumn("ID");
			teachModel2.addColumn("Name");
			teachModel2.addColumn("Email");
			teachModel2.addColumn("D-O-J");

			ResultSet rsTeach1=stmt.executeQuery("select teacher_id , name , email , joiningYear from teacher where branch_id = '"+branchId[1]+"' ");

			while(rsTeach1.next())
			{
				teachModel2.addRow(new Object[] {rsTeach1.getString(1) ,rsTeach1.getString(2) ,rsTeach1.getString(3) ,rsTeach1.getString(4)});
			}

			branch2TeachTab = new JTable(teachModel2);
			branch2TeachScroll.setViewportView(branch2TeachTab);
			
			JDesktopPane desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.WHITE);
			desktopPane.setBounds(25, 28, 1067, 445);
			subPan2.add(desktopPane);

			ResultSet rsTeachC2 = stmt.executeQuery("select count(*) from teacher where branch_id = '"+branchId[1]+"' ");

			while(rsTeachC2.next())
				lblTeach2CountDb.setText(rsTeachC2.getString(1));

			ResultSet rsHod = stmt.executeQuery("select Hod_id from branch where branch_id = '"+branchId[1]+"' ");

			while(rsHod.next())
				lblBranch2HodDb.setText(rsHod.getString(1));

		}
		catch(Exception E)
		{
			JOptionPane.showMessageDialog(null, E.getMessage());
		}

		/* Branch 3 */
		JPanel subPan3 = new JPanel();
		subPan3.setBackground(new Color(153, 255, 255));
		tabbedPane.addTab(branchId[2], null, subPan3, null);
		subPan3.setLayout(null);

		JScrollPane branch1StudScrol3 = new JScrollPane();
		branch1StudScrol3.setBounds(54, 77, 428, 336);
		subPan3.add(branch1StudScrol3);

		JLabel lblStud3Count = new JLabel("Count :");
		lblStud3Count.setBounds(54, 42, 53, 31);
		subPan3.add(lblStud3Count);

		JLabel lblStud3CountDb = new JLabel("<Dynamic>");
		lblStud3CountDb.setBounds(113, 42, 56, 31);
		subPan3.add(lblStud3CountDb);

		JScrollPane branch3TeachScroll = new JScrollPane();
		branch3TeachScroll.setBounds(639, 77, 428, 336);
		subPan3.add(branch3TeachScroll);

		JLabel lblTeach3Count = new JLabel("Count :");
		lblTeach3Count.setBounds(735, 42, 53, 31);
		subPan3.add(lblTeach3Count);

		JLabel lblTeach3CountDb = new JLabel("<Dynamic>");
		lblTeach3CountDb.setBounds(791, 42, 56, 31);
		subPan3.add(lblTeach3CountDb);

		JLabel lblBranch3Hod = new JLabel("HOD :");
		lblBranch3Hod.setBounds(872, 42, 53, 31);
		subPan3.add(lblBranch3Hod);

		JLabel lblBranch3HodDb = new JLabel("<Dynamic>");
		lblBranch3HodDb.setBounds(915, 42, 56, 31);
		subPan3.add(lblBranch3HodDb);

		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");

			Statement stmt=con.createStatement();

			DefaultTableModel studModel3 = new DefaultTableModel();
			studModel3.addColumn("USN");
			studModel3.addColumn("Name");
			studModel3.addColumn("Year");
			studModel3.addColumn("DOB");

			ResultSet rsStud=stmt.executeQuery("select usn , name , year , dob from student where branch_id = '"+branchId[2]+"' ");

			while(rsStud.next())
			{
				studModel3.addRow(new Object[] {rsStud.getString(1) ,rsStud.getString(2) ,rsStud.getString(3) ,rsStud.getString(4)});
			}

			branch3StudTab = new JTable(studModel3);
			branch1StudScrol3.setViewportView(branch3StudTab);

			ResultSet rsStudC = stmt.executeQuery("select count(usn) from student where branch_id = '"+branchId[2]+"' ");

			while(rsStudC.next())
				lblStud3CountDb.setText(rsStudC.getString(1));

			DefaultTableModel teachModel3 = new DefaultTableModel();

			teachModel3.addColumn("ID");
			teachModel3.addColumn("Name");
			teachModel3.addColumn("Email");
			teachModel3.addColumn("D-O-J");

			ResultSet rsTeach1=stmt.executeQuery("select teacher_id , name , email , joiningYear from teacher where branch_id = '"+branchId[2]+"' ");

			while(rsTeach1.next())
			{
				teachModel3.addRow(new Object[] {rsTeach1.getString(1) ,rsTeach1.getString(2) ,rsTeach1.getString(3) ,rsTeach1.getString(4)});
			}

			branch3TeachTab = new JTable(teachModel3);
			branch3TeachScroll.setViewportView(branch3TeachTab);
			
			JDesktopPane desktopPane = new JDesktopPane();
			desktopPane.setBackground(new Color(255, 255, 255));
			desktopPane.setBounds(31, 23, 1069, 445);
			subPan3.add(desktopPane);

			ResultSet rsTeachC3 = stmt.executeQuery("select count(*) from teacher where branch_id = '"+branchId[2]+"' ");

			while(rsTeachC3.next())
				lblTeach3CountDb.setText(rsTeachC3.getString(1));

			ResultSet rsHod = stmt.executeQuery("select Hod_id from branch where branch_id = '"+branchId[2]+"' ");

			while(rsHod.next())
				lblBranch3HodDb.setText(rsHod.getString(1));

		}
		catch(Exception E)
		{
			JOptionPane.showMessageDialog(null, E.getMessage());
		}

		/* add HOD */

		JPanel AddHodPan = new JPanel();
		AddHodPan.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Add Hod", null, AddHodPan, null);
		AddHodPan.setLayout(null);

		JLabel lblAddId = new JLabel("HOD_id:");
		lblAddId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddId.setBounds(10, 34, 133, 48);
		AddHodPan.add(lblAddId);

		txtteacherid = new JTextField();
		txtteacherid.setColumns(10);
		txtteacherid.setBounds(147, 47, 191, 30);
		AddHodPan.add(txtteacherid);

		JLabel lblAddName = new JLabel("Name:");
		lblAddName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddName.setBounds(10, 98, 90, 48);
		AddHodPan.add(lblAddName);

		txttname = new JTextField();
		txttname.setColumns(10);
		txttname.setBounds(147, 111, 191, 30);
		AddHodPan.add(txttname);

		JLabel lblAddBranch = new JLabel("BranchID:");
		lblAddBranch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddBranch.setBounds(10, 167, 90, 48);
		AddHodPan.add(lblAddBranch);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ISE", "CSE", "CIVIL"}));
		comboBox_2.setToolTipText("Select");
		comboBox_2.setBounds(147, 180, 191, 30);
		AddHodPan.add(comboBox_2);
		
		
		JLabel lblAddYearOfJoin = new JLabel("Year Of Join :");
		lblAddYearOfJoin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddYearOfJoin.setBounds(10, 228, 133, 48);
		AddHodPan.add(lblAddYearOfJoin);

		txtdateofjoin = new JTextField();
		txtdateofjoin.setColumns(10);
		txtdateofjoin.setBounds(147, 240, 191, 32);
		AddHodPan.add(txtdateofjoin);

		JLabel lblAddPhone = new JLabel("Phone :");
		lblAddPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddPhone.setBounds(10, 287, 133, 48);
		AddHodPan.add(lblAddPhone);

		txttphone = new JTextField();
		txttphone.setColumns(10);
		txttphone.setBounds(147, 300, 191, 30);
		AddHodPan.add(txttphone);

		JLabel lblAddDob = new JLabel("D - O - B:");
		lblAddDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddDob.setBounds(378, 34, 118, 48);
		AddHodPan.add(lblAddDob);

		JLabel label_6 = new JLabel("DD");
		label_6.setBounds(509, 55, 19, 14);
		AddHodPan.add(label_6);

		txtD = new JTextField(3);
		txtD.setColumns(10);
		txtD.setBounds(538, 47, 44, 30);
		AddHodPan.add(txtD);

		JLabel label_7 = new JLabel("MM");
		label_7.setBounds(592, 55, 31, 14);
		AddHodPan.add(label_7);

		txtM = new JTextField();
		txtM.setColumns(10);
		txtM.setBounds(621, 47, 44, 30);
		AddHodPan.add(txtM);

		txtY = new JTextField();
		txtY.setColumns(10);
		txtY.setBounds(710, 47, 44, 30);
		AddHodPan.add(txtY);

		JLabel lblYyyy = new JLabel("YYYY");
		lblYyyy.setBounds(671, 55, 31, 14);
		AddHodPan.add(lblYyyy);

		JLabel lblAddDesignation = new JLabel("Designation:");
		lblAddDesignation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddDesignation.setBounds(378, 98, 118, 48);
		AddHodPan.add(lblAddDesignation);

		txtdesig = new JTextField();
		txtdesig.setEditable(false);
		txtdesig.setText("HOD");
		txtdesig.setColumns(10);
		txtdesig.setBounds(506, 111, 165, 30);
		AddHodPan.add(txtdesig);

		JLabel lblAddClassId = new JLabel("ClassID:");
		lblAddClassId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddClassId.setBounds(378, 167, 90, 48);
		AddHodPan.add(lblAddClassId);

		txtclassid = new JTextField();
		txtclassid.setColumns(10);
		txtclassid.setBounds(506, 180, 167, 30);
		AddHodPan.add(txtclassid);

		JLabel lblAddSUbjectId = new JLabel("SubjectID:");
		lblAddSUbjectId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddSUbjectId.setBounds(378, 228, 118, 48);
		AddHodPan.add(lblAddSUbjectId);

		JComboBox comboBox_3 = new JComboBox();
	
		comboBox_3.setToolTipText("select");
		comboBox_3.setBounds(506, 246, 165, 30);
		AddHodPan.add(comboBox_3);
		
		JLabel lblAddEmail = new JLabel("Email:");
		lblAddEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddEmail.setBounds(378, 287, 90, 48);
		AddHodPan.add(lblAddEmail);

		txttemail = new JTextField();
		txttemail.setEditable(false);
		txttemail.setColumns(10);
		txttemail.setBounds(509, 300, 245, 30);
		AddHodPan.add(txttemail);
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

		Date d1 = sqlDate;

		SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");

		strDate = sm.format(sqlDate);
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_2.getSelectedItem().toString().equals("CIVIL"))
				{
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"17CIV50", "17CIVS51", "17CIVS52"}));
				}
				else
				{
					comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"17CS50", "17CS51", "17CS52"}));
				}
			}
		});
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtteacherid.getText().equals("") || txttname.getText().equals("")
						|| txtdateofjoin.getText().equals("") || txttphone.getText().equals("")
						|| txtclassid.getText().equals("") || txttemail.getText().equals("")
						|| txtD.getText().equals("") || txtY.getText().equals("") || txtM.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter details in all field");
				}
				else if(txttphone.getText().length()<10||txttphone.getText().length()>10)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Phone Number");
				}
				
				else if((txtY.getText().length()<4))
					
				{
					
					JOptionPane.showMessageDialog(null, "Please enter a valid DOB");
				}
				else if((Integer.parseInt(txtY.getText())>Integer.parseInt(strDate.toString().substring(6))))
						
				{
					
					JOptionPane.showMessageDialog(null, "Please enter a valid DOB");
					
				}
			
				else 
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loaded successfully");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
						Statement stmt = con.createStatement();
						
						String temp ="";
						
						ResultSet rs = stmt.executeQuery("select hod_id from branch where branch_id = '"+comboBox_2.getSelectedItem().toString()+"' ");
						while(rs.next())
							temp = rs.getString(1);
						System.out.print(temp);
						
						if(temp.equals(""))
						{	
							
						}
						else
						{
							if(txtteacherid.getText().equals(temp))
							{
								JOptionPane.showMessageDialog(null, "HOD Already Exist");
							}
							else
							{
								String updatquer = "update teacher set designation ='teacher' where teacher_id = '"+temp+"' ";
								stmt.executeUpdate(updatquer);
						
								String detetquer1 = "delete from branch where hod_id = '"+temp+"' ";
								PreparedStatement ps5 = con.prepareStatement(detetquer1);
								ps5.execute();
							}
						
						}
					}	
					catch(Exception E)
					{
						JOptionPane.showMessageDialog(null, E.getMessage());
					}
					
					try 
					{

						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loaded successfully");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
						Statement stmt = con.createStatement();
						
						
						String query = "Insert into teacher (teacher_id,Name,Branch_id,classId,DOB,PhoneNo,Email,JoiningYear,Designation,SubjectTeachId,password)"
								+ "values(?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, txtteacherid.getText());
						ps.setString(2, txttname.getText());
						ps.setString(4, txtclassid.getText());
						ps.setString(3, comboBox_2.getSelectedItem().toString());
						ps.setString(5, txtD.getText() + "/" + txtM.getText() + "/" + txtY.getText());
						ps.setString(6, txttphone.getText());
						ps.setString(7, txttemail.getText());
						ps.setString(8, txtdateofjoin.getText());
						ps.setString(9, txtdesig.getText());
						ps.setString(10, comboBox_3.getSelectedItem().toString());
						ps.setString(11, txtteacherid.getText());

						ps.execute();
						
						String query2 = "Insert into branch (name,hod_id,branch_id)" + "values(?,?,?)";
						
						PreparedStatement ps2 = con.prepareStatement(query2);
						ps2.setString(1, comboBox_2.getSelectedItem().toString());
						ps2.setString(2, txtteacherid.getText());
						ps2.setString(3,  comboBox_2.getSelectedItem().toString());
						ps2.execute();
						
						JOptionPane.showMessageDialog(null, "HOD  added successfully");
						txtteacherid.setText("");
						txtclassid.setText("");
						txttname.setText("");
						txttphone.setText("");
						txttemail.setText("");
						txtdateofjoin.setText("");

						txtD.setText("");
						txtM.setText("");
						txtY.setText("");
						

						} catch (Exception et) 
						{
							System.out.println(et.getMessage());
						}
					}
				
			}
		});
		button.setBackground(Color.GREEN);
		button.setBounds(245, 382, 118, 35);
		AddHodPan.add(button);

		JButton btnEmail = new JButton("Generate Email");
		btnEmail.setBackground(new Color(204, 255, 204));
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				if(txttname.getText().equals("") || txtteacherid.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Complete The Required Fields");
				}
				else
				{
					AddEmail = txttname.getText().toLowerCase().replaceAll("\\s+", "").concat(".".concat(txtteacherid.getText().concat("@saividya.ac.in")));
					txttemail.setText(AddEmail);
				}

			}
		});
		btnEmail.setBounds(782, 300, 154, 30);
		AddHodPan.add(btnEmail);

		JPanel queryPane = new JPanel();
		queryPane.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Query", null, queryPane, null);
		queryPane.setLayout(null);

		tfQuery = new JTextField();
		tfQuery.setBounds(26, 236, 382, 51);
		queryPane.add(tfQuery);
		tfQuery.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(433, 11, 719, 492);
		queryPane.add(scrollPane);

		JButton btnNewButton = new JButton("Execute Query");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				DefaultTableModel modelquery=new DefaultTableModel();
				try
				{

					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt=con.createStatement();
					ResultSet rs=null;
					
					String query = tfQuery.getText(); 
					
					if(query.startsWith("Update")||query.startsWith("update"))
					{
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Updated Successfully");
						
						modelquery.getDataVector().removeAllElements(); modelquery.fireTableDataChanged();
						
						
					}
					else	
					{
					rs=stmt.executeQuery(query);
					
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for(int i = 1 ; i <= columnCount ; i++)
						modelquery.addColumn(rsmd.getColumnName(i));

					Object []  row = new Object [columnCount];

					
					while(rs.next())
					{
						for(int i  = 1 ; i <= columnCount ; i++ )
						{
							row[i-1] = rs.getString(i);
						}

						modelquery.addRow(row);
					}
					}
					table = new JTable(modelquery);
					scrollPane.setViewportView(table);
					table.setRowHeight(30);
					table.setRowMargin(20);
					

				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}

			}
		});
		btnNewButton.setBounds(89, 320, 119, 31);
		queryPane.add(btnNewButton);
		
		JButton insertb = new JButton("Generate Select Query");
		insertb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfQuery.setText("Select  from  where ");
			}
		});
		insertb.setBackground(new Color(51, 204, 255));
		insertb.setBounds(149, 182, 188, 31);
		queryPane.add(insertb);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfQuery.setText("");
			}
		});
		btnReset.setBounds(218, 320, 119, 31);
		queryPane.add(btnReset);
		
	
		JButton btnlogout = new JButton("Click here to  ->Logout");
		btnlogout.setFont(new Font("Snap ITC", Font.BOLD, 35));
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
		tabbedPane.addTab("logout", null, btnlogout, null);

		JLabel lblNewLabel = new JLabel("ADMIN PANEL");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 35));
		lblNewLabel.setBounds(548, 64, 371, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmuds = new JLabel("EMUDS");
		lblEmuds.setForeground(Color.WHITE);
		lblEmuds.setFont(new Font("Snap ITC", Font.PLAIN, 35));
		lblEmuds.setBounds(20, 64, 371, 38);
		frame.getContentPane().add(lblEmuds);
		
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\adminw.jpg"));
				lblNewLabel_1.setBounds(0, 0, 1592, 917);
				frame.getContentPane().add(lblNewLabel_1);



	}
}
