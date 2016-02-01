import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class RemoveFrame extends JFrame {
	
	private Container pane;
	
	private DataBase database;
	
	//Student or Alumni or Position id
	private JLabel idLabel;
	private JTextField idTextField;
	private int ID;
	
	//choose type
	private JComboBox typeComboBox;
	
	private JButton removeButton;
	
	public RemoveFrame(DataBase database_P) {
		super("Remove an Entry");
		
		pane = getContentPane();
		setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		database = database_P;
		
		// remove by ID only?
		idLabel = new JLabel("ID:");
		idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(idLabel);
        idTextField = new JTextField(10);
        idTextField.setMaximumSize( idTextField.getPreferredSize() );
        idTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(idTextField);
        
        String[] comboTypes = { "Student", "Alumni", "Position" };
		typeComboBox = new JComboBox(comboTypes);
		typeComboBox.setSelectedIndex(0);
		typeComboBox.setMaximumSize( typeComboBox.getPreferredSize() );
		typeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(typeComboBox);
		
		removeButton = new JButton("Submit");
		removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(removeButton);
        
        removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ID = Integer.parseInt(idTextField.getText());
				
				//delete position in applies and then position
				//delete student and applicant or alumni and applicant
				
				switch (typeComboBox.getSelectedIndex()) {
				case 0:
					try {
						database.removeStudent(ID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						database.removeApplicant(ID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				case 1:
					try {
						database.removeAlumni(ID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						database.removeApplicant(ID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				case 2:
					try {
						database.removeApplication(ID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						database.removePosition(ID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
        });
		
		setSize(600,500);
		setLocation(300, 300);
		setVisible(true);
	}
}
