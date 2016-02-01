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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame{
	
	private Container pane;
	
	private JLabel connectLabel;
	private JButton connectButton;
	
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton loginButton;
	
	//choose type
	private JLabel typeLabel;
	private JComboBox typeComboBox;
	
	private String username;
	private String password;
	
	private JButton addButton;
	private JButton removeButton;
	
	private JButton editButton;
	
	private JButton searchButton;
	private JButton logoutButton;
	
    private DataBase database;
    private boolean databaseConnected = false;
    private User user;
    
    private AddFrame addFrame;
    private RemoveFrame removeFrame;
    private SearchFrame searchFrame;
    private EditFrame editFrame;
    private ApplyFrame applyFrame;
	
	public MainFrame() {
		super("Job Application App");
		
		pane = getContentPane();
		setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		connectLabel = new JLabel("Connect to database?");
		connectLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(connectLabel);
        connectButton = new JButton("Connect to database");
        connectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(connectButton);
        
        typeLabel = new JLabel("Type:");
		typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(typeLabel);
		String[] comboTypes = { "Student", "Alumni", "Admin" };
		typeComboBox = new JComboBox(comboTypes);
		typeComboBox.setSelectedIndex(0);
		typeComboBox.setMaximumSize( typeComboBox.getPreferredSize() );
		typeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(typeComboBox);
        
        usernameLabel = new JLabel("Username:");
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(usernameLabel);
        usernameTextField = new JTextField(10);
        usernameTextField.setMaximumSize( usernameTextField.getPreferredSize() );
        usernameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(usernameTextField);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(passwordLabel);
        passwordTextField = new JTextField(15);
        passwordTextField.setMaximumSize( passwordTextField.getPreferredSize() );
        passwordTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(passwordTextField);
        
        loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(loginButton);
        
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        
        editButton = new JButton("Edit");
        
        searchButton = new JButton("Search");
        logoutButton = new JButton("Logout");
        
        addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						addFrame = new AddFrame(database);
					}
				});
			}
        });
        removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						removeFrame = new RemoveFrame(database);
					}
				});
			}
        });
        
        editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						editFrame = new EditFrame(database, user, applyFrame);
					}
				});
			}
        });
        
        connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connectLabel.setText("Connecting...");
				database = new DataBase();
				connectLabel.setText("Connected");
				pane.remove(connectButton);
				databaseConnected = true;
			}
        });
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (databaseConnected) {
					username = usernameTextField.getText();
					password = passwordTextField.getText();
					
					int id = 0;
					try {
						id = database.login(username, password, (typeComboBox.getItemAt(typeComboBox.getSelectedIndex())).toString());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (id == 0) {
						JOptionPane.showMessageDialog(null, "Username or password is wrong.");
						usernameTextField.setText("");
						passwordTextField.setText("");
					}
					else {
						usernameTextField.setText("");
						passwordTextField.setText("");
						user = new User(id);
						user.setType(typeComboBox.getSelectedIndex());
						
						pane.remove(connectButton);
						pane.remove(typeLabel);
						pane.remove(typeComboBox);
						pane.remove(usernameLabel);
						pane.remove(usernameTextField);
						pane.remove(passwordLabel);
						pane.remove(passwordTextField);
						pane.remove(loginButton);
						
						if (user.getID() == 1) {
							addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
					        pane.add(addButton);
					        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
					        pane.add(removeButton);
						}
						else {
							editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
					        pane.add(editButton);
						}
						
				        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pane.add(searchButton);
				        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pane.add(logoutButton);
					}
					pane.validate();
					pane.repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, "Need to connect to database.");
				}
			}
        });
        searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						searchFrame = new SearchFrame(database, user);
					}
				});
			}
        });
        logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pane.remove(addButton);
				pane.remove(removeButton);
				pane.remove(searchButton);
				pane.remove(editButton);
				pane.remove(logoutButton);
				
				pane.add(typeLabel);
				pane.add(typeComboBox);
				
				//addFrame.dispatchEvent(new WindowEvent(addFrame, WindowEvent.WINDOW_CLOSING));
				
		        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		        pane.add(usernameLabel);
		        usernameTextField.setMaximumSize( usernameTextField.getPreferredSize() );
		        usernameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		        pane.add(usernameTextField);
		        
		        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		        pane.add(passwordLabel);
		        passwordTextField.setMaximumSize( passwordTextField.getPreferredSize() );
		        passwordTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		        pane.add(passwordTextField);
		        
		        pane.add(loginButton);

				pane.validate();
				pane.repaint();
			}
        });
		
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
