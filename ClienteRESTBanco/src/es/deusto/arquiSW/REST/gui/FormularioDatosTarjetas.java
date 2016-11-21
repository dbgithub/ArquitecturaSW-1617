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
import es.deusto.arquiSW.REST.DTO.TarjetaDTO;
import es.deusto.arquiSW.REST.DTO.OperacionDTO.EnumTipoOperacion;
import es.deusto.arquiSW.REST.DTO.TarjetaDTO.EnumProveedores;
import es.deusto.arquiSW.REST.DTO.TarjetaDTO.TiposTarjeta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FormularioDatosTarjetas {

	private JFrame frame;
	private JTextField textFieldNumero;
	private JTextField textFieldDNI;
	private JTextField textFieldLimite;
	private JTextField textFieldFechaCaducidad;
	private JTextField textFieldFechaExpedicion;
	private JTextField textFieldCuenta;
	private Controller controlador;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormularioDatosTarjetas window = new FormularioDatosTarjetas();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FormularioDatosTarjetas() {
		initialize();
	}
	
	public void setVisible(boolean b){
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
		
		JLabel label_1 = new JLabel("N\u00FAmero");
		label_1.setForeground(Color.BLACK);
		
		JComboBox<String> comboBoxProveedor = new JComboBox<String>();
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		
		JLabel label_2 = new JLabel("DNI Cliente");
		label_2.setForeground(Color.BLACK);
		
		JLabel label_3 = new JLabel("Tipo");
		label_3.setForeground(Color.BLACK);
		
		JComboBox<String> comboBoxTipo = new JComboBox<String>();
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogbutton = JOptionPane.showConfirmDialog(null,
						"¿Desea añadir realmente la tarjeta especificado ?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (dialogbutton == JOptionPane.YES_OPTION) {
					String numero= textFieldNumero.getText();
					String limite = textFieldLimite.getText();
					String fechaca= textFieldFechaCaducidad.getText();
					String fechaex= textFieldFechaExpedicion.getText();
					Object oprovee= comboBoxProveedor.getSelectedItem();
					String prov= String.valueOf(oprovee);
					Object otipo= comboBoxProveedor.getSelectedItem();
					String tipo= String.valueOf(otipo);
					String cuenta= textFieldCuenta.getText();
					DateFormat format = new SimpleDateFormat();
					Date dateca;
					Date dateex;
					EnumProveedores proveedor=EnumProveedores.valueOf(prov);
					TiposTarjeta tipot=TiposTarjeta.valueOf(tipo);
					try {
						dateca = format.parse(fechaca);
						dateex= format.parse(fechaex);
						TarjetaDTO tar= new TarjetaDTO(Integer.parseInt(numero), Integer.parseInt(cuenta), Integer.parseInt(limite), dateca, proveedor, tipot, dateex);
						controlador.crearTarjeta(tar);
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
				frame.setVisible(false);
			}
		});
		
		JLabel lblLmiteExtraccion = new JLabel("L\u00EDmite extraccion");
		
		textFieldLimite = new JTextField();
		textFieldLimite.setColumns(10);
		
		JLabel lblFechaCaducidad = new JLabel("Fecha caducidad");
		
		textFieldFechaCaducidad = new JTextField();
		textFieldFechaCaducidad.setColumns(10);
		
		JLabel lblFechaExpedicin = new JLabel("Fecha expedici\u00F3n");
		
		textFieldFechaExpedicion = new JTextField();
		textFieldFechaExpedicion.setColumns(10);
		
		JLabel lblCuente = new JLabel("Cuenta");
		
		textFieldCuenta = new JTextField();
		textFieldCuenta.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLmiteExtraccion)
							.addContainerGap(405, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(textFieldNumero, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textFieldLimite, Alignment.TRAILING)
												.addComponent(textFieldFechaExpedicion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
										.addComponent(comboBoxProveedor, 0, 147, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblFechaExpedicin)
									.addGap(128)))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label_3)
										.addComponent(label_2))
									.addGap(30)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textFieldDNI)
										.addComponent(comboBoxTipo, 0, 128, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaCaducidad)
										.addComponent(lblCuente))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldCuenta, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addComponent(textFieldFechaCaducidad, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
							.addGap(79))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textFieldNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addGap(18)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(comboBoxProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLmiteExtraccion)
						.addComponent(textFieldLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaCaducidad)
						.addComponent(textFieldFechaCaducidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaExpedicin)
						.addComponent(textFieldFechaExpedicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCuente)
						.addComponent(textFieldCuenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
