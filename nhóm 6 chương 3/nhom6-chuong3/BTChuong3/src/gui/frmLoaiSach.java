package gui;

import java.awt.EventQueue;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.LoaiSachDAO;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import pojo.LoaiSachPOJO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class frmLoaiSach extends javax.swing.JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tabDanhMucLoaiSach;
	private JTextField txtTenSach;
	private JTextField txtMota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoaiSach frame = new frmLoaiSach();
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
		ArrayList<LoaiSachPOJO> ds = LoaiSachDAO.layDanhSachLoaiSach();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã sách");
		dtm.addColumn("Tên sách");
		dtm.addColumn("Mô tả");
		dtm.setNumRows (ds.size());
		for (int i = 0; i < ds.size(); i ++) {
			LoaiSachPOJO ls =ds.get(i);
			dtm.setValueAt (ls.getiID(), i, 0);
			dtm.setValueAt (ls.getStrTen(), i, 1);
			dtm.setValueAt (ls.getStrMoTa(), i, 2);
		}
		this.tabDanhMucLoaiSach.setModel (dtm);
	}
	public frmLoaiSach() {
		setTitle("Danh mục loại sách");
		setBounds(100, 100, 433, 381);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 388, 119);
		getContentPane().add(scrollPane);
		
		tabDanhMucLoaiSach = new JTable();
		tabDanhMucLoaiSach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));

		
		scrollPane.setViewportView(tabDanhMucLoaiSach);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Th\u00F4ng tin lo\u1EA1i s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 157, 388, 119);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên sách:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 27, 77, 25);
		panel.add(lblNewLabel);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(113, 28, 233, 25);
		panel.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		txtMota = new JTextField();
		txtMota.setColumns(10);
		txtMota.setBounds(113, 73, 233, 25);
		panel.add(txtMota);
		
		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMT.setBounds(26, 72, 77, 25);
		panel.add(lblMT);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSach = txtTenSach.getText();
		        String moTa = txtMota.getText();
		        if (tenSach.isEmpty() || moTa.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				try {
					 int n = LoaiSachDAO.themLoaiSach(tenSach, moTa);
					 if(n>0)
					 {
						 JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						 txtTenSach.setText("");
						 txtMota.setText("");
						 hienThi();
					 }
					 else 
					 {
						 JOptionPane.showConfirmDialog(null, "thêm thất bại");
					 }
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "thêm thất bại");
				}
				
			}
		});
		
		
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(10, 286, 86, 29);
		getContentPane().add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSach = txtTenSach.getText();
		        String moTa = txtMota.getText();
		        if (tenSach.isEmpty() && moTa.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ít nhất 1 thông tin để sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				int selectedRow = tabDanhMucLoaiSach.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để Sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int id = Integer.parseInt(tabDanhMucLoaiSach.getValueAt(selectedRow, 0).toString()) ;

		        try {
		        	int n = LoaiSachDAO.suaLoaiSach(id,tenSach,moTa);
		        	if(n>0) {
		        		JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						txtTenSach.setText("");
						txtMota.setText("");
						hienThi();
		        	}
		        	else {
		        		JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        	}
		           
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(111, 286, 86, 29);
		getContentPane().add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = tabDanhMucLoaiSach.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int id = Integer.parseInt(tabDanhMucLoaiSach.getValueAt(selectedRow, 0).toString()) ;

		        try {
		        	int n = LoaiSachDAO.xoaLoaiSach(id);
		        	if(n>0) {
		        		JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						txtTenSach.setText("");
						txtMota.setText("");
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
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(207, 286, 86, 29);
		getContentPane().add(btnXoa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(rootPane, 
		                "Bạn có chắc chắn muốn thoát chương trình hay không?", "Xác nhận thoát",
		                JOptionPane.YES_NO_OPTION);

		            if (confirmed == JOptionPane.YES_OPTION) {
		                System.exit(0); 
		            }
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(303, 286, 95, 29);
		getContentPane().add(btnThoat);
		tabDanhMucLoaiSach.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tabDanhMucLoaiSach.getSelectedRow();
                    if (selectedRow != -1) { 
        
                        txtTenSach.setText(tabDanhMucLoaiSach.getValueAt(selectedRow, 1).toString());
						txtMota.setText(tabDanhMucLoaiSach.getValueAt(selectedRow, 2).toString());
                       
                    }
                }
            }
        });
		hienThi();

	}
}
