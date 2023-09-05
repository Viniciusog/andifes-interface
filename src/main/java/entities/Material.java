/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author vinij
 */
public class Material {
    
    private Integer id;
    private ComponenteCurricular componenteCurricular;
    private String enderecoLink;
    /*obsoleto, incompleto, completo*/
    private String estado;
    private Material materialAnterior;
    
    public Material() {
        
    }

    public Material(Integer id, ComponenteCurricular componenteCurricular, String enderecoLink, String estado, Material materialAnterior) {
        this.id = id;
        this.componenteCurricular = componenteCurricular;
        this.enderecoLink = enderecoLink;
        this.estado = estado;
        this.materialAnterior = materialAnterior;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ComponenteCurricular getComponenteCurricular() {
        return componenteCurricular;
    }

    public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    }

    public String getEnderecoLink() {
        return enderecoLink;
    }

    public void setEnderecoLink(String enderecoLink) {
        this.enderecoLink = enderecoLink;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Material getMaterialAnterior() {
        return materialAnterior;
    }

    public void setMaterialAnterior(Material materialAnterior) {
        this.materialAnterior = materialAnterior;
    }
}