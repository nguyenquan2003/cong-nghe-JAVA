package Chuong3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Bai3_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_ma;
	private JTextField txt_ten;
	private JTextField txt_namsinh;
	private JTable table_khachhang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai3_1 frame = new Bai3_1();
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
	public Bai3_1() {
		setTitle("Quản lý khách hàng - JDBC Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_first = new JButton("|<");
		btn_first.setBounds(170, 25, 56, 31);
		contentPane.add(btn_first);
		
		JButton btn_next = new JButton(">");
		btn_next.setBounds(236, 25, 56, 31);
		contentPane.add(btn_next);
		
		JButton btn_previous = new JButton("<");
		btn_previous.setBounds(302, 25, 56, 31);
		contentPane.add(btn_previous);
		
		JButton btn_last = new JButton(">|");
		btn_last.setBounds(368, 25, 56, 31);
		contentPane.add(btn_last);
		
		JLabel lblNewLabel = new JLabel("Mã");
		lblNewLabel.setBounds(10, 293, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên");
		lblNewLabel_1.setBounds(10, 324, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Năm sinh");
		lblNewLabel_2.setBounds(10, 356, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		txt_ma = new JTextField();
		txt_ma.setBounds(87, 290, 271, 20);
		contentPane.add(txt_ma);
		txt_ma.setColumns(10);
		
		txt_ten = new JTextField();
		txt_ten.setBounds(87, 321, 271, 20);
		contentPane.add(txt_ten);
		txt_ten.setColumns(10);
		
		txt_namsinh = new JTextField();
		txt_namsinh.setBounds(87, 353, 271, 20);
		contentPane.add(txt_namsinh);
		txt_namsinh.setColumns(10);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.setBounds(10, 400, 89, 23);
		contentPane.add(btn_them);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.setBounds(112, 400, 89, 23);
		contentPane.add(btn_luu);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.setBounds(214, 400, 89, 23);
		contentPane.add(btn_xoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 586, 199);
		contentPane.add(scrollPane);
		
		table_khachhang = new JTable();
		table_khachhang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "N\u0103m sinh"
			}
		));
		scrollPane.setViewportView(table_khachhang);
		LoadDuLieu();
		btn_first.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (table_khachhang.getRowCount() > 0) {
		            table_khachhang.getSelectionModel().setSelectionInterval(0, 0);
		        }
		    }
		});

		btn_last.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int lastRowIndex = table_khachhang.getRowCount() - 1;
		        if (lastRowIndex >= 0) {
		            table_khachhang.getSelectionModel().setSelectionInterval(lastRowIndex, lastRowIndex);
		        }
		    }
		});

		btn_previous.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRowIndex = table_khachhang.getSelectedRow();
		        if (selectedRowIndex > 0) {
		            table_khachhang.getSelectionModel().setSelectionInterval(selectedRowIndex - 1, selectedRowIndex - 1);
		        }
		    }
		});

		btn_next.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRowIndex = table_khachhang.getSelectedRow();
		        int lastRowIndex = table_khachhang.getRowCount() - 1;
		        if (selectedRowIndex < lastRowIndex) {
		            table_khachhang.getSelectionModel().setSelectionInterval(selectedRowIndex + 1, selectedRowIndex + 1);
		        }
		    }
		});

		btn_them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt_ma.setText("");
				txt_ma.requestFocus();
				txt_ten.setText("");
				txt_namsinh.setText("");
				table_khachhang.clearSelection();
			}
		});
		btn_luu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String maKH = txt_ma.getText();
		        String tenKH = txt_ten.getText();
		        String namSinh = txt_namsinh.getText();

		        if (maKH.isEmpty() || tenKH.isEmpty() || namSinh.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        try {
		            int namSinhInt = Integer.parseInt(namSinh);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Năm sinh phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try {
		            Connection connection = getConnection();
		            PreparedStatement statement;

		            if (isRowSelected()) {
		                String updateQuery = "UPDATE KhachHang SET TenKH = ?, NamSinh = ? WHERE MaKH = ?";
		                statement = connection.prepareStatement(updateQuery);
		                statement.setString(1, tenKH);
		                statement.setString(2, namSinh);
		                statement.setString(3, maKH);
		                statement.executeUpdate();
		            } else {
		                String insertQuery = "INSERT INTO KhachHang (MaKH, TenKH, NamSinh) VALUES (?, ?, ?)";
		                statement = connection.prepareStatement(insertQuery);
		                statement.setString(1, maKH);
		                statement.setString(2, tenKH);
		                statement.setString(3, namSinh);
		                statement.executeUpdate();
		            }
		            statement.close();
		            connection.close();
		            JOptionPane.showMessageDialog(null, "Lưu thông tin khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		            LoadDuLieu();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		btn_xoa.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table_khachhang.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
		        if (confirmation == JOptionPane.YES_OPTION) {
		            String maKH = table_khachhang.getValueAt(selectedRow, 0).toString();

		            try {
		                Connection connection = getConnection();
		                String deleteQuery = "DELETE FROM KhachHang WHERE MaKH = ?";
		                PreparedStatement statement = connection.prepareStatement(deleteQuery);
		                statement.setString(1, maKH);
		                statement.executeUpdate();
		                statement.close();
		                connection.close();
		                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		                txt_ma.setText("");
		                txt_ten.setText("");
		                txt_namsinh.setText("");
		                LoadDuLieu();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});

		table_khachhang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					int selectedRow=table_khachhang.getSelectedRow();
					if (selectedRow!=-1){
		                String maKH = table_khachhang.getValueAt(selectedRow, 0).toString();
		                String tenKH = table_khachhang.getValueAt(selectedRow, 1).toString();
		                String namSinh = table_khachhang.getValueAt(selectedRow, 2).toString();
		                txt_ma.enable(false);
		                txt_ma.setText(maKH);
		                txt_ten.setText(tenKH);
		                txt_namsinh.setText(namSinh);
					}
				}
			}
		});		
	}
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "sa");
            properties.setProperty("password", "123");
            properties.setProperty("encrypt", "true");
            properties.setProperty("trustServerCertificate", "true");
            String url = "jdbc:sqlserver://DESKTOP-J9MDADE\\BAO;databaseName=QLKH;";
            connection = DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
	private boolean isRowSelected() {
	    return table_khachhang.getSelectedRow() != -1;
	}
    public void LoadDuLieu() {
    	try {
    		Connection connection=getConnection();
    		String query="SELECT * FROM KhachHang";
    		PreparedStatement statement =connection.prepareStatement(query);
    		ResultSet resultSet=statement.executeQuery();
    		DefaultTableModel model=(DefaultTableModel) table_khachhang.getModel();
    		model.setRowCount(0);
    		while(resultSet.next()) {
    			String maKH=resultSet.getString("MaKH");
    			String tenKH=resultSet.getString("TenKH");
    			int namSinh=resultSet.getInt("NamSinh");
    			model.addRow(new Object[] {maKH,tenKH,namSinh});
    		}
    		connection.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }
}