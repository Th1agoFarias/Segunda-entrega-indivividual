package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;				 	//	classeDao com crud - ok
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.Conexao;
import br.com.agenda.model.Destino;




public class DestinoDAO {
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	

	
	public void save (Destino destino) {
		

		
		String sql = ("INSERT INTO destino(estado, cidade, ida, volta )" + "VALUES(?,?,?,?)");
		
		try {
            
			
			
			conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
           
            pstm.setString(1, destino.getEstado());
            pstm.setString(2, destino.getCidade());
            pstm.setInt(3, destino.getIda());
            pstm.setInt(4, destino.getVolta());
           
         
   
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         
            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

        }
		
	}
    
	public void removeById(int id) {
		String sql = "DELETE FROM destino WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Destino destino) {
		String sql = "UPDATE destino SET estado = ?, cidade = ?, ida=?, volta=? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
		
	         
            pstm.setString(1, destino.getEstado());
            pstm.setString(2, destino.getCidade());
            pstm.setInt(3, destino.getIda());
            pstm.setInt(4, destino.getVolta());
            pstm.setInt(5, destino.getId());
           
              
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Destino> getDestinos() {
		String sql = "SELECT * FROM destinos";
		Connection conn = null;
		PreparedStatement pstm = null;
		
	
		List<Destino> destinos = new ArrayList<Destino>();
		ResultSet rset = null;

		
		
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			
			

			while (rset.next()) {

				Destino destino = new Destino();

			
			
				destino.setId(rset.getInt("id"));
		
				destino.setEstado(rset.getString("estado"));
				destino.setCidade(rset.getString("cidade"));
				destino.setIda(rset.getInt("ida"));
				destino.setVolta(rset.getInt("volta"));
				
			
				
				destinos.add(destino);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return destinos;
	}

	public Destino buscarID(int id) {
		String sql = "SELECT * FROM destinos WHERE id = ?";
		Destino destino = new Destino();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			destino.setId(rset.getInt("id"));

	
			destino.setEstado(rset.getString("estado"));

	
			destino.setCidade(rset.getString("cidade"));
			destino.setIda(rset.getInt("ida"));
			destino.setVolta(rset.getInt("volta"));
			
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destino;
	}
	
}
	
	
	
	





