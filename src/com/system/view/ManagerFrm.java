package com.system.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class ManagerFrm extends JFrame {
	
	private JDesktopPane table =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrm frame = new ManagerFrm();
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
	public ManagerFrm() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setBackground(new Color(128, 255, 255));
		setBackground(new Color(166, 255, 255));
		setTitle("\u4F1A\u8BAE\u5BA4\u9884\u7EA6\u7CFB\u7EDF\u7BA1\u7406\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1293, 741);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u529F\u80FD\u9009\u62E9");
		mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 28));
		mnNewMenu.setIcon(new ImageIcon(ManagerFrm.class.getResource("/com/sun/java/swing/plaf/motif/icons/TreeClosed.gif")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u4F1A\u8BAE\u5BA4\u7BA1\u7406");
		mnNewMenu_2.setFont(new Font("宋体", Font.PLAIN, 20));
		mnNewMenu_2.setIcon(new ImageIcon(ManagerFrm.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Paste-Black.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6DFB\u52A0\u4F1A\u8BAE\u5BA4");
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMeetingFrm meetingInfoFrm=new AddMeetingFrm();
				meetingInfoFrm.setVisible(true);
				table.add(meetingInfoFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu_3.setFont(new Font("宋体", Font.PLAIN, 20));
		mnNewMenu_3.setIcon(new ImageIcon(ManagerFrm.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u67E5\u770B\u6240\u6709\u7528\u6237");
		mntmNewMenuItem_6.setFont(new Font("宋体", Font.PLAIN, 16));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUserFrm listUserFrm=new ListUserFrm();
				listUserFrm.setVisible(true);
				table.add(listUserFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u6DFB\u52A0\u7528\u6237");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddUserInterFrm addUserInterFrm=new AddUserInterFrm();
				addUserInterFrm.setVisible(true);
				table.add(addUserInterFrm);
			}
		});
		mntmNewMenuItem_10.setFont(new Font("宋体", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5B89\u5168\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_5.setFont(new Font("宋体", Font.PLAIN, 20));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(ManagerFrm.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_1.setFont(new Font("宋体", Font.PLAIN, 28));
		mnNewMenu_1.setIcon(new ImageIcon(ManagerFrm.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaVolumeThumb.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E0D\u8981\u6765\u627E\u6211");
		mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 20));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutMeInterFrm aboutMeInterFrm=new AboutMeInterFrm();
				aboutMeInterFrm.setVisible(true);
				table.add(aboutMeInterFrm);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(ManagerFrm.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaTimeThumb.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		table = new JDesktopPane();
		
		table.setBackground(new Color(128, 255, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		table.setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(groupLayout);
	}
}
