using Proyecto.vistas;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto.viewmodels
{
    class MainWindowVM
    {
        private MainWindow ventana;
        public void cancelar()
        {
            string mensaje = "¿Seguro que desea cancelar?";
            string caption = "Cancelar";

            MessageBoxButtons botones = MessageBoxButtons.YesNo;
            DialogResult result;

            result = MessageBox.Show(mensaje, caption, botones);
            if(result == DialogResult.Yes)
            {
                ventana.Close();
            }
        }
        public void aceptar()
        {
            string mensaje = "Ejecucion completada!";
            string caption = "Aceptado";

            MessageBoxButtons botones = MessageBoxButtons.OK;
            DialogResult result;
            result = MessageBox.Show(mensaje, caption, botones);
        }
        public void error()
        {
            string mensaje = "Ha ocurrido un error, revise los campos";
            string caption = "Error";

            MessageBoxButtons botones = MessageBoxButtons.OK;
            DialogResult result;
            result = MessageBox.Show(mensaje, caption, botones);
        }
        public void habitacionNueva()
        {
            HabitacionNueva habitacion_nueva = new HabitacionNueva();
            habitacion_nueva.Owner = ventana;
            habitacion_nueva.Show();
        }
        public void eliminarHabitacion()
        {
            EliminarHabitacion eliminar_habitacion = new EliminarHabitacion();
            eliminar_habitacion.Owner = ventana;
            eliminar_habitacion.Show();
        }
        public void tratamientoNuevo()
        {
            TratamientoNuevo tratamiento_nuevo = new TratamientoNuevo();
            tratamiento_nuevo.Owner = ventana;
            tratamiento_nuevo.Show();
        }
        public void eliminarTratamiento()
        {
            EliminarTratamiento eliminar_tratamiento = new EliminarTratamiento();
            eliminar_tratamiento.Owner = ventana;
            eliminar_tratamiento.Show();
        }
        public void medicamentoNuevo()
        {
            MedicamentoNuevo medicamento_nuevo = new MedicamentoNuevo();
            medicamento_nuevo.Owner = ventana;
            medicamento_nuevo.Show();
        }
        public void medicoNuevo()
        {
            MedicoNuevo medico_nuevo = new MedicoNuevo();
            medico_nuevo.Owner = ventana;
            medico_nuevo.Show();
        }
        public void setVentana(MainWindow ventana)
        {
            this.ventana = ventana;
        }
    }
}
