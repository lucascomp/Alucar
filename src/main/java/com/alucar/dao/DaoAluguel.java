package com.alucar.dao;

import com.alucar.dao.banco.ConFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DaoAluguel {
    
    private Connection conexao;
    private Statement comando;
    
    public void cancelar(int codAluguel, int codAssociado) {
        conectar();
        try {
            ResultSet rs = comando.executeQuery("select * from Aluguel where Cod_Aluguel = " + codAluguel + " and Cod_Associado = " + codAssociado + ";");
            if(rs.next()) {
                try {
                    comando.executeUpdate("update Aluguel set DataCancelamento = now() where Cod_Aluguel = " + codAluguel + ";");
                    JOptionPane.showMessageDialog(null, "Aluguel cancelado com sucesso");
                }
                catch(SQLException e) {
                    int erro = Integer.parseInt(e.getSQLState());
                    if(erro == 99997) {
                        JOptionPane.showMessageDialog(null, "Não é mais possível realizar cancelamento para este aluguel");
                    }
                    else {
                        imprimeErro("Erro. O aplicativo será fechado.");
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Este aluguel não pertence a você");
            }
        }
        catch(SQLException e) {
            imprimeErro("Erro. O aplicativo será fechado.");   
        }
        finally {
            fechar();
        }
    }
    
    public void inserir(int codAssociado, int codCarro, String dataInicio, String dataFim) {
        conectar();
        try {
            comando.executeUpdate("INSERT INTO Aluguel (Cod_Associado, Cod_Carro, DataAluguel, InicioAluguel, FimAluguel) values (" + codAssociado + ", " + codCarro + ", now(), '" + String.format("%s-%s-%s %s:00:00", dataInicio.substring(6, 10), dataInicio.substring(3, 5), dataInicio.substring(0, 2), dataInicio.substring(11)) + "', '" + String.format("%s-%s-%s %s:00:00", dataFim.substring(6, 10), dataFim.substring(3, 5), dataFim.substring(0, 2), dataFim.substring(11)) + "')");
            ResultSet rs = comando.executeQuery("SELECT * FROM Aluguel order by Cod_Aluguel desc limit 1;");
            rs.next();
            JOptionPane.showMessageDialog(null, "Aluguel marcado com sucesso!\nCódigo do Aluguel: " + rs.getInt("Cod_Aluguel") + "\nGuarde este código para caso necessite cancelar este aluguel");
        }
        catch(SQLException e) {
            int erro = e.getErrorCode();
            if(erro == 1292) {
                JOptionPane.showMessageDialog(null, "Data de Início e/ou data de Fim de Aluguel inválidos\n" + e.getMessage());
            }
            else {
                erro = Integer.parseInt(e.getSQLState());
                switch (erro) {
                    case 99996:
                        JOptionPane.showMessageDialog(null, "Um aluguel só pode durar entre 4 e 24 horas");
                        break;
                    case 99995:
                        JOptionPane.showMessageDialog(null, "A data de início do Aluguel tem que ser maior do que a data do aluguel");
                        break;
                    case 99998:
                        JOptionPane.showMessageDialog(null, "Este carro já tem Aluguel marcado dentro do período solicitado");
                        break;
                    case 99999:
                        JOptionPane.showMessageDialog(null, "Você já tem aluguel marcado dentro deste período solicitado");
                        break;
                    default:
                        imprimeErro("Erro. O aplicativo será fechado.");
                        break;
                }
            }
        }
        finally {
            fechar();
        }
    }
    
    public Double fatura(int codAssociado) {
        conectar();
        ResultSet rs;
        try {
            rs = comando.executeQuery("select sum(C.PrecoHora * timestampdiff(minute, A.InicioAluguel, A.FimAluguel) / 60) as FaturaMensal from Aluguel A, Carro C, Associado Ass where A.Cod_Carro = C.Cod_Carro and isnull(A.DataCancelamento) and A.Cod_Associado = " + codAssociado + " and A.Cod_Associado = Ass.Cod_Associado and month(A.InicioAluguel) = month(now()) and year(A.InicioAluguel) = year(now());");
            if(rs.next()) {
                Double fatura;
                fatura = rs.getDouble("FaturaMensal");
                fechar();
                return fatura;
            }
            else {
                fechar();
                return 0.0;
            }
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return null;
        }
    }
    
    public void conectar() {
        try {
            conexao = ConFactory.getConnection();
            comando = conexao.createStatement();
        }
        catch(SQLException | ClassNotFoundException e) {
            imprimeErro("Erro. O aplicativo será fechado.");
        }
    }
    
    public void fechar() {
        try {
            comando.close();
            conexao.close();
        }
        catch(SQLException e) {
            imprimeErro("Erro. O aplicativo será fechado.");
        }
    }
    
    public void imprimeErro(String msg) {
        JOptionPane.showMessageDialog(null, msg);
        System.exit(0);
    }
    
}
