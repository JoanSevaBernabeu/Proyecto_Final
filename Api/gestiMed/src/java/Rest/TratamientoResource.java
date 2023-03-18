/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DAO.DAOTratamiento;
import clases.Tratamiento;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import listas.ListaTratamiento;

/**
 *
 * @author joans
 */
@Path("tratamiento")
public class TratamientoResource {
    
    @Context
    private UriInfo context;

    public TratamientoResource() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllTratamientos(){
        Response response;
        
        ListaTratamiento lista = DAOTratamiento.getTratamientos();
        response = Response.status(Response.Status.OK).entity(lista).build();
        
        return response;
    }
    
    @GET
    @Path("{nombre}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getTratamiento(@PathParam("nombre") String nombre){
        Response response;
        
        Tratamiento tratamiento = DAOTratamiento.getTratamiento(nombre);
        response = Response.status(Response.Status.OK).entity(tratamiento).build();
        
        return response;
    }
}
