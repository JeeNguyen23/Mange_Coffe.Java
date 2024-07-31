/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.dashboard.forms;

import BUS.HoaDon;
import DAO.DAO_Pos;
import DAO.DAO_QLDoanhThu;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class From_QLDoanhThu extends javax.swing.JPanel {

    DefaultTableModel tblModel1;
    DAO_QLDoanhThu daodt = new DAO_QLDoanhThu();
    DAO_Pos pos = new DAO_Pos();
    public From_QLDoanhThu() {
        initComponents();
        initTable();
         initableload();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hd = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_doanhthu = new javax.swing.JTextField();
        btn_xuatfilexcel = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel4.setText("DOANH THU");

        tb_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_hd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(410, 410, 410))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Tổng doanh thu ");

        btn_xuatfilexcel.setText("Xuất File Excel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_xuatfilexcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addComponent(txt_doanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_doanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_xuatfilexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void initTable() {
        tblModel1 = new DefaultTableModel();
        tblModel1.setColumnIdentifiers(new String[]{"ID Hóa Đơn", "ID_Bàn", "Ngày", "Tiền Giảm", "Mã Nhân Viên", "Trạng Thái", "Tổng tiền"});
        tb_hd.setModel(tblModel1);
        tblModel1.setRowCount(0);
    }
     private void initableload() {
        double tong = 0;
        for (HoaDon nv : pos.getHoaDon()) {
           
           if(nv.getTrangThai().equals("Da thanh toan")){
            String idhoadon,IdBan,Ngay,tthai,maNV;
            String tienGiam,TongTien;
            idhoadon = nv.getID_HoaDon();
            IdBan = nv.getID_Ban().getId_Ban();
            Ngay = nv.getNgayThanhToan();
            tthai = nv.getTrangThai();
            maNV  = nv.getMaNV().getId_NV();
     
            tienGiam = String.valueOf(nv.getTienGiam());
            TongTien = String.valueOf(nv.getTongtien());
            tong += nv.getTongtien();
            
            String[] row = new String[]{idhoadon, IdBan, Ngay,tienGiam,maNV, tthai,TongTien};
            tblModel1.addRow(row);
               
           }
            
        }
        String tong1 = String.valueOf(tong);
        tblModel1.fireTableDataChanged();
        txt_doanhthu.setText(tong1);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xuatfilexcel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_hd;
    private javax.swing.JTextField txt_doanhthu;
    // End of variables declaration//GEN-END:variables
}
