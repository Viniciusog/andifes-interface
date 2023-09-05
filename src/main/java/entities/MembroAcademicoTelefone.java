/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class MembroAcademicoTelefone {
       
    private Integer id;
    private MembroAcademico membroAcademico;
    private String ddi;
    private String ddd;
    private String numero;
    
    public MembroAcademicoTelefone() {
        
    }

    public MembroAcademicoTelefone(Integer id, MembroAcademico membroAcademico, String ddi, String ddd, String numero) {
        this.id = id;
        this.membroAcademico = membroAcademico;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
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

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }  
}