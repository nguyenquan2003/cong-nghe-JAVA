package Gui;

import java.awt.EventQueue;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.LoaiSachDAO;
import Pojo.LoaiSachPOJO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DanhMucLoaiSach extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tblDanhMucLoaiSach;
	private JTextField txtTenSach;
	private JTextField txtMoTa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					DanhMucLoaiSach frame = new DanhMucLoaiSach();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void HienThi() {
		ArrayList<LoaiSachPOJO> ds = LoaiSachDAO.LayDSLoaiSach();
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã loại");
		dtm.addColumn("Tên loại sách");
		dtm.addColumn("Mô tả");
		dtm.setNumRows(ds.size());
		
		for (int i = 0; i < ds.size(); i++)
		{
			LoaiSachPOJO ls = ds.get(i);
			dtm.setValueAt(ls.getiID(), i, 0);
			dtm.setValueAt(ls.getStrTen(), i, 1);
			dtm.setValueAt(ls.getStrMoTa(), i, 2);
		}
		this.tblDanhMucLoaiSach.setModel(dtm);
	}
	
	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
	    String Ten = txtTenSach.getText();
	    String MoTa = txtMoTa.getText();

	    LoaiSachDAO LS = new LoaiSachDAO();
	    if (LS.ThemLoaiSach(Ten, MoTa)) {
	        JOptionPane.showMessageDialog(this, "Thêm thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblDanhMucLoaiSach.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Thêm thất bại");
	    }
	}
	
	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
	    int selectedRow = tblDanhMucLoaiSach.getSelectedRow();
	    int id = (Integer)tblDanhMucLoaiSach.getValueAt(selectedRow, 0);

	    LoaiSachDAO LS = new LoaiSachDAO();
	    if (LS.XoaLoaiSach(id)) {
	        JOptionPane.showMessageDialog(this, "Xoá thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblDanhMucLoaiSach.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Xoá thất bại");
	    }
	}
	
	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
	    String Ten = txtTenSach.getText();
	    String MoTa = txtMoTa.getText();
	    int selectedRow = tblDanhMucLoaiSach.getSelectedRow();
	    int id = (Integer)tblDanhMucLoaiSach.getValueAt(selectedRow, 0);

	    LoaiSachDAO LS = new LoaiSachDAO();
	    if (LS.SuaLoaiSach(Ten, MoTa, id)) {
	        JOptionPane.showMessageDialog(this, "Sửa thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblDanhMucLoaiSach.getModel();
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
	public DanhMucLoaiSach() {
		this.title = "Danh mục loại sách";
		setBounds(100, 100, 450, 420);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 24, 381, 197);
		getContentPane().add(scrollPane);
		
		tblDanhMucLoaiSach = new JTable();
		scrollPane.setViewportView(tblDanhMucLoaiSach);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin lo\u1EA1i s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 243, 400, 79);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên sách:");
		lblNewLabel.setBounds(10, 24, 63, 13);
		panel.add(lblNewLabel);
		
		JLabel lblMtT = new JLabel("Môt tả:");
		lblMtT.setBounds(10, 47, 63, 13);
		panel.add(lblMtT);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(68, 21, 296, 19);
		panel.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(68, 44, 296, 19);
		panel.add(txtMoTa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 337, 96, 32);
		btnThem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnThemActionPerformed(evt);
		    }
		});
		getContentPane().add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(116, 337, 96, 32);
		btnSua.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnSuaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(222, 337, 96, 32);
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnXoaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnXoa);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(328, 337, 96, 32);
		btnDong.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnDongActionPerformed(evt);
		    }
		});
		getContentPane().add(btnDong);

		HienThi();
	}
}
