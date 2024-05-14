import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String employeeId;
    private String fullName;
    private String hireDate;
    private String birthYear;
    private Department department;

    public Employee(String employeeId, String fullName, String hireDate, String birthYear, Department department) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.hireDate = hireDate;
        this.birthYear = birthYear;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public Department getDepartment() {
        return department;
    }
}

class Department {
    private String departmentId;
    private String departmentName;

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

public class EmployeeManagementApp extends JFrame {
    private DefaultListModel<String> employeeListModel;
    private ArrayList<Employee> employeeList;
    private JComboBox<String> departmentComboBox;

    private JTextField txtEmployeeId, txtFullName, txtHireDate, txtBirthYear, txtDepartment;

    public EmployeeManagementApp() {
        super("Quản lý nhân viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel filterLabel = new JLabel("Chọn phòng ban:");
        filterPanel.add(filterLabel);

        departmentComboBox = new JComboBox<>();
        departmentComboBox.addItem("Tất cả"); // Add an option to show all employees
        filterPanel.add(departmentComboBox);

        JPanel employeeListPanel = new JPanel(new BorderLayout());
        employeeListPanel.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));

        employeeListModel = new DefaultListModel<>();
        JList<String> employeeJList = new JList<>(employeeListModel);
        employeeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane employeeScrollPane = new JScrollPane(employeeJList);
        employeeListPanel.add(employeeScrollPane, BorderLayout.CENTER);

        JPanel employeeDetailsPanel = new JPanel(new GridBagLayout());
        employeeDetailsPanel.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblEmployeeId = new JLabel("Mã nhân viên:");
        employeeDetailsPanel.add(lblEmployeeId, gbc);

        gbc.gridx = 1;
        txtEmployeeId = new JTextField(20);
        txtEmployeeId.setEditable(false);
        employeeDetailsPanel.add(txtEmployeeId, gbc);

        JLabel lblFullName = new JLabel("Họ tên:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        employeeDetailsPanel.add(lblFullName, gbc);

        gbc.gridx = 1;
        txtFullName = new JTextField(20);
        txtFullName.setEditable(false);
        employeeDetailsPanel.add(txtFullName, gbc);

        JLabel lblHireDate = new JLabel("Ngày VL:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        employeeDetailsPanel.add(lblHireDate, gbc);

        gbc.gridx = 1;
        txtHireDate = new JTextField(20);
        txtHireDate.setEditable(false);
        employeeDetailsPanel.add(txtHireDate, gbc);

        JLabel lblBirthYear = new JLabel("Năm sinh:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        employeeDetailsPanel.add(lblBirthYear, gbc);

        gbc.gridx = 1;
        txtBirthYear = new JTextField(20);
        txtBirthYear.setEditable(false);
        employeeDetailsPanel.add(txtBirthYear, gbc);

        gbc.gridx = 1;
        txtDepartment = new JTextField(20);
        txtDepartment.setEditable(false);
        employeeDetailsPanel.add(txtDepartment, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnDeleteEmployee = new JButton("Xóa");
        JButton btnExit = new JButton("Thoát");
        buttonPanel.add(btnDeleteEmployee);
        buttonPanel.add(btnExit);

        add(filterPanel, BorderLayout.NORTH);
        add(employeeListPanel, BorderLayout.CENTER);
        add(employeeDetailsPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load employees from file
        loadEmployeesFromFile("src/ThongTin.txt");

        // Add employees to the list
        for (Employee employee : employeeList) {
            employeeListModel.addElement(employee.getFullName());
        }

        // Update departmentComboBox with department names
        updateDepartmentComboBox();

        employeeJList.addListSelectionListener(e -> {
            int selectedIndex = employeeJList.getSelectedIndex();
            if (selectedIndex != -1) {
                displayEmployeeDetails(selectedIndex);
            }
        });

        departmentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDepartment = (String) departmentComboBox.getSelectedItem();
                filterEmployeesByDepartment(selectedDepartment);
            }
        });

        btnDeleteEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = employeeJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    employeeListModel.remove(selectedIndex);
                    employeeList.remove(selectedIndex);
                    clearEmployeeDetails();
                } else {
                    JOptionPane.showMessageDialog(EmployeeManagementApp.this, "Please select an employee to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void loadEmployeesFromFile(String filename) {
        employeeList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String employeeId = parts[0];
                    String fullName = parts[1];
                    String hireDate = parts[2];
                    String birthYear = parts[3];
                    String departmentName = parts[4];
                    Department department = new Department("", departmentName); // Department ID is not used here
                    Employee employee = new Employee(employeeId, fullName, hireDate, birthYear, department);
                    employeeList.add(employee);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "File not found: " + filename, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDepartmentComboBox() {
        // Clear existing items
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem("All");
        // Add department names from employeeList
        for (Employee employee : employeeList) {
            Department department = employee.getDepartment();
            if (!containsItem(departmentComboBox, department.getDepartmentName())) {
                departmentComboBox.addItem(department.getDepartmentName());
            }
        }
    }
    
    private boolean containsItem(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    private void displayEmployeeDetails(int index) {
        if (index >= 0 && index < employeeList.size()) {
            Employee employee = employeeList.get(index);
            txtEmployeeId.setText(employee.getEmployeeId());
            txtFullName.setText(employee.getFullName());
            txtHireDate.setText(employee.getHireDate());
            txtBirthYear.setText(employee.getBirthYear());
        }
    }

    private void clearEmployeeDetails() {
        txtEmployeeId.setText("");
        txtFullName.setText("");
        txtHireDate.setText("");
        txtBirthYear.setText("");
        txtDepartment.setText("");
    }

    // Hàm so sánh hai đối tượng Department
    private boolean isSameDepartment(Department department1, Department department2) {
        if (department1 == null && department2 == null) {
            return true;
        }
        if (department1 == null || department2 == null) {
            return false;
        }
        return department1.getDepartmentId().equals(department2.getDepartmentId()) &&
            department1.getDepartmentName().equals(department2.getDepartmentName());
    }
    
    // Lọc danh sách nhân viên theo phòng ban
    private void filterEmployeesByDepartment(String departmentName) {
        employeeListModel.clear(); // Xóa danh sách hiện tại
    
        if (departmentName.equals("All")) {
            // Hiển thị tất cả nhân viên
            for (Employee employee : employeeList) {
                employeeListModel.addElement(employee.getFullName());
            }
        } else {
            // Lọc theo tên phòng ban
            for (Employee employee : employeeList) {
                Department employeeDepartment = employee.getDepartment();
                if (employeeDepartment != null && isSameDepartment(employeeDepartment, new Department("", departmentName))) {
                    employeeListModel.addElement(employee.getFullName());
                }
            }
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagementApp app = new EmployeeManagementApp();
            app.setVisible(true);
        });
    }
}
