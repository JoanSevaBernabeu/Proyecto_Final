﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto.clases
{
    class Medicamento
    {
        private string id;
        private string nombre;
        private int cantidad;
        private bool pedir;
        private int intervalo;
        private List<Tratamiento> tratamientos;

        // Constructores

        public Medicamento() { }

        public Medicamento(string id, string nombre, int cantidad, bool pedir, int intervalo)
        {
            this.id = id;
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.pedir = pedir;
            this.intervalo = intervalo;
        }

        // Getters
        public string getId() { return id; }
        public string getNombre() { return nombre; }
        public int getCantidad() { return cantidad; }
        public bool getPedir() { return pedir; }
        public int getIntervalo() { return intervalo; }
        public List<Tratamiento> getTratamiento() { return tratamientos; }

        // Setters
        public void setId(string id) { this.id = id; }
        public void setNombre(string nombre) { this.nombre = nombre; }
        public void setCantidad(int cantidad) { this.cantidad = cantidad; }
        public void setPedir(bool pedir) { this.pedir = pedir; }
        public void setIntervalo(int intervalo) { this.intervalo = intervalo; }
        public void setTratamientos(List<Tratamiento> tratamientos) { this.tratamientos = tratamientos; }
    }
}