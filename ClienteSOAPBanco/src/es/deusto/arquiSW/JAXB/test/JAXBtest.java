package es.deusto.arquiSW.JAXB.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.arquiSW.JAXB.classes.Banco;
import es.deusto.arquiSW.JAXB.classes.Cliente;
import es.deusto.arquiSW.JAXB.classes.Cuenta;
import es.deusto.arquiSW.JAXB.classes.Operacion;
import es.deusto.arquiSW.JAXB.classes.Tarjeta;

public class JAXBtest {

	static final String XML_FILE = "src/es/deusto/arquiSW/JAXB/test/marshallingXML.xml";
	Banco DeustoBankTest;
	Cliente cli;
	Cuenta cuenta;
	Operacion o1, o2, o3;
	Tarjeta t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Clientes:
		cli = new Cliente("7979797979", "Aitor", "DB", "C/ avenida de las universidades, 24", "aitor@thebest.com", 69696969, true, 1234, null);
		ArrayList<Cliente> colecionClientes = new ArrayList<Cliente>();
		colecionClientes.add(cli);
		// Operaciones:
		o1 = new Operacion(0001, new Date(System.currentTimeMillis()-10000), Operacion.EnumTipoOperacion.Ingreso, 250, cuenta);
		o2 = new Operacion(0002, new Date(System.currentTimeMillis()-20000), Operacion.EnumTipoOperacion.Ingreso, 100, cuenta);
		o3 = new Operacion(0003, new Date(System.currentTimeMillis()-1500), Operacion.EnumTipoOperacion.Ingreso, 150, cuenta);
		ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
		operaciones.add(o1); operaciones.add(o2); operaciones.add(o3);
		// Tarjetas:
		t = new Tarjeta(555556, null, 1200, new Date(System.currentTimeMillis()+50000), Tarjeta.EnumProveedores.Visa, Tarjeta.TiposTarjeta.Debito, new Date(System.currentTimeMillis()-100000));
		ArrayList<Tarjeta> colecionTarjetas = new ArrayList<Tarjeta>();
		colecionTarjetas.add(t);
		// Cuentas:
		cuenta = new Cuenta(45454548, "SXXKUTXA-09", new Date(System.currentTimeMillis()), true, 500f, 0.5f, cli, t, operaciones);
		ArrayList<Cuenta> colecionCuentas = new ArrayList<Cuenta>();
		colecionCuentas.add(cuenta);
		// Banco:
		DeustoBankTest = new Banco();
		DeustoBankTest.setListaClientes(colecionClientes);
		DeustoBankTest.setListaCuentas(colecionCuentas);
		DeustoBankTest.setListaTarjetas(colecionTarjetas);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void marshal() throws JAXBException, IOException {
		// create JAXB context and instantiate marshaller
				JAXBContext context = JAXBContext.newInstance(Banco.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				System.out.println("%%%%%%%%%%%%% MARSHALLING: %%%%%%%%%%%%%");
				m.marshal(DeustoBankTest, System.out);
				m.marshal(DeustoBankTest, new File(XML_FILE));

//				Otra manera de hacerlo:
//				Writer w = null;
//				try {
//					w = new FileWriter(XML_FILE_MARSHAL);
//					m.marshal(DeustoBankTest, w);
//				} finally {
//					try {
//						w.close();
//					} catch (Exception e) {
//					}
//				}
//				System.out.println();
//				System.out.println("And also only one book: ");
//				m.marshal(book2, System.out);
	}
	
	@Test
	public void unmarshal() throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Banco.class);
		Unmarshaller um = context.createUnmarshaller();
		Banco banco = (Banco) um.unmarshal(new FileReader(XML_FILE));
		
		System.out.println("%%%%%%%%%%%%% UNMARSHALLING: %%%%%%%%%%%%%");
		for (int i = 0; i < banco.getListaClientes().size(); i++) {
			System.out.println(banco.getListaClientes().remove(i).getDNI());
		}
		for (int i = 0; i < banco.getListaCuentas().size(); i++) {
			System.out.println(banco.getListaCuentas().remove(i).getIBAN());
		}
		for (int i = 0; i < banco.getListaTarjetas().size(); i++) {
			System.out.println(banco.getListaTarjetas().remove(i).getNumero());
		}
	}

}
