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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class View1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View1 frame = new View1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://VN88\\VONGOC:1433;databaseName=QL_CDDVD;trustServerCertificate=true";
        String userName = "sa";
        String password = "123456789";
        return DriverManager.getConnection(url, userName, password);
    }
    
    // Phương thức hiển thị View2
    private void showSearchView() {
        View2 view2 = new View2(); // Tạo một thể hiện mới của View2
        view2.setVisible(true); // Hiển thị giao diện View2
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

    
    
    /**
     * Create the frame.
     */
    public View1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 388, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(96, 10, 262, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Mã:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 13, 45, 16);
        contentPane.add(lblNewLabel);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(96, 39, 262, 19);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(96, 68, 262, 19);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(96, 97, 262, 19);
        contentPane.add(textField_3);
        
        JLabel lblLoi = new JLabel("Loại");
        lblLoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblLoi.setBounds(10, 68, 45, 16);
        contentPane.add(lblLoi);
        
        JLabel lblTiu = new JLabel("Tiêu đề:");
        lblTiu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblTiu.setBounds(10, 42, 76, 16);
        contentPane.add(lblTiu);
        
        JLabel lblNmXutBn = new JLabel("Năm xuất bản:");
        lblNmXutBn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNmXutBn.setBounds(10, 100, 93, 16);
        contentPane.add(lblNmXutBn);
        
        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBounds(10, 138, 85, 30);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Lưu");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_1.setBounds(96, 138, 85, 30);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Xóa");
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_2.setBounds(183, 138, 85, 30);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Tìm kiếm");
        btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_3.setBounds(273, 138, 93, 30);
        contentPane.add(btnNewButton_3);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"M\u00E3", "Ti\u00EAu \u0111\u1EC1", "Lo\u1EA1i", "N\u0103m XB"
        	}
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 187, 374, 248);
        contentPane.add(scrollPane);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Gọi phương thức để hiển thị View2
                showSearchView();
            }
        });
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các trường nhập liệu
                String ma = textField.getText();
                String tieuDe = textField_1.getText();
                String loai = textField_2.getText();
                String namSX = textField_3.getText();
                
                // Gọi phương thức addData để thêm dữ liệu mới
                addData(ma, tieuDe, loai, namSX);
            }
        });
        
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ mục của dòng được chọn
                int selectedRow = table.getSelectedRow();
                
                // Kiểm tra xem có dòng nào được chọn không
                if (selectedRow != -1) {
                    // Lấy mã từ dòng được chọn trong bảng
                    String maToDelete = (String) table.getValueAt(selectedRow, 0); // Giả sử mã ở cột đầu tiên

                    // Gọi phương thức delete để xóa dữ liệu dựa trên mã
                    deleteData(maToDelete);
                } else {
                    // Hiển thị thông báo nếu không có dòng nào được chọn
                    javax.swing.JOptionPane.showMessageDialog(View1.this, "Vui lòng chọn một dòng để xóa.", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });



        
        // Gọi loadData ở cuối phương thức khởi tạo
        loadData();
        
    }
    
    private void addData(String ma, String tieuDe, String loai, String namSX) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = getConnection();
            // Gọi stored procedure thêm dữ liệu
            String sql = "{CALL AddData(?, ?, ?, ?)}"; // Thay thế AddData bằng tên stored procedure của bạn
            stmt = conn.prepareCall(sql);
            // Thiết lập các tham số cho stored procedure
            stmt.setString(1, ma);
            stmt.setString(2, tieuDe);
            stmt.setString(3, loai);
            stmt.setString(4, namSX);
            // Thực thi stored procedure
            stmt.executeUpdate();
            // Load lại dữ liệu sau khi thêm
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error adding data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void saveData(String ma, String tieuDe, String loai, String namSX) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = getConnection();
            // Gọi stored procedure lưu dữ liệu
            String sql = "{CALL SaveData(?, ?, ?, ?)}"; // Thay thế SaveData bằng tên stored procedure của bạn
            stmt = conn.prepareCall(sql);
            // Thiết lập các tham số cho stored procedure
            stmt.setString(1, ma);
            stmt.setString(2, tieuDe);
            stmt.setString(3, loai);
            stmt.setString(4, namSX);
            // Thực thi stored procedure
            stmt.executeUpdate();
            // Load lại dữ liệu sau khi lưu
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Xóa
    private void deleteData(String ma) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = getConnection();
            // Gọi stored procedure xóa dữ liệu
            String sql = "{CALL DeleteData(?)}"; // Thay thế DeleteData bằng tên stored procedure của bạn
            stmt = conn.prepareCall(sql);
            // Thiết lập tham số cho stored procedure
            stmt.setString(1, ma);
            // Thực thi stored procedure
            stmt.executeUpdate();
            // Load lại dữ liệu sau khi xóa
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error deleting data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}