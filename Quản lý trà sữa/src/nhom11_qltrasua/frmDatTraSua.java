/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom11_qltrasua;

import Model.TraSua;
import Model.DatTraSua;
import Controller.DatTraSuaController;
import Model.KetNoi;
import Model.PhanQuyen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Cat Tuong
 */
public class frmDatTraSua extends javax.swing.JFrame {

    
  
    /**
     * Creates new form frmDatTraSua
     */
    public frmDatTraSua() {
        initComponents();
      loadThongTinTraSuaTrongButton();
         makeHoaDonID();
         loadTenNhanVien();
         layTenNhanVien();
//         renderMenu();

        
    }
        
   
    
  
    float tongTien = 0;
    private void loadThongTinTraSuaTrongButton()
    {
        ArrayList<TraSua> lsTenTraSua  = new ArrayList<>();
        DatTraSuaController datTraSuaController = new DatTraSuaController();
       lsTenTraSua = datTraSuaController.getTraSua();
         int x = 10, y = 20 , count = 0;
        for (TraSua traSua: lsTenTraSua)
        {
             ImageIcon imageIcon = new ImageIcon( "src\\Img\\" + traSua.getIdHinh());
                            Image image = imageIcon.getImage().getScaledInstance(50,70, Image.SCALE_SMOOTH);
           JButton   button = new JButton(traSua.getTenTraSua(),new ImageIcon(image));
               pnlMenu.add(button);
               button.setBounds(x, y, 150, 100);
               button.setMargin(new Insets(0,0,0,0));
               button.setPreferredSize(new Dimension(100,50));
               x+= 150;
//               JOptionPane.showMessageDialog(this, x);
               
//               JOptionPane.showMessageDialog(this, y);
               count ++;
               if(count == 3)
               {
                   x = 10;
                           count = 0;
                   y+= 100;
               }
               button.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent ae) {
                      try
                      {
                           ArrayList<TraSua> lsTraSua = new ArrayList<>();
                        
                       lsTraSua = datTraSuaController.getInforTraSua();
                          DefaultTableModel model = (DefaultTableModel) tblDsMuaHang.getModel();
                       for( TraSua ts : lsTraSua)
                       {
                         
                             
//                       JOptionPane.showMessageDialog(null, ts.getTenTraSua());
                           if(ts.getTenTraSua().equals(button.getText()))
                           {
//                                JOptionPane.showMessageDialog(null, ts.getTenTraSua());
//                                JOptionPane.showMessageDialog(null, button.getText());
                               lblMaTraSua.setText(ts.getMaTraSua());
                               lblTenTraSua.setText(ts.getTenTraSua());
                               lblGiaBan.setText(String.valueOf(ts.getGiaBan()));
                               lblNhaCungCap.setText(ts.getTenNCC());
                               float thanhToan = Float.parseFloat(lblTongTien.getText());
                               tongTien = thanhToan + ts.getGiaBan();
                               lblTongTien.setText(String.valueOf(tongTien));
                               
                            ImageIcon imageIcon = new ImageIcon( "src\\Img\\" + ts.getIdHinh());
                            Image image = imageIcon.getImage().getScaledInstance(235,230, Image.SCALE_SMOOTH);
                            lblLogo.setIcon(new ImageIcon(image));
                         break;
                           }
                                
                       }
                       float khuyenMai = 0;
                       if (!txtKhuyenMai.getText().isEmpty())
                       {
                           khuyenMai = Float.parseFloat(txtKhuyenMai.getText());
                       } 
                       
                       int soLuong = 1;
                       float giaBan = Float.parseFloat(lblGiaBan.getText());
                         Object[] objects =   addInforIntoList(lblTenTraSua.getText(),giaBan ,khuyenMai,soLuong );
                               model.addRow(objects);
                               txtKhuyenMai.setText("");
                               
                               
                        
                      }catch (ExceptionInInitializerError e )
                              {
                                 
                              }
                   }
               });
               
        }
       
    }
    
    
    
    public Object[]  addInforIntoList(String tenTraSua, float giaBan, float khuyenMai, int soLuong)
        {
           
             soLuong = 1 ;
           
             if(khuyenMai != 0)
                khuyenMai = giaBan * soLuong * khuyenMai/100;
             float  thanhTien = giaBan * soLuong - khuyenMai;
            Object [] objects = {tenTraSua,giaBan,soLuong,khuyenMai,thanhTien};
            return objects;
        }
       
   
    private void loadInforTraSua()
    {
        ArrayList<TraSua> traSuas = new ArrayList<TraSua>();
        ArrayList<String> lsTenTraSua = new ArrayList<>();
        DatTraSuaController controller = new DatTraSuaController();
      traSuas  = controller.getInforTraSua();
      int dem = controller.getInforTraSua().size();
      
//        JOptionPane.showMessageDialog(this, String.valueOf(dem));
      
    }
    
    public void makeHoaDonID()
    {
       DatTraSuaController controller = new DatTraSuaController();
       String hoaDonID = controller.makeMaHoaDon();
       if(!hoaDonID.equals("Full"))
       txtMaHoaDon.setText(hoaDonID);
       else 
           JOptionPane.showMessageDialog(null, "Dữ liệu đã đầy. Xin vui liên hệ nhà phát triển để mở rộng dữ liệu");
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnXoa = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtKhuyenMai = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMaTraSua = new javax.swing.JLabel();
        lblTenTraSua = new javax.swing.JLabel();
        lblGiaBan = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblNhaCungCap = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlable15 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboNhanVien = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        btnLuuHoaDon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDsMuaHang = new javax.swing.JTable();
        pnlMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnCapNhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hóa đơn");

        btnXoa.setBackground(new java.awt.Color(255, 153, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa khỏi danh sách");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setBackground(new java.awt.Color(153, 255, 153));
        btnTaoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 51, 102));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Khuyến mãi");

        txtKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtKhuyenMai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtKhuyenMaiFocusLost(evt);
            }
        });
        txtKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhuyenMaiActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đặt hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin trà sữa "));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Mã trà sữa");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Tên trà sữa");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Giá bán");

        lblMaTraSua.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        lblTenTraSua.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        lblGiaBan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Nhà cung cấp");

        lblNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        lblLogo.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenTraSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaTraSua, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblTenTraSua))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblGiaBan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblNhaCungCap))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaTraSua)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Tổng tiền:");

        jlable15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlable15.setText("VND");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 0, 0));
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTien.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11)
                .addGap(27, 27, 27)
                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jlable15)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlable15))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("%");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Mã hóa đơn");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Tên nhân viên");

        cboNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Số điện thoại khách hàng");

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusLost(evt);
            }
        });
        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Tên khách hàng");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });

        txtTenKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenKhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenKhachHangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenKhachHangFocusLost(evt);
            }
        });

        btnLuuHoaDon.setBackground(new java.awt.Color(102, 255, 255));
        btnLuuHoaDon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLuuHoaDon.setText("Lưu hóa đơn");
        btnLuuHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuHoaDonActionPerformed(evt);
            }
        });

        tblDsMuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên trà sữa", "Giá bán", "Số lượng", "Khuyến mãi", "Thành tiền"
            }
        ));
        tblDsMuaHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsMuaHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDsMuaHang);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Số lượng");

        txtSoLuong.setEditable(false);
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setEnabled(false);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel10)
                                .addGap(30, 30, 30)
                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCapNhat)
                            .addComponent(jLabel9))))
                .addGap(13, 13, 13)
                .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void layTenNhanVien()
    {
        int viTri =0;
       String tenNV = null;
        try
        {
            DatTraSuaController controller = new DatTraSuaController();
            PhanQuyen phanQuyen = new PhanQuyen();
            ArrayList<String> lsTenNhanVien = new ArrayList<>();
            lsTenNhanVien = controller.getTenNhanVien();
            Connection conn = KetNoi.connectToDatabase();
            String sql = "select TENNV FROM NHANVIEN JOIN DANGNHAP ON DANGNHAP.MANV = NHANVIEN.MANV and DANGNHAP.TAIKHOAN = '"+phanQuyen.getTaiKhoanCu()+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
               tenNV = rs.getString("TENNV");
            
            for (int i = 0; i< lsTenNhanVien.size();i++)
            {
                if(lsTenNhanVien.get(i).equals(tenNV))
                    viTri = i;
            }
             cboNhanVien.setSelectedIndex(viTri);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmDatTraSua.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        
       
     DefaultTableModel model = (DefaultTableModel) tblDsMuaHang.getModel();
     
        float tongTien  = Float.parseFloat(lblTongTien.getText().toString());
       
      int indexDong= tblDsMuaHang.getSelectedRow();
      
      if(indexDong != -1)
      {
         
          float donGia = Float.parseFloat( model.getValueAt(indexDong, 1).toString());
          float khuyenMai = Float.parseFloat( model.getValueAt(indexDong, 3).toString());
          int soLuong = Integer.parseInt(model.getValueAt(indexDong, 2).toString());
          

          tongTien = tongTien - (donGia *soLuong) + khuyenMai;
           model.removeRow(indexDong);
      }
      else 
      {
          JOptionPane.showMessageDialog(this, "Bạn chưa chọn mặt hàng cần xóa");
          return;
      }
        lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
//     /
PhanQuyen  phanQuyen = new PhanQuyen();
//JOptionPane.showMessageDialog(this, phanQuyen.getTaiKhoanCu());
if(!phanQuyen.getTaiKhoanCu().equals("admin"))
{
      
        
         frmMainNhanVien nhanVien = new frmMainNhanVien();
    nhanVien.setVisible(true);
    this.dispose();
}
else 
{
    frmMain m = new frmMain();
        m.setVisible(true);
        this.dispose();
     }

    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
        // TODO add your handling code here:
         for(char c : txtSoDienThoai.getText().toCharArray())
            {
               
              if(!Character.isDigit(c))
                 { JOptionPane.showMessageDialog(null, "Số điện thoại phải là số");
                             txtSoDienThoai.requestFocus();
              return;
               }
              
            }
            
            if(!(txtSoDienThoai.getText().length() == 10))
            {
                JOptionPane.showMessageDialog(null, "Số điện thoại phải 10 số");
                txtSoDienThoai.requestFocus();
                return;
            }
             String soDau = txtSoDienThoai.getText().substring(0, 1);
             if (Integer.parseInt(soDau) != 0)
             {
                 JOptionPane.showMessageDialog(null, "Đầu số điện thoại phải là 0");
                 txtSoDienThoai.requestFocus();
                return;
             }
      if(txtTenKhachHang.getText().isEmpty())
      {
           DatTraSuaController controller = new DatTraSuaController();
       txtTenKhachHang.setText(controller.getTenKH(txtSoDienThoai.getText()));
      }
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void txtKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhuyenMaiActionPerformed

    
  
    
    private void txtKhuyenMaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKhuyenMaiFocusLost
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblDsMuaHang.getModel();
        int chon = tblDsMuaHang.getSelectedRow();
        if(txtSoLuong.getText().isEmpty())
            txtSoLuong.setText("1");
        if(chon != -1)
        {
            
            //N?u txt khuy?n m�i kh�c r?ng 
          if(!txtKhuyenMai.getText().isEmpty())
          {
              // l?y th�ng tin c� s?n t? b?ng tblDsMuaHang
              float giaBan = Float.parseFloat(model.getValueAt(chon, 1).toString());
          float khuyenMai = Float.parseFloat(txtKhuyenMai.getText());
          int soLuong = Integer.parseInt(model.getValueAt(chon, 2).toString());
          Object[] objects = addInforIntoList(model.getValueAt(chon,0).toString(), giaBan, khuyenMai,soLuong);
          float giaKhuyenMai = Float.parseFloat(objects[3].toString());
            // c?p nh?t l?i gi� khuy?n m�i 
          model.setValueAt(giaKhuyenMai, chon, 3);
          
          tongTien = tongTien - giaKhuyenMai;
          lblTongTien.setText(String.valueOf(tongTien));
          }
          else  {
                  JOptionPane.showMessageDialog(null, "Bạn chưa cập nhật khuyến mãi");
                                return;

                  }// n?u kh�ng ch?n th� tr? v?
        }
        // c�i khuy?n m�i = r?ng ?? c�n nh?p ti?p :)))
        txtKhuyenMai.setText("");
    }//GEN-LAST:event_txtKhuyenMaiFocusLost

    private void tblDsMuaHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsMuaHangMouseClicked
        // TODO add your handling code here:
        
         if(txtTenKhachHang.getText().isEmpty())
        {
            txtTenKhachHang.requestFocus();
        }
         
        int indexRow = tblDsMuaHang.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblDsMuaHang.getModel();
        
        if (indexRow != -1)
        {
            txtSoLuong.setEditable(true);
            btnCapNhat.setEnabled(true);
            
       
            
        }
        else 
            return;
    }//GEN-LAST:event_tblDsMuaHangMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        if(txtSoLuong.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Số lượng không trống");
            return;
        }
          for(char c : txtSoLuong.getText().toCharArray())
            {
               
             if(!Character.isDigit(c))
             { JOptionPane.showMessageDialog(null, "Số lượng phải là số");
                             txtSoLuong.requestFocus();
             return ;
             }
            }
           int indexRow = tblDsMuaHang.getSelectedRow();
           TraSua traSua = new TraSua();
        DefaultTableModel model = (DefaultTableModel) tblDsMuaHang.getModel();
                  
        if(txtSoLuong.getText().isEmpty())
            txtSoLuong.setText("1");
        model.setValueAt(txtSoLuong.getText(), indexRow, 2);
        int soLuong = Integer.parseInt(tblDsMuaHang.getValueAt(indexRow, 2).toString());
    Float giaBan =  Float.parseFloat(tblDsMuaHang.getValueAt(indexRow, 1).toString());
    Float khuyenMai = Float.parseFloat(tblDsMuaHang.getValueAt(indexRow, 3).toString());
    Float giaKhuyenMai = khuyenMai * soLuong;
                     float thanhTien = giaBan * soLuong - giaKhuyenMai;
                     model.setValueAt(giaKhuyenMai, indexRow, 3);
                     model.setValueAt(thanhTien, indexRow, 4);

             lblTongTien.setText("0.0");
