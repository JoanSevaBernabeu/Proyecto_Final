package clases;

import clases.Tratamiento;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-21T23:15:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Medicamento.class)
public class Medicamento_ { 

    public static volatile SingularAttribute<Medicamento, Boolean> pedir;
    public static volatile SingularAttribute<Medicamento, Integer> intervalo;
    public static volatile ListAttribute<Medicamento, Tratamiento> tratamientoList;
    public static volatile SingularAttribute<Medicamento, String> id;
    public static volatile SingularAttribute<Medicamento, Integer> cantidad;
    public static volatile SingularAttribute<Medicamento, String> nombre;

}