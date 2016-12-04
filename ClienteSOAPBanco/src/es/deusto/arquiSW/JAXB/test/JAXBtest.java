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

import es.deusto.arquiSW.JAXB.classes.BancoJAXB;
import es.deusto.arquiSW.JAXB.classes.ClienteJAXB;
import es.deusto.arquiSW.JAXB.classes.CuentaJAXB;
import es.deusto.arquiSW.JAXB.classes.OperacionJAXB;
import es.deusto.arquiSW.JAXB.classes.TarjetaJAXB;

public class JAXBtest {

	static final String XML_FILE = "src/es/deusto/arquiSW/JAXB/test/marshallingXML.xml";
	BancoJAXB DeustoBankTest;
	ClienteJAXB cli;
	CuentaJAXB cuenta;
	OperacionJAXB o1, o2, o3;
	TarjetaJAXB t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Clientes:
		cli = new ClienteJAXB("7979797979", "Aitor", "DB", "C/ avenida de las universidades, 24", "aitor@thebest.com", 69696969, true, 1234);
		ArrayList<ClienteJAXB> colecionClientes = new ArrayList<ClienteJAXB>();
		colecionClientes.add(cli);
		// Lista de operaciones:
		ArrayList<OperacionJAXB> operaciones = new ArrayList<OperacionJAXB>();
		// Cuentas:
		cuenta = new CuentaJAXB(45454548, "SXXKUTXA-09", new Date(System.currentTimeMillis()), true, 500f, 0.5f, cli.getDNI(), operaciones);
		ArrayList<CuentaJAXB> colecionCuentas = new ArrayList<CuentaJAXB>();
		colecionCuentas.add(cuenta);
		// Operaciones:
		o1 = new OperacionJAXB(0001, new Date(System.currentTimeMillis()-10000), OperacionJAXB.EnumTipoOperacion.Ingreso, 250, cuenta.getIBAN());
		o2 = new OperacionJAXB(0002, new Date(System.currentTimeMillis()-20000), OperacionJAXB.EnumTipoOperacion.Ingreso, 100, cuenta.getIBAN());
		o3 = new OperacionJAXB(0003, new Date(System.currentTimeMillis()-1500), OperacionJAXB.EnumTipoOperacion.Ingreso, 150, cuenta.getIBAN());
		operaciones.add(o1); operaciones.add(o2); operaciones.add(o3);
		// Tarjetas:
		t = new TarjetaJAXB(555556, cuenta.getIBAN(), 1200, new Date(System.currentTimeMillis()+50000), TarjetaJAXB.EnumProveedores.Visa, TarjetaJAXB.TiposTarjeta.Debito, new Date(System.currentTimeMillis()-100000));
		ArrayList<TarjetaJAXB> colecionTarjetas = new ArrayList<TarjetaJAXB>();
		colecionTarjetas.add(t);
		// Banco:
		DeustoBankTest = new BancoJAXB();
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
				JAXBContext context = JAXBContext.newInstance(BancoJAXB.class);
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
		JAXBContext context = JAXBContext.newInstance(BancoJAXB.class);
		Unmarshaller um = context.createUnmarshaller();
		BancoJAXB banco = (BancoJAXB) um.unmarshal(new FileReader(XML_FILE));
		
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
