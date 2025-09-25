package ejercicio305;

public class Vista extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration

    private Controlador controlador;

    public Vista() {
    }

    public void arranca(){
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
        jButton1.addActionListener(controlador);
        jButton1.setActionCommand("SUMAR");
    }

    public String[] getCampos(){
        return new String[]{jTextField1.getText(), jTextField2.getText()};
    }

    public void escribirResultado(String resultado){
        this.jTextPane1.setText(resultado);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // ... Código de la plantilla BORRADO AQUÍ PARA QUE NO QUEDE TAN GRANDE LA SOLUCIÓN
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton1.setActionCommand("SUMAR");
    }
}