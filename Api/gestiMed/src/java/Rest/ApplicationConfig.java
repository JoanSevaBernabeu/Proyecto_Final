/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author joans
 */
@javax.ws.rs.ApplicationPath("gestimed")
public class ApplicationConfig extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
        private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Rest.EnfermeroResource.class);
        resources.add(Rest.MedicamentoResource.class);
        resources.add(Rest.MedicoResource.class);
        resources.add(Rest.PacienteResource.class);
        resources.add(Rest.TratamientoResource.class);
    }
}