package com.example.gestimedmedico

class Habitacion (numHabitacion: Short, numCamasDisp: Short, numCamasOcu: Short){
    var numHabitacion: Short
    var numCamasDisp: Short
    var numCamasOcu: Short
    lateinit var pacientes: List<Paciente>

    init {
        this.numHabitacion = numHabitacion
        this.numCamasDisp = numCamasDisp
        this.numCamasOcu = numCamasOcu
    }
}