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
import es.deusto.arquiSW.REST.DTO.CuentaDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FormularioDatosCuentas {

	private JFrame frmAniadirCuenta;
	private JTextField textFieldFechaApetura;
	private JTextField textFieldIBAN;
	private JTextField textFieldDNI;
	
	private Controller controlador;
	private JTextField textFieldSWIFT;
	private JTextField textFieldSaldo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormularioDatosCuentas window = new FormularioDatosCuentas();
//					window.frmAniadirCuenta.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FormularioDatosCuentas() {
		initialize();
	}
	
	public void setVisible(boolean b){
		this.frmAniadirCuenta.setVisible(b);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAniadirCuenta = new JFrame();
		frmAniadirCuenta.setTitle("A\u00F1adir cuenta");
		frmAniadirCuenta.setBounds(100, 100, 559, 266);
		
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
		
		textFieldFechaApetura = new JTextField();
		textFieldFechaApetura.setColumns(10);
		
		textFieldIBAN = new JTextField();
		textFieldIBAN.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		
		JComboBox<String> comboBoxInteres = new JComboBox<String>();
		comboBoxInteres.addItem("0.01");
		comboBoxInteres.addItem("0.02");
		comboBoxInteres.addItem("0.06");
	        
		
		JCheckBox checkBoxActiva = new JCheckBox("Activa");
		checkBoxActiva.setForeground(Color.BLACK);
		checkBoxActiva.setBackground((Color) null);
		
		JButton buttonGuardar = new JButton("Guardar");
		buttonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogbutton = JOptionPane.showConfirmDialog(null,
						"¿Desea añadir realmente la cuenta especificada ?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (dialogbutton == JOptionPane.YES_OPTION) {
					String IBAN= textFieldIBAN.getText();					
					String DNICliente = textFieldDNI.getText();
					String Fecha = textFieldFechaApetura.getText();
					String Saldo = textFieldSaldo.getText();
					String SWIFT = textFieldSWIFT.getText();
					boolean activa = checkBoxActiva.isSelected();
					Object o = comboBoxInteres.getSelectedItem();
					String interes= String.valueOf(o);
					DateFormat format = new SimpleDateFormat();
					Date date;
					try {
						date = format.parse(Fecha);
						CuentaDTO cuenta = new CuentaDTO(Integer.parseInt(IBAN), SWIFT, date, activa, Float.parseFloat(Saldo), Float.parseFloat(interes), DNICliente, null);
						controlador.crearCuenta(cuenta);
						setVisible(false);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					

				}
			}
		});
		
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
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSwift)
						.addComponent(label_1))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textFieldIBAN, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textFieldSWIFT, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
									.addGap(61))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textFieldDNI, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
									.addGap(22)
									.addComponent(label)))
							.addGap(18)
							.addComponent(textFieldFechaApetura, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(14))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSaldo)
						.addComponent(label_2)
						.addComponent(label_3))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBoxInteres, 0, 109, Short.MAX_VALUE)
							.addGap(176)
							.addComponent(checkBoxActiva, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textFieldSaldo, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(buttonGuardar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldIBAN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSwift)
						.addComponent(textFieldSWIFT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textFieldFechaApetura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkBoxActiva)
						.addComponent(label_3)
						.addComponent(comboBoxInteres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(buttonGuardar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSaldo)
							.addComponent(textFieldSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frmAniadirCuenta.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		frmAniadirCuenta.getContentPane().setLayout(groupLayout);
	}
}
