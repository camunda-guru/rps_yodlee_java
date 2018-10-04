package com.yodlee.engg.utility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class App {

	public static void createxml()
	{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.newDocument();
			Element root =document.createElement("products");
			document.appendChild(root);
			Element subElement=document.createElement("product");
			Attr attribute=document.createAttribute("seasonal");
			attribute.setNodeValue("false");
			subElement.setAttributeNodeNS(attribute);
			root.appendChild(subElement);
			Element node=document.createElement("id");
			Text txtNode=document.createTextNode("1234");
			node.appendChild(txtNode);
			subElement.appendChild(node);
			node=document.createElement("name");
			txtNode=document.createTextNode("Laptop");
			node.appendChild(txtNode);
			subElement.appendChild(node);
			node=document.createElement("cost");
			txtNode=document.createTextNode("45000");
			node.appendChild(txtNode);
			subElement.appendChild(node);
			
			TransformerFactory tfactory =	TransformerFactory.newInstance();
			Transformer transformer=tfactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("product.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void readxml(String filename)
	{
		File file=new File(filename);
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document= builder.parse(file);
			
			NodeList nodeList= document.getElementsByTagName("product");
			
		    for(int i=0;i<nodeList.getLength();i++)
		    {
		    	
		    	Node node = nodeList.item(i);
		    	if(node.getNodeType()==Node.ELEMENT_NODE)
		    	{
		    		System.out.println(node.getNodeName());
		    		Element element=(Element) node;
		    		NodeList innerNodeList=element.getElementsByTagName("id");
		    		System.out.println(innerNodeList.item(0));
		    		
		    		
		    	}
		    	if(node.getNodeType()==Node.TEXT_NODE)
		    	{
		    		System.out.println(node.getNodeValue());
		    	}
		    	
		    	
		    }
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//createxml();
         readxml("product.xml");
	}

}