//             DatTraSua datTraSua = datTraSuas.get(indexRow -1 );
//             datTraSua.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
//             model.setRowCount(0);
//             for (DatTraSua dts : datTraSuas)
//             {
//                 Object[] objects = {dts.getTenTraSua(),dts.getDonGia(),dts.getSoLuong(),dts.getKhuyenMai()};
//                 model.addRow(objects);
//             }
tongTien = 0;
for (int i = 0; i< tblDsMuaHang.getRowCount();i++)
{
//     soLuong = Float.parseFloat(tblDsMuaHang.getValueAt(i, 2).toString());
//     giaBan =  Float.parseFloat(tblDsMuaHang.getValueAt(i, 1).toString());
//    Float khuyenMai = Float.parseFloat(tblDsMuaHang.getValueAt(i, 3).toString());
    
//    
    tongTien = tongTien +Float.parseFloat(tblDsMuaHang.getValueAt(i, 4).toString());
}
txtSoLuong.setText("");
    lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnLuuHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuHoaDonActionPerformed
        // TODO add your handling code here:
        String maHDB = txtMaHoaDon.getText();
        String sdt = txtSoDienThoai.getText();
       DatTraSuaController controller = new DatTraSuaController();
       DatTraSua  datTraSua = null;
        String tenNhanVien = cboNhanVien.getSelectedItem().toString();
       
         float khuyenMai  = 0;   float tongTien = 0;
        for(int i = 0; i< tblDsMuaHang.getRowCount(); i++)
                {
                   
                  khuyenMai  = khuyenMai + Float.parseFloat(tblDsMuaHang.getValueAt(i, 3).toString());
                  tongTien = tongTien + Float.parseFloat(tblDsMuaHang.getValueAt(i, 4).toString());
        
                }
                 datTraSua = new DatTraSua(maHDB,sdt,tenNhanVien,khuyenMai,tongTien);
                controller.themHoaDon(datTraSua);

                
               
        for (int i = 0; i< tblDsMuaHang.getRowCount();i++)
        {
            
            String tenTraSua = tblDsMuaHang.getValueAt(i, 0).toString();
            int soLuong = Integer.parseInt(tblDsMuaHang.getValueAt(i, 2).toString());
            khuyenMai = Float.parseFloat(tblDsMuaHang.getValueAt(i, 3).toString());
            float thanhTien = Float.parseFloat(tblDsMuaHang.getValueAt(i,4).toString());
            datTraSua = new DatTraSua(maHDB, tenTraSua, soLuong, khuyenMai, thanhTien);
            controller.themChiTietHoaDon(datTraSua);
        }
        
    }//GEN-LAST:event_btnLuuHoaDonActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void txtTenKhachHangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKhachHangFocusGained
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_txtTenKhachHangFocusGained

    private void txtTenKhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKhachHangFocusLost
        // TODO add your handling code here:
        DatTraSuaController controller = new DatTraSuaController();
        String tenKhachHang = controller.getTenKH(txtSoDienThoai.getText());
        
      
    if(txtTenKhachHang.getText().isEmpty())
    {
            JOptionPane.showMessageDialog(this, "Tên khách hàng trống. Cần nhập tên khách hàng");
            return;
    }//GEN-LAST:event_txtTenKhachHangFocusLost
    else if(txtTenKhachHang.getText().equals(tenKhachHang) )
    {
        return;
    }
    else 
    {
        int trangThai = 1;
            controller.themKhachHangMoi(txtTenKhachHang.getText(), txtSoDienThoai.getText(),trangThai);
    }
    }
    
    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        NhapHoaDon nhapHoaDon = new NhapHoaDon();
        nhapHoaDon.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDatTraSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDatTraSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDatTraSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDatTraSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDatTraSua().setVisible(true);
            }
        });
    }
    private void loadTenNhanVien()
    {
        ArrayList<String> lsTenNhanVien  = new ArrayList<>();
        DatTraSuaController datTraSuaController = new DatTraSuaController();
        lsTenNhanVien = datTraSuaController.getTenNhanVien();
        
        for (String s : lsTenNhanVien)
        {
            cboNhanVien.addItem(s);
        }
    }
    
    public void resetForm()
    {
        DatTraSuaController controller = new DatTraSuaController();
        txtMaHoaDon.setText(controller.makeMaHoaDon());
       
        txtKhuyenMai.setText("");
        
        
    }
    
         private boolean kiemTraThongTin()
    {
        for(char c : txtSoDienThoai.getText().toCharArray())
            {
               
             if(!Character.isDigit(c))
             { JOptionPane.showMessageDialog(null, "Số điện thoại phải là số ");
                             txtSoDienThoai.requestFocus();
             return false;
             }
            }
            
            if(!(txtSoDienThoai.getText().length() == 10))
            {
                JOptionPane.showMessageDialog(null, "Số điện thoại phải 10 số");
                txtSoDienThoai.requestFocus();
                return false;
            }
             String soDau = txtSoDienThoai.getText().substring(0, 1);
             if (Integer.parseInt(soDau) != 0)
             {
                 JOptionPane.showMessageDialog(null, "Số điện thoại số đầu phải là số 0");
                 txtSoDienThoai.requestFocus();
                return false;
                
             }
             
             if(txtTenKhachHang.getText().isEmpty())
             {
                   JOptionPane.showMessageDialog(null, "Tên khách hàng không được trống");
                 txtTenKhachHang.requestFocus();
                 return false;
             }
             
            if(txtKhuyenMai.getText().isEmpty())
             {
                   JOptionPane.showMessageDialog(null, "Khuyến mãi không được trống");
                 txtKhuyenMai.requestFocus();
                 return false;
             }
             
            return true; 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuuHoaDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlable15;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMaTraSua;
    private javax.swing.JLabel lblNhaCungCap;
    private javax.swing.JLabel lblTenTraSua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JTable tblDsMuaHang;
    private javax.swing.JTextField txtKhuyenMai;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
