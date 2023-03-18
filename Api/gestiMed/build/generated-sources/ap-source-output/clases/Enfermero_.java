package clases;

import clases.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-21T23:15:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Enfermero.class)
public class Enfermero_ { 

    public static volatile SingularAttribute<Enfermero, String> apellidos;
    public static volatile SingularAttribute<Enfermero, String> numContacto;
    public static volatile SingularAttribute<Enfermero, String> contrasenya;
    public static volatile SingularAttribute<Enfermero, String> turno;
    public static volatile SingularAttribute<Enfermero, String> nombre;
    public static volatile ListAttribute<Enfermero, Paciente> pacienteList;
    public static volatile SingularAttribute<Enfermero, String> dni;
    public static volatile SingularAttribute<Enfermero, String> email;

}