package at.htl.formula1.boundary;

import at.htl.formula1.entity.Driver;
import at.htl.formula1.entity.Race;
import at.htl.formula1.entity.Result;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ResultsRestClient {
    @PersistenceContext
    EntityManager em;

    public static final String RESULTS_ENDPOINT = "http://vm90.htl-leonding.ac.at/results";
    private Client client = ClientBuilder.newClient();
    private WebTarget target = client.target(RESULTS_ENDPOINT);
    //Response response = (Response) target.request(MediaType.APPLICATION_JSON);
    //JsonArray payload = response.readEntity(JsonArray.class);

    /**
     * Vom RestEndpoint werden alle Result abgeholt und in ein JsonArray gespeichert.
     * Dieses JsonArray wird an die Methode persistResult(...) übergeben
     */
   @Transactional
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
    public void readResultsFromEndpoint() {

        JsonArray payload = null;

        persistResult(payload);
    }

    /**
     * Das JsonArray wird durchlaufen (iteriert). Man erhäjt dabei Objekte vom
     * Typ JsonValue. diese werden mit der Methode .asJsonObject() in ein
     * JsonObject umgewandelt.
     *
     * zB:
     * for (JsonValue jsonValue : resultsJson) {
     *             JsonObject resultJson = jsonValue.asJsonObject();
     *             ...
     *
     *  Mit den entsprechenden get-Methoden können nun die einzelnen Werte
     *  (raceNo, position und driverFullName) ausgelesen werden.
     *
     *  Mit dem driverFullName wird der entsprechende Driver aus der Datenbank ausgelesen.
     *
     *  Dieser Driver wird dann dem neu erstellten Result-Objekt übergeben
     *
     * @param resultsJson
     */
    @Transactional
    void persistResult(JsonArray resultsJson) {

    }

}
