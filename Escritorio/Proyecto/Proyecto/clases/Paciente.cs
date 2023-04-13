using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto.clases
{
    class Paciente
    {
        private string sip;
        private string nombre;
        private string apellidos;
        private string numContacto;
        private DateTime nacimiento;
        private List<Medico> medicos;
        private Tratamiento tratamiento;

        //Constructores
        public Paciente() { }

        public Paciente(string sip, string nombre, string apellidos, string numContacto, DateTime nacimiento)
        {
            this.sip = sip;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.numContacto = numContacto;
            this.nacimiento = nacimiento;
        }

        // Getters
        public string getSip() { return sip; }
        public string getNombre() { return nombre; }
        public string getApellidos() { return apellidos; }
        public string getNumContactos() { return numContacto; }
        public DateTime getNacimiento() { return nacimiento; }
        public List<Medico> getMedicos() { return medicos; }
        public Tratamiento getTratamiento() { return tratamiento; }

        //Setters
        public void setSip(string sip) { this.sip = sip; }
        public void setNombre(string nombre) { this.nombre = nombre; }
        public void setApellidos(string apellidos) { this.apellidos = apellidos; }
        public void setNumContacto(string numContacto) { this.numContacto = numContacto; }
        public void setNacimiento(DateTime nacimiento) { this.nacimiento = nacimiento; }
        public void setMedicos(List<Medico> medicos) { this.medicos = medicos; }
        public void setTratamiento(Tratamiento tratamiento) { this.tratamiento = tratamiento; }
    }
}
