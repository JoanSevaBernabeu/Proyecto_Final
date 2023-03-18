package com.example.gestimedmedico

class Medicamento (id: String, nombre: String, cantidad: Int, pedir:Boolean, intervalo: Int){
    var id: String
    var nombre: String
    var cantidad: Int
    var pedir: Boolean
    var intervalo: Int
    init {
        this.id = id
        this.nombre = nombre
        this.cantidad = cantidad
        this.pedir = pedir
        this.intervalo = intervalo
    }
}