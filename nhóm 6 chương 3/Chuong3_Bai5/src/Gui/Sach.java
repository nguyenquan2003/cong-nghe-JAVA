package Gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.LoaiSachDAO;
import Dao.SachDAO;
import Pojo.SachPOJO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Sach extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtTieuDe;
	private JTextField txtTacGia;
	private JTextField txtNXB;
	private JTextField txtTheLoai;
	private JTextField txtMoTa;
	private JTable tblSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sach frame = new Sach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void HienThi() {
		ArrayList<SachPOJO> ds = SachDAO.LayDSSach();
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã sách");
		dtm.addColumn("Tên sách");
		dtm.addColumn("Tác giả");
		dtm.addColumn("Năm xuất bản");
		dtm.addColumn("Mã loại");
		dtm.addColumn("Mô tả");
		dtm.setNumRows(ds.size());
		
		for (int i = 0; i < ds.size(); i++)
		{
			SachPOJO s = ds.get(i);
			dtm.setValueAt(s.getiID(), i, 0);
			dtm.setValueAt(s.getStrTen(), i, 1);
			dtm.setValueAt(s.getStrTacGia(), i, 2);
			dtm.setValueAt(s.getNXB(), i, 3);
			dtm.setValueAt(s.getiLSID(), i, 4);
			dtm.setValueAt(s.getStrMoTa(), i, 5);		
		}
		this.tblSach.setModel(dtm);
	}
	
	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
	    String Ten = txtTieuDe.getText();
	    String TacGia = txtTacGia.getText();
        int NXB = Integer.parseInt(txtNXB.getText());
        int iLSID = Integer.parseInt(txtTheLoai.getText());
	    String MoTa = txtMoTa.getText();

	    SachDAO S = new SachDAO();
	    if (S.ThemSach(Ten, TacGia, NXB, iLSID, MoTa)) {
	        JOptionPane.showMessageDialog(this, "Thêm thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Thêm thất bại");
	    }
	}
	
	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
	    int selectedRow = tblSach.getSelectedRow();
	    int id = (Integer)tblSach.getValueAt(selectedRow, 0);

	    SachDAO S = new SachDAO();
	    if (S.XoaSach(id)) {
	        JOptionPane.showMessageDialog(this, "Xoá thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Xoá thất bại");
	    }
	}
	
	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
		String Ten = txtTieuDe.getText();
	    String TacGia = txtTacGia.getText();
        int NXB = Integer.parseInt(txtNXB.getText());
        int iLSID = Integer.parseInt(txtTheLoai.getText());
	    String MoTa = txtMoTa.getText();
	    int selectedRow = tblSach.getSelectedRow();
	    int id = (Integer)tblSach.getValueAt(selectedRow, 0);

	    SachDAO S = new SachDAO();
	    if (S.SuaSach(Ten, TacGia, NXB, iLSID, MoTa, id)) {
	        JOptionPane.showMessageDialog(this, "Sửa thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Sửa thất bại");
	    }
	}
	
	private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {
		if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát ?") == JOptionPane.YES_NO_OPTION) {
			System.exit(0);		
		}		
		return;
	}

	/**
	 * Create the frame.
	 */
	public Sach() {
		setTitle("Sách");
		setBounds(100, 100, 581, 530);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 269, 434, 1);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin lo\u1EA1i s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Tên sách:");
		lblNewLabel.setBounds(10, 24, 63, 13);
		panel.add(lblNewLabel);
		
		JLabel lblMtT = new JLabel("Môt tả:");
		lblMtT.setBounds(10, 47, 63, 13);
		panel.add(lblMtT);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(68, 21, 296, 19);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(68, 44, 296, 19);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(76, 269, 414, 154);
		getContentPane().add(panel_1);
		
		JLabel lblTiu = new JLabel("Tiêu đề:");
		lblTiu.setBounds(10, 24, 63, 13);
		panel_1.add(lblTiu);
		
		JLabel lblTcGi = new JLabel("Tác giả:");
		lblTcGi.setBounds(10, 47, 63, 13);
		panel_1.add(lblTcGi);
		
		txtTieuDe = new JTextField();
		txtTieuDe.setColumns(10);
		txtTieuDe.setBounds(94, 21, 296, 19);
		panel_1.add(txtTieuDe);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(94, 44, 296, 19);
		panel_1.add(txtTacGia);
		
		JLabel lblNmXutBn = new JLabel("Năm xuất bản:");
		lblNmXutBn.setBounds(10, 73, 88, 13);
		panel_1.add(lblNmXutBn);
		
		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(94, 70, 296, 19);
		panel_1.add(txtNXB);
		
		JLabel lblThLoi = new JLabel("Thể loại:");
		lblThLoi.setBounds(10, 99, 63, 13);
		panel_1.add(lblThLoi);
		
		txtTheLoai = new JTextField();
		txtTheLoai.setColumns(10);
		txtTheLoai.setBounds(94, 96, 296, 19);
		panel_1.add(txtTheLoai);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(94, 123, 296, 19);
		panel_1.add(txtMoTa);
		
		JLabel lblTiu_1 = new JLabel("Mô tả:");
		lblTiu_1.setBounds(10, 126, 63, 13);
		panel_1.add(lblTiu_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 33, 506, 197);
		getContentPane().add(scrollPane);
		
		tblSach = new JTable();
		scrollPane.setViewportView(tblSach);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(76, 446, 96, 32);
		btnThem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnThemActionPerformed(evt);
		    }
		});
		getContentPane().add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(182, 446, 96, 32);
		btnSua.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnSuaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(288, 446, 96, 32);
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnXoaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnXoa);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(394, 446, 96, 32);
		btnDong.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnDongActionPerformed(evt);
		    }
		});
		getContentPane().add(btnDong);

		HienThi();
	}
}
