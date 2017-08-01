package Comon;

public class admin extends Computador {

	colecaoResponsavel administardor = new colecaoResponsavel();
	colecaoComputador computerLab = new colecaoComputador();
	
	public admin(String computador, byte[] mac, String ip, String host) {
		super(computador, mac, ip, host);
	}

	
	
}
