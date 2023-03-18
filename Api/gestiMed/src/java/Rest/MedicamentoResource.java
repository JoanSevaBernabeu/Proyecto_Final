/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DAO.DAOMedicamento;
import clases.Medicamento;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import listas.ListaMedicamento;

/**
 *
 * @author joans
 */
@Path("medicamento")
public class MedicamentoResource {
    @Context
    private UriInfo context;

    public MedicamentoResource() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllMedicamentos() {
        Response response;
  
        ListaMedicamento lista = DAOMedicamento.getMedicamentos();
        
        response = Response.status(Response.Status.OK).entity(lista).build();
        return response;
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOneMedicamento(@PathParam("id") String id) {
        Response response;
        
        Medicamento med = DAOMedicamento.getMedicamento(id);
        
        response = Response.status(Response.Status.OK).entity(med).build();
        return response;
    }
}
