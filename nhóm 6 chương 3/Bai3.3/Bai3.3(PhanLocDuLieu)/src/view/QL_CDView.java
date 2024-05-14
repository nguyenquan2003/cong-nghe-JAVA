package view;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class QL_CDView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QL_CDView frame = new QL_CDView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QL_CDView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 738, 476);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Mã", "Tiêu đề", "Loại", "Năm XB"}
        ));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 100, 704, 219);
        contentPane.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Lọc theo loại:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(59, 27, 115, 35);
        contentPane.add(lblNewLabel);
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(184, 29, 130, 35);
        contentPane.add(comboBox);
        
        JLabel lblLcTheoNm = new JLabel("Lọc theo năm xuất bản:");
        lblLcTheoNm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLcTheoNm.setBounds(348, 29, 182, 35);
        contentPane.add(lblLcTheoNm);
        
        comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(540, 29, 130, 35);
        contentPane.add(comboBox_1);

        comboBox.addActionListener(e -> updateTableData());
        comboBox_1.addActionListener(e -> updateTableData());
        
        DefaultComboBoxModel<String> loaiModel = new DefaultComboBoxModel<>();
        loaiModel.addElement("All");
        comboBox.setModel(loaiModel);

        DefaultComboBoxModel<String> namXBModel = new DefaultComboBoxModel<>();
        namXBModel.addElement("All");
        comboBox_1.setModel(namXBModel);
        
        updateComboBoxes();
        updateTableData();
        
    }
    
    private void updateComboBoxes() {
        // Lấy dữ liệu từ database
        List<String> loaiList = fetchLoaiFromDatabase();
        List<String> namXBList = fetchNamXBFromDatabase();

        // Tạo mới các DefaultComboBoxModel
        DefaultComboBoxModel<String> loaiModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> namXBModel = new DefaultComboBoxModel<>();

        // Thêm "All" vào đầu tiên cho cả hai ComboBox
        loaiModel.addElement("All");
        namXBModel.addElement("All");

        // Thêm dữ liệu từ danh sách vào ComboBoxModel
        for (String loai : loaiList) {
            loaiModel.addElement(loai);
        }

        for (String namXB : namXBList) {
            namXBModel.addElement(namXB);
        }

        // Cập nhật ComboBox với các model mới
        comboBox.setModel(loaiModel);
        comboBox_1.setModel(namXBModel);
    }

    private List<String> fetchLoaiFromDatabase() {
    	return fetchDistinctValues("{CALL sp_fetchDistinctLoai}");
    }

    private List<String> fetchNamXBFromDatabase() {
    	return fetchDistinctValues("{CALL sp_fetchDistinctNamXB}");
    }

    

    private List<String> fetchDistinctValues(String callStatement) {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            cst = connection.prepareCall(callStatement);
            rs = cst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
            try {
                if (cst != null) cst.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private List<Object[]> fetchDataFromDatabase(String loai, String namXB) {
        List<Object[]> dataList = new ArrayList<>();
        String query = "SELECT Ma, TieuDe, LoaiDia, NamXuatBan FROM CDDVDCollection WHERE 1 = 1";

        if (!"All".equals(loai)) {
            query += " AND LoaiDia = ?";
        }
        
        if (!"All".equals(namXB)) {
            query += " AND NamXuatBan = ?";
        }

        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            pst = connection.prepareStatement(query);
            
            int index = 1;
            if (!"All".equals(loai)) {
                pst.setString(index++, loai);
            }
            
            if (!"All".equals(namXB)) {
                pst.setString(index++, namXB);
            }

            rs = pst.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getString("Ma"),
                    rs.getString("TieuDe"),
                    rs.getString("LoaiDia"),
                    rs.getString("NamXuatBan")
                };
                dataList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
            try {
                if (pst != null) pst.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }

    
    

    private Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://VN88\\VONGOC:1433;databaseName=QL_CDDVD;trustServerCertificate=true";
        String userName = "sa";
        String password = "123456789";
        return DriverManager.getConnection(url, userName, password);
    }

    private void updateTableData() {
        String loai = (String) comboBox.getSelectedItem();
        String namXB = (String) comboBox_1.getSelectedItem();

        List<Object[]> newDataList = fetchDataFromDatabase(loai, namXB);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Object[] row : newDataList) {
            model.addRow(row);
        }
    }
    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

