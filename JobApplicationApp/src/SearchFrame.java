import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//if user, search jobs
//if admin, search anything?
public class SearchFrame extends JFrame {
	
	private Container pane;
	
	private DataBase database;
	private User user;
	
	
	private JLabel compLabel;
	private JTextField compTextField;
	private JLabel titleLabel;
	private JTextField titleTextField;
	
	//choose type
	private JComboBox typeComboBox;
	private JComboBox searchComboBox1;
	private JComboBox searchComboBox2;
	private JComboBox searchComboBox3;
	private JComboBox searchComboBox4;
	
	private JLabel idLabel;
	private JTextField idTextField;
	
	private JLabel firstLabel;
	private JTextField firstTextField;
	private JLabel lastLabel;
	private JTextField lastTextField;
	
	private JButton searchButton;
	
	private	JList searchList;
	private JScrollPane searchScrollPane;
	private DefaultListModel listModel;
	
	private String[] comboTypes2 = { "Search by Company", "Search by Position Title" };
	private String[] comboTypes1 = { "Search by ID", "Search by Name" };
	private String[] comboTypes = { "Student", "Alumni", "Position" };
	
	public SearchFrame(DataBase database_P, User user_P) {
		super("Search the Database");
		
		pane = getContentPane();
		setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		database = database_P;
		user = user_P;
		listModel = new DefaultListModel();
		
		searchList = new JList(listModel);
        searchList.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        searchScrollPane = new JScrollPane(searchList);
        searchScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        searchButton = new JButton("Search");
		searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(searchButton);
        
        if (user.getID() == 1) {
        	typeComboBox = new JComboBox(comboTypes);
    		typeComboBox.setSelectedIndex(0);
    		typeComboBox.setMaximumSize( typeComboBox.getPreferredSize() );
    		typeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
    		
    		searchComboBox1 = new JComboBox(comboTypes1);
        	searchComboBox1.setSelectedIndex(0);
        	searchComboBox1.setMaximumSize( searchComboBox1.getPreferredSize() );
        	searchComboBox1.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	searchComboBox2 = new JComboBox(comboTypes1);
        	searchComboBox2.setSelectedIndex(0);
        	searchComboBox2.setMaximumSize( searchComboBox2.getPreferredSize() );
        	searchComboBox2.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	searchComboBox3 = new JComboBox(comboTypes2);
        	searchComboBox3.setSelectedIndex(0);
        	searchComboBox3.setMaximumSize( searchComboBox3.getPreferredSize() );
        	searchComboBox3.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	idLabel = new JLabel("ID:");
    		idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    		idTextField = new JTextField(15);
    		idTextField.setMaximumSize( idTextField.getPreferredSize() );
    		idTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
    		
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
            
            compLabel = new JLabel("Company name:");
        	compLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	compTextField = new JTextField(10);
            compTextField.setMaximumSize( compTextField.getPreferredSize() );
            compTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            titleLabel = new JLabel("Position title:");
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            titleTextField = new JTextField(10);
            titleTextField.setMaximumSize( titleTextField.getPreferredSize() );
            titleTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
            pane.remove(searchScrollPane);
        pane.add(typeComboBox);
        pane.add(searchComboBox1);
        pane.add(idLabel);
		pane.add(idTextField);
		pane.add(searchScrollPane);
        
        searchComboBox1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					pane.remove(searchScrollPane);
					pane.remove(idLabel);
                	pane.remove(idTextField);
                	pane.remove(firstLabel);
                	pane.remove(firstTextField);
                	pane.remove(lastLabel);
                	pane.remove(lastTextField);
					
                    Object item = arg0.getItem();
                    if ((item.toString()).equals("Search by ID")) {
                		pane.add(idLabel);
                		pane.add(idTextField);
                		pane.add(searchScrollPane);
                    }
                    else if ((item.toString()).equals("Search by Name")) {
                        pane.add(firstLabel);
                        pane.add(firstTextField);
                        
                        pane.add(lastLabel);
                        pane.add(lastTextField);
                        pane.add(searchScrollPane);
                    }
                    pane.validate();
					pane.repaint();
                    }
                 }
        });
        
        typeComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					pane.remove(searchScrollPane);
					pane.remove(idLabel);
                	pane.remove(idTextField);
                	pane.remove(firstLabel);
                	pane.remove(firstTextField);
                	pane.remove(lastLabel);
                	pane.remove(lastTextField);
                	pane.remove(searchComboBox1);
                	pane.remove(searchComboBox2);
                	pane.remove(searchComboBox3);
                	pane.remove(compLabel);
                    pane.remove(compTextField);
                    pane.remove(titleLabel);
                    pane.remove(titleTextField);
					
                    Object item = arg0.getItem();
                    if ((item.toString()).equals("Student")) {                 	
                        pane.add(searchComboBox1);
                        pane.add(idLabel);
                        pane.add(idTextField);
                        pane.add(firstLabel);
                        pane.add(firstTextField);
                        pane.add(lastLabel);
                        pane.add(lastTextField);
                        pane.add(searchScrollPane);
                    }
                    else if ((item.toString()).equals("Alumni")) {
                        pane.add(searchComboBox2);
                        pane.add(idLabel);
                		pane.add(idTextField);
                        pane.add(searchScrollPane);
                        
                        searchComboBox2.addItemListener(new ItemListener() {
                			@Override
                			public void itemStateChanged(ItemEvent arg0) {
                				if (arg0.getStateChange() == ItemEvent.SELECTED) {
                					pane.remove(searchScrollPane);
                					pane.remove(idLabel);
                                	pane.remove(idTextField);
                                	pane.remove(firstLabel);
                                	pane.remove(firstTextField);
                                	pane.remove(lastLabel);
                                	pane.remove(lastTextField);
                					
                                    Object item = arg0.getItem();
                                    if ((item.toString()).equals("Search by ID")) {
                                		pane.add(idLabel);
                                		pane.add(idTextField);
                                		pane.add(searchScrollPane);
                                    }
                                    else if ((item.toString()).equals("Search by Name")) {
                                        pane.add(firstLabel);
                                        pane.add(firstTextField);
                                        
                                        pane.add(lastLabel);
                                        pane.add(lastTextField);
                                        pane.add(searchScrollPane);
                                    }
                                    pane.validate();
                					pane.repaint();
                                 }
                				
                			}
                        });
                    }
                    else if ((item.toString()).equals("Position")) {
                    	pane.remove(idLabel);
                    	pane.remove(idTextField);
                    	pane.remove(firstLabel);
                    	pane.remove(firstTextField);
                    	pane.remove(lastLabel);
                    	pane.remove(lastTextField);
                    	pane.remove(searchComboBox1);
                    	pane.remove(searchComboBox2);
                    	pane.remove(searchComboBox3);
                    	
                    	pane.add(searchComboBox3);
                    	pane.add(compLabel);
                        pane.add(compTextField);
                    	pane.add(searchScrollPane);
                        
                        searchComboBox3.addItemListener(new ItemListener() {
                			@Override
                			public void itemStateChanged(ItemEvent arg0) {
                				if (arg0.getStateChange() == ItemEvent.SELECTED) {
                					pane.remove(searchScrollPane);
                					pane.remove(compLabel);
                                    pane.remove(compTextField);
                                    pane.remove(titleLabel);
                                    pane.remove(titleTextField);
                					
                                    Object item = arg0.getItem();
                                    if ((item.toString()).equals("Search by Company")) {
                                        pane.add(compLabel);
                                        pane.add(compTextField);
                                        pane.add(searchScrollPane);
                                    }
                                    else if ((item.toString()).equals("Search by Position Title")) {
                                        pane.add(titleLabel);
                                        pane.add(titleTextField);
                                        pane.add(searchScrollPane);
                                    }
                                    pane.validate();
                					pane.repaint();
                                    }
                                 }
                        });
                    }
                    pane.validate();
					pane.repaint();
                 }
				
			}
        });
        }
        else {
        	searchComboBox4 = new JComboBox(comboTypes2);
        	searchComboBox4.setSelectedIndex(0);
        	searchComboBox4.setMaximumSize( searchComboBox4.getPreferredSize() );
        	searchComboBox4.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
            compLabel = new JLabel("Company name:");
        	compLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            compTextField = new JTextField(10);
            compTextField.setMaximumSize( compTextField.getPreferredSize() );
            compTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            compLabel = new JLabel("Company name:");
        	compLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	compTextField = new JTextField(10);
            compTextField.setMaximumSize( compTextField.getPreferredSize() );
            compTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            titleLabel = new JLabel("Position title:");
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            titleTextField = new JTextField(10);
            titleTextField.setMaximumSize( titleTextField.getPreferredSize() );
            titleTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            pane.add(searchComboBox4);
            pane.add(compLabel);
            pane.add(compTextField);
            pane.add(searchScrollPane);
            
            searchComboBox4.addItemListener(new ItemListener() {
    			@Override
    			public void itemStateChanged(ItemEvent arg0) {
    				if (arg0.getStateChange() == ItemEvent.SELECTED) {
    					pane.remove(searchScrollPane);
    					pane.remove(compLabel);
                        pane.remove(compTextField);
                        pane.remove(titleLabel);
                        pane.remove(titleTextField);
    					
                        Object item = arg0.getItem();
                        if ((item.toString()).equals("Search by Company")) {
                            pane.add(compLabel);
                            pane.add(compTextField);
                            pane.add(searchScrollPane);
                        }
                        else if ((item.toString()).equals("Search by Position Title")) {
                            pane.add(titleLabel);
                            pane.add(titleTextField);
                            pane.add(searchScrollPane);
                        }
                        pane.validate();
    					pane.repaint();
                        }
                     }
            });
        }
		
		if (user.getID() == 1) {
			//admin can access everything?
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int num = typeComboBox.getSelectedIndex();
					ResultSet rs;
					switch (num) {
					case 0: {
						int num1 = searchComboBox1.getSelectedIndex();
						switch (num1) {
						case 0: {
							try {
								//applicant_id, first_name, last_name, class, expected_grad_date, MSC
								rs = database.getInfoByID(0, Integer.parseInt(idTextField.getText()));
								listModel.clear();
								listModel.addElement("Applicant ID\t\tLast, First\t\tClass\t\tGrad Date\t\tMSC\n");
								while (rs.next()) {
									String applicant_id = rs.getString("applicant_id");
									String first_name = rs.getString("first_name");
						            String last_name = rs.getString("last_name");
						            String classyear = rs.getString("class");
						            String expected_grad_date = rs.getDate("expected_grad_date").toString();
						            String MSC = Integer.toString(rs.getInt("MSC"));
									listModel.addElement(applicant_id + "\t\t" + last_name +
				                               ", " + first_name + "\t\t" + classyear +
				                               "\t\t" + expected_grad_date + "\t\t" + MSC + "\n");
								}
							} catch (SQLException e) {
							}
							break;
						}
						case 1: {
							try {
								//applicant_id, first_name, last_name, class, expected_grad_date, MSC
								rs = database.getInfoByName(0, firstTextField.getText(), lastTextField.getText());
								listModel.clear();
								listModel.addElement("Applicant ID\t\tLast, First\t\tClass\t\tGrad Date\t\tMSC\n");
								while (rs.next()) {
									String applicant_id = rs.getString("applicant_id");
									String first_name = rs.getString("first_name");
						            String last_name = rs.getString("last_name");
						            String classyear = rs.getString("class");
						            String expected_grad_date = rs.getDate("expected_grad_date").toString();
						            String MSC = Integer.toString(rs.getInt("MSC"));
									listModel.addElement(applicant_id + "\t\t" + last_name +
				                               ", " + first_name + "\t\t" + classyear +
				                               "\t\t" + expected_grad_date + "\t\t" + MSC + "\n");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						}
						break;
					}
					case 1: {
						int num1 = searchComboBox2.getSelectedIndex();
						switch (num1) {
						case 0: {
							try {
								//applicant_id, first_name, last_name, graduation_date, age, current_job FROM Alumni
								rs = database.getInfoByID(1, Integer.parseInt(idTextField.getText()));
								listModel.clear();
								listModel.addElement("Applicant ID\t\tLast, First\t\tGrad Date\t\tAge\t\tCurrent Job\n");
								while (rs.next()) {
									String applicant_id = rs.getString("applicant_id");
									String first_name = rs.getString("first_name");
						            String last_name = rs.getString("last_name");
						            String grad_date = rs.getDate("graduation_date").toString();
						            String age = Integer.toString(rs.getInt("age"));
						            String curr_job = rs.getString("current_job");
									listModel.addElement(applicant_id + "\t\t" + last_name +
				                               ", " + first_name + "\t\t" + grad_date + "\t\t"
				                                + age + "\t\t" + curr_job + "\n");
								}
							} catch (SQLException e) {
							}
							break;
						}
						case 1: {
							try {
								//applicant_id, first_name, last_name, graduation_date, age, current_job
								rs = database.getInfoByName(1, firstTextField.getText(), lastTextField.getText());
								listModel.clear();
								listModel.addElement("Applicant ID\t\tLast, First\t\tGrad Date\t\tAge\t\tCurrent Job\n");
								while (rs.next()) {
									String applicant_id = rs.getString("applicant_id");
									String first_name = rs.getString("first_name");
						            String last_name = rs.getString("last_name");
						            String grad_date = rs.getDate("graduation_date").toString();
						            String age = Integer.toString(rs.getInt("age"));
						            String curr_job = rs.getString("current_job");
									listModel.addElement(applicant_id + "\t\t" + last_name +
				                               ", " + first_name + "\t\t" + grad_date + "\t\t"
				                                + age + "\t\t" + curr_job + "\n");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						}
						break;
					}
					case 2: {
						int num1 = searchComboBox3.getSelectedIndex();
						switch (num1) {
						case 0: {
							try {
								//position_id, title, salary, description, dept_name, company_name, accepted_major, accepted_gpa, apply_by_date
								rs = database.getInfoByCompany(compTextField.getText());
								listModel.clear();
								listModel.addElement("Position ID\t\tTitle\t\tSalary\t\tDescription\t\tDept\t\tCompany\t\tAccepted Major\t\tAccepted GPA\t\tApply by Date\n");
								while (rs.next()) {
									String position_id = rs.getString("position_id");
									String title = rs.getString("title");
						            String salary = rs.getString("salary");
						            String desc = rs.getString("description");
						            String dept = rs.getString("dept_name");
						            String company = rs.getString("name");
						            String major = rs.getString("accepted_major");
						            String gpa = rs.getString("accepted_gpa");
						            String apply_date = rs.getDate("apply_by_date").toString();
									listModel.addElement(position_id + "\t\t" + title +
				                               "\t\t " + salary + "\t\t" + desc + "\t\t"
				                                + dept + "\t\t" + company + "\t\t" + major + "\t\t" + gpa + "\t\t" + apply_date + "\n");
								}
							} catch (SQLException e) {

								e.printStackTrace();
							}
							break;
						}
						case 1: {
							try {
								//position_id, title, salary, description, dept_name, company_name, accepted_major, accepted_gpa, apply_by_date
								rs = database.getInfoByTitle(titleTextField.getText());
								listModel.clear();
								listModel.addElement("Position ID\t\tTitle\t\tSalary\t\tDescription\t\tDept\t\tCompany\t\tAccepted Major\t\tAccepted GPA\t\tApply by Date\n");
								while (rs.next()) {
									String position_id = rs.getString("position_id");
									String title = rs.getString("title");
						            String salary = rs.getString("salary");
						            String desc = rs.getString("description");
						            String dept = rs.getString("dept_name");
						            String company = rs.getString("name");
						            String major = rs.getString("accepted_major");
						            String gpa = rs.getString("accepted_gpa");
						            String apply_date = rs.getDate("apply_by_date").toString();
									listModel.addElement(position_id + "\t\t" + title +
				                               "\t\t " + salary + "\t\t" + desc + "\t\t"
				                                + dept + "\t\t" + company + "\t\t" + major + "\t\t" + gpa + "\t\t" + apply_date + "\n");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						}
						break;
					}
					}
				}
	        });
		}
		else {
			//user can only access jobs
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int num1 = searchComboBox4.getSelectedIndex();
					ResultSet rs;
					switch (num1) {
					case 0: {
						try {
							//position_id, title, salary, description, dept_name, company_name, accepted_major, accepted_gpa, apply_by_date
							rs = database.getInfoByCompany(compTextField.getText());
							listModel.clear();
							listModel.addElement("Position ID\t\tTitle\t\tSalary\t\tDescription\t\tDept\t\tCompany\t\tAccepted Major\t\tAccepted GPA\t\tApply by Date\n");
							while (rs.next()) {
								String position_id = rs.getString("position_id");
								String title = rs.getString("title");
					            String salary = rs.getString("salary");
					            String desc = rs.getString("description");
					            String dept = rs.getString("dept_name");
					            String company = rs.getString("name");
					            String major = rs.getString("accepted_major");
					            String gpa = rs.getString("accepted_gpa");
					            String apply_date = rs.getDate("apply_by_date").toString();
								listModel.addElement(position_id + "\t\t" + title +
			                               "\t\t " + salary + "\t\t" + desc + "\t\t"
			                                + dept + "\t\t" + company + "\t\t" + major + "\t\t" + gpa + "\t\t" + apply_date + "\n");
							}
						} catch (SQLException e) {
						}
						break;
					}
					case 1: {
						try {
							//position_id, title, salary, description, dept_name, company_name, accepted_major, accepted_gpa, apply_by_date
							rs = database.getInfoByTitle(titleTextField.getText());
							listModel.clear();
							listModel.addElement("Position ID\t\tTitle\t\tSalary\t\tDescription\t\tDept\t\tCompany\t\tAccepted Major\t\tAccepted GPA\t\tApply by Date\n");
							while (rs.next()) {
								String position_id = rs.getString("position_id");
								String title = rs.getString("title");
					            String salary = rs.getString("salary");
					            String desc = rs.getString("description");
					            String dept = rs.getString("dept_name");
					            String company = rs.getString("name");
					            String major = rs.getString("accepted_major");
					            String gpa = rs.getString("accepted_gpa");
					            String apply_date = rs.getDate("apply_by_date").toString();
								listModel.addElement(position_id + "\t\t" + title +
			                               "\t\t " + salary + "\t\t" + desc + "\t\t"
			                                + dept + "\t\t" + company + "\t\t" + major + "\t\t" + gpa + "\t\t" + apply_date + "\n");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					}
				}
	        });
		}
		
		setSize(900,500);
		setLocation(400, 400);
		setVisible(true);
	}
}
