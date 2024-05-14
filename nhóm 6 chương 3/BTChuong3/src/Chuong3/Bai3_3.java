package Chuong3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Bai3_3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_ma;
	private JTextField txt_namxb;
	private JTextField txt_tieude;
	private JTextField txt_loai;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai3_3 frame = new Bai3_3();
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
	public Bai3_3() {
		setTitle("Quản lý CDDVD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã:");
		lblNewLabel.setBounds(10, 11, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tiêu đề:");
		lblNewLabel_1.setBounds(10, 46, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Loại:");
		lblNewLabel_2.setBounds(10, 78, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Năm xuất bản:");
		lblNewLabel_3.setBounds(10, 111, 91, 14);
		contentPane.add(lblNewLabel_3);
		
		txt_ma = new JTextField();
		txt_ma.setBounds(111, 8, 194, 20);
		contentPane.add(txt_ma);
		txt_ma.setColumns(10);
		
		txt_namxb = new JTextField();
		txt_namxb.setBounds(111, 108, 194, 20);
		contentPane.add(txt_namxb);
		txt_namxb.setColumns(10);
		
		txt_tieude = new JTextField();
		txt_tieude.setBounds(111, 43, 194, 20);
		contentPane.add(txt_tieude);
		txt_tieude.setColumns(10);
		
		txt_loai = new JTextField();
		txt_loai.setBounds(111, 75, 194, 20);
		contentPane.add(txt_loai);
		txt_loai.setColumns(10);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.setBounds(10, 136, 89, 34);
		contentPane.add(btn_them);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.setBounds(109, 136, 89, 34);
		contentPane.add(btn_luu);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.setBounds(208, 136, 89, 34);
		contentPane.add(btn_xoa);
		
		JButton btn_timkiem = new JButton("Tìm kiếm");
		btn_timkiem.setBounds(307, 136, 89, 34);
		contentPane.add(btn_timkiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 547, 185);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3", "Ti\u00EAu \u0111\u1EC1", "Lo\u1EA1i", "N\u0103m XB"
			}
		));
		LoadDuLieu();
		scrollPane.setViewportView(table);
		btn_them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt_ma.setText("");
				txt_ma.requestFocus();
				txt_tieude.setText("");
				txt_loai.setText("");
				txt_namxb.setText("");
				table.clearSelection();
			}
		});
		btn_luu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String ma = txt_ma.getText();
		        String tieuDe = txt_tieude.getText();
		        String loai = txt_loai.getText();
		        String namXB = txt_namxb.getText();
		        try {
		            int namXBInt = Integer.parseInt(namXB);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Năm xuất bản phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (ma.isEmpty() || tieuDe.isEmpty() || loai.isEmpty() || namXB.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try {
		            Connection connection = getConnection();
		            PreparedStatement statement;
		            if (isRowSelected()) {
		                String updateQueryString = "UPDATE CDDVDCollection SET TieuDe=?, LoaiDia=?, NamXuatBan=? WHERE Ma=?";
		                statement = connection.prepareStatement(updateQueryString);
		                statement.setString(1, tieuDe);
		                statement.setString(2, loai);
		                statement.setString(3, namXB);
		                statement.setString(4, ma);
		                statement.executeUpdate();
		            } else {
		                String insertQuery = "INSERT INTO CDDVDCollection (Ma, TieuDe, LoaiDia, NamXuatBan) VALUES (?, ?, ?,?)";
		                statement = connection.prepareStatement(insertQuery);
		                statement.setString(1, ma);
		                statement.setString(2, tieuDe);
		                statement.setString(3, loai);
		                statement.setString(4, namXB);
		                statement.executeUpdate();
		            }
		            statement.close();
		            connection.close();
		            JOptionPane.showMessageDialog(null, "Lưu thông tin đĩa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		            LoadDuLieu();
		        } catch (Exception ex1) {
		            ex1.printStackTrace();
		        }
		    }
		});
		btn_xoa.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
		        if (confirmResult != JOptionPane.YES_OPTION) {
		            return;
		        }

		        String ma = table.getValueAt(selectedRow, 0).toString();
		        try {
		            Connection connection = getConnection();
		            String deleteQuery = "DELETE FROM CDDVDCollection WHERE Ma = ?";
		            PreparedStatement statement = connection.prepareStatement(deleteQuery);
		            statement.setString(1, ma);
		            statement.executeUpdate();
		            statement.close();
		            connection.close();
		            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		            txt_ma.setText("");
		            txt_tieude.setText("");
		            txt_loai.setText("");
		            txt_namxb.setText("");
		            LoadDuLieu();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            int selectedRow = table.getSelectedRow();
		            if (selectedRow != -1) {
		                String ma = table.getValueAt(selectedRow, 0).toString();
		                String tieuDe = table.getValueAt(selectedRow, 1).toString();
		                String loai = table.getValueAt(selectedRow, 2).toString();
		                String namXB = table.getValueAt(selectedRow, 3).toString();
		                txt_ma.enable(false);
		                txt_ma.setText(ma);
		                txt_tieude.setText(tieuDe);
		                txt_loai.setText(loai);
		                txt_namxb.setText(namXB);
		            }
		        }
		    }
		});
		btn_timkiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Bai3_3_TimKiem formTimKiem=new Bai3_3_TimKiem();
				formTimKiem.setVisible(true);
			}
		});
	}
	private boolean isRowSelected() {
	    return table.getSelectedRow() != -1;
	}
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "sa");
            properties.setProperty("password", "123");
            properties.setProperty("encrypt", "true");
            properties.setProperty("trustServerCertificate", "true");
            String url = "jdbc:sqlserver://DESKTOP-J9MDADE\\BAO;databaseName=QLDIA;";
            connection = DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void LoadDuLieu() {
        try {
            Connection connection = getConnection();
            String query = "{CALL ListAllCDDVD}";
            CallableStatement statement = connection.prepareCall(query);
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                String ma = resultSet.getString("Ma");
                String tieuDe = resultSet.getString("TieuDe");
                String loaiDia = resultSet.getString("LoaiDia");
                int namXB = resultSet.getInt("NamXuatBan");
                model.addRow(new Object[]{ma, tieuDe, loaiDia, namXB});
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
