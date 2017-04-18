/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locafilme.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class PersisteFilme 
{
   
				
    public void persiste(Filme filme){
        Connection connection;
        try {
           connection =
				DriverManager.getConnection("jdbc:h2:mem:;" +
"INIT=RUNSCRIPT FROM './src/main/resources/create_schema.sql'\\;", "sa", "");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO filme (id, nome, genero, duracao, status, dtempreste, dtdevolve) "
                    + "VALUES ("+ filme.getId()+", '"+ filme.getNome() +"' , "+ filme.getGenero().getValor() +" , "+ filme.getDuracao() +
                    ", "+ filme.getStatus().getValor() +", "+ filme.getDataUltimoEmprestimo() +", "+ filme.getDataDevolvucao() +" )");
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersisteFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void merge(Filme filme){
        Connection connection;
        try {
            connection =
				DriverManager.getConnection("jdbc:h2:mem:;" +
"INIT=RUNSCRIPT FROM './src/main/resources/create_schema.sql'\\;", "sa", "");
            PreparedStatement ps = connection.prepareStatement("UPDATE filme SET  nome = '" + filme.getNome()+ "' , genero =" + filme.getGenero().getValor()+
                    ", duracao =" + filme.getDuracao()+ ", status =" + filme.getStatus().getValor()+ ", dtempreste =" + filme.getDataUltimoEmprestimo() +
                    ", dtdevolve =" + filme.getDataDevolvucao()+ ";");
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersisteFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Filme findById(int id){
        Filme f = null;
        Connection connection;
        try {
            connection =
				DriverManager.getConnection("jdbc:h2:mem:;" +
"INIT=RUNSCRIPT FROM './src/main/resources/create_schema.sql'\\;", "sa", "");
            PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM Filme where id =" + id);
		ResultSet rs = ps2.executeQuery();
		rs.next();
                f = new Filme(rs.getInt("id"), rs.getString("nome"), Genero.ValueBy(rs.getInt("genero"))  , rs.getInt("duracao"));
                f.setStatus(StatusFilme.ValueBy(rs.getInt("status")));
		connection.close();
        } catch (Exception e) {
            
        }
        return  f;
    }
    
    
    
    
    
    
    
 
    
}
