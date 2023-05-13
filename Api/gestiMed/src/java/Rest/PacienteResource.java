/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DAO.DAOPaciente;
import clases.Paciente;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import listas.ListaPaciente;

/**
 *
 * @author joans
 */
@Path("paciente")
public class PacienteResource {
    @Context
    private UriInfo context;

    public PacienteResource() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllPacientes(){
        Response response;
        
        ListaPaciente lista = DAOPaciente.getPacientes();
        response = Response.status(Response.Status.OK).entity(lista).build();
        
        return response;
    }
    
    @GET
    @Path("sip/{sip}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOnePaciente(@PathParam("sip") String sip){
        Response response;
        Paciente paciente = DAOPaciente.getPaciente(sip);
        response = Response.status(Response.Status.OK).entity(paciente).build();
        return response;
    }
    
    @POST
    @Path("nuevo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPaciente(Paciente paciente){
        Response response;
        
        DAOPaciente.pacientePost(paciente);
        response = Response.status(Response.Status.CREATED).build();
        
        return response;
    }
    
    @DELETE
    @Path("delete/{sip}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deletePaciente(@PathParam("sip") String sip){
        Response response;
        
        DAOPaciente.pacienteDelete(sip);
        response = Response.status(Response.Status.OK).build();
        return response;
    }
}
