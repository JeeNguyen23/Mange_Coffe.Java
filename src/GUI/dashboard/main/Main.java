package GUI.dashboard.main;

import GUI.Login.main.Login;
import static GUI.Login.main.Login.ql;
import GUI.dashboard.events.EventMenuSelected;
import GUI.dashboard.forms.Form_POS;
import GUI.dashboard.forms.Form_QLBan;
import GUI.dashboard.forms.Form_QLHD;
import GUI.dashboard.forms.Form_QLNhanVien;
import GUI.dashboard.forms.Form_QLSanPham;
import GUI.dashboard.forms.Form_QLTaiKhoanNhanVien;
import GUI.dashboard.forms.From_QLDoanhThu;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {



    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
         if(ql){
            System.out.println("la true");
            }else{
            System.out.println("la false");
            }
        menu1.initMoving(this);
        menu1.addEventMenuSelected(new EventMenuSelected() { 
            @Override
            public void selected(int index) {
                if (ql == true) {
                    
                    if (index == 0) {
                        System.out.println("Index: " + index);
                        setForm(new Form_QLBan());
                    } else if (index == 1) {
                        System.out.println("Index: " + index);

                        setForm(new Form_POS());
                    } else if (index == 2) {
                        System.out.println("Index: " + index);
                        setForm(new From_QLDoanhThu());

                    } else if (index == 3) {
                        System.out.println("Index: " + index);
                        setForm(new From_QLDoanhThu());
                    } else if (index == 6) {
                        System.out.println("Index: " + index);
                        setForm(new Form_QLSanPham());
                    } else if (index == 7) {
                        System.out.println("Index: " + index);
                        setForm(new Form_QLNhanVien());
                    }else if (index == 8) {
                        System.out.println("Index: " + index);
                        setForm(new Form_QLBan());
                    } else if (index == 9) {
                        System.out.println("Index: " + index);
                        try {
                            setForm(new Form_QLTaiKhoanNhanVien());
                        } catch (SQLException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (index == 10) {
                        int i = JOptionPane.showConfirmDialog(rootPane, "Are you sure?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (i == JOptionPane.YES_OPTION) {
                            Login lg = new Login();
                            setVisible(false);
                            lg.setVisible(true);
                        } else {
                            return;
                        }

                    }
                } else{
                    if (index == 0) {
                        System.out.println("Index: " + index);
                        setForm(new Form_QLBan());
                    } else if (index == 1) {
                        System.out.println("Index: " + index);

                        setForm(new Form_POS());
                    } else if (index == 2) {
                        System.out.println("Index: " + index);
                        setForm(new From_QLDoanhThu());

                    } else if (index == 3) {
                        System.out.println("Index: " + index);
                        setForm(new From_QLDoanhThu());
                    } else if (index == 6) {
                          JOptionPane.showMessageDialog(rootPane, "Tài khoản này không có quyền quản lý\n"); 
                    } else if (index == 7) {
                          JOptionPane.showMessageDialog(rootPane, "Tài khoản này không có quyền quản lý\n"); 
                   
                    }else if (index == 8) {
                         JOptionPane.showMessageDialog(rootPane, "Tài khoản này không có quyền quản lý\n"); 
                    } else if (index == 9) {
                         JOptionPane.showMessageDialog(rootPane, "Tài khoản này không có quyền quản lý\n"); 
                    } else if (index == 10) {
                        int i = JOptionPane.showConfirmDialog(rootPane, "Are you sure?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (i == JOptionPane.YES_OPTION) {
                            Login lg = new Login();
                            setVisible(false);
                            lg.setVisible(true);
                        } else {
                            return;
                        }

                    }
                }

            }
        });
    }

    private void setForm(JComponent com) {
        main_panel.removeAll();
        main_panel.add(com);
        main_panel.repaint();
        main_panel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.dashboard.swing.PanelBorder();
        menu1 = new gui.dashboard.component.Menu();
        header2 = new GUI.dashboard.component.Header();
        main_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        main_panel.setOpaque(false);
        main_panel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                    .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.dashboard.component.Header header2;
    public javax.swing.JPanel main_panel;
    private gui.dashboard.component.Menu menu1;
    private GUI.dashboard.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
