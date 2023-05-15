﻿using Proyecto.clases;
using Proyecto.servicios;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto.viewmodels
{
    class TratamientoNuevoVM
    {
        private TratamientoNuevo ventana;
        TratamientoService servicio;
        Collection<Tratamiento> tratamientos;

        public void setVentana(TratamientoNuevo ventana)
        {
            this.ventana = ventana;
        }
        public void error()
        {
            string mensaje = "Este tratamiento ya existe";
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
        public Collection<Medicamento> getMedicamentos()
        {
            MedicamentoService medicamentoService = new MedicamentoService();
            Collection<Medicamento> medicamentos = medicamentoService.getAllMedicamentos();
            return medicamentos;
        }
        public Medicamento getMedicamento(string nombre)
        {
            MedicamentoService medicamentoService = new MedicamentoService();
            Collection<Medicamento> medicamento = medicamentoService.getMedicamento(nombre);
            if (medicamento.Count() != 1) return null;
            else return medicamento[0];
        }
        public void aceptar(Tratamiento tratamiento)
        {
            obtenerTratamientos();
            bool existe = false;
            foreach(Tratamiento trat in tratamientos)
            {
                if (trat.getNombre() == tratamiento.getNombre()) existe = true;
            }
            if (existe) error();
            else postTratamiento(tratamiento);
        }
        public void postTratamiento(Tratamiento tratamiento)
        {
            string mensaje = "Ejecucion completada!";
            string caption = "Aceptado";

            MessageBoxButtons botones = MessageBoxButtons.OK;
            DialogResult result;
            result = MessageBox.Show(mensaje, caption, botones);

            servicio.postTratamiento(tratamiento);
        }
        public void obtenerTratamientos()
        {
            servicio = new TratamientoService();
            tratamientos = servicio.getAllTratamientos();
        }
    }
}
