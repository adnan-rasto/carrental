package com.zbw.carrental.rest;

import com.zbw.carrental.businesslogic.CustomerService;
import com.zbw.carrental.entities.Customer;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {

    @EJB
    private CustomerService customerService = new CustomerService();

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(){
        Customer customer = customerService.findCustomer(2);
        return Response.status(200).entity(customer).build();
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByName(@PathParam("param") String name){
        return Response.status(200).entity(null).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCustomer(final Customer customer){
        Customer persistedCustomer = customerService.createCustomer(customer);
        return Response.ok(persistedCustomer).build();
    }
}
