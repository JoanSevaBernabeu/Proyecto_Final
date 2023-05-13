package clases;

import clases.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-12T18:29:04", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> numHabitacion;
    public static volatile SingularAttribute<Habitacion, Short> camDisponibles;
    public static volatile ListAttribute<Habitacion, Paciente> pacienteList;
    public static volatile SingularAttribute<Habitacion, Short> camOcupadas;

}