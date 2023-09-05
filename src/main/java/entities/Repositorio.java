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
public class Repositorio {
    
    private Integer id;
    private String linkEmenta;
    private Date dataFim;
    private String referencia;
    private String nomeCompleto;
    
    public Repositorio() {
        
    }

    public Repositorio(Integer id, String linkEmenta, Date dataFim, String referencia, String nomeCompleto) {
        this.id = id;
        this.linkEmenta = linkEmenta;
        this.dataFim = dataFim;
        this.referencia = referencia;
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkEmenta() {
        return linkEmenta;
    }

    public void setLinkEmenta(String linkEmenta) {
        this.linkEmenta = linkEmenta;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }  
}