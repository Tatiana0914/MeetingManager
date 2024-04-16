package com.system.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.cj.exceptions.RSAException;
import com.system.dao.UserDao;
import com.system.model.User;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterFrm extends JInternalFrame {
	private JTextField userSidTxt;
	private JTextField userNameTxt;
	private JTextField userpasswordTxt;
	
	private UserDao userDao=new UserDao();
	private DbUtil dbUtil=new DbUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterFrm frame = new UserInterFrm();
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
	public UserInterFrm() {
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		setBounds(100, 100, 663, 427);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7:");
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D:");
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801:");
		
		userSidTxt = new JTextField();
		userSidTxt.setEditable(false);
		userSidTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		userpasswordTxt = new JTextField();
		userpasswordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(userpasswordTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userSidTxt, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
							.addGap(86)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(288)
							.addComponent(btnNewButton)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userSidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userpasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnNewButton)
					.addContainerGap(178, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		fillpane();
	}
	
	/**
	 * 修改用户名和密码
	 * @param e
	 */
	protected void updateActionPerformed(ActionEvent e) {
		String sid=userSidTxt.getText();
		String password=userpasswordTxt.getText();
		String name=userNameTxt.getText();
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
		}
		
		updateInfo(sid,name,password);
	}

	private void updateInfo(String sid, String name, String password) {
		User user=new User();
		user.setSid(sid);
		user.setName(name);
		user.setPassword(password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int flag=userDao.update(con, user);
			if(flag==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
			}else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 展示学生信息
	 */
	private void fillpane() {
		User user=new User();
		user.setSid(LogOnFrm.user_id);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet resultSet=userDao.list(con,user);
			if(resultSet.next()) {
				userSidTxt.setText(resultSet.getString("sid"));
				userNameTxt.setText(resultSet.getString("name"));
				userpasswordTxt.setText(resultSet.getString("password"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
