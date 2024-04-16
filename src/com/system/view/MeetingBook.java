package com.system.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.system.dao.OrdersDao;
import com.system.dao.RoomFreeDao;
import com.system.dao.FreeTimeDao;
import com.system.model.FreeRoom;
import com.system.model.Orders;
import com.system.util.DateChooser;
import com.system.util.DateTimeUtil;
import com.system.util.DbUtil;
import com.system.util.StringUtil;
import javax.swing.border.EtchedBorder;

public class MeetingBook extends JInternalFrame {
	private JTable roomFreeTable;

	private DbUtil dbUtil=new DbUtil();
	private RoomFreeDao roomFreeDao=new RoomFreeDao();
	private OrdersDao ordersDao=new OrdersDao();
	private FreeTimeDao freeTimeDao=new FreeTimeDao();
	
	private JTextField beginTimeTxt;
	private JTextField endTimeTxt;
	private JTextField buildingTxt;
	private JTextField DateTxt;
	
	private JLabel FreeTimeId;
	private JLabel Date;
	private JLabel BeginTime;
	private JLabel EndTime;
	private JLabel Building;
	private JLabel Room;
	private JLabel Seat;
	private JLabel Orders;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeetingBook frame = new MeetingBook();
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
	public MeetingBook() {
		setResizable(true);
		setMaximizable(true);
		setTitle("\u4F1A\u8BAE\u5BA4\u9884\u7EA6");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 792, 601);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u9009\u4E2D\u4F1A\u8BAE\u5BA4\u65F6\u95F4\u6BB5\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setToolTipText("");
		
