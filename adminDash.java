import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class adminDash {

	private JFrame frame;
	private JTable branch1StudTab;
	private JTable branch1TeachTab;
	private JTable branch2StudTab;
	private JTable branch2TeachTab;
	private JTable branch3StudTab;
	private JTable branch3TeachTab;
	private JTextField tfAddId;
	private JTextField tfAddName;
	private JTextField tfAddYearOfjoin;
	private JTextField tfAddPhone;
	private JTextField tfAddDobDD;
	private JTextField tfAddDobMM;
	private JTextField tfAddDobYY;
	private JTextField tfAddDesignation;
	private JTextField tfAddClassId;
	private JTextField tfAddEmail;
	String AddEmail ="";
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
		tabbedPane.setFont(new Font("Segoe Print", Font.BOLD, 20));
		tabbedPane.setBounds(10, 91, 1327, 519);
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
		branch1TeachScroll.setBounds(492, 77, 428, 336);
		subPan1.add(branch1TeachScroll);

		JLabel lblTeach1Count = new JLabel("Count :");
		lblTeach1Count.setBounds(492, 42, 53, 31);
		subPan1.add(lblTeach1Count);

		JLabel lblTeach1CountDb = new JLabel("<Dynamic>");
		lblTeach1CountDb.setBounds(548, 42, 56, 31);
		subPan1.add(lblTeach1CountDb);

		JLabel lblBranch1Hod = new JLabel("HOD :");
		lblBranch1Hod.setBounds(629, 42, 53, 31);
		subPan1.add(lblBranch1Hod);

		JLabel lblBranch1HodDb = new JLabel("<Dynamic>");
		lblBranch1HodDb.setBounds(672, 42, 56, 31);
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

			ResultSet rsStudC = stmt.executeQuery("select count(usn) from student where branch_id = '"+branchId[0]+"' ");

			while(rsStudC.next())
				lblStud1CountDb.setText(rsStudC.getString(1));

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

			ResultSet rsTeachC = stmt.executeQuery("select count(usn) from student where branch_id = '"+branchId[0]+"' ");

			while(rsTeachC.next())
				lblTeach1CountDb.setText(rsTeachC.getString(1));
			
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
		branch2TeachScroll.setBounds(492, 77, 428, 336);
		subPan2.add(branch2TeachScroll);

		JLabel lblTeach2Count = new JLabel("Count :");
		lblTeach2Count.setBounds(492, 42, 53, 31);
		subPan2.add(lblTeach2Count);

		JLabel lblTeach2CountDb = new JLabel("<Dynamic>");
		lblTeach2CountDb.setBounds(548, 42, 56, 31);
		subPan2.add(lblTeach2CountDb);

		JLabel lblBranch2Hod = new JLabel("HOD :");
		lblBranch2Hod.setBounds(629, 42, 53, 31);
		subPan2.add(lblBranch2Hod);

		JLabel lblBranch2HodDb = new JLabel("<Dynamic>");
		lblBranch2HodDb.setBounds(672, 42, 56, 31);
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

			ResultSet rsTeachC = stmt.executeQuery("select count(usn) from student where branch_id = '"+branchId[1]+"' ");

			while(rsTeachC.next())
				lblTeach2CountDb.setText(rsTeachC.getString(1));
			
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
		branch3TeachScroll.setBounds(492, 77, 428, 336);
		subPan3.add(branch3TeachScroll);

		JLabel lblTeach3Count = new JLabel("Count :");
		lblTeach3Count.setBounds(492, 42, 53, 31);
		subPan3.add(lblTeach3Count);

		JLabel lblTeach3CountDb = new JLabel("<Dynamic>");
		lblTeach3CountDb.setBounds(548, 42, 56, 31);
		subPan3.add(lblTeach3CountDb);

		JLabel lblBranch3Hod = new JLabel("HOD :");
		lblBranch3Hod.setBounds(629, 42, 53, 31);
		subPan3.add(lblBranch3Hod);

		JLabel lblBranch3HodDb = new JLabel("<Dynamic>");
		lblBranch3HodDb.setBounds(672, 42, 56, 31);
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

			ResultSet rsTeachC = stmt.executeQuery("select count(usn) from student where branch_id = '"+branchId[2]+"' ");

			while(rsTeachC.next())
				lblTeach3CountDb.setText(rsTeachC.getString(1));
			
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
		tabbedPane.addTab("ADD HOD", null, AddHodPan, null);
		AddHodPan.setLayout(null);
		
		JLabel lblAddId = new JLabel("Teacher_id:");
		lblAddId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddId.setBounds(10, 34, 133, 48);
		AddHodPan.add(lblAddId);
		
		tfAddId = new JTextField();
		tfAddId.setColumns(10);
		tfAddId.setBounds(147, 47, 191, 30);
		AddHodPan.add(tfAddId);
		
		JLabel lblAddName = new JLabel("Name:");
		lblAddName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddName.setBounds(10, 98, 90, 48);
		AddHodPan.add(lblAddName);
		
		tfAddName = new JTextField();
		tfAddName.setColumns(10);
		tfAddName.setBounds(147, 111, 191, 30);
		AddHodPan.add(tfAddName);
		
		JLabel lblAddBranch = new JLabel("BranchID:");
		lblAddBranch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddBranch.setBounds(10, 167, 90, 48);
		AddHodPan.add(lblAddBranch);
		
		JComboBox cbAddBranch = new JComboBox();
		cbAddBranch.setToolTipText("Select");
		cbAddBranch.setBounds(147, 180, 191, 30);
		AddHodPan.add(cbAddBranch);
		
		JLabel lblAddYearOfJoin = new JLabel("Year Of Join :");
		lblAddYearOfJoin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddYearOfJoin.setBounds(10, 228, 133, 48);
		AddHodPan.add(lblAddYearOfJoin);
		
		tfAddYearOfjoin = new JTextField();
		tfAddYearOfjoin.setColumns(10);
		tfAddYearOfjoin.setBounds(147, 240, 191, 32);
		AddHodPan.add(tfAddYearOfjoin);
		
		JLabel lblAddPhone = new JLabel("Phone :");
		lblAddPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddPhone.setBounds(10, 287, 133, 48);
		AddHodPan.add(lblAddPhone);
		
		tfAddPhone = new JTextField();
		tfAddPhone.setColumns(10);
		tfAddPhone.setBounds(147, 300, 191, 30);
		AddHodPan.add(tfAddPhone);
		
		JLabel lblAddDob = new JLabel("D - O - B:");
		lblAddDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddDob.setBounds(378, 34, 118, 48);
		AddHodPan.add(lblAddDob);
		
		JLabel label_6 = new JLabel("DD");
		label_6.setBounds(509, 55, 19, 14);
		AddHodPan.add(label_6);
		
		tfAddDobDD = new JTextField();
		tfAddDobDD.setColumns(10);
		tfAddDobDD.setBounds(538, 47, 44, 30);
		AddHodPan.add(tfAddDobDD);
		
		JLabel label_7 = new JLabel("MM");
		label_7.setBounds(592, 55, 19, 14);
		AddHodPan.add(label_7);
		
		tfAddDobMM = new JTextField();
		tfAddDobMM.setColumns(10);
		tfAddDobMM.setBounds(621, 47, 44, 30);
		AddHodPan.add(tfAddDobMM);
		
		tfAddDobYY = new JTextField();
		tfAddDobYY.setColumns(10);
		tfAddDobYY.setBounds(690, 47, 44, 30);
		AddHodPan.add(tfAddDobYY);
		
		JLabel label_8 = new JLabel("YY");
		label_8.setBounds(671, 55, 19, 14);
		AddHodPan.add(label_8);
		
		JLabel lblAddDesignation = new JLabel("Designation:");
		lblAddDesignation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddDesignation.setBounds(378, 98, 118, 48);
		AddHodPan.add(lblAddDesignation);
		
		tfAddDesignation = new JTextField();
		tfAddDesignation.setColumns(10);
		tfAddDesignation.setBounds(506, 111, 165, 30);
		AddHodPan.add(tfAddDesignation);
		
		JLabel lblAddClassId = new JLabel("ClassID:");
		lblAddClassId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddClassId.setBounds(378, 167, 90, 48);
		AddHodPan.add(lblAddClassId);
		
		tfAddClassId = new JTextField();
		tfAddClassId.setColumns(10);
		tfAddClassId.setBounds(506, 180, 167, 30);
		AddHodPan.add(tfAddClassId);
		
		JLabel lblAddSUbjectId = new JLabel("SubjectID:");
		lblAddSUbjectId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddSUbjectId.setBounds(378, 228, 118, 48);
		AddHodPan.add(lblAddSUbjectId);
		
		JComboBox cbAddSubjectId = new JComboBox();
		cbAddSubjectId.setToolTipText("select");
		cbAddSubjectId.setBounds(506, 246, 165, 30);
		AddHodPan.add(cbAddSubjectId);
		
		JLabel lblAddEmail = new JLabel("Email:");
		lblAddEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddEmail.setBounds(378, 287, 90, 48);
		AddHodPan.add(lblAddEmail);
		
		tfAddEmail = new JTextField();
		tfAddEmail.setEditable(false);
		tfAddEmail.setColumns(10);
		tfAddEmail.setBounds(506, 300, 165, 30);
		AddHodPan.add(tfAddEmail);
		
		JButton button = new JButton("Submit");
		button.setBackground(Color.GREEN);
		button.setBounds(245, 382, 118, 35);
		AddHodPan.add(button);
		
		JButton btnEmail = new JButton("Generate Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if(tfAddName.getText().equals("") || tfAddId.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Complete The Required Fields");
				}
				else
				{
					AddEmail = tfAddName.getText().toLowerCase().replaceAll("\\s+", "").concat(".".concat(tfAddId.getText().concat("@saividya.ac.in")));
					tfAddEmail.setText(AddEmail);
				}
				
			}
		});
		btnEmail.setBounds(690, 304, 154, 23);
		AddHodPan.add(btnEmail);
		
		
		
	}
}
