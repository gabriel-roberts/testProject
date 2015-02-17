package manageSolution;

import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import com.sun.java.swing.plaf.windows.*;

public class AccountManager extends JFrame {
	
	private Account account;
	private Address address;
	private CreditCard creditCard;
	
	public static final String newline = "\n";
	public static final String VALIDATE_SAVE = "Validate & Save";

	public static final String EXIT = "Exit";
	public static final String VISA = "Visa";
	public static final String DISCOVER = "Discover";
	public static final String MASTER = "Master";
	public static final String VALIDCARD = "Valid Card";

	private JComboBox cmbCardType;

	private JTextField txtFirstName, txtLastName;
	private JTextField txtAddress, txtTown, txtCounty;
	private JTextField txtCardNumber, txtExpDate;

	private JLabel lblCardType;
	private JLabel lblFirstName, lblLastName;
	private JLabel lblAddress, lblTown, lblCounty;
	private JLabel lblCardNumber, lblExpDate;
	private JLabel lblResult, lblResultValue;

	
	public AccountManager() {
		
		super("Customer Account Manager");

		cmbCardType = new JComboBox();
		cmbCardType.addItem(AccountManager.VISA);
		cmbCardType.addItem(AccountManager.MASTER);
		cmbCardType.addItem(AccountManager.DISCOVER);

		txtFirstName = new JTextField(20);
		txtLastName = new JTextField(20);
		txtAddress = new JTextField(20);
		txtTown = new JTextField(20);
		txtCounty = new JTextField(20);
		txtCardNumber = new JTextField(20);
		txtExpDate = new JTextField(20);

		lblCardType = new JLabel("Card Type:");
		lblFirstName = new JLabel("First Name:");
		lblLastName = new JLabel("Last Name:");
		lblAddress = new JLabel("Address:");
		lblTown = new JLabel("City:");
		lblCounty = new JLabel("State:");
		lblCardNumber = new JLabel("Card Number:");
		lblExpDate = new JLabel("Exp Date:");

		lblResult = new JLabel("Result:");
		lblResultValue =
				new JLabel(" Please click on Validate & Save Button");


		//Create the open button
		JButton validateSaveButton =
				new JButton(AccountManager.VALIDATE_SAVE);
		validateSaveButton.setMnemonic(KeyEvent.VK_V);
		JButton exitButton = new JButton(AccountManager.EXIT);
		exitButton.setMnemonic(KeyEvent.VK_X);
		ButtonHandler objButtonHandler = new ButtonHandler(this);


		validateSaveButton.addActionListener(objButtonHandler);
		exitButton.addActionListener(new ButtonHandler());

		JPanel buttonPanel = new JPanel();

		GridBagLayout gridbag = new GridBagLayout();
		buttonPanel.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;

		buttonPanel.add(lblCardType);
		buttonPanel.add(cmbCardType);
		buttonPanel.add(lblFirstName);
		buttonPanel.add(txtFirstName);
		buttonPanel.add(lblLastName);
		buttonPanel.add(txtLastName);
		buttonPanel.add(lblAddress);
		buttonPanel.add(txtAddress);
		buttonPanel.add(lblTown);
		buttonPanel.add(txtTown);
		buttonPanel.add(lblCounty);
		buttonPanel.add(txtCounty);
		buttonPanel.add(lblCardNumber);
		buttonPanel.add(txtCardNumber);
		buttonPanel.add(lblExpDate);
		buttonPanel.add(txtExpDate);
		buttonPanel.add(lblResult);
		buttonPanel.add(lblResultValue);

		buttonPanel.add(validateSaveButton);
		buttonPanel.add(exitButton);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblFirstName, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(txtFirstName, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gridbag.setConstraints(lblLastName, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gridbag.setConstraints(txtLastName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gridbag.setConstraints(lblAddress, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gridbag.setConstraints(txtAddress, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gridbag.setConstraints(lblTown, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gridbag.setConstraints(txtTown, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gridbag.setConstraints(lblCounty, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gridbag.setConstraints(txtCounty, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gridbag.setConstraints(lblCardType, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gridbag.setConstraints(cmbCardType, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gridbag.setConstraints(lblCardNumber, gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gridbag.setConstraints(txtCardNumber, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gridbag.setConstraints(lblExpDate, gbc);
		gbc.gridx = 1;
		gbc.gridy = 7;
		gridbag.setConstraints(txtExpDate, gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gridbag.setConstraints(lblResult, gbc);
		gbc.gridx = 1;
		gbc.gridy = 8;
		gridbag.setConstraints(lblResultValue, gbc);

		gbc.insets.left = 2;
		gbc.insets.right = 2;
		gbc.insets.top = 40;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 10;
		gridbag.setConstraints(validateSaveButton, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 10;
		gridbag.setConstraints(exitButton, gbc);

		Container contentPane = getContentPane();

		contentPane.add(buttonPanel, BorderLayout.CENTER);

	}
	public String getFirstName() {
		return txtFirstName.getText();
	}
	public String getLastName() {
		return txtLastName.getText();
	}
	public String getAddress() {
		return txtAddress.getText();
	}
	public String getTown() {
		return txtTown.getText();
	}
	public String getAddrCnty() {
		return txtCounty.getText();
	}
	public String getCardNumber() {
		return txtCardNumber.getText();
	}
	public String getExpDate() {
		return txtExpDate.getText();
	}
	public String getCardType() {
		return (String) cmbCardType.getSelectedItem();
	}
	public void setResultDisplay(String msg) {
		lblResultValue.setText(msg);
	}
	public Account getAccountObject() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Address getAddressObject() {
		return address;
	}
	public void setAddressObject(Address address) {
		this.address = address;
	}
	public CreditCard getCreditCardObject() {
		return creditCard;
	}
	public void setCreditCardObject(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
} // End of class AccountManager

class ButtonHandler implements ActionListener {
	AccountManager objAccountManager;
	public void actionPerformed(ActionEvent e) {
		String validateCheckResult = null;

		if (e.getActionCommand().equals(AccountManager.EXIT)) {
			System.exit(1);
		}
		if (e.getActionCommand().equals(AccountManager.VALIDATE_SAVE)) {
			//get input values
			String firstName = objAccountManager.getFirstName();
			String lastName = objAccountManager.getLastName();
			String address = objAccountManager.getAddress();
			String town = objAccountManager.getTown();
			String county = objAccountManager.getAddrCnty();
			String cardType = objAccountManager.getCardType();
			String cardNumber =objAccountManager.getCardNumber();
			String cardExpDate = objAccountManager.getExpDate();

			boolean validData = true;
			String errorMessage = "";

			Account account = new Account(firstName, lastName);
			if (account.isValid() == false) {
				validData = false;
				errorMessage = "Invalid FirstName/LastName";
			}

			Address addressObject = new Address(address, town, county);
			if (addressObject.isValid() == false) {
				validData = false;
				errorMessage = "Invalid Address/Town/County";
			}

			CreditCard creditCard = new CreditCard(cardType, cardNumber, cardExpDate);
			if (creditCard.isValid() == false) {
				validData = false;
				errorMessage = "Invalid CreditCard Info";
			}

			boolean result = true;

			if (!validData) {
				System.out.println(errorMessage);
				result = false;
			}

			if (addressObject.save() && account.save() && creditCard.save()) {
				result = true;
			} 
			else {
				result = false;
			}

			if (result) {
				validateCheckResult = " Valid Customer Data: Data Saved Successfully ";

			} 
			else {
				validateCheckResult = " Invalid Customer Data: Data Could Not Be Saved ";

			}

			objAccountManager.setResultDisplay(validateCheckResult);
		}
	}

	public ButtonHandler() {
	}
	public ButtonHandler(AccountManager inobjAccountManager) {
		objAccountManager = inobjAccountManager;
	}

} // End of class ButtonHandler