
package com.helloweenvsfei.ch24.client;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class HelloWebServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public HelloWebServiceClient() {
        create0();
        Endpoint HelloWebServicePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://ch24.helloweenvsfei.com", "HelloWebServicePortTypeLocalEndpoint"), new QName("http://ch24.helloweenvsfei.com", "HelloWebServicePortTypeLocalBinding"), "xfire.local://HelloWebService");
        endpoints.put(new QName("http://ch24.helloweenvsfei.com", "HelloWebServicePortTypeLocalEndpoint"), HelloWebServicePortTypeLocalEndpointEP);
        Endpoint HelloWebServiceHttpPortEP = service0 .addEndpoint(new QName("http://ch24.helloweenvsfei.com", "HelloWebServiceHttpPort"), new QName("http://ch24.helloweenvsfei.com", "HelloWebServiceHttpBinding"), "http://localhost:8080/xfire/services/HelloWebService");
        endpoints.put(new QName("http://ch24.helloweenvsfei.com", "HelloWebServiceHttpPort"), HelloWebServiceHttpPortEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((com.helloweenvsfei.ch24.client.HelloWebServicePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://ch24.helloweenvsfei.com", "HelloWebServicePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://ch24.helloweenvsfei.com", "HelloWebServiceHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public HelloWebServicePortType getHelloWebServicePortTypeLocalEndpoint() {
        return ((HelloWebServicePortType)(this).getEndpoint(new QName("http://ch24.helloweenvsfei.com", "HelloWebServicePortTypeLocalEndpoint")));
    }

    public HelloWebServicePortType getHelloWebServicePortTypeLocalEndpoint(String url) {
        HelloWebServicePortType var = getHelloWebServicePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public HelloWebServicePortType getHelloWebServiceHttpPort() {
        return ((HelloWebServicePortType)(this).getEndpoint(new QName("http://ch24.helloweenvsfei.com", "HelloWebServiceHttpPort")));
    }

    public HelloWebServicePortType getHelloWebServiceHttpPort(String url) {
        HelloWebServicePortType var = getHelloWebServiceHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public static void main(String[] args) {
        HelloWebServiceClient client = new HelloWebServiceClient();
        //创建服务
        HelloWebServicePortType service = client.getHelloWebServiceHttpPort();
        //调用服务
		System.out.println(service.sayHello("Web Service"));
    }

}
