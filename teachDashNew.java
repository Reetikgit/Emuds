import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

//import CalendarProgram.btnNext_Action;
//import CalendarProgram.btnPrev_Action;
//import CalendarProgram.cmbYear_Action;
//import CalendarProgram.tblCalendarRenderer;



import java.awt.Component;
import java.awt.Container;

import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;

public class teachDashNew {

	private JTextField txtDate,txtDate2;
	static JLabel lblMonth, lblYear;
	static JButton btnPrev, btnNext;
	static JTable tblCalendar;
	static JComboBox cmbYear;
	static JFrame frmMain;
	static Container pane;
	static DefaultTableModel mtblCalendar; // Table model
	static JScrollPane stblCalendar; // The scrollpane
	static JPanel pnlCalendar;
	static int realYear, realMonth, realDay, currentYear, currentMonth;
	private JFrame frame;
	private JTextField tname;
	private JTextField tusn;
	private JTextField tclassid;
	private JTextField txtDobDd;
	private JTextField txtDobMm;
	private JTextField txtDobYy;
	private JTextField txtemailf;
	private JTextField txtphonef;
	private JTextField tproctor;
	JFrame frame2;
	private JTable table;
	GregorianCalendar cal;
	int count1, count2;
	String id, pass;
	String sub1, sub2, sub3;
	private JTextField atxtf;
	private JTextField atxtf2;
	private JTextField subjectf;
	int count;
	String strDate ;
	int dynamic = 7;
	String subject, desig, teacherid, teacherbranchid, teacherphone, teachername, teacheremail, teacherdateofjoin,
	teacherdob, teacherclassid;
	private JTable table_1;
	private JTextField branchf;
	private JTable table_2;
	private JTable table_3;
	private JTextField marksf;
	private JTextField markssubject;
	private JTextField marksidf;
	private JTextField marksnamef;
	private JPasswordField currentPasswordf;
	private JPasswordField newPasswordf;
	private JTextField txtteacherid;
	private JTextField txttname;
	private JTextField txttclassid;
	private JTextField txtD;
	private JTextField txtM;
	private JTextField txtY;
	private JTextField txttphone;
	private JTextField txttemail;
	JButton btn2,btnUpdate_2;

	String sEmail = "";
	/**
	 * Launch the application.
	 */
	public static void main(String id, String pass) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teachDashNew window = new teachDashNew(id, pass);
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
	public teachDashNew(String id, String pass) {
		this.id = id;
		this.pass = pass;
		System.out.println("I am" + id + "" + pass);
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1373, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();

			// model.addRow(new Object[]
			// {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs = stmt
					.executeQuery("select * from teacher where teacher_id='" + id + "' and Password='" + pass + "' ");

			while (rs.next()) {
				teacherid = rs.getString(1);
				teacherbranchid = rs.getString(3);
				teachername = rs.getString(2);
				teacherclassid = rs.getString(4);
				teacherdob = rs.getString(5);
				teacherphone = rs.getString(6);
				teacheremail = rs.getString(7);
				teacherdateofjoin = rs.getString(8);
				subject = rs.getString(10);
				desig = rs.getString(9);

			}
			System.out.println("final" + subject);

		}

		catch (Exception eee) {
			System.out.println(eee.getMessage());
		}
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setAutoscrolls(true);
		//		tabbedPane.setToolTipText("Menu");
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabbedPane.setAlignmentY(2.0f);
		tabbedPane.setForeground(new Color(255, 51, 102));
		tabbedPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Segoe Print", Font.BOLD, 20));
		tabbedPane.setBounds(20, 147, 1327, 519);
		frame.getContentPane().add(tabbedPane);

		JPanel profilePanel = new JPanel();
		profilePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		profilePanel.setBackground(new Color(51, 153, 204));
		tabbedPane.addTab("Profile", profilePanel);
		// tabbedPane.setForegroundAt(0, new Color(204, 51, 102));
		profilePanel.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(82, 87, 906, 367);
		profilePanel.add(desktopPane);

		JLabel subjectlbl = new JLabel("Subject:");
		subjectlbl.setBounds(436, 274, 131, 51);
		desktopPane.add(subjectlbl);
		subjectlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblEmailId = new JLabel("Email ID :");
		lblEmailId.setBounds(436, 212, 131, 51);
		desktopPane.add(lblEmailId);
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblPhoneNo = new JLabel("Phone Number:");
		lblPhoneNo.setBounds(436, 156, 162, 51);
		desktopPane.add(lblPhoneNo);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblDateOfJoin = new JLabel("Date Of Join :");
		lblDateOfJoin.setBounds(436, 94, 131, 51);
		desktopPane.add(lblDateOfJoin);
		lblDateOfJoin.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblDob = new JLabel("Date Of Birth:");
		lblDob.setBounds(436, 32, 131, 51);
		desktopPane.add(lblDob);
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel sunjectlbl = new JLabel(subject);
		sunjectlbl.setBounds(605, 274, 223, 45);
		desktopPane.add(sunjectlbl);
		sunjectlbl.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblEmailDb = new JLabel(teacheremail);
		lblEmailDb.setBounds(547, 218, 323, 45);
		desktopPane.add(lblEmailDb);
		lblEmailDb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblPhoneDb = new JLabel(teacherphone);
		lblPhoneDb.setBounds(609, 162, 219, 45);
		desktopPane.add(lblPhoneDb);
		lblPhoneDb.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblDobDb = new JLabel(teacherdob);
		lblDobDb.setBounds(605, 38, 219, 45);
		desktopPane.add(lblDobDb);
		lblDobDb.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblDojDb = new JLabel(teacherdateofjoin);
		lblDojDb.setBounds(609, 100, 219, 45);
		desktopPane.add(lblDojDb);
		lblDojDb.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblIdDb = new JLabel(teacherid);
		lblIdDb.setBounds(185, 100, 124, 45);
		desktopPane.add(lblIdDb);
		lblIdDb.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblClassId = new JLabel(teacherclassid);
		lblClassId.setBounds(185, 156, 113, 45);
		desktopPane.add(lblClassId);
		lblClassId.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblDeptDb = new JLabel(teacherbranchid);
		lblDeptDb.setBounds(185, 212, 165, 45);
		desktopPane.add(lblDeptDb);
		lblDeptDb.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblDesigDb = new JLabel(desig);
		lblDesigDb.setBounds(185, 274, 165, 45);
		desktopPane.add(lblDesigDb);
		lblDesigDb.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblDesig = new JLabel("Designation :");
		lblDesig.setBounds(22, 268, 119, 51);
		desktopPane.add(lblDesig);
		lblDesig.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblDept = new JLabel("Department :");
		lblDept.setBounds(22, 206, 131, 51);
		desktopPane.add(lblDept);
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblClassid = new JLabel("Class Id :");
		lblClassid.setBounds(22, 145, 87, 51);
		desktopPane.add(lblClassid);
		lblClassid.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblId = new JLabel("Your ID :");
		lblId.setBounds(22, 94, 87, 51);
		desktopPane.add(lblId);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(22, 32, 87, 51);
		desktopPane.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		if(!(desig.equalsIgnoreCase("HOD")))
		{
			JLabel lblNameDb = new JLabel("Prof."+""+teachername);	
			lblNameDb.setBounds(185, 38, 212, 45);
			desktopPane.add(lblNameDb);
			lblNameDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
		}
		else
		{
			JLabel lblNameDb = new JLabel("Dr."+""+teachername);	
			lblNameDb.setBounds(185, 38, 212, 45);
			desktopPane.add(lblNameDb);
			lblNameDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
		}



		JLabel lblEmudsprofile = new JLabel("EMUDS-Profile");
		lblEmudsprofile.setFont(new Font("Poor Richard", Font.PLAIN, 30));
		lblEmudsprofile.setBounds(10, 9, 358, 47);
		profilePanel.add(lblEmudsprofile);

