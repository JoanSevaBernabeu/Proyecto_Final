package com.example.gestimedmedico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
        setContentView(R.layout.activity_main)
        /*
        var enfermeros : ArrayList<Enfermero> = addEnfermeros()
        var medicos : List<Medico> = addMedicos()
        var medicamento : Medicamento = addMedicamentos()
        var tratamiento : Tratamiento = addTratamiento(medicamento)
        var pacientes : List<Paciente> = addPacientes(enfermeros,medicos,tratamiento)


        getPacientes()
        getMedicos()
        model.setListaPacientes(listaPacientes)
        model.setListaMedicos(listaMedicos)

         */
    }

    private fun getPacientes(){
        CoroutineScope(Dispatchers.Main).launch {
            listaPacientes = adaptadorApi.cargarPacientes().await()
        }
    }
    private fun getMedicos(){
        CoroutineScope(Dispatchers.Main).launch {
            listaMedicos = adaptadorApi.cargarMedicos().await()
        }
    }

    private fun addEnfermeros():ArrayList<Enfermero>{
        var enfermeros = ArrayList<Enfermero>()
        enfermeros.add(Enfermero("1","1","1","1","1","1","1","1"))
        enfermeros.add(Enfermero("2","2","2","2","2","2","2","2"))
        enfermeros.add(Enfermero("3","3","3","3","3","3","3","3"))
        return enfermeros
    }

    private fun addMedicos(): ArrayList<Medico>{
        var medicos = ArrayList<Medico>()
        medicos.add(Medico("2","2","2","2","2","2","2","2"))
        medicos.add(Medico("2","2","2","2","2","2","2","2"))
        medicos.add(Medico("2","2","2","2","2","2","2","2"))
        return medicos
    }
    private fun addPacientes(enfermeros: List<Enfermero>,medicos: List<Medico>, tratamiento: Tratamiento): ArrayList<Paciente>{
        var pacientes = ArrayList<Paciente>()
        pacientes.add(Paciente("586729795","Joan1","Seva Bernabeu", "620220902", Date(1997,4,30),medicos,enfermeros,"Urgente",tratamiento))
        pacientes.add(Paciente("571283758","Joan2","Seva Bernabeu", "620220902", Date(1997,4,30),medicos,enfermeros,"Medio",tratamiento))
        pacientes.add(Paciente("059792387","Joan3","Seva Bernabeu", "620220902", Date(1997,4,30),medicos,enfermeros,"No-Urgente",tratamiento))
        return pacientes
    }

    private fun addMedicamentos():Medicamento{
        var medicamento = Medicamento("4875917","Mentiritis",100,false,5)
        return medicamento
    }
    private fun addTratamiento(medicamento:Medicamento):Tratamiento{
        var tratamiento = Tratamiento("cagarPadentro","Haser kk al reves","Haser la kk normal",medicamento)
        return tratamiento
    }
/*


 */
}