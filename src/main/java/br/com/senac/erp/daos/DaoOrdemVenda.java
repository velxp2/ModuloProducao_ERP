/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.erp.daos;

import br.com.senac.erp.Connection.ConnectionUtils;
import br.com.senac.erp.model.OrdemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class DaoOrdemVenda {

    private static final String SELECT_ORDEM_BY_ID = "SELECT ID, PRODUTO, QUANTIDADE FROM ERP.ORDEMVENDA WHERE ID =?";

    public DaoOrdemVenda(){
    }
    
    public OrdemVenda obter(int id) {
        OrdemVenda ordem = null;
        // Step 1: Establishing a Connection
        try (Connection connection = ConnectionUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDEM_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                
                int IdVenda = rs.getInt("ID");
                String nome = rs.getString("PRODUTO");
                int quantidade = rs.getInt("QUANTIDADE");
                ordem = new OrdemVenda(IdVenda, nome, quantidade);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ordem;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