		JPanel newSPan = new JPanel();
		newSPan.setBackground(Color.WHITE);
		tabbedPane.addTab("Add (Student)", null, newSPan, null);
		// tabbedPane.setForegroundAt(1, new Color(204, 51, 102));
		newSPan.setLayout(null);
		DefaultTableModel model3 = new DefaultTableModel();
		DefaultTableModel model4 = new DefaultTableModel();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from subject where BranchId='" + teacherbranchid + "'");
			while (rs.next()) {

				sub1 = rs.getString(2);
				sub2 = rs.getString(3);
				sub3 = rs.getString(4);

			}
		} catch (Exception eee) {
			System.out.println(eee.getMessage());
		}
		JScrollPane scroll2 = new JScrollPane();
		scroll2.setBounds(678, 73, 393, 285);
		newSPan.add(scroll2);

		table_1 = new JTable(model3);
	
	
		// scroll2.setColumnHeaderView(table_1);

		JButton btnNewButton_3 = new JButton("Pick");
		btnNewButton_3.setBackground(new Color(102, 51, 255));
		btnNewButton_3.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton_3.setBounds(723, 387, 89, 35);
		JComboBox comboJoinYear = new JComboBox();
		comboJoinYear.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018"}));
		comboJoinYear.setBounds(107, 109, 172, 20);
		
		comboJoinYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(branchf.getText().equals("CIVIL"))
				{
					tusn.setText("1VA"+comboJoinYear.getSelectedItem().toString().substring(2)+branchf.getText().substring(0,1)+branchf.getText().substring(2,3)+"0");
				}
				else
				tusn.setText("1VA"+comboJoinYear.getSelectedItem().toString().substring(2)+branchf.getText().substring(0,2)+"0");
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboJoinYear.setEnabled(false);
				count = 0;
				int column = 0;
				int row = table_1.getSelectedRow();

				String value1 = table_1.getModel().getValueAt(row, column).toString();

				tusn.setEditable(false);

				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
					Statement stmt = con.createStatement();

					// model.addRow(new Object[]
					// {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs = stmt.executeQuery("select * from student where USN='" + value1 + "'");

					while (rs.next()) {

						//
						String[] DobDb = rs.getString(7).split("/");
						tusn.setText(rs.getString(1));

						tproctor.setText(rs.getString(6));
						txtphonef.setText(rs.getString(8));
						txtemailf.setText(rs.getString(9));
						tname.setText(rs.getString(2));
						comboJoinYear.setSelectedItem(rs.getString(2));
						txtDobDd.setText(DobDb[0]);
						txtDobMm.setText(DobDb[1]);
						txtDobYy.setText(DobDb[2]);
						count++;

					}
				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}

			}
		});
		newSPan.add(btnNewButton_3);
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setToolTipText("Select");
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(453, 109, 114, 20);

		comboBox.setToolTipText("Select");
		if(teacherbranchid.equals("CSE"))
		{
			comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"17CS"}));
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "17CS"}));
		}
		else if(teacherbranchid.equals("ISE"))
		{
			comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"17IS"}));
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "17CS"}));
		}
		else
		{
			comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"17CIV"}));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "17CIV" }));
		}
		comboBox_4.setBounds(106, 297, 172, 23);
		
		

		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (count > 0) {
					int inputt = JOptionPane.showConfirmDialog(null, "Confirm your update");
					if (inputt == 0) {
						
						try {
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();
							ResultSet rs = stmt.executeQuery("{call proc1()}");
							while(rs.next())
							{
								System.out.println("Stored Proc"+rs.getString(1));
								}
							String query = "update student set USN=?,Name=?,Year=?,Branch_id=?,Class_id=?,teacher_id=?,DOB=?,Phone_NO=?,Email=?,Subject_id=?,Marks_id=?,Password=? where USN='"
									+ tusn.getText() + "'";
							PreparedStatement ps = con.prepareStatement(query);
							ps.setString(1, tusn.getText());
							ps.setString(2, tname.getText());
							ps.setString(3, comboJoinYear.getSelectedItem().toString());
							ps.setString(4, branchf.getText());
							ps.setString(5, comboBox_4.getSelectedItem().toString());
							ps.setString(6, tproctor.getText());
							ps.setString(7, txtDobDd.getText() + "/" + txtDobMm.getText() + "/" + txtDobYy.getText());
							ps.setString(8, txtphonef.getText());
							ps.setString(9, txtemailf.getText());
							ps.setString(10, comboBox.getSelectedItem().toString());
							ps.setString(11, tusn.getText());
							ps.setString(12, tusn.getText());
							ps.execute();
							JOptionPane.showMessageDialog(null, "Student data Updated successfully");
							model3.getDataVector().removeAllElements();
							model3.fireTableDataChanged();
							table_1.setModel(model3);
							ResultSet rs2 = stmt
									.executeQuery("select * from student where Branch_id='" + teacherbranchid + "'");
							while (rs2.next()) {

								model3.addRow(new Object[] { rs2.getString(1), rs2.getString(2),
										rs2.getString(3) + "  Batch" });

							}
							tusn.setEditable(true);
							tusn.setText("");
							tclassid.setText("");
							tproctor.setText("");
							txtphonef.setText("");
							txtemailf.setText("");
							tname.setText("");
							
							txtDobDd.setText("");
							txtDobMm.setText("");
							txtDobYy.setText("");
							count = 0;

						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					} else {

					}
				}

				else {
					JOptionPane.showMessageDialog(null, "Note:Select a student from the list and press PICK");
				}

			}
		});
		btnNewButton_5.setBackground(new Color(0, 204, 255));
		btnNewButton_5.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton_5.setBounds(843, 387, 89, 35);
		newSPan.add(btnNewButton_5);

		JLabel lblNewLabel_3 = new JLabel("Student Details");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblNewLabel_3.setBounds(800, 21, 138, 28);
		newSPan.add(lblNewLabel_3);

		// THE TABLE

		model3.addColumn("Student id");
		model3.addColumn("Student Name");
		model3.addColumn("Batch Year");
		model4.addColumn("Student id");
		model4.addColumn("Student Name");
		model4.addColumn("IA 1");
		model4.addColumn("IA 2");
		model4.addColumn("IA 3");
		scroll2.setViewportView(table_1);
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();

			// model.addRow(new Object[]
			// {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs = stmt.executeQuery("select * from student where Branch_id='" + teacherbranchid + "'");

			while (rs.next()) {

				model3.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3) + "  Batch" });

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// final JTable table2=new JTable();
		// scroll.setViewportView(table2);

		JPanel atnSPan = new JPanel();
		atnSPan.setBackground(Color.WHITE);
		tabbedPane.addTab("Attendance(Student)", atnSPan);
		// tabbedPane.setForegroundAt(2, new Color(204, 51, 102));
		atnSPan.setLayout(null);

		// THE TABLE

		// THE MODEL OF OUR TABLE

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(436, 84, 600, 268);
		atnSPan.add(scroll);

		// THE TABLE
		final JTable table = new JTable();
		table.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		table.setBackground(new Color(204, 153, 102));
		scroll.setViewportView(table);
		table.setRowHeight(30);
		// final JTable table2=new JTable()
		;
		// scroll.setViewportView(table2);

		DefaultTableModel model2 = new DefaultTableModel();
		// THE MODEL OF OUR TABLE
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;

				default:
					return String.class;
				}
			}
		};

		// ASSIGN THE MODEL TO TABLE
		table.setModel(model);
		// table2.setModel(model3);
		model.addColumn("Present/Absent");
		model.addColumn("Student Name");
		model.addColumn("USN");
		model2.addColumn("Student id");
		model2.addColumn("Present/Absent");
		model2.addColumn("Student Name");

		subjectf = new JTextField();
		subjectf.setEditable(false);

		subjectf.setBounds(163, 421, 134, 20);
		atnSPan.add(subjectf);
		subjectf.setColumns(10);

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();

			// model.addRow(new Object[]
			// {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs = stmt
					.executeQuery("select * from teacher where teacher_id='" + id + "' and Password='" + pass + "' ");

			while (rs.next()) {
				subject = rs.getString(10);
				desig = rs.getString(9);

			}

		}

		catch (Exception eee) {
			System.out.println(eee.getMessage());
		}
		subjectf.setText(subject);
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(new Color(153, 204, 255));
		desktopPane_1.setBounds(10, 64, 650, 435);
		newSPan.add(desktopPane_1);
		tproctor = new JTextField();
		tproctor.setBounds(396, 171, 171, 23);
		desktopPane_1.add(tproctor);
		tproctor.setColumns(10);

		JLabel lblProctor = new JLabel("Proctor ID:");
		lblProctor.setBounds(289, 153, 97, 51);
		desktopPane_1.add(lblProctor);
		lblProctor.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblDateOfJoin_1 = new JLabel("JoinYear:");
		lblDateOfJoin_1.setBounds(10, 90, 87, 51);
		desktopPane_1.add(lblDateOfJoin_1);
		lblDateOfJoin_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		branchf = new JTextField();
		branchf.setBounds(107, 231, 171, 20);
		desktopPane_1.add(branchf);
		branchf.setEditable(false);

		branchf.setColumns(10);
		branchf.setText(teacherbranchid);

		tclassid = new JTextField();
		tclassid.setVisible(false);
		tclassid.setBounds(117, 258, 14, 7);
		desktopPane_1.add(tclassid);
		tclassid.setColumns(10);

		tusn = new JTextField();
		tusn.setBounds(108, 171, 171, 23);
		desktopPane_1.add(tusn);
		tusn.setColumns(10);
		tname = new JTextField();
		tname.setBounds(107, 49, 171, 23);
		desktopPane_1.add(tname);
		tname.setColumns(10);
		
		JLabel lblDeptAddS = new JLabel("Branch:");
		lblDeptAddS.setBounds(10, 213, 87, 51);
		desktopPane_1.add(lblDeptAddS);
		lblDeptAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblClassIdAddS = new JLabel("Class Id :");
		lblClassIdAddS.setBounds(10, 279, 87, 51);
		desktopPane_1.add(lblClassIdAddS);
		lblClassIdAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblUsnAddS = new JLabel("USN :");
		lblUsnAddS.setBounds(10, 153, 87, 51);
		desktopPane_1.add(lblUsnAddS);
		lblUsnAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblNameAddS = new JLabel("Name :");
		lblNameAddS.setBounds(10, 31, 87, 51);
		desktopPane_1.add(lblNameAddS);
		lblNameAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblPhoneAddS = new JLabel("Phone :");
		lblPhoneAddS.setBounds(299, 212, 87, 51);
		desktopPane_1.add(lblPhoneAddS);
		lblPhoneAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtphonef = new JTextField();
		txtphonef.setBounds(396, 230, 171, 23);
		desktopPane_1.add(txtphonef);
		txtphonef.setColumns(10);

		JLabel lblEmailAddS = new JLabel("Email :");
		lblEmailAddS.setBounds(298, 275, 87, 51);
		desktopPane_1.add(lblEmailAddS);
		lblEmailAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtemailf = new JTextField();
		txtemailf.setEditable(false);
		txtemailf.setBounds(396, 293, 234, 23);
		desktopPane_1.add(txtemailf);
		txtemailf.setColumns(10);
		desktopPane_1.add(comboBox);
		JLabel lblSubAddS = new JLabel("Subject Series:");
		lblSubAddS.setBounds(299, 90, 151, 51);
		desktopPane_1.add(lblSubAddS);
		lblSubAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblDobAddS = new JLabel("D.O.B :");
		lblDobAddS.setBounds(299, 31, 65, 51);
		desktopPane_1.add(lblDobAddS);
		lblDobAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtDobDd = new JTextField();
		txtDobDd.setBounds(396, 49, 54, 23);
		desktopPane_1.add(txtDobDd);
		txtDobDd.setForeground(Color.BLACK);
		txtDobDd.setColumns(10);

		txtDobMm = new JTextField();
		txtDobMm.setBounds(489, 49, 54, 23);
		desktopPane_1.add(txtDobMm);
		txtDobMm.setForeground(Color.BLACK);
		txtDobMm.setColumns(10);

		txtDobYy = new JTextField();
		txtDobYy.setBounds(586, 49, 54, 23);
		desktopPane_1.add(txtDobYy);
		txtDobYy.setForeground(Color.BLACK);
		txtDobYy.setColumns(10);
		JLabel lblDd = new JLabel("DD");
		lblDd.setBounds(372, 53, 14, 14);
		desktopPane_1.add(lblDd);

		JLabel lblMm_1 = new JLabel("MM");
		lblMm_1.setBounds(457, 53, 22, 14);
		desktopPane_1.add(lblMm_1);

		JLabel lblYy_1 = new JLabel("YYYY");
		lblYy_1.setBounds(553, 53, 34, 14);
		desktopPane_1.add(lblYy_1);
		JButton btnSubmitAddS = new JButton("Submit");
		btnSubmitAddS.setBounds(187, 364, 114, 35);
		desktopPane_1.add(btnSubmitAddS);
		btnSubmitAddS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tusn.getText().equals("") || tname.getText().equals("")
						|| txtphonef.getText().equals("")
						|| tproctor.getText().equals("") || txtemailf.getText().equals("")
						|| txtDobMm.getText().equals("") || txtDobYy.getText().equals("")
						|| txtDobDd.getText().equals("") || tusn.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter details in all field");
				}
				else if(txtphonef.getText().length()<10||txtphonef.getText().length()>10)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Phone Number");
				}
			
				else if((txtDobYy.getText().length()<4))
					
				{
					
					JOptionPane.showMessageDialog(null, "Please enter a valid DOB");
				}
				else if((Integer.parseInt(txtDobYy.getText())>Integer.parseInt(strDate.toString().substring(6))))
						
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
						String query = "Insert into student (USN,Name,Year,Branch_id,class_id,Teacher_id,DOB,Phone_No,Email,subject_id,marks_id,password)"
								+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, tusn.getText().toUpperCase());
						ps.setString(2, tname.getText());
						ps.setString(3, comboJoinYear.getSelectedItem().toString());
						ps.setString(4, branchf.getText().toUpperCase());
						ps.setString(5, comboBox_4.getSelectedItem().toString());
						ps.setString(6, tproctor.getText());
						ps.setString(7, txtDobDd.getText() + "/" + txtDobMm.getText() + "/" + txtDobYy.getText());
						ps.setString(8, txtphonef.getText());
						ps.setString(9, txtemailf.getText());
						ps.setString(10, comboBox.getSelectedItem().toString());
						ps.setString(11, tusn.getText().toUpperCase());
						ps.setString(12, tusn.getText());
						ps.execute();
						String query2 = "Insert into marks (USN,Name,BranchID,SubjectId,IA1,IA2,IA3)"
								+ "values(?,?,?,?,?,?,?)";
						PreparedStatement ps2 = con.prepareStatement(query2);
						ps2.setString(1, tusn.getText().toUpperCase());
						ps2.setString(2, tname.getText());
						ps2.setString(3, branchf.getText().toUpperCase());
						ps2.setString(4, sub1);
						ps2.setInt(5, -1);
						ps2.setInt(6, -1);
						ps2.setInt(7, -1);
						
						ps2.execute();
						String query3 = "Insert into marks (USN,Name,BranchID,SubjectId,IA1,IA2,IA3)"
								+ "values(?,?,?,?,?,?,?)";
						PreparedStatement ps3 = con.prepareStatement(query3);
						ps3.setString(1, tusn.getText().toUpperCase());
						ps3.setString(2, tname.getText());
						ps3.setString(3, branchf.getText().toUpperCase());
						ps3.setString(4, sub2);
						ps3.setInt(5, -1);
						ps3.setInt(6, -1);
						ps3.setInt(7, -1);

						ps3.execute();
						String query4 = "Insert into marks (USN,Name,BranchID,SubjectId,IA1,IA2,IA3)"
								+ "values(?,?,?,?,?,?,?)";
						PreparedStatement ps4 = con.prepareStatement(query3);
						ps4.setString(1, tusn.getText().toUpperCase());
						ps4.setString(2, tname.getText());
						ps4.setString(3, branchf.getText().toUpperCase());
						ps4.setString(4, sub3);
						ps4.setInt(5, -1);
						ps4.setInt(6, -1);
						ps4.setInt(7, -1);

						ps4.execute();
						JOptionPane.showMessageDialog(null, "Student added successfully");
						model3.getDataVector().removeAllElements();
						model3.fireTableDataChanged();
						table_1.setModel(model3);

						tusn.setText("");

						tproctor.setText("");
						txtphonef.setText("");
						txtemailf.setText("");
						tname.setText("");
						
						txtDobDd.setText("");
						txtDobMm.setText("");
						txtDobYy.setText("");

						// model.addRow(new Object[]
						// {textField.getText(),textField_1.getText(),textField_2.getText()});
						ResultSet rs = stmt
								.executeQuery("select * from student where Branch_id='" + teacherbranchid + "'");
						while (rs.next()) {

							model3.addRow(
									new Object[] { rs.getString(1), rs.getString(2), rs.getString(3) + "  Batch" });

						}

					}

					catch (Exception e) {
						System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(null, "USN already exists");
					}
					/* Automatic update value in marks taBLE */
					try {
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loaded successfully");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
						Statement stmt = con.createStatement();
						model4.getDataVector().removeAllElements();
						model4.fireTableDataChanged();
						table_3.setModel(model4);
						ResultSet rs = stmt.executeQuery("select * from marks where BranchID='" + teacherbranchid
								+ "' and subjectId='" + subject + "'");
						while (rs.next()) 
						{

							int avg = 0;
							int countNot = 0;
							int marks[] = new int[3];

							if(rs.getInt(5) == -1)
								marks[0] = 0;
							else
							{
								marks[0] = rs.getInt(5);
								countNot++;
							}

							if(rs.getInt(6) == -1)
								marks[1] = 0;
							else
							{
								marks[1] = rs.getInt(6);
								countNot++;
							}

							if(rs.getInt(7) == -1)
								marks[2] = 0;
							else
							{
								marks[2] = rs.getInt(7);
								countNot++;
							}
							if(countNot != 0)
								avg = (marks[0]+marks[1]+marks[2])/countNot;
							else
								avg = 0;

							model4.addRow(new Object[] { rs.getString(1) ,rs.getString(2) ,marks[0] ,marks[1] ,marks[2] ,avg});
						
						}
						table_3.setModel(model4);
					}
					catch (Exception ee) {
						System.out.println(ee.getMessage());
					}

				}
			}
		});

		btnSubmitAddS.setBackground(new Color(0, 255, 0));

		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tusn.setEditable(true);
				tusn.setText("");
				tclassid.setText("");
				tproctor.setText("");
				txtphonef.setText("");
				txtemailf.setText("");
				tname.setText("");
				
				txtDobDd.setText("");
				txtDobMm.setText("");
				txtDobYy.setText("");
				count = 0;
			}
		});
		btnReset_1.setBackground(Color.GREEN);
		btnReset_1.setBounds(353, 364, 114, 35);
		desktopPane_1.add(btnReset_1);

		JButton btnNewButton_7 = new JButton("Generate ");
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(tname.getText().equals("") || tusn.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Complete All Fields");
				else
				{
					sEmail = tname.getText().toLowerCase().replaceAll("\\s+","").concat(tusn.getText().substring(7)).concat(".").concat((comboJoinYear.getSelectedItem().toString().substring(2).concat(comboBox_4.getSelectedItem().toString().substring(2))).concat("@saividya.ac.in"));
					txtemailf.setText(sEmail);
				}

			}
		});
		btnNewButton_7.setBounds(541, 331, 89, 23);
		desktopPane_1.add(btnNewButton_7);


		desktopPane_1.add(comboBox_4);
		
	
		desktopPane_1.add(comboJoinYear);
		// }

		JDesktopPane desktopPane_5 = new JDesktopPane();
		desktopPane_5.setBackground(new Color(102, 102, 153));
		desktopPane_5.setBounds(670, 53, 413, 393);
		newSPan.add(desktopPane_5);

		JButton btnNewButton_6 = new JButton("Delete");
		btnNewButton_6.setBounds(286, 335, 89, 35);
		desktopPane_5.add(btnNewButton_6);
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (count > 0) {

					int inputt = JOptionPane.showConfirmDialog(null,
							"Do you really want to Remove data for " + tname.getText());
					if (inputt == 0) {

						try {
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();

							String query = "delete from student where USN='" + tusn.getText() + "'";
							String query2 = "delete from marks where USN='" + tusn.getText() + "'";
							PreparedStatement ps = con.prepareStatement(query);
							ps.execute();
							PreparedStatement ps2 = con.prepareStatement(query2);
							ps2.execute();
							JOptionPane.showMessageDialog(null, "Student record deleted Successfully");
							model3.getDataVector().removeAllElements();
							model3.fireTableDataChanged();
							table_1.setModel(model3);
							ResultSet rs2 = stmt
									.executeQuery("select * from student where Branch_id='" + teacherbranchid + "'");

							while (rs2.next()) {

								model3.addRow(new Object[] { rs2.getString(1), rs2.getString(2),
										rs2.getString(3) + "  Batch" });

							}
							tusn.setEditable(true);
							tusn.setText("");

							tproctor.setText("");
							txtphonef.setText("");
							txtemailf.setText("");
							tname.setText("");
		
							txtDobDd.setText("");
							txtDobMm.setText("");
							txtDobYy.setText("");
							count = 0;

						} catch (Exception ee) {
							System.out.println(ee.getMessage());
						}
						try {
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
							Statement stmt = con.createStatement();
							model4.getDataVector().removeAllElements();
							model4.fireTableDataChanged();
							table_3.setModel(model4);
							ResultSet rs = stmt.executeQuery("select * from marks where BranchID='" + teacherbranchid
									+ "' and subjectId='" + subject + "'");
							while (rs.next()) 
							{

								int avg = 0;
								int countNot = 0;
								int marks[] = new int[3];

								if(rs.getInt(5) == -1)
									marks[0] = 0;
								else
								{
									marks[0] = rs.getInt(5);
									countNot++;
								}

								if(rs.getInt(6) == -1)
									marks[1] = 0;
								else
								{
									marks[1] = rs.getInt(6);
									countNot++;
								}

								if(rs.getInt(7) == -1)
									marks[2] = 0;
								else
								{
									marks[2] = rs.getInt(7);
									countNot++;
								}
								if(countNot != 0)
									avg = (marks[0]+marks[1]+marks[2])/countNot;
								else
									avg = 0;

								model4.addRow(new Object[] { rs.getString(1) ,rs.getString(2) ,marks[0] ,marks[1] ,marks[2] ,avg});
							
							}
							table_3.setModel(model4);
						
						} catch (Exception ee) {
							System.out.println(ee.getMessage());
						}
					} else {

					}
				} else {
					JOptionPane.showMessageDialog(null, "Note:Select a student from the lsit and press Pick to delete");
				}

			}
		});
		btnNewButton_6.setBackground(new Color(255, 0, 0));
		btnNewButton_6.setFont(new Font("Sylfaen", Font.BOLD, 14));

		btnNewButton_6.setEnabled(true);

		JLabel lblNewLabel = new JLabel("EMUDS-Add Student");
		lblNewLabel.setFont(new Font("Poor Richard", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 239, 31);
		newSPan.add(lblNewLabel);

		JDesktopPane desktopPane_8 = new JDesktopPane();
		desktopPane_8.setBackground(new Color(153, 204, 255));
		desktopPane_8.setBounds(658, 457, 425, 42);
		newSPan.add(desktopPane_8);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 53, 387, 13);
		newSPan.add(separator_2);
		JScrollPane scroll3 = new JScrollPane();
		scroll3.setBounds(514, 89, 553, 337);

		JPanel marksPan = new JPanel();
		marksPan.setForeground(Color.ORANGE);
		marksPan.setBackground(Color.WHITE);
		tabbedPane.addTab("Marks", null, marksPan, null);
		marksPan.setLayout(null);
		marksPan.add(scroll3);
		table_3 = new JTable(model4);
		table_3.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		table_3.setBackground(new Color(255, 255, 255));
		// scroll3.setColumnHeaderView(table_3);
