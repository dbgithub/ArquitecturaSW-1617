package sw;

import java.util.Date;

public class Operacion {
	private enum EnumTipoOperacion {
		Ingreso,Extraccion; 
	}
	private int id;
	private Date fecha;
	private EnumTipoOperacion tipo;
	private float importe;
	private Cuenta cuenta;
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EnumTipoOperacion getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoOperacion tipo) {
		this.tipo = tipo;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	

}
