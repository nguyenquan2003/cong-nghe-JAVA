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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;

public class Bai3_2_TimKiem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_timkiem;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai3_2_TimKiem frame = new Bai3_2_TimKiem();
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
	public Bai3_2_TimKiem() {
		setTitle("Tìm kiếm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập dữ liệu cần tìm");
		lblNewLabel.setBounds(35, 22, 143, 14);
		contentPane.add(lblNewLabel);
		
		txt_timkiem = new JTextField();
		txt_timkiem.setBounds(166, 19, 192, 20);
		contentPane.add(txt_timkiem);
		txt_timkiem.setColumns(10);
		
		JButton btn_tim = new JButton("Tìm");
		btn_tim.setBounds(371, 11, 65, 37);
		contentPane.add(btn_tim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 469, 140);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3", "Ti\u00EAu \u0111\u1EC1", "Lo\u1EA1i", "N\u0103m XB"
			}
		));
		scrollPane.setViewportView(table);
		LoadDuLieu();
		btn_tim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputSearch=txt_timkiem.getText();
				if(inputSearch.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu cần tìm!!!","Lỗi",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					Connection connection=getConnection();
					PreparedStatement statement;
					String searchQuery = "SELECT * FROM CDDVDCollection WHERE Ma LIKE ? OR TieuDe LIKE ? OR LoaiDia LIKE ? OR NamXuatBan = ?";
					statement = connection.prepareStatement(searchQuery);
					statement.setString(1, "%" + inputSearch + "%"); 
					statement.setString(2, "%" + inputSearch + "%"); 
					statement.setString(3, "%" + inputSearch + "%"); 
		            try {
		                int namXB = Integer.parseInt(inputSearch);
		                statement.setInt(4, namXB);
		            } catch (NumberFormatException ex) {
		                statement.setInt(4, 0);
		            }
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
				}catch (Exception ex) {
					ex.printStackTrace();
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
            String url = "jdbc:sqlserver://DESKTOP-J9MDADE\\BAO;databaseName=QLDIA;";
            connection = DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void LoadDuLieu() {
    	try {
    		Connection connection=getConnection();
    		String query="SELECT * FROM CDDVDCollection";
    		PreparedStatement statement =connection.prepareStatement(query);
    		ResultSet resultSet=statement.executeQuery();
    		DefaultTableModel model=(DefaultTableModel) table.getModel();
    		model.setRowCount(0);
    		while(resultSet.next()) {
    			String ma=resultSet.getString("Ma");
    			String tieuDe=resultSet.getString("TieuDe");
    			String loaiDia=resultSet.getString("LoaiDia");
    			int namXB=resultSet.getInt("NamXuatBan");
    			model.addRow(new Object[] {ma,tieuDe,loaiDia,namXB});
    		}
    		connection.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }
}
