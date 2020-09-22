/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.test.logic;

import co.edu.uniandes.csw.parcial1.ejb.VideoJuegoLogic;
import co.edu.uniandes.csw.parcial1.entities.VideoJuegoEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author User
 */
@RunWith(Arquillian.class)
public class VideoJuegoLogicTest {
     private PodamFactory factory = new PodamFactoryImpl();
     
     @Inject
    private VideoJuegoLogic videoLogic;
     @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
     private List<VideoJuegoEntity> data = new ArrayList<>();
      @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VideoJuegoEntity.class.getPackage())
                .addPackage(VideoJuegoLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from VideoJuegoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            VideoJuegoEntity entity = factory.manufacturePojo(VideoJuegoEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    @Test
    public void createVideoJuego() throws BusinessLogicException 
    {
        VideoJuegoEntity newEntity = factory.manufacturePojo(VideoJuegoEntity.class);
        VideoJuegoEntity result = videoLogic.createVideoJuego(newEntity);
        Assert.assertNotNull(result);

        VideoJuegoEntity entity = em.find(VideoJuegoEntity.class, result.getId());
        Assert.assertEquals(entity.getTitulo(), result.getTitulo());
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createVideoJuegoEmpresaNoValida() throws BusinessLogicException
    {
        VideoJuegoEntity newEntity = factory.manufacturePojo(VideoJuegoEntity.class);
        newEntity.setEmpresa("Jesus");
        VideoJuegoEntity result = videoLogic.createVideoJuego(newEntity);
        Assert.assertNotNull(result);

        VideoJuegoEntity entity = em.find(VideoJuegoEntity.class, result.getId());
        Assert.assertEquals(entity.getEmpresa(), result.getEmpresa());
}
    public void createVideoJuegoNombreEmpresaIgual() throws BusinessLogicException
    {
        VideoJuegoEntity newEntity = factory.manufacturePojo(VideoJuegoEntity.class);
        newEntity.setEmpresa("Xbox");
        newEntity.setTitulo("RE5");
        VideoJuegoEntity result = videoLogic.createVideoJuego(newEntity);
        Assert.assertNotNull(result);
        
        VideoJuegoEntity newEntity2 = factory.manufacturePojo(VideoJuegoEntity.class);
        newEntity.setEmpresa("Xbox");
        newEntity.setTitulo("RE5");
        VideoJuegoEntity result2 = videoLogic.createVideoJuego(newEntity2);
        Assert.assertNotNull(result2);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createVideoJuegoCalificacionInvalida() throws BusinessLogicException
    {
    VideoJuegoEntity newEntity = factory.manufacturePojo(VideoJuegoEntity.class);
     newEntity.setCalificacion(11);
     VideoJuegoEntity result = videoLogic.createVideoJuego(newEntity);
        
    }
}
