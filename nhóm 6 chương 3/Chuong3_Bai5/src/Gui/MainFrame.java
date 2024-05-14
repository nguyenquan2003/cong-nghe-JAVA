package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JDesktopPane DesktopPanel;

    /**
     * Launch the application.
     */
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
    
    private void mntmLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {
        DanhMucLoaiSach frm = new DanhMucLoaiSach();
        frm.setVisible(true);
        this.DesktopPanel.add(frm);
    }
    
    private void mntmSachActionPerformed(java.awt.event.ActionEvent evt) {
        Sach frm = new Sach();
        frm.setVisible(true);
        this.DesktopPanel.add(frm);
    }
    
    private void mntmHoaDonActionPerformed(java.awt.event.ActionEvent evt) {
        PhieuNhapSach frm = new PhieuNhapSach();
        frm.setVisible(true);
        this.DesktopPanel.add(frm);
    }
    
    private void mntmPhieuNhapSachActionPerformed(java.awt.event.ActionEvent evt) {
        PhieuNhapSach frm = new PhieuNhapSach();
        frm.setVisible(true);
        this.DesktopPanel.add(frm);
    }
    
    public void Dongmntm() {
        this.DesktopPanel.removeAll();
        this.DesktopPanel.repaint();
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnHeThong = new JMenu("Hệ thống");
        menuBar.add(mnHeThong);
        
        JMenuItem mntmDangNhap = new JMenuItem("Đăng nhập");
        mnHeThong.add(mntmDangNhap);
        
        JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
        mnHeThong.add(mntmDangXuat);
        
        JMenuItem mntmThoat = new JMenuItem("Thoát");
        mnHeThong.add(mntmThoat);
        
        JMenu mnQuanLy = new JMenu("Quản lý");
        menuBar.add(mnQuanLy);
        
        JMenuItem mntmLoaiSach = new JMenuItem("Loại sách");
        mntmLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntmLoaiSachActionPerformed(evt);
            }
        });
        mnQuanLy.add(mntmLoaiSach);
        
        JMenuItem mntmSach = new JMenuItem("Sách");
        mntmSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mntmSachActionPerformed(evt);
            }
        });
        mnQuanLy.add(mntmSach);
        
        JMenuItem mntmHoaDon = new JMenuItem("Hoá đơn");
        mntmHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mntmHoaDonActionPerformed(evt);
            }
        });
        mnQuanLy.add(mntmHoaDon);
        
        JMenuItem mntmPhieuNhapSach = new JMenuItem("Phiếu nhập sách");
        mntmPhieuNhapSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mntmPhieuNhapSachActionPerformed(evt);
            }
        });
        mnQuanLy.add(mntmPhieuNhapSach);
        
        JMenu mnHuongDan = new JMenu("Hướng dẫn");
        menuBar.add(mnHuongDan);
        
        JMenuItem mntmThongTin = new JMenuItem("Thông tin");
        mnHuongDan.add(mntmThongTin);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        DesktopPanel = new JDesktopPane();
        contentPane.add(DesktopPanel, BorderLayout.CENTER);
    }

}
