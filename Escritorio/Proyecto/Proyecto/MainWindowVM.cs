using Proyecto.clases;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto
{
    class MainWindowVM : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public ObservableCollection<Enfermero> listaEnfermerosMañana;
        public ObservableCollection<Enfermero> listaEnfermerosTarde;
        public ObservableCollection<Enfermero> listaEnfermerosNoche;

        public ObservableCollection<Medico> listaMedicosMañana;
        public ObservableCollection<Medico> listaMedicosTarde;
        public ObservableCollection<Medico> listaMedicosNoche;

        private Servicio _servicio;

        public MainWindowVM()
        {
            _servicio = new Servicio();
        }
        public void limpiarPantalla()
        {

        }
    }
}
