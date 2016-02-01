import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class EditFrame extends JFrame {
	
	private Container pane;
	private GridLayout gridLayout;
	
	private DataBase database;
	private User user;
	
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
	
	private JButton submitButton;
	private JButton applyButton;
	
	private ApplyFrame applyFrame;
	
	public EditFrame(DataBase database_P, User user_P, ApplyFrame applyFrame_P) {
		super("Edit Profile");
		
		user = user_P;
		pane = getContentPane();
		if (user.getType() == 0) {
			gridLayout = new GridLayout(18,2);
		}
		else {
			gridLayout = new GridLayout(17,2);
		}
		setLayout(gridLayout);
		database = database_P;
		applyFrame = applyFrame_P;
		
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
        
        pane.add(firstLabel);
        pane.add(firstTextField);
        pane.add(lastLabel);
        pane.add(lastTextField);
		
        if (user.getType() == 1) {
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
        
        pane.add(gradLabel);
        pane.add(gradTextField);
        pane.add(ageLabel);
    	pane.add(ageTextField);
    	pane.add(jobLabel);
    	pane.add(jobTextField);
        }
        else {
		//student
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
        
        pane.add(classLabel);
        pane.add(classTextField);
        pane.add(expGradLabel);
        pane.add(expGradTextField);
        pane.add(MSCLabel);
        pane.add(MSCTextField);
        pane.add(numLabel);
        pane.add(numTextField);
        }
        
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
        
        resumeLabel = new JLabel("Resume on file? (Yes/No):");
        resumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resumeTextField = new JTextField(5);
        resumeTextField.setMaximumSize( resumeTextField.getPreferredSize() );
        resumeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        letterLabel = new JLabel("Cover letter on file? (Yes/No):");
        letterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        letterTextField = new JTextField(5);
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
		
		//user can only edit their own info
		submitButton = new JButton("Submit");
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(submitButton);
        
        ResultSet rs;
  	    try {
			rs = database.getUserInfo(user.getID(), user.getType());
			if(rs.next()) {
				if (user.getType() == 0) {
					//class, expected_grad_date, MSC, student_number, username_student, password_student, GPA, resume_on_file, 
					//	cover_letter_on_file, major_1, major_2, home_address, phone_number
					firstTextField.setText(rs.getString(1));
					lastTextField.setText(rs.getString(2));
					classTextField.setText(rs.getString(3));
					expGradTextField.setText((rs.getDate(4)).toString());
					MSCTextField.setText(Integer.toString(rs.getInt(5)));
					numTextField.setText(Integer.toString(rs.getInt(6)));
					userTextField.setText(rs.getString(7));
					passTextField.setText(rs.getString(8));
					gpaTextField.setText(Double.toString(rs.getDouble(9)));
					if (Integer.parseInt(rs.getString(10)) == 0) {
						resumeTextField.setText("N");
					}
					else {
						resumeTextField.setText("Y");
					}
					if (Integer.parseInt(rs.getString(11)) == 0) {
						letterTextField.setText("N");
					}
					else {
						letterTextField.setText("Y");
					}
					major1TextField.setText(rs.getString(12));
					major2TextField.setText(rs.getString(13));
					addressTextField.setText(rs.getString(14));
					phoneTextField.setText(rs.getString(15));
				}
				else {
					//first_name, last_name, graduation_date, age, current_job, username_alumni, password_alumni, GPA,
					//	resume_on_file, cover_letter_on_file, major_1, major_2, home_address, phone_number
					firstTextField.setText(rs.getString(1));
					lastTextField.setText(rs.getString(2));
					gradTextField.setText((rs.getDate(3)).toString());
					ageTextField.setText(Integer.toString(rs.getInt(4)));
					jobTextField.setText(rs.getString(5));
					userTextField.setText(rs.getString(6));
					passTextField.setText(rs.getString(7));
					gpaTextField.setText(Double.toString(rs.getDouble(8)));
					if (Integer.parseInt(rs.getString(9)) == 0) {
						resumeTextField.setText("N");
					}
					else {
						resumeTextField.setText("Y");
					}
					if (Integer.parseInt(rs.getString(10)) == 0) {
						letterTextField.setText("N");
					}
					else {
						letterTextField.setText("Y");
					}
					major1TextField.setText(rs.getString(11));
					major2TextField.setText(rs.getString(12));
					addressTextField.setText(rs.getString(13));
					phoneTextField.setText(rs.getString(14));
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (user.getType() == 1) {
					//alumni
					try {
						int resume = 0;
						int letter = 0;
						if ((resumeTextField.getText()).equals("Y")) {
							resume = 1;
						}
						if ((letterTextField.getText()).equals("Y")) {
							letter = 1;
						}
						database.editAlumni(user.getID(), firstTextField.getText(), lastTextField.getText(), gradTextField.getText(),
								userTextField.getText(), passTextField.getText(), 
								Double.parseDouble(gpaTextField.getText()), resume, letter,
								major1TextField.getText(), major2TextField.getText(), addressTextField.getText(),
								phoneTextField.getText(), Integer.parseInt(ageTextField.getText()), 
								jobTextField.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					//student
					try {
						int resume = 0;
						int letter = 0;
						if ((resumeTextField.getText()).equals("Y")) {
							resume = 1;
						}
						if ((letterTextField.getText()).equals("Y")) {
							letter = 1;
						}
						database.editStudent(user.getID(), firstTextField.getText(), lastTextField.getText(), classTextField.getText(),
								expGradTextField.getText(), Integer.parseInt(MSCTextField.getText()), 
								Integer.parseInt(numTextField.getText()),
								userTextField.getText(), passTextField.getText(), 
								Double.parseDouble(gpaTextField.getText()), resume, letter,
								major1TextField.getText(), major2TextField.getText(), addressTextField.getText(),
								phoneTextField.getText());
					} catch (SQLException e) {
					}
				}
			}
        });
		
		//user can create application for job
		applyButton = new JButton("Apply for position / Edit Status");
		applyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(applyButton);
        
        applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						applyFrame = new ApplyFrame(database, user);
					}
				});
			}
        });
		
		setSize(600,500);
		setLocation(200, 200);
		setVisible(true);
	}
}
