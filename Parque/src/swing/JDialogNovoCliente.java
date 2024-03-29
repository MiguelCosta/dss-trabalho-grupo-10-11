/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogNovoCliente.java
 *
 * Created on 30/Dez/2010, 16:40:25
 */

package swing;
import java.awt.*;
import sci.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
/**
 *
 * @author Hugo
 */
public class JDialogNovoCliente extends javax.swing.JDialog {
    ResultSet rSet = null;
    /** Creates new form JDialogNovoCliente */
    public JDialogNovoCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centerOnScreen(this);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNovoNum = new javax.swing.JTextField();
        jTextFieldNovoNome = new javax.swing.JTextField();
        jTextFieldNovoNib = new javax.swing.JTextField();
        jTextFieldNovaMatricula = new javax.swing.JTextField();
        jComboBoxNovoModo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setText("Nome do Cliente");

        jLabel2.setText("Número de Cliente");

        jLabel3.setText("NIB");

        jLabel4.setText("Modo de Entrada");

        jLabel5.setText("Matricula");

        try {     
            rSet = Query.queryModosEntrada(); 

            while (rSet.next())         
            jComboBoxNovoModo.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JInterfacePARKUM.class.getName()).log(Level.SEVERE, null, ex); 
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNovoNib, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jTextFieldNovoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jTextFieldNovoNum, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxNovoModo, 0, 248, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(57, 57, 57)
                        .addComponent(jTextFieldNovaMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNovoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNovoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNovoNib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxNovoModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNovaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Limpar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JDialogNovoCliente.this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jTextFieldNovaMatricula.setText(null);
       jTextFieldNovoNib.setText(null);
       jTextFieldNovoNome.setText(null);
       jTextFieldNovoNum.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String idCliente    = jTextFieldNovoNum.getText();
            String nomeCliente  = jTextFieldNovoNome.getText();
            String nib          = jTextFieldNovoNib.getText();
            String modo         = jComboBoxNovoModo.getSelectedItem().toString();
            String matricula    = jTextFieldNovaMatricula.getText();

            String msgERRO = "";
            if (idCliente.equalsIgnoreCase(""))                     msgERRO = msgERRO + "Falta inserir o número do Cliente\n";
            if (nomeCliente.equalsIgnoreCase(""))                   msgERRO = msgERRO + "Falta inserir o nome do Cliente\n";
            if (nib.equalsIgnoreCase(""))                           msgERRO = msgERRO + "Falta inserir o NIB do cliente!\n";
            if (modo.equalsIgnoreCase(""))                          msgERRO = msgERRO + "Falta inserir o modo de entrada\n";
            if (matricula.equalsIgnoreCase(""))                     msgERRO = msgERRO + "Falta inserir a matrícula do veículo\n";
            if (Util.isNumber(idCliente) == false)                  msgERRO = msgERRO + "O id do cliente apenas pode conter algarismos\n";
            //if (Util.isNumber(nib) == false)                        msgERRO = msgERRO + "O nib do cliente apenas pode conter algarismos\n";
            System.out.println(msgERRO);

            if (msgERRO.equalsIgnoreCase("") == false) {
            JOptionPane.showMessageDialog(null, msgERRO, "Erro ao criar cliente", 1);
            } else {
                Query.adicionarCliente(idCliente, nomeCliente, Query.procuraModoEntradaPorNome(modo), matricula, nib);
             /* 
              * Query.adicionarIDCliente(idCliente, idCliente);
                Query.adicionarNomeCliente(idCliente, nomeCliente);
                Query.adicionarNib(idCliente, nib);
                Query.adicionarModo(idCliente, modo );
                Query.adicionarMatricula(idCliente,matricula);

              */
                JOptionPane.showMessageDialog(null, "Cliente adicionar com sucesso!", "Cliente adicionado", 1);
                JDialogNovoCliente.this.dispose();
            }

        } catch (Exception ex) {
            Logger.getLogger(JDialogAlterCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JDialogNovoCliente dialog = new JDialogNovoCliente(new java.awt.Frame(), true);
                     dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(JDialogNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }



        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBoxNovoModo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldNovaMatricula;
    private javax.swing.JTextField jTextFieldNovoNib;
    private javax.swing.JTextField jTextFieldNovoNome;
    private javax.swing.JTextField jTextFieldNovoNum;
    // End of variables declaration//GEN-END:variables


    public static void centerOnScreen(final Component target) {
       if (target != null) {
           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
           Dimension dialogSize = target.getSize();

           if (dialogSize.height > screenSize.height) {
               dialogSize.height = screenSize.height;
           }
           if (dialogSize.width > screenSize.width) {
               dialogSize.width = screenSize.width;
           }

           target.setLocation((screenSize.width - dialogSize.width) / 2,
                   (screenSize.height - dialogSize.height) / 2);
       }
   }
}
