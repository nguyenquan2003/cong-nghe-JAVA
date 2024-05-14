package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.HoadonDAO;
import dao.NguoiDungDAO;
import dao.PhieuNhapSachDAO;
import dao.SachDAO;
import pojo.HoaDonPOJO;
import pojo.LoaiSachPOJO;
import pojo.NguoiDungPOJO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class frmHoaDon extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tabDanhMucHoaDon;
	private JTextField txtNgay;
	private JTextField txtTenKhachHang;
	private JTextField txtGhiChu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHoaDon frame = new frmHoaDon();
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
	
	private void hienThi() {
		ArrayList<HoaDonPOJO> ds = HoadonDAO.layDanhSachHoaDon();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã hoá đơn");
		dtm.addColumn("Ngày");
		dtm.addColumn("ID người dùng");	
		dtm.addColumn("Tên khách hàng");
		dtm.addColumn("Ghi chú");
		
		dtm.setNumRows (ds.size());
		for (int i = 0; i < ds.size(); i ++) {
			HoaDonPOJO hd =ds.get(i);
			dtm.setValueAt (hd.getiHD_ID(), i, 0);
			dtm.setValueAt (hd.getdNgay(), i, 1);
			dtm.setValueAt (hd.getiND_ID(), i, 2);
			dtm.setValueAt (hd.getStrTenKhachHang(), i, 3);
			dtm.setValueAt (hd.getStrGhiChu(), i, 4);
		}
		this.tabDanhMucHoaDon.setModel (dtm);
	}
	public frmHoaDon() {
		setBounds(100, 100, 646, 509);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 614, 178);
		getContentPane().add(scrollPane);
		
		tabDanhMucHoaDon = new JTable();
		scrollPane.setViewportView(tabDanhMucHoaDon);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 198, 614, 125);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ngày");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 22, 76, 19);
		panel.add(lblNewLabel);
		
		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgay.setBounds(116, 22, 139, 19);
		panel.add(txtNgay);
		txtNgay.setColumns(10);
		
		JLabel lblIdNgiDng = new JLabel("ID người dùng");
		lblIdNgiDng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdNgiDng.setBounds(10, 67, 96, 19);
		panel.add(lblIdNgiDng);
		
		JLabel txtTen = new JLabel("Tên Khách Hàng");
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setBounds(287, 22, 117, 19);
		panel.add(txtTen);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(417, 22, 139, 19);
		panel.add(txtTenKhachHang);
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGhiCh.setBounds(287, 67, 76, 19);
		panel.add(lblGhiCh);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(417, 67, 139, 19);
		panel.add(txtGhiChu);
		
		
		
		ArrayList<NguoiDungPOJO> ds = NguoiDungDAO.layDanhSachNguoiDung();
		DefaultComboBoxModel<NguoiDungPOJO> model = new DefaultComboBoxModel<>();
        for (NguoiDungPOJO nguoidung : ds) {
            model.addElement(nguoidung);
        }
		JComboBox<NguoiDungPOJO> cbxID = new JComboBox<>(model);
		
		
		cbxID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxID.setBounds(116, 68, 139, 18);
		panel.add(cbxID);
		cbxID.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof NguoiDungPOJO) {
                	NguoiDungPOJO nguoidung = (NguoiDungPOJO) value;
                	setText(nguoidung.getStrHoTen());
                   
                    
                }
                return this;
            }
        });
		cbxID.addActionListener(e -> {
            if (cbxID.getSelectedItem() != null) {
            	NguoiDungPOJO selectedNguoidung = (NguoiDungPOJO) cbxID.getSelectedItem();
                int id = selectedNguoidung.getiND_ID();
 
            }
        });
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ngay = txtNgay.getText();
				String khachhang = txtTenKhachHang.getText();
				String ghichu = txtGhiChu.getText();
				NguoiDungPOJO selectedLoaiSach = (NguoiDungPOJO) cbxID.getSelectedItem();
			    int id = selectedLoaiSach.getiND_ID();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        
		        if (ngay.isEmpty() || ngay.isEmpty() ||ghichu.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        try {
		            Date date = dateFormat.parse(ngay);
		            
		            try {
						 int n = HoadonDAO.themHoaDon(date,id,ghichu,khachhang);
						 if(n>0)
						 {
							 JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							 txtGhiChu.setText("");
							 txtNgay.setText("");
							 txtGhiChu.setText("");
							 txtTenKhachHang.setText("");
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
		btnNewButton.setBounds(10, 349, 122, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ngay = txtNgay.getText();
				String khachhang = txtTenKhachHang.getText();
				String ghichu = txtGhiChu.getText();
				NguoiDungPOJO selectedLoaiSach = (NguoiDungPOJO) cbxID.getSelectedItem();
			    int ND_id = selectedLoaiSach.getiND_ID();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        
		        if (ghichu.isEmpty() || ngay.isEmpty() ||khachhang.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				int selectedRow = tabDanhMucHoaDon.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để Sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int id = Integer.parseInt(tabDanhMucHoaDon.getValueAt(selectedRow, 0).toString()) ;

		        try {	
		        	Date date = dateFormat.parse(ngay);
		        	
		        	 try {
				        	int n = HoadonDAO.suaHoaDon(id,date,ND_id ,khachhang,ghichu);
				        	if(n>0) {
				        		JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				        		 txtGhiChu.setText("");
								 txtNgay.setText("");
								 txtGhiChu.setText("");
								 txtTenKhachHang.setText("");
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
		btnSa.setBounds(173, 349, 122, 30);
		getContentPane().add(btnSa);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tabDanhMucHoaDon.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int id = Integer.parseInt(tabDanhMucHoaDon.getValueAt(selectedRow, 0).toString()) ;

		        try {
		        	int n = HoadonDAO.xoaHoaDon(id);
		        	if(n>0) {
		        		JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        		txtGhiChu.setText("");
						 txtNgay.setText("");
						 txtGhiChu.setText("");
						 txtTenKhachHang.setText("");
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
		btnXo.setBounds(338, 349, 122, 30);
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
		btnThot.setBounds(502, 349, 122, 30);
		getContentPane().add(btnThot);
		tabDanhMucHoaDon.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tabDanhMucHoaDon.getSelectedRow();
                    if (selectedRow != -1) { 
                        txtNgay.setText(tabDanhMucHoaDon.getValueAt(selectedRow, 1).toString());
                        int idnguoidung = Integer.parseInt(tabDanhMucHoaDon.getValueAt(selectedRow,2 ).toString()) ;
                        for (int i = 0; i < cbxID.getItemCount(); i++) {
				            NguoiDungPOJO item = cbxID.getItemAt(i);
				            if (item.getiND_ID() == idnguoidung) {
				            	cbxID.setSelectedIndex(i);
				                break;
				            }
				        }
						txtTenKhachHang.setText(tabDanhMucHoaDon.getValueAt(selectedRow, 3).toString());
						txtGhiChu.setText(tabDanhMucHoaDon.getValueAt(selectedRow, 4).toString());
                       
                    }
                }
            }
        });
		hienThi();
	}
	

}
