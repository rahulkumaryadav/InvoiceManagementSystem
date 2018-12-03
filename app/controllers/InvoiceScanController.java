package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.InvoiceScan;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class InvoiceScanController extends Controller {

    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "defaultPersistenceUnit" );
    EntityManager entitymanager = emfactory.createEntityManager( );


    @play.db.jpa.Transactional
    public Result index(){
        return ok(views.html.invoiceScan.render(null));
    }


    @play.db.jpa.Transactional
    public Result create() throws IOException {
        Logger.info("CodeGeneratorController--create()");
        JsonNode jsonNode = Controller.request().body().asJson();
        ObjectMapper mapper = new ObjectMapper();
        InvoiceScan InvoiceScan = mapper.readValue(jsonNode.toString(), InvoiceScan.class);
        Date date=new Date();
        InvoiceScan.setDtCreated(date);
        InvoiceScan.setActiveFlag(true);
        entitymanager.getTransaction().begin();
        if (!entitymanager.contains(InvoiceScan)) {
            entitymanager.persist(InvoiceScan);
            entitymanager.flush();
        }
        entitymanager.getTransaction().commit();
        return ok("");
    }

    @play.db.jpa.Transactional
    public  Result getAll() throws IOException {

        Logger.info("InvoiceScanController.getAll()");
        List<InvoiceScan> InvoiceScanList= entitymanager.createQuery("select a from InvoiceScan a where activeFlag=true order by dtCreated desc ", InvoiceScan.class).getResultList();
        ObjectMapper objectMapper=new ObjectMapper();
        String a=objectMapper.writeValueAsString(InvoiceScanList);
        JsonNode jsonNode=objectMapper.readTree(a);
        if (jsonNode.has(0))
            return ok(jsonNode);
        else{
            Logger.info("record not found");
            return ok("");
        }
    }

    @play.db.jpa.Transactional
    public  Result delete(String id) throws IOException {
        Logger.info("id*****************************"+Long.parseLong(id));
        Date date=new Date();
        InvoiceScan invoiceScan= entitymanager.createQuery("select a from InvoiceScan a where a.id=:id",InvoiceScan.class).setParameter("id",Long.parseLong(id)).getSingleResult();
        Logger.info("InvoiceScan"+invoiceScan);
        invoiceScan.setDtModified(date);
        invoiceScan.setActiveFlag(false);
        Logger.info("InvoiceScan"+invoiceScan);
        entitymanager.getTransaction().begin();
        if (!entitymanager.contains(invoiceScan)) {
            entitymanager.persist(invoiceScan);
            entitymanager.flush();
        }
        entitymanager.getTransaction().commit();
        return ok();
    }
}
