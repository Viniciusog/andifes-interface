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
public class AlunoEspecializacao {
    
    private Integer id;
    private AlunoProfessorISF alunoProfessorISF;
    private Date dataIngresso;
    private Date dataConclusao;
    private String diplomaFile;
    private String titulacao;
    private String registroMinistrante;
    
    public AlunoEspecializacao() {
        
    }

    public AlunoEspecializacao(Integer id, AlunoProfessorISF alunoProfessorISF, Date dataIngresso, Date dataConclusao, String diplomaFile, String titulacao, String registroMinistrante) {
        this.id = id;
        this.alunoProfessorISF = alunoProfessorISF;
        this.dataIngresso = dataIngresso;
        this.dataConclusao = dataConclusao;
        this.diplomaFile = diplomaFile;
        this.titulacao = titulacao;
        this.registroMinistrante = registroMinistrante;
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

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getDiplomaFile() {
        return diplomaFile;
    }

    public void setDiplomaFile(String diplomaFile) {
        this.diplomaFile = diplomaFile;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getRegistroMinistrante() {
        return registroMinistrante;
    }

    public void setRegistroMinistrante(String registroMinistrante) {
        this.registroMinistrante = registroMinistrante;
    }
}