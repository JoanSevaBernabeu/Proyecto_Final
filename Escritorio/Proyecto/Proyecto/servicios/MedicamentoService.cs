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
    class MedicamentoService
    {
        private string ruta;

        public MedicamentoService()
        {
            ruta = "http://localhost:8085/gestiMed/gestimed/medicamento";
        }

        public ObservableCollection<Medicamento> getAllMedicamentos()
        {
            var client = new RestClient(ruta);
            var request = new RestRequest(Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Medicamento>>(response.Content);
        }
        public ObservableCollection<Medicamento> getMedicamento(string id)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/id/" + id, Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Medicamento>>(response.Content);
        }
        public IRestResponse postMedicamento(Medicamento medicamento)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/nuevo", Method.POST);
            string datos = JsonConvert.SerializeObject(medicamento);
            request.AddParameter("application/json", datos, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }
        public IRestResponse deleteMedicamento(string id)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/delete/" + id, Method.DELETE);
            var response = client.Execute(request);
            return response;
        }
    }
}
