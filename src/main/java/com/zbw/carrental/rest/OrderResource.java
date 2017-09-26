package com.zbw.carrental.rest;

import com.zbw.carrental.businesslogic.OrderService;
import com.zbw.carrental.entities.Order;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.logging.Logger;

@Path("/order")
public class OrderResource {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private OrderService orderService = new OrderService();

    final static Logger logger = Logger.getLogger(String.valueOf(OrderResource.class));

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("param") String orderId) {
        logger.info("Entering the getOrderById method of OrderResource class");

        int parsedParameter = Integer.valueOf(orderId);

        Order order = orderService.findOrder(parsedParameter);
        return Response.
                status(200).
                entity(order).
                build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Order order) {
        logger.info("Entering the create method of OrderResource class");
        orderService.createOrde(order);

        return Response.created(UriBuilder.
                fromResource(CustomerResource.class).
                path(String.valueOf(order.getOrderID())).
                build()).
                build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Integer id) {
        logger.info("Entering the deletedById method of OrderResource class");
        Order entity = orderService.findOrder(id);
        if (entity == null) {
            return Response.
                    status(Response.Status.NOT_FOUND).
                    build();
        }
        orderService.removeOrder(entity);

        return Response.
                noContent().
                build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> listAll() {
        logger.info("Entering the listAll method of OrderResource class");

        TypedQuery<Order> findAllQuery = orderService.getEntityManager().
                createQuery("SELECT o FROM carorder o ORDER BY o.id" , Order.class);
        final List<Order> results = findAllQuery.getResultList();
        return results;
    }

    // Put funktioniert momentan nicht korrekt
    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Order order) {
        logger.info("Entering the update method of OrderResource class");

        Order searchOrder = orderService.findOrder(order.getOrderID());
        System.out.println(order.getOrderID());

        orderService.updateOrder(order);

        return Response.
                noContent().
                build();
    }
}
