package com.system.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.system.dao.MeetingRoomDao;
import com.system.model.MeetingRoom;
import com.system.util.DbUtil;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AddMeetingFrm extends JInternalFrame {
	private JTextField roomIdTxt;
	private JTextField roomNameTxt;
	private JTextField buildingNameTxt;
	private JTextField seatTxt;
	private JTextField buildingIdTxt;
	
	DbUtil dbUtil=new DbUtil();
	MeetingRoomDao meetingRoomDao=new MeetingRoomDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMeetingFrm frame = new AddMeetingFrm();
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
	public AddMeetingFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setTitle("\u6DFB\u52A0\u4F1A\u8BAE\u5BA4");
		setBounds(100, 100, 550, 395);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u8BAE\u5BA4\u53F7:");
		
		roomIdTxt = new JTextField();
		roomIdTxt.setColumns(10);
		
		roomNameTxt = new JTextField();
		roomNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F1A\u8BAE\u5BA4\u540D:");
		
		JLabel lblNewLabel_2 = new JLabel("\u6559\u5B66\u697C\u7F16\u53F7:");
		
		JLabel lblNewLabel_4 = new JLabel("\u6559\u5B66\u697C\u540D:");
		
		seatTxt = new JTextField();
		seatTxt.setColumns(10);
		
		buildingNameTxt = new JTextField();
		buildingNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5EA7\u4F4D\u6570:");
		
		buildingIdTxt = new JTextField();
		buildingIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addactionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buildingIdTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(roomIdTxt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(buildingNameTxt)))
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(roomNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(seatTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnNewButton)
										.addGap(18)
										.addComponent(btnNewButton_1))))
							.addGap(90))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(roomNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(roomIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(9)))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(buildingNameTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(seatTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(buildingIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(27))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	private void resetValueActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		roomIdTxt.setText("");
		buildingIdTxt.setText("");
		buildingNameTxt.setText("");
		roomNameTxt.setText("");
		seatTxt.setText("");
	}

	private void addactionPerformed(ActionEvent e) {
		int roomid=Integer.valueOf(roomIdTxt.getText());
		int buildingid=Integer.valueOf(buildingIdTxt.getText());
		String buildingName=buildingNameTxt.getText();
		String roomName=roomNameTxt.getText();
		int seat=Integer.valueOf(seatTxt.getText());
		MeetingRoom meetingRoom=new MeetingRoom(roomid,buildingid,buildingName,roomName,seat);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=meetingRoomDao.add(con, meetingRoom);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch(Exception e2) {
				e2.printStackTrace();
		    }
	    }
	}
}
