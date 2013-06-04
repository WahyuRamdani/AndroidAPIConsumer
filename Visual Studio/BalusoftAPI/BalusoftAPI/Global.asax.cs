﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel.Activation;
using System.Web;
using System.Web.Routing;
using System.Web.Security;
using System.Web.SessionState;

namespace BalusoftAPI
{
    public class Global : System.Web.HttpApplication
    {

        protected void Application_Start(object sender, EventArgs e)
        {
            // http://localhost/api/sayHello
            RouteTable.Routes.Add(new ServiceRoute("api", new WebServiceHostFactory(), typeof(BalusoftAPI)));
        }
    }
}