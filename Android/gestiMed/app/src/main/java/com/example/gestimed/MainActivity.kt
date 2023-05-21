package com.example.gestimed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val model: PacienteModel by viewModels()
    private var listaPacientes = ArrayList<Paciente>()
    private var listaMedicos = ArrayList<Medico>()
    private var adaptadorApi: AdaptadorApi = AdaptadorApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        model.setContxto(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        model.setListaMedicos(addMedicos())
        model.setListaPacientes(addPacientes())

    }
    private fun addMedicos(): ArrayList<Medico>{
        var medicos = ArrayList<Medico>()
        medicos.add(Medico("2","2","2","2","2","2"))
        medicos.add(Medico("2","2","2","2","2","2"))
        medicos.add(Medico("2","2","2","2","2","2"))
        return medicos
    }

    private fun addMedicamentos():Medicamento{
        var medicamento = Medicamento("4875917","Mentiritis",100,5)
        return medicamento
    }
    private fun addTratamiento(medicamento:Medicamento):Tratamiento{
        var tratamiento = Tratamiento("cagarPadentro","Haser kk al reves","Haser la kk normal",medicamento)
        return tratamiento
    }
    private fun addHabitacion():Habitacion{
        var habitacion = Habitacion("3",5,3)
        return habitacion
    }
    private fun addPacientes():ArrayList<Paciente>{
        var medicamento = addMedicamentos()
        var tratamiento = addTratamiento(medicamento)
        var habitacion = addHabitacion()
        var pacientes = ArrayList<Paciente>()
        pacientes.add(Paciente("1234","Joan1","Seva1","123445", Date(2020,4,4),listaMedicos,"Urgente",tratamiento,habitacion))
        pacientes.add(Paciente("1234","Joan1","Seva1","123445", Date(2020,4,4),listaMedicos,"Medio",tratamiento,habitacion))
        pacientes.add(Paciente("1234","Joan1","Seva1","123445", Date(2020,4,4),listaMedicos,"Urgente",tratamiento,habitacion))
        return pacientes
    }
}