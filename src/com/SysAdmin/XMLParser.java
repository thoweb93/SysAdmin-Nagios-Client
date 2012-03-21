package com.SysAdmin;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.SysAdmin.Entity.HostEntity;
import com.SysAdmin.Entity.NagiosEntity;
import com.SysAdmin.Entity.ServiceEntity;

public class XMLParser {
	
	private static final String NODE_ROOT  		= "nagios_status";
	private static final String NODE_HOSTS 		= "hosts";
	private static final String NODE_HOST  		= "host";
	private static final String NODE_SERVICES 	= "services";
	private static final String NODE_SERVICE	= "service";
	
	private static final Integer NODE_ID_HOSTS    = 1;
	private static final Integer NODE_ID_SERVICES = 2;
	
	public static NagiosEntity parce(String _xmlFile)
	{
		// if parameter object xmlFile is empty
		if(_xmlFile.isEmpty())
			throw new Exception("File is empty");
			
		try{
			// Document XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder        builder = factory.newDocumentBuilder();
			Document               dom 	   = builder.parse(new File(_xmlFile));
			
			// XML Nodes
			Element  root  = dom.getDocumentElement();				// XML Root
			NodeList node_root = root.getElementsByTagName(NODE_ROOT);	// subNodes
			
			Node node_hosts    = node_root.item(NODE_ID_HOSTS);
			Node node_services = node_root.item(NODE_ID_SERVICES);
			
			parseHosts(node_hosts);
			
			// get sub nodes
			for(int i=0; i < items.getLength(); i++)
			{
				
				/*
				Node item = items.item(i);
				NodeList properties = item.getChildNodes();
				
				for(int j=0;j<properties.getLength();j++)
				{
					Node property = properties.item(j);
					String name   = property.getNodeName();
					
					if(name.equalsIgnoreCase(""))
				}*/
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	private static HostEntity[] parseHosts(Node _node_hosts)
	{
		NodeList hosts	    = _node_hosts.getChildNodes();
		Integer  hostsCount = hosts.getLength();
		
		HostEntity[] hostEntities = new HostEntity[hostsCount];
		
		// get sub nodes
		for(int i=0; i < hosts.getLength(); i++)
		{
			hostEntities[i] = parseHost(hosts.item(i));
		}
		
		return hostEntities;
	}
	
	private static HostEntity parseHost(Node _node_host)
	{
		HostEntity hostEntity = new HostEntity();
		
		return hostEntity;
	}
	
	private static ServiceEntity[] parseServices()
	{}
	
	private static ServiceEntity parseService()
	{}
}
