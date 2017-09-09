package com.zbw.carrental.rest;

import com.zbw.carrental.businesslogic.CustomerService;
import com.zbw.carrental.entities.Customer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Stateless
@Path("/customer")
public class CustomerResource {

    @EJB
    private CustomerService customerService;

    @GET
    public Response getAllCustomers(){
        Customer customer = customerService.findCustomer(1);
        // GenericEntity<Customer> customerWrapper = new GenericEntity<Customer>(customer){};
        return Response.ok(customer).build();
    }

    @POST
    public Response saveCustomer(final Customer customer){
        Customer persistedCustomer = customerService.createCustomer(customer);
        return Response.ok(persistedCustomer).build();
    }
}
