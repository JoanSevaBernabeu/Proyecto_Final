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
    class TratamientoService
    {
        private string ruta;
        public TratamientoService()
        {
            ruta = "http://localhost:8081/gestimed/gestimed2/tratamiento";
        }
        public ObservableCollection<Tratamiento> getAllTratamientos()
        {
            var client = new RestClient(ruta);
            var request = new RestRequest(Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Tratamiento>>(response.Content);
        }
        public ObservableCollection<Tratamiento> getTratamiento(string nombre)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/" + nombre, Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Tratamiento>>(response.Content);
        }
        public IRestResponse postTratamiento(Tratamiento tratamiento)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/nuevo", Method.POST);
            string datos = JsonConvert.SerializeObject(tratamiento);
            request.AddParameter("application/json", datos, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }
        public IRestResponse deleteTratamiento(string nombre)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/delete/" + nombre, Method.DELETE);
            var response = client.Execute(request);
            return response;
        }
    }
}
