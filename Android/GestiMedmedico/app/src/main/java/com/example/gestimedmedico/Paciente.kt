package com.example.gestimedmedico

import java.util.*
import kotlin.collections.ArrayList

class Paciente(sip: String, nombre: String, apellidos: String, numContacto: String, nacimiento: Date, medicos: List<Medico>, enfermeros: List<Enfermero>, urgencia: String, tratamiento: Tratamiento) {
    var sip: String
    var nombre: String
    var apellidos: String
    var numContacto: String
    var nacimiento: Date
    var medicos: List<Medico>
    var enfermeros: List<Enfermero>
    var tratamiento: Tratamiento
    var urgencia : String

    init {
        this.sip = sip
        this.nombre = nombre
        this.apellidos = apellidos
        this.numContacto = numContacto
        this.nacimiento = nacimiento
        this.medicos = medicos
        this.enfermeros = enfermeros
        this.tratamiento = tratamiento
        this.urgencia = urgencia
    }
}