package com.zbw.carrental.rest;

import com.zbw.carrental.businesslogic.UserService;
import com.zbw.carrental.entities.User;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.logging.Logger;

@Path("/user")
public class UserResource {


    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private UserService userService = new UserService();

    final static Logger logger = Logger.getLogger(String.valueOf(UserResource.class));

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("param") String userId) {
        logger.info("Entering the getUserById method");
        int parsedParameter = Integer.valueOf(userId);

        User user = userService.findUser(parsedParameter);
        return Response.
                status(200).
                entity(user).
                build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        logger.info("Entering the create method");
        userService.createUser(user);

        return Response.created(UriBuilder.
                fromResource(CustomerResource.class).
                path(String.valueOf(user.getUserId())).
                build()).
                build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Integer id) {
        logger.info("Entering the deleteById method");
        User entity = userService.findUser(id);
        if (entity == null) {
            return Response.
                    status(Response.Status.NOT_FOUND).
                    build();
        }
        userService.removeUser(entity);

        return Response.
                noContent().
                build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listAll() {
        logger.info("Entering the listAll method");

        TypedQuery<User> findAllQuery = userService.getEntityManager().
                createQuery("SELECT DISTINCT u FROM User u ORDER BY u.userId" , User.class);
        final List<User> results = findAllQuery.getResultList();
        return results;
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(User user) {
        logger.info("Entering the update method");
        userService.updateUser(user);

        return Response.
                noContent().
                build();
    }

}
