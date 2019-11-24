package br.com.senac.erp.daos;

import br.com.senac.erp.Connection.ConnectionUtils;
import br.com.senac.erp.model.MateriaPrima;
import br.com.senac.erp.model.OrdemProducao;
import br.com.senac.erp.model.OrdemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VictorGuilhermeSeraf
 */
public class DaoOrdemProducao {

    private static final String INSERT_ORDEM_SQL = "INSERT INTO ERP.ORDEMPRODUCAO (ID, RECURSOS, STATU, DATAINICIO, "
            + "DATATERMINO, DATAPREV, TEMPOESTIMADO, ID_ORDEMVENDA) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
    private static final String INSERT_ORDEM_MATERIA_SQL = "INSERT INTO ERP.ORDEMPRODUCAO_MATERIAPRIMA (ID_ORDEMPRODUCAO, ID_MATERIAPRIMA) "
            + "VALUES (?, ?);";
//    private static final String SELECT_ORDEM_BY_ID = "SELECT * FROM ERP.ORDEMPRODUCAO WHERE (ID =?)";
    private static final String SELECT_ALL_ORDENS_VENDA = "SELECT * FROM ERP.ORDEMPRODUCAO OP \n"
            + "INNER JOIN ERP.ORDEMVENDA OV ON OP.ID_ORDEMVENDA = OV.ID;";
    private static final String SELECT_ALL_ORDENS_MATERIA = "SELECT * FROM ERP.ORDEMPRODUCAO OP \n"
            + "INNER JOIN ERP.ORDEMPRODUCAO_MATERIAPRIMA OM ON OP.ID = OM.ID_ORDEMPRODUCAO\n"
            + "INNER JOIN ERP.MATERIAPRIMA M ON M.ID = OM.ID_MATERIAPRIMA;";
//    private static final String DELETE_ORDEM_SQL = "DELETE FROM ERP.ORDEMPRODUCAO WHERE (ID = ?)";
//    private static final String UPDATE_ORDEM_SQL = "UPDATE ERP.ORDEMPRODUCAO SET NOME = ?,EMAIL = ? WHERE (ID = ?)";

    public DaoOrdemProducao() {
    }

    public void inserir(OrdemProducao ordem) throws SQLException {
        System.out.println(INSERT_ORDEM_SQL);
        System.out.println(INSERT_ORDEM_MATERIA_SQL);
        List<MateriaPrima> materias = ordem.getMaterias();

        try (Connection connection = ConnectionUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDEM_SQL);
                PreparedStatement preparedStatements = connection.prepareStatement(INSERT_ORDEM_MATERIA_SQL);) {
            preparedStatement.setInt(1, ordem.getId());
            preparedStatement.setInt(2, ordem.getRecurso());
            preparedStatement.setString(3, ordem.getStatu());
            preparedStatement.setString(4, ordem.getDataInicio());
            preparedStatement.setString(5, ordem.getDataTermino());
            preparedStatement.setString(6, ordem.getDataPrevista());
            preparedStatement.setString(7, ordem.getTempoEstimado());
            preparedStatement.setInt(8, ordem.getOrdemVenda().getId());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            try {
                for (MateriaPrima m : materias) {
                    preparedStatements.setInt(1, ordem.getId());
                    preparedStatements.setInt(2, m.getId());
                    preparedStatements.executeUpdate();
                }
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                printSQLException(e);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        try {

        } catch (Exception e) {
        }
    }

//    public OrdemProducao obter(long id) {
//        OrdemProducao ordem = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = ConnectionUtils.getConnection();
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDEM_BY_ID);) {
//            preparedStatement.setLong(1, id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                
//                String nome = rs.getString("NOME");
//                String sexo = rs.getString("SEXO");
//                String datanascimento = rs.getString("DATANASCIMENTO");
//                String cpf = rs.getString("CPF");
//                String endereco = rs.getString("ENDERECO");
//                String telefone = rs.getString("TELEFONE");
//                String email = rs.getString("EMAIL");
////                ordem = new Cliente(id, nome, sexo, datanascimento, cpf, endereco, telefone, email);
//                
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return ordem;
//    }
//
    public List<OrdemProducao> listar() {

        System.out.println(SELECT_ALL_ORDENS_VENDA);
        System.out.println(SELECT_ALL_ORDENS_MATERIA);
        List<OrdemProducao> lista = new ArrayList<>();
        
        try (Connection connection = ConnectionUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDENS_VENDA);
                PreparedStatement preparedStatements = connection.prepareStatement(SELECT_ALL_ORDENS_VENDA);) {
            System.out.println(preparedStatement);
            System.out.println(preparedStatements);

            ResultSet resultVenda = preparedStatement.executeQuery();
            ResultSet resultMateria = preparedStatements.executeQuery();

            while (resultVenda.next()) {
                int id_ordem = resultVenda.getInt("ID");
                int recursos = resultVenda.getInt("RECURSOS");
                String status = resultVenda.getString("STATU");
                String dataInicio = resultVenda.getString("DATAINICIO");
                String dataTermino = resultVenda.getString("DATATERMINO");
                String dataPrev = resultVenda.getString("DATAPREV");
                String tempoEstimado = resultVenda.getString("TEMPOESTIMADO");
                
                int id_venda = resultVenda.getInt("ID_ORDEMVENDA");
                String produto = resultVenda.getString("PRODUTO");
                int quantidade = resultVenda.getInt("QUANTIDADE");
                OrdemVenda venda = new OrdemVenda();
                venda.setId(id_venda);
                venda.setProduto(produto);
                venda.setQuantidadeProd(quantidade);
                
                List<MateriaPrima> materias = new ArrayList<>();
                for (int i = 0; i < resultMateria.getFetchSize(); i++) {
                    int id_materia = resultMateria.getInt("ID_MATERIAPRIMA");
                    String nome = resultMateria.getString("NOME");
                    int quantidadeMateria = resultMateria.getInt("QUANTIDADE");
                    String fabricante = resultMateria.getString("FABRICANTE");
                    boolean selecionado = resultMateria.getBoolean("SELECIONADO");
                    
                    materias.add(new MateriaPrima(id_materia, nome, quantidadeMateria, fabricante, selecionado));
                }
                lista.add(new OrdemProducao(id_ordem, venda, materias, recursos, status, 
                        dataInicio, dataTermino, dataPrev, tempoEstimado));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return lista;
    }
//
//    public boolean deletar(int id) throws SQLException {
//        boolean rowDeleted;
//        try (Connection connection =  ConnectionUtils.getConnection(); 
//            PreparedStatement statement = connection.prepareStatement(DELETE_ORDEM_SQL);) {
//            statement.setInt(1, id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
//        return rowDeleted;
//    }
//
//    public boolean editar(OrdemProducao ordem) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection =  ConnectionUtils.getConnection();
//            PreparedStatement statement = connection.prepareStatement(UPDATE_ORDEM_SQL);) {
////            statement.setString(1, ordem.getNome());
////            statement.setString(2, ordem.getSexo());
////            statement.setString(3, ordem.getDataNascimento());
////            statement.setString(4, ordem.getCpf());
////            statement.setString(5, ordem.getEndereco());
////            statement.setString(6, ordem.getTelefone());
////            statement.setString(7, ordem.getEmail());
//            statement.setLong(8, ordem.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
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
