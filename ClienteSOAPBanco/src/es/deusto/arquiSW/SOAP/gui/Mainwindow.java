package es.deusto.arquiSW.SOAP.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Mainwindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldMovil;
	private JTextField textFieldIBAN;
	private JTextField textFieldDNICliente;
	private JTextField textFieldFechaApertura;

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
		setTitle("DeustoBank(SOAP)");
		setMinimumSize(new Dimension(600, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("DeustoBank (SOAP)");
		lblTitle.setFont(new Font("Khmer OS System", Font.BOLD, 23));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(111)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(101))
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
		);
		
		JPanel panel_importar = new JPanel();
		panel_importar.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane.addTab("Importar", null, panel_importar, null);
		GroupLayout gl_panel_importar = new GroupLayout(panel_importar);
		gl_panel_importar.setHorizontalGroup(
			gl_panel_importar.createParallelGroup(Alignment.LEADING)
				.addGap(0, 585, Short.MAX_VALUE)
		);
		gl_panel_importar.setVerticalGroup(
			gl_panel_importar.createParallelGroup(Alignment.LEADING)
				.addGap(0, 377, Short.MAX_VALUE)
		);
		panel_importar.setLayout(gl_panel_importar);
		
		JPanel panel_exportar = new JPanel();
		panel_exportar.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane.addTab("Exportar", null, panel_exportar, null);
		
		JTabbedPane tabbedPane_inside = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_exportar = new GroupLayout(panel_exportar);
		gl_panel_exportar.setHorizontalGroup(
			gl_panel_exportar.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_inside, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
		);
		gl_panel_exportar.setVerticalGroup(
			gl_panel_exportar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_exportar.createSequentialGroup()
					.addGap(24)
					.addComponent(tabbedPane_inside, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
		);
		
		JPanel panel_clientes = new JPanel();
		panel_clientes.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("Clientes", null, panel_clientes, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_clientes = new GroupLayout(panel_clientes);
		gl_panel_clientes.setHorizontalGroup(
			gl_panel_clientes.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
		);
		gl_panel_clientes.setVerticalGroup(
			gl_panel_clientes.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JPanel filterpane = new JPanel();
		filterpane.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		filterpane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"col4", "col3", "col2", "col1"
			}
		));
		table.setRowSelectionAllowed(false);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblDNI = new JLabel("DNI");
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lbMovil = new JLabel("M\u00F3vil");
		
		textFieldMovil = new JTextField();
		textFieldMovil.setColumns(10);
		
		JCheckBox chckbxEmpleado = new JCheckBox("Empleado");
		GroupLayout gl_filterpane = new GroupLayout(filterpane);
		gl_filterpane.setHorizontalGroup(
			gl_filterpane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_filterpane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_filterpane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEmail)
						.addComponent(lblDNI)
						.addComponent(lbMovil)
						.addComponent(lblApellidos)
						.addComponent(lblNombre))
					.addGap(21)
					.addGroup(gl_filterpane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_filterpane.createSequentialGroup()
							.addGroup(gl_filterpane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_filterpane.createSequentialGroup()
									.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
									.addGap(29))
								.addGroup(gl_filterpane.createSequentialGroup()
									.addComponent(textFieldMovil, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
									.addGap(61)
									.addComponent(chckbxEmpleado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(90)
							.addComponent(btnAplicar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_filterpane.createSequentialGroup()
							.addComponent(textFieldDNI, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
							.addGap(258))
						.addGroup(gl_filterpane.createSequentialGroup()
							.addGroup(gl_filterpane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
								.addComponent(textFieldApellidos, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
							.addGap(45)))
					.addContainerGap())
		);
		gl_filterpane.setVerticalGroup(
			gl_filterpane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_filterpane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_filterpane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_filterpane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDNI)
							.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_filterpane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_filterpane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_filterpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_filterpane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_filterpane.createSequentialGroup()
							.addGroup(gl_filterpane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_filterpane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbMovil)
								.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxEmpleado)))
						.addComponent(btnAplicar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		filterpane.setLayout(gl_filterpane);
		
		JButton btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(filterpane, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(696)
							.addComponent(btnAniadir, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(16)
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(296))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(filterpane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAniadir, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(66))
		);
		panel.setLayout(gl_panel);
		panel_clientes.setLayout(gl_panel_clientes);
		
		JPanel panel_cuentas = new JPanel();
		panel_cuentas.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("Cuentas", null, panel_cuentas, null);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_cuentas = new GroupLayout(panel_cuentas);
		gl_panel_cuentas.setHorizontalGroup(
			gl_panel_cuentas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
		);
		gl_panel_cuentas.setVerticalGroup(
			gl_panel_cuentas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
		);
		
		JPanel panel2 = new JPanel();
		scrollPane2.setViewportView(panel2);
		
		JPanel filterpane2 = new JPanel();
		filterpane2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		filterpane2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"col4", "col3", "col2", "col1"
			}
		));
		table_1.setRowSelectionAllowed(false);
		
		JLabel lblIban = new JLabel("IBAN");
		
		textFieldIBAN = new JTextField();
		textFieldIBAN.setColumns(10);
		
		JLabel lblDniCliente = new JLabel("DNI Cliente");
		
		textFieldDNICliente = new JTextField();
		textFieldDNICliente.setColumns(10);
		
		JLabel lblFechaApertura = new JLabel("Fecha Apertura");
		
		textFieldFechaApertura = new JTextField();
		textFieldFechaApertura.setColumns(10);
		
		JCheckBox chckbxActiva = new JCheckBox("Activa");
		
		JLabel lblInters = new JLabel("Inter\u00E9s");
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnAplicarCuentas = new JButton("Aplicar");

		GroupLayout gl_filterpane2 = new GroupLayout(filterpane2);
		gl_filterpane2.setHorizontalGroup(
			gl_filterpane2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_filterpane2.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaApertura)
						.addComponent(lblIban)
						.addComponent(lblDniCliente)
						.addComponent(lblInters))
					.addGap(58)
					.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldFechaApertura, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addGroup(gl_filterpane2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldIBAN, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
						.addComponent(textFieldDNICliente, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addGroup(gl_filterpane2.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(chckbxActiva)))
					.addGap(18)
					.addComponent(btnAplicarCuentas, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_filterpane2.setVerticalGroup(
			gl_filterpane2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_filterpane2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_filterpane2.createSequentialGroup()
							.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIban)
								.addComponent(textFieldIBAN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDniCliente)
								.addComponent(textFieldDNICliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaApertura)
								.addComponent(textFieldFechaApertura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_filterpane2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_filterpane2.createSequentialGroup()
									.addGroup(gl_filterpane2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblInters)
										.addComponent(comboBox))
									.addGap(3))
								.addComponent(chckbxActiva))
							.addGap(7))
						.addGroup(Alignment.TRAILING, gl_filterpane2.createSequentialGroup()
							.addComponent(btnAplicarCuentas, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		filterpane2.setLayout(gl_filterpane2);
		
		JButton btnAniadirCuentas = new JButton("A\u00F1adir");
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
					.addGap(35)
					.addComponent(filterpane2, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
					.addGap(50))
				.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 808, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap(699, Short.MAX_VALUE)
					.addComponent(btnAniadirCuentas, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGap(19)
					.addComponent(filterpane2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAniadirCuentas, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		panel2.setLayout(gl_panel2);
		panel_cuentas.setLayout(gl_panel_cuentas);
		
		JPanel panel_tarjetas = new JPanel();
		panel_tarjetas.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("Tarjetas", null, panel_tarjetas, null);
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_tarjetas = new GroupLayout(panel_tarjetas);
		gl_panel_tarjetas.setHorizontalGroup(
			gl_panel_tarjetas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
		);
		gl_panel_tarjetas.setVerticalGroup(
			gl_panel_tarjetas.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
		);
		
		JPanel panel3 = new JPanel();
		scrollPane3.setViewportView(panel3);
		
		JPanel filterpane3 = new JPanel();
		filterpane3.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		filterpane3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"col4", "col3", "col2", "col1"
			}
		));
		table.setRowSelectionAllowed(false);

		GroupLayout gl_filterpane3 = new GroupLayout(filterpane3);
		gl_filterpane3.setHorizontalGroup(
			gl_filterpane3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 10, Short.MAX_VALUE)
		);
		gl_filterpane3.setVerticalGroup(
			gl_filterpane3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 10, Short.MAX_VALUE)
		);
		filterpane3.setLayout(gl_filterpane3);
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(26)
					.addComponent(filterpane3, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(12)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(5)
					.addComponent(filterpane3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
		);
		panel3.setLayout(gl_panel3);
		panel_tarjetas.setLayout(gl_panel_tarjetas);
		
		JPanel panel_resultado = new JPanel();
		panel_resultado.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane_inside.addTab("RESULTADO", null, panel_resultado, null);
		GroupLayout gl_panel_resultado = new GroupLayout(panel_resultado);
		gl_panel_resultado.setHorizontalGroup(
			gl_panel_resultado.createParallelGroup(Alignment.LEADING)
				.addGap(0, 580, Short.MAX_VALUE)
		);
		gl_panel_resultado.setVerticalGroup(
			gl_panel_resultado.createParallelGroup(Alignment.LEADING)
				.addGap(0, 326, Short.MAX_VALUE)
		);
		panel_resultado.setLayout(gl_panel_resultado);
		panel_exportar.setLayout(gl_panel_exportar);
		contentPane.setLayout(gl_contentPane);
	}
}
