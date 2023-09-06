/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.Date;
/**
 *
 * @author dahir
 */
public class TabelaAvisosOrientadoPossuiOrientador {
    private Date quando;
    private String quem;
    
    public TabelaAvisosOrientadoPossuiOrientador(){
    }
    
    public TabelaAvisosOrientadoPossuiOrientador(Date quando, String quem){
        this.quando = quando;
        this.quem = quem;
    }
    
    public Date getQuando(){
        return quando;
    }
    
    public void setQuando(Date quando){
        this.quando = quando;
    }
    
    public String quem(){
        return quem;
    }
    
    public void setQuem(String quem){
        this.quem = quem;
    }
}

