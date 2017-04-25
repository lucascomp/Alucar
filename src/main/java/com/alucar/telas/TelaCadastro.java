/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alucar.telas;

import com.alucar.dao.DaoAssociado;
import com.alucar.modelos.Associado;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {

    public TelaCadastro() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        textoEndereco = new javax.swing.JTextField();
        textoRG = new javax.swing.JTextField();
        textoCPF = new javax.swing.JTextField();
        textoCNH = new javax.swing.JTextField();
        textoEmail = new javax.swing.JTextField();
        textoTelefone = new javax.swing.JTextField();
        textoSenha1 = new javax.swing.JPasswordField();
        textoSenha2 = new javax.swing.JPasswordField();
        textoLogin = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        textoNascimento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Faça seu cadastro!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Endereço:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("RG:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("CPF:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("CNH:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("E-mail:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Telefone:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Data de Nascimento:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Escolha seu Login:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Escolha sua Senha:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Confirme sua senha:");

        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoEndereco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoSenha1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(textoSenha2))))
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(textoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            
            Associado associado = new Associado();
            associado.setRg(textoRG.getText());
            associado.setCpf(textoCPF.getText());
            associado.setCnh(textoCNH.getText());
            associado.setEmail(textoEmail.getText());
            associado.setLogin(textoLogin.getText());
            associado.setSenha(textoSenha1.getText());
            associado.setNome(textoNome.getText());
            associado.setNascimento(textoNascimento.getText());
            associado.setEndereco(textoNome.getText());
            associado.setTelefone(textoTelefone.getText());
            
            String senhaConf = textoSenha2.getText();
            
            DaoAssociado daoAssociado = new DaoAssociado();
        
            if(associado.getNome().length() < 1)
                JOptionPane.showMessageDialog(this, "Insira seu nome.");
            else if(associado.getNome().length() > 40)
                JOptionPane.showMessageDialog(this, "Nome muito longo.");
            else if(associado.getEndereco().length() < 1)
                JOptionPane.showMessageDialog(this, "Insira seu endereço.");
            else if(associado.getEndereco().length() > 60)
                JOptionPane.showMessageDialog(this, "Endereço muito longo.");
            else if(associado.getRg().length() != 9 || Pattern.matches("[a-zA-Z]+", associado.getRg()))
                JOptionPane.showMessageDialog(this, "RG inválido. Insira somente números");
            else if(daoAssociado.existeRg(associado.getRg()))
                JOptionPane.showMessageDialog(this, "O RG inserido já está cadastrado.");
            else if(associado.getCpf().length() != 11 || Pattern.matches("[a-zA-Z]+", associado.getCpf()))
                JOptionPane.showMessageDialog(this, "CPF inválido. Insira somente números");
            else if(daoAssociado.existeCpf(associado.getCpf()))
                JOptionPane.showMessageDialog(this, "O CPF inserido já está cadastrado.");
            else if(associado.getCnh().length() != 11 || Pattern.matches("[a-zA-Z]+", associado.getCnh()))
                JOptionPane.showMessageDialog(this, "CNH inválida.");
            else if(daoAssociado.existeCnh(associado.getCnh()))
                JOptionPane.showMessageDialog(this, "A CNH inserida já está cadastrado.");
            else if(associado.getEmail().length() < 7 || !associado.getEmail().contains("@") || associado.getEmail().length() > 30)
                JOptionPane.showMessageDialog(this, "E-mail inválido.");
            else if(daoAssociado.existeEmail(associado.getEmail()))
                JOptionPane.showMessageDialog(this, "O E-mail inserido já está cadastrado.");
            else if(Pattern.matches("[a-zA-Z]+", associado.getTelefone()) || associado.getTelefone().length() > 11)
                JOptionPane.showMessageDialog(this, "Telefone inválido.");
            else if(associado.getTelefone().length() < 10)
                JOptionPane.showMessageDialog(this, "Telefone inválido. Verifique o DDD.");
            else if(daoAssociado.existeTelefone(associado.getTelefone()))
                JOptionPane.showMessageDialog(this, "O telefone inserido já está cadastrado.");
            else if(!Pattern.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]", associado.getNascimento()))
                JOptionPane.showMessageDialog(this, "Insira sua data de nascimento no formato dd/mm/aaaa.");
            else if(Integer.parseInt(associado.getNascimento().substring(6)) > 1998 || Integer.parseInt(associado.getNascimento().substring(6)) < 1900 || Integer.parseInt(associado.getNascimento().substring(3, 5)) > 12 || Integer.parseInt(associado.getNascimento().substring(3, 5)) < 1 || Integer.parseInt(associado.getNascimento().substring(0, 2)) < 1 || (Integer.parseInt(associado.getNascimento().substring(3, 5)) == 2 && (Integer.parseInt(associado.getNascimento().substring(6)) % 400 == 0 || (Integer.parseInt(associado.getNascimento().substring(6)) % 4 == 0 && Integer.parseInt(associado.getNascimento().substring(6)) % 100 != 0)) && Integer.parseInt(associado.getNascimento().substring(0, 2)) > 29)|| (Integer.parseInt(associado.getNascimento().substring(3, 5)) == 2 && !(Integer.parseInt(associado.getNascimento().substring(6)) % 400 == 0 || (Integer.parseInt(associado.getNascimento().substring(6)) % 4 == 0 && Integer.parseInt(associado.getNascimento().substring(6)) % 100 != 0)) && Integer.parseInt(associado.getNascimento().substring(0, 2)) > 28) || ((Integer.parseInt(associado.getNascimento().substring(3, 5)) == 1 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 3 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 5 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 7 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 8 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 10 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 12) && Integer.parseInt(associado.getNascimento().substring(0, 2)) > 31) || ((Integer.parseInt(associado.getNascimento().substring(3, 5)) == 4 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 6 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 9 || Integer.parseInt(associado.getNascimento().substring(3, 5)) == 11) && Integer.parseInt(associado.getNascimento().substring(0, 2)) > 30))
                JOptionPane.showMessageDialog(this, "Data de nascimento inválida.");
            else if(!Pattern.matches("[a-z][a-z][a-z][a-z][a-z]", associado.getLogin()))
                JOptionPane.showMessageDialog(this, "Seu login deve conter 5(cinco) letras.");
            else if(daoAssociado.existeLogin(associado.getLogin()))
                JOptionPane.showMessageDialog(this, "Este login já está cadastrado.");
            else if(associado.getSenha().length() < 5)
                JOptionPane.showMessageDialog(this, "Sua senha deve conter 5 caracteres no mínimo.");
            else if(!associado.getSenha().equals(senhaConf))
                JOptionPane.showMessageDialog(this, "As senhas não coincidem.");
            else {
                daoAssociado.inserir(associado);
                JOptionPane.showMessageDialog(this, "Cadastro criado com sucesso!");
                TelaLogin tela = new TelaLogin();
                tela.setVisible(true);
                dispose();
            }
      //  } catch (SQLException ex) {
       //     JOptionPane.showMessageDialog(this, "");
      //  } catch (ClassNotFoundException ex) {
       //     JOptionPane.showMessageDialog(this, "");
      //  }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField textoCNH;
    private javax.swing.JTextField textoCPF;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoEndereco;
    private javax.swing.JTextField textoLogin;
    private javax.swing.JTextField textoNascimento;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoRG;
    private javax.swing.JPasswordField textoSenha1;
    private javax.swing.JPasswordField textoSenha2;
    private javax.swing.JTextField textoTelefone;
    // End of variables declaration//GEN-END:variables
}
