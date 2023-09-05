/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class TrilhaEscolhida {
    private Integer id;
    private TrilhaOfertada trilhaOfertada;
    private ComponenteCurricular componenteCurricular;
    
    public TrilhaEscolhida() {
        
    }

    public TrilhaEscolhida(Integer id, TrilhaOfertada trilhaOfertada, ComponenteCurricular componenteCurricular) {
        this.id = id;
        this.trilhaOfertada = trilhaOfertada;
        this.componenteCurricular = componenteCurricular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrilhaOfertada getTrilhaOfertada() {
        return trilhaOfertada;
    }

    public void setTrilhaOfertada(TrilhaOfertada trilhaOfertada) {
        this.trilhaOfertada = trilhaOfertada;
    }

    public ComponenteCurricular getComponenteCurricular() {
        return componenteCurricular;
    }

    public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    } 
}