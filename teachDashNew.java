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

	private JTextField txtDate;
	static JLabel lblMonth, lblYear;
	static JButton btnPrev, btnNext;
	static JTable tblCalendar;
	static JComboBox cmbYear;
	static JFrame frmMain;
	static Container pane;
	static DefaultTableModel mtblCalendar; //Table model
	static JScrollPane stblCalendar; //The scrollpane
	static JPanel pnlCalendar;
	static int realYear, realMonth, realDay, currentYear, currentMonth;
	private JFrame frame;
	private JTextField tname;
	private JTextField tusn;
	private JTextField tclassid;
	private JTextField tdate;
	private JTextField txtDobDd;
	private JTextField txtDobMm;
	private JTextField txtDobYy;
	private JTextField txtemailf;
	private JTextField txtphonef;
	private JTextField txtteacherid;
	private JTextField txttname;
	private JTextField txttdateofjoin;
	private JTextField txttphone;
	private JTextField tproctor;


	private JTextField txttemail;
	private JTextField txttclassid;
	private JTextField txtDesig;
	private JTextField txtD;
	private JTextField txtM;
	private JTextField txtY;
	JFrame frame2;
	private JTable table;
	GregorianCalendar cal;
	int count1,count2;
	String id,pass;
	private JTextField atxtf;
	private JTextField subjectf;
	int count;
	String subject,desig,teacherid,teacherbranchid,teacherphone,teachername,teacheremail,teacherdateofjoin,teacherdob,teacherclassid;
	private JTable table_1;
	private JTextField branchf;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String id,String pass) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teachDashNew window = new teachDashNew(id,pass);
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
	public teachDashNew(String id,String pass) {
		this.id=id;
		this.pass=pass;
		System.out.println("I am"+id+""+pass);
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1373, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);


		branchf = new JTextField();
		branchf.setEditable(false);
		branchf.setBounds(107, 226, 171, 20);

		branchf.setColumns(10);
		try {


			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
			Statement stmt=con.createStatement();

			//	model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs=stmt.executeQuery("select * from teacher where teacher_id='"+id+"' and Password='"+pass+"' ");

			while(rs.next())
			{		
				teacherid=rs.getString(1);
				teacherbranchid=rs.getString(3);
				teachername=rs.getString(2);
				teacherclassid=rs.getString(4);
				teacherdob=rs.getString(5);
				teacherphone=rs.getString(6);
				teacheremail=rs.getString(7);
				teacherdateofjoin=rs.getString(8);
				subject=rs.getString(10);
				desig=rs.getString(9);

			}
			System.out.println("final"+subject);




		}

		catch(Exception eee)
		{
			System.out.println(eee.getMessage());
		}
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setToolTipText("Menu");
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
				tabbedPane.setForegroundAt(0, new Color(204, 51, 102));
				profilePanel.setLayout(null);
				
				JDesktopPane desktopPane = new JDesktopPane();
				desktopPane.setBackground(new Color(255, 255, 255));
				desktopPane.setBounds(82, 51, 906, 367);
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
																		lblEmailDb.setBounds(605, 218, 223, 45);
																		desktopPane.add(lblEmailDb);
																		lblEmailDb.setFont(new Font("Tahoma", Font.PLAIN, 21));
																		
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
																																										
																																												JLabel lblNameDb = new JLabel(teachername);
																																												lblNameDb.setBounds(185, 38, 212, 45);
																																												desktopPane.add(lblNameDb);
																																												lblNameDb.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JPanel newSPan = new JPanel();
		newSPan.setBackground(new Color(255, 255, 204));
		tabbedPane.addTab("Add (Student)", null, newSPan, null);
		tabbedPane.setForegroundAt(1, new Color(204, 51, 102));
		newSPan.setLayout(null);
		JLabel lblNameAddS = new JLabel("Name :");
		lblNameAddS.setBounds(10, 21, 87, 51);
		lblNameAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblNameAddS);

		JLabel lblUsnAddS = new JLabel("USN :");
		lblUsnAddS.setBounds(10, 83, 87, 51);
		lblUsnAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblUsnAddS);

		JLabel lblClassIdAddS = new JLabel("Class Id :");
		lblClassIdAddS.setBounds(10, 145, 87, 51);
		lblClassIdAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblClassIdAddS);

		JLabel lblDeptAddS = new JLabel("Branch:");
		lblDeptAddS.setBounds(10, 207, 87, 51);
		lblDeptAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblDeptAddS);

		JLabel lblDateOfJoin_1 = new JLabel("JoinYear:");
		lblDateOfJoin_1.setBounds(10, 264, 87, 51);
		lblDateOfJoin_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblDateOfJoin_1);
		tproctor = new JTextField();
		tproctor.setBounds(219, 349, 171, 23);
		tproctor.setColumns(10);
		JButton btnSubmitAddS = new JButton("Submit");
		btnSubmitAddS.setBounds(404, 343, 114, 35);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(468, 129, 114, 20);
		comboBox.setToolTipText("Select");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"17CS", "17ME", "17CIV", "17EE"}));
		branchf.setText(teacherbranchid);
		DefaultTableModel model3=new DefaultTableModel();
		DefaultTableModel model4=new DefaultTableModel();
		btnSubmitAddS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(tusn.getText().equals("")||tname.getText().equals("")||tdate.getText().equals("")||txtphonef.getText().equals("")||tclassid.getText().equals("")||tproctor.getText().equals("")||txtemailf.getText().equals("")||txtDobMm.getText().equals("")||txtDobYy.getText().equals("")||txtDobDd.getText().equals("")||tusn.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter details in all field");
				}
				else
				{
					try 
					{

						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loaded successfully");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
						Statement stmt=con.createStatement();
						String query = "Insert into student (USN,Name,Year,Branch_id,class_id,Teacher_id,DOB,Phone_No,Email,subject_id,marks_id,password)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1,tusn.getText().toUpperCase());
						ps.setString(2,tname.getText());
						ps.setString(3,tdate.getText());
						ps.setString(4,branchf.getText().toUpperCase());
						ps.setString(5,tclassid.getText().toUpperCase());
						ps.setString(6,tproctor.getText());
						ps.setString(7,txtDobDd.getText()+"/"+txtDobMm.getText()+"/"+txtDobYy.getText());
						ps.setString(8,txtphonef.getText());
						ps.setString(9,txtemailf.getText());
						ps.setString(10,comboBox.getSelectedItem().toString());
						ps.setString(11,tusn.getText().toUpperCase());
						ps.setString(12,tusn.getText());
						
						String query2 = "Insert into marks (USN,Name,Branch_id,subject_id,IA1,IA2,IA3)"+"values(?,?,?,?,?,?,?)";
						PreparedStatement ps2 = con.prepareStatement(query);
						ps2.setString(1,tusn.getText().toUpperCase());
						ps2.setString(2,tname.getText());
						ps2.setString(3,branchf.getText().toUpperCase());
						ps2.setString(4,subject);
						ps2.setInt(5,0);
						ps2.setInt(6,0);
						ps2.setInt(7,0);
						
						ps2.execute();
						ps.execute();
						JOptionPane.showMessageDialog(null,"Student added successfully");
						model3.getDataVector().removeAllElements();
						model3.fireTableDataChanged();
						table_1.setModel(model3);


						tusn.setText("");
						tclassid.setText("");
						tproctor.setText("");
						txtphonef.setText("");
						txtemailf.setText("");
						tname.setText("");
						tdate.setText("");
						txtDobDd.setText("");
						txtDobMm.setText("");
						txtDobYy.setText("");

						// model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
						ResultSet rs=stmt.executeQuery("select * from student where Branch_id='"+teacherbranchid+"'");
						while(rs.next())
						{


							model3.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3)+"  Batch"});




						}



					}

					catch(Exception e)
					{
						System.out.println("USN already exists");
						JOptionPane.showMessageDialog(null,"USN already exists");
					}

				}
			}
		});


		btnSubmitAddS.setBackground(new Color(0, 255, 0));
		newSPan.add(btnSubmitAddS);
		newSPan.add(comboBox);
		tname = new JTextField();
		tname.setBounds(107, 39, 171, 23);
		newSPan.add(tname);
		tname.setColumns(10);

		tusn = new JTextField();
		tusn.setBounds(107, 102, 171, 23);
		tusn.setColumns(10);
		newSPan.add(tusn);

		tclassid = new JTextField();
		tclassid.setBounds(107, 164, 171, 23);
		tclassid.setColumns(10);
		newSPan.add(tclassid);

		tdate = new JTextField();
		tdate.setBounds(107, 283, 171, 23);
		tdate.setColumns(10);
		newSPan.add(tdate);

		JLabel lblDobAddS = new JLabel("D.O.B :");
		lblDobAddS.setBounds(307, 21, 87, 51);
		lblDobAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblDobAddS);

		JLabel lblSubAddS = new JLabel("Subject Series:");
		lblSubAddS.setBounds(307, 110, 151, 51);
		lblSubAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblSubAddS);

		txtDobDd = new JTextField();
		txtDobDd.setBounds(404, 39, 54, 23);
		txtDobDd.setForeground(Color.LIGHT_GRAY);
		txtDobDd.setText("DD");
		txtDobDd.setColumns(10);
		newSPan.add(txtDobDd);

		txtDobMm = new JTextField();
		txtDobMm.setBounds(464, 40, 54, 23);
		txtDobMm.setForeground(Color.LIGHT_GRAY);
		txtDobMm.setText("MM");
		txtDobMm.setColumns(10);
		newSPan.add(txtDobMm);

		txtDobYy = new JTextField();
		txtDobYy.setBounds(528, 40, 54, 23);
		txtDobYy.setForeground(Color.LIGHT_GRAY);
		txtDobYy.setText("YY");
		txtDobYy.setColumns(10);
		newSPan.add(txtDobYy);

		JLabel lblEmailAddS = new JLabel("Email :");
		lblEmailAddS.setBounds(307, 198, 87, 51);
		lblEmailAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblEmailAddS);

		txtemailf = new JTextField();
		txtemailf.setBounds(404, 217, 171, 23);
		txtemailf.setColumns(10);
		newSPan.add(txtemailf);

		JLabel lblPhoneAddS = new JLabel("Phone :");
		lblPhoneAddS.setBounds(307, 264, 87, 51);
		lblPhoneAddS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblPhoneAddS);

		txtphonef = new JTextField();
		txtphonef.setBounds(404, 283, 171, 23);
		txtphonef.setColumns(10);
		newSPan.add(txtphonef);

		JLabel lblProctor = new JLabel("TeacherID(Procter):");
		lblProctor.setBounds(10, 331, 199, 51);
		lblProctor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newSPan.add(lblProctor);

		newSPan.add(branchf);
		newSPan.add(tproctor);
		JScrollPane scroll2=new JScrollPane();
		scroll2.setBounds(678, 73, 393, 285);
		newSPan.add(scroll2);
		

		table_1 = new JTable(model3);
		//scroll2.setColumnHeaderView(table_1);

		JButton btnNewButton_3 = new JButton("Pick");
		btnNewButton_3.setBackground(new Color(102, 51, 255));
		btnNewButton_3.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton_3.setBounds(723, 387, 89, 35);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
				int column = 0;
				int row = table_1.getSelectedRow();
				System.out.println("I am"+row);
				String value1 = table_1.getModel().getValueAt(row, column).toString();
				System.out.println("I am"+row+"value="+value1);
				tusn.setEditable(false);

				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
					Statement stmt=con.createStatement();

					// model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs=stmt.executeQuery("select * from student where USN='"+value1+"'");






					while(rs.next())
					{

						//		  				  String c1= rs.getString(7).toString().substring(0,2);
						//		  				  String c2= rs.getString(7).toString().substring(2,4);
						//		  				  String c3= rs.getString(7).toString().substring(4,6);
						String [] DobDb = rs.getString(7).split("/");
											tusn.setText(rs.getString(1));
						tclassid.setText(rs.getString(5));
						tproctor.setText(rs.getString(6));
						txtphonef.setText(rs.getString(8));
						txtemailf.setText(rs.getString(9));
						tname.setText(rs.getString(2));
						tdate.setText(rs.getString(3));
						txtDobDd.setText(DobDb[0]);
						txtDobMm.setText(DobDb[1]);
						txtDobYy.setText(DobDb[2]);
						count++;




					}
				}
				catch(Exception ee)
				{
					System.out.println(ee.getMessage());
				}																	  

			}
		});
		newSPan.add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(count>0)
				{
					int inputt = JOptionPane.showConfirmDialog(null,"Confirm your update");
					if(inputt==0)
					{


						try {
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
							Statement stmt=con.createStatement();
							ResultSet rs=stmt.executeQuery("select * from student");


							String query = "update student set USN=?,Name=?,Year=?,Branch_id=?,Class_id=?,teacher_id=?,DOB=?,Phone_NO=?,Email=?,Subject_id=?,Marks_id=?,Password=? where USN='"+tusn.getText()+"'";
							PreparedStatement ps = con.prepareStatement(query);
							ps.setString(1,tusn.getText());
							ps.setString(2,tname.getText());
							ps.setString(3,tdate.getText());
							ps.setString(4,branchf.getText());
							ps.setString(5,tclassid.getText());
							ps.setString(6,tproctor.getText());
							ps.setString(7,txtDobDd.getText()+"/"+txtDobMm.getText()+"/"+txtDobYy.getText());
							ps.setString(8,txtphonef.getText());
							ps.setString(9,txtemailf.getText());
							ps.setString(10,comboBox.getSelectedItem().toString());
							ps.setString(11,tusn.getText());
							ps.setString(12,tusn.getText());
							ps.execute();
							JOptionPane.showMessageDialog(null,"Student data Updated successfully");
							model3.getDataVector().removeAllElements();
							model3.fireTableDataChanged();
							table_1.setModel(model3);
							ResultSet rs2=stmt.executeQuery("select * from student where Branch_id='"+teacherbranchid+"'");
							while(rs2.next())
							{


								model3.addRow(new Object[] {rs2.getString(1),rs2.getString(2),rs2.getString(3)+"  Batch"});




							}
							tusn.setEditable(true);
							tusn.setText("");
							tclassid.setText("");
							tproctor.setText("");
							txtphonef.setText("");
							txtemailf.setText("");
							tname.setText("");
							tdate.setText("");
							txtDobDd.setText("");
							txtDobMm.setText("");
							txtDobYy.setText("");
							count=0;

						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
					}
					else
					{

					}
				}

				else
				{
					JOptionPane.showMessageDialog(null,"Note:Select a student from the list and press PICK");
				}

			}
		});
		btnNewButton_5.setBackground(new Color(0, 204, 255));
		btnNewButton_5.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton_5.setBounds(843, 387, 89, 35);
		newSPan.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Delete");
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(count>0)
				{


					int inputt = JOptionPane.showConfirmDialog(null,"Do you really want to Remove data for "+tname.getText());
					if(inputt==0)
					{

						try {
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
							Statement stmt=con.createStatement();

							String query="delete from student where USN='"+tusn.getText()+"'";
							PreparedStatement ps = con.prepareStatement(query);
							ps.execute();
							JOptionPane.showMessageDialog(null,"Student record deleted Successfully");
							model3.getDataVector().removeAllElements();
							model3.fireTableDataChanged();
							table_1.setModel(model3);
							ResultSet rs2=stmt.executeQuery("select * from student where Branch_id='"+teacherbranchid+"'");

							while(rs2.next())
							{

								model3.addRow(new Object[] {rs2.getString(1),rs2.getString(2),rs2.getString(3)+"  Batch"});

							}
							tusn.setEditable(true);
							tusn.setText("");
							tclassid.setText("");
							tproctor.setText("");
							txtphonef.setText("");
							txtemailf.setText("");
							tname.setText("");
							tdate.setText("");
							txtDobDd.setText("");
							txtDobMm.setText("");
							txtDobYy.setText("");
							count=0;

						}
						catch(Exception ee)
						{
							System.out.println(ee.getMessage());
						}
					}
					else
					{

					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Note:Select a student from the lsit and press Pick to delete");
				}

			}
		});
		btnNewButton_6.setBackground(new Color(255, 0, 0));
		btnNewButton_6.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton_6.setBounds(953, 387, 89, 35);
		newSPan.add(btnNewButton_6);

		JLabel lblNewLabel_3 = new JLabel("Student Details");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblNewLabel_3.setBounds(800, 21, 138, 28);
		newSPan.add(lblNewLabel_3);




		//THE TABLE

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

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
			Statement stmt=con.createStatement();

			// model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs=stmt.executeQuery("select * from student where Branch_id='"+teacherbranchid+"'");






			while(rs.next())
			{


				model3.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3)+"  Batch"});




			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//   final JTable table2=new JTable();
		//   scroll.setViewportView(table2);


		JPanel atnSPan = new JPanel();
		atnSPan.setBackground(new Color(255, 255, 204));
		tabbedPane.addTab("Attendance(Student)", atnSPan);
		tabbedPane.setForegroundAt(2, new Color(204, 51, 102));
		atnSPan.setLayout(null);

		//THE TABLE

		//THE MODEL OF OUR TABLE


		JScrollPane scroll=new JScrollPane();
		scroll.setBounds(436,84,600,268);
		atnSPan.add(scroll);


		//THE TABLE
		final JTable table=new JTable();
		scroll.setViewportView(table);
		//   final JTable table2=new JTable();
		//   scroll.setViewportView(table2);


		DefaultTableModel model2=new DefaultTableModel();
		//THE MODEL OF OUR TABLE
		DefaultTableModel model=new DefaultTableModel()
		{
			public Class<?> getColumnClass(int column)
			{
				switch(column)
				{
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

		//ASSIGN THE MODEL TO TABLE
		table.setModel(model);
		//   table2.setModel(model3);
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

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
			Statement stmt=con.createStatement();

			// model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs=stmt.executeQuery("select * from teacher where teacher_id='"+id+"' and Password='"+pass+"' ");

			while(rs.next())
			{    
				subject=rs.getString(10);
				desig=rs.getString(9);

			}





		}

		catch(Exception eee)
		{
			System.out.println(eee.getMessage());
		}
		subjectf.setText(subject);  



		/*HOOOOOOOOOOOOOOODDDDD*/
		/*if(desig.equals("HOD"))
{*/
		btnNewButton_6.setEnabled(true);
		JButton btnResetForm = new JButton("Reset Form");
		btnResetForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tusn.setEditable(true);
				tusn.setText("");
				tclassid.setText("");
				tproctor.setText("");
				txtphonef.setText("");
				txtemailf.setText("");
				tname.setText("");
				tdate.setText("");
				txtDobDd.setText("");
				txtDobMm.setText("");
				txtDobYy.setText("");
			}
		});
		btnResetForm.setBackground(new Color(204, 255, 51));
		btnResetForm.setBounds(538, 343, 114, 35);
		newSPan.add(btnResetForm);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(662, 56, 424, 316);
		newSPan.add(desktopPane_1);
		
				//newSPan.se(model3);
		
				JPanel newTPan = new JPanel();
				newTPan.setBackground(new Color(255, 255, 204));
				tabbedPane.addTab("Add (Teacher)", null, newTPan, null);
				newTPan.setLayout(null);
				
						JLabel lblNameAddT = new JLabel("Teacher_id:");
						lblNameAddT.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblNameAddT.setBounds(10, 24, 133, 48);
						newTPan.add(lblNameAddT);
						
								JLabel lblDobAddT = new JLabel("Name:");
								lblDobAddT.setFont(new Font("Tahoma", Font.PLAIN, 20));
								lblDobAddT.setBounds(10, 88, 90, 48);
								newTPan.add(lblDobAddT);
								
										JLabel lblEmailAddT = new JLabel("BranchID:");
										lblEmailAddT.setFont(new Font("Tahoma", Font.PLAIN, 20));
										lblEmailAddT.setBounds(10, 157, 90, 48);
										newTPan.add(lblEmailAddT);
										
												JLabel lblDateOfJoinAddT = new JLabel("Year Of Join :");
												lblDateOfJoinAddT.setFont(new Font("Tahoma", Font.PLAIN, 20));
												lblDateOfJoinAddT.setBounds(10, 218, 133, 48);
												newTPan.add(lblDateOfJoinAddT);
												
														JLabel lblPhoneAddT = new JLabel("Phone :");
														lblPhoneAddT.setFont(new Font("Tahoma", Font.PLAIN, 20));
														lblPhoneAddT.setBounds(10, 277, 133, 48);
														newTPan.add(lblPhoneAddT);
														
																txtteacherid = new JTextField();
																txtteacherid.setBounds(147, 37, 191, 30);
																newTPan.add(txtteacherid);
																txtteacherid.setColumns(10);
																
																		txttname = new JTextField();
																		txttname.setColumns(10);
																		txttname.setBounds(147, 101, 191, 30);
																		newTPan.add(txttname);
																		
																				txttdateofjoin = new JTextField();
																				txttdateofjoin.setColumns(10);
																				txttdateofjoin.setBounds(147, 230, 191, 32);
																				newTPan.add(txttdateofjoin);
																				
																						txttphone = new JTextField();
																						txttphone.setColumns(10);
																						txttphone.setBounds(147, 290, 191, 30);
																						newTPan.add(txttphone);
																						JComboBox comboBox_2 = new JComboBox();
																						comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ISE", "CSE", "MECHANICAL", "CIVIL", "EEE"}));
																						comboBox_2.setToolTipText("Select");
																						comboBox_2.setBounds(147, 170, 191, 30);
																						
																						
																								newTPan.add(comboBox_2);
																								
																										JLabel lblclassid = new JLabel("ClassID:");
																										lblclassid.setFont(new Font("Tahoma", Font.PLAIN, 20));
																										lblclassid.setBounds(378, 157, 90, 48);
																										newTPan.add(lblclassid);
																										
																												JLabel lblemail = new JLabel("Email:");
																												lblemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
																												lblemail.setBounds(378, 277, 90, 48);
																												newTPan.add(lblemail);
																												
																														JLabel lblDateofbirth = new JLabel("DateOfBirth:");
																														lblDateofbirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
																														lblDateofbirth.setBounds(378, 24, 118, 48);
																														newTPan.add(lblDateofbirth);
																														
																																JLabel lblDesignation = new JLabel("Designation:");
																																lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 20));
																																lblDesignation.setBounds(378, 88, 118, 48);
																																newTPan.add(lblDesignation);
																																
																																		JLabel lblSubjectid = new JLabel("SubjectID:");
																																		lblSubjectid.setFont(new Font("Tahoma", Font.PLAIN, 20));
																																		lblSubjectid.setBounds(378, 218, 118, 48);
																																		newTPan.add(lblSubjectid);
																																		
																																				JComboBox comboBox_3 = new JComboBox();
																																				comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"17cs50", "17cs51", "17ME50", "17ME51", "17CIV50", "17CIV51", "17EEE50", "17EEE51"}));
																																				comboBox_3.setToolTipText("select");
																																				comboBox_3.setBounds(506, 236, 165, 30);
																																				newTPan.add(comboBox_3);
																																				
																																						txttemail = new JTextField();
																																						txttemail.setBounds(506, 290, 165, 30);
																																						newTPan.add(txttemail);
																																						txttemail.setColumns(10);
																																						
																																								txttclassid = new JTextField();
																																								txttclassid.setBounds(506, 170, 167, 30);
																																								newTPan.add(txttclassid);
																																								txttclassid.setColumns(10);
																																								
																																										txtDesig = new JTextField();
																																										txtDesig.setBounds(506, 101, 165, 30);
																																										newTPan.add(txtDesig);
																																										txtDesig.setColumns(10);
																																										
																																												txtD = new JTextField();
																																												txtD.setBounds(538, 37, 44, 30);
																																												newTPan.add(txtD);
																																												txtD.setColumns(10);
																																												
																																														txtM = new JTextField();
																																														txtM.setBounds(621, 37, 44, 30);
																																														newTPan.add(txtM);
																																														txtM.setColumns(10);
																																														
																																																txtY = new JTextField();
																																																txtY.setColumns(10);
																																																txtY.setBounds(690, 37, 44, 30);
																																																newTPan.add(txtY);
																																																
																																																		JLabel lblNewLabel = new JLabel("DD");
																																																		lblNewLabel.setBounds(509, 45, 19, 14);
																																																		newTPan.add(lblNewLabel);
																																																		
																																																				JLabel lblMm = new JLabel("MM");
																																																				lblMm.setBounds(592, 45, 19, 14);
																																																				newTPan.add(lblMm);
																																																				
																																																						JLabel lblYy = new JLabel("YY");
																																																						lblYy.setBounds(671, 45, 19, 14);
																																																						newTPan.add(lblYy);	
																																																						
																																																								JButton btnSubmitAddT = new JButton("Submit");
																																																								btnSubmitAddT.addActionListener(new ActionListener() {
																																																									public void actionPerformed(ActionEvent e)
																																																									{
																																																										if(txtteacherid.getText().equals("")||txttname.getText().equals("")||txttdateofjoin.getText().equals("")||txttphone.getText().equals("")||txttclassid.getText().equals("")||txttemail.getText().equals("")||txtDesig.getText().equals("")||txtD.getText().equals("")||txtY.getText().equals("")||txtM.getText().equals(""))
																																																										{
																																																											JOptionPane.showMessageDialog(null,"Enter details in all field");
																																																										}
																																																										else
																																																										{
																																																											try 
																																																											{

																																																												Class.forName("com.mysql.jdbc.Driver");
																																																												System.out.println("Driver loaded successfully");
																																																												Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
																																																												Statement stmt=con.createStatement();
																																																												String query = "Insert into teacher (teacher_id,Name,Branch_id,classId,DOB,PhoneNo,Email,JoiningYear,Designation,SubjectTeachId,password)"+"values(?,?,?,?,?,?,?,?,?,?,?)";
																																																												PreparedStatement ps = con.prepareStatement(query);
																																																												ps.setString(1,txtteacherid.getText());
																																																												ps.setString(2,txttname.getText());
																																																												ps.setString(4,txttclassid.getText());
																																																												ps.setString(3,comboBox_2.getSelectedItem().toString());
																																																												ps.setString(5,txtD.getText()+"/"+txtM.getText()+"/"+txtY.getText());
																																																												ps.setString(6,txttphone.getText());
																																																												ps.setString(7,txttemail.getText());
																																																												ps.setString(8,txttdateofjoin.getText());
																																																												ps.setString(9,txtDesig.getText());
																																																												ps.setString(10,comboBox_3.getSelectedItem().toString());
																																																												ps.setString(11,txtteacherid.getText());

																																																												ps.execute();
																																																												JOptionPane.showMessageDialog(null,"Teacher added successfully");
																																																												txtteacherid.setText("");
																																																												txttclassid.setText("");
																																																												txttname.setText("");
																																																												txttphone.setText("");
																																																												txttemail.setText("");
																																																												txttdateofjoin.setText("");
																																																												txtDesig.setText("");
																																																												txtD.setText("");
																																																												txtM.setText("");
																																																												txtY.setText("");
																																																											}


																																																											catch(Exception ee)
																																																											{
																																																												System.out.println(ee.getMessage());
																																																											}

																																																										}
																																																									}
																																																								});
																																																								btnSubmitAddT.setBackground(new Color(0, 255, 0));
																																																								btnSubmitAddT.setBounds(245, 372, 118, 35);
																																																								newTPan.add(btnSubmitAddT);
																																																								
																																																								table_2 = new JTable();
																																																								table_2.setBounds(746, 88, 342, 294);
																																																								newTPan.add(table_2);
																																																								
																																																								JButton btntpick = new JButton("Pick");
																																																								btntpick.setBackground(new Color(102, 51, 204));
																																																								btntpick.setFont(new Font("Sylfaen", Font.BOLD, 14));
																																																								btntpick.setBounds(802, 415, 89, 32);
																																																								newTPan.add(btntpick);
																																																								
																																																								JButton btntupdate = new JButton("Update");
																																																								btntupdate.setBackground(new Color(51, 153, 153));
																																																								btntupdate.setFont(new Font("Sylfaen", Font.BOLD, 14));
																																																								btntupdate.setBounds(901, 415, 89, 32);
																																																								newTPan.add(btntupdate);
																																																								
																																																								JButton btntDelete = new JButton("Delete");
																																																								btntDelete.setBackground(new Color(255, 0, 0));
																																																								btntDelete.setFont(new Font("Sylfaen", Font.BOLD, 14));
																																																								btntDelete.setBounds(999, 415, 89, 32);
																																																								newTPan.add(btntDelete);
																																																								
																																																								JButton btnNewButton_7 = new JButton("Reset Form");
																																																								btnNewButton_7.setBackground(new Color(0, 153, 51));
																																																								btnNewButton_7.setBounds(410, 372, 102, 35);
																																																								newTPan.add(btnNewButton_7);
				JPanel atnTPan = new JPanel();

		tabbedPane.addTab("Attendacne(Teacher)", null, atnTPan, null);

		atnTPan.setLayout(null);
		atnTPan.setVisible(false);


		//}

		java.sql.Date sqlDate2 = new java.sql.Date(new java.util.Date().getTime());
		System.out.println(sqlDate2);
		//    model.addColumn("Points");
		//    model.addColumn("Manager");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
			Statement stmt=con.createStatement();

			// model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
			ResultSet rs=stmt.executeQuery("select * from student where Branch_id='"+teacherbranchid+"'");


			while(rs.next())
			{


				model.addRow(new Object[] {false,rs.getString(2),rs.getString(1)});
				model2.addRow(new Object[] {false,rs.getString(2),rs.getString(1)});




			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//THE ROW

		//OBTAIN SELECTED ROW
		JButton btn=new JButton("Mark");
		btn.setBackground(new Color(102, 102, 204));
		btn.addActionListener(new ActionListener()
		{



			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(count1!=0&&count2!=0)
				{
					// TODO Auto-generated method stub
					int c=0;
					//GET SELECTED ROW
					for(int i=0;i<table.getRowCount();i++)
					{
						Boolean checked=Boolean.valueOf(table.getValueAt(i, 0).toString());
						String col=table.getValueAt(i, 2).toString();
						String col2=table.getValueAt(i, 1).toString();

						//DISPLAY
						if((checked))
						{
							try {


								Class.forName("com.mysql.jdbc.Driver");
								System.out.println("Driver loaded successfully");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
								Statement stmt=con.createStatement();
								String query = "Insert into attendance (usn,subject_id,teacher_id,classes_done,classes_attended,percentage,status,date,subjectid,StudentName)"+"values(?,?,?,?,?,?,?,?,?,?)";
								PreparedStatement ps = con.prepareStatement(query);
								ps.setString(1,col);

								ps.setString(2,"17cs");
								ps.setString(3,id);
								ps.setInt(4,50);
								ps.setInt(5,20);
								ps.setInt(6,20);
								ps.setString(7,"P");
								// ps.setString(8,);
								ps.setString(8,txtDate.getText());
								ps.setString(9,subjectf.getText());
								ps.setString(10,col2);
								ps.execute();
								c++;
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}

						}
						else
						{
							try {


								Class.forName("com.mysql.jdbc.Driver");
								System.out.println("Driver loaded successfully");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
								Statement stmt=con.createStatement();
								String query = "Insert into attendance (usn,subject_id,teacher_id,classes_done,classes_attended,percentage,status,date,subjectid,StudentName)"+"values(?,?,?,?,?,?,?,?,?,?)";
								PreparedStatement ps = con.prepareStatement(query);
								ps.setString(1,col);

								ps.setString(2,"17cs");
								ps.setString(3,id);
								ps.setInt(4,50);
								ps.setInt(5,20);
								ps.setInt(6,20);
								ps.setString(7,"A");
								// ps.setString(8,);
								ps.setString(8,txtDate.getText());
								ps.setString(9,subjectf.getText());
								ps.setString(10,col2);
								ps.execute();
								c++;
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}

					}
					if(c>0)
						JOptionPane.showMessageDialog(null,"Attendance pushed");
					btn.setEnabled(false);

				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please select the date of attendance");
				}
			}
		});

		//ADD BUTTON TO FORM
		btn.setBounds(789,410,152,42);
		atnSPan.add(btn);

		JButton btnCc4 = new JButton("ClassCode 4");
		btnCc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{

			}
		});
		btnCc4.setBounds(198, 291, 104, 23);

		JButton btnCc6 = new JButton("ClassCode6");
		btnCc6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{

			}
		});
		btnCc6.setBounds(198, 244, 104, 23);
		btnCc4.setVisible(false);
		btnCc6.setVisible(false);
		atnSPan.add(btnCc4);
		atnSPan.add(btnCc6);

		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBackground(new Color(102, 102, 255));
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{

				int c=0;
				//GET SELECTED ROW
				for(int i=0;i<table.getRowCount();i++)
				{
					Boolean checked=Boolean.valueOf(table.getValueAt(i, 0).toString());
					String col=table.getValueAt(i, 2).toString();

					//DISPLAY
					if((checked))
					{
						try {


							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
							Statement stmt=con.createStatement();
							String sql = "update attendance set status='P' where usn='"+col+"' and teacher_id='"+teacherid+"'";
							stmt.executeUpdate(sql);


							//	java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

							c++;
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}

					}
					else
					{
						try {


							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded successfully");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
							Statement stmt=con.createStatement();

							String sql = "update attendance set status='A' where usn='"+col+"' and teacher_id='"+teacherid+"' ";
							stmt.executeUpdate(sql);
							c++;
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
					}
				}
				if(c>0)
					JOptionPane.showMessageDialog(null,"Successfull");
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





		JPanel calenderpanel = new JPanel();
		calenderpanel.setBackground(new Color(204, 153, 204));
		calenderpanel.setLayout(null);
		tabbedPane.addTab("Reference Calender", null, calenderpanel, null);
		tabbedPane.setForegroundAt(1, new Color(204, 51, 102));

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Reetik\\Desktop\\teachertext.gif"));
		lblNewLabel_1.setBounds(896, 21, 451, 53);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblEmuds = new JLabel("EMUDS");
		lblEmuds.setFont(new Font("Sylfaen", Font.BOLD, 56));
		lblEmuds.setBounds(20, 21, 253, 63);
		frame.getContentPane().add(lblEmuds);

		JLabel lblNewLabel2 = new JLabel("New label");
		lblNewLabel2.setIcon(new ImageIcon("C:\\Users\\Reetik\\Desktop\\teachdashboard2.jpg"));
		lblNewLabel2.setBounds(10, 11, 3454, 727);
		frame.getContentPane().add(lblNewLabel2);

		txtDate = new JTextField();
		txtDate.setEditable(false);
		//set bounds of text field
		txtDate.setBounds(64, 107, 134, 20);
		//add text field to contentPane
		atnSPan.add(txtDate);
		//set columns
		txtDate.setColumns(10);

		//create button and there object
		JButton btnNewButtonP = new JButton("PickDate");
		btnNewButtonP.setBackground(new Color(255, 0, 51));
		//perform action listener
		btnNewButtonP.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				count1=0;
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				txtDate.setText(new DatePicker(f).setPickedDate());
				count1++;
			}
		});


		//set button bound
		btnNewButtonP.setBounds(222, 98, 117, 38);
		//add button in contentPane
		atnSPan.add(btnNewButtonP);
		JLabel lblEmudsattendance = new JLabel("EMUDS-Attendance ");
		lblEmudsattendance.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblEmudsattendance.setBounds(10, 11, 188, 38);
		atnSPan.add(lblEmudsattendance);

		JButton btnDisplayAttendance = new JButton("Display Attendance");
		btnDisplayAttendance.setBackground(new Color(204, 102, 0));
		btnDisplayAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					model2.getDataVector().removeAllElements();
					model2.fireTableDataChanged();
					table.setModel(model2);
					Class.forName("com.mysql.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
					Statement stmt=con.createStatement();

					//				model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs=stmt.executeQuery("select * from attendance where date='"+txtDate.getText()+"' and teacher_id='"+teacherid+"' ");
					//				java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

					//				   jTextField3.setText(dateFormat.format(date));
					while(rs.next())
					{

						model2.addRow(new Object[] {rs.getString(1),rs.getString(7),rs.getString(10)});

					}
					//				     


				}

				catch(Exception eee)
				{
					System.out.println(eee.getMessage());
				}
			}
		});
		btn.setEnabled(false);
		btnDisplayAttendance.setBounds(196, 177, 134, 38);
		atnSPan.add(btnDisplayAttendance);



		JButton btnNewButton_4 = new JButton("Mark");
		btnNewButton_4.setBackground(new Color(204, 102, 0));
		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				table.setModel(model);
				try
				{
					btn.setEnabled(false);
					java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

					Date d1=sqlDate;



					SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");

					String strDate = sm.format(sqlDate);
					//Converting the String back to java.util.Date
					Date dt = sm.parse(strDate);
					System.out.println("I am "+strDate+"I am txt"+txtDate.getText());
					if (txtDate.getText().equals(strDate.toString())) 
					{ 
						System.out.println("I caem here");
						btn.setEnabled(true);

					} 
					else
					{
						btn.setEnabled(false);
						btnUpdate_1.setEnabled(true);
					}

				}
				catch(Exception ee)
				{
					System.out.println(ee.getMessage());
				}
				count2=0;
				atxtf.setText(txtDate.getText());

				int block=0;
				count2++;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
					Statement stmt=con.createStatement();

					ResultSet rs=stmt.executeQuery("select * from attendance");
					while(rs.next())
					{
						if(rs.getString(8).equals(txtDate.getText())&&rs.getString(3).equals(id))
						{
							block=100;
							break;
						}



					}
					System.out.println("i am "+block);
				}
				catch(Exception ee)
				{
					System.out.println(ee.getMessage());
				}
				System.out.println("I ama"+ block);
				if(block==100)
				{
					System.out.println("I also bb");
					btn.setEnabled(false);
				}
				else
				{
					//
				}
			}
		});
		btnNewButton_4.setBounds(64, 177, 89, 38);
		atnSPan.add(btnNewButton_4);

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

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emudsf","root","");
					Statement stmt=con.createStatement();

					//				model.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText()});
					ResultSet rs=stmt.executeQuery("select * from student where Branch_id='"+teacherbranchid+"'");
					java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
					//			    System.out.println(sqlDate);
					//				   jTextField3.setText(dateFormat.format(date));
					while(rs.next())
					{

						model.addRow(new Object[] {false,rs.getString(2),rs.getString(1)});

					}
				}

				catch(Exception e)
				{
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
		/* ADD EMUDS CALENDER CODE*/
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}

		//Prepare frame


		//Create controls
		lblMonth = new JLabel ("January");
		lblMonth.setForeground(new Color(204, 102, 51));
		lblMonth.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		lblMonth.setBounds(336, 13, 150, 37);
		btnPrev = new JButton ("<-----");
		btnPrev.setBounds(10, 25, 86, 25);
		btnNext = new JButton ("---->");
		btnNext.setBounds(706, 25, 80, 25);
		mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		stblCalendar.setBounds(10, 48, 776, 276);
		pnlCalendar = new JPanel(null);

		//Set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));

		//Register action listeners
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());

		//Add controls to pane
		calenderpanel.add(pnlCalendar);
		pnlCalendar.setLayout(null);
		pnlCalendar.add(lblMonth);
		pnlCalendar.add(btnPrev);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);

		//Set bounds
		pnlCalendar.setBounds(209, 78, 796, 335);

		//Make frame visible

		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;

		//Add headers
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
			mtblCalendar.addColumn(headers[i]);
		}

		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

		//No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		//Single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//Set row/column count
		tblCalendar.setRowHeight(38);
		lblYear = new JLabel ("Change year:");
		lblYear.setBounds(428, 424, 80, 20);
		calenderpanel.add(lblYear);
		cmbYear = new JComboBox();
		cmbYear.setBounds(598, 423, 80, 20);
		calenderpanel.add(cmbYear);

		JLabel lblNewLabel_2 = new JLabel("Emuds - Calender");
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(25, 25, 223, 36);
		calenderpanel.add(lblNewLabel_2);
		
		JPanel pnlchangepass = new JPanel();
		tabbedPane.addTab("Change Password", null, pnlchangepass, null);
		tabbedPane.setForegroundAt(6, new Color(204, 0, 102));
		pnlchangepass.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(180, 41, 357, 246);
		pnlchangepass.add(internalFrame);
		internalFrame.setVisible(true);
		
		JPanel request = new JPanel();
		request.setForeground(new Color(204, 51, 102));
		tabbedPane.addTab("Request Update", null, request, null);
		tabbedPane.setForegroundAt(7, new Color(204, 0, 102));
		JScrollPane scroll3=new JScrollPane();
		scroll3.setBounds(642, 55, 429, 378);
		scroll3.setViewportView(table_3);
		
				JPanel marksPan = new JPanel();
				marksPan.setBackground(Color.WHITE);
				tabbedPane.addTab("Marks", null, marksPan, null);
				tabbedPane.setForegroundAt(8, new Color(204, 51, 102));
				marksPan.setLayout(null);
				marksPan.add(scroll3);
				table_3 = new JTable(model4);
				table_3.setBounds(679, 24, 404, 363);
				marksPan.add(table_3);
				
				JLabel lblNewLabel_4 = new JLabel("EMUDS- Marks Upload");
				lblNewLabel_4.setFont(new Font("Poor Richard", Font.BOLD, 27));
				lblNewLabel_4.setBounds(20, 9, 369, 44);
				marksPan.add(lblNewLabel_4);
				
				JLabel lblStudentName = new JLabel("Student  Name");
				lblStudentName.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblStudentName.setBounds(56, 112, 110, 26);
				marksPan.add(lblStudentName);
				
				JLabel lblStudentId = new JLabel("Student ID");
				lblStudentId.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblStudentId.setBounds(56, 181, 110, 26);
				marksPan.add(lblStudentId);
				
				JLabel lblMarksFor = new JLabel("Marks for ");
				lblMarksFor.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblMarksFor.setBounds(56, 254, 110, 26);
				marksPan.add(lblMarksFor);
				
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setToolTipText("Select");
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"IA 1", "IA 2", "IA 3"}));
				comboBox_1.setBounds(196, 257, 110, 20);
				marksPan.add(comboBox_1);
				
				JLabel lblEnterMarks = new JLabel("Enter Marks");
				lblEnterMarks.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblEnterMarks.setBounds(56, 322, 110, 26);
				marksPan.add(lblEnterMarks);
				
				textField = new JTextField();
				textField.setBounds(196, 325, 110, 20);
				marksPan.add(textField);
				textField.setColumns(10);
				
				JLabel lblSubjectId_1 = new JLabel("Subject ID");
				lblSubjectId_1.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblSubjectId_1.setBounds(56, 383, 110, 26);
				marksPan.add(lblSubjectId_1);
				
				textField_1 = new JTextField();
				textField_1.setBounds(196, 386, 110, 20);
				marksPan.add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(196, 184, 110, 20);
				marksPan.add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(196, 115, 110, 20);
				marksPan.add(textField_3);
				textField_3.setColumns(10);
				
				JButton btnNewButton = new JButton("Push Marks");
				btnNewButton.setBounds(426, 236, 110, 35);
				marksPan.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Pick");
				btnNewButton_1.setBounds(426, 108, 110, 34);
				marksPan.add(btnNewButton_1);
				
				JButton btnReset = new JButton("Reset");
				btnReset.setBounds(426, 375, 110, 34);
				marksPan.add(btnReset);
		
		JButton btnlogout = new JButton("Click here to  ->Logout");
		btnlogout.setBackground(new Color(204, 102, 153));
		btnlogout.setFont(new Font("Snap ITC", Font.PLAIN, 40));
		tabbedPane.addTab("Log Out", null, btnlogout, null);
		tabbedPane.setForegroundAt(9, new Color(204, 0, 102));
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBounds(9, 131, 235, 548);
		frame.getContentPane().add(desktopPane_3);
		cmbYear.addActionListener(new cmbYear_Action());
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);

		//Populate table
		for (int i=realYear-100; i<=realYear+100; i++){
			cmbYear.addItem(String.valueOf(i));
		}

		//Refresh calendar
		refreshCalendar (realMonth, realYear); //Refresh calendar
	}

	public static void refreshCalendar(int month, int year){
		//Variables
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som; //Number Of Days, Start Of Month

		//Allow/disallow buttons
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
		if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
		lblMonth.setText(months[month]);
		cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

		//Clear table
		for (int i=0; i<6; i++){
			for (int j=0; j<7; j++){
				mtblCalendar.setValueAt(null, i, j);
			}
		}

		//Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);

		//Draw calendar
		for (int i=1; i<=nod; i++){
			int row = new Integer((i+som-2)/7);
			int column  =  (i+som-2)%7;
			mtblCalendar.setValueAt(i, row, column);
		}

		//Apply renderers
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	}

	static class tblCalendarRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			if (column == 0 || column == 6){ //Week-end
				setBackground(new Color(255, 220, 220));
			}
			else{ //Week
				setBackground(new Color(255, 255, 255));
			}
			if (value != null){
				if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
					setBackground(new Color(220, 220, 255));
				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}

	static class btnPrev_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (currentMonth == 0){ //Back one year
				currentMonth = 11;
				currentYear -= 1;
			}
			else{ //Back one month
				currentMonth -= 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}
	static class btnNext_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (currentMonth == 11){ //Foward one year
				currentMonth = 0;
				currentYear += 1;
			}
			else{ //Foward one month
				currentMonth += 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}
	static class cmbYear_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (cmbYear.getSelectedItem() != null){
				String b = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				refreshCalendar(currentMonth, currentYear);
			}
		}
	}
}



