using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Proyecto
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public MainWindow()
        {
            InitializeComponent();
        }

        private void CommandBindingCancelar_Executed(object sender, ExecutedRoutedEventArgs e)
        {

        }
        private void CommandBindingSalir_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            System.Windows.Application.Current.Shutdown();
        }
        private void CommandBindingHabitacionNueva_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            HabitacionNueva habitacion_nueva = new HabitacionNueva();
            habitacion_nueva.Owner = this;
            habitacion_nueva.Show();
        }
        private void CommandBindingTratamientoNuevo_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            TratamientoNuevo tratamiento_nuevo = new TratamientoNuevo();
            tratamiento_nuevo.Owner = this;
            tratamiento_nuevo.Show();
        }
        private void CommandBindingMedicamentoNuevo_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            
        }
        private void CommandBindingMedicoNuevo_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            MedicoNuevo medico_nuevo = new MedicoNuevo();
            medico_nuevo.Owner = this;
            medico_nuevo.Show();
        }
    }
}
