package clases;

import clases.Habitacion;
import clases.Medico;
import clases.Tratamiento;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-05T18:04:38", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, String> apellidos;
    public static volatile SingularAttribute<Paciente, Habitacion> numHabitacion;
    public static volatile SingularAttribute<Paciente, String> numContacto;
    public static volatile SingularAttribute<Paciente, String> sip;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, String> urgencia;
    public static volatile SingularAttribute<Paciente, Date> nacimiento;
    public static volatile ListAttribute<Paciente, Medico> medicoList;
    public static volatile SingularAttribute<Paciente, Tratamiento> tratamiento;

}