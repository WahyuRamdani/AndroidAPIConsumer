using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.ServiceModel;
using System.ServiceModel.Web;
using System.ServiceModel.Activation;



namespace BalusoftAPI
{
    /// <summary>
    /// Clase que representa un Webservice REST
    /// </summary>
    [ServiceContract]
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.PerCall)]
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class BalusoftAPI
    {
        /// <summary>
        /// 
        /// </summary>
        public List<Persona> personas = new List<Persona>()
        { 
            new Persona()
            {
                Nombre = "Isaac",
                Apellido = "Ojeda",
                Edad = 22,
                Contacto = "isaacoq@gmail.com"
            },
            new Persona()
            {
                Nombre = "Fulanito",
                Apellido = "SuApellido",
                Edad = 50,
                Contacto = "funalito@mail.com"
            },
            new Persona()
            {
                Nombre = "Fulanito",
                Apellido = "SuApellido2",
                Edad = 25,
                Contacto = "funalitoSoyElSegundo@mail.com"
            },
        };


        /// <summary>
        /// Método que será llamado GET /getHello
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        [WebGet(UriTemplate="sayHello/{name}")]
        public string SayHello(string name)
        {
            return String.Format("Hola, {0}", name);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        [WebGet(UriTemplate = "persons/{name}")]
        public BalusoftResponse<List<Persona>> GetAllPersonsByName(string name)
        {            
            return  new BalusoftResponse<List<Persona>>()
            {
                StatusCode = System.Net.HttpStatusCode.OK,
                StatusMessage = "",
                Response = this.personas.Where(n => n.Nombre == name).ToList<Persona>()
            };
        }



    }
}