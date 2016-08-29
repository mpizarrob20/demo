package cine.model;

import cine.service.PagoService;
import cine.service.PeliculaService;
import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by May on 24/08/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/app-context.xml"})
public class PeliculaTest {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private PagoService pagoService;

    Pelicula pelicula = new Pelicula();
    Pago pago = new Pago();


    @Before
    public void before() {
        System.out.println("before()");
        assertNotNull(peliculaService);

    }

    @After
    public void after() {
        System.out.println("after()");
        pelicula.getNombre();
    }

    @Test
    public void contador() throws Exception {
        Pelicula p = peliculaService.getPelicula(5);
        assertNotNull(p);

    }

    @Test
    public void insertar() {
        pago.setId(25);
        pago.setTipoPago("tarjetas credito");
        pagoService.insertarPago(pago);
        assertNotNull(pago);

    }

    @Test
    public void delete() {
        int id = 12;
        Pago pag = pagoService.getPago(id);
        pagoService.deletePago(pag);
        Pago pag1 = pagoService.getPago(id);
        assertNull(pag1);

    }

    @Test
    public void update() {
        int id = 13;
        String tipoPago = "Tarjeta Banco";
        Pago pagoUpdate = pagoService.getPago(id);
        pagoUpdate.setId(id);
        pagoUpdate.setTipoPago(tipoPago);
        pagoService.updatePago(pagoUpdate);
        Pago pagoActualizado = pagoService.getPago(id);
        System.out.print("El tipo de pago es" + pagoActualizado.getTipoPago());


    }


}