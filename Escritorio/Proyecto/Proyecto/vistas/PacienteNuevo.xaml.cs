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
using System.Windows.Shapes;

namespace Proyecto.vistas
{
    /// <summary>
    /// Lógica de interacción para PacienteNuevo.xaml
    /// </summary>
    public partial class PacienteNuevo : Window
    {
        private PacienteNuevoVM vm;
        public PacienteNuevo()
        {
            vm = new PacienteNuevoVM();
            this.DataContext = vm;
            vm.setVentana(this);
            InitializeComponent();
        }
        private void aceptarButton_Click(object sender, RoutedEventArgs e)
        {
        }

        private void addButton_Click(object sender, RoutedEventArgs e)
        {
            ComboBox combo = new ComboBox();
            combo.Width = 110;
            combo.Height = 30;
            StackPanel stack = medicosStackPanel;
            stack.Children.Add(combo);
        }
        private void cancelarButton_Click(object sender, RoutedEventArgs e)
        {
            vm.cancelar();
        }
    }
}
