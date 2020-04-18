package DAO;

import BEAN.provaBEAN;
import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class provaDAO {
    
    Connection con = conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
            
    public void SalvarDados(provaBEAN pb){
        try {
            stmt = con.prepareStatement("INSERT INTO avaliacao(prova_parcial, prova_bimestral,media,resultado) VALUES (?,?,?,?)");
            stmt.setFloat(1, pb.getProva_parcial());
            stmt.setFloat(2, pb.getProva_bimestral());
            stmt.setFloat(3, pb.getMedia());
            stmt.setString(4, pb.getResultado());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"DADOS INSERIDO COM SUCESSO!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO AO INSERIR DADOS: "+ex,"AVISO",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void AtualizarDados(provaBEAN pb, int id){
        try {
            stmt = con.prepareStatement("UPDATE avaliacao SET prova_parcial = ?, prova_bimestral = ?, media = ?, resultado = ? WHERE id = "+id);
            stmt.setFloat(1, pb.getProva_parcial());
            stmt.setFloat(2, pb.getProva_bimestral());
            stmt.setFloat(3, pb.getMedia());
            stmt.setString(4, pb.getResultado());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"DADOS ATUALIZADOS COM SUCESSO!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO AO ATUALIZAR DADOS!!","AVISO",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void DeletarDados(int id){
        try {
            stmt = con.prepareStatement("DELETE FROM avaliacao WHERE id = "+id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"DADOS EXCLUÍDOS COM SUCESSO!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO AO EXCLUIR DADOS!!","AVISO",JOptionPane.ERROR_MESSAGE);
        }
    }
}
