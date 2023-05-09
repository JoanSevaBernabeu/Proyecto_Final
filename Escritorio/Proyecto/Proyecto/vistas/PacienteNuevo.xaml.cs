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
        public PacienteNuevo()
        {
            InitializeComponent();
        }
        private void aceptarButton_Click(object sender, RoutedEventArgs e)
        {
            if (!String.IsNullOrEmpty(SipTextBox.Text))
            {
                //vm.error();
            }
            else
            {
                //vm.aceptar();
            }
        }
    }
}
