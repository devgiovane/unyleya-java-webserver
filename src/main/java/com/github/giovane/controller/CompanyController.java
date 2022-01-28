package com.github.giovane.controller;

import com.github.giovane.entity.CompanyEntity;
import com.github.giovane.service.CompanyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8", MediaType.APPLICATION_FORM_URLENCODED + ";charset=utf-8"})
public class CompanyController {

    private final CompanyService service = new CompanyService();

    @POST
    public Response createCompany(CompanyEntity companyEntity) {
        System.out.println("POST");
        boolean success = service.save(companyEntity);
        if(!success) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

    @GET
    public Response readCompanies() {
        System.out.println("GET");
        List<CompanyEntity> companyEntityList = service.find();
        if (companyEntityList.isEmpty()) {
            return Response.status(404).build();
        }
        return Response.ok(companyEntityList).build();
    }

    @GET
    @Path("{id}")
    public Response readCompany(@PathParam("id") int id) {
        System.out.println("GET");
        CompanyEntity companyEntity = service.findOne(id);
        if(companyEntity == null) {
            return Response.status(404).build();
        }
        return Response.ok(companyEntity).build();
    }

    @PUT
    @Path("{id}")
    public Response updateCompany(@PathParam("id") int id, CompanyEntity companyEntity) {
        System.out.println("POST");
        CompanyEntity companyExists = service.findOne(id);
        if(companyExists == null) {
            return Response.status(404).build();
        }
        boolean success = service.update(id, companyEntity);
        if(!success) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCompany(@PathParam("id") int id) {
        System.out.println("DELETE");
        CompanyEntity companyEntity = service.findOne(id);
        if(companyEntity == null) {
            return Response.status(404).build();
        }
        boolean success = service.delete(companyEntity.getId());
        if(!success) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

}
