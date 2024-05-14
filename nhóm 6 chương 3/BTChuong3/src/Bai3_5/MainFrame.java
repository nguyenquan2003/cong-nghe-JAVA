package Bai3_5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.frmHoaDon;
import gui.frmLoaiSach;
import gui.frmPhieuNhapSach;
import gui.frmSach;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JMenuItem mni_DangNhap;
    private JMenuItem mni_DangXuat;
    private JMenuItem mni_LoaiSach;
    private JMenuItem mni_Sach;
    private JMenuItem mni_HoaDon;
    private JMenuItem mni_PhieuNhap;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		JMenuBar menuBar1 = new JMenuBar();
		menuBar1.setBounds(0, 0, 674, 29);
		contentPane.add(menuBar1);

        JMenu mn_HeThong = new JMenu("Hệ thống");
        menuBar1.add(mn_HeThong);

        mni_DangNhap = new JMenuItem("Đăng nhập");
        mn_HeThong.add(mni_DangNhap);

        mni_DangXuat = new JMenuItem("Đăng xuất");
        mni_DangXuat.setEnabled(false);
        mn_HeThong.add(mni_DangXuat);

        JMenuItem mni_Thoat = new JMenuItem("Thoát");
        mn_HeThong.add(mni_Thoat);

        JMenu mn_QuanLy = new JMenu("Quản lý");
        menuBar1.add(mn_QuanLy);

        mni_LoaiSach = new JMenuItem("Loại Sách");
        mni_LoaiSach.setEnabled(false);
        mn_QuanLy.add(mni_LoaiSach);

        mni_Sach = new JMenuItem("Sách");
        mni_Sach.setEnabled(false);
        mn_QuanLy.add(mni_Sach);

        mni_HoaDon = new JMenuItem("Hóa đơn");
        mni_HoaDon.setEnabled(false);
        mn_QuanLy.add(mni_HoaDon);

        mni_PhieuNhap = new JMenuItem("Phiếu nhập sách");
        mni_PhieuNhap.setEnabled(false);
        mn_QuanLy.add(mni_PhieuNhap);

        JMenu mn_HuongDan = new JMenu("Hướng dẫn");
        menuBar1.add(mn_HuongDan);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 26, 674, 544);
		contentPane.add(desktopPane);
		desktopPane.setLayout(new BoxLayout(desktopPane, BoxLayout.X_AXIS));

        mni_DangNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final frm_Login frm = new frm_Login(MainFrame.this, true);
                frm.setVisible(true);
                setVisible(false);
            }
        });

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

    public JMenuItem getMni_DangNhap() {
        return mni_DangNhap;
    }

    public JMenuItem getMni_DangXuat() {
        return mni_DangXuat;
    }

    public JMenuItem getMni_LoaiSach() {
        return mni_LoaiSach;
    }

    public JMenuItem getMni_Sach() {
        return mni_Sach;
    }

    public JMenuItem getMni_HoaDon() {
        return mni_HoaDon;
    }

    public JMenuItem getMni_PhieuNhap() {
        return mni_PhieuNhap;
    }
}
