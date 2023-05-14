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
    class EliminarTratamientoVM
    {
        private EliminarTratamiento ventana;
        TratamientoService servicio;
        Collection<Tratamiento> tratamientos;

        public void error()
        {
            string mensaje = "Este tratamiento no existe";
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
        public void setVentana(EliminarTratamiento ventana)
        {
            this.ventana = ventana;
        }
        public void obtenerTratamientos()
        {
            servicio = new TratamientoService();
            tratamientos = servicio.getAllTratamientos();
        }
        public void deleteTratmiento(string nombre)
        {
            string mensaje = "Ejecucion completada!";
            string caption = "Aceptado";

            MessageBoxButtons botones = MessageBoxButtons.OK;
            DialogResult result;
            result = MessageBox.Show(mensaje, caption, botones);

            servicio.deleteTratamiento(nombre);
        }
        public void aceptar(string nombre)
        {
            obtenerTratamientos();
            bool existe = false;
            foreach(Tratamiento tratamiento in tratamientos)
            {
                if (tratamiento.getNombre() == nombre) existe = true;
            }
            if (existe) deleteTratmiento(nombre);
            else error();
        }
    }
}
