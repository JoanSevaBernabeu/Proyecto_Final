/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DAO.DAOHabitacion;
import clases.Habitacion;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import listas.ListaHabitaciones;

/**
 *
 * @author joans
 */
@Path("habitacion")
public class HabitacionResource {
    @Context
    private UriInfo context;
    
    public HabitacionResource(){
    }
    
    @GET
    @Path("num/{numero}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHabitacion(@PathParam("numero") Short numero){
        Response response;
        Habitacion habitacion = DAOHabitacion.getHabitacion(numero);
        response = Response.status(Response.Status.OK).entity(habitacion).build();
        return response;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHabitaciones(){
        Response response;
        ListaHabitaciones lista = DAOHabitacion.obtenerHabitaciones();
        response = Response.status(Response.Status.OK).entity(lista).build();
        return response;
    }
    @POST
    @Path("nueva")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postHabitacion(Habitacion habitacion){
        Response response = null;
        
        boolean exito = DAOHabitacion.postHabitacion(habitacion);
        if(exito == true) response = Response.status(Response.Status.CREATED).build();
        //else response = Response.status(Response.Status.)
        return response;
    }
    
}
