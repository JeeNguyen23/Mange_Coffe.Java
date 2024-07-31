
package GUI.dashboard.swing;

import GUI.dashboard.model.Model_Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MenuITem extends javax.swing.JPanel {
    private boolean selected;
    
    public MenuITem(Model_Menu data) {
        
        initComponents();
        setOpaque(false);
        if(data.getType()== Model_Menu.MenuType.MENU){
            lbIcon.setIcon(data.toIcon());
            jLabel1.setText(data.getName());
            
        }else if(data.getType() == Model_Menu.MenuType.TITLE){
            lbIcon.setText(data.getName());
            lbIcon.setFont(new Font("sansserif",1,12));
            jLabel1.setVisible(false);
        }else{
            jLabel1.setText(" ");
        }
         Border border = new EmptyBorder(0, 0, 0, 5);
        
    
        this.setBorder(border);
    }
    public void setSelected(boolean selected){
        this.selected = selected;
        repaint();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
       if(selected){
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          
            g2.setColor(new Color(255,255,255,80));
           g2.fillRoundRect(10, 0, getWidth() -20, getHeight(), 5, 5);
       }
        super.paintComponent(g); 
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(0, 0, 0));

        lbIcon.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbIcon;
    // End of variables declaration//GEN-END:variables
}
