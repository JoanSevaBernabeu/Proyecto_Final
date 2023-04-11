/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DAO.DAOMedico;
import clases.Medico;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import listas.ListaMedico;

/**
 * REST Web Service
 *
 * @author joans
 */
@Path("medico")
public class MedicoResource {

    @Context
    private UriInfo context;

    public MedicoResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllMedicos() {
        Response response;

        ListaMedico med = DAOMedico.getMedicos();
        
        response = Response.status(Response.Status.OK).entity(med).build();
        return response;
    }
    
    @GET
    @Path("dni/{dni}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getMedico(@PathParam("dni") String dni){
        Response response;
        
        Medico med = DAOMedico.getMedico(dni);
        
        response = Response.status(Response.Status.OK).entity(med).build();
        return response;
    }
    
}
