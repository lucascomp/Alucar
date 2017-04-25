create database Alucar;

use Alucar;

create table Associado
(
	Cod_Associado int not null auto_increment primary key,
	RG varchar(9) not null unique,
	CPF varchar(11) not null unique,
	CNH varchar(11) not null unique,
	Email varchar(30) not null unique,
	Login varchar(5) not null unique,
	Senha varchar(8) not null,
	Nome varchar(40) not null,
	DataNascimento date not null, 
	Endereco varchar(60) not null,
	Telefone varchar(11) not null,
	DataAssociacao datetime not null
);

delimiter $$
create trigger constraint_associado before insert on Associado
	for each row
    begin
		if (new.RG regexp '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') = false then
			signal sqlstate value '99978'
			set message_text = "Erro na constraint ck_rg.";
        end if;
        if (new.CPF regexp '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') = false then
			signal sqlstate value '99979'
			set message_text = "Erro na constraint ck_cpf.";
        end if;
        if (new.CNH regexp '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') = false then
			signal sqlstate value '99980'
			set message_text = "Erro na constraint ck_cnh.";
        end if;
        if (new.Login regexp '[A-Za-z][A-Za-z][A-Za-z][A-Za-z][A-Za-z]') = false then
			signal sqlstate value '99981'
			set message_text = "Erro na constraint ck_login.";
        end if;
        if (length(new.Senha) > 4) = false then
			signal sqlstate value '99982'
			set message_text = "Erro na constraint ck_senha.";
        end if;
		if (new.Nome regexp '^[A-Za-z éáíóúôêâ]+$') = false then
			signal sqlstate value '99983'
			set message_text = "Erro na constraint ck_nome.";
		end if;
		if (new.DataNascimento > DATE_SUB(now(), INTERVAL 18 year) or new.DataNascimento < DATE_SUB(now(), INTERVAL 100 year)) then
			signal sqlstate value '99984'
			set message_text = "Erro na constraint ck_nascimento.";
		end if;
		if (new.Telefone regexp '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or new.telefone regexp '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') = false then
			signal sqlstate value '99985'
			set message_text = "Erro na constraint ck_telefone.";
		end if;
		if (new.DataAssociacao < '2016-11-19 23:59:59') then
			signal sqlstate value '99986'
			set message_text = "Erro na constraint ck_associacao.";
		end if;
	end$$
delimiter ;

create table Carro
(
	Cod_Carro int not null auto_increment primary key,
	Placa varchar(7) not null unique,
	Modelo varchar(15) not null,
	Marca varchar(15) not null,
	Ano int not null,
	Cor varchar(10) not null,
	QtdPortas int not null,
	ArCondicionado bool not null,
	TipoDirecao varchar(16) not null,
	TipoMarcha varchar(10) not null,
	PrecoHora float not null
);

delimiter $$
create trigger constraint_carro before insert on Carro
	for each row
    begin
		if (new.Placa regexp '[a-z][a-z][a-z][0-9][0-9][0-9][0-9]') = false then
			signal sqlstate value '99987'
			set message_text = "Erro na constraint ck_placa.";
        end if;
        if (new.Ano >= 2000 and new.Ano <= 2016) = false then
			signal sqlstate value '99988'
			set message_text = "Erro na constraint ck_ano.";
        end if;
        if (new.Cor in ('Preto', 'Branco', 'Cinza', 'Azul', 'Vermelho')) = false then
			signal sqlstate value '99989'
			set message_text = "Erro na constraint ck_cor.";
        end if;
        if (new.QtdPortas = 2 or new.QtdPortas = 4) = false then
			signal sqlstate value '99990'
			set message_text = "Erro na constraint ck_portas.";
        end if;
        if (new.TipoDirecao in ('Normal', 'Hidraulica', 'Eletrica', 'Eletrohidraulica')) = false then
			signal sqlstate value '99991'
			set message_text = "Erro na constraint ck_direcao.";
        end if;
        if (new.TipoMarcha in ('Manual', 'Automatico')) = false then
			signal sqlstate value '99992'
			set message_text = "Erro na constraint ck_marcha.";
        end if;
        if (new.PrecoHora > 0) = false then
			signal sqlstate value '99993'
			set message_text = "Erro na constraint ck_precohora.";
        end if;
    end$$
delimiter ;

create table Aluguel
(
	Cod_Aluguel int not null auto_increment primary key,
	Cod_Associado int not null references Associado(Cod_Associado),
	Cod_Carro int not null references Carro(Cod_Carro),
	DataAluguel datetime not null,
	DataCancelamento datetime,
	InicioAluguel datetime not null,
	FimAluguel datetime not null
);

delimiter $$
create trigger constraint_aluguel before insert on Aluguel
	for each row
    begin
		if (new.DataAluguel > '2016-11-18 23:59:59') = false then
			signal sqlstate value '99994'
			set message_text = "Erro na constraint ck_aluguel.";
        end if;
        if (new.InicioAluguel >= new.DataAluguel) = false then
			signal sqlstate value '99995'
			set message_text = "Erro na constraint ck_inicio.";
        end if;
        if (new.FimAluguel BETWEEN date_add(new.InicioAluguel, INTERVAL 4 hour) and date_add(new.InicioAluguel, INTERVAL 24 hour)) = false then
			signal sqlstate value '99996'
			set message_text = "Erro na constraint ck_fim.";
        end if;
        if (day(new.InicioAluguel - new.DataCancelamento) >= 1 or month(new.InicioAluguel - new.DataCancelamento) >= 1 or year(new.InicioAluguel - new.DataCancelamento) >= 1) = false then
			signal sqlstate value '99997'
			set message_text = "Erro na constraint ck_cancelamento.";
        end if;
    end$$

create trigger teste_carro_disponivel before insert on Aluguel
	for each row
	begin
		set @ok = EXISTS (SELECT * FROM Aluguel a WHERE a.Cod_Carro = NEW.Cod_Carro and (NEW.InicioAluguel BETWEEN a.InicioAluguel and a.FimAluguel and NEW.FimAluguel BETWEEN a.InicioAluguel and a.FimAluguel));
		if(@ok) then
			signal sqlstate value '99998'
			set message_text = "Este carro está alugado entre esse período.";
		end if;
	end$$

create trigger teste_associado_disponivel before insert on Aluguel
	for each row
	begin
		set @ok = EXISTS (SELECT * FROM Aluguel a WHERE a.Cod_Associado = New.Cod_Associado and (NEW.InicioAluguel BETWEEN a.InicioAluguel and a.FimAluguel and NEW.FimAluguel BETWEEN a.InicioAluguel and a.FimAluguel));
		if(@ok) then
			signal sqlstate value '99999'
			set message_text = "Associado já tem aluguel marcado pra esse período.";
		end if;
    end$$
delimiter ;

insert into Associado (RG, CPF, CNH, Email, Login, Senha, Nome, DataNascimento, Endereco, Telefone, DataAssociacao) values ('245654364', '23423434346', '42343243532', 'lucas@ime.uerj.br', 'lukes', 'senha', 'Lucas Alves de Sousa', str_to_date('06/09/1995', '%d/%m/%Y'), 'Rua da folha, 539', '21988258261', '2016-11-20 00:00:00');
insert into Associado (RG, CPF, CNH, Email, Login, Senha, Nome, DataNascimento, Endereco, Telefone, DataAssociacao) values ('234355435', '34654567432', '34565367543', 'tiago@ime.uerj.br', 'tiags', '12345678', 'Tiago Rezende da Rocha Vasconcellos', str_to_date('14/02/1996', '%d/%m/%Y'), 'Estrada da Posse, 111', '21909090909','2016-11-20 00:00:00');
insert into Associado (RG, CPF, CNH, Email, Login, Senha, Nome, DataNascimento, Endereco, Telefone, DataAssociacao) values ('232343234', '54353454366', '64645743454', 'flavia@ime.uerj.br', 'flavs', 'esqueci', 'Flávia Avelino', str_to_date('12/10/1993', '%d/%m/%Y'), 'Rua das beldades, 10', '21968023395', '2016-11-20 00:00:00');

insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0001', 'GOL', 'VOLKSWAGEN', 2004, 'Preto', 2, 0, 'Normal', 'Manual', 4.0);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0002', 'JETTA', 'VOLKSWAGEN', 2004, 'Cinza', 2, 0, 'Hidraulica', 'Manual', 4.5);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0003', 'UP', 'VOLKSWAGEN', 2015, 'Vermelho', 4, 1, 'Eletrohidraulica', 'Automatico', 10.0);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0004', 'TIGUAN', 'VOLKSWAGEN', 2004, 'Vermelho', 2, 1, 'Normal', 'Manual', 5.0);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0005', 'VOYAGE', 'VOLKSWAGEN', 2004, 'Azul', 2, 1, 'Normal', 'Manual', 5.5);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0006', 'CELTA', 'GENERAL MOTORS', 2004, 'Branco', 2, 1, 'Hidraulica', 'Manual', 5.5);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0007', 'CORSA', 'GENERAL MOTORS', 2004, 'Branco', 2, 0, 'Normal', 'Manual', 4.0);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0008', 'ONIX', 'GENERAL MOTORS', 2013, 'Cinza', 4, 1, 'Eletrica', 'Automatico', 9.5);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0009', 'FIESTA', 'FORD', 2004, 'Preto', 2, 1, 'Hidraulica', 'Manual', 5.5);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('ABC0010', 'FOCUS', 'FORD', 2004, 'Azul', 2, 0, 'Normal', 'Manual', 4.0);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0001', 'KA', 'FORD', 2004, 'Vermelho', 2, 1, 'Hidraulica', 'Manual', 5.5);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0002', 'UNO', 'FIAT', 2007, 'Azul', 4, 1, 'Hidraulica', 'Automatico', 6.7);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0003', 'PALIO', 'FIAT', 2008, 'Cinza', 4, 1, 'Hidraulica', 'Automatico', 6.9);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0004', 'PUNTO', 'FIAT', 2009, 'Preto', 4, 1, 'Eletrica', 'Automatico', 7.7);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0005', 'CIVIC', 'HONDA', 2004, 'Branco', 4, 1, 'Hidraulica', 'Manual', 6.0);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0006', 'FIT', 'HONDA', 2005, 'Cinza', 4, 1, 'Hidraulica', 'Manual', 6.2);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0007', '206', 'PEUGEOT', 2010, 'Azul', 4, 1, 'Eletrica', 'Automatico', 9.0);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0008', '307', 'PEUGEOT', 2005, 'Azul', 4, 1, 'Hidraulica', 'Manual', 6.2);
insert into Carro (Placa, Modelo, Marca, Ano, Cor, QtdPortas, ArCondicionado, TipoDirecao, TipoMarcha, PrecoHora) values ('CDE0009', 'T6', 'JAC MOTORS', 2009, 'Branco', 4, 1, 'Eletrica', 'Automatico', 8.8);

insert into Aluguel (Cod_Associado, Cod_Carro, DataAluguel, InicioAluguel, FimAluguel) values (1, 1, '2016-11-20', '2016-11-20', '2016-11-21');
insert into Aluguel (Cod_Associado, Cod_Carro, DataAluguel, InicioAluguel, FimAluguel) values (1, 2, '2016-11-21', '2016-11-21', '2016-11-22');
insert into Aluguel (Cod_Associado, Cod_Carro, DataAluguel, InicioAluguel, FimAluguel) values (2, 2, '2016-11-20', '2016-11-20', '2016-11-20 23:59:59');
