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
public class AlunoProfessorISF {
    private Integer id;
    private String ra;
    private MembroAcademico membroAcademico;
    
    public AlunoProfessorISF() {
        
    }

    public AlunoProfessorISF(Integer id, String ra, MembroAcademico membroAcademico) {
        this.id = id;
        this.ra = ra;
        this.membroAcademico = membroAcademico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public MembroAcademico getMembroAcademico() {
        return membroAcademico;
    }

    public void setMembroAcademico(MembroAcademico membroAcademico) {
        this.membroAcademico = membroAcademico;
    }   
}