package com.example.gestimedmedico

class Enfermero(dni: String, nombre: String, apellidos: String, email:String, contrasenya: String, numContacto: String, turno: String, estado: String) {
    var dni: String
    var nombre: String
    var apellidos: String
    var email: String
    var contrasenya: String
    var numContacto: String
    var turno: String
    var estado: String
    // var pacientes: List<Paciente>

    init {
        this.dni = dni
        this.nombre = nombre
        this.apellidos = apellidos
        this.email = email
        this.contrasenya = contrasenya
        this.numContacto = numContacto
        this.turno = turno
        this.estado = estado
        //this.pacientes = pacientes
    }
}