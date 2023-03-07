package service;

import java.util.List;

import model.Vuelo;

public interface IServiceVuelos {
	
	public List<Vuelo> obtenerVuelosDisponibles(int plazas);
	public void actualizarPlazas(int vuelo, int plazas);
}
