package com.system.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.system.dao.UserDao;
import com.system.model.User;
import com.system.util.DbUtil;

import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AddUserInterFrm extends JInternalFrame {
	private JTextField userIdTxt;
	private JTextField userNameTxt;
	
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserInterFrm frame = new AddUserInterFrm();
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
	public AddUserInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u7528\u6237\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel_2 = new JLabel("(!\u521D\u59CB\u5BC6\u78016\u4E2A8!)");
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetactionPerformed(arg0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel_2)
							.addGap(87)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblNewLabel_2)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u7F16\u53F7:");
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D:");
		
		userIdTxt = new JTextField();
		userIdTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userNameTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetactionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		userIdTxt.setText("");
		userNameTxt.setText("");
	}

	private void addActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String userid=userIdTxt.getText();
		String username=userNameTxt.getText();
		String password="6个8";
		User user=new User(userid,username,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=userDao.addUser(con, user);
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
