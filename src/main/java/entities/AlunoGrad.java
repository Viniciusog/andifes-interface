/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author dahir
 */
public class AlunoGrad {
    private Integer professor_isf_id;
    private String Poca_file;
    private String Edital_Selecao_File;
    private String Resultado_Selecao_File;
    private String Termo_Turma_Compromisso_File;
    private String Vinculo_File;
            
    public AlunoGrad() {
    
    }

    public AlunoGrad(Integer professor_isf_id, String Poca_file, String Edital_Selecao_File,
                      String Resultado_Selecao_File, String Termo_Turma_Compromisso_File, String Vinculo_File) {
        this.professor_isf_id = professor_isf_id;
        this.Poca_file = Poca_file;
        this.Edital_Selecao_File = Edital_Selecao_File;
        this.Resultado_Selecao_File = Resultado_Selecao_File;
        this.Termo_Turma_Compromisso_File = Termo_Turma_Compromisso_File;
        this.Vinculo_File = Vinculo_File;
    }

    public Integer getProfessor_isf_id() {
        return professor_isf_id;
    }

    public void setProfessor_isf_id(Integer professor_isf_id) {
        this.professor_isf_id = professor_isf_id;
    }

    public String getPoca_file() {
        return Poca_file;
    }

    public void setPoca_file(String Poca_file) {
        this.Poca_file = Poca_file;
    }

    public String getEdital_Selecao_File() {
        return Edital_Selecao_File;
    }

    public void setEdital_Selecao_File(String Edital_Selecao_File) {
        this.Edital_Selecao_File = Edital_Selecao_File;
    }

    public String getResultado_Selecao_File() {
        return Resultado_Selecao_File;
    }

    public void setResultado_Selecao_File(String Resultado_Selecao_File) {
        this.Resultado_Selecao_File = Resultado_Selecao_File;
    }

    public String getTermo_Turma_Compromisso_File() {
        return Termo_Turma_Compromisso_File;
    }

    public void setTermo_Turma_Compromisso_File(String Termo_Turma_Compromisso_File) {
        this.Termo_Turma_Compromisso_File = Termo_Turma_Compromisso_File;
    }

    public String getVinculo_File() {
        return Vinculo_File;
    }

    public void setVinculo_File(String Vinculo_File) {
        this.Vinculo_File = Vinculo_File;
    }
}
