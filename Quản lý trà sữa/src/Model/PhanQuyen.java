/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nguyen Cat Tuong
 */
public class PhanQuyen {
    
  private static String taiKhoan;

    public String getTaiKhoanCu() {
        return taiKhoan;
    }

    public void setTaiKhoanCu(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

   public static void xoaPhanQuyen()
   {
       taiKhoan = null;
   }
    
    
    
}
