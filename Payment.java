import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField txtCardNumber;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 660);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblPayment.setBounds(610, 37, 213, 38);
		contentPane.add(lblPayment);
		
		JLabel lblSelectYourPayment = new JLabel("Select your payment method");
		lblSelectYourPayment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectYourPayment.setBounds(455, 229, 227, 26);
		contentPane.add(lblSelectYourPayment);
		
		JLabel lblDeliverTo = new JLabel("Deliver to");
		lblDeliverTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeliverTo.setBounds(151, 150, 116, 26);
		contentPane.add(lblDeliverTo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(276, 127, 183, 73);
		contentPane.add(textArea);
		
		JButton btnUpdateAddress = new JButton("Update address");
		btnUpdateAddress.setBounds(487, 150, 109, 23);
		contentPane.add(btnUpdateAddress);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(126, 84, 1030, 17);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(153, 0, 0));
		separator_1.setForeground(new Color(0, 204, 153));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(126, 442, -26, -354);
		contentPane.add(separator_1);
		
		JRadioButton rdbtnUpi = new JRadioButton("UPI");
		rdbtnUpi.setBounds(487, 286, 109, 23);
		contentPane.add(rdbtnUpi);
		
		JRadioButton rdbtnPhonepay = new JRadioButton("PhonePay");
		rdbtnPhonepay.setBounds(487, 375, 109, 23);
		contentPane.add(rdbtnPhonepay);
		
		JRadioButton rdbtnGooglepay = new JRadioButton("GooglePay");
		rdbtnGooglepay.setBounds(487, 443, 109, 23);
		contentPane.add(rdbtnGooglepay);
		
		JRadioButton rdbtnDebitcreditCard = new JRadioButton("Debit/Credit Card");
		rdbtnDebitcreditCard.setBounds(487, 512, 109, 23);
		contentPane.add(rdbtnDebitcreditCard);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(610, 539, 145, 20);
		contentPane.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		JLabel lblCardnumber = new JLabel("CardNumber");
		lblCardnumber.setBounds(524, 542, 72, 14);
		contentPane.add(lblCardnumber);
		
		JLabel lblUpiId = new JLabel("UPI ID");
		lblUpiId.setBounds(550, 330, 46, 17);
		contentPane.add(lblUpiId);
		
		textField = new JTextField();
		textField.setBounds(610, 328, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount to be paid:");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAmount.setBounds(154, 570, 183, 23);
		contentPane.add(lblAmount);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(335, 577, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Reetik\\Desktop\\download.png"));
		lblNewLabel_1.setBounds(387, 354, 63, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Reetik\\Desktop\\googlepay.png"));
		lblNewLabel_4.setBounds(387, 435, 57, 38);
		contentPane.add(lblNewLabel_4);
		
		JButton btnPayNow = new JButton("Pay now");
		btnPayNow.setBackground(new Color(0, 204, 0));
		btnPayNow.setBounds(1056, 550, 116, 46);
		contentPane.add(btnPayNow);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Reetik\\Desktop\\upi.jpg"));
		lblNewLabel_2.setBounds(387, 278, 71, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Reetik\\Desktop\\debit.png"));
		lblNewLabel_3.setBounds(387, 510, 72, 26);
		contentPane.add(lblNewLabel_3);
	}
}
