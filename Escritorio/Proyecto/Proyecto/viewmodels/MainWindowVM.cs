using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto.viewmodels
{
    class MainWindowVM
    {
        private MainWindow ventana;
        public void cancelar()
        {

        }
        public void habitacionNueva()
        {
            HabitacionNueva habitacion_nueva = new HabitacionNueva();
            habitacion_nueva.Owner = ventana;
            habitacion_nueva.Show();
        }
        public void tratamientoNuevo()
        {
            TratamientoNuevo tratamiento_nuevo = new TratamientoNuevo();
            tratamiento_nuevo.Owner = ventana;
            tratamiento_nuevo.Show();
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
