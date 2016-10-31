package es.deusto.arquiSW.SOAP.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import es.deusto.arquiSW.JAXB.classes.Banco;
import es.deusto.arquiSW.JAXB.classes.Cliente;
import es.deusto.arquiSW.JAXB.classes.Cuenta;
import es.deusto.arquiSW.JAXB.classes.Tarjeta;
import es.deusto.arquiSW.SOAP.DeustoBankServiceStub;
import es.deusto.arquiSW.SOAP.Importar;
import es.deusto.arquiSW.SOAP.ObtenerCliente;
import es.deusto.arquiSW.SOAP.ObtenerClienteResponse;
import es.deusto.arquiSW.SOAP.ObtenerCuenta;
import es.deusto.arquiSW.SOAP.ObtenerCuentaResponse;
import es.deusto.arquiSW.SOAP.ObtenerTarjeta;
import es.deusto.arquiSW.SOAP.ObtenerTarjetaResponse;
import es.deusto.arquiSW.threads.InicializacionThread;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Mainwindow extends JFrame {

	private DeustoBankServiceStub SOAPservice; // Este es la variable del Servicio Web SOAP.
	private Banco bnc; // Variable que se utiliza en el proceso de IMPORTAR y EXPORTAR datos desde un XML (JAXB)
	private Cliente[] tempClientes; // Este array temporal de CLIENTES guarda todos los clientes obtenidos desde el servicio SOAP
	private Cuenta[] tempCuentas; // Este array temporal de CUENTAS guarda todos los clientes obtenidos desde el servicio SOAP
	private Tarjeta[] tempTarjetas; // Este array temporal de TARJETAS guarda todos los clientes obtenidos desde el servicio SOAP
	private JPanel contentPane;
	private JTable table;
	private JTable table_2;
	private JTable table_1;
	private JTextField textFieldIBAN;
	private JTextField textFieldDNICliente;
	private JTextField textFieldFechaApertura;
	private JTextField textFieldNumeroTarjeta;
	private JTextField textFieldDNIClienteTarjeta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textFieldSeleccionarArchivo;
	private JTable tableResultadosClientes;
	private JTable tableResultadosCuentas;
	private JTable tableResultadosTarjetas;
	private JButton btnBorrarClientes;
	private JButton btnBorrarCuentas;
	private JButton btnBorrarTarjetas;
	private JTable tableClientes;
	private JTable tableCuentas;
	private JTable tableTarjetas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainwindow frame = new Mainwindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainwindow() {
		// Lanzamos un Thread para que la inicializacion y la obtencion
		// de datos del servicio web se haga en un hilo aparte.
		InicializacionThread iniThread = new InicializacionThread(this);
		Thread initializationThreat = new Thread(iniThread);
		initializationThreat.start();
		
		setTitle("DeustoBank(SOAP)");
		setMinimumSize(new Dimension(600, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTitle = new JLabel("DeustoBank (SOAP)");
		lblTitle.setFont(new Font("Khmer OS System", Font.BOLD, 23));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addGap(111)
								.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(101))
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(5)
										.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)));

		JPanel panel_importar = new JPanel();
		panel_importar.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane.addTab("Importar", null, panel_importar, null);

		JLabel lblSeleccionarArchivo = new JLabel("Seleccionar archivo");

		textFieldSeleccionarArchivo = new JTextField();
		textFieldSeleccionarArchivo.setColumns(10);

		JButton btnSubir = new JButton("Subir");

		// Funcionalidad del boton subir
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creamos el objeto JFileChooser
				JFileChooser fc = new JFileChooser();
				// Elegimos como extension predeterminada .xml
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
				fc.setFileFilter(xmlfilter);
				// Abrimos la ventana, guardamos la opcion seleccionada por el
				// usuario
				int seleccion = fc.showOpenDialog(contentPane);

				// Si el usuario, pincha en aceptar
				if (seleccion == JFileChooser.APPROVE_OPTION) {

					// Seleccionamos el fichero
					File fichero = fc.getSelectedFile();

					JAXBContext jaxbContext;
					try {
						jaxbContext = JAXBContext.newInstance(Banco.class);
						Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
						bnc = (Banco) jaxbUnmarshaller.unmarshal(fichero);
						if(bnc.getListaClientes().size()!=0){
							for (int i = 0; i < bnc.getListaClientes().size(); i++) {
								Cliente c= bnc.getListaClientes().get(i);
								DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
								model.addRow(new Object[]{c.getDNI(), c.getNombre(),c.getApellidos(),c.getDireccion(),c.getEmail(),c.getMovil(),(c.isEmpleado()) ? "Si" : "No"});
								
							}
						}
						
						if(bnc.getListaCuentas().size()!=0){
							for (int i = 0; i < bnc.getListaCuentas().size(); i++) {
								Cuenta cu= bnc.getListaCuentas().get(i);
								DefaultTableModel model = (DefaultTableModel) tableCuentas.getModel();
								model.addRow(new Object[]{cu.getIBAN(),cu.getSWIFT(),cu.getFechaApertura(),(cu.isActiva())?"Si":"No",cu.getSaldoActual(),cu.getInteres(),cu.getTitular()});
							}
							
						}
						
						if(bnc.getListaTarjetas().size()!=0){
							for (int i = 0; i < bnc.getListaTarjetas().size(); i++) {
								Tarjeta t= bnc.getListaTarjetas().get(i);
								DefaultTableModel model = (DefaultTableModel) tableTarjetas.getModel();
								model.addRow(new Object[]{t.getNumero(),t.getLimiteExtraccion(),t.getFechaCaducidad(),t.getProveedor(),t.getTipo(),t.getFechaExpedicion(),t.getCuenta()});
							}
							
						}
						
						

					} catch (JAXBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Importar im = new Importar();
				Cliente[] arrayClientes = (Cliente[])bnc.getListaClientes().toArray() ;
				Cuenta[] arrayCuentas = (Cuenta[])bnc.getListaCuentas().toArray();
				Tarjeta[] arrayTarjetas = (Tarjeta[])bnc.getListaTarjetas().toArray();
				
				
//				im.setClientes(arrayClientes);
//				im.setCuentas(arrayCuentas);
//				im.setTarjetas(arrayTarjetas);
//				
			
				
			}
		});
		GroupLayout gl_panel_importar = new GroupLayout(panel_importar);
		gl_panel_importar.setHorizontalGroup(gl_panel_importar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_importar.createSequentialGroup()
						.addGroup(gl_panel_importar.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_importar.createSequentialGroup().addContainerGap().addComponent(
										btnImportar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_importar.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_importar.createSequentialGroup().addGap(116).addComponent(
												tabbedPane_1, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
										.addGroup(
												gl_panel_importar.createSequentialGroup().addGap(200)
														.addComponent(lblSeleccionarArchivo).addGap(44)
														.addComponent(textFieldSeleccionarArchivo,
																GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnSubir, GroupLayout.PREFERRED_SIZE, 91,
																GroupLayout.PREFERRED_SIZE)
														.addGap(149))))
						.addGap(165)));
		gl_panel_importar.setVerticalGroup(gl_panel_importar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_importar.createSequentialGroup().addGap(29)
						.addGroup(gl_panel_importar.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSeleccionarArchivo).addComponent(btnSubir).addComponent(
										textFieldSeleccionarArchivo, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE).addGap(18)
						.addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGap(57)));

		JPanel panelClientes = new JPanel();
		tabbedPane_1.addTab("Clientes", null, panelClientes, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panelClientes = new GroupLayout(panelClientes);
		gl_panelClientes.setHorizontalGroup(
			gl_panelClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelClientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelClientes.setVerticalGroup(
			gl_panelClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
					.addGap(19))
		);
		
		JPanel panel_2 = new JPanel();
		scrollPane_2.setViewportView(panel_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
					.addGap(19))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
					.addGap(23))
		);
		
		tableClientes = new JTable();
		tableClientes.setRowSelectionAllowed(false);
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellidos", "Direccion", "Email", "Movil", "Empleado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(tableClientes);
		panel_2.setLayout(gl_panel_2);
		panelClientes.setLayout(gl_panelClientes);

		JPanel panelCuentas = new JPanel();
		tabbedPane_1.addTab("Cuentas", null, panelCuentas, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GroupLayout gl_panelCuentas = new GroupLayout(panelCuentas);
		gl_panelCuentas.setHorizontalGroup(
			gl_panelCuentas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCuentas.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelCuentas.setVerticalGroup(
			gl_panelCuentas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCuentas.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_3 = new JPanel();
		scrollPane_4.setViewportView(panel_3);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
					.addGap(21))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
					.addGap(41))
		);
		
		tableCuentas = new JTable();
		tableCuentas.setRowSelectionAllowed(false);
		tableCuentas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IBAN", "SWIFT", "Fecha apertura", "Activa", "Saldo actual", "Interes", "DNI titular"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCuentas.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane_5.setViewportView(tableCuentas);
		panel_3.setLayout(gl_panel_3);
		panelCuentas.setLayout(gl_panelCuentas);

		JPanel panelTarjetas = new JPanel();
		tabbedPane_1.addTab("Tarjetas", null, panelTarjetas, null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GroupLayout gl_panelTarjetas = new GroupLayout(panelTarjetas);
		gl_panelTarjetas.setHorizontalGroup(
			gl_panelTarjetas.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelTarjetas.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelTarjetas.setVerticalGroup(
			gl_panelTarjetas.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelTarjetas.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_4 = new JPanel();
		scrollPane_6.setViewportView(panel_4);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
		);
		
		tableTarjetas = new JTable();
		tableTarjetas.setRowSelectionAllowed(false);
		tableTarjetas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Fecha caducidad", "Proveedor", "Tipo", "Limite extraccion", "Fecha expedicion", "Cuenta vinculada"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTarjetas.getColumnModel().getColumn(1).setPreferredWidth(97);
		tableTarjetas.getColumnModel().getColumn(4).setPreferredWidth(93);
		tableTarjetas.getColumnModel().getColumn(5).setPreferredWidth(95);
		tableTarjetas.getColumnModel().getColumn(6).setPreferredWidth(96);
		scrollPane_7.setViewportView(tableTarjetas);
		panel_4.setLayout(gl_panel_4);
		panelTarjetas.setLayout(gl_panelTarjetas);
		panel_importar.setLayout(gl_panel_importar);

		JPanel panel_exportar = new JPanel();
		panel_exportar.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane.addTab("Exportar", null, panel_exportar, null);

		JTabbedPane tabbedPane_inside = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_exportar = new GroupLayout(panel_exportar);
		gl_panel_exportar.setHorizontalGroup(gl_panel_exportar.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_inside, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE));
		gl_panel_exportar.setVerticalGroup(gl_panel_exportar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_exportar.createSequentialGroup().addGap(24).addComponent(tabbedPane_inside,
						GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)));

		JPanel panel_clientes = new JPanel();
		panel_clientes.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("Clientes", null, panel_clientes, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_clientes = new GroupLayout(panel_clientes);
		gl_panel_clientes.setHorizontalGroup(gl_panel_clientes.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE));
		gl_panel_clientes.setVerticalGroup(gl_panel_clientes.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE));

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);

		JScrollPane scrollPaneForTableClientesFiltro = new JScrollPane();
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"DNI", "Nombre", "Apellidos", "Direccion", "Email", "Movil", "Empleado"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPaneForTableClientesFiltro.setViewportView(table);

		JButton btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBorrarClientes.doClick();
				tableResultadosClientes.setModel(table.getModel());
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		JLabel label = new JLabel("Email");
		label.setForeground(Color.WHITE);

		JLabel label_1 = new JLabel("DNI");
		label_1.setForeground(Color.WHITE);

		JLabel label_2 = new JLabel("M\u00F3vil");
		label_2.setForeground(Color.WHITE);

		JLabel label_3 = new JLabel("Apellidos");
		label_3.setForeground(Color.WHITE);

		JLabel label_4 = new JLabel("Nombre");
		label_4.setForeground(Color.WHITE);

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JCheckBox checkBox = new JCheckBox("Empleado");
		checkBox.setForeground(Color.WHITE);
		checkBox.setBackground((Color)null);

		JButton button_1 = new JButton("Aplicar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				es.deusto.arquiSW.SOAP.classes.xsd.Cliente[] arrayCliente;
				ObtenerCliente obtCliente = new ObtenerCliente();
				obtCliente.setDNI((textField_2.getText() != "") ? textField_2.getText() : null);
				obtCliente.setNombre((textField_3.getText() != "") ? textField_3.getText() : null);
				obtCliente.setApellidos((textField_4.getText() != "") ? textField_4.getText() : null);
				obtCliente.setEmail((textField.getText() != "") ? textField.getText() : null);
				obtCliente.setMovil((textField_1.getText() != "") ? textField_1.getText() : null);
				obtCliente.setEmpleado((checkBox.isSelected()) ? checkBox.isSelected() : null);
				ObtenerClienteResponse obtCienteRes;
				try {
					obtCienteRes = SOAPservice.obtenerCliente(obtCliente);
					arrayCliente = obtCienteRes.get_return();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					for (es.deusto.arquiSW.SOAP.classes.xsd.Cliente c : arrayCliente) {
						model.addRow(new Object[]{c.getDNI(), c.getNombre(),c.getApellidos(),c.getDireccion(),c.getEmail(),c.getMovil(),(c.getEmpleado()) ? "Si" : "No"});
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING).addGap(0, 896, Short.MAX_VALUE).addGroup(gl_panel_1
						.createSequentialGroup().addGap(49).addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING, false).addComponent(label).addComponent(
										label_1)
								.addComponent(label_2)
								.addComponent(label_3).addComponent(label_4))
						.addGap(21)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(textField, GroupLayout.DEFAULT_SIZE, 578,
																Short.MAX_VALUE)
														.addGap(29))
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 280,
																Short.MAX_VALUE)
														.addGap(61).addComponent(checkBox, GroupLayout.DEFAULT_SIZE,
																266, Short.MAX_VALUE)))
										.addGap(66).addComponent(button_1, GroupLayout.PREFERRED_SIZE, 101,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(
										gl_panel_1.createSequentialGroup()
												.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 516,
														Short.MAX_VALUE)
												.addGap(258))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(textField_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														729, Short.MAX_VALUE)
												.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 729,
														Short.MAX_VALUE))
										.addGap(45)))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGap(0, 168, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(
										gl_panel_1.createSequentialGroup().addGap(31)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
														.addComponent(label_4).addComponent(textField_3,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))))
						.addGap(11)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_3).addComponent(
								textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
								.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label).addComponent(textField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox)))
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(33)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE).addGap(54))
				.addGroup(Alignment.TRAILING,
						gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnAniadir, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPaneForTableClientesFiltro, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE))
								.addGap(22)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addGap(11)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 172,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(scrollPaneForTableClientesFiltro, GroupLayout.PREFERRED_SIZE, 249,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnAniadir, GroupLayout.PREFERRED_SIZE, 45,
												GroupLayout.PREFERRED_SIZE)
										.addGap(56)));
		panel.setLayout(gl_panel);
		panel_clientes.setLayout(gl_panel_clientes);

		JPanel panel_cuentas = new JPanel();
		panel_cuentas.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("Cuentas", null, panel_cuentas, null);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_cuentas = new GroupLayout(panel_cuentas);
		gl_panel_cuentas.setHorizontalGroup(gl_panel_cuentas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE));
		gl_panel_cuentas.setVerticalGroup(gl_panel_cuentas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE));

		JPanel panel2 = new JPanel();
		scrollPane2.setViewportView(panel2);

		JPanel filterpane2 = new JPanel();
		filterpane2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		filterpane2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		JScrollPane scrollPaneForTableCuentasFiltro = new JScrollPane();
		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"IBAN", "SWIFT", "Fecha apertura", "Activa", "Saldo actual", "Interes", "DNI titular", "Tarjeta vinculada"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(59);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(57);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(111);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(63);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(63);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(79);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(120);
		scrollPaneForTableCuentasFiltro.setViewportView(table_1);

		JLabel lblIban = new JLabel("IBAN");
		lblIban.setForeground(Color.WHITE);

		textFieldIBAN = new JTextField();
		textFieldIBAN.setColumns(10);

		JLabel lblDniCliente = new JLabel("DNI Cliente");
		lblDniCliente.setForeground(Color.WHITE);

		textFieldDNICliente = new JTextField();
		textFieldDNICliente.setColumns(10);

		JLabel lblFechaApertura = new JLabel("Fecha Apertura");
		lblFechaApertura.setForeground(Color.WHITE);

		textFieldFechaApertura = new JTextField();
		textFieldFechaApertura.setColumns(10);

		JCheckBox chckbxActiva = new JCheckBox("Activa");
		chckbxActiva.setForeground(Color.WHITE);
		chckbxActiva.setBackground((Color)null);

		JLabel lblInters = new JLabel("Inter\u00E9s");
		lblInters.setForeground(Color.WHITE);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {null, "0.1", "0.5", "1.2", "5"}));

		JButton btnAplicarCuentas = new JButton("Aplicar");
		btnAplicarCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				es.deusto.arquiSW.SOAP.classes.xsd.Cuenta[] arrayCuenta;
				ObtenerCuenta obtCuenta = new ObtenerCuenta();
				obtCuenta.setIBAN((textFieldIBAN.getText() != "") ? textFieldIBAN.getText() : null);
				obtCuenta.setDNI((textFieldDNICliente.getText() != "") ? textFieldDNICliente.getText() : null);
				obtCuenta.setFechaApertura((textFieldFechaApertura.getText() != "") ? textFieldFechaApertura.getText() : null);
				obtCuenta.setInteres((comboBox.getSelectedItem() != "") ? (String)comboBox.getSelectedItem() : null);
				obtCuenta.setActiva((chckbxActiva.isSelected()) ? chckbxActiva.isSelected() : null);
				ObtenerCuentaResponse obtCuentaRes;
				try {
					obtCuentaRes = SOAPservice.obtenerCuenta(obtCuenta);
					arrayCuenta = obtCuentaRes.get_return();
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					for (es.deusto.arquiSW.SOAP.classes.xsd.Cuenta cu : arrayCuenta) {
						model.addRow(new Object[]{cu.getIBAN(),cu.getSWIFT(),cu.getFechaApertura(),(cu.getActiva())?"Si":"No",cu.getSaldoActual(),cu.getInteres(),cu.getTitular()});
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		GroupLayout gl_filterpane2 = new GroupLayout(filterpane2);
		gl_filterpane2.setHorizontalGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING).addGroup(gl_filterpane2
				.createSequentialGroup().addGap(47)
				.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING).addComponent(lblFechaApertura)
						.addComponent(lblIban).addComponent(lblDniCliente).addComponent(lblInters))
				.addGap(58)
				.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldFechaApertura, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
						.addGroup(gl_filterpane2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldIBAN, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
						.addComponent(textFieldDNICliente, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
						.addGroup(gl_filterpane2.createSequentialGroup()
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
								.addComponent(chckbxActiva)))
				.addGap(18).addComponent(btnAplicarCuentas, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
				.addGap(12)));
		gl_filterpane2.setVerticalGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING).addGroup(gl_filterpane2
				.createSequentialGroup()
				.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_filterpane2.createSequentialGroup().addContainerGap()
								.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE).addComponent(lblIban)
										.addComponent(textFieldIBAN, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDniCliente).addComponent(textFieldDNICliente,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblFechaApertura).addComponent(textFieldFechaApertura,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblInters).addComponent(comboBox,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(chckbxActiva)))
						.addGroup(gl_filterpane2.createSequentialGroup().addGap(81).addComponent(btnAplicarCuentas,
								GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(23, Short.MAX_VALUE)));
		filterpane2.setLayout(gl_filterpane2);

		JButton btnAniadirCuentas = new JButton("A\u00F1adir");
		btnAniadirCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBorrarCuentas.doClick();
				tableResultadosCuentas.setModel(table_1.getModel());
			}
		});
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAniadirCuentas, GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPaneForTableCuentasFiltro, GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
						.addGap(27))
				.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup().addGap(35)
						.addComponent(filterpane2, GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE).addGap(41)));
		gl_panel2
				.setVerticalGroup(
						gl_panel2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel2.createSequentialGroup().addGap(19)
										.addComponent(filterpane2, GroupLayout.PREFERRED_SIZE, 154,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(scrollPaneForTableCuentasFiltro, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
										.addGap(18).addComponent(btnAniadirCuentas, GroupLayout.PREFERRED_SIZE, 39,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47)));
		panel2.setLayout(gl_panel2);
		panel_cuentas.setLayout(gl_panel_cuentas);

		JPanel panel_tarjetas = new JPanel();
		panel_tarjetas.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("Tarjetas", null, panel_tarjetas, null);
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_tarjetas = new GroupLayout(panel_tarjetas);
		gl_panel_tarjetas.setHorizontalGroup(gl_panel_tarjetas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE));
		gl_panel_tarjetas.setVerticalGroup(gl_panel_tarjetas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE));

		JPanel panel3 = new JPanel();
		scrollPane3.setViewportView(panel3);

		JPanel filterpane3 = new JPanel();
		filterpane3.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		filterpane3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		JScrollPane scrollPaneForTableTarjetasFiltro = new JScrollPane();
		table_2 = new JTable();
		table_2.setRowSelectionAllowed(false);
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Numero", "Fecha caducidad", "Proveedor", "Tipo", "Limite extraccion", "Fecha expedicion", "Cuenta vinculada"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(66);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(125);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(64);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(114);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(120);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(112);
		scrollPaneForTableTarjetasFiltro.setViewportView(table_2);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setForeground(Color.WHITE);

		textFieldNumeroTarjeta = new JTextField();
		textFieldNumeroTarjeta.setColumns(10);

		JLabel lblDNIcliente = new JLabel("DNI Cliente");
		lblDNIcliente.setForeground(Color.WHITE);

		textFieldDNIClienteTarjeta = new JTextField();
		textFieldDNIClienteTarjeta.setColumns(10);

		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setForeground(Color.WHITE);

		JComboBox<String> comboBoxProveedor = new JComboBox<String>();
		comboBoxProveedor.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Visa", "MasterCard", "AmericanExpress"}));

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Debito", "Credito"}));

		JButton buttonAplicarTarjetas = new JButton("Aplicar");
		buttonAplicarTarjetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta[] arrayTarjeta;
				ObtenerTarjeta obtTarjeta = new ObtenerTarjeta();
				obtTarjeta.setNumero((textFieldNumeroTarjeta.getText() != "") ? textFieldNumeroTarjeta.getText() : null);
				obtTarjeta.setDNI((textFieldDNIClienteTarjeta.getText() != "") ? textFieldDNIClienteTarjeta.getText() : null);
				obtTarjeta.setProveedor((comboBoxProveedor.getSelectedItem() != "") ? (String)comboBoxProveedor.getSelectedItem() : null);
				obtTarjeta.setTipo((comboBox_1.getSelectedItem() != "") ? (String)comboBox_1.getSelectedItem() : null);
				ObtenerTarjetaResponse obtTarjetaRes;
				try {
					obtTarjetaRes = SOAPservice.obtenerTarjeta(obtTarjeta);
					arrayTarjeta = obtTarjetaRes.get_return();
					DefaultTableModel model = (DefaultTableModel) table_2.getModel();
					for (es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta t : arrayTarjeta) {
						model.addRow(new Object[]{t.getNumero(),t.getLimiteExtraccion(),t.getFechaCaducidad(),t.getProveedor(),t.getTipo(),t.getFechaExpedicion(),t.getCuenta()});
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		GroupLayout gl_filterpane3 = new GroupLayout(filterpane3);
		gl_filterpane3.setHorizontalGroup(gl_filterpane3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_filterpane3.createSequentialGroup().addGap(25)
						.addGroup(gl_filterpane3.createParallelGroup(Alignment.LEADING).addComponent(lblProveedor)
								.addComponent(lblNumero))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_filterpane3.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxProveedor, 0, 317, Short.MAX_VALUE).addComponent(
										textFieldNumeroTarjeta, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_filterpane3.createParallelGroup(Alignment.LEADING).addComponent(lblDNIcliente)
								.addComponent(lblTipo))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_filterpane3.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 239,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDNIClienteTarjeta))
						.addGap(43).addComponent(buttonAplicarTarjetas, GroupLayout.PREFERRED_SIZE, 105,
								GroupLayout.PREFERRED_SIZE)
						.addGap(59)));
		gl_filterpane3
				.setVerticalGroup(
						gl_filterpane3.createParallelGroup(Alignment.TRAILING)
								.addGroup(
										gl_filterpane3.createSequentialGroup().addGroup(gl_filterpane3
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_filterpane3.createSequentialGroup().addGap(35)
														.addGroup(gl_filterpane3.createParallelGroup(Alignment.TRAILING)
																.addGroup(gl_filterpane3.createSequentialGroup()
																		.addGroup(gl_filterpane3
																				.createParallelGroup(Alignment.BASELINE)
																				.addComponent(lblNumero)
																				.addComponent(textFieldNumeroTarjeta,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				gl_filterpane3
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblProveedor)
																						.addComponent(
																								comboBoxProveedor,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
																.addGroup(
																		gl_filterpane3.createSequentialGroup()
																				.addGroup(gl_filterpane3
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(lblDNIcliente)
																						.addComponent(
																								textFieldDNIClienteTarjeta,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																				.addGap(18)
																				.addGroup(gl_filterpane3
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(lblTipo)
																						.addComponent(comboBox_1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))))
												.addGroup(gl_filterpane3.createSequentialGroup().addGap(47)
														.addComponent(buttonAplicarTarjetas, GroupLayout.PREFERRED_SIZE,
																38, GroupLayout.PREFERRED_SIZE)))
												.addContainerGap(37, Short.MAX_VALUE)));
		filterpane3.setLayout(gl_filterpane3);

		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrarTarjetas.doClick();
				tableResultadosTarjetas.setModel(table_2.getModel());
			}
		});
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(26)
					.addComponent(filterpane3, GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
					.addGap(74))
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap(874, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
				.addGroup(Alignment.LEADING, gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneForTableTarjetasFiltro, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
					.addGap(48))
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(filterpane3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(scrollPaneForTableTarjetasFiltro, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
		);
		panel3.setLayout(gl_panel3);
		panel_tarjetas.setLayout(gl_panel_tarjetas);

		JPanel panel_resultado = new JPanel();
		panel_resultado.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("RESULTADO", null, panel_resultado, null);

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_resultado = new GroupLayout(panel_resultado);
		gl_panel_resultado
				.setHorizontalGroup(gl_panel_resultado.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_resultado.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_resultado
				.setVerticalGroup(gl_panel_resultado.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_resultado.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
								.addContainerGap()));

		JPanel panel_5 = new JPanel();
		scrollPane_1.setViewportView(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cuentas", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

		JScrollPane scrollPaneForTableCuentas = new JScrollPane();
		tableResultadosCuentas = new JTable();
		tableResultadosCuentas.setRowSelectionAllowed(false);
		tableResultadosCuentas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IBAN", "SWIFT", "Fecha apertura", "Activa", "Saldo actual", "Interes", "DNI titular", "Tarjeta vinculada"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableResultadosCuentas.getColumnModel().getColumn(0).setPreferredWidth(59);
		tableResultadosCuentas.getColumnModel().getColumn(1).setPreferredWidth(57);
		tableResultadosCuentas.getColumnModel().getColumn(2).setPreferredWidth(111);
		tableResultadosCuentas.getColumnModel().getColumn(3).setPreferredWidth(63);
		tableResultadosCuentas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableResultadosCuentas.getColumnModel().getColumn(5).setPreferredWidth(63);
		tableResultadosCuentas.getColumnModel().getColumn(6).setPreferredWidth(79);
		tableResultadosCuentas.getColumnModel().getColumn(7).setPreferredWidth(120);
		scrollPaneForTableCuentas.setViewportView(tableResultadosCuentas);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup().addContainerGap()
						.addComponent(scrollPaneForTableCuentas, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_7.setVerticalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
						.addComponent(scrollPaneForTableCuentas, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
						.addGap(4)));
		panel_7.setLayout(gl_panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tarjetas", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

		JScrollPane scrollPaneForTableTarjetas = new JScrollPane();
		tableResultadosTarjetas = new JTable();
		tableResultadosTarjetas.setRowSelectionAllowed(false);
		tableResultadosTarjetas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Fecha caducidad", "Proveedor", "Tipo", "Limite extraccion", "Fecha expedicion", "Cuenta vinculada"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableResultadosTarjetas.getColumnModel().getColumn(0).setPreferredWidth(66);
		tableResultadosTarjetas.getColumnModel().getColumn(1).setPreferredWidth(125);
		tableResultadosTarjetas.getColumnModel().getColumn(3).setPreferredWidth(64);
		tableResultadosTarjetas.getColumnModel().getColumn(4).setPreferredWidth(114);
		tableResultadosTarjetas.getColumnModel().getColumn(5).setPreferredWidth(120);
		tableResultadosTarjetas.getColumnModel().getColumn(6).setPreferredWidth(112);
		scrollPaneForTableTarjetas.setViewportView(tableResultadosTarjetas);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup().addContainerGap()
						.addComponent(scrollPaneForTableTarjetas, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
						.addGap(7)));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
						.addComponent(scrollPaneForTableTarjetas, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
						.addGap(4)));
		panel_8.setLayout(gl_panel_8);

		JButton btnExportarTodo = new JButton("Exportar todo");
		btnExportarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportar(false,false,false,true);
			}
		});

		JButton btnExportarTarjetas = new JButton("Exportar");
		btnExportarTarjetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportar(false,false,true,false);
			}
		});

		btnBorrarTarjetas = new JButton("Borrar");
		btnBorrarTarjetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableResultadosTarjetas.setRowSelectionAllowed(false);
				tableResultadosTarjetas.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Numero", "Fecha caducidad", "Proveedor", "Tipo", "Limite extraccion", "Fecha expedicion", "Cuenta vinculada"
						}
					) {
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					tableResultadosTarjetas.getColumnModel().getColumn(0).setPreferredWidth(66);
					tableResultadosTarjetas.getColumnModel().getColumn(1).setPreferredWidth(125);
					tableResultadosTarjetas.getColumnModel().getColumn(3).setPreferredWidth(64);
					tableResultadosTarjetas.getColumnModel().getColumn(4).setPreferredWidth(114);
					tableResultadosTarjetas.getColumnModel().getColumn(5).setPreferredWidth(120);
					tableResultadosTarjetas.getColumnModel().getColumn(6).setPreferredWidth(112);
			}
		});

		JButton buttonExportarCuentas = new JButton("Exportar");
		buttonExportarCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportar(false,true,false,false);
			}
		});

		btnBorrarCuentas = new JButton("Borrar");
		btnBorrarCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableResultadosCuentas.setRowSelectionAllowed(false);
				tableResultadosCuentas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"IBAN", "SWIFT", "Fecha apertura", "Activa", "Saldo actual", "Interes", "DNI titular", "Tarjeta vinculada"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				tableResultadosCuentas.getColumnModel().getColumn(0).setPreferredWidth(59);
				tableResultadosCuentas.getColumnModel().getColumn(1).setPreferredWidth(57);
				tableResultadosCuentas.getColumnModel().getColumn(2).setPreferredWidth(111);
				tableResultadosCuentas.getColumnModel().getColumn(3).setPreferredWidth(63);
				tableResultadosCuentas.getColumnModel().getColumn(4).setPreferredWidth(100);
				tableResultadosCuentas.getColumnModel().getColumn(5).setPreferredWidth(63);
				tableResultadosCuentas.getColumnModel().getColumn(6).setPreferredWidth(79);
				tableResultadosCuentas.getColumnModel().getColumn(7).setPreferredWidth(120);
			}
		});

		JButton buttonExportarClientes = new JButton("Exportar");
		buttonExportarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportar(true,false,false,false);
			}
		});

		btnBorrarClientes = new JButton("Borrar");
		btnBorrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableResultadosClientes.setRowSelectionAllowed(false);
				tableResultadosClientes.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"DNI", "Nombre", "Apellidos", "Direccion", "Email", "Movil", "Empleado"
						}
					) {
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnExportarTodo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
								.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
								.addComponent(panel_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))))
					.addGap(18)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnBorrarTarjetas, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addComponent(btnBorrarCuentas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonExportarCuentas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnExportarTarjetas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
							.addComponent(buttonExportarClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBorrarClientes, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(57)
							.addComponent(buttonExportarClientes)
							.addGap(18)
							.addComponent(btnBorrarClientes)
							.addGap(96)
							.addComponent(buttonExportarCuentas)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(btnBorrarCuentas)
							.addGap(85)
							.addComponent(btnExportarTarjetas)
							.addGap(18)
							.addComponent(btnBorrarTarjetas)
							.addGap(44)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExportarTodo, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
		);

		JScrollPane scrollPaneForTableClientes = new JScrollPane();
		tableResultadosClientes = new JTable();
		tableResultadosClientes.setRowSelectionAllowed(false);
		tableResultadosClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellidos", "Direccion", "Email", "Movil", "Empleado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPaneForTableClientes.setViewportView(tableResultadosClientes);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addContainerGap()
						.addComponent(scrollPaneForTableClientes, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
						.addComponent(scrollPaneForTableClientes, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addContainerGap()));
		panel_6.setLayout(gl_panel_6);
		panel_5.setLayout(gl_panel_5);
		panel_resultado.setLayout(gl_panel_resultado);
		panel_exportar.setLayout(gl_panel_exportar);
		contentPane.setLayout(gl_contentPane);
	}

	public void setSOAPservice(DeustoBankServiceStub sOAPservice) {
		SOAPservice = sOAPservice;
	}
	
	private void exportar(boolean clientes, boolean cuentas, boolean tarjetas, boolean todo) {
		Banco b = new Banco();
		
		if(clientes || todo) {
			// Añadimos la lista de clientes a nuestra clase Banco que sera la que luego serialicemos como XML
			b.setListaClientes((ArrayList<Cliente>) Arrays.asList(tempClientes));
		}
		if (cuentas || todo) {
			// Añadimos la lista de cuentas a nuestra clase Banco que sera la que luego serialicemos como XML
			b.setListaCuentas((ArrayList<Cuenta>) Arrays.asList(tempCuentas));
		}
		if (tarjetas || todo) {
			// Añadimos la lista de tarjetas a nuestra clase Banco que sera la que luego serialicemos como XML
			b.setListaTarjetas((ArrayList<Tarjeta>) Arrays.asList(tempTarjetas));
		}
		
		// Creamos el objeto JFileChooser
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Guardar archivo xml...");  
		int seleccion = fc.showOpenDialog(contentPane);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			JAXBContext context;
			try {
				context = JAXBContext.newInstance(Banco.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(b, fichero);
				System.out.println("[Mainwindow] Marshal realizado satisfactoriamente! :)");
			} catch (JAXBException e) {
				System.out.println("[Mainwindow] Error al hacer el marshal en el metodod 'exportar'");
				e.printStackTrace();
			}
		}
	}

	public void setTempClientes(Cliente[] tempClientes) {
		this.tempClientes = tempClientes;
	}

	public void setTempCuentas(Cuenta[] tempCuentas) {
		this.tempCuentas = tempCuentas;
	}

	public void setTempTarjetas(Tarjeta[] tempTarjetas) {
		this.tempTarjetas = tempTarjetas;
	}
	
	public void loadClientes() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Cliente c : tempClientes) {
			model.addRow(new Object[]{c.getDNI(), c.getNombre(),c.getApellidos(),c.getDireccion(),c.getEmail(),c.getMovil(),(c.isEmpleado()) ? "Si" : "No"});
		}
	}
	
	public void loadCuentas() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		for (Cuenta cu : tempCuentas) {
			model.addRow(new Object[]{cu.getIBAN(),cu.getSWIFT(),cu.getFechaApertura(),(cu.isActiva())?"Si":"No",cu.getSaldoActual(),cu.getInteres(),cu.getTitular()});
		}
	}
	
	public void loadTarjetas() {
		DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		for (Tarjeta t: tempTarjetas) {
			model.addRow(new Object[]{t.getNumero(),t.getLimiteExtraccion(),t.getFechaCaducidad(),t.getProveedor(),t.getTipo(),t.getFechaExpedicion(),t.getCuenta()});
		}
	}
}
