package es.deusto.arquiSW.REST.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import es.deusto.arquiSW.REST.Controller.Controller;
import es.deusto.arquiSW.REST.DTO.ClienteDTO;
import es.deusto.arquiSW.REST.DTO.CuentaDTO;
import es.deusto.arquiSW.REST.DTO.TarjetaDTO;

public class MainWindow {

	private JFrame frmDeustobankrest;
	private JTextField textField_DNI;
	private JTable tableClientes;
	private JTextField textField_IBAN;
	private JTable tableCuentas;
	private JTextField textField_NumeroTarjeta;
	private JTable tableTarjetas;
	private Controller controller;
	private FormularioDatosCliente formCliente;
	private FormularioDatosCuentas formCuentas;
	private FormularioDatosTarjetas formTarjetas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmDeustobankrest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		// PRUEBAS:

		// Cargamos todos clientes
		this.controller.obtenerClientes();
		if (controller.getColeccionClientes().size() > 0) {
			loadClientes();
		}
		this.controller.obtenerCuentas();
		if (controller.getColeccionCuentas().size() > 0) {
			loadCuentas();
		}
		this.controller.obtenerTarjetas();
		if (controller.getColeccionTarjetas().size() > 0) {
			loadTarjetas();
		}

		// this.controller.obtenerCliente("8656565"); // FUNCIONA!
		// this.controller.obtenerCuenta("454545"); // FALLA
		// this.controller.obtenerTarjeta("555556"); // FUNCIONA!
		// this.controller.crearCliente(new ClienteDTO("123456789","PRUEBA
		// NOMBRE","PRUEBA APELLIDOS","PRUEBA
		// DIR","prueba@gmail.prueba",79797979,true,5665)); // FUNCIONA!
		// this.controller.modificarCliente(new
		// ClienteDTO("123456789","PRUEBA","PRUEBA","PRUEBA","prueba@gmail.prueba",97979797,false,6556));
		// // FUNCIONA!
		// this.controller.eliminarCiente("123456789"); // FUNCIONA!
		// this.controller.crearCuenta(new CuentaDTO(62811149, "SWIF-XXC", new
		// Date(System.currentTimeMillis()), true, 10587f, 0.1f, "123456789",
		// null)); // FALLA ?
		// this.controller.modificarCuenta(new CuentaDTO(94111826, "SW-56TT",
		// new Date(System.currentTimeMillis()), false, 100f, 0.15f,
		// "123456789", null)); // FALLA ?
		// this.controller.eliminarCuenta(String.valueOf(94111826)); // FALLA ?
		// this.controller.crearTarjeta(new TarjetaDTO(3333336,454545,3000, new
		// Date(System.currentTimeMillis()+100000),EnumProveedores.Mastercard,TiposTarjeta.Credito,new
		// Date(System.currentTimeMillis()))); // FUNCIONA!
		// this.controller.modificarTarjeta(new TarjetaDTO(3333336,454545,1500,
		// new
		// Date(System.currentTimeMillis()+200000),EnumProveedores.Mastercard,TiposTarjeta.Debito,new
		// Date(System.currentTimeMillis()))); // FUNCIONA!
		// this.controller.eliminarTarjeta(String.valueOf(3333336)); //
		// FUNCIONA!
		// this.controller.probarhola(); // FUNCIONA!
	}

	public void loadClientes() {
		DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
		limpiarJTable(model);
		if (controller.getColeccionClientes() != null) {
			for (ClienteDTO c : controller.getColeccionClientes()) {
				model.addRow(new Object[] { c.getDNI(), c.getNombre(), c.getApellidos(), c.getDireccion(), c.getEmail(),
						c.getMovil(), (c.isEmpleado()) ? "Si" : "No" });
			}
		}
	}

	public void loadCuentas() {
		DefaultTableModel model = (DefaultTableModel) tableCuentas.getModel();
		limpiarJTable(model);
		if (controller.getColeccionCuentas() != null) {
			for (CuentaDTO cu : controller.getColeccionCuentas()) {
				DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				model.addRow(new Object[] { cu.getIBAN(), cu.getSWIFT(), formatoFecha.format(cu.getFechaApertura()),
						(cu.isActiva()) ? "Si" : "No", cu.getSaldoActual(), cu.getInteres(), cu.getTitular() });
			}
		}
	}

	public void loadTarjetas() {
		DefaultTableModel model = (DefaultTableModel) tableTarjetas.getModel();
		limpiarJTable(model);
		if (controller.getColeccionTarjetas() != null) {
			for (TarjetaDTO t : controller.getColeccionTarjetas()) {
				DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				model.addRow(new Object[] { t.getNumero(), t.getLimiteExtraccion(),
						formatoFecha.format(t.getFechaCaducidad()), t.getProveedor(), t.getTipo(),
						formatoFecha.format(t.getFechaExpedicion()), t.getCuenta() });
			}
		}
	}

	private void limpiarJTable(DefaultTableModel model) {
		int rowCount = model.getRowCount();

		for (int j = rowCount - 1; j >= 0; j--) {
			model.removeRow(j);
		}

	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = new Controller();
		frmDeustobankrest = new JFrame();
		frmDeustobankrest.setTitle("DeustoBank(REST)");
		frmDeustobankrest.setBounds(100, 100, 837, 610);
		frmDeustobankrest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frmDeustobankrest.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				loadClientes();
				loadCuentas();
				loadTarjetas();
			}
		});
		JLabel lblDeustobankrest = new JLabel("DeustoBank (REST)");
		lblDeustobankrest.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeustobankrest.setFont(new Font("Dialog", Font.BOLD, 23));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tabbedPane.getSelectedIndex()) {

				// Eliminacion de clientes
				case 0:
					Object o = tableClientes.getValueAt(tableClientes.getSelectedRow(), 0);
					if (o instanceof String) {
						String dni = (String) o;
						int dialogbutton = JOptionPane.showConfirmDialog(null,
								"¿Desea eliminar realmente el cliente con DNI " + dni + " ?", "Eliminar cliente",
								JOptionPane.YES_NO_OPTION);
						if (dialogbutton == JOptionPane.YES_OPTION) {
							controller.eliminarCliente(dni);
							textField_DNI.setText(null);
							controller.obtenerClientes();
							loadClientes();
						}

					}

					break;

				// Eliminacion de cuentas
				case 1:
					o = tableCuentas.getValueAt(tableCuentas.getSelectedRow(), 0);
					if (o instanceof Integer) {
						int iban = (Integer) o;
						int dialogbutton = JOptionPane.showConfirmDialog(null,
								"¿Desea eliminar realmente la cuenta con IBAN " + iban + " ?", "Eliminar cuenta",
								JOptionPane.YES_NO_OPTION);
						if (dialogbutton == JOptionPane.YES_OPTION) {
							controller.eliminarCuenta(String.valueOf(iban));
							textField_IBAN.setText(null);
							controller.obtenerCuentas();
							loadCuentas();
						}
					}
					break;

				// Eliminacion de tarjetas
				default:
					o = tableTarjetas.getValueAt(tableTarjetas.getSelectedRow(), 0);
					if (o instanceof Integer) {
						int numero = (Integer) o;
						int dialogbutton = JOptionPane.showConfirmDialog(null,
								"¿Desea eliminar realmente la tarjeta con numero " + numero + " ?", "Eliminar tarjeta",
								JOptionPane.YES_NO_OPTION);
						if (dialogbutton == JOptionPane.YES_OPTION) {
							controller.eliminarTarjeta(String.valueOf(numero));
							textField_NumeroTarjeta.setText(null);
							controller.obtenerTarjetas();
							loadTarjetas();
						}
					}
					break;
				}
			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// formCliente = new FormularioDatosCliente();
				// formCuentas = new FormularioDatosCuentas();
				// formTarjetas = new FormularioDatosTarjetas();
				Object o = null;
				switch (tabbedPane.getSelectedIndex()) {
				// Modificar clientes
				case 0:
					o = tableClientes.getValueAt(tableClientes.getSelectedRow(), 0);
					if (o instanceof String) {
						String dni = (String) o;
						controller.obtenerCliente(dni);
						formCliente = new FormularioDatosCliente(controller);
						formCliente.setVisible(true);

					}
					break;
				// Modificar Cuentas
				case 1:
					o = tableCuentas.getValueAt(tableCuentas.getSelectedRow(), 0);
					if (o instanceof Integer) {
						int iban = (Integer) o;
						controller.obtenerCuenta(Integer.toString(iban));
						formCuentas = new FormularioDatosCuentas(controller);
						formCuentas.setVisible(true);
					}

					break;

				// Modificar tarjetas
				default:
					o = tableTarjetas.getValueAt(tableTarjetas.getSelectedRow(), 0);
					if (o instanceof Integer) {
						int num = (Integer) o;
						controller.obtenerTarjeta(Integer.toString(num));	
						formTarjetas = new FormularioDatosTarjetas(controller);
						formTarjetas.setVisible(true);
					}
					break;
				}
			}
		});

		JButton btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formCliente = new FormularioDatosCliente();
				formCuentas = new FormularioDatosCuentas();
				formTarjetas = new FormularioDatosTarjetas();
				switch (tabbedPane.getSelectedIndex()) {

				// Annadir clientes
				case 0:
					formCliente.setVisible(true);

					break;

				// Annadir Cuentas
				case 1:
					formCuentas.setVisible(true);
					break;

				// Annadir tarjetas
				default:
					formTarjetas.setVisible(true);
					break;
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(frmDeustobankrest.getContentPane());
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap().addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addGap(10)
												.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 791,
														Short.MAX_VALUE)
												.addGap(10))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup()
												.addComponent(lblDeustobankrest, GroupLayout.DEFAULT_SIZE, 804,
														Short.MAX_VALUE)
												.addGap(7))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnAniadir, GroupLayout.PREFERRED_SIZE, 101,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE)
										.addGap(39)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(41)
						.addComponent(lblDeustobankrest, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAniadir, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGap(18)));

		JPanel panel_clientes = new JPanel();
		tabbedPane.addTab("Clientes", null, panel_clientes, null);

		JLabel lblDni = new JLabel("DNI");

		textField_DNI = new JTextField();
		textField_DNI.setColumns(10);

		JButton btnBuscarClientes = new JButton("Buscar");
		btnBuscarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField_DNI.getText().isEmpty()) {
					controller.obtenerCliente(textField_DNI.getText());
					loadClientes();
				} else {
					controller.obtenerClientes();
					loadClientes();
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_clientes = new GroupLayout(panel_clientes);
		gl_panel_clientes
				.setHorizontalGroup(gl_panel_clientes.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_clientes.createSequentialGroup().addGap(243).addComponent(lblDni).addGap(18)
								.addComponent(textField_DNI, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE).addGap(29)
								.addComponent(btnBuscarClientes, GroupLayout.PREFERRED_SIZE, 77,
										GroupLayout.PREFERRED_SIZE)
								.addGap(196))
						.addGroup(Alignment.LEADING,
								gl_panel_clientes.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
										.addContainerGap()));
		gl_panel_clientes.setVerticalGroup(gl_panel_clientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_clientes.createSequentialGroup().addGap(31)
						.addGroup(gl_panel_clientes.createParallelGroup(Alignment.BASELINE).addComponent(lblDni)
								.addComponent(textField_DNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscarClientes, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE).addContainerGap()));

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
								.addGap(20)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addGap(21)));

		tableClientes = new JTable();
		tableClientes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "DNI", "Nombre", "Apellidos", "Direccion", "Email", "Movil", "Empleado" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(tableClientes);
		panel.setLayout(gl_panel);
		panel_clientes.setLayout(gl_panel_clientes);

		JPanel panel_cuentas = new JPanel();
		tabbedPane.addTab("Cuentas", null, panel_cuentas, null);

		JLabel lblIban = new JLabel("IBAN");

		textField_IBAN = new JTextField();
		textField_IBAN.setColumns(10);

		JButton buttonBuscarCuentas = new JButton("Buscar");
		buttonBuscarCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField_IBAN.getText().isEmpty()) {
					controller.obtenerCuenta(textField_IBAN.getText());
					loadCuentas();
				} else {
					controller.obtenerCuentas();
					loadCuentas();
				}
			}
		});

		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_cuentas = new GroupLayout(panel_cuentas);
		gl_panel_cuentas.setHorizontalGroup(gl_panel_cuentas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cuentas.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel_cuentas.createSequentialGroup().addGap(182).addComponent(lblIban).addGap(18)
						.addComponent(textField_IBAN, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE).addGap(18)
						.addComponent(buttonBuscarCuentas, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addGap(188)));
		gl_panel_cuentas.setVerticalGroup(gl_panel_cuentas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cuentas.createSequentialGroup().addGap(29)
						.addGroup(gl_panel_cuentas.createParallelGroup(Alignment.BASELINE).addComponent(lblIban)
								.addComponent(textField_IBAN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonBuscarCuentas, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE).addContainerGap()));

		JPanel panel_1 = new JPanel();
		scrollPane_2.setViewportView(panel_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
								.addContainerGap()));

		tableCuentas = new JTable();
		tableCuentas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "IBAN", "SWIFT", "Fecha apertura",
				"Activa", "Saldo actual", "Interes", "DNI titular" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(tableCuentas);
		panel_1.setLayout(gl_panel_1);
		panel_cuentas.setLayout(gl_panel_cuentas);

		JPanel panel_tarjetas = new JPanel();
		tabbedPane.addTab("Tarjetas", null, panel_tarjetas, null);

		JLabel lblNewLabel = new JLabel("N\u00FAmero");

		textField_NumeroTarjeta = new JTextField();
		textField_NumeroTarjeta.setColumns(10);

		JButton buttonBuscarTarjetas = new JButton("Buscar");
		buttonBuscarTarjetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_NumeroTarjeta.getText().isEmpty()) {
					controller.obtenerTarjeta(textField_NumeroTarjeta.getText());
					loadTarjetas();
				} else {
					controller.obtenerTarjetas();
					loadTarjetas();
				}

			}
		});

		JScrollPane scrollPane_4 = new JScrollPane();
		GroupLayout gl_panel_tarjetas = new GroupLayout(panel_tarjetas);
		gl_panel_tarjetas
				.setHorizontalGroup(
						gl_panel_tarjetas.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_tarjetas.createSequentialGroup().addGap(189)
										.addComponent(lblNewLabel).addGap(18)
										.addComponent(textField_NumeroTarjeta, GroupLayout.DEFAULT_SIZE, 313,
												Short.MAX_VALUE)
										.addGap(18)
										.addComponent(buttonBuscarTarjetas, GroupLayout.PREFERRED_SIZE, 77,
												GroupLayout.PREFERRED_SIZE)
										.addGap(137))
								.addGroup(Alignment.LEADING,
										gl_panel_tarjetas
												.createSequentialGroup().addContainerGap().addComponent(scrollPane_4,
														GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
												.addContainerGap()));
		gl_panel_tarjetas.setVerticalGroup(gl_panel_tarjetas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tarjetas.createSequentialGroup().addGap(24)
						.addGroup(gl_panel_tarjetas.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_NumeroTarjeta, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel).addComponent(buttonBuscarTarjetas,
										GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGap(8).addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addContainerGap()));

		JPanel panel_2 = new JPanel();
		scrollPane_4.setViewportView(panel_2);

		JScrollPane scrollPane_5 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2
				.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panel_2.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_2
				.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panel_2.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addContainerGap()));

		tableTarjetas = new JTable();
		tableTarjetas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numero", "Limite extraccion",
				"Fecha caducidad", "Proveedor", "Tipo", "Fecha expedicion", "Cuenta vinculada" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_5.setViewportView(tableTarjetas);
		panel_2.setLayout(gl_panel_2);
		panel_tarjetas.setLayout(gl_panel_tarjetas);
		frmDeustobankrest.getContentPane().setLayout(gl_contentPane);
	}
}
