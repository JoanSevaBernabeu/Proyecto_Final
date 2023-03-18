package clases;

import clases.Medicamento;
import clases.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-21T23:15:09", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Tratamiento.class)
public class Tratamiento_ { 

    public static volatile SingularAttribute<Tratamiento, String> descripcion;
    public static volatile SingularAttribute<Tratamiento, Medicamento> medicamento;
    public static volatile SingularAttribute<Tratamiento, String> nombre;
    public static volatile ListAttribute<Tratamiento, Paciente> pacienteList;
    public static volatile SingularAttribute<Tratamiento, String> solucion;

}