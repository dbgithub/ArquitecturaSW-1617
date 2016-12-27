package es.deusto.arquiSW.REST.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import es.deusto.arquiSW.REST.Controller.Controller;
import es.deusto.arquiSW.REST.DTO.CuentaDTO;
import es.deusto.arquiSW.REST.DTO.TarjetaDTO;

public class FormularioDatosTarjetas {

	private JFrame frame;
	private JTextField textFieldNumero;
	private JTextField textFieldLimite;
	private JFormattedTextField textFieldFechaCaducidad;
	private JFormattedTextField textFieldFechaExpedicion;
	private Controller controlador;
	private JComboBox<String> comboBoxTipo;
	private JComboBox<Integer> comboBoxCuenta;
	private JComboBox<String> comboBoxProveedor;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FormularioDatosTarjetas window = new FormularioDatosTarjetas();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	/**
	 * @wbp.parser.entryPoint
	 */
	public FormularioDatosTarjetas() {
		initialize();
		frame.setTitle("A�adir tarjetas");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogbutton = JOptionPane.showConfirmDialog(null,
						"�Desea a�adir realmente la tarjeta especificado ?", "Confirmaci�n", JOptionPane.YES_NO_OPTION);
				if (dialogbutton == JOptionPane.YES_OPTION) {
					String numero = textFieldNumero.getText();
					String limite = textFieldLimite.getText();
					String fechaca = textFieldFechaCaducidad.getText();
					String fechaex = textFieldFechaExpedicion.getText();
					Object oprovee = comboBoxProveedor.getSelectedItem();
					String prov = String.valueOf(oprovee);
					Object otipo = comboBoxTipo.getSelectedItem();
					String tipo = String.valueOf(otipo);
					Object ocuenta = comboBoxCuenta.getSelectedItem();
					String cuenta = String.valueOf(ocuenta);
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date dateca;
					Date dateex;
					try {
						dateca = format.parse(fechaca);
						dateex = format.parse(fechaex);
						TarjetaDTO tar = new TarjetaDTO(Integer.parseInt(numero), Integer.parseInt(cuenta),
								Integer.parseInt(limite), dateca, prov, tipo, dateex);
						controlador.crearTarjeta(tar);
						controlador.obtenerTarjetas();
						
						setVisible(false);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

	}

	public FormularioDatosTarjetas(Controller co) {
		initialize();
		this.controlador = co;
		frame.setTitle("Modificar tarjetas");
		TarjetaDTO tar = this.controlador.getColeccionTarjetas().get(0);
		textFieldLimite.setText(Integer.toString(tar.getLimiteExtraccion()));
		textFieldNumero.setText(Integer.toString(tar.getNumero()));
		for (int i = 0; i < comboBoxProveedor.getItemCount(); i++) {
			if (comboBoxProveedor.getItemAt(i).equals(tar.getProveedor())) {
				comboBoxProveedor.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < comboBoxCuenta.getItemCount(); i++) {
			if (comboBoxCuenta.getItemAt(i) == (tar.getCuenta())) {
				comboBoxCuenta.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < comboBoxTipo.getItemCount(); i++) {
			if (comboBoxTipo.getItemAt(i).equals(tar.getTipo())) {
				comboBoxTipo.setSelectedIndex(i);
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		textFieldFechaCaducidad.setValue(sdf.format(tar.getFechaCaducidad()));
		textFieldFechaExpedicion.setValue(sdf.format(tar.getFechaExpedicion()));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogbutton = JOptionPane.showConfirmDialog(null, "�Desea modificar realmente la tarjeta?",
						"Confirmaci�n", JOptionPane.YES_NO_OPTION);
				if (dialogbutton == JOptionPane.YES_OPTION) {
					String numero = textFieldNumero.getText();
					String limite = textFieldLimite.getText();
					String fechaca = textFieldFechaCaducidad.getText();
					String fechaex = textFieldFechaExpedicion.getText();
					Object oprovee = comboBoxProveedor.getSelectedItem();
					String prov = String.valueOf(oprovee);
					Object otipo = comboBoxTipo.getSelectedItem();
					String tipo = String.valueOf(otipo);
					Object ocuenta = comboBoxCuenta.getSelectedItem();
					String cuenta = String.valueOf(ocuenta);
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date dateca;
					Date dateex;
					try {
						dateca = format.parse(fechaca);
						dateex = format.parse(fechaex);
						TarjetaDTO tarjeta = new TarjetaDTO(Integer.parseInt(numero), Integer.parseInt(cuenta),
								Integer.parseInt(limite), dateca, prov, tipo, dateex);
						controlador.modificarTarjeta(tarjeta);
						controlador.obtenerTarjetas();
						setVisible(false);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(b);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 296);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground((Color) null);

		JLabel label = new JLabel("Proveedor");
		label.setForeground(Color.BLACK);

		JLabel label_1 = new JLabel("Numero");
		label_1.setForeground(Color.BLACK);

		comboBoxProveedor = new JComboBox<String>();
		comboBoxProveedor.addItem("Visa");
		comboBoxProveedor.addItem("Mastercard");
		comboBoxProveedor.addItem("AmericanExpress");

		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);

		JLabel label_3 = new JLabel("Tipo");
		label_3.setForeground(Color.BLACK);

		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.addItem("Credito");
		comboBoxTipo.addItem("Debito");
		this.controlador = new Controller();
		comboBoxCuenta = new JComboBox<Integer>();
		this.controlador.obtenerCuentas();
		for (CuentaDTO cu : controlador.getColeccionCuentas()) {
			comboBoxCuenta.addItem(cu.getIBAN());
		}

		btnGuardar = new JButton("Guardar");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		JLabel lblLmiteExtraccion = new JLabel("L\u00EDmite extraccion");

		textFieldLimite = new JTextField();
		textFieldLimite.setColumns(10);

		JLabel lblFechaCaducidad = new JLabel("Fecha caducidad");
		MaskFormatter mf1;
		try {
			mf1 = new MaskFormatter("##/##/####");
			mf1.setPlaceholderCharacter('_');
			textFieldFechaCaducidad = new JFormattedTextField(mf1);
			textFieldFechaCaducidad.setColumns(10);

			JLabel lblFechaExpedicin = new JLabel("Fecha expedici\u00F3n");

			textFieldFechaExpedicion = new JFormattedTextField(mf1);
			textFieldFechaExpedicion.setColumns(10);

			JLabel lblCuente = new JLabel("Cuenta");

			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
					Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
							.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
									.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
											.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(label).addComponent(label_1))
											.addGap(18).addGroup(gl_panel
													.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
															.addComponent(textFieldNumero, Alignment.LEADING,
																	GroupLayout.PREFERRED_SIZE, 147,
																	GroupLayout.PREFERRED_SIZE)
															.addGroup(gl_panel
																	.createParallelGroup(Alignment.LEADING, false)
																	.addComponent(textFieldLimite, Alignment.TRAILING)
																	.addComponent(textFieldFechaExpedicion,
																			Alignment.TRAILING,
																			GroupLayout.DEFAULT_SIZE,
																			113, Short.MAX_VALUE)))
													.addComponent(comboBoxProveedor, 0, 151, Short.MAX_VALUE)))
									.addGroup(gl_panel.createSequentialGroup().addComponent(lblFechaExpedicin)
											.addGap(128)))
							.addGroup(gl_panel.createSequentialGroup().addComponent(lblLmiteExtraccion).addGap(139)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup().addGap(10)
											.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 105,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCancelar,
													GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup().addGap(18).addGroup(gl_panel
											.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup().addComponent(label_3).addGap(64)
													.addComponent(comboBoxTipo, 0, 128, Short.MAX_VALUE))
											.addGroup(gl_panel.createSequentialGroup()
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
															.addComponent(lblFechaCaducidad).addComponent(lblCuente))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
															.addComponent(textFieldFechaCaducidad,
																	GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
															.addComponent(comboBoxCuenta, 0, 128, Short.MAX_VALUE))))))
							.addGap(40)));
			gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup().addGap(35).addGroup(gl_panel
									.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
											.createSequentialGroup()
											.addGroup(gl_panel
													.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
															.createSequentialGroup().addGroup(gl_panel
																	.createParallelGroup(Alignment.BASELINE)
																	.addComponent(label_1).addComponent(textFieldNumero,
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.DEFAULT_SIZE,
																			GroupLayout.PREFERRED_SIZE))
															.addGap(18).addComponent(label))
													.addGroup(gl_panel.createSequentialGroup().addGap(38).addComponent(
															comboBoxProveedor, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(lblLmiteExtraccion).addComponent(textFieldLimite,
															GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(lblFechaExpedicin)
													.addComponent(textFieldFechaExpedicion, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_3).addComponent(comboBoxTipo,
															GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(lblFechaCaducidad)
													.addComponent(textFieldFechaCaducidad, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(lblCuente).addComponent(comboBoxCuenta,
															GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 38,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 38,
													GroupLayout.PREFERRED_SIZE))
									.addContainerGap(16, Short.MAX_VALUE)));
			panel.setLayout(gl_panel);
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE)));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(80, Short.MAX_VALUE)));
			frame.getContentPane().setLayout(groupLayout);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
