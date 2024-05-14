package Gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.HoaDonDAO;
import Dao.SachDAO;
import Pojo.HoaDonPOJO;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class HoaDon extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNgay;
	private JTextField txtNhanVien;
	private JTextField txtKH;
	private JTextField txtGhiChu;
	private JTable tblHoaDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon frame = new HoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void HienThi() {
		ArrayList<HoaDonPOJO> ds = HoaDonDAO.LayDSSach();
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã hoá đơn");
		dtm.addColumn("Ngày");
		dtm.addColumn("Nhân viên");
		dtm.addColumn("Khách hàng");
		dtm.addColumn("Ghi chú");
		dtm.setNumRows(ds.size());
		
		for (int i = 0; i < ds.size(); i++)
		{
			HoaDonPOJO HD = ds.get(i);
			dtm.setValueAt(HD.getiID(), i, 0);
			dtm.setValueAt(HD.getNgay(), i, 1);
			dtm.setValueAt(HD.getNhanVien(), i, 2);
			dtm.setValueAt(HD.getTenKH(), i, 3);
			dtm.setValueAt(HD.getGhiChu(), i, 4);	
		}
		this.tblHoaDon.setModel(dtm);
	}
	
	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
	    String Ngay = txtNgay.getText();
	    String NhanVien = txtNhanVien.getText();
        String TenKH = txtKH.getText();
        String GhiChu = txtGhiChu.getText();

	    HoaDonDAO HD = new HoaDonDAO();
	    if (HD.ThemHoaDon(Ngay, NhanVien, TenKH, GhiChu)) {
	        JOptionPane.showMessageDialog(this, "Thêm thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Thêm thất bại");
	    }
	}
	
	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
	    int selectedRow = tblHoaDon.getSelectedRow();
	    int id = (Integer)tblHoaDon.getValueAt(selectedRow, 0);

	    HoaDonDAO HD = new HoaDonDAO();
	    if (HD.XoaHoaDon(id)) {
	        JOptionPane.showMessageDialog(this, "Xoá thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
	        model.setRowCount(0);

	        // Hiển thị lại dữ liệu
	        HienThi();
	    } else {
	        JOptionPane.showMessageDialog(this, "Xoá thất bại");
	    }
	}
	
	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
		String Ngay = txtNgay.getText();
	    String NhanVien = txtNhanVien.getText();
        String TenKH = txtKH.getText();
        String GhiChu = txtGhiChu.getText();
        int selectedRow = tblHoaDon.getSelectedRow();
	    int id = (Integer)tblHoaDon.getValueAt(selectedRow, 0);

	    HoaDonDAO HD = new HoaDonDAO();
	    if (HD.SuaHoaDon(Ngay, NhanVien, TenKH, GhiChu, id)) {
	        JOptionPane.showMessageDialog(this, "Sửa thành công");

	        // Xóa toàn bộ dữ liệu của bảng
	        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
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
	public HoaDon() {
		setTitle("Hoá đơn");
		setBounds(100, 100, 682, 433);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 10, 471, 168);
		getContentPane().add(scrollPane);
		
		tblHoaDon = new JTable();
		scrollPane.setViewportView(tblHoaDon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(118, 201, 414, 130);
		getContentPane().add(panel_1);
		
		JLabel lblNgy = new JLabel("Ngày:");
		lblNgy.setBounds(10, 24, 63, 13);
		panel_1.add(lblNgy);
		
		JLabel lblNhnVin = new JLabel("Nhân viên:");
		lblNhnVin.setBounds(10, 47, 63, 13);
		panel_1.add(lblNhnVin);
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(94, 21, 296, 19);
		panel_1.add(txtNgay);
		
		txtNhanVien = new JTextField();
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(94, 44, 296, 19);
		panel_1.add(txtNhanVien);
		
		JLabel lblTnKhchHng = new JLabel("Tên KH:");
		lblTnKhchHng.setBounds(10, 73, 88, 13);
		panel_1.add(lblTnKhchHng);
		
		txtKH = new JTextField();
		txtKH.setColumns(10);
		txtKH.setBounds(94, 70, 296, 19);
		panel_1.add(txtKH);
		
		JLabel lblThGhiCh = new JLabel("Thể ghi chú:");
		lblThGhiCh.setBounds(10, 99, 63, 13);
		panel_1.add(lblThGhiCh);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(94, 96, 296, 19);
		panel_1.add(txtGhiChu);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(118, 341, 96, 32);
		btnThem.setBounds(76, 446, 96, 32);
		btnThem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnThemActionPerformed(evt);
		    }
		});
		getContentPane().add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(224, 341, 96, 32);
		btnSua.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnSuaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(330, 341, 96, 32);
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnXoaActionPerformed(evt);
		    }
		});
		getContentPane().add(btnXoa);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(436, 341, 96, 32);
		btnDong.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnDongActionPerformed(evt);
		    }
		});
		getContentPane().add(btnDong);

	}

}
