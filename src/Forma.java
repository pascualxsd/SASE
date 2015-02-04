
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Forma extends javax.swing.JFrame {

    /**
     * Creates new form Forma
     */
    public Forma() {
        initComponents();
   
    }
    
 void CargaActas (int fila ){
    String lapso,carrera,materia,sede,seccion;
    DefaultTableModel modelo= new DefaultTableModel();
       String codigo;
       String sql1;
       String sql2; 
       int i=0;
       modelo.addColumn("RG");
    modelo.addColumn("Cedula");
    modelo.addColumn("Nombre y Apellido");
    modelo.addColumn("Nota");
    modelo.addColumn("Noasistio");
    modelo.addColumn("Abandono");
       jLabel6.setText(jTable1.getValueAt(fila,3).toString());//lo que este en esa fila tal y le pasa lo de la columna 1
       lapso=  jTable1.getValueAt(fila,0).toString();
       sede= jTable1.getValueAt(fila,1).toString();
       carrera= jTable1.getValueAt(fila,2).toString();
       materia=  jTable1.getValueAt(fila,3).toString();
       seccion= jTable1.getValueAt(fila,4).toString();
      // sql="SELECT * FROM sigu06_5, sigu04_1 WHERE  sigu04_1.sigu04_1lapso = '"+valor+"' AND sigu04_1.sigu04_1codasign = sigu06_5.sigu06_5codasign  ";
 
       
       sql1="SELECT e.sigu08_2cedula, e.sigu08_2apellido, e.sigu08_2nombre "+
       "FROM sigu08_2 e INNER JOIN sigu04_1 i ON (e.sigu08_2cedula = i.sigu04_1cedula) "+
       "WHERE i.sigu04_1lapso = '"+lapso+
       "' AND i.sigu04_1codsede='"+ sede +"' AND i.sigu04_1codca='"+carrera+ 
       "' AND i.sigu04_1codasign='" + materia +"' AND i.sigu04_1codseccion='"+seccion+"'"; 
      
       String []datoslap = new String [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            i=0;
            while(rs.next()){
               
               i++;
               
                datoslap[2]=rs.getString(2)+" "+rs.getString(3);
                datoslap[0]=String.valueOf(i);
                datoslap[1]=rs.getString(1);
            
                //sql2 = "SELECT * FROM sigu08_2 WHERE  sigu08_2cedula = '"+rs.getString(2)+"'";
                //Statement st2 = cn.createStatement();
                //ResultSet rs2 = st.executeQuery(sql2);
               // rs2.next();
               // System.out.println(rs2.getString(1) + " "+ rs2.getString(2) + " " + rs2.getString(3));
                //datoslap[0]="" + i++;
                //datoslap[1]=rs2.getString(1);
                //datoslap[2]=rs2.getString(2) + " " + rs2.getString(3);
                
                modelo.addRow(datoslap);
            }
            jTable2.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Forma.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
//     System.out.println(rs.getString(2));
         
           
}
      



    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
     modelo.addColumn("Lapso");
    modelo.addColumn("Sede");
    modelo.addColumn("Carrera");
    modelo.addColumn("Materia");
    modelo.addColumn("Seccion");
    
    
    //jTable1.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        JOptionPane.showMessageDialog(null,"Lapso donde desea Trabajar");
       // sql="SELECT * FROM sigu06_6";
    }
    else{
        
          sql="SELECT * FROM sigu04_1 WHERE  sigu04_1.sigu04_1lapso = '"+valor+"'";
    }                 
                                     
    String []datoslap = new String [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datoslap[0]=rs.getString(1);
                datoslap[1]=rs.getString(4);
                datoslap[2]=rs.getString(3);
                datoslap[3]=rs.getString(5);
                datoslap[4]=rs.getString(6);
            
               
                modelo.addRow(datoslap);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Forma.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBackground(new java.awt.Color(0, 0, 102));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "RG", "Cedula", "Apellido Nombre", "Nota", "No Asisto", "Abandono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 620, 210));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Sede", "Carrera", "Materia", "Seccion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 620, 90));

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 100, 20));

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel4.setText("Lapso");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 50, 20));

        jTextField1.setText("2014-2");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 130, -1));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setText("Cierre de Semestre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 180, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 730, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel5.setText("Alumnos de la Materia Seleccinada");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 330, 30));

        jButton3.setText("Alumnos de la Materia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 3, 730, 740));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        mostrardatos(jTextField1.getText());
      
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     int fila =jTable1.getSelectedRow();
     if(fila>=0){   
     CargaActas(fila);
      
     }
     else {
        
       JOptionPane.showMessageDialog(null,"seleccione una materia");
       } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Forma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
Conectar cc= new Conectar();
    Connection cn= cc.conexion();

    private void BuscarSsede(int fila) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
