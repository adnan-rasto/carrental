package com.zbw.carrental.rest;

import com.zbw.carrental.businesslogic.CustomerService;
import com.zbw.carrental.entities.Customer;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.logging.Logger;

@Path("/customer")
public class CustomerResource {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private CustomerService customerService = new CustomerService();

    final static Logger logger = Logger.getLogger(String.valueOf(CustomerResource.class));

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") Integer customerId) {
        logger.info("Entering the getCustomerById method");

        Customer customer = customerService.
                findCustomer(customerId);

        return Response.status(200).
                entity(customer).
                build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomerByName(@PathParam("name") String customerName) {
        logger.info("Entering the getCustomerByName method");
        TypedQuery<Customer> findByNameQuery =
                customerService.
                        getEntityManager().
                        createQuery("SELECT c FROM Customer c where c.lastname = :entityLastname ORDER BY c.lastname", Customer.class);
        findByNameQuery.setParameter("entityLastname", customerName);


        final List<Customer> results = findByNameQuery.getResultList();
        return results;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Customer entity) {
        logger.info("Entering the create method");
        customerService.createCustomer(entity);

        return Response.
                created(UriBuilder.
                fromResource(CustomerResource.class).
                path(String.valueOf(entity.getId())).
                build()).
                build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Integer id) {
        logger.info("Entering the deleteById method");
        Customer entity = customerService.findCustomer(id);
        if (entity == null) {
            return Response.
                    status(Response.Status.NOT_FOUND).
                    build();
        }
        customerService.removeCustomer(entity);
        return Response.
                noContent().
                build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> listAll() {
        logger.info("Entering the listAll method");
        TypedQuery<Customer> findAllQuery = customerService.getEntityManager().
                createQuery("SELECT DISTINCT c FROM Customer c ORDER BY c.id", Customer.class);

        final List<Customer> results = findAllQuery.getResultList();
        return results;
    }

    // Put funktioniert momentan nicht korrekt
    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Customer entity) {
        logger.info("Entering the update method");
        customerService.updateCustomer(entity);

        return Response.
                ok(entity).
                build();
    }
}
