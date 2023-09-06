/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vinij
 */
public class MembroAcademico {
    
    private int id;
    private String identidade;
    private String nacionalidade;
    private String paisDeResidencia;
    private String nomeCompleto;
    private Date dataNascimento;
    private String nomeDaMae;
    private String genero;
    private List<MembroAcademicoTelefone> telefones = new ArrayList<>();
    private List<MembroAcademicoEndereco> enderecos = new ArrayList<>();
    private List<MembroAcademicoEmail> emails = new ArrayList<>();
    
    public MembroAcademico() {

    }

    public MembroAcademico(int id, String identidade, String nacionalidade, String paisDeResidencia, String nomeCompleto, Date dataNascimento, String nomeDaMae, String genero) {
        this.id = id;
        this.identidade = identidade;
        this.nacionalidade = nacionalidade;
        this.paisDeResidencia = paisDeResidencia;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.nomeDaMae = nomeDaMae;
        this.genero = genero;
    }
    
    public void addEndereco(MembroAcademicoEndereco e) {
        this.enderecos.add(e);
    }
    
    public void removerEndereco(MembroAcademicoEndereco e) {
        this.enderecos.remove(e);
    }
    
    public void addTelefone(MembroAcademicoTelefone t) {
        this.telefones.add(t);
    }
    
    public void removerTelefone(MembroAcademicoTelefone e) {
        this.telefones.remove(e);
    }
    
    public void addEmail(MembroAcademicoEmail e) {
        this.emails.add(e);
    }
    
    public void removerEmail(MembroAcademicoEmail e) {
        this.emails.remove(e);
    }

    public List<MembroAcademicoTelefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<MembroAcademicoTelefone> telefones) {
        this.telefones = telefones;
    }

    public List<MembroAcademicoEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<MembroAcademicoEmail> emails) {
        this.emails = emails;
    }
    
    

    public List<MembroAcademicoEndereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<MembroAcademicoEndereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPaisDeResidencia() {
        return paisDeResidencia;
    }

    public void setPaisDeResidencia(String paisDeResidencia) {
        this.paisDeResidencia = paisDeResidencia;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
           
      
    
}
