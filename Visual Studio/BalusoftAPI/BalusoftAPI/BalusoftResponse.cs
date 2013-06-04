using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BalusoftAPI
{
    public class BalusoftResponse<T>
    {
        public System.Net.HttpStatusCode StatusCode{ get; set; }
        public string StatusMessage { get; set; }
        public T Response { get; set; }
    }
}