		JButton btnNewButton_3 = new JButton("\u9884\u7EA6");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderactionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
					.addGap(69))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(620, Short.MAX_VALUE)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_3)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		FreeTimeId = new JLabel("\u7F16\u53F7:");
		FreeTimeId.setFont(new Font("宋体", Font.PLAIN, 12));
		
		Date = new JLabel("\u65E5\u671F\uFF1A");
		
		BeginTime = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		
		EndTime = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		
		Building = new JLabel("\u6559\u5B66\u697C\uFF1A");
		
		Room = new JLabel("\u4F1A\u8BAE\u5BA4\uFF1A");
		
		Seat = new JLabel("\u53EF\u7528\u5EA7\u4F4D\uFF1A");
		
		Orders = new JLabel("\u662F\u5426\u53EF\u9884\u7EA6\uFF1A");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(FreeTimeId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Building, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(Date)
						.addComponent(Room))
					.addGap(80)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(Seat)
						.addComponent(BeginTime))
					.addGap(98)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(EndTime)
						.addComponent(Orders))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(FreeTimeId)
						.addComponent(EndTime)
						.addComponent(Date)
						.addComponent(BeginTime))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(Orders)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(Building)
							.addComponent(Room)
							.addComponent(Seat)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		JButton btnNewButton_2 = new JButton("\u9009\u62E9\u65E5\u671F:");
		
		DateTxt = new JTextField(" \u586B\u5165\u65E5\u671F");
		DateTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F00\u59CB\u65F6\u95F4:");
		
		beginTimeTxt = new JTextField();
		beginTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7ED3\u675F\u65F6\u95F4:");
		
		endTimeTxt = new JTextField();
		endTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6559\u5B66\u697C:");
		
		buildingTxt = new JTextField();
		buildingTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(DateTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(beginTimeTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(endTimeTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buildingTxt, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(4))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(24))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2)
							.addComponent(DateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)
							.addComponent(beginTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(endTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buildingTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_3)))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectTimeActionPerformed(arg0);
			}
		});
		
		roomFreeTable = new JTable();
		roomFreeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				roomFreemousePressed(arg0);
			}
		});
		roomFreeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u65E5\u671F", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u4F1A\u8BAE\u5BA4\u53F7", "\u6559\u5B66\u697C", "\u53EF\u7528\u5EA7\u4F4D", "\u662F\u5426\u53EF\u9884\u7EA6"
			}
		));
		roomFreeTable.getColumnModel().getColumn(7).setPreferredWidth(64);
		scrollPane.setViewportView(roomFreeTable);
		getContentPane().setLayout(groupLayout);
		
		fillroomFreeTable(new FreeRoom());
	}

	/**
	 * 预约事件
	 * @param e
	 */
	private void orderactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(FreeTimeId.equals("编号")) {
			JOptionPane.showMessageDialog(null, "未选中会议室");
			return;
		}
		int row=roomFreeTable.getSelectedRow();
		if(roomFreeTable.getValueAt(row, 7).equals("否")) {
			JOptionPane.showMessageDialog(null, "会议室已被预约");
			return;
		}
		String freetime_id=FreeTimeId.getText().substring(3);
		FreeRoom freeRoom=new FreeRoom();
		freeRoom.setFreetime_id(Integer.valueOf(freetime_id));
		Orders orders=new Orders();
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs1=ordersDao.show(con, LogOnFrm.user_id);
			Set<Integer> set=new HashSet<>();//用来存已经预约过的user_id
			int flag=0;
			while(rs1.next()) {
				Date dNow=new Date();
				Date dBefore=new Date();
				Calendar calendar=Calendar.getInstance();
				calendar.setTime(dNow);
				calendar.add(Calendar.DAY_OF_WEEK, -7);
				dBefore=calendar.getTime();
				//这样得到的dNow就是今天，dBefore就是七天前
				set.add(rs1.getInt("freetime_id"));
				if(rs1.getInt("status")==-1) {//即缺席
					ResultSet lastrs=roomFreeDao.select(con, rs1.getInt("freetime_id"));
					Date date=null;
					if(lastrs.next()) {
						date=lastrs.getDate("Date");
					}
					if(date.compareTo(dBefore)>=0&&date.compareTo(dNow)<=0) {
						flag++;
						if(flag==1) {
							dNow=date;
							calendar=Calendar.getInstance();
							calendar.setTime(dNow);
							calendar.add(Calendar.DAY_OF_WEEK, -7);
							dBefore=calendar.getTime();
						}
					}
				}
				if(flag>=3) {
					JOptionPane.showMessageDialog(null, "本周违约次数超过三次，无法预约");
					return;
				}
				
				ResultSet rs=roomFreeDao.showFree(con, freeRoom);
				if(rs.next()) {
					if(set.contains(rs.getInt("freetime_id"))) {
						JOptionPane.showMessageDialog(null, "已预约过该时段会议室");
						return;
					}
					orders.setFreetime_id(rs.getInt("freetime_id"));
					orders.setOpentime_id(rs.getInt("opentime_id"));
					orders.setRoom_id(rs.getInt("room_id"));
					orders.setUsers_id(LogOnFrm.user_id);
					orders.setStatus(0);
				}
				int p=freeTimeDao.order(con,freeRoom.getFreetime_id());
				if(p==1) {
//					int n=ordersDao.add(con, orders);
//					if(n==1) {
//						JOptionPane.showMessageDialog(null, "预约成功");
//					}else {
//						freeTimeDao.resetorder(con, orders.getFreetime_id());
//						JOptionPane.showMessageDialog(null, "预约失败");
//					}
					JOptionPane.showMessageDialog(null, "预约成功");
				}else {
					JOptionPane.showMessageDialog(null, "预约失败");
				}
			 }
		}catch(Exception e1) {
				e1.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				}catch(Exception e2) {
					e2.printStackTrace();
			}
		}
	}

	/**
	 * 表格点击事件处理
	 * @param arg0
	 */
	private void roomFreemousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=roomFreeTable.getSelectedRow();
		FreeTimeId.setText("编号:"+roomFreeTable.getValueAt(row, 0).toString());
		Date.setText("日期:"+roomFreeTable.getValueAt(row, 1).toString());
		BeginTime.setText("开始时间:"+roomFreeTable.getValueAt(row, 2).toString());
		EndTime.setText("结束时间:"+roomFreeTable.getValueAt(row, 3).toString());
		Building.setText("教学楼:"+roomFreeTable.getValueAt(row, 4).toString());
		Room.setText("会议室:"+roomFreeTable.getValueAt(row, 5).toString());
		Seat.setText("座位:"+roomFreeTable.getValueAt(row, 6).toString());
		Orders.setText("是否可预约:"+roomFreeTable.getValueAt(row, 7).toString());
	}

	private void searchActionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String date=DateTxt.getText();
		String beginTime=beginTimeTxt.getText();
		String endTime=endTimeTxt.getText();
		String building=buildingTxt.getText();
		FreeRoom freeRoom=new FreeRoom();
		if(!StringUtil.isEmpty(date)&&!date.equals("单击选择日期")) {
			if(DateTimeUtil.isDate(date)) {
				freeRoom.setDate(DateTimeUtil.StringtoDate(date));
			}else {
				JOptionPane.showMessageDialog(null, "日期格式不正确");
				return;
			}
		}
		if(!StringUtil.isEmpty(beginTime)) {
			if(DateTimeUtil.isTime(beginTime)) {
				freeRoom.setBegin_time(DateTimeUtil.StringtoTime(beginTime));
			}else {
				JOptionPane.showMessageDialog(null, "开始时间格式不正确");
				return;
			}
		}
		if(!StringUtil.isEmpty(endTime)) {
			if(DateTimeUtil.isTime(endTime)) {
				freeRoom.setBegin_time(DateTimeUtil.StringtoTime(endTime));
			}else {
				JOptionPane.showMessageDialog(null, "结束时间格式不正确");
				return;
			}
		}
		if(!StringUtil.isEmpty(building)) {
			freeRoom.setBuilding_name(building);
		}
		this.fillroomFreeTable(freeRoom);
	}

	private void selectTimeActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt1 = new JTextField("单击选择日期");
		txt1.setBounds(10, 5, 200, 30);
 
		// 定义日历控件面板类
		DateChooser p = new DateChooser(txt1, "yyyy-MM-dd");
		p.initCalendarPanel();
 
		JFrame f = new JFrame("日期选择器");
		f.getContentPane().setLayout(null);
		p.add(txt1);
		f.getContentPane().add(p);
		f.getContentPane().add(txt1);
		f.setSize(480, 450);
		f.setBackground(Color.WHITE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void resetValueActionPerformed(ActionEvent arg0) {
		DateTxt.setText("单击选择日期");
		beginTimeTxt.setText("");
		endTimeTxt.setText("");
		buildingTxt.setText("");
		fillroomFreeTable(new FreeRoom());
	}

	/**
	 * 初始化表格
	 * @param freeRoom
	 */
	private void fillroomFreeTable(FreeRoom freeRoom) {
		DefaultTableModel dtm=(DefaultTableModel)roomFreeTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			ResultSet rs=roomFreeDao.showFree(con, freeRoom);
			ResultSet rs1=ordersDao.show(con, LogOnFrm.user_id);
			Set<Integer> set=new HashSet<>();
			while(rs1.next()) {
				set.add(rs1.getInt("freetime_id"));
			}
			while(rs.next()) {
				Vector vector=new Vector<>();
				vector.add(rs.getInt("freetime_id"));
				vector.add(rs.getDate("date"));
				vector.add(rs.getTime("begin_time"));
				vector.add(rs.getTime("end_time"));
				vector.add(rs.getString("building_name"));
				vector.add(rs.getString("room_name"));
				vector.add(rs.getInt("seat"));
				if(!set.contains(rs.getInt("freetime_id"))&&rs.getInt("order_flag")==1) {
					vector.add("是");
				}else {
					vector.add("否");
				}
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
