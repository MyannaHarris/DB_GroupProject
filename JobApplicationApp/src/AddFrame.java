import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.*;
import java.util.Properties;


public class AddFrame extends JFrame {
	
	private Container pane;
	private GridLayout gridLayout;
	
	private DataBase database;
	
	//choose type
	private JLabel typeLabel;
	private JComboBox typeComboBox;
	
	private JButton addButton;
	
	private JLabel firstLabel;
	private JTextField firstTextField;
	private JLabel lastLabel;
	private JTextField lastTextField;
	
	private JLabel classLabel;
	private JTextField classTextField;
	private JLabel expGradLabel;
	private JTextField expGradTextField;
	private JLabel MSCLabel;
	private JTextField MSCTextField;
	private JLabel numLabel;
	private JTextField numTextField;
	
	private JLabel gradLabel;
	private JTextField gradTextField;
	private JLabel ageLabel;
	private JTextField ageTextField;
	private JLabel jobLabel;
	private JTextField jobTextField;
	
	private JLabel userLabel;
	private JTextField userTextField;
	private JLabel passLabel;
	private JTextField passTextField;
	
	private JLabel gpaLabel;
	private JTextField gpaTextField;
	private JLabel resumeLabel;
	private JTextField resumeTextField;
	private JLabel letterLabel;
	private JTextField letterTextField;
	private JLabel major1Label;
	private JTextField major1TextField;
	private JLabel major2Label;
	private JTextField major2TextField;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	
	private JLabel titleLabel;
	private JTextField titleTextField;
	private JLabel salaryLabel;
	private JTextField salaryTextField;
	private JLabel descLabel;
	private JTextField descTextField;
	private JLabel accMajorLabel;
	private JTextField accMajorTextField;
	private JLabel accGpaLabel;
	private JTextField accGpaTextField;
	private JLabel dateLabel;
	private JTextField dateTextField;
	
	private JLabel dept_nameLabel;
	private JTextField dept_nameTextField;
	private JLabel dept_hiringLabel;
	private JTextField dept_hiringTextField;
	
	private JLabel comp_nameLabel;
	private JTextField comp_nameTextField;
	private JLabel comp_cityLabel;
	private JTextField comp_cityTextField;
	private JLabel comp_stateLabel;
	private JTextField comp_stateTextField;
	
	
	//applicant_id, first_name, last_name, class, expected_grad_date, MSC, student_number, username_student, password_student
	//alum = applicant_id, first_name, last_name, graduation_date, username_student, password_student
	//applicant = applicant_id, GPA, resume_on_file, cover_letter_on_file, major_1, major_2, home_address, phone_number
	//position = position_id, department_id, title, salary, description, accepted_major, accepted_gpa, apply_by_date
	//department
	//company
	
