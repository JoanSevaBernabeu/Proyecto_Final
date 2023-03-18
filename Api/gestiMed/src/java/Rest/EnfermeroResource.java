/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DAO.DAOEnfermero;
import clases.Enfermero;
import listas.ListaEnfermero;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author joans
 */
@Path("enfermero")
public class EnfermeroResource {
    @Context
    private UriInfo context;


    public EnfermeroResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllMedicos() {
        Response response;

        ListaEnfermero enf = DAOEnfermero.getEnfermeros();
        
        response = Response.status(Response.Status.OK).entity(enf).build();
        return response;
    }
    
    @GET
    @Path("dni/{dni}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getMedico(@PathParam("dni") String dni){
        Response response;
        
        Enfermero enf = DAOEnfermero.getEnfermero(dni);
        
        response = Response.status(Response.Status.OK).entity(enf).build();
        return response;
    }
    
    @GET
    @Path("turno/{turno}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getTurnosMedicos(@PathParam("turno") String turno){
        Response response;
        
        ListaEnfermero lista = DAOEnfermero.getEnfermeros(turno);
        response = Response.status(Response.Status.OK).entity(lista).build();
        
        return response;
    }
}
