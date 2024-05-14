package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;

public class QLNhaSach extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNhaSach frame = new QLNhaSach();
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
	public QLNhaSach() {
		setTitle("Chương 3 bài 6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar1 = new JMenuBar();
		menuBar1.setBounds(0, 0, 424, 28);
		contentPane.add(menuBar1);
		
		JMenu mn_HeThong = new JMenu("Hệ thống");
		menuBar1.add(mn_HeThong);
		
	
		JMenuItem mni_DangNhap = new JMenuItem("Đăng nhập");
		mn_HeThong.add(mni_DangNhap);
		
		JMenuItem mni_DangXuat = new JMenuItem("Đăng xuất");
		mni_DangXuat.setEnabled(false);
		mn_HeThong.add(mni_DangXuat);
		
		JMenuItem mni_Thoat = new JMenuItem("Thoát");
		mni_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(rootPane, 
		                "Bạn có chắc chắn muốn thoát chương trình hay không?", "Xác nhận thoát",
		                JOptionPane.YES_NO_OPTION);

		            if (confirmed == JOptionPane.YES_OPTION) {
		                System.exit(0); 
		            }
			}
		});
		mn_HeThong.add(mni_Thoat);
		
		JMenu mn_QuanLy = new JMenu("Quản lý");
		menuBar1.add(mn_QuanLy);
		
		JMenuItem mni_LoaiSach = new JMenuItem("Loại Sách");
		mn_QuanLy.add(mni_LoaiSach);
		
		JMenuItem mni_Sach = new JMenuItem("Sách");
		mn_QuanLy.add(mni_Sach);
		
		JMenuItem mni_HoaDon = new JMenuItem("Hóa đơn");
		mn_QuanLy.add(mni_HoaDon);
		
		JMenuItem mni_PhieuNhap = new JMenuItem("Phiếu nhập sách");
		mn_QuanLy.add(mni_PhieuNhap);
		
		JMenu mn_HuongDan = new JMenu("Hướng dẫn");
		menuBar1.add(mn_HuongDan);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 26, 674, 544);
		contentPane.add(desktopPane);
		desktopPane.setLayout(new BoxLayout(desktopPane, BoxLayout.X_AXIS));
		
		mni_DangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mni_HoaDon.setEnabled(false);
                mni_LoaiSach.setEnabled(false);
                mni_PhieuNhap.setEnabled(false);
                mni_Sach.setEnabled(false);
                mni_DangXuat.setEnabled(false);
                mni_DangNhap.setEnabled(true);
			}
		});
		
		mni_LoaiSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoaiSach frm1=new frmLoaiSach();
				desktopPane.removeAll();
				frm1.setVisible(true);
				desktopPane.add(frm1);
			}
		});
		mni_Sach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				frmSach frm1=new frmSach();
				frm1.setVisible(true);
				desktopPane.add(frm1);
			}
		});
		mni_PhieuNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				frmPhieuNhapSach frm1=new frmPhieuNhapSach();
				frm1.setVisible(true);
				desktopPane.add(frm1);
			}
		});
		mni_HoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				frmHoaDon frm1=new frmHoaDon();
				frm1.setVisible(true);
				desktopPane.add(frm1);
			}
		});
	}
}


