package com.zbw.carrental.rest;

import com.zbw.carrental.businesslogic.VehicleService;
import com.zbw.carrental.entities.Vehicle;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.logging.Logger;

@Path("/vehicle")
public class VehilceResource {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private VehicleService vehicleService = new VehicleService();

    final static Logger logger = Logger.getLogger(String.valueOf(VehilceResource.class));

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehicleById(@PathParam("param") String userId) {
        logger.info("Entering the getVehicleById method of VehilceResource class");
        int parsedParameter = Integer.valueOf(userId);

        Vehicle vehicle = vehicleService.findVehicle(parsedParameter);
        return Response.
                status(200).
                entity(vehicle).
                build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Vehicle vehicle) {
        logger.info("Entering the create method of VehilceResource class");
        vehicleService.createVehicle(vehicle);

        return Response.created(UriBuilder.
                fromResource(CustomerResource.class).
                path(String.valueOf(vehicle.getId())).
                build()).
                build();
    }


    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Integer id) {
        logger.info("Entering the deleteById method of VehilceResource class");
        Vehicle vehicle = vehicleService.findVehicle(id);
        if (vehicle == null) {
            return Response.
                    status(Response.Status.NOT_FOUND).
                    build();
        }
        vehicleService.removeVehicle(vehicle);
        return Response.
                noContent().
                build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> listAll() {
        logger.info("Entering the listAll method of VehilceResource class");

        TypedQuery<Vehicle> findAllQuery =
                vehicleService.
                getEntityManager().
                createQuery("SELECT DISTINCT v FROM Vehicle v ORDER BY v.id" , Vehicle.class);

        final List<Vehicle> results = findAllQuery.getResultList();
        return results;
    }

    // Put funktioniert momentan nicht korrekt
    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Vehicle vehicle) {
        logger.info("Entering the update method of VehilceResource class");
        vehicleService.updateVehicle(vehicle);

        return Response.
                noContent().
                build();
    }

}
