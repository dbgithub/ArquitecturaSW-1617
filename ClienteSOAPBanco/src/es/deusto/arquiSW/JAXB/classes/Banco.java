package es.deusto.arquiSW.JAXB.classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Banco {

	ArrayList<Cliente> listaClientes;
	ArrayList<Cuenta> listaCuentas;
	ArrayList<Tarjeta> listaTarjetas;
	
	public Banco() {
		
	}
	
	@XmlElementWrapper(name = "lista_clientes")
	@XmlElement(name = "cliente") // XmlElement especifica el nombre de las entidades
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	@XmlElementWrapper(name = "lista_cuentas")
	@XmlElement(name = "cuenta") // XmlElement especifica el nombre de las entidades
	public ArrayList<Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	@XmlElementWrapper(name = "lista_tarjetas")
	@XmlElement(name = "tarjeta") // XmlElement especifica el nombre de las entidades
	public ArrayList<Tarjeta> getListaTarjetas() {
		return listaTarjetas;
	}
	public void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}
	
	
	
}
