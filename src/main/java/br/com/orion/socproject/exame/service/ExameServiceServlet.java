package br.com.orion.socproject.exame.service;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

public class ExameServiceServlet extends CXFNonSpringServlet {

	private static final long serialVersionUID = 6607667132908200299L;

	@Override
    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/ExameService", new ExameService());
    }
}