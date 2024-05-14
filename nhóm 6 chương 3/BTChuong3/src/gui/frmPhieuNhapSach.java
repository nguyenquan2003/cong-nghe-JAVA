package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.LoaiSachDAO;
import dao.PhieuNhapSachDAO;
import dao.SachDAO;
import pojo.LoaiSachPOJO;
import pojo.PhieuNhapSachPOJO;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class frmPhieuNhapSach extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tabDanhMucPNS;
	private JTextField txtGhiChu;
	private JTextField txtNgay;
	private JTextField txtNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPhieuNhapSach frame = new frmPhieuNhapSach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */private void hienThi() {
			ArrayList<PhieuNhapSachPOJO> ds = PhieuNhapSachDAO.layDanhPNS();
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.addColumn("Mã phiếu nhập sách");
			dtm.addColumn("Ghi chú");
			dtm.addColumn("Ngày");	
			dtm.addColumn("Nhân viên");
			
			dtm.setNumRows (ds.size());
			for (int i = 0; i < ds.size(); i ++) {
				PhieuNhapSachPOJO s =ds.get(i);
				dtm.setValueAt (s.getiPNS_ID(), i, 0);
				dtm.setValueAt (s.getStrGhiChu(), i, 1);
				dtm.setValueAt (s.getdNgay(), i, 2);
				dtm.setValueAt (s.getStrNhanVien(), i, 3);
			}
			this.tabDanhMucPNS.setModel (dtm);
		}
		
	public frmPhieuNhapSach() {
		setTitle("Quản lý phiếu nhập sách");
		setBounds(100, 100, 598, 516);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 566, 223);
		getContentPane().add(scrollPane);
		
		tabDanhMucPNS = new JTable();
		scrollPane.setViewportView(tabDanhMucPNS);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chi ti\u1EBFt phi\u1EBFu nh\u1EADp s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 243, 566, 159);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ghi chú");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(48, 20, 68, 19);
		panel.add(lblNewLabel);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGhiChu.setBounds(149, 20, 334, 19);
		panel.add(txtGhiChu);
		txtGhiChu.setColumns(10);
		
		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgay.setColumns(10);
		txtNgay.setBounds(149, 64, 334, 19);
		panel.add(txtNgay);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 64, 88, 19);
		panel.add(lblNewLabel_1);
		
		txtNV = new JTextField();
		txtNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNV.setColumns(10);
		txtNV.setBounds(149, 116, 334, 19);
		panel.add(txtNV);
		
		JLabel lblNewLabel_2 = new JLabel("Nhân viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(48, 116, 68, 19);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ghichu = txtGhiChu.getText();
				String ngay = txtNgay.getText();
				String nhanvien = txtNV.getText();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        
		        if (ghichu.isEmpty() || ngay.isEmpty() ||nhanvien.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        try {
		            Date date = dateFormat.parse(ngay);
		            
		            try {
						 int n = PhieuNhapSachDAO.themPhieuNhapSach(ghichu,date, nhanvien);
						 if(n>0)
						 {
							 JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							 txtGhiChu.setText("");
							 txtNgay.setText("");
							 txtNV.setText("");
							 hienThi();
						 }
						 else 
						 {
							 JOptionPane.showConfirmDialog(null, "thêm thất bại");
						 }
					} catch (Exception e2) {
						JOptionPane.showConfirmDialog(null, "thêm thất bại");
					}
		            
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Vui nhập đúng định dạng năm - tháng - ngày", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        	return;
		        }
		        

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 412, 118, 37);
		getContentPane().add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ghichu = txtGhiChu.getText();
				String ngay = txtNgay.getText();
				String nhanvien = txtNV.getText();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        
		        if (ghichu.isEmpty() || ngay.isEmpty() ||nhanvien.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				int selectedRow = tabDanhMucPNS.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để Sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int id = Integer.parseInt(tabDanhMucPNS.getValueAt(selectedRow, 0).toString()) ;

		        try {	
		        	Date date = dateFormat.parse(ngay);
		        	
		        	 try {
				        	int n = PhieuNhapSachDAO.suaPhieuNhapSach(id,ghichu,date, nhanvien);
				        	if(n>0) {
				        		JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				        		txtGhiChu.setText("");
								 txtNgay.setText("");
								 txtNV.setText("");
								 hienThi();
				        	}
				        	else {
				        		JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				        	}
				           
				        } catch (Exception ex) {
				        	JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				        }
		           
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Vui nhập đúng định dạng năm - tháng - ngày", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        	return;
		        }
			}
		});
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSa.setBounds(157, 412, 118, 37);
		getContentPane().add(btnSa);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tabDanhMucPNS.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int id = Integer.parseInt(tabDanhMucPNS.getValueAt(selectedRow, 0).toString()) ;

		        try {
		        	int n = PhieuNhapSachDAO.xoaPhieuNhapSach(id);
		        	if(n>0) {
		        		JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        		txtGhiChu.setText("");
						 txtNgay.setText("");
						 txtNV.setText("");
						 hienThi();

		        	}
		        	else {
		        		JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        	}
		           
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		});
		btnXo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXo.setBounds(310, 412, 118, 37);
		getContentPane().add(btnXo);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(rootPane, 
		                "Bạn có chắc chắn muốn thoát chương trình hay không?", "Xác nhận thoát",
		                JOptionPane.YES_NO_OPTION);

		            if (confirmed == JOptionPane.YES_OPTION) {
		                System.exit(0); 
		            }
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(458, 412, 118, 37);
		getContentPane().add(btnThot);
		tabDanhMucPNS.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tabDanhMucPNS.getSelectedRow();
                    if (selectedRow != -1) { 
        
                        txtGhiChu.setText(tabDanhMucPNS.getValueAt(selectedRow, 1).toString());
						txtNgay.setText(tabDanhMucPNS.getValueAt(selectedRow, 2).toString());
						txtNV.setText(tabDanhMucPNS.getValueAt(selectedRow, 3).toString());
                       
                    }
                }
            }
        });
		hienThi();

	}

}