//		table_3.setModel(model4);
		scroll3.setViewportView(table_3);
		table_3.setRowHeight(30);
		table_3.setRowMargin(10);
		model4.addColumn("Average");

		JLabel lblNewLabel_4 = new JLabel("EMUDS- Marks Upload");
		lblNewLabel_4.setBounds(42, 11, 369, 44);
		lblNewLabel_4.setFont(new Font("Poor Richard", Font.BOLD, 27));
		marksPan.add(lblNewLabel_4);

		JLabel lblStudentName = new JLabel("Student  Name");
		lblStudentName.setBounds(56, 112, 110, 26);
		lblStudentName.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		marksPan.add(lblStudentName);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(56, 181, 110, 26);
		lblStudentId.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		marksPan.add(lblStudentId);

		JLabel lblMarksFor = new JLabel("Marks for ");
		lblMarksFor.setBounds(56, 254, 110, 26);
		lblMarksFor.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		marksPan.add(lblMarksFor);

		JComboBox markscombo = new JComboBox();
		markscombo.setBounds(196, 257, 110, 20);
		markscombo.setToolTipText("Select");
		markscombo.setModel(new DefaultComboBoxModel(new String[] { "IA1", "IA2", "IA3" }));
		marksPan.add(markscombo);

		JLabel lblEnterMarks = new JLabel("Enter Marks");
		lblEnterMarks.setBounds(56, 322, 110, 26);
		lblEnterMarks.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		marksPan.add(lblEnterMarks);

		marksf = new JTextField();
		marksf.setBounds(196, 325, 110, 20);
		marksPan.add(marksf);
		marksf.setColumns(10);

		JLabel lblSubjectId_1 = new JLabel("Subject ID");
		lblSubjectId_1.setBounds(56, 383, 110, 26);
		lblSubjectId_1.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		marksPan.add(lblSubjectId_1);

		markssubject = new JTextField();
		markssubject.setEditable(false);
		markssubject.setBounds(196, 386, 110, 20);
		marksPan.add(markssubject);
		markssubject.setColumns(10);

		marksidf = new JTextField();
		marksidf.setEditable(false);
		marksidf.setBounds(196, 184, 110, 20);
		marksPan.add(marksidf);
		marksidf.setColumns(10);

		marksnamef = new JTextField();
		marksnamef.setEditable(false);
		marksnamef.setBounds(196, 115, 110, 20);
		marksPan.add(marksnamef);
		marksnamef.setColumns(10);
		markssubject.setText(subject);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from marks where BranchID='" + teacherbranchid + "' and SubjectId='" + subject + "'");

			while (rs.next()) 
			{

				int avg = 0;
				int countNot = 0;
				int marks[] = new int[3];

				if(rs.getInt(5) == -1)
					marks[0] = 0;
				else
				{
					marks[0] = rs.getInt(5);
					countNot++;
				}

				if(rs.getInt(6) == -1)
					marks[1] = 0;
				else
				{
					marks[1] = rs.getInt(6);
					countNot++;
				}

				if(rs.getInt(7) == -1)
					marks[2] = 0;
				else
				{
					marks[2] = rs.getInt(7);
					countNot++;
				}
				if(countNot != 0)
					avg = (marks[0]+marks[1]+marks[2])/countNot;
				else
					avg = 0;

				model4.addRow(new Object[] { rs.getString(1) ,rs.getString(2) ,marks[0] ,marks[1] ,marks[2] ,avg});

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(537, 115, 131, 20);

		JDesktopPane desktopPane_4 = new JDesktopPane();
		desktopPane_4.setBackground(new Color(255, 255, 204));
		desktopPane_4.setBounds(44, 74, 460, 414);
		marksPan.add(desktopPane_4);

		JButton btnNewButton_1 = new JButton("Pick");
		btnNewButton_1.setBounds(319, 33, 110, 34);
		desktopPane_4.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(102, 102, 255));

		JButton btnPushMarks = new JButton("Push Marks");
		btnPushMarks.setBounds(319, 169, 110, 35);
		desktopPane_4.add(btnPushMarks);
		btnPushMarks.setBackground(new Color(0, 255, 0));

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(319, 306, 110, 34);
		desktopPane_4.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				marksnamef.setText("");
				marksidf.setText("");
				marksf.setText("");
				count = 0;

			}

		});
		btnReset.setBackground(new Color(204, 51, 153));

		btnPushMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (count > 0) 
				{
					if (!(marksf.getText().equals("")))

					{
						try 
						{
							Class.forName("com.mysql.jdbc.Driver");

							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();

							if(markscombo.getSelectedItem().toString().equals("IA1"))
							{	
								String up = "Update marks set IA1 = '"+Integer.parseInt(marksf.getText())+"' where USN = '"+marksidf.getText()+"' and subjectId = '"+subject+"' ";

								stmt.executeUpdate(up);
								JOptionPane.showMessageDialog(null, "Marks Pushed Successfully");

								marksf.setText("");
								model4.getDataVector().removeAllElements();
								model4.fireTableDataChanged();
								table_3.setModel(model4);
								ResultSet rs = stmt.executeQuery("select * from marks where BranchID='"
										+ teacherbranchid + "' and subjectId='" + subject + "'");

								while (rs.next())
								{
									int avg = 0;
									int countNot = 0;
									int marks[] = new int[3];

									if(rs.getInt(5) == -1)
										marks[0] = 0;
									else
									{
										marks[0] = rs.getInt(5);
										countNot++;
									}

									if(rs.getInt(6) == -1)
										marks[1] = 0;
									else
									{
										marks[1] = rs.getInt(6);
										countNot++;
									}

									if(rs.getInt(7) == -1)
										marks[2] = 0;
									else
									{
										marks[2] = rs.getInt(7);
										countNot++;
									}

									if(countNot != 0)
										avg = (marks[0]+marks[1]+marks[2])/countNot;
									else
										avg = 0;

									model4.addRow(new Object[] { rs.getString(1), rs.getString(2), marks[0] , marks[1] , marks[2] , avg});
								}
							}

							if(markscombo.getSelectedItem().toString().equals("IA2"))
							{	
								String up = "Update marks set IA2 = '"+Integer.parseInt(marksf.getText())+"' where USN = '"+marksidf.getText()+"' and subjectId = '"+subject+"' ";

								stmt.executeUpdate(up);
								JOptionPane.showMessageDialog(null, "Marks Pushed Successfully");

								marksf.setText("");
								model4.getDataVector().removeAllElements();
								model4.fireTableDataChanged();
								table_3.setModel(model4);
								ResultSet rs = stmt.executeQuery("select * from marks where BranchID='"
										+ teacherbranchid + "' and subjectId='" + subject + "'");

								while (rs.next())
								{
									int avg = 0;
									int countNot = 0;
									int marks[] = new int[3];

									if(rs.getInt(5) == -1)
										marks[0] = 0;
									else
									{
										marks[0] = rs.getInt(5);
										countNot++;
									}

									if(rs.getInt(6) == -1)
										marks[1] = 0;
									else
									{
										marks[1] = rs.getInt(6);
										countNot++;
									}
									
									if(rs.getInt(7) == -1)
										marks[2] = 0;
									else
									{
										marks[2] = rs.getInt(7);
										countNot++;
									}

									if(countNot != 0)
										avg = (marks[0]+marks[1]+marks[2])/countNot;
									else
										avg = 0;

									model4.addRow(new Object[] { rs.getString(1), rs.getString(2), marks[0] , marks[1] , marks[2] , avg});
								}
							}

							if(markscombo.getSelectedItem().toString().equals("IA3"))
							{	
								String up = "Update marks set IA3 = '"+Integer.parseInt(marksf.getText())+"' where USN = '"+marksidf.getText()+"' and subjectId = '"+subject+"' ";

								stmt.executeUpdate(up);
								JOptionPane.showMessageDialog(null, "Marks Pushed Successfully");

								marksf.setText("");
								model4.getDataVector().removeAllElements();
								model4.fireTableDataChanged();
								table_3.setModel(model4);
								ResultSet rs = stmt.executeQuery("select * from marks where BranchID='"
										+ teacherbranchid + "' and subjectId='" + subject + "'");

								while (rs.next())
								{
									int avg = 0;
									int countNot = 0;
									int marks[] = new int[3];

									if(rs.getInt(5) == -1)
										marks[0] = 0;
									else
									{
										marks[0] = rs.getInt(5);
										countNot++;
									}

									if(rs.getInt(6) == -1)
										marks[1] = 0;
									else
									{
										marks[1] = rs.getInt(6);
										countNot++;
									}

									if(rs.getInt(7) == -1)
										marks[2] = 0;
									else
									{
										marks[2] = rs.getInt(7);
										countNot++;
									}

									if(countNot != 0)
										avg = (marks[0]+marks[1]+marks[2])/countNot;
									else
										avg = 0;

									model4.addRow(new Object[] { rs.getString(1), rs.getString(2), marks[0] , marks[1] , marks[2] , avg});
								}
							}
					} 
					catch (Exception ee) {
						System.out.println(ee.getMessage());
					}
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Marks Feild cant be empty");
				}

			}

			else {
				JOptionPane.showMessageDialog(null, "Please Pick a student");
			}
		}
	});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int column = 0;
				int row = table_3.getSelectedRow();
				System.out.println("I am" + row);
				String value1 = table_3.getModel().getValueAt(row, column).toString();
				System.out.println("I am" + row + "value=" + value1);
				marksidf.setEditable(false);

				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
					Statement stmt = con.createStatement();

					// model.addRow(new Object[]
					// {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs = stmt.executeQuery("select * from marks where USN='" + value1 + "'");

					while (rs.next()) {

						marksnamef.setText(rs.getString(2));
						marksidf.setText(rs.getString(1));
						markssubject.setText(rs.getString(4));
						count++;
					}
				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}

			}
		});

		JLabel lblNewLabel_5 = new JLabel("Display Panel");
		lblNewLabel_5.setFont(new Font("Segoe Script", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(697, 43, 170, 35);
		marksPan.add(lblNewLabel_5);

		JDesktopPane desktopPane_12 = new JDesktopPane();
		desktopPane_12.setBackground(new Color(255, 255, 204));
		desktopPane_12.setBounds(503, 437, 580, 51);
		marksPan.add(desktopPane_12);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(42, 54, 387, 13);
		marksPan.add(separator_3);
		java.sql.Date sqlDate2 = new java.sql.Date(new java.util.Date().getTime());
		System.out.println(sqlDate2);
		// model.addColumn("Points");
		// model.addColumn("Manager");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();

			// model.addRow(new Object[]
			// {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs = stmt.executeQuery("select * from student where Branch_id='" + teacherbranchid + "'");

			while (rs.next()) {

				model.addRow(new Object[] { false, rs.getString(2), rs.getString(1) });
				model2.addRow(new Object[] { false, rs.getString(2), rs.getString(1) });

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// THE ROW

		// OBTAIN SELECTED ROW
		JButton btn = new JButton("Mark");
		btn.setBackground(new Color(102, 102, 204));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			
					// TODO Auto-generated method stub
					int c = 0;
					// GET SELECTED ROW
					for (int i = 0; i < table.getRowCount(); i++) {
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
						String col = table.getValueAt(i, 2).toString();
						String col2 = table.getValueAt(i, 1).toString();

						// DISPLAY
						if ((checked)) {
							try {

								Class.forName("com.mysql.jdbc.Driver");
								System.out.println("Driver loaded successfully");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf",
										"root", "");
								Statement stmt = con.createStatement();
								String query = "Insert into attendance (usn,teacher_id,status,date,subjectid,StudentName)"
										+ "values(?,?,?,?,?,?)";
								PreparedStatement ps = con.prepareStatement(query);
								ps.setString(1, col);

								ps.setString(2, id);

								ps.setString(3, "P");
								// ps.setString(8,);
								ps.setString(4, txtDate.getText());
								ps.setString(5, subjectf.getText());
								ps.setString(6, col2);
								ps.execute();
								c++;
							} 
							catch (Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
						else
						{
						 
							try {

								Class.forName("com.mysql.jdbc.Driver");
								System.out.println("Driver loaded successfully");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf",
										"root", "");
								Statement stmt = con.createStatement();
								String query = "Insert into attendance (usn,teacher_id,status,date,subjectid,StudentName)"
										+ "values(?,?,?,?,?,?)";
								PreparedStatement ps = con.prepareStatement(query);
								ps.setString(1, col);

								ps.setString(2, id);

								ps.setString(3, "A");
								// ps.setString(8,);
								ps.setString(4, txtDate.getText());
								ps.setString(5, subjectf.getText());
								ps.setString(6, col2);
								ps.execute();
								c++;
							}
							catch (Exception e) {
								System.out.println(e.getMessage());
							}
						

					}
					}
					if (c > 0)
					{
						JOptionPane.showMessageDialog(null, "Attendance pushed");
						btn.setEnabled(false);
					
				} else {
					JOptionPane.showMessageDialog(null,"Eroor");
				}
			
			}
		});
		// ADD BUTTON TO FORM
		btn.setBounds(789, 410, 152, 42);
		atnSPan.add(btn);

		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBackground(new Color(102, 102, 255));
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int c = 0;
				// GET SELECTED ROW
				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
					String col = table.getValueAt(i, 2).toString();

					// DISPLAY
					if ((checked)) {
						try {

							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();
							String sql = "update attendance set status='P' where usn='" + col + "' and teacher_id='"
									+ teacherid + "'";
							stmt.executeUpdate(sql);

							// java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

							c++;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					} else {
						try {

							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();

							String sql = "update attendance set status='A' where usn='" + col + "' and teacher_id='"
									+ teacherid + "' ";
							stmt.executeUpdate(sql);
							c++;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
				if (c > 0)
					JOptionPane.showMessageDialog(null, "Attendance Updated");
					btn.setEnabled(false);

			}

		});
		btnUpdate_1.setBounds(543, 412, 141, 38);
		atnSPan.add(btnUpdate_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 385, 14);
		atnSPan.add(separator);

		JLabel lblAttendanceForDate = new JLabel("Attendance for date:");
		lblAttendanceForDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAttendanceForDate.setBounds(687, 14, 141, 30);
		atnSPan.add(lblAttendanceForDate);
		//		if(desig.equals("HOD"))
		//	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Add(Teacher)*", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("EMUDS-Add Teacher");
		lblNewLabel_9.setFont(new Font("Segoe Print", Font.BOLD, 23));
		lblNewLabel_9.setBounds(10, 11, 300, 40);
		panel.add(lblNewLabel_9);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 62, 519, 17);
		panel.add(separator_1);

		JLabel lblNewLabel_10 = new JLabel("Teacher ID");
		lblNewLabel_10.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNewLabel_10.setBounds(48, 100, 107, 27);
		panel.add(lblNewLabel_10);

		txtteacherid = new JTextField();
		txtteacherid.setBounds(195, 104, 160, 20);
		panel.add(txtteacherid);
		txtteacherid.setColumns(10);

		JLabel lblTeacherName = new JLabel(" Name");
		lblTeacherName.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblTeacherName.setBounds(64, 184, 131, 27);
		panel.add(lblTeacherName);

		txttname = new JTextField();
		txttname.setColumns(10);
		txttname.setBounds(195, 188, 160, 20);
		panel.add(txttname);

		JLabel lblJoiningYear = new JLabel("Joining Year");
		lblJoiningYear.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblJoiningYear.setBounds(48, 265, 131, 27);
		panel.add(lblJoiningYear);

		JLabel lblBranchId = new JLabel("Branch ID");
		lblBranchId.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblBranchId.setBounds(48, 356, 131, 27);
		panel.add(lblBranchId);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Select");

		comboBox_2.setBounds(195, 360, 160, 20);
		panel.add(comboBox_2);
		JLabel lblClassId_1 = new JLabel("Class ID");
		lblClassId_1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblClassId_1.setBounds(48, 437, 131, 27);
		panel.add(lblClassId_1);

		txttclassid = new JTextField();
		txttclassid.setColumns(10);
		txttclassid.setBounds(195, 441, 160, 20);
		
		panel.add(txttclassid);

		if (teacherbranchid.equals("ISE")) {
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "ISE" }));
		}
		if (teacherbranchid.equals("CSE")) {
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "CSE" }));
		}
		if (teacherbranchid.equals("CIVIL")) {
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "CIVIL" }));
		}
		if (teacherbranchid.equals("CIVIL")) {
			comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "17CIV50", "17CIV51", "17CIV52" }));
		} else {
			comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "17CS50", "17CS51", "17CS52" }));
		}
		DefaultTableModel model5 = new DefaultTableModel();
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(537, 33, 131, 20);
		model5.addColumn("Teacher ID");
		model5.addColumn("Name");
		model5.addColumn("Join Year");
		JComboBox comboTeacherJoin = new JComboBox();
		comboTeacherJoin.setModel(new DefaultComboBoxModel(new String[] {"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		comboTeacherJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_2.getSelectedItem().toString().equals("CIVIL"))
				{
					txttclassid.setText(comboTeacherJoin.getSelectedItem().toString().substring(2)+comboBox_2.getSelectedItem().toString().substring(0,3));
				}
				else
					txttclassid.setText(comboTeacherJoin.getSelectedItem().toString().substring(2)+comboBox_2.getSelectedItem().toString().substring(0,2));
			}
		});
		
		comboTeacherJoin.setBounds(165, 23, 158, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Teacher" }));
		comboBox_1.setToolTipText("Select");
		JButton btnSubmitAddT = new JButton("Submit");
		btnSubmitAddT.setBackground(new Color(0, 255, 0));
		btnSubmitAddT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtteacherid.getText().equals("") || txttname.getText().equals("")
						|| txttphone.getText().equals("")
						|| txttclassid.getText().equals("") || txttemail.getText().equals("")
						|| txtD.getText().equals("") || txtY.getText().equals("") || txtM.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter details in all field");
					
					
				} 
				else if(txttphone.getText().length()<10||txttphone.getText().length()>10)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Phone Number");
				}
