package Chuong3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class Bai3_4 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JComboBox<String> comboBox;
    private JList<String> list_danhmuc;


    private ArrayList<String> danhMucList = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Bai3_4 frame = new Bai3_4();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Bai3_4() {
    	setTitle("Quản lý sản phẩm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 859, 599);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 192), null));
        panel.setBounds(10, 11, 326, 540);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), null), "Danh mục sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(10, 11, 277, 439);
        panel.add(panel_2);
        panel_2.setLayout(null);

        list_danhmuc = new JList<>();
        list_danhmuc.setBounds(10, 21, 257, 407);
        panel_2.add(list_danhmuc);

        JButton btn_themdm = new JButton("Thêm DM");
        btn_themdm.setBounds(10, 482, 89, 23);
        panel.add(btn_themdm);
        btn_themdm.addActionListener(e -> themDanhMuc());

        JButton btn_capnhatdm = new JButton("Cập nhật DM");
        btn_capnhatdm.setBounds(109, 482, 108, 23);
        panel.add(btn_capnhatdm);
        btn_capnhatdm.addActionListener(e -> capNhatDanhMuc());

        JButton btn_xoadm = new JButton("Xóa DM");
        btn_xoadm.setBounds(227, 482, 89, 23);
        panel.add(btn_xoadm);
        btn_xoadm.addActionListener(e -> xoaDanhMuc());

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 192), null));
        panel_1.setBounds(335, 11, 500, 540);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 480, 209);
        panel_1.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá"
                }
        ));
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Danh mục:");
        lblNewLabel.setBounds(20, 252, 91, 14);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
        lblNewLabel_1.setBounds(20, 288, 91, 14);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tên sản phẩm:");
        lblNewLabel_2.setBounds(20, 331, 91, 14);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Số lượng:");
        lblNewLabel_3.setBounds(20, 372, 91, 14);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Đơn giá:");
        lblNewLabel_4.setBounds(20, 414, 91, 14);
        panel_1.add(lblNewLabel_4);

        comboBox = new JComboBox<>();
        comboBox.setBounds(136, 248, 171, 22);
        panel_1.add(comboBox);

        textField = new JTextField();
        textField.setBounds(136, 285, 246, 20);
        panel_1.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(136, 328, 246, 20);
        panel_1.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(136, 369, 246, 20);
        panel_1.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(136, 411, 246, 20);
        panel_1.add(textField_3);
        textField_3.setColumns(10);

        JButton btn_themsp = new JButton("Thêm SP");
        btn_themsp.setBounds(112, 481, 109, 23);
        panel_1.add(btn_themsp);

        JButton btn_capnhatsp = new JButton("Cập nhật SP\r\n");
        btn_capnhatsp.setBounds(231, 481, 109, 23);
        panel_1.add(btn_capnhatsp);

        JButton btn_xoasp = new JButton("Xóa SP");
        btn_xoasp.setBounds(347, 481, 109, 23);
        panel_1.add(btn_xoasp);
        loadDanhMucToList();
        btn_themsp.addActionListener(e -> themSanPham());
        btn_capnhatsp.addActionListener(e -> capNhatSanPham());
        btn_xoasp.addActionListener(e -> xoaSanPham());
       loadAllSanPhamToTable();
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    String maSP = (String) model.getValueAt(selectedRow, 0);
                    String tenSP = (String) model.getValueAt(selectedRow, 1);
                    int soLuong = (int) model.getValueAt(selectedRow, 2);
                    double donGia = (double) model.getValueAt(selectedRow, 3);
                    String tenDM = (String) comboBox.getSelectedItem();

                    textField.setText(maSP);
                    textField.enable(false);
                    textField_1.setText(tenSP);
                    textField_2.setText(String.valueOf(soLuong));
                    textField_3.setText(String.valueOf(donGia));
                    comboBox.setSelectedItem(tenDM);
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table.rowAtPoint(e.getPoint()) == -1) {
                    table.clearSelection();
                    clearTextFields();
                }
            }
        });
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
              JList theList = (JList) mouseEvent.getSource();
              if (mouseEvent.getClickCount() == 1) {
                int index = theList.locationToIndex(mouseEvent.getPoint());
                if (index >= 0) {
                  Object o = theList.getModel().getElementAt(index);
                  Connection connection = getConnection();
               	try {
					int maDM = getMaDanhMuc(o.toString(), connection);
					loadSanPhamToTable(maDM);
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//              		
                }
              }
            }
          };
          list_danhmuc.addMouseListener(mouseListener);
          
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "sa");
            properties.setProperty("password", "123");
            properties.setProperty("encrypt", "true");
            properties.setProperty("trustServerCertificate", "true");
            String url = "jdbc:sqlserver://DESKTOP-J9MDADE\\BAO;databaseName=QLSP;";
            connection = DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    private void loadDanhMucToList() {
        danhMucList.clear();
        try (Connection connection = getConnection()) {
            String sql = "SELECT TenDM FROM DanhMuc WHERE isDelete = 0";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String tenDM = resultSet.getString("TenDM");
                    danhMucList.add(tenDM);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String tenDM : danhMucList) {
            listModel.addElement(tenDM);
        }
        list_danhmuc.setModel(listModel);
        loadComboBox();
    }
    private void loadComboBox() {
        comboBox.removeAllItems();
        for (String tenDM : danhMucList) {
            comboBox.addItem(tenDM);
        }
    }
    private void themDanhMuc() {
        String tenDM = JOptionPane.showInputDialog(this, "Nhập tên danh mục mới:");
        if (tenDM != null && !tenDM.isEmpty()) {
            try (Connection connection = getConnection()) {
                String sql = "INSERT INTO DanhMuc (TenDM, isDelete) VALUES (?, 0)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, tenDM);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Đã thêm danh mục mới thành công.");
                    loadDanhMucToList();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm danh mục.");
            }
        }
    }
    private void capNhatDanhMuc() {
        int selectedIndex = list_danhmuc.getSelectedIndex();
        if (selectedIndex != -1) {
            String tenDM = JOptionPane.showInputDialog(this, "Nhập tên danh mục mới:");
            if (tenDM != null && !tenDM.isEmpty()) {
                try (Connection connection = getConnection()) {
                    String sql = "UPDATE DanhMuc SET TenDM = ? WHERE TenDM = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        String oldTenDM = danhMucList.get(selectedIndex);
                        statement.setString(1, tenDM);
                        statement.setString(2, oldTenDM);
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Đã cập nhật danh mục thành công.");
                        loadDanhMucToList(); // Cập nhật lại JList
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật danh mục.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một danh mục để cập nhật.");
        }
    }

    // Hàm xóa danh mục
    private void xoaDanhMuc() {
        int selectedIndex = list_danhmuc.getSelectedIndex();
        if (selectedIndex != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa danh mục này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection connection = getConnection()) {
                    String tenDM = danhMucList.get(selectedIndex);
                    String sql = "UPDATE DanhMuc SET isDelete = 1 WHERE TenDM = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, tenDM);
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Đã xóa danh mục thành công.");
                        loadDanhMucToList(); // Cập nhật lại JList
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa danh mục.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một danh mục để xóa.");
        }
    }

    private void loadSanPhamToTable(int maDM) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try (Connection connection = getConnection()) {
        	
            String sql = "SELECT MaSP, TenSP, SoLuong, DonGia FROM SanPham where MaDM=?";
            try (PreparedStatement statement = connection.prepareStatement(sql))
                  {
            	 statement.setInt(1, maDM);
            	ResultSet resultSet = statement.executeQuery();
            	
                while (resultSet.next()) {
                    String maSP = resultSet.getString("MaSP");
                    String tenSP = resultSet.getString("TenSP");
                    int soLuong = resultSet.getInt("SoLuong");
                    double donGia = resultSet.getDouble("DonGia");

                    model.addRow(new Object[]{maSP, tenSP, soLuong, donGia});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadAllSanPhamToTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try (Connection connection = getConnection()) {
        	
            String sql = "SELECT MaSP, TenSP, SoLuong, DonGia FROM SanPham";
            try (PreparedStatement statement = connection.prepareStatement(sql))
                  {
            	 
            	ResultSet resultSet = statement.executeQuery();
            	
                while (resultSet.next()) {
                    String maSP = resultSet.getString("MaSP");
                    String tenSP = resultSet.getString("TenSP");
                    int soLuong = resultSet.getInt("SoLuong");
                    double donGia = resultSet.getDouble("DonGia");

                    model.addRow(new Object[]{maSP, tenSP, soLuong, donGia});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void themSanPham() {
        String maSP = textField.getText();
        String tenSP = textField_1.getText();
        int soLuong = Integer.parseInt(textField_2.getText());
        double donGia = Double.parseDouble(textField_3.getText());
        String tenDM = (String) comboBox.getSelectedItem();

        try (Connection connection = getConnection()) {
            int maDM = getMaDanhMuc(tenDM, connection);

            String sql = "INSERT INTO SanPham (MaSP, TenSP, SoLuong, DonGia,MaDM ,isDelete) VALUES (?, ?, ?,?, ?, 0)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, maSP);
                statement.setString(2, tenSP);
                statement.setInt(3, soLuong);
                statement.setDouble(4, donGia);
                statement.setInt(5, maDM);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Đã thêm sản phẩm mới thành công.");
                loadSanPhamToTable(maDM); // Cập nhật lại bảng sản phẩm
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm sản phẩm.");
        }
    }

    private int getMaDanhMuc(String tenDM, Connection connection) throws SQLException {
        String sql = "SELECT MaDM FROM DanhMuc WHERE TenDM = ? AND isDelete = 0";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tenDM);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("MaDM");
                }
            }
        }
        return -1;
    }
    private void capNhatSanPham() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để cập nhật.");
            return;
        }

        String maSP = textField.getText();
        String tenSP = textField_1.getText();
        int soLuong = Integer.parseInt(textField_2.getText());
        double donGia = Double.parseDouble(textField_3.getText());
        String tenDM = (String) comboBox.getSelectedItem();

        try (Connection connection = getConnection()) {
            int maDM = getMaDanhMuc(tenDM, connection);

            String sql = "UPDATE SanPham SET TenSP = ?, SoLuong = ?, DonGia = ? WHERE MaSP = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, tenSP);
                statement.setInt(2, soLuong);
                statement.setDouble(3, donGia);
                statement.setString(4, maSP);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Đã cập nhật sản phẩm thành công.");
                loadSanPhamToTable(maDM); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật sản phẩm.");
        }
    }
    private void xoaSanPham() {
        String maSP = textField.getText();
        if (!maSP.isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection connection = getConnection()) {
                    String sql = "DELETE FROM SanPham WHERE MaSP = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, maSP);
                        statement.executeUpdate();
                        String tenDM = (String) comboBox.getSelectedItem();
                        JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm thành công.");
                        loadSanPhamToTable(getMaDanhMuc(tenDM, connection));
                        clearTextFields(); 
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa sản phẩm.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa.");
        }
        
    }
    private void clearTextFields() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField.setEnabled(true);
    }
}
