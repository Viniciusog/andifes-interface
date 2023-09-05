/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class TrilhaOfertada {
    
    private Integer id;
    private Integer cargaHoraria;
    private String idioma;
    private String linkEmenta;
    private Integer horasTeoricas;
    private Integer horasPraticas;
    
    public TrilhaOfertada() {
        
    }

    public TrilhaOfertada(Integer id, Integer cargaHoraria, String idioma, String linkEmenta, Integer horasTeoricas, Integer horasPraticas) {
        this.id = id;
        this.cargaHoraria = cargaHoraria;
        this.idioma = idioma;
        this.linkEmenta = linkEmenta;
        this.horasTeoricas = horasTeoricas;
        this.horasPraticas = horasPraticas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLinkEmenta() {
        return linkEmenta;
    }

    public void setLinkEmenta(String linkEmenta) {
        this.linkEmenta = linkEmenta;
    }

    public Integer getHorasTeoricas() {
        return horasTeoricas;
    }

    public void setHorasTeoricas(Integer horasTeoricas) {
        this.horasTeoricas = horasTeoricas;
    }

    public Integer getHorasPraticas() {
        return horasPraticas;
    }

    public void setHorasPraticas(Integer horasPraticas) {
        this.horasPraticas = horasPraticas;
    } 
}