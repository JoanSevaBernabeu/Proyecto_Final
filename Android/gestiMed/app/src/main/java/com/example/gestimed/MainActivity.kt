package com.example.gestimed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    val model: PacienteModel by viewModels()
    private var listaPacientes = ArrayList<Paciente>()
    private var listaMedicos = ArrayList<Medico>()
    private var adaptadorApi: AdaptadorApi = AdaptadorApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        model.setContxto(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model.setListaMedicos(addMedicos())

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
}