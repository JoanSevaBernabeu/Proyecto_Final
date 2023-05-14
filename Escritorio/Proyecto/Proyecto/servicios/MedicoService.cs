﻿using Newtonsoft.Json;
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
    class MedicoService
    {
        private string ruta;

        public MedicoService()
        {
            ruta = "http://localhost:8085/gestimed/gestiMed/medico";

        }
        public ObservableCollection<Medico> getAllMedicos()
        {
            var client = new RestClient(ruta);
            var request = new RestRequest(Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Medico>>(response.Content);
        }
        public ObservableCollection<Medico> getMedico(string dni)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/dni/" + dni, Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Medico>>(response.Content);
        }
        public IRestResponse postMedico(Medico medico)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/nuevo", Method.POST);
            string datos = JsonConvert.SerializeObject(medico);
            request.AddParameter("application/json", datos, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }
        public IRestResponse deleteMedico(string dni)
        {
            var client = new RestClient(ruta);
            var request = new RestRequest("/delete/" + dni, Method.DELETE);
            var response = client.Execute(request);
            return response;
        }
    }
}
