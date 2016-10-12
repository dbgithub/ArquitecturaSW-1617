package sw;

import java.util.Date;

public class Operacion {
	public enum EnumTipoOperacion {
		Ingreso,Extraccion; 
	}
	private int id;
	private Date fecha;
	private EnumTipoOperacion tipo;
	private float importe;
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