//				
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
					try {

						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loaded successfully");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
						Statement stmt = con.createStatement();
						String query = "Insert into teacher (teacher_id,Name,Branch_id,classId,DOB,PhoneNo,Email,JoiningYear,Designation,SubjectTeachId,password)"
								+ "values(?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, txtteacherid.getText());
						ps.setString(2, txttname.getText());
						ps.setString(4, txttclassid.getText());
						ps.setString(3, comboBox_2.getSelectedItem().toString());
						ps.setString(5, txtD.getText() + "/" + txtM.getText() + "/" + txtY.getText());
						ps.setString(6, txttphone.getText());
						ps.setString(7, txttemail.getText());
						ps.setString(8, comboTeacherJoin.getSelectedItem().toString());
						ps.setString(9, comboBox_1.getSelectedItem().toString());
						ps.setString(10, comboBox_3.getSelectedItem().toString());
						ps.setString(11, txtteacherid.getText());

						ps.execute();
						JOptionPane.showMessageDialog(null, "Teacher added successfully");
						try {

							model5.getDataVector().removeAllElements(); model5.fireTableDataChanged();
							// model.addRow(new Object[]
							// {textField.getText(),textField_1.getText(),textField_2.getText()});
							ResultSet rs = stmt.executeQuery("select * from teacher where Branch_id='" + teacherbranchid + "'");

							while (rs.next()) {

								model5.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(8) });

							}

						} catch (Exception et) {
							System.out.println(et.getMessage());
						}
						txtteacherid.setText("");
						txttclassid.setText("");
						txttname.setText("");
						txttphone.setText("");
						txttemail.setText("");
						txtD.setText("");
						txtM.setText("");
						txtY.setText("");
					}

					catch (Exception ee) {
						System.out.println(ee.getMessage());
					}
				}

			}
		});
		btnSubmitAddT.setBounds(818, 462, 89, 37);
		panel.add(btnSubmitAddT);

		JButton btnReset_2 = new JButton("Reset");
		btnReset_2.setBackground(new Color(255, 102, 102));
		btnReset_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtteacherid.setText("");
				txttclassid.setText("");
				txttname.setText("");
				txttphone.setText("");
				txttemail.setText("");
			
				txtD.setText("");
				txtM.setText("");
				txtY.setText("");
			}
		});
		btnReset_2.setBounds(973, 462, 89, 37);
		panel.add(btnReset_2);

		JDesktopPane desktopPane_9 = new JDesktopPane();
		desktopPane_9.setBackground(new Color(255, 255, 255));
		desktopPane_9.setBounds(20, 62, 710, 437);
		panel.add(desktopPane_9);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(375, 29, 131, 27);
		desktopPane_9.add(lblDesignation);
		lblDesignation.setFont(new Font("Sylfaen", Font.BOLD, 20));


		desktopPane_9.add(comboBox_1);
		desktopPane_9.add(comboBox_3);

		JLabel lblSubjectId_2 = new JLabel("Subject ID");
		lblSubjectId_2.setBounds(375, 111, 131, 27);
		desktopPane_9.add(lblSubjectId_2);
		lblSubjectId_2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		JLabel lblDob_1 = new JLabel("DOB");
		lblDob_1.setBounds(411, 192, 67, 27);
		desktopPane_9.add(lblDob_1);
		lblDob_1.setFont(new Font("Sylfaen", Font.BOLD, 20));

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(406, 283, 131, 27);
		desktopPane_9.add(lblPhone);
		lblPhone.setFont(new Font("Sylfaen", Font.BOLD, 20));

		txttphone = new JTextField();
		txttphone.setBounds(537, 287, 131, 20);
		desktopPane_9.add(txttphone);
		txttphone.setColumns(10);

		txtD = new JTextField();
		txtD.setBounds(537, 196, 32, 20);
		desktopPane_9.add(txtD);
		txtD.setColumns(10);

		JLabel lblDd_1 = new JLabel("DD");
		lblDd_1.setBounds(513, 199, 24, 14);
		desktopPane_9.add(lblDd_1);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(411, 369, 131, 27);
		desktopPane_9.add(lblEmail);
		lblEmail.setFont(new Font("Sylfaen", Font.BOLD, 20));

		txttemail = new JTextField();
		txttemail.setEditable(false);
		txttemail.setBounds(501, 373, 199, 20);
		desktopPane_9.add(txttemail);
		txttemail.setColumns(10);

		JButton btnGenerate = new JButton("Generate ");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String sEmail2="";
				if(txtteacherid.getText().equals("") || txttname.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Complete All Fields");
				else
				{
					sEmail2 = txttname.getText().toLowerCase().replaceAll("\\s+","").concat(txtteacherid.getText().substring(1)).concat(".").concat(comboBox_2.getSelectedItem().toString().concat("@saividya.ac.in"));
					txttemail.setText(sEmail2);
				}
			}
		});
		btnGenerate.setBounds(563, 403, 89, 23);
		desktopPane_9.add(btnGenerate);

		JDesktopPane desktopPane_13 = new JDesktopPane();
		desktopPane_13.setBackground(new Color(51, 204, 255));
		desktopPane_13.setBounds(10, 11, 690, 69);
		desktopPane_9.add(desktopPane_13);

		JDesktopPane desktopPane_14 = new JDesktopPane();
		desktopPane_14.setBackground(new Color(51, 204, 255));
		desktopPane_14.setBounds(10, 177, 690, 69);
		desktopPane_9.add(desktopPane_14);
		
				JLabel lblYy = new JLabel("YYYY");
				lblYy.setBounds(620, 23, 24, 14);
				desktopPane_14.add(lblYy);
				
						JLabel lblMm = new JLabel("MM");
						lblMm.setBounds(563, 23, 24, 14);
						desktopPane_14.add(lblMm);
						
								txtM = new JTextField();
								txtM.setBounds(583, 20, 32, 20);
								desktopPane_14.add(txtM);
								txtM.setColumns(10);
								
										txtY = new JTextField();
										txtY.setBounds(648, 20, 32, 20);
										desktopPane_14.add(txtY);
										txtY.setColumns(10);
										
										
										desktopPane_14.add(comboTeacherJoin);

		JDesktopPane desktopPane_15 = new JDesktopPane();
		desktopPane_15.setBackground(new Color(51, 204, 255));
		desktopPane_15.setBounds(10, 357, 690, 69);
		desktopPane_9.add(desktopPane_15);

		JDesktopPane desktopPane_10 = new JDesktopPane();
		desktopPane_10.setBackground(new Color(255, 255, 255));
		desktopPane_10.setBounds(734, 441, 359, 58);
		panel.add(desktopPane_10);

		JDesktopPane desktopPane_11 = new JDesktopPane();
		desktopPane_11.setBackground(new Color(51, 102, 204));
		desktopPane_11.setBounds(734, 36, 359, 400);
		panel.add(desktopPane_11);
		JTable table_5 = new JTable(model5);
		table_5.setEnabled(false);
		JScrollPane scroll5 = new JScrollPane();
		scroll5.setBounds(10, 30, 320, 359);
		desktopPane_11.add(scroll5);
		scroll5.setViewportView(table_5);


		JLabel lblTeacherDetails = new JLabel("Teacher Details");
		lblTeacherDetails.setBounds(74, -11, 229, 40);
		desktopPane_11.add(lblTeacherDetails);
		lblTeacherDetails.setFont(new Font("Segoe Print", Font.BOLD, 23));
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();

			// model.addRow(new Object[]
			// {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs = stmt.executeQuery("select * from teacher where Branch_id='" + teacherbranchid + "'");

			while (rs.next()) {

				model5.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(8) });

			}

		} catch (Exception et) {
			System.out.println(et.getMessage());
		}

		JPanel atnTPan = new JPanel();
		tabbedPane.addTab("Attendance(Teacher) *", null, atnTPan, null);
		btn2 = new JButton("Mark");
		btn2.setBounds(746, 22, 80, 38);

		btn2.setBackground(new Color(102, 102, 204));
	
		btnUpdate_2 = new JButton("Update");
		btnUpdate_2.setBounds(591, 22, 90, 38);

		btnUpdate_2.setBackground(new Color(102, 102, 255));

		// ADD BUTTON TO FORM



		btnUpdate_2.setBackground(new Color(102, 102, 255));
		JLabel lblEmudsattendancet = new JLabel("EMUDS-Teacher Attendance ");
		lblEmudsattendancet.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblEmudsattendancet.setBounds(20, 11, 319, 38);
		atnTPan.add(lblEmudsattendancet);

		atxtf2 = new JTextField();
		atxtf2.setEditable(false);
		atxtf2.setBounds(838, 21, 105, 20);
		atnTPan.add(atxtf2);
		atxtf2.setColumns(10);

		DefaultTableModel model6 = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;

				default:
					return String.class;
				}
			}
		};
		txtDate2 = new JTextField();
		txtDate2.setEditable(false);
		// set bounds of text field
		txtDate2.setBounds(64, 107, 134, 20);
		// add text field to contentPane
		atnTPan.add(txtDate2);
		// set columns
		txtDate2.setColumns(10);

		DefaultTableModel model21 = new DefaultTableModel();
		model21.addColumn("Teacher_ID");
		model21.addColumn("Present/Absent");
		model21.addColumn("Name");

		model6.addColumn("Present/Absent");
		model6.addColumn("Name");
		model6.addColumn("Teacher_ID");
		atnTPan.setLayout(null);

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
			Statement stmt = con.createStatement();

			// model.addRow(new Object[]
			// {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs = stmt.executeQuery("select * from teacher where Branch_id='" + teacherbranchid + "' and Designation='Teacher' ");

			while (rs.next()) {

				model6.addRow(new Object[] { false, rs.getString(2), rs.getString(1) });
				model21.addRow(new Object[] { false, rs.getString(2), rs.getString(1) });

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		JButton RefereshButton2 = new JButton("Refresh List");
		RefereshButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model6.getDataVector().removeAllElements(); model6.fireTableDataChanged();
				try { Class.forName("com.mysql.jdbc.Driver");

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root", "");
				Statement stmt=con.createStatement();


				ResultSet rs=stmt.executeQuery("select * from teacher where Branch_id='"+teacherbranchid+"' and Designation='Teacher'"); 

				while(rs.next()) {

					model6.addRow(new Object[] {false,rs.getString(2),rs.getString(1)});

				}
				}

				catch(Exception ee) { System.out.println(ee.getMessage()); } 


			}
		});


		RefereshButton2.setBackground(new Color(0, 0, 204));
		RefereshButton2.setBounds(491, 15, 128, 32);
		atnTPan.add(RefereshButton2);

		JDesktopPane desktopPane_2t = new JDesktopPane();
		desktopPane_2t.setBackground(new Color(51, 153, 204));
		desktopPane_2t.setBounds(418, 69, 632, 299);
		atnTPan.add(desktopPane_2t);
		JTable table7 = new JTable(model6);

		JScrollPane scroll6 = new JScrollPane();
		scroll6.setBounds(10, 11, 612, 277);
		desktopPane_2t.add(scroll6);
		scroll6.setViewportView(table7);

		JButton PickButton2 = new JButton("PickDate");
		PickButton2.setBackground(new Color(255, 0, 51));
		PickButton2.setBounds(222, 98, 117, 38);
		atnTPan.add(PickButton2);
		// perform action listener
		PickButton2.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				count1 = 0;
				// create frame new object  f
				final JFrame f = new JFrame();
				// set text which is collected by date picker i.e. set date
				txtDate2.setText(new DatePicker(f).setPickedDate());
				count1++;
			}
		});

		JDesktopPane desktopPane_7t = new JDesktopPane();
		desktopPane_7t.setBackground(new Color(204, 204, 255));
		desktopPane_7t.setBounds(20, 389, 1038, 83);
		atnTPan.add(desktopPane_7t);

		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int c = 0;
				// GET SELECTED ROW
				for (int i = 0; i < table7.getRowCount(); i++) {
					Boolean checked2 = Boolean.valueOf(table7.getValueAt(i, 0).toString());
					String col2 = table7.getValueAt(i, 2).toString();

					// DISPLAY
					if ((checked2)) {
						try {

							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();
							String sql = "update teacherattendance set status='P' where teacherid='" + col2 + "' and Hodid='"
									+ teacherid + "'";
							stmt.executeUpdate(sql);

							// java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

							c++;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					} else {
						try {

							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();

							String sql = "update teacherattendance set status='A' where teacherid='" + col2 + "' and Hodid='"
									+ teacherid + "' ";
							stmt.executeUpdate(sql);
							c++;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
				if (c > 0)
				{
					JOptionPane.showMessageDialog(null, "Attendance Updated");
				btn2.setEnabled(false);
				}

			}

		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				
					// TODO Auto-generated method stub
					int c = 0;
					// GET SELECTED ROW
					for (int i = 0; i < table7.getRowCount(); i++) {
						Boolean checked2 = Boolean.valueOf(table7.getValueAt(i, 0).toString());
						String col2 = table7.getValueAt(i, 2).toString();
						String col22 = table7.getValueAt(i, 1).toString();

						// DISPLAY
						if ((checked2)) {
							try {

								Class.forName("com.mysql.jdbc.Driver");
								System.out.println("Driver loaded successfully");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf",
										"root", "");
								Statement stmt = con.createStatement();
								String query = "Insert into teacherattendance (teacherid,Hodid,status,date,teacherName)"
										+ "values(?,?,?,?,?)";
								PreparedStatement ps = con.prepareStatement(query);
								ps.setString(1, col2);

								ps.setString(2, id);

								ps.setString(3, "P");
								// ps.setString(8,);
								ps.setString(4, txtDate2.getText());

								ps.setString(5, col22);
								ps.execute();
								c++;
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

						}
						else
						{
							try 
							{

								Class.forName("com.mysql.jdbc.Driver");
								System.out.println("Driver loaded successfully");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf",
										"root", "");
								Statement stmt = con.createStatement();
								String query = "Insert into teacherattendance (teacherid,Hodid,status,date,teacherName)"
										+ "values(?,?,?,?,?)";
								PreparedStatement ps = con.prepareStatement(query);
								ps.setString(1, col2);

								ps.setString(2, id);

								ps.setString(3, "A");
								// ps.setString(8,);
								ps.setString(4, txtDate2.getText());

								ps.setString(5, col22);
								ps.execute();
								c++;
							}
							catch (Exception e)
							{
								System.out.println(e.getMessage());
							}
						}

					}
					if (c > 0)
					{
						JOptionPane.showMessageDialog(null, "Attendance pushed");
						btn2.setEnabled(false);
					}

				} 
			
		});
		/*attendacnce mark*/

		// }

		JPanel calenderpanel = new JPanel();
		calenderpanel.setBackground(new Color(153, 204, 255));
		calenderpanel.setLayout(null);
		tabbedPane.addTab("Reference Calender", null, calenderpanel, null);
		// tabbedPane.setForegroundAt(1, new Color(204, 51, 102));

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\teachertext.gif"));
		lblNewLabel_1.setBounds(1061, 21, 451, 53);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblEmuds = new JLabel("EMUDS");
		lblEmuds.setForeground(new Color(255, 255, 255));
		lblEmuds.setFont(new Font("Sylfaen", Font.BOLD, 56));
		lblEmuds.setBounds(20, 21, 253, 63);
		frame.getContentPane().add(lblEmuds);

		txtDate = new JTextField();
		txtDate.setEditable(false);
		// set bounds of text field
		txtDate.setBounds(64, 107, 134, 20);
		// add text field to contentPane
		atnSPan.add(txtDate);
		// set columns
		txtDate.setColumns(10);
		btn.setEnabled(false);
		// create button and there object
		JButton btnNewButtonP = new JButton("PickDate");
		btnNewButtonP.setBackground(new Color(255, 0, 51));
		// perform action listener
		btnNewButtonP.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				count1 = 0;
				// create frame new object  f
				final JFrame f = new JFrame();
				// set text which is collected by date picker i.e. set date
				txtDate.setText(new DatePicker(f).setPickedDate());
				count1++;
			}
		});


		// set button bound
		btnNewButtonP.setBounds(222, 98, 117, 38);
		// add button in contentPane
		atnSPan.add(btnNewButtonP);
		JLabel lblEmudsattendance = new JLabel("EMUDS-Attendance ");
		lblEmudsattendance.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblEmudsattendance.setBounds(10, 11, 188, 38);
		atnSPan.add(lblEmudsattendance);
	//	btn.setEnabled(false);

		atxtf = new JTextField();
		atxtf.setEditable(false);
		atxtf.setBounds(838, 21, 105, 20);
		atnSPan.add(atxtf);
		atxtf.setColumns(10);
		atxtf = new JTextField();
		atxtf.setEditable(false);
		atxtf.setBounds(838, 21, 105, 20);
		atnSPan.add(atxtf);
		atxtf.setColumns(10);

		JLabel lblSubjectId = new JLabel("Subject ID");
		lblSubjectId.setBounds(64, 420, 89, 23);
		atnSPan.add(lblSubjectId);

		JButton btnRefreshList = new JButton("Refresh List");
		btnRefreshList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
					Statement stmt = con.createStatement();

					// model.addRow(new Object[]
					// {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs = stmt.executeQuery("select * from student where Branch_id='" + teacherbranchid + "'");
					java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
					//    System.out.println(sqlDate);
					//   jTextField3.setText(dateFormat.format(date));
					while (rs.next()) {

						model.addRow(new Object[] { false, rs.getString(2), rs.getString(1) });

					}
				}

				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});

		btnRefreshList.setBackground(new Color(0, 0, 204));
		btnRefreshList.setBounds(491, 15, 128, 32);
		atnSPan.add(btnRefreshList);

		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBackground(new Color(51, 153, 204));
		desktopPane_2.setBounds(418, 69, 632, 299);
		atnSPan.add(desktopPane_2);

		JDesktopPane desktopPane_6 = new JDesktopPane();
		desktopPane_6.setBackground(new Color(102, 153, 153));
		desktopPane_6.setBounds(20, 69, 375, 323);
		atnSPan.add(desktopPane_6);

		JButton btnmark1 = new JButton("Mark");
		btnmark1.setBounds(48, 156, 89, 38);
		desktopPane_6.add(btnmark1);
		btnmark1.setBackground(new Color(204, 102, 0));
		//btn.setEnabled(false);
		JButton btnDisplayAttendance = new JButton("Display Attendance");
		btnDisplayAttendance.setBounds(178, 156, 134, 38);
		desktopPane_6.add(btnDisplayAttendance);
		btnDisplayAttendance.setBackground(new Color(204, 102, 0));
		btnDisplayAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					model2.getDataVector().removeAllElements();
					model2.fireTableDataChanged();
					table.setModel(model2);
					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
					Statement stmt = con.createStatement();

					// model.addRow(new Object[]
					// {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs = stmt.executeQuery("select * from attendance where date='" + txtDate.getText()
							+ "' and teacher_id='" + teacherid + "' ");
					// java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

					//   jTextField3.setText(dateFormat.format(date));
					while (rs.next()) {

						model2.addRow(new Object[] { rs.getString(1), rs.getString(3), rs.getString(6) });

					}
					//    

				}

				catch (Exception eee) {
					System.out.println(eee.getMessage());
				}
			}
		});

		if(!(desig.equals("HOD")))
		{
			tabbedPane.removeTabAt(5);
			tabbedPane.removeTabAt(4);

		}
		btnmark1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				table.setModel(model);
				try {
				//	btn.setEnabled(false);
					count2 = 0;
					java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

					Date d1 = sqlDate;

					SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");

					strDate = sm.format(sqlDate);
					// Converting the String back to java.util.Date
					Date dt = sm.parse(strDate);
					System.out.println("I am " + strDate + "I am txt" + txtDate.getText());
					if (txtDate.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please select date to continue");
					}
					if (Integer.parseInt(txtDate.getText().substring(0,2))<=(Integer.parseInt(strDate.toString().substring(0,2)))) 
					{
						System.out.println("I caem here");
						btn.setEnabled(true);

					} else {
						btn.setEnabled(false);
						btnUpdate_1.setEnabled(true);
					}

				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}
				
				atxtf.setText(txtDate.getText());

				int block = 0;
				//count2++;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
					Statement stmt = con.createStatement();

					ResultSet rs = stmt.executeQuery("{call Proc2()}");
					while (rs.next()) {
						if (rs.getString(4).equals(txtDate.getText()) && rs.getString(2).equals(id)) {
							block = 100;
							break;
						}

					}
					System.out.println("i am " + block);
				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}
				System.out.println("I ama" + block);
				if (block == 100) {
					System.out.println("I also bb");
					btn.setEnabled(false);
				} else {


				}
			}
		});
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

		Date d1 = sqlDate;

		SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");

		strDate = sm.format(sqlDate);
		System.out.println(strDate.toString());
		txtDate.setText(strDate.toString());
		txtDate2.setText(strDate.toString());
		JDesktopPane desktopPane_7 = new JDesktopPane();
		desktopPane_7.setBackground(new Color(102, 153, 153));
		desktopPane_7.setBounds(20, 389, 1038, 83);
		atnSPan.add(desktopPane_7);
		/* ADD EMUDS CALENDER CODE */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}

		// Prepare frame

		// Create controls
		lblMonth = new JLabel("January");
		lblMonth.setForeground(new Color(204, 102, 51));
		lblMonth.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		lblMonth.setBounds(336, 13, 150, 37);
		btnPrev = new JButton("<-----");
		btnPrev.setBounds(10, 25, 86, 25);
		btnNext = new JButton("---->");
		btnNext.setBounds(706, 25, 80, 25);
		mtblCalendar = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		stblCalendar.setBounds(10, 48, 776, 276);
		pnlCalendar = new JPanel(null);

		// Set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));

		// Register action listeners
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());

		// Add controls to pane
		calenderpanel.add(pnlCalendar);
		pnlCalendar.setLayout(null);
		pnlCalendar.add(lblMonth);
		pnlCalendar.add(btnPrev);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);

		// Set bounds
		pnlCalendar.setBounds(209, 78, 796, 335);

		// Make frame visible

		// Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); // Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); // Get day
		realMonth = cal.get(GregorianCalendar.MONTH); // Get month
		realYear = cal.get(GregorianCalendar.YEAR); // Get year
		currentMonth = realMonth; // Match month and year
		currentYear = realYear;

		// Add headers
		String[] headers = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" }; // All headers
		for (int i = 0; i < 7; i++) {
			mtblCalendar.addColumn(headers[i]);
		}

		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); // Set background

		// No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		// Single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Set row/column count
		tblCalendar.setRowHeight(38);
		lblYear = new JLabel("Change year:");
		lblYear.setBounds(428, 424, 80, 20);
		calenderpanel.add(lblYear);
		cmbYear = new JComboBox();
		cmbYear.setBounds(598, 423, 80, 20);
		calenderpanel.add(cmbYear);

		JLabel lblNewLabel_2 = new JLabel("Emuds - Calender");
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(25, 24, 223, 37);
		calenderpanel.add(lblNewLabel_2);
		// tabbedPane.setForegroundAt(6, new Color(204, 0, 102));

		JPanel pnlchangepass = new JPanel();
		pnlchangepass.setBackground(Color.WHITE);
		tabbedPane.addTab("Change Password", null, pnlchangepass, null);
		// tabbedPane.setForegroundAt(7, new Color(204, 0, 102));
		pnlchangepass.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("EMUDS-Change Password");
		lblNewLabel_6.setFont(new Font("Segoe Script", Font.BOLD, 28));
		lblNewLabel_6.setBounds(10, 23, 437, 34);
		pnlchangepass.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Current Password");
		lblNewLabel_7.setFont(new Font("Sylfaen", Font.PLAIN, 39));
		lblNewLabel_7.setBounds(418, 124, 331, 40);
		pnlchangepass.add(lblNewLabel_7);

		currentPasswordf = new JPasswordField();
		currentPasswordf.setBounds(469, 196, 195, 34);
		pnlchangepass.add(currentPasswordf);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Sylfaen", Font.PLAIN, 39));
		lblNewPassword.setBounds(453, 266, 331, 40);
		pnlchangepass.add(lblNewPassword);

		newPasswordf = new JPasswordField();
		newPasswordf.setBounds(469, 342, 195, 34);
		pnlchangepass.add(newPasswordf);
		desktopPane_7t.add(btn2);
		desktopPane_7t.add(btnUpdate_2);
		JDesktopPane desktopPane_6t = new JDesktopPane();
		desktopPane_6t.setBackground(new Color(204, 204, 255));
		desktopPane_6t.setBounds(20, 69, 375, 323);
		atnTPan.add(desktopPane_6t);
		
		JButton MarkButton2 = new JButton("Mark");
		MarkButton2.setBounds(43, 131, 89, 38);
		desktopPane_6t.add(MarkButton2);
		///	desktopPane_6t.add(btnNewButtont);
		MarkButton2.setBackground(new Color(204, 102, 0));
		JButton displayButton2 = new JButton("Display Attendance");
		displayButton2.setBounds(170, 131, 134, 38);
		desktopPane_6t.add(displayButton2);
		//desktopPane_6t.add(btnDisplayAttendancet);
		displayButton2.setBackground(new Color(204, 102, 0));

		JLabel label2 = new JLabel("Attendance for date:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label2.setBounds(671, 14, 141, 30);
		atnTPan.add(label2);
		displayButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					model21.getDataVector().removeAllElements();
					model21.fireTableDataChanged();
					table7.setModel(model21);
					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
					Statement stmt = con.createStatement();

					// model.addRow(new Object[]
					// {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs = stmt.executeQuery("select * from teacherattendance where date='" + txtDate2.getText()
							+ "' and Hodid='" + teacherid + "' ");
					// java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

					//   jTextField3.setText(dateFormat.format(date));
					while (rs.next()) {

						model21.addRow(new Object[] { rs.getString(1), rs.getString(3), rs.getString(5) });

					}
					//    

				}

				catch (Exception eee) {
					System.out.println(eee.getMessage());
				}
			}
		});
		btn2.setEnabled(false);
		MarkButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				table7.setModel(model6);
				count2 = 0;
				try {
			
					java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

					Date d1 = sqlDate;

					SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");

					String strDate = sm.format(sqlDate);
					// Converting the String back to java.util.Date
					Date dt = sm.parse(strDate);
					
					if (txtDate2.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please select date to continue");
					}
					if (Integer.parseInt(txtDate2.getText().substring(0,2))<=(Integer.parseInt(strDate.toString().substring(0,2)))) 
					{
						
						btn2.setEnabled(true);

					} else {
						btn2.setEnabled(false);
						btnUpdate_1.setEnabled(true);
					}

				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}
			
				atxtf2.setText(txtDate2.getText());

				int block = 0;
				count2++;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root", "");
					Statement stmt = con.createStatement();

					ResultSet rs = stmt.executeQuery("select * from teacherattendance");
					while (rs.next()) {
						if (rs.getString(4).equals(txtDate2.getText()) && rs.getString(2).equals(id)) {
							block = 100;
							break;
						}

					}

				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}

				if (block == 100) {

					btn2.setEnabled(false);
				} else {

				}
			}
		});
		btn2.setEnabled(false);
		JButton btnNewButton_2 = new JButton("Confirm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentPasswordf.equals("") || newPasswordf.equals("")) {
					JOptionPane.showMessageDialog(null, "The fields cant be empty");
				} else if (newPasswordf.getText().equals(currentPasswordf.getText()) == false) {

					if (currentPasswordf.getText().equals(pass))

					{
						try {

							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf", "root",
									"");
							Statement stmt = con.createStatement();
							String query = "Update teacher set Password='" + newPasswordf.getText()
									+ "' where teacher_id='" + teacherid + "'";
							stmt.executeUpdate(query);
							JOptionPane.showMessageDialog(null,
									"PasswordUpdated Successfully. Login again to continue");
							frame.setVisible(false);
							Authenticate ob = new Authenticate();
							ob.main(null);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					} else {
						JOptionPane.showMessageDialog(null, "Password Mismatch");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Current Passowrd and New Password cant be same");
				}
			}

		});
		btnNewButton_2.setBackground(new Color(51, 0, 255));
		btnNewButton_2.setBounds(526, 434, 98, 34);
		pnlchangepass.add(btnNewButton_2);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\tenorlogout.gif"));
		lblNewLabel_8.setBounds(418, -88, 231, 252);
		pnlchangepass.add(lblNewLabel_8);

		JButton btnlogout = new JButton("Click here to  ->Logout");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int inputt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?");
				if (inputt == 0) {
					Authenticate obj = new Authenticate();
					obj.main(null);
					frame.setVisible(false);
				} else if (inputt == 1) {

				}

			}
		});
		btnlogout.setBackground(new Color(204, 102, 153));
		btnlogout.setFont(new Font("Snap ITC", Font.PLAIN, 40));
		tabbedPane.addTab("Log Out", null, btnlogout, null);
		// tabbedPane.setForegroundAt(dynamic, new Color(204, 0, 102));

		/* HOD ACCESS */

		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBackground(new Color(51, 102, 153));
		desktopPane_3.setBounds(20, 147, 247, 519);
		frame.getContentPane().add(desktopPane_3);
		if(!(desig.equals("HOD")))
		{
			JLabel LableDashTop = new JLabel("Prof."+""+teachername);
			LableDashTop.setFont(new Font("Sylfaen", Font.BOLD, 20));
			LableDashTop.setBounds(1176, 94, 300, 42);
			frame.getContentPane().add(LableDashTop);

		}
		else
		{
			JLabel LableDashTop = new JLabel("Dr."+""+teachername);
			LableDashTop.setFont(new Font("Sylfaen", Font.BOLD, 20));
			LableDashTop.setBounds(1176, 94, 197, 42);
			frame.getContentPane().add(LableDashTop);

		}
		JLabel lblNewLabel2 = new JLabel("New label");
		lblNewLabel2.setIcon(new ImageIcon("C:\\Users\\Imran\\Documents\\Emuds Contents\\teachdashboard2.jpg"));
		lblNewLabel2.setBounds(10, 11, 3454, 782);
		frame.getContentPane().add(lblNewLabel2);
		cmbYear.addActionListener(new cmbYear_Action());
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);

		// Populate table
		for (int i = realYear - 100; i <= realYear + 100; i++) {
			cmbYear.addItem(String.valueOf(i));
		}

		// Refresh calendar
		refreshCalendar(realMonth, realYear); // Refresh calendar
}

