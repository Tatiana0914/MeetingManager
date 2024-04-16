package com.system.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class UserFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrm frame = new UserFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserFrm() {
		setTitle("\u4F1A\u8BAE\u5BA4\u9884\u7EA6\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4F1A\u8BAE\u5BA4");
		mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 30));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9884\u7EA6\u4F1A\u8BAE\u5BA4");
		mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 25));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MeetingBook meetingBook=new MeetingBook();
				meetingBook.setVisible(true);
				table.add(meetingBook);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9884\u7EA6\u60C5\u51B5");
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 25));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOrderShowFrm userOrderShowFrm=new UserOrderShowFrm();
				userOrderShowFrm.setVisible(true);
				table.add(userOrderShowFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		mnNewMenu_1.setFont(new Font("宋体", Font.PLAIN, 30));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.PLAIN, 25));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				UserInterFrm userInterFrm=new UserInterFrm();
				userInterFrm.setVisible(true);
				table.add(userInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(179, 255, 102));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.WEST);
		table.setLayout(new BorderLayout(0, 0));
	}

}
