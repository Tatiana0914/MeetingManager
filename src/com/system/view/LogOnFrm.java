package com.system.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;
import com.system.dao.ManagerDao;
import com.system.dao.UserDao;
import com.system.model.Manager;
import com.system.model.User;
import com.system.util.DbUtil;
import com.system.util.StringUtil;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField NameTxt;
	private JPasswordField passwordTxt;
	private JComboBox userType;
	private UserDao userDao=new UserDao();
	private ManagerDao managerDao=new ManagerDao();
	private DbUtil dbUtil=new DbUtil();
    public static String user_id=null;
	public static String manager_name=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		/*
		 * 改变系统默认字体
		 */
		Font font =new Font("Dialog",Font.PLAIN,12);
		java.util.Enumeration keys=UIManager.getDefaults().keys();
		while(keys.hasMoreElements()) {
			Object key=keys.nextElement();
			Object value=UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		
		setTitle("\u4F1A\u8BAE\u5BA4\u9884\u7EA6\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u8BAE\u5BA4\u9884\u7EA6\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 28));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-fewer-details@2x.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		
		NameTxt = new JTextField();
		NameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E\r\n");
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 19));
		
		userType = new JComboBox();
		userType.setFont(new Font("宋体", Font.PLAIN, 18));
		userType.setModel(new DefaultComboBoxModel(new String[] {"\u7528\u6237", "\u7BA1\u7406\u5458"}));
		userType.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u5F55\u7C7B\u578B:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, Alignment.TRAILING))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(NameTxt, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
										.addComponent(passwordTxt)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(userType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))))
					.addGap(119))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(NameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(userType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置登录界面居中；
		this.setLocationRelativeTo(null);
	}

	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//获取界面上的用户名，密码
		String Name=this.NameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(Name)) {
			JOptionPane.showMessageDialog(null,"账号不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null,"密码不能为空");
			return;
		}
		
		String usertype=userType.getSelectedItem().toString();
		
		if(usertype.equals("用户")) {
			User user=new User(Name,password);
			
			Connection con=null;
			try {
				con=dbUtil.getCon();
				User curreUser=userDao.login(con, user);
				if(curreUser!=null) {
					user_id=Name;
					dispose();
					new UserFrm().setVisible(true);
					}else {
					JOptionPane.showMessageDialog(null,"账号或密码错误");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}else{
			Manager managers=new Manager(Name,password);
			Connection con=null;
			try {
				con=dbUtil.getCon();
				Manager curreManer=managerDao.login(con, managers);
				if(curreManer!=null) {
					manager_name=Name;
					dispose();
					new ManagerFrm().setVisible(true);
					}else {
					JOptionPane.showMessageDialog(null,"用户名或密码错误");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.NameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
