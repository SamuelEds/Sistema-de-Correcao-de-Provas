/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BEAN.provaBEAN;
import DAO.provaDAO;
import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        
        PuxarDados();
        
        //this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void PuxarDados(){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM avaliacao");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) resultados.getModel();
            
            while(rs.next()){
                Object[] dados = {rs.getFloat("prova_parcial"), rs.getFloat("prova_bimestral"), rs.getFloat("media"), rs.getString("resultado")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Pesquisar(int id){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM avaliacao WHERE id like '%"+id+"%'");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) resultados.getModel();
            table.setNumRows(0);
            if(rs.next()){
                Object[] dados = {rs.getFloat("prova_parcial"), rs.getFloat("prova_bimestral"), rs.getFloat("media"), rs.getString("resultado")};
                table.addRow(dados);
            }else{
                JOptionPane.showMessageDialog(null,"ID NÃO FOI ENCONTRADO","AVISO",JOptionPane.ERROR_MESSAGE);
                PuxarDados();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ppOficial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pbOficial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pParcial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pBimestral = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        salvar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        pesquisar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROVA BIMESTRAL ORIGINAL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PROVA PARCIAL ORIGINAL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PROVA BIMESTRAL");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PROVA PARCIAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(207, 207, 207)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pParcial)
                    .addComponent(ppOficial, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pbOficial)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pBimestral)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ppOficial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbOficial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pParcial, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(pBimestral))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        salvar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salvar.setText("SALVAR DADOS");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        atualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        atualizar.setText("ATUALIZAR DADOS");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        deletar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deletar.setText("DELETAR DADOS");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        pesquisar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pesquisar.setText("PESQUISAR DADOS");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(47, 47, 47)
                .addComponent(atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(deletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        resultados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOTA PROVA_PARCIAL", "NOTA PROVA_BIMESTRAL", "MÉDIA", "RESULTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(resultados);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(967, 702));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        provaBEAN pb = new provaBEAN();
        provaDAO pd = new provaDAO();
        
        if(ppOficial.getText().equals("") || pbOficial.getText().equals("") || pParcial.getText().equals("") || pBimestral.getText().equals("")){
            JOptionPane.showMessageDialog(null,"ALGUNS CAMPOS NÃO FORAM PREENCHIDOS","AVISO",JOptionPane.ERROR_MESSAGE);
        }else{
            
            String provaOficialParcial = ppOficial.getText();
            String[] pprovOficial = provaOficialParcial.split(",");
            
            String provaOficialBimestral = pbOficial.getText();
            String[] pbrovOficial = provaOficialBimestral.split(",");
            
            String provaParcial = pParcial.getText();
            String[] pprov = provaParcial.split(",");
            
            String provaBimestral = pBimestral.getText();
            String[] bprov = provaBimestral.split(",");
            
            if(pprov.length == pprovOficial.length && bprov.length == pbrovOficial.length){
                
                float n1 = 0;
                float n2 = 0;
                
                float nm = Float.parseFloat(JOptionPane.showInputDialog("QUANTO VALE CADA QUESTÃO? "));
                
                for(int i = 0;i < pprovOficial.length;i++){
                    
                    if(pprovOficial[i] == null ? (pprov[i]) == null : pprovOficial[i].equals(pprov[i])){
                        n1 = n1 + nm;
                    }
                    
                    if(pbrovOficial[i] == null ? (bprov[i]) == null : pbrovOficial[i].equals(bprov[i])){
                        n2 = n2 + nm;
                    }
                    
                }
                
                float media = (n1 + n2) / 2;
                if(media >= 6){
                    pb.setResultado("APROVADO(A)");
                   // resultado = "APROVADO(A)";
                }else if(media < 6 && media >= 4){
                    pb.setResultado("RECUPERAÇÃO");
                    //resultado = "RECUPERAÇÃO";
                }else if(media < 4){
                    pb.setResultado("REPROVADO(A)");
                    //resultado = "REPROVADO(A)";
                }else{
                    JOptionPane.showMessageDialog(null,"OCORREU UM ERRO. POR FAVOR, TENTE NOVAMENTE","AVISO",JOptionPane.ERROR_MESSAGE);
                }
                
                pb.setProva_parcial((float) n1);
                pb.setProva_bimestral((float) n2);
                pb.setMedia(media);
                
                pd.SalvarDados(pb);
                
                DefaultTableModel table = (DefaultTableModel) resultados.getModel();
                Object[] dados = {n1,n2,media,pb.getResultado()};
                table.addRow(dados);
                
            }else{
                JOptionPane.showMessageDialog(null,"OS CAMPOS PRECISAM TER O MESMO NÚMERO DE QUESTÕES","AVISO",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        provaBEAN pb = new provaBEAN();
        provaDAO pd = new provaDAO();
        
        if(ppOficial.getText().equals("") || pbOficial.getText().equals("") || pParcial.getText().equals("") || pBimestral.getText().equals("")){
            JOptionPane.showMessageDialog(null,"ALGUNS CAMPOS NÃO FORAM PREENCHIDOS","AVISO",JOptionPane.ERROR_MESSAGE);
        }else{
            
            if(resultados.getSelectedRow() != -1){
                String provaOficialParcial = ppOficial.getText();
                String[] pprovOficial = provaOficialParcial.split(",");
            
                String provaOficialBimestral = pbOficial.getText();
                String[] pbrovOficial = provaOficialBimestral.split(",");
            
                String provaParcial = pParcial.getText();
                String[] pprov = provaParcial.split(",");
            
                String provaBimestral = pBimestral.getText();
                String[] bprov = provaBimestral.split(",");
            
                if(pprov.length == pprovOficial.length && bprov.length == pbrovOficial.length){
                
                    float n1 = 0;
                    float n2 = 0;
                
                    float nm = Float.parseFloat(JOptionPane.showInputDialog("QUANTO VALE CADA QUESTÃO? "));
                
                    for(int i = 0;i < pprovOficial.length;i++){
                    
                        if(pprovOficial[i] == null ? (pprov[i]) == null : pprovOficial[i].equals(pprov[i])){
                            n1 = n1 + nm;
                        }
                    
                        if(pbrovOficial[i] == null ? (bprov[i]) == null : pbrovOficial[i].equals(bprov[i])){
                            n2 = n2 + nm;
                        }
                    
                    }
                
                    float media = (n1 + n2) / 2;
                    if(media >= 6){
                        pb.setResultado("APROVADO(A)");
                        // resultado = "APROVADO(A)";
                    }else if(media < 6 && media >= 4){
                        pb.setResultado("RECUPERAÇÃO");
                        //resultado = "RECUPERAÇÃO";
                    }else if(media < 4){
                        pb.setResultado("REPROVADO(A)");
                        //resultado = "REPROVADO(A)";
                    }else{
                        JOptionPane.showMessageDialog(null,"OCORREU UM ERRO. POR FAVOR, TENTE NOVAMENTE","AVISO",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    int id = Integer.parseInt(JOptionPane.showInputDialog("INDIQUE O ID PARA ATUALIZAÇÃO: "));
                    
                
                    pb.setProva_parcial((float) n1);
                    pb.setProva_bimestral((float) n2);
                    pb.setMedia(media);
                
                    pd.AtualizarDados(pb, id);
                    
                    resultados.setValueAt(pb.getProva_parcial(), resultados.getSelectedRow(), 0);
                    resultados.setValueAt(pb.getProva_bimestral(), resultados.getSelectedRow(), 1);
                    resultados.setValueAt(pb.getMedia(), resultados.getSelectedRow(), 2);
                    resultados.setValueAt(pb.getResultado(), resultados.getSelectedRow(), 3);
                
                }else{
                    JOptionPane.showMessageDialog(null,"OS CAMPOS PRECISAM TER O MESMO NÚMERO DE QUESTÕES","AVISO",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"SELECIONE UMA LINHA DA TABELA","AVISO",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_atualizarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        provaBEAN pb = new provaBEAN();
        provaDAO pd = new provaDAO();
        
        if(resultados.getSelectedRow() != -1){
            int id = Integer.parseInt(JOptionPane.showInputDialog("INDIQUE O ID PARA DELETAR: "));
            pd.DeletarDados(id);
            
            DefaultTableModel table = (DefaultTableModel) resultados.getModel();
            table.removeRow(resultados.getSelectedRow());
        }else{
            JOptionPane.showMessageDialog(null,"SELECIONE UMA LINHA DA TABELA","AVISO",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deletarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog("DIGITE O ID PARA PESQUISA: "));
        Pesquisar(id);
    }//GEN-LAST:event_pesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton deletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pBimestral;
    private javax.swing.JTextField pParcial;
    private javax.swing.JTextField pbOficial;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextField ppOficial;
    private javax.swing.JTable resultados;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}