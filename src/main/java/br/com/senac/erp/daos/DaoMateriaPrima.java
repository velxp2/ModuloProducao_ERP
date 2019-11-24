/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.erp.daos;

import br.com.senac.erp.Connection.ConnectionUtils;
import br.com.senac.erp.model.MateriaPrima;
import br.com.senac.erp.model.OrdemProducao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class DaoMateriaPrima {
       
    
    private static final String SELECT_ALL_MATERIAS = "SELECT * FROM ERP.MATERIAPRIMA;";

    public DaoMateriaPrima(){
    }

    public List <MateriaPrima> listar() {

        List <MateriaPrima> lista = new ArrayList <>();
        try (Connection connection = ConnectionUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATERIAS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                int quantidade = rs.getInt("QUANTIDADE");
                String fabricante = rs.getString("FABRICANTE");
                boolean selecionado = rs.getBoolean("SELECIONADO");
                lista.add(new MateriaPrima(id, nome, quantidade, fabricante, selecionado));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return lista;
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

