package PhotoFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;







public class myFrame extends JDialog {


	public JButton btnNewButton;		//断开
	public JButton btnNewButton_1;		//连接
	public JButton btnNewButton_2;		//模拟触发
	public JButton btnNewButton_3;		//发送抬杆命令
	public JButton btnNewButton_4;		//抓拍命令
	public JButton btnNewButton_5;		//发送485
	public JButton button_1;			//搜索设备
	public JButton button;				//更新时间
	public JButton btnip;				//修改IP地址
	public JEditorPane editorPane;		//IP1
	public JEditorPane editorPane_1;	//IP2
	public JEditorPane editorPane_2;	//设备编号
	public JEditorPane editorPane_3; 	//识别结果1
	public JEditorPane editorPane_5;	//待更改的IP地址
	public JEditorPane editorPane_6; // 识别结果2
	public PhotoFrame.JpegPanel panel;       // 相机1
	public PhotoFrame.JpegPanel panel_1;    // 相机2
	public PhotoFrame.JpegPanel panel_2;    // 车牌1
	public PhotoFrame.JpegPanel panel_3;    // 车牌2
	public JList<String> listinfo;     //显示信息
	public DefaultListModel<String> listModel;


	public JRadioButton rdbtnNewRadioButton;//jpeg


	public synchronized void jpegShow(PhotoFrame.JpegPanel jPanel, byte[] Image, int itype)
	{
		if(jPanel != null)
		{
			jPanel.RefreshImage(Image, itype);
			jPanel.repaint();
		}
	}

	/**
	 * Create the dialog.
	 */
	public myFrame() {

		//setBounds(100, 100, 647, 538);
		setBounds(100, 100, 858, 699);
		getContentPane().setLayout(null);
		setTitle("KHTSample(java)");

		panel = new PhotoFrame.JpegPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		//panel.setBounds(10, 10, 300, 237);
		panel.setBounds(29, 26, 380, 310);

		getContentPane().add(panel);

		panel_1 = new PhotoFrame.JpegPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		//panel_1.setBounds(320, 10, 300, 237);
		panel_1.setBounds(437, 26, 380, 310);
		getContentPane().add(panel_1);

		panel_2 = new PhotoFrame.JpegPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.LIGHT_GRAY);
		//panel_2.setBounds(10, 257, 300, 237);
		panel_2.setBounds(37, 396, 165, 45);
		getContentPane().add(panel_2);

		panel_3 = new PhotoFrame.JpegPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(449, 398, 165, 45);
		getContentPane().add(panel_3);


		editorPane = new JEditorPane();
		editorPane.setBackground(Color.LIGHT_GRAY);
		editorPane.setForeground(Color.BLACK);
		editorPane.setText("192.168.2.20");
		//editorPane.setBounds(320, 257, 92, 21);
		editorPane.setBounds(146, 349, 95, 23);
		getContentPane().add(editorPane);


		editorPane_1 = new JEditorPane();
		editorPane_1.setText("192.168.2.27");
		editorPane_1.setForeground(Color.BLACK);
		editorPane_1.setBackground(Color.LIGHT_GRAY);
		//editorPane_1.setBounds(422, 257, 92, 21);
		editorPane_1.setBounds(572, 353, 100, 23);
		getContentPane().add(editorPane_1);


		listModel = new DefaultListModel();
		listModel.addElement("log here...");

		listinfo = new JList(listModel);
		//JList list = new JList();
		//list.setBounds(616, 373, -305, 121);
		listinfo.setBounds(12, 477, 513, 172);
		getContentPane().add(listinfo);


		btnNewButton = new JButton("\u65AD\u5F00");  // duan kai
		//btnNewButton.setBounds(422, 303, 93, 23);
		btnNewButton.setBounds(424, 342, 60, 45);
		getContentPane().add(btnNewButton);


		btnNewButton_1 = new JButton("\u8FDE\u63A5");  // lian jie
		//btnNewButton_1.setBounds(320, 303, 93, 23);
		btnNewButton_1.setBounds(360, 342, 60, 45);
		getContentPane().add(btnNewButton_1);


		btnNewButton_2 = new JButton("\u6A21\u62DF\u89E6\u53D1"); // monichufa
		//btnNewButton_2.setBounds(527, 303, 93, 23);
		btnNewButton_2.setBounds(563, 489, 93, 23);
		getContentPane().add(btnNewButton_2);

		btnNewButton_3 = new JButton("\u62AC\u6746"); // tai gan
		btnNewButton_3.setBounds(563, 529, 93, 23);
		getContentPane().add(btnNewButton_3);


		btnNewButton_4 = new JButton("\u6293\u62CD"); // zhua pai
		//btnNewButton_4.setBounds(421, 361, 93, 23);
		btnNewButton_4.setBounds(701, 489, 93, 23);
		getContentPane().add(btnNewButton_4);

		btnNewButton_5 = new JButton("\u53D1\u9001485");// fasong485
		btnNewButton_5.setBounds(701, 529, 93, 23);
		getContentPane().add(btnNewButton_5);

//		rdbtnNewRadioButton = new JRadioButton("JPEG\u5F00\u5173"); // JPEG kaiguan
//		rdbtnNewRadioButton.setToolTipText("");
//		rdbtnNewRadioButton.setBounds(528, 255, 92, 23);
//		getContentPane().add(rdbtnNewRadioButton);

		button = new JButton("\u66F4\u65B0\u65F6\u95F4");// gengxinshijian
		button.setBounds(701, 569, 93, 23);
		getContentPane().add(button);

		button_1 = new JButton("\u641C\u7D22\u8BBE\u5907"); // sousuoshebei
		button_1.setBounds(563, 569, 93, 23);
		getContentPane().add(button_1);

//		btnip = new JButton("\u4FEE\u6539IP"); // xiugai IP
//		btnip.setBounds(422, 424, 93, 23);
//		getContentPane().add(btnip);

//		editorPane_2 = new JEditorPane();
//		editorPane_2.setText("\u8BF7\u8F93\u5165\u8BBE\u5907\u7F16\u53F7"); // qingshurushebeibianhao
//		editorPane_2.setForeground(Color.BLACK);
//		editorPane_2.setBackground(Color.LIGHT_GRAY);
//		editorPane_2.setBounds(422, 473, 92, 21);
//		getContentPane().add(editorPane_2);

		editorPane_3 = new JEditorPane();
		editorPane_3.setFont(new Font("宋体", Font.BOLD, 22));
		editorPane_3.setText("\u65E0\u8F66\u724C");// shibiejieguo1
		editorPane_3.setForeground(Color.BLACK);
		editorPane_3.setBackground(Color.WHITE);
		editorPane_3.setBounds(225, 399, 145, 41);
		getContentPane().add(editorPane_3);


		editorPane_6 = new JEditorPane();
		editorPane_6.setFont(new Font("宋体", Font.BOLD, 22));
		editorPane_6.setText("\u65E0\u8F66\u724C");// shibiejieguo2
		editorPane_6.setForeground(Color.BLACK);
		editorPane_6.setBackground(Color.WHITE);
		//editorPane_3.setBounds(320, 473, 92, 21);
		editorPane_6.setBounds(646, 401, 145, 41);
		getContentPane().add(editorPane_6);


//		editorPane_5 = new JEditorPane();
//		editorPane_5.setText("192.168.0.206");
//		editorPane_5.setForeground(Color.BLACK);
//		editorPane_5.setBackground(Color.LIGHT_GRAY);
//		editorPane_5.setBounds(528, 473, 92, 21);
//		getContentPane().add(editorPane_5);
	}
}
