using Newtonsoft.Json;
using Proyecto.clases;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto.servicios
{
    class PacienteService
    {
        private string ruta;
        public PacienteService()
        {
            ruta = "http://localhost:8085/gestiMed/gestimed/paciente";

        }
        public ObservableCollection<Paciente> getAllPacientes()
        {
            var client = new RestClient(ruta);
            var request = new RestRequest(Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Paciente>>(response.Content);
        }
        public ObservableCollection<Paciente> getPaciente(string sip)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/sip/" + sip, Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Paciente>>(response.Content);
        }
        public IRestResponse postPaciente(Paciente paciente)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/nuevo", Method.POST);
            string datos = JsonConvert.SerializeObject(paciente);
            request.AddParameter("application/json", datos, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }
        public IRestResponse deletePaciente(string sip)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/delete/" + sip, Method.DELETE);
            var response = client.Execute(request);
            return response;
        }
    }
}
