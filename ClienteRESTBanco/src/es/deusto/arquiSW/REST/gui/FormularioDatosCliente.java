package es.deusto.arquiSW.REST.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import es.deusto.arquiSW.REST.Controller.Controller;
import es.deusto.arquiSW.REST.DTO.ClienteDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioDatosCliente {

	private JFrame frmAniadir;
	private JTextField textFieldEmail;
	private JTextField textFieldMovil;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private Controller controller;
	private JTextField textFieldDireccion;
	private JTextField textFieldPIN;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FormularioDatos window = new FormularioDatos();
	// window.frmAadir.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */

	public FormularioDatosCliente() {
		initialize();
		this.controller = new Controller();
	}

	public void setVisible(boolean b) {
		this.frmAniadir.setVisible(b);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmAniadir = new JFrame();
		frmAniadir.setTitle("A\u00F1adir clientes");
		frmAniadir.setBounds(100, 100, 511, 361);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground((Color) null);

		JLabel label = new JLabel("Email");
		label.setForeground(Color.BLACK);

		JLabel label_1 = new JLabel("DNI");
		label_1.setForeground(Color.BLACK);

		JLabel label_2 = new JLabel("M\u00F3vil");
		label_2.setForeground(Color.BLACK);

		JLabel label_3 = new JLabel("Apellidos");
		label_3.setForeground(Color.BLACK);

		JLabel label_4 = new JLabel("Nombre");
		label_4.setForeground(Color.BLACK);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);

		textFieldMovil = new JTextField();
		textFieldMovil.setColumns(10);

		JCheckBox checkBox = new JCheckBox("Empleado");
		checkBox.setForeground(Color.BLACK);
		checkBox.setBackground((Color) null);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int dialogbutton = JOptionPane.showConfirmDialog(null,
						"¿Desea añadir realmente el cliente especificado ?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (dialogbutton == JOptionPane.YES_OPTION) {
					String dni = textFieldDNI.getText();
					String nombre = textFieldNombre.getText();
					String apellidos = textFieldApellidos.getText();
					String direccion = textFieldDireccion.getText();
					String correo = textFieldEmail.getText();
					int movil = Integer.valueOf(textFieldMovil.getText());
					boolean empleado = checkBox.isSelected();
					int pin = Integer.valueOf(textFieldPIN.getText());
					ClienteDTO c = new ClienteDTO(dni, nombre, apellidos, direccion, correo, movil, empleado, pin);
					controller.crearCliente(c);
					setVisible(false);

				}

			}
		});

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");

		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);

		JLabel lblPin = new JLabel("PIN");

		textFieldPIN = new JTextField();
		textFieldPIN.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(
						Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
										.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(label_1).addComponent(label_3).addComponent(label_4))
										.addGap(21)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(textFieldDNI, GroupLayout.DEFAULT_SIZE, 168,
																Short.MAX_VALUE)
														.addGap(199))
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(textFieldApellidos, Alignment.LEADING)
														.addComponent(textFieldNombre, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)))
										.addGap(25)).addGroup(
												gl_panel.createSequentialGroup()
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblDireccin).addComponent(label_2)
																.addComponent(label).addComponent(lblPin))
														.addGap(20)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel.createSequentialGroup()
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(textFieldEmail,
																						GroupLayout.DEFAULT_SIZE, 236,
																						Short.MAX_VALUE)
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addComponent(textFieldPIN,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED))
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addComponent(
																								textFieldMovil,
																								GroupLayout.PREFERRED_SIZE,
																								183,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)))
																		.addGroup(gl_panel.createSequentialGroup()
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(checkBox,
																						GroupLayout.DEFAULT_SIZE, 131,
																						Short.MAX_VALUE)))
																.addComponent(textFieldDireccion,
																		GroupLayout.PREFERRED_SIZE, 365,
																		GroupLayout.PREFERRED_SIZE))
														.addContainerGap()))
								.addGroup(Alignment.TRAILING,
										gl_panel.createSequentialGroup()
												.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 101,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 104,
														GroupLayout.PREFERRED_SIZE)
												.addGap(29)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
								textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(31)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_4)
										.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_3).addComponent(
						textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDireccin).addComponent(
						textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox).addComponent(label_2))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPin).addComponent(
						textFieldPIN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(63, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frmAniadir.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(119, Short.MAX_VALUE)));
		frmAniadir.getContentPane().setLayout(groupLayout);
	}
}
