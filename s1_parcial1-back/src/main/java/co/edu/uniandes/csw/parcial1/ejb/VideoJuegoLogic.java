/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.ejb;

import co.edu.uniandes.csw.parcial1.entities.VideoJuegoEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial1.persistence.VideoJuegoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author User
 */
public class VideoJuegoLogic {
    @Inject
    private VideoJuegoPersistence persistence;
    
    private static final Logger LOGGER = Logger.getLogger(VideoJuegoLogic.class.getName());
    
    //* No puede existir 2 videojuegos con el mismo título y la misma empresa. Pueden existir videojuegos con el mismo nombre, pero de diferentes empresas.
    //* La valor del campo consola tiene que estar dentro de las siguientes opciones: "PlayStation", "Xbox", "Nintendo Switch", "Nintendo 3DS", "PSVita"
    public VideoJuegoEntity createVideoJuego(VideoJuegoEntity videoJuego) throws BusinessLogicException
    {
        if(!videoJuego.getConsola().equals("PlayStation") ||!videoJuego.getConsola().equals("Xbox")||!videoJuego.getConsola().equals("Nintendo Switch")||!videoJuego.getConsola().equals("Nintendo 3DS")||!videoJuego.getConsola().equals("PSVita"))
        {
            throw new BusinessLogicException("El nombre de la empresa no es valido");
        }
        if(videoJuego.getCalificacion() > 10 && videoJuego.getCalificacion() <0)
        {
            throw new BusinessLogicException("La calificacion se sale de los parametros");
        }
        for(int i = 0; i <getVideoJuegos().size() ; i++)
        {
            VideoJuegoEntity videoJuego2 = getVideoJuegos().get(i);
            if(videoJuego.getTitulo().equals(videoJuego2.getTitulo()) && videoJuego.getEmpresa().equals(videoJuego2.getEmpresa()) )
            {
                throw new BusinessLogicException("El nombre del videojuego ya existe en esa empresa");
            }
        }
        
        videoJuego = persistence.create(videoJuego);
        return videoJuego;
    }
    public List<VideoJuegoEntity> getVideoJuegos() 
    {
    LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los VideoJuegos");
    List<VideoJuegoEntity> lista = persistence.findAll();
    LOGGER.log(Level.INFO, "Termina proceso de consultar todas los Videojuegos");
    return lista;
}
}
