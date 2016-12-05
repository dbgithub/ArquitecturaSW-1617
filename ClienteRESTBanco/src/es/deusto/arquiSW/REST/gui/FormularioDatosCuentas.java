package es.deusto.arquiSW.REST.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import es.deusto.arquiSW.REST.DTO.ClienteDTO;
import es.deusto.arquiSW.REST.DTO.CuentaDTO;
import es.deusto.arquiSW.REST.DTO.OperacionDTO;

public class FormularioDatosCuentas {

	private JFrame frmAniadirCuenta;
	private JFormattedTextField textFieldFechaApetura;
	private JTextField textFieldIBAN;
	private Controller controlador;
	private JTextField textFieldSWIFT;
	private JTextField textFieldSaldo;
	private JCheckBox checkBoxActiva;
	private JComboBox<String> comboBoxInteres;
	private JComboBox<String> comboBoxDNI;
	private JButton buttonGuardar;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FormularioDatosCuentas window = new FormularioDatosCuentas();
	// window.frmAniadirCuenta.setVisible(true);
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
	public FormularioDatosCuentas() {
		initialize();
		frmAniadirCuenta.setTitle("Añadir cuentas");
		buttonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogbutton = JOptionPane.showConfirmDialog(null,
						"¿Desea añadir realmente la cuenta especificada ?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (dialogbutton == JOptionPane.YES_OPTION) {
					String IBAN = textFieldIBAN.getText();
					Object DNI = comboBoxDNI.getSelectedItem();
					String DNICliente = String.valueOf(DNI);
					String Fecha = textFieldFechaApetura.getText();
					String Saldo = textFieldSaldo.getText();
					String SWIFT = textFieldSWIFT.getText();
					boolean activa = checkBoxActiva.isSelected();
					Object o = comboBoxInteres.getSelectedItem();
					String interes = String.valueOf(o);
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date date;
					try {
						date = format.parse(Fecha);
						CuentaDTO cuenta = new CuentaDTO(Integer.parseInt(IBAN), SWIFT, date, activa,
								Float.parseFloat(Saldo), Float.parseFloat(interes), DNICliente,
								new ArrayList<OperacionDTO>());
						controlador.crearCuenta(cuenta);
						setVisible(false);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
	}

	public FormularioDatosCuentas(Controller co) {
		initialize();
		this.controlador = co;
		frmAniadirCuenta.setTitle("Modificar cuentas");
		CuentaDTO cu= this.controlador.getColeccionCuentas().get(0);
		textFieldIBAN.setText(Integer.toString(cu.getIBAN()));
		textFieldSWIFT.setText(cu.getSWIFT());
		textFieldSaldo.setText(Float.toString(cu.getSaldoActual()));
		if(cu.isActiva()){
			checkBoxActiva.setSelected(true);
		}
		for (int i = 0; i < comboBoxInteres.getItemCount(); i++) {
			if(comboBoxInteres.getItemAt(i).equals(Float.toString(cu.getInteres()))){
				comboBoxInteres.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < comboBoxDNI.getItemCount(); i++) {
			if(comboBoxDNI.getItemAt(i).equals(cu.getTitular())){
				comboBoxDNI.setSelectedIndex(i);
			}
		}
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		textFieldFechaApetura.setValue(sdf.format(cu.getFechaApertura()));
		buttonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogbutton = JOptionPane.showConfirmDialog(null,
						"¿Desea modificar realmente la cuenta?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (dialogbutton == JOptionPane.YES_OPTION) {
					String IBAN = textFieldIBAN.getText();
					Object DNI = comboBoxDNI.getSelectedItem();
					String DNICliente = String.valueOf(DNI);
					String Fecha = textFieldFechaApetura.getText();
					String Saldo = textFieldSaldo.getText();
					String SWIFT = textFieldSWIFT.getText();
					boolean activa = checkBoxActiva.isSelected();
					Object o = comboBoxInteres.getSelectedItem();
					String interes = String.valueOf(o);
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date date;
					try {
						date = format.parse(Fecha);
						CuentaDTO cuenta = new CuentaDTO(Integer.parseInt(IBAN), SWIFT, date, activa,
								Float.parseFloat(Saldo), Float.parseFloat(interes), DNICliente,
								new ArrayList<OperacionDTO>());
						controlador.modificarCuenta(cuenta);
						setVisible(false);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		
		
	}

	public void setVisible(boolean b) {
		this.frmAniadirCuenta.setVisible(b);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAniadirCuenta = new JFrame();
//		frmAniadirCuenta.setTitle("A\u00F1adir cuenta");
		frmAniadirCuenta.setBounds(100, 100, 565, 281);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground((Color) null);

		JLabel label = new JLabel("Fecha Apertura");
		label.setForeground(Color.BLACK);

		JLabel label_1 = new JLabel("IBAN");
		label_1.setForeground(Color.BLACK);

		JLabel label_2 = new JLabel("DNI Cliente");
		label_2.setForeground(Color.BLACK);

		JLabel label_3 = new JLabel("Inter\u00E9s");
		label_3.setForeground(Color.BLACK);

		try {
			MaskFormatter mf1 = new MaskFormatter("##/##/####");
			mf1.setPlaceholderCharacter('_');
			textFieldFechaApetura = new JFormattedTextField(mf1);
			textFieldFechaApetura.setColumns(10);

			textFieldIBAN = new JTextField();
			textFieldIBAN.setColumns(10);

			comboBoxInteres = new JComboBox<String>();
			comboBoxInteres.addItem("0.01");
			comboBoxInteres.addItem("0.02");
			comboBoxInteres.addItem("0.06");

			comboBoxDNI = new JComboBox<String>();
			this.controlador = new Controller();
			this.controlador.obtenerClientes();
			for (ClienteDTO clienteDTO : controlador.getColeccionClientes()) {
				comboBoxDNI.addItem(clienteDTO.getDNI());
			}

			checkBoxActiva = new JCheckBox("Activa");
			checkBoxActiva.setForeground(Color.BLACK);
			checkBoxActiva.setBackground((Color) null);

			buttonGuardar = new JButton("Guardar");
			

			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmAniadirCuenta.setVisible(false);
				}
			});

			JLabel lblSwift = new JLabel("SWIFT");

			textFieldSWIFT = new JTextField();
			textFieldSWIFT.setColumns(10);

			JLabel lblSaldo = new JLabel("Saldo");

			textFieldSaldo = new JTextField();
			textFieldSaldo.setColumns(10);

			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup().addGap(38)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblSaldo)
											.addComponent(label_2).addComponent(label_3)))
							.addGroup(gl_panel.createSequentialGroup().addGap(60)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblSwift)
											.addComponent(label_1))))
							.addGap(32)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldIBAN, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textFieldSWIFT, GroupLayout.DEFAULT_SIZE, 211,
													Short.MAX_VALUE)
											.addGap(170))
									.addGroup(Alignment.TRAILING,
											gl_panel.createSequentialGroup()
													.addComponent(comboBoxInteres, 0, 109, Short.MAX_VALUE).addGap(97)
													.addComponent(checkBoxActiva, GroupLayout.PREFERRED_SIZE, 96,
															GroupLayout.PREFERRED_SIZE)
													.addGap(79))
									.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
											.addComponent(textFieldSaldo, GroupLayout.PREFERRED_SIZE, 119,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
											.addComponent(buttonGuardar, GroupLayout.PREFERRED_SIZE, 94,
													GroupLayout.PREFERRED_SIZE)
											.addGap(29).addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 94,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
											.addComponent(comboBoxDNI, GroupLayout.PREFERRED_SIZE, 113,
													GroupLayout.PREFERRED_SIZE)
											.addGap(18).addComponent(label)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textFieldFechaApetura, GroupLayout.DEFAULT_SIZE, 165,
													Short.MAX_VALUE)))
							.addContainerGap()));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup().addContainerGap(25, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldIBAN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblSwift)
									.addComponent(textFieldSWIFT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
									.addComponent(label)
									.addComponent(comboBoxDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldFechaApetura, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
									.addComponent(comboBoxInteres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(checkBoxActiva))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(buttonGuardar, GroupLayout.PREFERRED_SIZE, 38,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 38,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblSaldo)
											.addComponent(textFieldSaldo, GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap()));
			panel.setLayout(gl_panel);
			GroupLayout groupLayout = new GroupLayout(frmAniadirCuenta.getContentPane());
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE).addGap(20)));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout
							.createSequentialGroup().addContainerGap().addComponent(panel, GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(14, Short.MAX_VALUE)));
			frmAniadirCuenta.getContentPane().setLayout(groupLayout);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
