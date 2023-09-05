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
public class Orientacao {
    
    private Integer id;
    private AlunoProfessorISF alunoProfessorISF;
    private Especialista especialista;
    private Date dataInicial;
    private Date dataFinal;
    private String status;
    
    public Orientacao() {
        
    }

    public Orientacao(Integer id, AlunoProfessorISF alunoProfessorISF, Especialista especialista, Date dataInicial, Date dataFinal) {
        this.id = id;
        this.alunoProfessorISF = alunoProfessorISF;
        this.especialista = especialista;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlunoProfessorISF getAlunoProfessorISF() {
        return alunoProfessorISF;
    }

    public void setAlunoProfessorISF(AlunoProfessorISF alunoProfessorISF) {
        this.alunoProfessorISF = alunoProfessorISF;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    } 

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }
    
}
