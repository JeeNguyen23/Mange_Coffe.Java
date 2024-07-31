/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.dashboard.forms;

import BUS.Ban;
import DAO.DAO_Pos;
import DAO.DAO_QLBan;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Form_QLBan extends javax.swing.JPanel {

    DAO.DAO_Pos daopos = new DAO_Pos();
    DAO.DAO_QLBan daoban = new DAO_QLBan();
      DefaultTableModel tblModel1;
    String idBanql ="";
    public Form_QLBan() {
        initComponents();
        initTable();
        initableload() ;
    }
     private void initTable() {
        tblModel1 = new DefaultTableModel();
        tblModel1.setColumnIdentifiers(new String[]{"ID_Ban", "Tên Bàn", "Vị Trí", "Trạng Thái"});
        tbl_Ban.setModel(tblModel1);
        tblModel1.setRowCount(0);

    }
      private void initableload() {
  
        ArrayList<Ban> listnv = daopos.getDanhSachBan();
        String tt= "";
        for (Ban nv : listnv) {
           
            if(nv.getTinhTrang() == 1){
                tt = "Đã được đặt";
            }else{
                tt  = "Chưa có người đặt";
            }
            String[] row = new String[]{nv.getId_Ban(), nv.getTen_Ban(), nv.getViTri(), tt};
            tblModel1.addRow(row);
        }
        tblModel1.fireTableDataChanged();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Ban = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tenBan = new javax.swing.JTextField();
        txt_ViTri = new javax.swing.JTextField();
        chk_TrangThai = new javax.swing.JCheckBox();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();

        tbl_Ban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Ban);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setText("QUẢN LÝ BÀN");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel3.setText("Tên Bàn");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel4.setText("Vị Trí");

        chk_TrangThai.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        chk_TrangThai.setText("Trạng thái");
        chk_TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_TrangThaiActionPerformed(evt);
            }
        });

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(chk_TrangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenBan)
                            .addComponent(txt_ViTri))
                        .addGap(134, 134, 134))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addComponent(chk_TrangThai)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(69, 69, 69))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chk_TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_TrangThaiActionPerformed

    private void tbl_BanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BanMouseClicked
        int row = tbl_Ban.getSelectedRow();
        if(row >= 0 ){
            idBanql = tbl_Ban.getValueAt(row, 0).toString();
            txt_tenBan.setText(tbl_Ban.getValueAt(row, 1).toString());
            txt_ViTri.setText(tbl_Ban.getValueAt(row, 2).toString());
            if(tbl_Ban.getValueAt(row, 3).toString().equals("Đã được đặt")){
                chk_TrangThai.setSelected(true);
            }else{
                 chk_TrangThai.setSelected(false);
            }
        }
    }//GEN-LAST:event_tbl_BanMouseClicked

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
    
       String tenString = txt_tenBan.getText();
       String vitri = txt_ViTri.getText();
       int tt= 0;
       if(chk_TrangThai.isSelected()){
           tt = 1;
       }
       daoban.themBan("sd", tenString, vitri, tt);
       tblModel1.removeRow(0);
       initableload() ;
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        String ten_ban = txt_tenBan.getText();
        String Vitri = txt_ViTri.getText();
        int tt = 0;
        if(chk_TrangThai.isSelected()){
           tt = 1;
        }
        daoban.updateBan(idBanql, ten_ban, Vitri, tt);
        tblModel1.removeRow(0);
        initableload() ;
    }//GEN-LAST:event_btn_SuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JCheckBox chk_TrangThai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Ban;
    private javax.swing.JTextField txt_ViTri;
    private javax.swing.JTextField txt_tenBan;
    // End of variables declaration//GEN-END:variables
}
