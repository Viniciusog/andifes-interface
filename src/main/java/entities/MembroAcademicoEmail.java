/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class MembroAcademicoEmail {
    
    private Integer id;
    private MembroAcademico membroAcademico;
    private String valor;
    private String tipo;
    
    public MembroAcademicoEmail() {
        
    }

    public MembroAcademicoEmail(Integer id, MembroAcademico membroAcademico, String valor, String tipo) {
        this.id = id;
        this.membroAcademico = membroAcademico;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MembroAcademico getMembroAcademico() {
        return membroAcademico;
    }

    public void setMembroAcademico(MembroAcademico membroAcademico) {
        this.membroAcademico = membroAcademico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    } 
}