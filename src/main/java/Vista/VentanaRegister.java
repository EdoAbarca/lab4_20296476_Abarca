package Vista;

import Modelo.ImplementacionRedSocial;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class VentanaRegister extends javax.swing.JFrame {

    ImplementacionRedSocial ReferenciaRedSocial;
    
    /**
     * Creates new form VentanaRegister
     * @param RS
     */
    public VentanaRegister(ImplementacionRedSocial RS)
    {
        this.ReferenciaRedSocial = RS;
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.jButton2.setFocusable(false);
        this.jButton2.setVisible(false);
        this.jButton1.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 249, 231));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(133, 193, 233));
        jLabel1.setText("Registro de usuario");
        jLabel1.setRequestFocusEnabled(false);

        jButton2.setText("Registrarse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.setRequestFocusEnabled(false);
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        jTextField1.setRequestFocusEnabled(false);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(133, 193, 233));
        jLabel2.setText("Usuario");
        jLabel2.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(133, 193, 233));
        jLabel3.setText("Contrasenia");
        jLabel3.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(585, 585, 585))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(602, 602, 602))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(497, 497, 497)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1)
                            .addComponent(jTextField1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(85, 85, 85)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(212, 212, 212))
        );

        jLabel1.getAccessibleContext().setAccessibleName("jLabel1");
        jPasswordField1.getAccessibleContext().setAccessibleName("jPasswordField1");
        jTextField1.getAccessibleContext().setAccessibleName("jTextField1");
        jLabel2.getAccessibleContext().setAccessibleName("jLabel2");
        jLabel3.getAccessibleContext().setAccessibleName("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        this.jTextField1.setFocusable(true);
        this.jPasswordField1.setFocusable(false);
        this.jButton2.setFocusable(false);
        this.jButton1.setFocusable(false);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        //Se obtiene lo que hay en ambas casillas
        String textBox = jTextField1.getText();
        String passBox = String.valueOf(jPasswordField1.getPassword());
        //Si alguna de las casillas esta vaci�a
        if(textBox.trim().equals("") || passBox.trim().equals(""))
        {
            jButton2.setVisible(false); //No se permite seleccionar el boton
        }
        else //Caso contrario
        {
            jButton2.setVisible(true); //Se permite seleccionar boton
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        //Se obtiene lo que hay en ambas casillas
        String textBox = jTextField1.getText();
        String passBox = String.valueOf(jPasswordField1.getPassword());
        //Si alguna de las casillas esta vaci�a
        if(textBox.trim().equals("") || passBox.trim().equals(""))
        {
            jButton2.setVisible(false); //No se permite seleccionar el boton
        }
        else //Caso contrario
        {
            jButton2.setVisible(true); //Se permite seleccionar boton
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        this.jTextField1.setFocusable(false);
        this.jPasswordField1.setFocusable(true);
        this.jButton2.setFocusable(false);
        this.jButton1.setFocusable(false);
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Boton Volver
        // Instanciar la ventana inicial
        MuestraInicial RegresoAInicio = new MuestraInicial(this.ReferenciaRedSocial);
        
        // Finalizar muestreo de esta ventana
        this.setVisible(false);
        
        // Iniciar muestreo ventana a dirigirse
        RegresoAInicio.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Boton Registrar
        // Obtener los datos ingresados en las casillas
        String textBox = jTextField1.getText();
        String passBox = String.valueOf(jPasswordField1.getPassword());
        
        // Llamar a metodo Register de la red social
        String ResultadoRegistro = this.ReferenciaRedSocial.Register(textBox, passBox);
        
        // Divison array para revisar resultado de aplicar Register con los datos ingresados
        String[] DivisionResultado = ResultadoRegistro.split(" ");
        
        // Si la operacion fue exitosa
        if(!DivisionResultado[0].equals("Error:"))
        {
            // Se muestra ventana de resultado
            JOptionPane.showMessageDialog(this, ResultadoRegistro);
            
            // Instanciar la ventana de inicio
            MuestraInicial Retorno = new MuestraInicial(this.ReferenciaRedSocial);
            
            // Finalizar muestreo ventana actual
            this.setVisible(false);
            
            // Iniciar muestreo ventana inicio
            Retorno.setVisible(true);
        }
        
        // Caso contrario, se muestra JOptionPane, en su version en error (se mantiene en ventana actual)
        else
        {
            JOptionPane.showMessageDialog(this, ResultadoRegistro, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        this.jTextField1.setFocusable(false);
        this.jPasswordField1.setFocusable(false);
    }//GEN-LAST:event_jPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
