import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ApplyFrame extends JFrame {
	
	private Container pane;
	
	private DataBase database;
	private User user;
	
	//Position ID
	private JLabel idLabel;
	private JTextField idTextField;
	
	private JLabel dateLabel;
	private JTextField dateTextField;
	private JLabel considerLabel;
	private JTextField considerTextField;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	private JLabel siteLabel;
	private JTextField siteTextField;
	private JLabel offerLabel;
	private JTextField offerTextField;
	private JLabel rejectLabel;
	private JTextField rejectTextField;
	
	private JButton submitButton;
	private JButton searchButton;
	
	private int appID = 0;
	
	public ApplyFrame(DataBase database_P, User user_P) {
		super("Apply to Position / Edit Status");
		
		pane = getContentPane();
		setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		database = database_P;
		user = user_P;
		
		//Use Position ID
		idLabel = new JLabel("Position ID:");
		idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(idLabel);
		idTextField = new JTextField(15);
		idTextField.setMaximumSize( idTextField.getPreferredSize() );
		idTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(idTextField);
		searchButton = new JButton("Search for Application");
		searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(searchButton);
		
		dateLabel = new JLabel("Todays date (YYYY-MM-DD):");
		dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dateTextField = new JTextField(15);
		dateTextField.setMaximumSize( dateTextField.getPreferredSize() );
		dateTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(dateLabel);
		pane.add(dateTextField);
        
		considerLabel = new JLabel("Under consideration (Y/N):");
		considerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		considerTextField = new JTextField(15);
		considerTextField.setMaximumSize( considerTextField.getPreferredSize() );
		considerTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(considerLabel);
		pane.add(considerTextField);
        
		phoneLabel = new JLabel("Phone interview (Y/N):");
		phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneTextField = new JTextField(15);
		phoneTextField.setMaximumSize( phoneTextField.getPreferredSize() );
		phoneTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(phoneLabel);
		pane.add(phoneTextField);
		
		siteLabel = new JLabel("Site interview (Y/N):");
		siteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		siteTextField = new JTextField(15);
		siteTextField.setMaximumSize( siteTextField.getPreferredSize() );
		siteTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(siteLabel);
		pane.add(siteTextField);
        
		offerLabel = new JLabel("Offer (Y/N):");
		offerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		offerTextField = new JTextField(15);
		offerTextField.setMaximumSize( offerTextField.getPreferredSize() );
		offerTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(offerLabel);
		pane.add(offerTextField);
        
		rejectLabel = new JLabel("Rejection (Y/N):");
		rejectLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rejectTextField = new JTextField(15);
		rejectTextField.setMaximumSize( rejectTextField.getPreferredSize() );
		rejectTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(rejectLabel);
		pane.add(rejectTextField);
		
		//Application information
		
		submitButton = new JButton("Submit");
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(submitButton);
        
        searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((idTextField.getText()).length() == 7) {
	            	  ResultSet rs;
	            	  try {
						rs = database.getApplicationInfo(user.getID(), Integer.parseInt(idTextField.getText()));
						if(rs.next()) {
							System.out.println("in the if");
							appID = rs.getInt(1);
							dateTextField.setText((rs.getDate(2)).toString());
							considerTextField.setText(rs.getString(3));
							phoneTextField.setText(rs.getString(4));
							siteTextField.setText(rs.getString(5));
							offerTextField.setText(rs.getString(6));
							rejectTextField.setText(rs.getString(7));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	              }
			}
        });
        
        submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					database.addApplication(appID, user.getID(), Integer.parseInt(idTextField.getText()), dateTextField.getText(),
							considerTextField.getText(), phoneTextField.getText(), siteTextField.getText(),
							offerTextField.getText(), rejectTextField.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        });
		
		setSize(600,500);
		setLocation(300, 300);
		setVisible(true);
	}
}
