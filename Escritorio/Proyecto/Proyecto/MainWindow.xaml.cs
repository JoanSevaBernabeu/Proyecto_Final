using Proyecto.viewmodels;
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
        private MainWindowVM vm;
        public MainWindow()
        {
            vm = new MainWindowVM();
            this.DataContext = vm;
            vm.setVentana(this);
            InitializeComponent();
        }

        private void CommandBindingCancelar_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            vm.cancelar();
        }
        private void CommandBindingSalir_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            System.Windows.Application.Current.Shutdown();
        }
        private void CommandBindingHabitacionNueva_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            vm.habitacionNueva();
        }
        private void CommandBindingTratamientoNuevo_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            vm.tratamientoNuevo();
        }
        private void CommandBindingMedicamentoNuevo_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            vm.medicamentoNuevo();
        }
        private void CommandBindingMedicoNuevo_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            vm.medicoNuevo();
        }
    }
}
