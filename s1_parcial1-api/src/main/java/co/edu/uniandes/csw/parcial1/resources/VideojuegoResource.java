package co.edu.uniandes.csw.parcial1.resources;

import co.edu.uniandes.csw.parcial1.dtos.VideojuegoDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("/videojuegos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class VideojuegoResource {
    
    private static final Logger LOGGER = Logger.getLogger(VideojuegoResource.class.getName());
    @POST
    public VideojuegoDTO createVideojuego(VideojuegoDTO videojuego) {
        return videojuego;
    }
}