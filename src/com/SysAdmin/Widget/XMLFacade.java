package com.SysAdmin.Widget;

// java
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
// javax
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// org.xmlpull
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;
// com.SysAdmin
import com.SysAdmin.AppFacade;
// android
import android.util.Log;
import android.util.Xml;

/**
 * @author Lukas Bernreiter
 * @version 0.2, 22/02/2012
 * @since 0.2
 */
public abstract class XMLFacade 
{
	/**
	 * Creates a new XML file.
	 * @param _widgets A list of widgets, used for creating the XML file.
	 * @throws Exception
	 */
	public static void Write(List<IWidget> _widgets) throws Exception
	{
		// initialize objects
		XmlSerializer serializer = Xml.newSerializer();
		FileWriter writer = new FileWriter(AppFacade.GetXMLFile());
		
		try
		{
			// set output and start tag
			serializer.setOutput(writer);
			serializer.startDocument("UTF-8", true);
			serializer.startTag("", "RSS-Widgets");
			serializer.attribute("", "Count", String.valueOf(_widgets.size()));
			
			// add each widget
			for(IWidget widget : _widgets)
			{
				serializer.startTag("", "Widget");
				serializer.attribute("", "URL", widget.getServerURL().getHost());
				serializer.startTag("", "Name");
				serializer.text(widget.getWidgetName());
			
				// add each filter
				for(String filter : widget.getActiveFilter())
				{
					serializer.startTag("", "Filter");
					serializer.text(filter);
					serializer.endTag("", "Filter");
				}
				
				serializer.endTag("", "Widget");
			}
			
			serializer.endTag("", "RSS-Widgets");
			serializer.endDocument();
			
		}catch(Exception _e)
		{
			Log.e(AppFacade.GetTag(), _e.getMessage());
			throw new Exception(_e.getMessage());
		}
	}
	
	/**
	 * Reads and parses the XML file using DOM.
	 * @return a list of widgets, retrieved from the XML file
	 * @throws Exception 
	 */
	public List<IWidget> Read() throws Exception
	{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		
		try
		{
			List<IWidget> widgets = new ArrayList<IWidget>();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(new File(AppFacade.GetXMLFile()));
			Element root = dom.getDocumentElement();
			NodeList widgetsList = root.getElementsByTagName(AppFacade.GetXMLStartWidget());
			
			for (int i = 0; i<widgetsList.getLength(); i++)
			{
				IWidget widget = new RSSWidget();
				Node widgetNode = widgetsList.item(i);						
				widget.setServerURL(new URL(widgetNode.getAttributes().item(0).toString()));
				NodeList widgetChildNodes = widgetNode.getChildNodes();
				
				for(int j = 0; j<widgetChildNodes.getLength(); j++)
				{
					// check if the child represents an filter
					if(widgetChildNodes.item(j).equals(AppFacade.GetXMLStartFilter()))
						widget.addFilterToList(widgetChildNodes.item(j).getTextContent());
					else if (widgetChildNodes.item(j).equals(AppFacade.GetXMLStartName()))
						widget.setWidgetName(widgetChildNodes.item(j).getTextContent());
				}
				
				widgets.add(widget);
			}
			
		}catch (Exception _e) 
		{
			Log.e(AppFacade.GetTag(), _e.getMessage());
			throw new Exception(_e.getMessage());
		}
		
		return null;
	}
	
}