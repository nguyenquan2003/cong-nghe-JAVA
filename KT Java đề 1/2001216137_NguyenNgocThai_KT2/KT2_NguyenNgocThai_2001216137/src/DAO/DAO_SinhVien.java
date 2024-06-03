package DAO;

import POJO.SinhVienPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;

public class DAO_SinhVien implements DAO_Interface<SinhVienPOJO> {
    private static final Logger LOGGER = Logger.getLogger(DAO_SinhVien.class.getName());

    private static DAO_SinhVien instance;

    private DAO_SinhVien() {}

    public static DAO_SinhVien getInstance() {
        if (instance == null) {
            instance = new DAO_SinhVien();
        }
        return instance;
    }

    @Override
    public int Them(SinhVienPOJO sv) {
        String sql = "INSERT INTO students (first_name, last_name, gender, phone_number, birthday) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectDB.open();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, sv.getFirstName());
            pst.setString(2, sv.getLastName());
            pst.setString(3, sv.getGender());
            pst.setString(4, sv.getPhoneNumber());
            pst.setDate(5, new java.sql.Date(sv.getBirthday().getTime()));

            return pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi thêm sinh viên", ex);
        }
        return 0;
    }

    @Override
    public int Sua(SinhVienPOJO sv) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, gender = ?, phone_number = ?, birthday = ? WHERE id = ?";
        try (Connection con = ConnectDB.open();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, sv.getFirstName());
            pst.setString(2, sv.getLastName());
            pst.setString(3, sv.getGender());
            pst.setString(4, sv.getPhoneNumber());
            pst.setDate(5, new java.sql.Date(sv.getBirthday().getTime()));
            pst.setInt(6, sv.getId());

            return pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi cập nhật sinh viên", ex);
        }
        return 0;
    }

    @Override
    public int Xoa(SinhVienPOJO sv) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = ConnectDB.open();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, sv.getId());
            return pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi xóa sinh viên", ex);
        }
        return 0;
    }

    @Override
    public ArrayList<SinhVienPOJO> ShowAll() {
        String sql = "SELECT id, first_name, last_name, gender, phone_number, birthday FROM students";
        ArrayList<SinhVienPOJO> listSV = new ArrayList<>();

        try (Connection con = ConnectDB.open();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String gender = rs.getString("gender");
                String phoneNumber = rs.getString("phone_number");
                java.util.Date birthday = rs.getDate("birthday");

                SinhVienPOJO sv = new SinhVienPOJO(id, firstName, lastName, gender, phoneNumber, birthday);
                listSV.add(sv);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi lấy thông tin sinh viên", ex);
        }
        return listSV;
    }
}
