# Alucar - Projeto final de Banco de Dados I

Para executar o sistema, siga os seguintes passos:

* Baixe e instale o banco de dados MySQL. Crie um servidor localhost:3306 com usuário: root e senha: teste123 (OBS: o sistema está programado para funcionar apenas sob estas condições). Caso você tenha o MySQL instalado, porém sua senha é diferente de 'teste123', mudar a senha é simples:
  * Faça login no servidor usando o Workbench.
  * Acesse o menu Server > Users and Privileges. Digite sua senha para prosseguir, escolha e selecione a opção 'root' na coluna 'User' e clique em 'Expire Password'.
  * Logo após, você deve fechar o Workbench e abri-lô de novo. Tente logar. Nessa hora, será solicitado uma senha nova. Então, mude a senha para 'teste123' (sem aspas).
  * Depois que testar o sistema, volte para sua antiga senha repetindo este simples processo.
* Baixe este repositório. Observe que, apesar de não ser uma boa prática, este repositório inclui a pasta 'target', tendo como objetivo facilitar a vida de quem vai testar o sistema.
* Execute o scriptCriarAlucar.sql no servidor localhost:3306 para criar o banco de dados que o sistema usa. Este script está na raíz do repositório.
* Entre na pasta target e execute o jar alucar-1.0-SNAPSHOT

Este projeto é um projeto Maven.

Desenvolvido por: Lucas Alves
