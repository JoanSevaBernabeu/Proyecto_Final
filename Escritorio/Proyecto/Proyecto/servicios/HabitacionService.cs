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
    class HabitacionService
    {
        private string ruta;

        public HabitacionService()
        {
            ruta = "http://localhost:8081/gestimed/gestimed2/habitacion";
        }

        public ObservableCollection<Habitacion> getAllHabitaciones()
        {
            var client = new RestClient(ruta);
            var request = new RestRequest(Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Habitacion>>(response.Content);
        }
        public ObservableCollection<Habitacion> getHabitacion(string numero)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/" + numero, Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Habitacion>>(response.Content);
        }
        public IRestResponse postHabitacion(Habitacion habitacion)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/nueva", Method.POST);
            string datos = JsonConvert.SerializeObject(habitacion);
            request.AddParameter("application/json", datos, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }
        public IRestResponse deleteHabitacion(string numero)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/delete/" + numero, Method.DELETE);
            var response = client.Execute(request);
            return response;
        }
    }
}
