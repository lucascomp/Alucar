package com.alucar.dao;

import com.alucar.dao.banco.ConFactory;
import com.alucar.modelos.Associado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DaoAssociado {
    
    private Connection conexao;
    private Statement comando;
    
    public void inserir(Associado associado) {
        conectar();
        try {
            comando.executeUpdate("INSERT INTO Associado (RG, CPF, CNH, Email, Login, Senha, Nome, DataNascimento, Endereco, Telefone, DataAssociacao) VALUES(" + associado.getRg() + ", " + associado.getCpf() + ", " + associado.getCnh() + ", '" + associado.getEmail() + "', '" + associado.getLogin() + "', '" + associado.getSenha() + "', '" + associado.getNome() + "', '" + String.format("%s-%s-%s", associado.getNascimento().substring(6), associado.getNascimento().substring(3, 5), associado.getNascimento().substring(0, 2)) + "', '" + 
associado.getEndereco() + "', " + associado.getTelefone() + ", now());");
        }
        catch(SQLException e) {
            imprimeErro("Erro. O aplicativo será fechado.");
        }
        finally {
            fechar();
        }
    }
    
    public void apagar(String login) {
        conectar();
        try {
            comando.executeUpdate("DELETE FROM Associado WHERE Login = '" + login + "';");
        }
        catch(SQLException e) {
            imprimeErro("Erro. O aplicativo será fechado.");
        }
        finally {
            fechar();
        }
    }
    
    public void atualizar(String login, Associado associado) {
        conectar();
        String com = "UPDATE Associado SET RG = " + associado.getRg() + ", CPF = " + associado.getCpf() + ", CNH = " + associado.getCnh() + ", Email = '" + associado.getEmail() + "', Login = '" + associado.getLogin() + "', Senha = '" + associado.getSenha() + "', Nome = '" + associado.getNome() + "', DataNascimento = '" + associado.getNascimento()+ "', Endereco = '" + associado.getEndereco() + "', Telefone = " + associado.getTelefone() + " WHERE Login = '" + login + "';";
        try {
            comando.executeUpdate(com);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally {
            fechar();
        }
    }
    
    public Associado logar(String login, String senha) {
        conectar();
        Associado resultado = new Associado();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT * FROM Associado WHERE CAST(Login AS BINARY) = '" + login + "' and CAST(Senha AS BINARY) = '" + senha + "';");
            if(rs.next()) {
                resultado.setCod(rs.getInt("Cod_Associado"));
                resultado.setRg(rs.getString("RG"));
                resultado.setCpf(rs.getString("CPF"));
                resultado.setCnh(rs.getString("CNH"));
                resultado.setEmail(rs.getString("Email"));
                resultado.setLogin(rs.getString("Login"));
                resultado.setSenha(rs.getString("Senha"));
                resultado.setNome(rs.getString("Nome"));
                resultado.setNascimento(rs.getString("DataNascimento"));
                resultado.setEndereco(rs.getString("Endereco"));
                resultado.setTelefone(rs.getString("Telefone"));
                resultado.setAssociacao(rs.getString("DataAssociacao"));
                fechar();
                return resultado;
            }
            else {
                fechar();
                return null;
            }    
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return null;
        }
    }
    
    public boolean existeRg(String rg) {
        conectar();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT RG FROM Associado WHERE RG = '" + rg + "';");
            if(rs.next()) {
                fechar();
                return true;
            }
            else {
                fechar();
                return false;
            }
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return false;
        }
    }
    public boolean existeCpf(String cpf) {
        conectar();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT CPF FROM Associado WHERE CPF = '" + cpf + "';");
            if(rs.next()) {
                fechar();
                return true;
            }
            else {
                fechar();
                return false;
            }
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return false;
        }
    }
    public boolean existeCnh(String cnh) {
        conectar();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT CNH FROM Associado WHERE CNH = '" + cnh + "';");
            if(rs.next()) {
                fechar();
                return true;
            }
            else {
                fechar();
                return false;
            }
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return false;
        }
    }
    public boolean existeEmail(String email) {
        conectar();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT Email FROM Associado WHERE Email = '" + email + "';");
            if(rs.next()) {
                fechar();
                return true;
            }
            else {
                fechar();
                return false;
            }
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return false;
        }
    }
    public boolean existeTelefone(String telefone) {
        conectar();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT Telefone FROM Associado WHERE Telefone = '" + telefone + "';");
            if(rs.next()) {
                fechar();
                return true;
            }
            else {
                fechar();
                return false;
            }
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return false;
        }
    }
    
    public boolean existeLogin(String login) {
        conectar();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT Login FROM Associado WHERE Login = '" + login + "';");
            if(rs.next()) {
                fechar();
                return true;
            }
            else {
                fechar();
                return false;
            }
        }
        catch(SQLException e) {
            fechar();
            imprimeErro("Erro. O aplicativo será fechado.");
            return false;
        }
    }
    
    public void conectar() {
        try {
            conexao = ConFactory.getConnection();
            comando = conexao.createStatement();
        }
        catch(SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getStackTrace());
            imprimeErro("Erro. O aplicativo será fechado.");
        }
    }
    
    public void fechar() {
        try {
            comando.close();
            conexao.close();
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getStackTrace());
            imprimeErro("Erro. O aplicativo será fechado.");
        }
    }
    
    public void imprimeErro(String msg) {
        JOptionPane.showMessageDialog(null, msg);
        System.exit(0);
    }
}