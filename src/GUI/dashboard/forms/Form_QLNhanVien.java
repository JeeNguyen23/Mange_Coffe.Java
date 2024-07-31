/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.dashboard.forms;

import BUS.ChucVuNhanVien;

import BUS.NhanVien;
import DAO.DAO_Quanlynhanvien;
import GUI.dashboard.main.Main;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Form_QLNhanVien extends javax.swing.JPanel {

    DAO_Quanlynhanvien daoqlnv = new DAO_Quanlynhanvien();
    DefaultTableModel tblModel1;
    ArrayList<NhanVien> lstStaff = daoqlnv.getNhanViens();
    Main main;

    public Form_QLNhanVien() {
        initComponents();
        initTable();
        initableload();
        initchucvu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_sua = new javax.swing.JButton();
        rdb_gtnam = new javax.swing.JRadioButton();
        btn_reset = new javax.swing.JButton();
        rdb_gtnu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnv = new javax.swing.JTable();
        txt_maNV = new javax.swing.JTextField();
        txt_TenNV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_cccd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbm_chucvu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_ngaysinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        btn_sua.setText("Update");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        rdb_gtnam.setText("Nam");

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        rdb_gtnu.setText("Nữ");

        tblnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnv);

        txt_maNV.setEditable(false);

        jLabel1.setText("Mã NV");

        jLabel2.setText("Tên NV");

        jLabel3.setText("Ngày Sinh");

        jLabel4.setText("CCCD");

        jLabel5.setText("SĐT");

        btn_them.setText("Insert");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel6.setText("Chức Vụ");

        btn_xoa.setText("Delete");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel7.setText("Giới Tính");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_maNV)
                                    .addComponent(txt_TenNV)
                                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_cccd)
                                    .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(cbm_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdb_gtnam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(rdb_gtnu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_reset)
                            .addComponent(btn_them)
                            .addComponent(btn_xoa)
                            .addComponent(btn_sua))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(txt_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_xoa)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6)
                        .addComponent(cbm_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_sua))
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rdb_gtnam)
                            .addComponent(rdb_gtnu))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btn_reset)
                        .addGap(21, 21, 21))))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void initTable() {
        tblModel1 = new DefaultTableModel();
        tblModel1.setColumnIdentifiers(new String[]{"ID_NhanVien", "Ten", "Ngaysinh", "CCCD", "GioiTinh", "So Dien Thoai", "Chuc Vu"});
        tblnv.setModel(tblModel1);
        tblModel1.setRowCount(0);

    }

    private void initbuttongroup() {
        buttonGroup1.add(rdb_gtnam);
        buttonGroup1.add(rdb_gtnu);
    }

    private void initableload() {
        tblModel1.removeTableModelListener(tblnv);
        ArrayList<NhanVien> listnv = daoqlnv.getNhanViens();
        for (NhanVien nv : listnv) {
            String[] row = new String[]{nv.getId_NV(), nv.getTen_NV(), nv.getNgaySinh(), nv.getCccd(), nv.getGioiTinh(), nv.getSdt(), nv.getChucVu().toString()};
            tblModel1.addRow(row);
        }
        tblModel1.fireTableDataChanged();
    }

    private void initchucvu() {
        for (ChucVuNhanVien cv : daoqlnv.getchucvu()) {
            cbm_chucvu.addItem(cv);
        }
    }
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        String manv, tennv, Ngaysinh, sdt, gioitinh, cccd;
        manv = txt_maNV.getText();
        tennv = txt_TenNV.getText();
        Ngaysinh = txt_ngaysinh.getText();
        sdt = txt_sdt.getText();
        String cv = cbm_chucvu.getSelectedItem().toString();
        if (rdb_gtnam.isSelected()) {
            gioitinh = "Nam";
        } else {
            gioitinh = "Nữ";
        }
        cccd = txt_cccd.getText();
        daoqlnv.update(manv, tennv, Ngaysinh, cccd, sdt, gioitinh, cv);
        JOptionPane.showMessageDialog(this, "Da update thanh cong");
        lstStaff = daoqlnv.getNhanViens();
        initableload();


    }//GEN-LAST:event_btn_suaActionPerformed

    private void tblnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnvMouseClicked

        int row = tblnv.getSelectedRow();
        if (row >= 0) {
            txt_maNV.setText(tblnv.getValueAt(row, 0).toString());
            txt_TenNV.setText(tblnv.getValueAt(row, 1).toString());
            txt_ngaysinh.setText(tblnv.getValueAt(row, 2).toString());
            String gioitinh = tblnv.getValueAt(row, 4).toString();
            if (gioitinh.equals("Nam")) {
                rdb_gtnam.setSelected(true);
                rdb_gtnu.setSelected(false);
            } else {
                rdb_gtnu.setSelected(true);
                rdb_gtnam.setSelected(false);
            }

            txt_sdt.setText(tblnv.getValueAt(row, 5).toString());
            txt_cccd.setText(tblnv.getValueAt(row, 3).toString());
            ArrayList<ChucVuNhanVien> cv = daoqlnv.getchucvu();
            for (int i = 0; i < cv.size(); i++) {
                if (cv.get(i).getTenChucVu().equals(tblnv.getValueAt(row, 6).toString())) {
                    cbm_chucvu.setSelectedIndex(i);
                }
            }

        }
    }//GEN-LAST:event_tblnvMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String manv, tennv, Ngaysinh, sdt, gioitinh, cccd, cv;
        manv = txt_maNV.getText();
        tennv = txt_TenNV.getText();
        Ngaysinh = txt_ngaysinh.getText();
        sdt = txt_sdt.getText();
        cv = cbm_chucvu.getSelectedItem().toString();
        if (rdb_gtnam.isSelected()) {
            gioitinh = "Nam";
        } else {
            gioitinh = "Nữ";
        }
        cccd = txt_cccd.getText();
        daoqlnv.insert(manv, tennv, Ngaysinh, cccd, sdt, gioitinh, cv);
        initableload();
        JOptionPane.showMessageDialog(this, "Da them thanh cong");
        tblModel1.addRow(new Object[]{manv, tennv, Ngaysinh, cccd, sdt, gioitinh, cv});
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed

        txt_TenNV.setText("");
        txt_maNV.setText("");
        txt_cccd.setText("");
        txt_ngaysinh.setText("");
        txt_sdt.setText("");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        String manv;
        manv = txt_maNV.getText();
        int i = JOptionPane.showConfirmDialog(this, "Are you sure?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            daoqlnv.delete(manv);
            txt_TenNV.setText("");
            txt_maNV.setText("");
            txt_cccd.setText("");
            txt_ngaysinh.setText("");
            txt_sdt.setText("");
            buttonGroup1.clearSelection();
            initableload();
            JOptionPane.showMessageDialog(this, "Da xoa thanh cong");
            initableload();
        }
    }//GEN-LAST:event_btn_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Object> cbm_chucvu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb_gtnam;
    private javax.swing.JRadioButton rdb_gtnu;
    private javax.swing.JTable tblnv;
    private javax.swing.JTextField txt_TenNV;
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
