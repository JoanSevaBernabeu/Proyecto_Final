package clases;

import clases.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-21T23:15:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> apellidos;
    public static volatile SingularAttribute<Medico, String> numContacto;
    public static volatile SingularAttribute<Medico, String> contrasenya;
    public static volatile SingularAttribute<Medico, String> turno;
    public static volatile SingularAttribute<Medico, String> nombre;
    public static volatile ListAttribute<Medico, Paciente> pacienteList;
    public static volatile SingularAttribute<Medico, String> dni;
    public static volatile SingularAttribute<Medico, String> email;

}