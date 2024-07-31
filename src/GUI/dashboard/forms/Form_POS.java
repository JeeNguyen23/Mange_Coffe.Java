package GUI.dashboard.forms;

import BUS.Ban;
import BUS.HoaDon;
import BUS.LoaiSanPham;
import BUS.SanPham;
import BUS.SanPhamChuaThanhToan;
import DAO.DAO_Pos;
import DAO.DAO_Quanlysanpham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import DAO.DataConnection;
import GUI.Login.main.Login;
import static GUI.Login.main.Login.tentk;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Form_POS extends javax.swing.JPanel {

    private JButton btTable;
    public DAO.DAO_Pos daopos = new DAO_Pos();
    public  String id_hd;
    public static String ban;
    public String id_sp = "";
    private JTextField idTextField = new JTextField();
    DefaultTableModel tblModel1;
    public Form_POS() {
        initComponents();
        themBan();
        initLoai();
        initTable();


    }
    private void initTable() {
        tblModel1 = new DefaultTableModel();
        tblModel1.setColumnIdentifiers(new String[]{"Tên sản phẩm", "Số lượng", "Giá", "Thành Tiền"});
        tbt_SPCTT.setModel(tblModel1);
    
        tblModel1.setRowCount(0);

    }
    private void initableload(String id) {
    
        ArrayList<SanPhamChuaThanhToan> listnv = daopos.getSPCTT(id);
        for (SanPhamChuaThanhToan nv : listnv) 
        {
            
            
            String sl = String.valueOf(nv.getSOLUONG());
            String gia = String.valueOf(nv.getGia());
            String thanhtien = String.valueOf(nv.getThanhtien());
              
            String[] row = new String[]{nv.getTenSP(),sl,gia,thanhtien };
            tblModel1.addRow(row);
            if(nv.getIdHoaDon().isEmpty()){
                  id_hd = null; 
            }else{
                  id_hd = nv.getIdHoaDon();  
            }
            txt_TT.setText(String.valueOf(nv.getTOngtien()));
        }
        tblModel1.fireTableDataChanged();
    }


    private void handleTableClick(ActionEvent event) {
        
        String tableId = event.getActionCommand();
        System.out.println("ID" + tableId);
        tblModel1.setRowCount(0); 
        initableload(tableId);
        ban = tableId;
        for(HoaDon hd : daopos.getHoaDon()){
            if(hd.getID_Ban().getId_Ban().equals(tableId)){
                 id_hd = hd.getID_HoaDon();  
            }
            
        }
        System.out.println("ID hoaDon" +id_hd);
      
    }

    private void themBan() {
        for (Ban ban : daopos.getDanhSachBan()) {
            btTable = new JButton();
            if (ban.getTinhTrang() == 1) {
                btTable.setBorder(new LineBorder(Color.RED, 2));
            }
            btTable.setText(ban.getTen_Ban());
            btTable.setActionCommand(ban.getId_Ban());
            btTable.addActionListener(this::handleTableClick);
            panel_table.add(btTable);
        }
    }

    private void initLoai() {
        for (LoaiSanPham lsp : daopos.getLoaiSanPham()) {
            cbo_Loai.addItem(lsp);
        }
    }

    private void initSP(String id) {
        cbo_SP.removeAllItems();
        for (SanPham item : daopos.getSanPhamFromLoaiSP(id)) {

            cbo_SP.addItem(item);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_table = new javax.swing.JPanel();
        cbo_Loai = new javax.swing.JComboBox<>();
        cbo_SP = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbt_SPCTT = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        soluong = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        txt_TT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();

        panel_table.setBorder(javax.swing.BorderFactory.createTitledBorder("Bàn"));
        panel_table.setLayout(new java.awt.GridLayout(6, 6, 3, 3));

        cbo_Loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_LoaiActionPerformed(evt);
            }
        });

        tbt_SPCTT.setModel(new javax.swing.table.DefaultTableModel(
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
        tbt_SPCTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbt_SPCTTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbt_SPCTT);

        jButton1.setText("Thêm món");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Số lượng");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Thành tiền");

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setText("Thanh toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton5.setText("Đặt bàn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btn_Sua.setText("Xóa");
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
                .addContainerGap()
                .addComponent(panel_table, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_Loai, 0, 178, Short.MAX_VALUE)
                            .addComponent(cbo_SP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(soluong)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(22, 22, 22)
                                .addComponent(txt_TT, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cbo_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(btn_Sua)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_LoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_LoaiActionPerformed
        LoaiSanPham lsb = (LoaiSanPham) cbo_Loai.getSelectedItem();
        System.out.println("LSB ID " + lsb.getId_SanPham());
        cbo_SP.removeAll();
        initSP(lsb.getId_SanPham());
    }//GEN-LAST:event_cbo_LoaiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int soLuong = (int) soluong.getValue();
        SanPham sp = (SanPham)cbo_SP.getSelectedItem();
        System.out.println(id_hd);
        daopos.insertCTHD(id_hd,sp,soLuong);
        tblModel1.setRowCount(0); 
        initableload(ban);
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
            LocalDate currentDate = LocalDate.now();
            String now = String.valueOf(currentDate);
            daopos.insertHoaDon("s", ban, now, 0.0, 0.0,"Chua thanh toan", "74538");
            JOptionPane.showMessageDialog(panel_table, "Them thanh cong");
            initableload(ban);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int i = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán không?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if(i == JOptionPane.YES_OPTION){
           daopos.thanhToan(id_hd);
           initTable();
           initableload(ban);
           
       }else{
           return;
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbt_SPCTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbt_SPCTTMouseClicked
         int row = tbt_SPCTT.getSelectedRow();
         DAO_Quanlysanpham dao = new DAO_Quanlysanpham();
         if(row > 0 ){
         
             for(SanPham sp : dao.get_sanpham()){
                if(sp.getTenSanPham().equals(tbt_SPCTT.getValueAt(row, 0).toString())){
                    id_sp = sp.getId_sanPham();
                }
             }
            
        }
         
    }//GEN-LAST:event_tbt_SPCTTMouseClicked

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        System.out.println("ID_HOADON: " + id_hd);
        System.out.println("ID SP: " + id_sp);
        daopos.deleteCTHD(id_hd, id_sp);
        tblModel1.setRowCount(0);
        initableload(ban);
    }//GEN-LAST:event_btn_SuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JComboBox<Object> cbo_Loai;
    private javax.swing.JComboBox<Object> cbo_SP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_table;
    private javax.swing.JSpinner soluong;
    private javax.swing.JTable tbt_SPCTT;
    private javax.swing.JTextField txt_TT;
    // End of variables declaration//GEN-END:variables
}
