package juego;

public class Teclado {

	public static enum TipoEstado {
		PULSADA_IZQUIERDA, PULSADA_DERECHA, PULSADA_ARRIBA, PULSADA_ABAJO,
		PULSADA_DISPARO, NO_PULSADA 
	}
	
	private TipoEstado estado = TipoEstado.NO_PULSADA;
	
	public TipoEstado getEstado() {
		return estado;
	}
	
	public void setEstado(TipoEstado estado) {
		this.estado = estado;
	}
}
