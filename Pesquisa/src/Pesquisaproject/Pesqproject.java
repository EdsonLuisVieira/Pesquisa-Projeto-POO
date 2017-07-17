package Pesquisaproject;
import java.io.*;
import java.util.*;


import org.omg.CORBA.Request;

import java.net.URLStreamHandler;
import java.net.*;
import java.net.Authenticator.RequestorType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.servlet.http.*;


public class Pesqproject extends javax.servlet.http.HttpServlet{

	public static void main(String[] args)   {
		
		try {
			
			/**
			 * Capturar Informações da maquina
			 */
		      InetAddress hostlocal = InetAddress.getLocalHost();
		      NetworkInterface netInter = NetworkInterface.getByInetAddress(hostlocal);
		      byte[] macAddressBytes = netInter.getHardwareAddress();
		      
		      String macAddress =  String.format ( "%1$02x-%2$02x-%3$02x-%4$02x-%5$02x-%6$02x",
		      macAddressBytes[0], macAddressBytes[1],
		      macAddressBytes[2], macAddressBytes[3],
		      macAddressBytes[4], macAddressBytes[5] ).toUpperCase();
		   
		    
		      System.out.println("---Host Local---");
		      System.out.println("host: "+hostlocal.getHostName());
		      System.out.println("Ipv4 Local: "+hostlocal.getHostAddress());
		      System.out.println("Mac: "+macAddress);
		      System.out.println("Placa de saida: "+netInter.getDisplayName());
		      System.out.println("Interface de Saida: "+netInter.getName());
		      System.out.println("------------------------------"); 
		      
		    
		      
		      /**
			   * Capturar Informações de Urls ip de Endereços de serviços e tradução dns 
			   */
		      
		     
		      InetAddress service1 = InetAddress.getByName("gru10s11-in-f4.1e100.net");
		      System.out.println("Servico1:" + service1.getCanonicalHostName());
		      System.out.println("EndereçoIp do Servico1:" + service1.getHostAddress());
		      InetAddress and = InetAddress.getByName("www.google.com"); 
		      System.out.println("end google: "+and.getHostAddress());
		      System.out.println("hostanme google: "+and.getHostName());
		      InetAddress service3 = InetAddress.getByName("www.facebook.com"); 
		      System.out.println("end facebbok: "+service3.getHostAddress());
		      System.out.println("hostanme facebook: "+service3.getHostName());
		      
		    
		       

		    }catch (Exception end){System.out.println(""+end.getMessage());}
		    
		 	
		
		 
		
		 try{
			 
			 /**
			  * Informações sobre a Rede que o Dispositivo está conectado
			  */
	
			 System.out.println("------------------------------"); 
			 InetAddress var =InetAddress.getByName("DESKTOP-3DS0N");
			 NetworkInterface end=NetworkInterface.getByInetAddress(var);
			 List <InterfaceAddress> valuee = new ArrayList <InterfaceAddress>();
			 valuee = end.getInterfaceAddresses();
			 for (int i=0;i<valuee.size();i++) {
				 System.out.println("Info gerais host Local: "+valuee.get(i)); 
			 }
		
		 }catch (Exception end){System.out.println(""+end.getMessage());}
		 System.out.println("------------------------------"); 
	}	 

}

		      
		      
		      
	
	


