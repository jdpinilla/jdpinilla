/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.test.persistence;

import co.edu.uniandes.csw.parcial1.entities.VideoJuegoEntity;
import co.edu.uniandes.csw.parcial1.persistence.VideoJuegoPersistence;
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
public class VideoJuegoPersistnceTest {
    @Inject
    private VideoJuegoPersistence videoPersistence;
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    private List<VideoJuegoEntity> data = new ArrayList<>();
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VideoJuegoEntity.class.getPackage())
                .addPackage(VideoJuegoPersistence.class.getPackage())
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

    private void clearData() {
       em.createQuery("delete from VideoJuegoEntity").executeUpdate(); 
    }

    private void insertData() {
       PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            VideoJuegoEntity entity = factory.manufacturePojo(VideoJuegoEntity.class);
            em.persist(entity);
            data.add(entity);
       }
    }
    @Test
    public void createTest() {
        PodamFactory factory = new PodamFactoryImpl();
        VideoJuegoEntity videoJuego = factory.manufacturePojo(VideoJuegoEntity.class);
        VideoJuegoEntity result = videoPersistence.create(videoJuego);
        Assert.assertNotNull(result);
        VideoJuegoEntity entity = em.find(VideoJuegoEntity.class, result.getId());
        Assert.assertTrue(videoJuego.equals(entity));        
    }

}
