package Gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.PhieuNhapSachDAO;
import Dao.SachDAO;
import Pojo.PhieuNhapSachPOJO;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class PhieuNhapSach extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tblPhieuNhapSach;
	private JTextField txtGhiChu;
	private JTextField txtNgay;
	private JTextField txtNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuNhapSach frame = new PhieuNhapSach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void HienThi() {
		ArrayList<PhieuNhapSachPOJO> ds = PhieuNhapSachDAO.LayDSPhieuNhapSach();
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã phiếu");
		dtm.addColumn("Ghi chú");
		dtm.addColumn("Ngày");
		dtm.addColumn("Nhân viên");
		dtm.setNumRows(ds.size());
		
		for (int i = 0; i < ds.size(); i++)
		{
			PhieuNhapSachPOJO PNS = ds.get(i);
			dtm.setValueAt(PNS.getiID(), i, 0);
			dtm.setValueAt(PNS.getStrGhiChu(), i, 1);
			dtm.setValueAt(PNS.getNgay(), i, 2);
			dtm.setValueAt(PNS.getStrNhanVien(), i, 3);	
		}
		this.tblPhieuNhapSach.setModel(dtm);
	}
	
	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
	    String GhiChu = txtGhiChu.getText();
	    String Ngay = txtNgay.getText();
        String NhanVien = txtNhanVien.getText();

	    PhieuNhapSachDAO PNS = new PhieuNhapSachDAO();
	    if (PNS.ThemPNS(GhiChu, Ngay, NhanVien)) {
	        JOptionPane.showMessageDialog(this, "Thêm thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblPhieuNhapSach.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Thêm thất bại");
	    }
	}
	
	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
	    int selectedRow = tblPhieuNhapSach.getSelectedRow();
	    int id = (Integer)tblPhieuNhapSach.getValueAt(selectedRow, 0);

	    PhieuNhapSachDAO PNS = new PhieuNhapSachDAO();
	    if (PNS.XoaPNS(id)) {
	        JOptionPane.showMessageDialog(this, "Xoá thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblPhieuNhapSach.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Xoá thất bại");
	    }
	}
	
	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
		String GhiChu = txtGhiChu.getText();
	    String Ngay = txtNgay.getText();
        String NhanVien = txtNhanVien.getText();
	    int selectedRow = tblPhieuNhapSach.getSelectedRow();
	    int id = (Integer)tblPhieuNhapSach.getValueAt(selectedRow, 0);

	    PhieuNhapSachDAO PNS = new PhieuNhapSachDAO();
	    if (PNS.SuaPNS(GhiChu, Ngay, NhanVien, id)) {
	        JOptionPane.showMessageDialog(this, "Sửa thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblPhieuNhapSach.getModel();
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
	public PhieuNhapSach() {
		setTitle("Phiếu nhập sách");
		setBounds(100, 100, 534, 449);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 25, 388, 197);
		getContentPane().add(scrollPane);
		
		tblPhieuNhapSach = new JTable();
		scrollPane.setViewportView(tblPhieuNhapSach);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin phi\u1EBFu nh\u1EADp s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(54, 248, 414, 102);
		getContentPane().add(panel_1);
		
		JLabel lblGhiCh = new JLabel("Ghi chú:");
		lblGhiCh.setBounds(10, 24, 63, 13);
		panel_1.add(lblGhiCh);
		
		JLabel lblNgy = new JLabel("Ngày:");
		lblNgy.setBounds(10, 47, 63, 13);
		panel_1.add(lblNgy);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(94, 21, 296, 19);
		panel_1.add(txtGhiChu);
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(94, 44, 296, 19);
		panel_1.add(txtNgay);
		
		JLabel lblNhnVin = new JLabel("Nhân viên:");
		lblNhnVin.setBounds(10, 73, 88, 13);
		panel_1.add(lblNhnVin);
		
		txtNhanVien = new JTextField();
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(94, 70, 296, 19);
		panel_1.add(txtNhanVien);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(54, 360, 96, 32);
		btnThem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnThemActionPerformed(evt);
		    }
		});
		getContentPane().add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(160, 360, 96, 32);
		btnSua.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnSuaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(266, 360, 96, 32);
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnXoaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnXoa);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(372, 360, 96, 32);
		btnDong.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnDongActionPerformed(evt);
		    }
		});
		getContentPane().add(btnDong);
		
		HienThi();

	}
}
