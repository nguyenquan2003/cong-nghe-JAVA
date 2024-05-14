package Bai3_5;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.QLNhaSach;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.awt.event.ActionEvent;

public class frm_Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_Login;
	private JTextField txt_Password;
	
	private String strTenDangNhap;
	private String strMatKhau;
	private String strTenNguoiDung;
	public boolean bKetQuaDangNhap;
	
	public String getMatKhau() {
		return strMatKhau;
	}
	public String getTenNguoiDung() {
		return strTenDangNhap;
	}
	public boolean getKetQuaDangNhap() {
		return bKetQuaDangNhap;
	}

	/**
	 * Launch the application.
	 */
	public  void main(String[] args) {
		try {
			frm_Login dialog = new frm_Login(null, bKetQuaDangNhap);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frm_Login(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setToolTipText("");
			panel.setBounds(10, 11, 446, 217);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Tên đăng nhập: ");
			lblNewLabel.setBounds(28, 61, 104, 23);
			panel.add(lblNewLabel);
			
			txt_Login = new JTextField();
			txt_Login.setBounds(154, 62, 282, 20);
			panel.add(txt_Login);
			txt_Login.setColumns(10);
			
			JLabel lblMtKhu = new JLabel("Mật khẩu:");
			lblMtKhu.setBounds(28, 121, 85, 23);
			panel.add(lblMtKhu);
			
			txt_Password = new JTextField();
			txt_Password.setColumns(10);
			txt_Password.setBounds(154, 122, 282, 20);
			panel.add(txt_Password);
		}
		{
			
			JPanel btn_Login = new JPanel();
			btn_Login.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btn_Login, BorderLayout.SOUTH);
			JButton okButton = new JButton("Đăng nhập");
			okButton.setActionCommand("OK");
			btn_Login.add(okButton);
			getRootPane().setDefaultButton(okButton);
			okButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        try {
			            // kết nối csdl
			            Properties properties = new Properties();
			            properties.setProperty("user", "sa");
			            properties.setProperty("password", "123");
			            properties.setProperty("encrypt", "true");
			            properties.setProperty("trustServerCertificate", "true");
			            String url = "jdbc:sqlserver://DESKTOP-J9MDADE\\BAO;databaseName=QL_NhaSach;";
			            Connection connection = DriverManager.getConnection(url, properties);
			            java.sql.Statement statement = connection.createStatement();
			            String sql = "SELECT * FROM NguoiDung WHERE TenDangNhap = '" + txt_Login.getText() + "' AND MatKhau = '" + txt_Password.getText() + "'";
			            ResultSet rs = statement.executeQuery(sql);
			            bKetQuaDangNhap = rs.next();

			            connection.close();
			            if (bKetQuaDangNhap) {
			                setVisible(false);
			                MainFrame mf = new MainFrame();
			                mf.getMni_HoaDon().setEnabled(true);
			                mf.getMni_LoaiSach().setEnabled(true);
			                mf.getMni_PhieuNhap().setEnabled(true);
			                mf.getMni_Sach().setEnabled(true);
			                mf.getMni_DangNhap().setEnabled(false);
			                mf.getMni_DangXuat().setEnabled(true);
			                mf.setVisible(true); 
			                JOptionPane.showMessageDialog(btn_Login, "Đăng nhập thành công!");
			            } else {
			                JOptionPane.showMessageDialog(btn_Login, "Tên đăng nhập không đúng!!!!");
			            }

			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(btn_Login, ex.getMessage());
			        }
			    }
			});

			

			{
				JButton btn_Exit = new JButton("Cancel");
				btn_Exit.setActionCommand("Cancel");
				btn_Login.add(btn_Exit);
			}
		}
	}
	
}
