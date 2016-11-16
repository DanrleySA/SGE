/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.view;

import br.com.unicatolica.bean.ProdutoBean;
import br.com.unicatolica.bean.SaidaBean;
import br.com.unicatolica.dao.ProdutoDAO;
import br.com.unicatolica.model.ProdutoSaida;
import br.com.unicatolica.utilitario.Alertas;
import br.com.unicatolica.utilitario.NossaData;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danrl
 */
public class FormSaida extends javax.swing.JDialog {

    private List<ProdutoSaida> listaItens;
    private SaidaBean saidaBean;
    private ProdutoBean pb;

    /**
     * Creates new form FormSaida
     */
    public FormSaida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listaItens = new ArrayList<>();
        saidaBean = new SaidaBean();
        pb = new ProdutoBean();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfNomeProduto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItens = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tfNomeProduto.setBackground(new java.awt.Color(0, 51, 204));
        tfNomeProduto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tfNomeProduto.setForeground(new java.awt.Color(255, 255, 255));
        tfNomeProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfNomeProduto.setText("Saida de Produtos");
        tfNomeProduto.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Produto");

        tfProduto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProdutoActionPerformed(evt);
            }
        });
        tfProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfProdutoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfProdutoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Quantidade");

        tfQuantidade.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantidadeActionPerformed(evt);
            }
        });
        tfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyTyped(evt);
            }
        });

        jtItens.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jtItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Prod.", "Produto", "Qtde."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtItens.setFocusable(false);
        jtItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtItens);
        if (jtItens.getColumnModel().getColumnCount() > 0) {
            jtItens.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("  F2 - Finalizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(tfProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                    .addComponent(tfQuantidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfNomeProduto)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProdutoActionPerformed
        try {
            if (tfProduto.getText().isEmpty()) {
                Alertas.mensagemAviso("Informe o código do produto!");
            } else {
                int codigo = Integer.parseInt(tfProduto.getText());
                if (ProdutoDAO.buscaProduto(codigo) == null) {
                    Alertas.mensagemAviso("Produto não encontrado!");
                } else {
                    pb.setProduto(ProdutoDAO.buscaProduto(codigo));
                    tfNomeProduto.setText(pb.getProduto().getDescricao().toUpperCase());
                    tfQuantidade.requestFocus();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tfProdutoActionPerformed

    private void tfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantidadeActionPerformed
        try {
            if (tfQuantidade.getText().isEmpty()) {
                Alertas.mensagemAviso("Informe a quantidade!");
            } else {
                int quant = Integer.parseInt(tfQuantidade.getText());
                if (quant == 0) {
                    Alertas.mensagemAviso("Informe uma quantidade maior que zero!");
                } else if ((quant + qtdeDaLista()) > pb.getProduto().getQuantidade()) {
                    Alertas.mensagemAviso("Quantidade insuficiente no estoque!");
                } else {
                    ProdutoSaida ps = new ProdutoSaida();
                    ps.setProduto(pb.getProduto());
                    ps.setQuantidade(quant);
                    listaItens.add(ps);
                    preencherTabela();
                    novoItem();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tfQuantidadeActionPerformed

    private void tfProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyTyped
        String str = "0123456789";
        if (!str.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfProdutoKeyTyped

    private void tfQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyTyped
        String str = "0123456789";
        if (!str.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfQuantidadeKeyTyped

    private void tfProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyPressed
        menu(evt);
    }//GEN-LAST:event_tfProdutoKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormSaida dialog = new FormSaida(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtItens;
    private javax.swing.JLabel tfNomeProduto;
    private javax.swing.JTextField tfProduto;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables

    private Integer qtdeDaLista() {
        int soma = 0;
        for (ProdutoSaida ps : listaItens) {
            if (pb.getProduto().getCodigo() == ps.getProduto().getCodigo()) {
                soma += ps.getQuantidade();
            }
        }
        return soma;
    }

    private void novoItem() {
        pb = new ProdutoBean();
        tfQuantidade.setText("");
        tfProduto.setText("");
        tfNomeProduto.setText("Saída de Produtos");
        tfProduto.requestFocus();
    }

    private void preencherTabela() {
        DefaultTableModel tb = (DefaultTableModel) jtItens.getModel();
        tb.setNumRows(0);
        try {
            for (ProdutoSaida ps : listaItens) {
                tb.addRow(new Object[]{
                    ps.getProduto().getCodigo(),
                    ps.getProduto().getDescricao(),
                    ps.getQuantidade()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void menu(KeyEvent evt) {
        try {
            if (evt.getKeyCode() == KeyEvent.VK_F2) {
                if (listaItens.size() == 0) {
                    Alertas.mensagemAviso("Adicione um produto na lista para efetuar a saída!");
                } else {
                    saidaBean.getSaida().setLista(listaItens);
                    saidaBean.getSaida().setMemorando("SAÍDA DE PRODUTOS");
                    saidaBean.getSaida().setDataSaida(NossaData.getDataAtual());
                    saidaBean.salvarSaida();
                    Alertas.mensagemConfirmacao("Saída efetuada com sucesso!");
                    limpar();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpar() {
        novoItem();
        saidaBean = new SaidaBean();
        listaItens.clear();
        preencherTabela();
    }
}