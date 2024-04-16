package com.system.view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.system.dao.UserDao;
import com.system.util.DbUtil;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ListUserFrm extends JInternalFrame {
	private JTable UsersTable;
	private DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	private JLabel UserId;
	private JLabel UserName;
	private JLabel Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUserFrm frame = new ListUserFrm();
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
	public ListUserFrm() {
		setTitle("EveryBody\u2018s Information");
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 474, 394);
		
		JScrollPane scrollPane = new JScrollPane();
		
		UsersTable = new JTable();
		UsersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				listUserMousePressed(arg0);
			}
		});
		UsersTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u7F16\u53F7", "\u7528\u6237\u540D", "\u7528\u6237\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(UsersTable);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u9009\u4E2D\u7528\u6237\u4FE1\u606F\u680F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(47))
		);
		
		UserId = new JLabel("\u7528\u6237\u7F16\u53F7:");
		
		UserName = new JLabel("\u7528\u6237\u540D:");
		
		Password = new JLabel("\u7528\u6237\u5BC6\u7801:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(UserId)
						.addComponent(UserName)
						.addComponent(Password))
					.addContainerGap(286, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(UserId)
					.addGap(18)
					.addComponent(UserName)
					.addGap(18)
					.addComponent(Password)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		fillroomFreeTable();
	}
	
	private void listUserMousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=UsersTable.getSelectedRow();
		UserId.setText("用户编号:"+UsersTable.getValueAt(row,0).toString());
		UserName.setText("用户名:"+UsersTable.getValueAt(row, 1).toString());
		Password.setText("密码:"+UsersTable.getValueAt(row, 2).toString());
	}

	private void fillroomFreeTable() {
		DefaultTableModel dtm=(DefaultTableModel)UsersTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			ResultSet rs=userDao.listUser(con);
			
			while(rs.next()) {
				Vector vector=new Vector<>();
				vector.add(rs.getString("sid"));
				vector.add(rs.getString("name"));
				vector.add(rs.getString("password"));
				dtm.addRow(vector);
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
