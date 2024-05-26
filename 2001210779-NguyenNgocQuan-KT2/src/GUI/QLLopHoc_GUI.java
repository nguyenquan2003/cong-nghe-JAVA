package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class QLLopHoc_GUI extends JFrame {
    private JTextField txtClassName, txtStartDate, txtEndDate, txtGradeA, txtGradeB, txtGradeC;
    private JComboBox<String> cmbLecturerID;
    private JButton btnAdd, btnDelete, btnUpdate, btnClear, btnExit;
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public QLLopHoc_GUI() {
        // Initialize UI components
        setTitle("Manage Classes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.add(new JLabel("ten lop hoc:"));
        txtClassName = new JTextField();
        inputPanel.add(txtClassName);
        inputPanel.add(new JLabel("ngay bat dau:"));
        txtStartDate = new JTextField();
        inputPanel.add(txtStartDate);
        inputPanel.add(new JLabel("ngay ket thuc:"));
        txtEndDate = new JTextField();
        inputPanel.add(txtEndDate);
        inputPanel.add(new JLabel("Grade Test A:"));
        txtGradeA = new JTextField();
        inputPanel.add(txtGradeA);
        inputPanel.add(new JLabel("Grade Test B:"));
        txtGradeB = new JTextField();
        inputPanel.add(txtGradeB);
        inputPanel.add(new JLabel("Grade Test C:"));
        txtGradeC = new JTextField();
        inputPanel.add(txtGradeC);
        inputPanel.add(new JLabel("ID giang vien:"));
        cmbLecturerID = new JComboBox<>();
        inputPanel.add(cmbLecturerID);

        btnAdd = new JButton("them");
        btnDelete = new JButton("xoa");
        btnUpdate = new JButton("cap nhat");
        btnClear = new JButton("lam moi");
        btnExit = new JButton("thoat");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Connect to SQL Server database
        try {
        	

            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-K2L5MCI:1433;databaseName=ClassManagement;user=sa;password=1234567890;trustServerCertificate=true;");
            populateLecturers();
            populateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add action listeners
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClass();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClass();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClass();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitProgram();
            }
        });

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                showClassDetails(row);
            }
        });

        setSize(800, 400);
        setVisible(true);
    }

    private void populateLecturers() throws SQLException {
        cmbLecturerID.removeAllItems();
        pstmt = conn.prepareStatement("SELECT LECTURER_ID FROM dbo.LECTURER");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int lecturerId = rs.getInt("LECTURER_ID");
            cmbLecturerID.addItem(String.valueOf(lecturerId));
        }
    }

    private void populateTable() throws SQLException {
        model.setColumnIdentifiers(new String[]{"ma lop hoc", "ma khoa hoc", "ma giang vien", "ten lop", "ngay bat dau", "ngay ket thuc", "Grade Test A", "Grade Test B", "Grade Test C"});
        pstmt = conn.prepareStatement("SELECT * FROM dbo.CLASSES");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(rs.getInt("CLASS_ID"));
            rowData.add(rs.getInt("COURSE_ID"));
            rowData.add(rs.getInt("LECTURER_ID"));
            rowData.add(rs.getString("CLASS_NAME"));
            rowData.add(rs.getString("START_DATE"));
            rowData.add(rs.getString("END_DATE"));
            rowData.add(rs.getDouble("GRADE_TEST_A"));
            rowData.add(rs.getDouble("GRADE_TEST_B"));
            rowData.add(rs.getDouble("GRADE_TEST_C"));
            model.addRow(rowData);
        }
    }

    private void clearFields() {
        txtClassName.setText("");
        txtStartDate.setText("");
        txtEndDate.setText("");
        txtGradeA.setText("");
        txtGradeB.setText("");
        txtGradeC.setText("");
        cmbLecturerID.setSelectedIndex(0);
    }

    private void exitProgram() {
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit the program?", "Exit Program Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    private void showClassDetails(int row) {
        txtClassName.setText(model.getValueAt(row, 3).toString());
        txtStartDate.setText(model.getValueAt(row, 4).toString());
        txtEndDate.setText(model.getValueAt(row, 5).toString());
        txtGradeA.setText(model.getValueAt(row, 6).toString());
        txtGradeB.setText(model.getValueAt(row, 7).toString());
        txtGradeC.setText(model.getValueAt(row, 8).toString());
        cmbLecturerID.setSelectedItem(model.getValueAt(row, 2).toString());
    }

    private void addClass() {
        String className = txtClassName.getText();
        String startDate = txtStartDate.getText();
        String endDate = txtEndDate.getText();
        double gradeA = Double.parseDouble(txtGradeA.getText());
        double gradeB = Double.parseDouble(txtGradeB.getText());
        double gradeC = Double.parseDouble(txtGradeC.getText());
        int lecturerID = Integer.parseInt(cmbLecturerID.getSelectedItem().toString());

        try {
            // Check if start date is before end date
            if (startDate.compareTo(endDate) > 0) {
                JOptionPane.showMessageDialog(this, "Start date must be before end date.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
                pstmt = conn.prepareStatement("INSERT INTO dbo.CLASSES (CLASS_NAME, START_DATE, END_DATE, GRADE_TEST_A, GRADE_TEST_B, GRADE_TEST_C, LECTURER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, className);
                pstmt.setString(2, startDate);
                pstmt.setString(3, endDate);
                pstmt.setDouble(4, gradeA);
                pstmt.setDouble(5, gradeB);
                pstmt.setDouble(6, gradeC);
                pstmt.setInt(7, lecturerID);
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Class added successfully.");
                populateTable();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding class.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void deleteClass() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a class to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int classID = (int) model.getValueAt(selectedRow, 0);

            try {
                pstmt = conn.prepareStatement("DELETE FROM dbo.CLASSES WHERE CLASS_ID = ?");
                pstmt.setInt(1, classID);
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Class deleted successfully.");
                populateTable();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting class.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void updateClass() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a class to update.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int classID = (int) model.getValueAt(selectedRow, 0);
            String className = txtClassName.getText();
            String startDate = txtStartDate.getText();
            String endDate = txtEndDate.getText();
            double gradeA = Double.parseDouble(txtGradeA.getText());
            double gradeB = Double.parseDouble(txtGradeB.getText());
            double gradeC = Double.parseDouble(txtGradeC.getText());
            int lecturerID = Integer.parseInt(cmbLecturerID.getSelectedItem().toString());

            try {
                // Check if start date is before end date
                if (startDate.compareTo(endDate) > 0) {
                    JOptionPane.showMessageDialog(this, "Start date must be before end date.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                pstmt = conn.prepareStatement("UPDATE dbo.CLASSES SET CLASS_NAME = ?, START_DATE = ?, END_DATE = ?, GRADE_TEST_A = ?, GRADE_TEST_B = ?, GRADE_TEST_C = ?, LECTURER_ID = ? WHERE CLASS_ID = ?");
                pstmt.setString(1, className);
                pstmt.setString(2, startDate);
                pstmt.setString(3, endDate);
                pstmt.setDouble(4, gradeA);
                pstmt.setDouble(5, gradeB);
                pstmt.setDouble(6, gradeC);
                pstmt.setInt(7, lecturerID);
                pstmt.setInt(8, classID);
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Class updated successfully.");
                populateTable();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating class.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new QLLopHoc_GUI();
                }
            });
        }
    }
