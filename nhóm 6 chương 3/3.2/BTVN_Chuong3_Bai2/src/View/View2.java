package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class View2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View2 frame = new View2();
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
	 private Connection getConnection() throws SQLException {
	        String url = "jdbc:sqlserver://HOHUUNHAN\\HOHUUNHAN:1433;databaseName=QL_DIACD/DVD;trustServerCertificate=true";
	        String userName = "sa";
	        String password = "1234567890";
	        return DriverManager.getConnection(url, userName, password);
	 }
	 
	
	 
	public View2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập dữ liệu cần tìm");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 140, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(160, 15, 243, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm ");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(427, 10, 85, 31);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Mã", "Tiêu đề", "Loại", "Năm XB"
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 58, 518, 195);
		contentPane.add(scrollPane);
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Lấy từ khóa tìm kiếm từ trường văn bản
		        String keyword = textField.getText();
		        // Gọi phương thức search để tìm kiếm và hiển thị kết quả
		        search(keyword);
		    }
		});
		
		 loadData();
	}
	 private void loadData() {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            String sql = "SELECT Ma, TieuDe, Loai, NamSX FROM DIA"; // Thay thế "TableName" bằng tên bảng của bạn
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(sql);

	            // Xóa tất cả các dòng hiện có trong bảng
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setRowCount(0);

	            // Đổ dữ liệu từ ResultSet vào bảng
	            while (rs.next()) {
	                String ma = rs.getString("Ma");
	                String tieuDe = rs.getString("TieuDe");
	                String loai = rs.getString("Loai");
	                String namSX = rs.getString("NamSX");
	                model.addRow(new Object[] { ma, tieuDe, loai, namSX });
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            javax.swing.JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	 }

	 

		// Phương thức search để thực hiện tìm kiếm trong bảng
		private void search(String keyword) {
		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    // Xóa tất cả các dòng hiện có trong bảng
		    model.setRowCount(0);
		    
		    // Thực hiện truy vấn và hiển thị kết quả tìm kiếm
		    try {
		        Connection conn = getConnection();
		        String sql = "SELECT Ma, TieuDe, Loai, NamSX FROM DIA WHERE Ma LIKE '%" + keyword + "%' OR TieuDe LIKE '%" + keyword + "%' OR Loai LIKE '%" + keyword + "%' OR NamSX LIKE '%" + keyword + "%'";
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(sql);
		        
		        // Đổ dữ liệu từ ResultSet vào bảng
		        while (rs.next()) {
		            String ma = rs.getString("Ma");
		            String tieuDe = rs.getString("TieuDe");
		            String loai = rs.getString("Loai");
		            String namSX = rs.getString("NamSX");
		            model.addRow(new Object[] { ma, tieuDe, loai, namSX });
		        }
		        
		        // Đóng kết nối và các tài nguyên
		        rs.close();
		        stmt.close();
		        conn.close();
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        javax.swing.JOptionPane.showMessageDialog(this, "Error searching data: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		    }
		}

}
