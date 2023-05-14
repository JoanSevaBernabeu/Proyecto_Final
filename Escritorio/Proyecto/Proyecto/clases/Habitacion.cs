using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto.clases
{
    class Habitacion
    {
        private string numHabitacion;
        private int numCamasDisp;
        private int numCamasOcu;
        private List<Paciente> pacientes;

        // Constructores
        public Habitacion() { }
        public Habitacion(string numHabitacion, int numCamasDisp, int numCamasOcu) 
        {
            this.numHabitacion = numHabitacion;
            this.numCamasDisp = numCamasDisp;
            this.numCamasOcu = numCamasOcu;
        }

        public void addPaciente(Paciente paciente)
        {
            if (numCamasDisp > numCamasOcu) pacientes.Add(paciente);
        }

        // Getters
        public string getNumHabitacion() { return numHabitacion; }
        public int getNumCamasDisponibles() { return numCamasDisp; }
        public int getNumCamasOcupadas() { return numCamasOcu; }
        public List<Paciente> getListaPacientes() { return pacientes; }

        // Setters
        public void setNumHabitacion(string numHabitacion) { this.numHabitacion = numHabitacion; }
        public void setNumCamasDisponibles(int numCamasDisponibles) { numCamasDisponibles = numCamasDisp; }
        public void setNumCamasOcupadas(int numCamasOcupadas) { numCamasOcupadas = numCamasOcu; }
        public void setListaPacientes(List<Paciente> pacientes) { this.pacientes = pacientes; }
    }
}
