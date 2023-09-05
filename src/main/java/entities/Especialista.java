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
public class Especialista {
    private Integer id;
    private String biodata;
    private boolean dispoMinitrar;
    private String titulacao;
    private String lingua;
    private String declaracaoProficiencia;
    private boolean dispoOriEsp;
    private String vinculoFile;
    private String curriculo;
    private Date dataCredenciamento;
    private boolean disponibilidadeAutor;
    private String papeis;
    private boolean resetNeed;
    private String diplomaFile;
    private String linkCnpq;
    private String pocaFile;
    private String registroAutoria;
    private String registroMinistrante;    
    private MembroAcademico membroAcademico;
    
    public Especialista() {
        
    }

    public Especialista(Integer id, String biodata, boolean dispoMinitrar, String titulacao, String lingua, String declaracaoProficiencia, boolean dispoOriEsp, String vinculoFile, String curriculo, Date dataCredenciamento, boolean disponibilidadeAutor, String papeis, boolean resetNeed, String diplomaFile, String linkCnpq, String pocaFile, String registroAutoria, String registroMinistrante, MembroAcademico membroAcademico) {
        this.id = id;
        this.biodata = biodata;
        this.dispoMinitrar = dispoMinitrar;
        this.titulacao = titulacao;
        this.lingua = lingua;
        this.declaracaoProficiencia = declaracaoProficiencia;
        this.dispoOriEsp = dispoOriEsp;
        this.vinculoFile = vinculoFile;
        this.curriculo = curriculo;
        this.dataCredenciamento = dataCredenciamento;
        this.disponibilidadeAutor = disponibilidadeAutor;
        this.papeis = papeis;
        this.resetNeed = resetNeed;
        this.diplomaFile = diplomaFile;
        this.linkCnpq = linkCnpq;
        this.pocaFile = pocaFile;
        this.registroAutoria = registroAutoria;
        this.registroMinistrante = registroMinistrante;
        this.membroAcademico = membroAcademico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public boolean isDispoMinitrar() {
        return dispoMinitrar;
    }

    public void setDispoMinitrar(boolean dispoMinitrar) {
        this.dispoMinitrar = dispoMinitrar;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getDeclaracaoProficiencia() {
        return declaracaoProficiencia;
    }

    public void setDeclaracaoProficiencia(String declaracaoProficiencia) {
        this.declaracaoProficiencia = declaracaoProficiencia;
    }

    public boolean isDispoOriEsp() {
        return dispoOriEsp;
    }

    public void setDispoOriEsp(boolean dispoOriEsp) {
        this.dispoOriEsp = dispoOriEsp;
    }

    public String getVinculoFile() {
        return vinculoFile;
    }

    public void setVinculoFile(String vinculoFile) {
        this.vinculoFile = vinculoFile;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public Date getDataCredenciamento() {
        return dataCredenciamento;
    }

    public void setDataCredenciamento(Date dataCredenciamento) {
        this.dataCredenciamento = dataCredenciamento;
    }

    public boolean isDisponibilidadeAutor() {
        return disponibilidadeAutor;
    }

    public void setDisponibilidadeAutor(boolean disponibilidadeAutor) {
        this.disponibilidadeAutor = disponibilidadeAutor;
    }

    public String getPapeis() {
        return papeis;
    }

    public void setPapeis(String papeis) {
        this.papeis = papeis;
    }

    public boolean isResetNeed() {
        return resetNeed;
    }

    public void setResetNeed(boolean resetNeed) {
        this.resetNeed = resetNeed;
    }

    public String getDiplomaFile() {
        return diplomaFile;
    }

    public void setDiplomaFile(String diplomaFile) {
        this.diplomaFile = diplomaFile;
    }

    public String getLinkCnpq() {
        return linkCnpq;
    }

    public void setLinkCnpq(String linkCnpq) {
        this.linkCnpq = linkCnpq;
    }

    public String getPocaFile() {
        return pocaFile;
    }

    public void setPocaFile(String pocaFile) {
        this.pocaFile = pocaFile;
    }

    public String getRegistroAutoria() {
        return registroAutoria;
    }

    public void setRegistroAutoria(String registroAutoria) {
        this.registroAutoria = registroAutoria;
    }

    public String getRegistroMinistrante() {
        return registroMinistrante;
    }

    public void setRegistroMinistrante(String registroMinistrante) {
        this.registroMinistrante = registroMinistrante;
    }

    public MembroAcademico getMembroAcademico() {
        return membroAcademico;
    }

    public void setMembroAcademico(MembroAcademico membroAcademico) {
        this.membroAcademico = membroAcademico;
    }  
}