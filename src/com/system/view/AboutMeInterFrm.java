package com.system.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AboutMeInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutMeInterFrm frame = new AboutMeInterFrm();
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
	public AboutMeInterFrm() {
		setClosable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setIconifiable(true);
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setBounds(100, 100, 408, 309);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutMeInterFrm.class.getResource("/com/sun/deploy/uitoolkit/impl/fx/ui/resources/image/aboutjava6.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
