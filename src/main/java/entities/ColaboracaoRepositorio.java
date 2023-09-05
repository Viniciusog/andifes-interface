/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class ColaboracaoRepositorio {
    private Integer id;
    private Repositorio repositorio;
    private Orientacao orientacao;
    
    public ColaboracaoRepositorio() {
        
    }

    public ColaboracaoRepositorio(Integer id, Repositorio repositorio, Orientacao orientacao) {
        this.id = id;
        this.repositorio = repositorio;
        this.orientacao = orientacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Orientacao getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(Orientacao orientacao) {
        this.orientacao = orientacao;
    }  
}