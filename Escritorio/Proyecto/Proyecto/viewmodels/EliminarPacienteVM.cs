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
    class EliminarPacienteVM
    {
        private EliminarPaciente ventana;
        PacienteService servicio;
        Collection<Paciente> pacientes;

        public void error()
        {
            string mensaje = "Este paciente no existe";
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
        public void setVentana(EliminarPaciente ventana)
        {
            this.ventana = ventana;
        }
        public void obtenerPacientes()
        {
            servicio = new PacienteService();
            pacientes = servicio.getAllPacientes();
        }
        private void deletePaciente(string sip)
        {
            string mensaje = "Ejecucion completada!";
            string caption = "Aceptado";

            MessageBoxButtons botones = MessageBoxButtons.OK;
            DialogResult result;
            result = MessageBox.Show(mensaje, caption, botones);

            servicio.deletePaciente(sip);
        }
        public void aceptar(string sip)
        {
            obtenerPacientes();
            bool existe = false;
            foreach(Paciente paciente in pacientes)
            {
                if (paciente.getSip() == sip) existe = true;
            }
            if (existe) deletePaciente(sip);
            else error();
        }
    }
}
