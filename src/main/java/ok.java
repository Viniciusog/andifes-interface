import java.awt.CardLayout;

public class ok extends javax.swing.JFrame {

    public ok() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jButton1.setText("Trocar Painel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel1, "painel1");
        getContentPane().add(jPanel2, "painel2");

        getContentPane().add(jButton1, "botao");

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.next(getContentPane());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ok().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
}
