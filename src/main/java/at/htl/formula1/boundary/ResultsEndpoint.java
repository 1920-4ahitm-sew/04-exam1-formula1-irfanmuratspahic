package at.htl.formula1.boundary;

import at.htl.formula1.entity.Driver;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("results")
public class ResultsEndpoint {
    @PersistenceContext
    EntityManager em;

    /**
     * @param name als QueryParam einzulesen
     * @return JsonObject
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPointsSumOfDriver(@QueryParam("name") String name) {
        Long points = em
                .createNamedQuery("Result.sumPointsForDriver", Long.class)
                .setParameter("NAME", name)
                .getSingleResult();

        Driver driver = em
                .createNamedQuery("Driver.findByName", Driver.class)
                .setParameter("NAME", name)
                .getSingleResult();

        return Json
                .createObjectBuilder()
                .add("driver", driver.getName())
                .add("points", points)
                .build();
    }

    /**
     * @param id des Rennens
     * @return
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPointsSumOfAllDrivers() {
        List<Object[]> elements = em
                .createNamedQuery("Result.sumPointsForAllDrivers", Object[].class)
                .getResultList();

        return Response.ok(elements).build();
    }


    // Ergänzen Sie Ihre eigenen Methoden ...

}
