/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.persistence;

import co.edu.uniandes.csw.parcial1.entities.VideoJuegoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class VideoJuegoPersistence {
     private static final Logger LOGGER = Logger.getLogger(VideoJuegoPersistence.class.getName());
     
    @PersistenceContext(unitName = "parcial1PU")
    protected EntityManager em;
    /**
     * Crea un videojuego
     * @param videoJuego
     */
    public VideoJuegoEntity create(VideoJuegoEntity videoJuego)
    {
        LOGGER.log(Level.INFO, "Creando un nuevo videojuego");
        em.persist(videoJuego);
        LOGGER.log(Level.INFO, "Videojuego creado");
        return videoJuego;
    }     
    public List<VideoJuegoEntity> findAll() {
       LOGGER.log(Level.INFO, "Consultando todos los VideoJuegos");
        TypedQuery query = em.createQuery("select u from VideoJuegoEntity u", VideoJuegoEntity.class);
        return query.getResultList();
    }
    
}