public static void refreshCalendar(int month, int year) {
	// Variables
	String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	int nod, som; // Number Of Days, Start Of Month

	// Allow/disallow buttons
	btnPrev.setEnabled(true);
	btnNext.setEnabled(true);
	if (month == 0 && year <= realYear - 10) {
		btnPrev.setEnabled(false);
	} // Too early
	if (month == 11 && year >= realYear + 100) {
		btnNext.setEnabled(false);
	} // Too late
	lblMonth.setText(months[month]);
	cmbYear.setSelectedItem(String.valueOf(year)); // Select the correct year in the combo box

	// Clear table
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 7; j++) {
			mtblCalendar.setValueAt(null, i, j);
		}
	}

	// Get first day of month and number of days
	GregorianCalendar cal = new GregorianCalendar(year, month, 1);
	nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	som = cal.get(GregorianCalendar.DAY_OF_WEEK);

	// Draw calendar
	for (int i = 1; i <= nod; i++) {
		int row = new Integer((i + som - 2) / 7);
		int column = (i + som - 2) % 7;
		mtblCalendar.setValueAt(i, row, column);
	}

	// Apply renderers
	tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
}

static class tblCalendarRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, selected, focused, row, column);
		if (column == 0 || column == 6) { // Week-end
			setBackground(new Color(255, 220, 220));
		} else { // Week
			setBackground(new Color(255, 255, 255));
		}
		if (value != null) {
			if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth
					&& currentYear == realYear) { // Today
				setBackground(new Color(220, 220, 255));
			}
		}
		setBorder(null);
		setForeground(Color.black);
		return this;
	}
}

static class btnPrev_Action implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (currentMonth == 0) { // Back one year
			currentMonth = 11;
			currentYear -= 1;
		} else { // Back one month
			currentMonth -= 1;
		}
		refreshCalendar(currentMonth, currentYear);
	}
}

static class btnNext_Action implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (currentMonth == 11) { // Foward one year
			currentMonth = 0;
			currentYear += 1;
		} else { // Foward one month
			currentMonth += 1;
		}
		refreshCalendar(currentMonth, currentYear);
	}
}

static class cmbYear_Action implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (cmbYear.getSelectedItem() != null) {
			String b = cmbYear.getSelectedItem().toString();
			currentYear = Integer.parseInt(b);
			refreshCalendar(currentMonth, currentYear);
		}
	}
}
}
