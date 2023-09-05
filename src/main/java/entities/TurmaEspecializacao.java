/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;

/**
 *
 * @author vinij
 */
public class TurmaEspecializacao {
    
    private Integer id;
    private TrilhaEscolhida trilhaEscolhida;
    private Date dataInicio;
    private Date dataFim;
    
    public TurmaEspecializacao() {
        
    }

    public TurmaEspecializacao(Integer id, TrilhaEscolhida trilhaEscolhida, Date dataInicio, Date dataFim) {
        this.id = id;
        this.trilhaEscolhida = trilhaEscolhida;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrilhaEscolhida getTrilhaEscolhida() {
        return trilhaEscolhida;
    }

    public void setTrilhaEscolhida(TrilhaEscolhida trilhaEscolhida) {
        this.trilhaEscolhida = trilhaEscolhida;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}