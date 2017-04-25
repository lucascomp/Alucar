package com.alucar.modelos;

public class Aluguel {
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public int getAssociado() {
        return associado;
    }
    public void setAssociado(int associado) {
        this.associado = associado;
    }
    public int getCarro() {
        return carro;
    }
    public void setCarro(int carro) {
        this.carro = carro;
    }
    public String getDataAluguel() {
        return dataAluguel;
    }
    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    public String getDataCancelamento() {
        return dataCancelamento;
    }
    public void setDataCancelamento(String dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }
    
    private int cod;
    private int associado;
    private int carro;
    private String dataAluguel;
    private String dataInicio;
    private String dataFim;
    private String dataCancelamento;
}
