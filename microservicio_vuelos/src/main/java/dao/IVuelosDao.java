package dao;

import java.util.List;

import model.Vuelo;

public interface IVuelosDao {

	public List<Vuelo> obtenerVuelosDisponibles();
	
	public void actualizarVuelo(Vuelo vuelo);
	
	public Vuelo devolverVuelo(int idvuelo);
}
