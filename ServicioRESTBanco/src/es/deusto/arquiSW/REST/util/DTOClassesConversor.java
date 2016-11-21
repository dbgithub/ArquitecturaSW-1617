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
		return new Cliente(dto.getDNI(), dto.getNombre(), dto.getApellidos(), dto.getDireccion(), dto.getEmail(),
				dto.getMovil(), dto.isEmpleado(), dto.getPIN(), null);
	}

	public Cuenta DTOCuentaToCuenta(CuentaDTO dto) {
		ArrayList<Operacion> collectionOperacion = new ArrayList<Operacion>();
		for (OperacionDTO item : dto.getOperaciones()) {
			collectionOperacion.add(this.DTOOperacionToOperacion(item));
		}
		Cliente tmp = new Cliente();
		tmp.setDNI(dto.getTitular());
		return new Cuenta(dto.getIBAN(), dto.getSWIFT(), dto.getFechaApertura(), dto.isActiva(), dto.getSaldoActual(),
				dto.getInteres(), tmp, null, collectionOperacion);
	}

	public Operacion DTOOperacionToOperacion(OperacionDTO dto) {
		return new Operacion(dto.getId(), dto.getFecha(), Operacion.EnumTipoOperacion.valueOf(dto.getTipo().name()),
				dto.getImporte(), null);

	}

	public Tarjeta DTOTarjetaToTarjeta(TarjetaDTO dto) {
		Cuenta c = new Cuenta();
		c.setIBAN(dto.getCuenta());
		return new Tarjeta(dto.getNumero(), c, dto.getLimiteExtraccion(), dto.getFechaCaducidad(),
				Tarjeta.EnumProveedores.valueOf(dto.getProveedor().name()),
				Tarjeta.TiposTarjeta.valueOf(dto.getTipo().name()), dto.getFechaExpedicion());

	}

	// Domain classes -> DTO
	public ClienteDTO ClienteToDTOCliente(Cliente c) {
		return new ClienteDTO(c.getDNI(), c.getNombre(), c.getApellidos(), c.getDireccion(), c.getEmail(), c.getMovil(),
				c.isEmpleado(), c.getPIN());
	}

	public CuentaDTO CuentaToDTOCuenta(Cuenta cu) {
		ArrayList<OperacionDTO> listaOperaciones = new ArrayList<OperacionDTO>();
		if (cu.getOperaciones() != null) {
			for (Operacion o : cu.getOperaciones()) {
				listaOperaciones.add(this.OperacionToDTOOperacion(o));
			}			
		}
		return new CuentaDTO(cu.getIBAN(), cu.getSWIFT(), cu.getFechaApertura(), cu.isActiva(), cu.getSaldoActual(),
				cu.getInteres(), cu.getTitular().getDNI(), listaOperaciones);
	}

	public OperacionDTO OperacionToDTOOperacion(Operacion o) {
		return new OperacionDTO(o.getId(), o.getFecha(), OperacionDTO.EnumTipoOperacion.valueOf(o.getTipo().name()),
				o.getImporte(), 0);
	}

	public TarjetaDTO TarjetaToDTOTarjeta(Tarjeta t) {
		return new TarjetaDTO(t.getNumero(), t.getCuenta().getIBAN(), t.getLimiteExtraccion(), t.getFechaCaducidad(),
				TarjetaDTO.EnumProveedores.valueOf(t.getProveedor().name()),
				TarjetaDTO.TiposTarjeta.valueOf(t.getTipo().name()), t.getFechaExpedicion());

	}
}
