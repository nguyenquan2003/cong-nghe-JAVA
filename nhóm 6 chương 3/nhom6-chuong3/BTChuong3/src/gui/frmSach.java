package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.LoaiSachDAO;
import dao.SachDAO;
import pojo.LoaiSachPOJO;
import pojo.SachPOJO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmSach extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tabQuanLySach;
	private JTextField txtTieuDe;
	private JTextField txtTacGia;
	private JTextField txtMota;
	private JTextField txtNXB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSach frame = new frmSach();
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
		ArrayList<SachPOJO> ds = SachDAO.layDanhSachSach();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã sách");
		dtm.addColumn("Tiêu đề");
		dtm.addColumn("Tác giả");
		dtm.addColumn("Năm xuất bản");
		dtm.addColumn("loại sách");
		dtm.addColumn("Mô tả");
		dtm.setNumRows (ds.size());
		for (int i = 0; i < ds.size(); i ++) {
			SachPOJO s =ds.get(i);
			dtm.setValueAt (s.getiS_ID(), i, 0);
			dtm.setValueAt (s.getStrTieuDe(), i, 1);
			dtm.setValueAt (s.getStrTacGia(), i, 2);
			dtm.setValueAt (s.getiNamXuatBan(), i, 3);
			dtm.setValueAt (s.getiLS_ID(), i, 4);
			dtm.setValueAt (s.getStrMota(), i, 5);
		}
		this.tabQuanLySach.setModel (dtm);
	}
	
	public frmSach() {
		setTitle("Quản lý sách");
		setBounds(100, 100, 595, 416);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 563, 142);
		getContentPane().add(scrollPane);
		
		tabQuanLySach = new JTable();
		scrollPane.setViewportView(tabQuanLySach);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 173, 563, 142);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tiêu đề");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 25, 61, 16);
		panel.add(lblNewLabel);
		
		txtTieuDe = new JTextField();
		txtTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTieuDe.setBounds(94, 24, 135, 19);
		panel.add(txtTieuDe);
		txtTieuDe.setColumns(10);
		
		JLabel lblTcGi = new JLabel("Tác giả");
		lblTcGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTcGi.setBounds(10, 64, 61, 16);
		panel.add(lblTcGi);
		ArrayList<LoaiSachPOJO> ds = LoaiSachDAO.layDanhSachLoaiSach();
		DefaultComboBoxModel<LoaiSachPOJO> model = new DefaultComboBoxModel<>();
        for (LoaiSachPOJO loaiSach : ds) {
            model.addElement(loaiSach);
        }
		JComboBox<LoaiSachPOJO> cbxTheLoai = new JComboBox<>(model);
		cbxTheLoai.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof LoaiSachPOJO) {
                    LoaiSachPOJO loaiSach = (LoaiSachPOJO) value;
                    setText(loaiSach.getStrTen());
                }
                return this;
            }
        });

		cbxTheLoai.addActionListener(e -> {
            if (cbxTheLoai.getSelectedItem() != null) {
                LoaiSachPOJO selectedLoaiSach = (LoaiSachPOJO) cbxTheLoai.getSelectedItem();
                int id = selectedLoaiSach.getiID();
                
            }
        });
		
		cbxTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxTheLoai.setBounds(423, 59, 112, 21);
		panel.add(cbxTheLoai);
		txtTacGia = new JTextField();
		txtTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(94, 63, 135, 19);
		panel.add(txtTacGia);
		
		JLabel lblMT = new JLabel("Mô tả");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMT.setBounds(10, 107, 61, 16);
		panel.add(lblMT);
		
		txtMota = new JTextField();
		txtMota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMota.setColumns(10);
		txtMota.setBounds(94, 104, 441, 22);
		panel.add(txtMota);
		
		JLabel lblNmXutBn = new JLabel("Năm xuất bản");
		lblNmXutBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmXutBn.setBounds(310, 25, 103, 16);
		panel.add(lblNmXutBn);
		
		JLabel lblThLoi = new JLabel("Thể loại");
		lblThLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThLoi.setBounds(310, 64, 61, 16);
		panel.add(lblThLoi);

		txtNXB = new JTextField();
		txtNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNXB.setColumns(10);
		txtNXB.setBounds(423, 26, 112, 19);
		panel.add(txtNXB);
		
		JButton btnNewButton = new JButton("Thêm");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 345, 94, 33);
		getContentPane().add(btnNewButton);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tieude = txtTieuDe.getText();
				String tacgia = txtTacGia.getText();
				int NXB =0;
				try {
					NXB =Integer.parseInt(txtNXB.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập năm xuất bản là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				LoaiSachPOJO selectedLoaiSach = (LoaiSachPOJO) cbxTheLoai.getSelectedItem();
			    int id_ls = selectedLoaiSach.getiID();
		        String moTa = txtMota.getText();
		        if (tieude.isEmpty()||tacgia.isEmpty()||NXB == 0  || moTa.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				int selectedRow = tabQuanLySach.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để Sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int id = Integer.parseInt(tabQuanLySach.getValueAt(selectedRow, 0).toString()) ;

		        try {
		        	int n = SachDAO.suaSach(id,tieude,tacgia,NXB,id_ls,moTa);
		        	if(n>0) {
		        		JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        		txtTieuDe.setText("");
						 txtTacGia.setText("");
						 txtNXB.setText("");
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
		btnSua.setBounds(164, 345, 94, 33);
		getContentPane().add(btnSua);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = tabQuanLySach.getSelectedRow();
			        if (selectedRow == -1) {
			            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        int id = Integer.parseInt(tabQuanLySach.getValueAt(selectedRow, 0).toString()) ;

			        try {
			        	int n = SachDAO.xoaSach(id);
			        	if(n>0) {
			        		JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			        		 txtTieuDe.setText("");
							 txtTacGia.setText("");
							 txtNXB.setText("");
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
		btnXo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXo.setBounds(324, 345, 94, 33);
		getContentPane().add(btnXo);
		
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
		btnThoat.setBounds(479, 345, 94, 33);
		getContentPane().add(btnThoat);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tieude = txtTieuDe.getText();
				String tacgia = txtTacGia.getText();
				int NXB =0;
				try {
					NXB =Integer.parseInt(txtNXB.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập năm xuất bản là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				LoaiSachPOJO selectedLoaiSach = (LoaiSachPOJO) cbxTheLoai.getSelectedItem();
			    int id = selectedLoaiSach.getiID();
		        String moTa = txtMota.getText();
		        if (tieude.isEmpty()||tacgia.isEmpty()||NXB == 0  || moTa.isEmpty() ) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				try {
					 int n = SachDAO.themSach(tieude,tacgia,NXB,id, moTa);
					 if(n>0)
					 {
						 JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						 txtTieuDe.setText("");
						 txtTacGia.setText("");
						 txtNXB.setText("");
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
		tabQuanLySach.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tabQuanLySach.getSelectedRow();
                    if (selectedRow != -1) { 
                    	txtTieuDe.setText(tabQuanLySach.getValueAt(selectedRow, 1).toString());
						 txtTacGia.setText(tabQuanLySach.getValueAt(selectedRow, 2).toString());
						 txtNXB.setText(tabQuanLySach.getValueAt(selectedRow, 3).toString());
						 int loaisach = Integer.parseInt(tabQuanLySach.getValueAt(selectedRow, 4).toString()) ;
						 for (int i = 0; i < cbxTheLoai.getItemCount(); i++) {
					            LoaiSachPOJO item = cbxTheLoai.getItemAt(i);
					            if (item.getiID() == loaisach) {
					            	cbxTheLoai.setSelectedIndex(i);
					                break;
					            }
					        }
						 txtMota.setText(tabQuanLySach.getValueAt(selectedRow, 5).toString());
                       
                       
                    }
                }
            }
        });
		 hienThi();
	}
}
