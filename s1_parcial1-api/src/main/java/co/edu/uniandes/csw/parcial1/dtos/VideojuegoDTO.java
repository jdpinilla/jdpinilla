package co.edu.uniandes.csw.parcial1.dtos;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class VideojuegoDTO implements Serializable {
    
    private Long id;
    private String titulo;
    private String empresa;
    private int edadMinimaRecomendada;
    private int edadMaximaRecomendada;
    private String consola;
    private int calificacion;

    public VideojuegoDTO()
    {     
    }
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
     * @return the id
     */
    public Long getId() {
        return id;
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
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}