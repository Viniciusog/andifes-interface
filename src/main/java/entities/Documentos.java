/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author dahiwa
 */
public class Documentos {
    private String Titulacao;
    private Boolean Tempo_atuacao;
    private String Proficiencia;
    private String Nivel;
    private String Diploma;
    private String comprov_prof;
    private String comprov_vinc;
    
    public Documentos() {
    
    }
    
    public Documentos(String Titulacao, Boolean Tempo_atuacao, String Proficiencia, String Nivel, String Diploma,
                String comprov_prof, String comprov_vinc) {
        this.Titulacao = Titulacao;
        this.Tempo_atuacao = Tempo_atuacao;
        this.Proficiencia = Proficiencia;
        this.Nivel = Nivel;
        this.Diploma = Diploma;
        this.comprov_prof = comprov_prof;
        this.comprov_vinc = comprov_vinc;
    }
    
    public String getTitulacao() {
        return Titulacao;
    }

    public void setTitulacao(String Titulacao) {
        this.Titulacao = Titulacao;
    }

    public Boolean getTempo_atuacao() {
        return Tempo_atuacao;
    }

    public void setTempo_atuacao(Boolean Tempo_atuacao) {
        this.Tempo_atuacao = Tempo_atuacao;
    }

    public String getProficiencia() {
        return Proficiencia;
    }

    public void setProficiencia(String Proficiencia) {
        this.Proficiencia = Proficiencia;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    public String getDiploma() {
        return Diploma;
    }

    public void setDiploma(String Diploma) {
        this.Diploma = Diploma;
    }

    public String getComprov_prof() {
        return comprov_prof;
    }

    public void setComprov_prof(String comprov_prof) {
        this.comprov_prof = comprov_prof;
    }

    public String getComprov_vinc() {
        return comprov_vinc;
    }

    public void setComprov_vinc(String comprov_vinc) {
        this.comprov_vinc = comprov_vinc;
    }
}
