package com.system.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.system.dao.OrdersDao;
import com.system.dao.RoomFreeDao;
import com.system.dao.UserDao;
import com.system.model.FreeRoom;
import com.system.util.DateTimeUtil;
import com.system.util.DbUtil;
import com.system.util.StringUtil;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserOrderShowFrm extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil=new DbUtil();
	private OrdersDao ordersDao=new OrdersDao();
	private RoomFreeDao roomFreeDao=new RoomFreeDao();
	private JTextField beginTimeTxt;
	private JTextField endTimeTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOrderShowFrm frame = new UserOrderShowFrm();
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
	public UserOrderShowFrm() {
		setTitle("\u9884\u7EA6\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u6559\u5B66\u697C", "\u4F1A\u8BAE\u5BA4", "\u65E5\u671F", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u72B6\u6001"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u5F00\u59CB\u65F6\u95F4:");
		
		beginTimeTxt = new JTextField();
		beginTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7ED3\u675F\u65F6\u95F4:");
		
		endTimeTxt = new JTextField();
		endTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(beginTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(endTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(beginTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(endTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);
		
		fillTable(null, null);
}

	private void searchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String beginTime=this.beginTimeTxt.getText();
		String endTime=this.endTimeTxt.getText();
		if(!StringUtil.isEmpty(beginTime)) {
			if(!DateTimeUtil.isTime(beginTime)) {
				JOptionPane.showMessageDialog(null, "起始时间格式不正确");
				return;
			}
		}
		if(!StringUtil.isEmpty(endTime)) {
			if(!DateTimeUtil.isTime(endTime)) {
				JOptionPane.showMessageDialog(null, "结束时间格式不正确");
				return;
			}
		}
		fillTable(null, null);
	}

	private void resetValueActionPerformed(ActionEvent arg0) {
		beginTimeTxt.setText("");
		endTimeTxt.setText("");
		fillTable(null, null);
	}

private void fillTable(String beginDate,String endDate) {
	DefaultTableModel dtm=(DefaultTableModel)table.getModel();
	dtm.setRowCount(0);
	Connection con=null;
	try {
		con=dbUtil.getCon();
		ResultSet rs=ordersDao.show(con, LogOnFrm.user_id);
		while(rs.next()) {
			int freetime_id=rs.getInt("freetime_id");
			ResultSet rs1=roomFreeDao.select(con, freetime_id);
			int flag1=1,flag2=1;
		    Vector vector=new Vector<>();
		    vector.add(rs.getInt("orders_id"));
		    vector.add(rs1.getString("building_name"));
		    vector.add(rs1.getString("room_name"));
		    vector.add(rs1.getDate("date"));
		    if(!StringUtil.isEmpty(beginDate)) {
		    	if(rs1.getTime("begin_time").compareTo(DateTimeUtil.StringtoTime(beginDate))<0) {
		    		flag1=0;
		    	}
		    }
		    if(!StringUtil.isEmpty(endDate)) {
		    	if(rs1.getTime("end_time").compareTo(DateTimeUtil.StringtoTime(endDate))>0) {
		    		flag2=0;
		    	}
		    }
		    vector.add(rs1.getTime("begin_time"));
		    vector.add(rs1.getTime("end_time"));
		    //0:预约中，1：已到，-1：缺席
		    if(rs1.getInt("status")==0) {
		    	vector.add("履约中");
		    }else if(rs1.getInt("status")==1){
		    	vector.add("已履约");
		    }else {
		    	vector.add("缺勤");
		    }
		    if(flag1==1&&flag2==1) {
		    	dtm.addRow(vector);
		    }
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