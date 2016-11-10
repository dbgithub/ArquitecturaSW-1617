package es.deusto.arquiSW.REST.util;

import java.util.ArrayList;

import es.deusto.arquiSW.REST.DTO.ClienteDTO;
import es.deusto.arquiSW.REST.DTO.CuentaDTO;
import es.deusto.arquiSW.REST.DTO.OperacionDTO;
import es.deusto.arquiSW.REST.DTO.TarjetaDTO;
import es.deusto.arquiSW.REST.classes.Cliente;
import es.deusto.arquiSW.REST.classes.Cuenta;
import es.deusto.arquiSW.REST.classes.Operacion;
import es.deusto.arquiSW.REST.classes.Tarjeta;

public class DTOClassesConversor {
	
	public DTOClassesConversor() {
		
	}

	// DTO -> Domain classes
	public Cliente DTOClienteToCliente(ClienteDTO dto) {
		return new Cliente(dto.getDNI(),dto.getNombre(),dto.getApellidos(),dto.getDireccion(),dto.getEmail(),dto.getMovil(),
				dto.isEmpleado(),dto.getPIN(),null);
	}
	public Cuenta DTOCuentaToCuenta(CuentaDTO dto) {
		ArrayList<Operacion> collectionOperacion = new ArrayList<Operacion>();
		for (OperacionDTO item : dto.getOperaciones()) {
			collectionOperacion.add(this.DTOOperacionToOperacion(item));
		}
		Cliente tmp = new Cliente(); tmp.setDNI(dto.getTitular());
		return new Cuenta(dto.getIBAN(),dto.getSWIFT(),dto.getFechaApertura(),dto.isActiva(),dto.getSaldoActual(),
				dto.getInteres(),tmp, null, collectionOperacion);
	}
	public Operacion DTOOperacionToOperacion(OperacionDTO dto) {
		return null;
	}
	public Tarjeta DTOTarjetaToTarjeta(TarjetaDTO dto) {
		return null;
	}
	
	// Domain classes -> DTO
	public ClienteDTO ClienteToDTOCliente(Cliente c) {
		return null;
	}
	public CuentaDTO CuentaToDTOCuenta(Cuenta cu) {
		return null;
	}
	public OperacionDTO OperacionToDTOOperacion(Operacion o) {
		return null;
	}
	public TarjetaDTO TarjetaToDTOTarjeta(Tarjeta t) {
		return null;
	}
}
