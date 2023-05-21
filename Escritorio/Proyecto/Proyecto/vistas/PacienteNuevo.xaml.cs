﻿using Proyecto.clases;
using Proyecto.viewmodels;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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
            //rellenaCombobox();
            
            
            InitializeComponent();
            creaCombobox();
            rellenaComboUrgencia();
        }
        private void aceptarButton_Click(object sender, RoutedEventArgs e)
        {
            Paciente paciente = obtenerPaciente();
            vm.aceptar(paciente);
        }
        private void rellenaComboUrgencia()
        {
            urgenciaComboBox.Items.Add("Urgente");
            urgenciaComboBox.Items.Add("Medio");
            urgenciaComboBox.Items.Add("Bajo");
        }
        private void rellenaComboTratamiento()
        {

        }
        private void addButton_Click(object sender, RoutedEventArgs e)
        {
            //rellenaComboboxMedicos();
            creaCombobox();
        }
        private void creaCombobox() 
        {
            ComboBox combo = new ComboBox();
            combo.Width = 110;
            combo.Height = 30;
            combo.Items.Add("Joan");
            combo.Items.Add("Antonio");
            combo.Items.Add("Jose");
            combo.Items.Add("Edurne");
            medicosStackPanel.Children.Add(combo);
        }
        private void cancelarButton_Click(object sender, RoutedEventArgs e)
        {
            vm.cancelar();
        }
        private void rellenaComboboxMedicos()
        {
            ComboBox combo = new ComboBox();
            combo.Width = 110;
            combo.Height = 30;
            StackPanel stack = medicosStackPanel;
            Collection<Medico> medicos = vm.getMedicos();
            foreach(Medico med in medicos)
            {
                combo.Items.Add(med.getNombre());
            }
            stack.Children.Add(combo);
        }
        private Collection<Medico> obtenerMedicos()
        {
            StackPanel stack = medicosStackPanel;
            Collection<Medico> medicos = null;
            for (int i = 0; i < stack.Children.Count; i++) 
            {
                Medico med = vm.getMedico(stack.Children[i].ToString());
                medicos.Add(med);
            }
            return medicos;
        }
        private Paciente obtenerPaciente()
        {
            Paciente paciente;
            string nombre = nombreTextBox.Text;
            string sip = SipTextBox.Text;
            string telefono = telefonoTextBox.Text;
            string apellidos = apellidoTextBox.Text;
            string sintomas = sintomasTextBox.Text;
            int dia = int.Parse(diaTextBox.Text);
            int mes = int.Parse(mesTextBox.Text);
            int ano = int.Parse(anoTextBox.Text);
            DateTime nacimiento = new DateTime(ano, mes, dia);
            Habitacion habitacion = vm.getHabitacion(numHabitacionTextBox.Text);
            Tratamiento tratamiento = vm.getTratamiento(tratamientoComboBox.SelectedItem.ToString());
            string urgencia = urgenciaComboBox.SelectedItem.ToString();
            Collection<Medico> medicos = obtenerMedicos();
            paciente = new Paciente(sip, nombre, apellidos, telefono, nacimiento, sintomas, urgencia);
            paciente.setHabitacion(habitacion);
            paciente.setTratamiento(tratamiento);
            paciente.setMedicos(medicos);
            return paciente;
        }
    }
}
