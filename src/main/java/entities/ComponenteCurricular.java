/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class ComponenteCurricular {
    
    private Integer id;
    private String codigo;
    private Integer cargaHoraria;
    private String eixoTematico;
    private boolean obrigatoriedade;
    private String tipoDisciplina;
    private String nomeCompleto;
    
    public ComponenteCurricular() {
        
    }

    public ComponenteCurricular(Integer id, String codigo, Integer cargaHoraria, String eixoTematico, boolean obrigatoriedade, String tipoDisciplina, String nomeCompleto) {
        this.id = id;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.eixoTematico = eixoTematico;
        this.obrigatoriedade = obrigatoriedade;
        this.tipoDisciplina = tipoDisciplina;
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEixoTematico() {
        return eixoTematico;
    }

    public void setEixoTematico(String eixoTematico) {
        this.eixoTematico = eixoTematico;
    }

    public boolean isObrigatoriedade() {
        return obrigatoriedade;
    }

    public void setObrigatoriedade(boolean obrigatoriedade) {
        this.obrigatoriedade = obrigatoriedade;
    }

    public String getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(String tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    } 
}