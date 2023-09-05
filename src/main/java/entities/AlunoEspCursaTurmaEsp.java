/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class AlunoEspCursaTurmaEsp {
    
    private Integer id;
    private AlunoEspecializacao alunoEsp;
    private TurmaEspecializacao turmaEsp;
    private Float notaFinal;
    
    public AlunoEspCursaTurmaEsp() {
        
    }

    public AlunoEspCursaTurmaEsp(Integer id, AlunoEspecializacao alunoEsp, TurmaEspecializacao turmaEsp, Float notaFinal) {
        this.id = id;
        this.alunoEsp = alunoEsp;
        this.turmaEsp = turmaEsp;
        this.notaFinal = notaFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlunoEspecializacao getAlunoEsp() {
        return alunoEsp;
    }

    public void setAlunoEsp(AlunoEspecializacao alunoEsp) {
        this.alunoEsp = alunoEsp;
    }

    public TurmaEspecializacao getTurmaEsp() {
        return turmaEsp;
    }

    public void setTurmaEsp(TurmaEspecializacao turmaEsp) {
        this.turmaEsp = turmaEsp;
    }

    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    } 
}