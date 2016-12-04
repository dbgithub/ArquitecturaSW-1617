package es.deusto.arquiSW.JAXB.classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BancoJAXB {

	ArrayList<ClienteJAXB> listaClientes;
	ArrayList<CuentaJAXB> listaCuentas;
	ArrayList<TarjetaJAXB> listaTarjetas;
	
	public BancoJAXB() {
		
	}
	
	@XmlElementWrapper(name = "lista_clientes")
	@XmlElement(name = "cliente") // XmlElement especifica el nombre de las entidades
	public ArrayList<ClienteJAXB> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<ClienteJAXB> listaClientes) {
		this.listaClientes = listaClientes;
	}
	@XmlElementWrapper(name = "lista_cuentas")
	@XmlElement(name = "cuenta") // XmlElement especifica el nombre de las entidades
	public ArrayList<CuentaJAXB> getListaCuentas() {
		return listaCuentas;
	}
	public void setListaCuentas(ArrayList<CuentaJAXB> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	@XmlElementWrapper(name = "lista_tarjetas")
	@XmlElement(name = "tarjeta") // XmlElement especifica el nombre de las entidades
	public ArrayList<TarjetaJAXB> getListaTarjetas() {
		return listaTarjetas;
	}
	public void setListaTarjetas(ArrayList<TarjetaJAXB> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}
	
	
	
}
