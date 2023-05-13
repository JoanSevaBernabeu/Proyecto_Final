using Newtonsoft.Json;
using Proyecto.clases;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto
{
    class Servicio
    {
        string ruta;
        public Servicio()
        {
            ruta = "http://localhost:8081/gestimed/gestimed2";
        }
        public ObservableCollection<Medico> getMedicosTurno(string turno)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("medico/turno/" + turno,Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Medico>>(response.Content);
        }

        public ObservableCollection<Tratamiento> getAllTratamientos()
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("tratamiento", Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Tratamiento>>(response.Content);
        }
        public IRestResponse postPaciente(Paciente pacienteNuevo)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("paciente/nuevo", Method.POST);
            string datos = JsonConvert.SerializeObject(pacienteNuevo);
            request.AddParameter("application/json", datos, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }
    }
}
