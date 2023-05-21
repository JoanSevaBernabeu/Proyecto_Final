package com.example.gestimed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class LoginFragment(): Fragment() {
    val model:PacienteModel by activityViewModels()
    private var listaPacientes = ArrayList<Paciente>()
    private var listaMedicos = ArrayList<Medico>()
    private var adaptadorApi: AdaptadorApi = AdaptadorApi()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //getPacientes()
        //getMedicos()
        // listaMedicos = addMedicos()
        // listaPacientes = addPacientes()
        //model.setListaPacientes(listaPacientes)
        // model.setListaMedicos(listaMedicos)
        val lista = model.getListaMedicos()
        val navController = NavHostFragment.findNavController(this)
        val view = inflater.inflate(R.layout.login_fragment,container,false)
        val aceptarBoton = view.findViewById<Button>(R.id.aceptarButton)
        val cancelarBoton = view.findViewById<Button>(R.id.cancelarButton)
        val usuario = view.findViewById<TextInputEditText>(R.id.usuarioInput)
        val passw = view.findViewById<TextInputEditText>(R.id.passwInput)
        aceptarBoton.setOnClickListener {
            var continuar: Boolean = false
            for(item in lista!!){
                if(usuario.text.toString().equals(item.nombre) && passw.text.toString().equals(item.contrasenya)){
                    continuar = true
                }
            }
            if(continuar){
                navController.navigate(R.id.action_loginFragment_to_recyclerFragment)
            }else{
                Toast.makeText(model.getContxto(),"Error en el usuario o contraseña", Toast.LENGTH_LONG).show()
            }
        }
        cancelarBoton.setOnClickListener {
            usuario.setText("")
            passw.setText("")
        }
        return view
    }
    /*
    private fun getPacientes(){
        CoroutineScope(Dispatchers.Main).launch {
            listaPacientes = adaptadorApi.cargarPacientes().await()
        }
    }
    private fun getMedicos(){
        CoroutineScope(Dispatchers.Main).launch {
            listaMedicos = adaptadorApi.cargarMedicos().await()
        }
        */
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
