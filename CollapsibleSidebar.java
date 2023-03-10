package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CollapsibleSidebar extends JFrame implements ActionListener {
	private String appName;
	private JButton toggleButton;
	private JLabel titleLabel;
	private JPanel sidebar;
	private JTabbedPane mainArea;
	private JSplitPane splitPane;

	public void setTitleLabel(String title){
		appName = title;
		Font font = new Font("Calibri", Font.PLAIN, 20);
		titleLabel.setFont(font);
		titleLabel.setText(appName);
	}

	public CollapsibleSidebar() {
		super("Duka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Create the toolbar with the toggle button
		JToolBar toolbar = new JToolBar();

		toggleButton = new JButton("X");
		titleLabel = new JLabel();
		this.setTitleLabel("Duka");

		toggleButton.addActionListener(this);
		
		toolbar.add(toggleButton);
		toolbar.add(titleLabel);
		add(toolbar, BorderLayout.NORTH);

		// Create the sidebar
		sidebar = new Sidebar();
		sidebar.setPreferredSize(new Dimension(200, 0));
		sidebar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		add(sidebar, BorderLayout.WEST);

		// Create the main area
		mainArea = new MainArea();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, mainArea);
		add(splitPane, BorderLayout.CENTER);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == toggleButton) 
		{
			if (sidebar.isVisible()) 
			{
				toggleButton.setText("_>");
				sidebar.setVisible(false);
			} 
			else 
			{
				toggleButton.setText("X");
				add(sidebar, BorderLayout.WEST);
				sidebar.setVisible(true);
			}
		}
	}
}