package br.com.agenda.promocao;




	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import br.com.agenda.factory.Conexao;




	public class PromocaoDAO {

		Connection conn = null;
		
		PreparedStatement pstm = null;
		


		public void save (Promocao promocao) throws Exception {
			

			
			String sql = ("INSERT INTO promocao(nome, valor, id, fk_destino_id )" + "VALUES(?,?,?,?)");
			
			try {
	            
				
				
				conn = Conexao.createConnectionToMySQL();
	            pstm = conn.prepareStatement(sql);
	           
	            pstm.setString(1, promocao.getNome());
	            pstm.setDouble(2, promocao.getValor());
	            pstm.setInt(3, promocao.getId());
	            pstm.setInt(4, promocao.getDestino().getId());
	            
	         
	   
	            pstm.execute();
	            pstm.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }



	   }



	   public void removeById(int id) throws Exception {
		   String sql = "DELETE FROM promocao WHERE id = ?";
			Connection conn = null;
			PreparedStatement pstm = null;

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				pstm.execute();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }



	   }



	   public void update(Promocao promocao) throws Exception {
		   String sql = "UPDATE promocao SET nome = ? , valor = ? WHERE id = ?";
			Connection conn = null;
			PreparedStatement pstm = null;
			

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
			
		         
				  	pstm.setString(1, promocao.getNome());
		            pstm.setDouble(2, promocao.getValor());
		            pstm.setInt(3, promocao.getId());
		            pstm.setInt(4, promocao.getDestino().getId());
		            
				pstm.execute();
				pstm.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }



	   }



	   public ResultSet getPromocao() throws SQLException {
	        String sql = "SELECT * FROM promocao";
	        Statement pstm = null;
	        ResultSet resultado = null;
	        try {
	        	pstm = conn.prepareStatement(sql);
	            resultado = pstm.executeQuery(sql);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return resultado;



	   }

	

	
	
		

		
	
	


	   }
