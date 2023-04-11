package clases;

import clases.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-05T18:04:38", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, Short> numHabitacion;
    public static volatile SingularAttribute<Habitacion, Boolean> ocupada;
    public static volatile ListAttribute<Habitacion, Paciente> pacienteList;
    public static volatile SingularAttribute<Habitacion, Short> habOcupadas;

}