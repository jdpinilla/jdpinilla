/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class VideoJuegoEntity implements Serializable{
    //título, una empresa, un rango de edad recomendado, una consola donde se puede jugar, una calificación en número de estrellas y un id
    @Id
    private Long Id;
    
    private String titulo;
    private String empresa;
    private int edadMinimaRecomendada;
    private int edadMaximaRecomendada;
    private String consola;
    private int calificacion;

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @return the consola
     */
    public String getConsola() {
        return consola;
    }

    /**
     * @return the edadMaximaRecomendada
     */
    public int getEdadMaximaRecomendada() {
        return edadMaximaRecomendada;
    }

    /**
     * @return the edadMinimaRecomendada
     */
    public int getEdadMinimaRecomendada() {
        return edadMinimaRecomendada;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @param consola the consola to set
     */
    public void setConsola(String consola) {
        this.consola = consola;
    }

    /**
     * @param edadMaximaRecomendada the edadMaximaRecomendada to set
     */
    public void setEdadMaximaRecomendada(int edadMaximaRecomendada) {
        this.edadMaximaRecomendada = edadMaximaRecomendada;
    }

    /**
     * @param edadMinimaRecomendada the edadMinimaRecomendada to set
     */
    public void setEdadMinimaRecomendada(int edadMinimaRecomendada) {
        this.edadMinimaRecomendada = edadMinimaRecomendada;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    

}
