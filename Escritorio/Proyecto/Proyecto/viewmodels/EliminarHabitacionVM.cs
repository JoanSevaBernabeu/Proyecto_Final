﻿using Proyecto.clases;
using Proyecto.servicios;
using Proyecto.vistas;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto.viewmodels
{
    class EliminarHabitacionVM
    {
        private EliminarHabitacion ventana;
        HabitacionService servicio;
        Collection<Habitacion> habitaciones;

        public void error()
        {
            string mensaje = "Esta habitacion no existe";
            string caption = "Error";

            MessageBoxButtons botones = MessageBoxButtons.OK;
            DialogResult result;
            result = MessageBox.Show(mensaje, caption, botones);
        }
        public void cancelar()
        {
            string mensaje = "¿Seguro que desea cancelar?";
            string caption = "Cancelar";

            MessageBoxButtons botones = MessageBoxButtons.YesNo;
            DialogResult result;

            result = MessageBox.Show(mensaje, caption, botones);
            if (result == DialogResult.Yes)
            {
                ventana.Close();
            }
        }
        public void setVentana(EliminarHabitacion ventana)
        {
            this.ventana = ventana;
        }
        public void obtenerHabitaciones()
        {
            servicio = new HabitacionService();
            habitaciones = servicio.getAllHabitaciones();
        }
        public void deleteHabitacion(string numero)
        {
            string mensaje = "Ejecucion completada!";
            string caption = "Aceptado";

            MessageBoxButtons botones = MessageBoxButtons.OK;
            DialogResult result;
            result = MessageBox.Show(mensaje, caption, botones);
            servicio.deleteHabitacion(numero);
        }
        public void aceptar(string numero)
        {
            obtenerHabitaciones();
            bool existe = false;
            foreach(Habitacion habitacion in habitaciones)
            {
                if (habitacion.getNumHabitacion() == numero) existe = true;
            }
            if (existe) deleteHabitacion(numero);
            else error();
        }
    }
}
