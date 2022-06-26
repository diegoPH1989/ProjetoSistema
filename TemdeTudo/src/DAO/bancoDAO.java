package DAO;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class bancoDAO {
    private Connection conn;
    private PreparedStatement ps;
    
    public boolean executaComando( String comando){
        boolean resultadoComando = false;
        
        try {
            ps = conn.prepareStatement(comando);
            resultadoComando = ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "bancoDAO.executaComando " + ex.getMessage());
        }
        return resultadoComando;
    }
    
    public ResultSet retornaDados(String comando){
        ResultSet Dados = null;
        try {
        ps = conn.prepareStatement(comando);
            Dados =  ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(bancoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Dados;
    }
    
    public bancoDAO(){
         String textoConexao = "jdbc:mysql://localhost:3306/mercadotemdetudo?user=root&password=";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(textoConexao);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "bancoDAO.bancoDAO " + ex.getMessage());
        }
    }
    
    
}