	public AddFrame(DataBase database_P) {
		super("Add an Entry");
		
		pane = getContentPane();
		gridLayout = new GridLayout(18,2);
		setLayout(gridLayout);
		database = database_P;
		
		//add ID, username, password at least
		//need all info?
		typeLabel = new JLabel("Type:");
		typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(typeLabel);
		String[] comboTypes = { "Student", "Alumni", "Position" };
		typeComboBox = new JComboBox(comboTypes);
		typeComboBox.setSelectedIndex(0);
		typeComboBox.setMaximumSize( typeComboBox.getPreferredSize() );
		typeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(typeComboBox);
        
        //student
        firstLabel = new JLabel("First name:");
        firstLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstTextField = new JTextField(15);
        firstTextField.setMaximumSize( firstTextField.getPreferredSize() );
        firstTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lastLabel = new JLabel("Last name:");
        lastLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastTextField = new JTextField(15);
        lastTextField.setMaximumSize( lastTextField.getPreferredSize() );
        lastTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        classLabel = new JLabel("Class (grade):");
        classLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        classTextField = new JTextField(15);
        classTextField.setMaximumSize( classTextField.getPreferredSize() );
        classTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        expGradLabel = new JLabel("Expected Graduation (YYYY-MM-DD):");
        expGradLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        expGradTextField = new JTextField(15);
        expGradTextField.setMaximumSize( expGradTextField.getPreferredSize() );
        expGradTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        MSCLabel = new JLabel("MSC:");
        MSCLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        MSCTextField = new JTextField(15);
        MSCTextField.setMaximumSize( MSCTextField.getPreferredSize() );
        MSCTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        numLabel = new JLabel("Student number:");
        numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numTextField = new JTextField(15);
        numTextField.setMaximumSize( numTextField.getPreferredSize() );
        numTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        userLabel = new JLabel("Username:");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userTextField = new JTextField(10);
        userTextField.setMaximumSize( userTextField.getPreferredSize() );
        userTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        passLabel = new JLabel("Password:");
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passTextField = new JTextField(15);
        passTextField.setMaximumSize( passTextField.getPreferredSize() );
        passTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        gpaLabel = new JLabel("GPA:");
        gpaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gpaTextField = new JTextField(5);
        gpaTextField.setMaximumSize( gpaTextField.getPreferredSize() );
        gpaTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        resumeLabel = new JLabel("Resume on file? (Y/N):");
        resumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resumeTextField = new JTextField(1);
        resumeTextField.setMaximumSize( resumeTextField.getPreferredSize() );
        resumeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        letterLabel = new JLabel("Cover letter on file? (Y/N):");
        letterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        letterTextField = new JTextField(1);
        letterTextField.setMaximumSize( letterTextField.getPreferredSize() );
        letterTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        major1Label = new JLabel("1st Major:");
        major1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        major1TextField = new JTextField(15);
        major1TextField.setMaximumSize( major1TextField.getPreferredSize() );
        major1TextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        major2Label = new JLabel("2nd Major:");
        major2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        major2TextField = new JTextField(15);
        major2TextField.setMaximumSize( major2TextField.getPreferredSize() );
        major2TextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        addressLabel = new JLabel("Address:");
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addressTextField = new JTextField(20);
        addressTextField.setMaximumSize( addressTextField.getPreferredSize() );
        addressTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        phoneTextField = new JTextField(12);
        phoneTextField.setMaximumSize( phoneTextField.getPreferredSize() );
        phoneTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        pane.add(firstLabel);
        pane.add(firstTextField);
        pane.add(lastLabel);
        pane.add(lastTextField);
        pane.add(classLabel);
        pane.add(classTextField);
        pane.add(expGradLabel);
        pane.add(expGradTextField);
        pane.add(MSCLabel);
        pane.add(MSCTextField);
        pane.add(numLabel);
        pane.add(numTextField);
        pane.add(userLabel);
        pane.add(userTextField);
        pane.add(passLabel);
        pane.add(passTextField);
        
        pane.add(gpaLabel);
        pane.add(gpaTextField);
        pane.add(resumeLabel);
        pane.add(resumeTextField);
        pane.add(letterLabel);
        pane.add(letterTextField);
        pane.add(major1Label);
        pane.add(major1TextField);
        pane.add(major2Label);
        pane.add(major2TextField);
        pane.add(addressLabel);
        pane.add(addressTextField);
        pane.add(phoneLabel);
        pane.add(phoneTextField);
        
		addButton = new JButton("Submit");
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(addButton);
        
        //alumni
        gradLabel = new JLabel("Graduation date (YYYY-MM-DD):");
        gradLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gradTextField = new JTextField(10);
        gradTextField.setMaximumSize( gradTextField.getPreferredSize() );
        gradTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        ageLabel = new JLabel("Age:");
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ageTextField = new JTextField(10);
        ageTextField.setMaximumSize( ageTextField.getPreferredSize() );
        ageTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        jobLabel = new JLabel("Current job title ( or N/A):");
        jobLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jobTextField = new JTextField(10);
        jobTextField.setMaximumSize( jobTextField.getPreferredSize() );
        jobTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //position
        titleLabel = new JLabel("Position title:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleTextField = new JTextField(15);
        titleTextField.setMaximumSize( titleTextField.getPreferredSize() );
        titleTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        salaryLabel = new JLabel("Salary:");
        salaryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        salaryTextField = new JTextField(15);
        salaryTextField.setMaximumSize( salaryTextField.getPreferredSize() );
        salaryTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        descLabel = new JLabel("Description:");
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descTextField = new JTextField(50);
        descTextField.setMaximumSize( descTextField.getPreferredSize() );
        descTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        accMajorLabel = new JLabel("Accepted Major:");
        accMajorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        accMajorTextField = new JTextField(15);
        accMajorTextField.setMaximumSize( accMajorTextField.getPreferredSize() );
        accMajorTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        accGpaLabel = new JLabel("Accepted GPA:");
        accGpaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        accGpaTextField = new JTextField(5);
        accGpaTextField.setMaximumSize( accGpaTextField.getPreferredSize() );
        accGpaTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        dateLabel = new JLabel("Apply by date (YYYY-MM-DD):");
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateTextField = new JTextField(10);
        dateTextField.setMaximumSize( dateTextField.getPreferredSize() );
        dateTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        dept_nameLabel = new JLabel("Department name:");
        dept_nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dept_nameTextField = new JTextField(15);
        dept_nameTextField.setMaximumSize( dept_nameTextField.getPreferredSize() );
        dept_nameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        dept_hiringLabel = new JLabel("Department hiring (Y/N):");
        dept_hiringLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dept_hiringTextField = new JTextField(1);
        dept_hiringTextField.setMaximumSize( dept_hiringTextField.getPreferredSize() );
        dept_hiringTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        comp_nameLabel = new JLabel("Company name:");
        comp_nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        comp_nameTextField = new JTextField(15);
        comp_nameTextField.setMaximumSize( comp_nameTextField.getPreferredSize() );
        comp_nameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        comp_cityLabel = new JLabel("Company city:");
        comp_cityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        comp_cityTextField = new JTextField(15);
        comp_cityTextField.setMaximumSize( comp_cityTextField.getPreferredSize() );
        comp_cityTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        comp_stateLabel = new JLabel("Company state:");
        comp_stateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        comp_stateTextField = new JTextField(2);
        comp_stateTextField.setMaximumSize( comp_stateTextField.getPreferredSize() );
        comp_stateTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        typeComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
                    Object item = arg0.getItem();
                    if ((item.toString()).equals("Student")) {
                    	pane.remove(titleLabel);
                        pane.remove(titleTextField);
                        pane.remove(salaryLabel);
                        pane.remove(salaryTextField);
                        pane.remove(descLabel);
                        pane.remove(descTextField);
                        pane.remove(accMajorLabel);
                        pane.remove(accMajorTextField);
                        pane.remove(accGpaLabel);
                        pane.remove(accGpaTextField);
                        pane.remove(dateLabel);
                        pane.remove(dateTextField);
                        pane.remove(dept_nameLabel);
                        pane.remove(dept_nameTextField);
                        pane.remove(dept_hiringLabel);
                        pane.remove(dept_hiringTextField);
                        pane.remove(comp_nameLabel);
                        pane.remove(comp_nameTextField);
                        pane.remove(comp_cityLabel);
                        pane.remove(comp_cityTextField);
                        pane.remove(comp_stateLabel);
                        pane.remove(comp_stateTextField);
                    	
                    	pane.remove(firstLabel);
                        pane.remove(firstTextField);
                        pane.remove(lastLabel);
                        pane.remove(lastTextField);
                    	pane.remove(userLabel);
                        pane.remove(userTextField);
                        pane.remove(passLabel);
                        pane.remove(passTextField);
                        pane.remove(gpaLabel);
                        pane.remove(gpaTextField);
                        pane.remove(resumeLabel);
                        pane.remove(resumeTextField);
                        pane.remove(letterLabel);
                        pane.remove(letterTextField);
                        pane.remove(major1Label);
                        pane.remove(major1TextField);
                        pane.remove(major2Label);
                        pane.remove(major2TextField);
                        pane.remove(addressLabel);
                        pane.remove(addressTextField);
                        pane.remove(phoneLabel);
                        pane.remove(phoneTextField);
                    	pane.remove(addButton);
                    	pane.remove(gradLabel);
                    	pane.remove(gradTextField);
                    	pane.remove(ageLabel);
                    	pane.remove(ageTextField);
                    	pane.remove(jobLabel);
                    	pane.remove(jobTextField);
                    	
                    	gridLayout.setRows(18);
                    	
                    	pane.add(firstLabel);
                        pane.add(firstTextField);
                        pane.add(lastLabel);
                        pane.add(lastTextField);
                        pane.add(classLabel);
                        pane.add(classTextField);
                        pane.add(expGradLabel);
                        pane.add(expGradTextField);
                        pane.add(MSCLabel);
                        pane.add(MSCTextField);
                        pane.add(numLabel);
                        pane.add(numTextField);
                        pane.add(userLabel);
                        pane.add(userTextField);
                        pane.add(passLabel);
                        pane.add(passTextField);
                        
                        pane.add(gpaLabel);
                        pane.add(gpaTextField);
                        pane.add(resumeLabel);
                        pane.add(resumeTextField);
                        pane.add(letterLabel);
                        pane.add(letterTextField);
                        pane.add(major1Label);
                        pane.add(major1TextField);
                        pane.add(major2Label);
                        pane.add(major2TextField);
                        pane.add(addressLabel);
                        pane.add(addressTextField);
                        pane.add(phoneLabel);
                        pane.add(phoneTextField);
                    	pane.add(addButton);
                    }
                    else if ((item.toString()).equals("Alumni")) {
                    	pane.remove(titleLabel);
                        pane.remove(titleTextField);
                        pane.remove(salaryLabel);
                        pane.remove(salaryTextField);
                        pane.remove(descLabel);
                        pane.remove(descTextField);
                        pane.remove(accMajorLabel);
                        pane.remove(accMajorTextField);
                        pane.remove(accGpaLabel);
                        pane.remove(accGpaTextField);
                        pane.remove(dateLabel);
                        pane.remove(dateTextField);
                        pane.remove(dept_nameLabel);
                        pane.remove(dept_nameTextField);
                        pane.remove(dept_hiringLabel);
                        pane.remove(dept_hiringTextField);
                        pane.remove(comp_nameLabel);
                        pane.remove(comp_nameTextField);
                        pane.remove(comp_cityLabel);
                        pane.remove(comp_cityTextField);
                        pane.remove(comp_stateLabel);
                        pane.remove(comp_stateTextField);
                    	
                    	pane.remove(firstLabel);
                        pane.remove(firstTextField);
                        pane.remove(lastLabel);
                        pane.remove(lastTextField);
                        pane.remove(classLabel);
                        pane.remove(classTextField);
                        pane.remove(expGradLabel);
                        pane.remove(expGradTextField);
                        pane.remove(MSCLabel);
                        pane.remove(MSCTextField);
                        pane.remove(numLabel);
                        pane.remove(numTextField);
                        pane.remove(userLabel);
                        pane.remove(userTextField);
                        pane.remove(passLabel);
                        pane.remove(passTextField);
                        pane.remove(gpaLabel);
                        pane.remove(gpaTextField);
                        pane.remove(resumeLabel);
                        pane.remove(resumeTextField);
                        pane.remove(letterLabel);
                        pane.remove(letterTextField);
                        pane.remove(major1Label);
                        pane.remove(major1TextField);
                        pane.remove(major2Label);
                        pane.remove(major2TextField);
                        pane.remove(addressLabel);
                        pane.remove(addressTextField);
                        pane.remove(phoneLabel);
                        pane.remove(phoneTextField);
                    	pane.remove(addButton);
                    	
                    	gridLayout.setRows(17);
                    	
                    	pane.add(firstLabel);
                        pane.add(firstTextField);
                        pane.add(lastLabel);
                        pane.add(lastTextField);
                    	pane.add(gradLabel);
                    	pane.add(gradTextField);
                    	pane.add(ageLabel);
                    	pane.add(ageTextField);
                    	pane.add(jobLabel);
                    	pane.add(jobTextField);
                    	pane.add(userLabel);
                        pane.add(userTextField);
                        pane.add(passLabel);
                        pane.add(passTextField);
                        
                        pane.add(gpaLabel);
                        pane.add(gpaTextField);
                        pane.add(resumeLabel);
                        pane.add(resumeTextField);
                        pane.add(letterLabel);
                        pane.add(letterTextField);
                        pane.add(major1Label);
                        pane.add(major1TextField);
                        pane.add(major2Label);
                        pane.add(major2TextField);
                        pane.add(addressLabel);
                        pane.add(addressTextField);
                        pane.add(phoneLabel);
                        pane.add(phoneTextField);
                    	pane.add(addButton);
                    }
                    else if ((item.toString()).equals("Position")) {
                    	pane.remove(firstLabel);
                        pane.remove(firstTextField);
                        pane.remove(lastLabel);
                        pane.remove(lastTextField);
                        pane.remove(classLabel);
                        pane.remove(classTextField);
                        pane.remove(expGradLabel);
                        pane.remove(expGradTextField);
                        pane.remove(MSCLabel);
                        pane.remove(MSCTextField);
                        pane.remove(numLabel);
                        pane.remove(numTextField);
                        pane.remove(userLabel);
                        pane.remove(userTextField);
                        pane.remove(passLabel);
                        pane.remove(passTextField);
                        pane.remove(gpaLabel);
                        pane.remove(gpaTextField);
                        pane.remove(resumeLabel);
                        pane.remove(resumeTextField);
                        pane.remove(letterLabel);
                        pane.remove(letterTextField);
                        pane.remove(major1Label);
                        pane.remove(major1TextField);
                        pane.remove(major2Label);
                        pane.remove(major2TextField);
                        pane.remove(addressLabel);
                        pane.remove(addressTextField);
                        pane.remove(phoneLabel);
                        pane.remove(phoneTextField);
                    	pane.remove(addButton);
                    	pane.remove(gradLabel);
                    	pane.remove(gradTextField);
                    	pane.remove(ageLabel);
                    	pane.remove(ageTextField);
                    	pane.remove(jobLabel);
                    	pane.remove(jobTextField);
                    	
                    	gridLayout.setRows(15);
                    	
                    	pane.add(titleLabel);
                        pane.add(titleTextField);
                        pane.add(salaryLabel);
                        pane.add(salaryTextField);
                        pane.add(descLabel);
                        pane.add(descTextField);
                        pane.add(accMajorLabel);
                        pane.add(accMajorTextField);
                        pane.add(accGpaLabel);
                        pane.add(accGpaTextField);
                        pane.add(dateLabel);
                        pane.add(dateTextField);
                        pane.add(dept_nameLabel);
                        pane.add(dept_nameTextField);
                        pane.add(dept_hiringLabel);
                        pane.add(dept_hiringTextField);
                        pane.add(comp_nameLabel);
                        pane.add(comp_nameTextField);
                        pane.add(comp_cityLabel);
                        pane.add(comp_cityTextField);
                        pane.add(comp_stateLabel);
                        pane.add(comp_stateTextField);
                    	pane.add(addButton);
                    }
                    pane.validate();
					pane.repaint();
                 }
				
			}
        });
        
        addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num = typeComboBox.getSelectedIndex();
				switch (num) {
				case 0: {
					try {
						int resume = 0;
						int letter = 0;
						if ((resumeTextField.getText()).equals("Y")) {
							resume = 1;
						}
						if ((letterTextField.getText()).equals("Y")) {
							letter = 1;
						}
						database.addStudent(firstTextField.getText(), lastTextField.getText(), classTextField.getText(),
								expGradTextField.getText(), Integer.parseInt(MSCTextField.getText()), 
								Integer.parseInt(numTextField.getText()),
								userTextField.getText(), passTextField.getText(), 
								Double.parseDouble(gpaTextField.getText()), resume, letter,
								major1TextField.getText(), major2TextField.getText(), addressTextField.getText(),
								phoneTextField.getText());
					} catch (SQLException e) {
					}
					break;
				}
				case 1: {
					try {
						int resume = 0;
						int letter = 0;
						if ((resumeTextField.getText()).equals("Y")) {
							resume = 1;
						}
						if ((letterTextField.getText()).equals("Y")) {
							letter = 1;
						}
						database.addAlumni(firstTextField.getText(), lastTextField.getText(), gradTextField.getText(),
								userTextField.getText(), passTextField.getText(), 
								Double.parseDouble(gpaTextField.getText()), resume, letter,
								major1TextField.getText(), major2TextField.getText(), addressTextField.getText(),
								phoneTextField.getText(), Integer.parseInt(ageTextField.getText()), 
								jobTextField.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 2: {
					try {
						database.addPosition(titleTextField.getText(), salaryTextField.getText(), descTextField.getText(),
								accMajorTextField.getText(), Double.parseDouble(accGpaTextField.getText()), dateTextField.getText(),
								dept_nameTextField.getText(), dept_hiringTextField.getText(),
								comp_nameTextField.getText(), comp_cityTextField.getText(),
								comp_stateTextField.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				}
			}
        });
        
		
		setSize(600,500);
		setLocation(200, 200);
		setVisible(true);
	}
}
