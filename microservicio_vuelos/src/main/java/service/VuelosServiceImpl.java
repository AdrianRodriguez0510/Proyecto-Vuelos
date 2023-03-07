package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IVuelosDao;
import model.Vuelo;
@Service
public class VuelosServiceImpl implements IServiceVuelos {

	@Autowired
	IVuelosDao dao;
	@Override
	public List<Vuelo> obtenerVuelosDisponibles(int plazas) {
		List<Vuelo> vuelos = dao.obtenerVuelosDisponibles();
		return vuelos.stream().filter(t->t.getPlazas()>=plazas).collect(Collectors.toList());
		
	}

	@Override
	public void actualizarPlazas(int idvuelo, int plazas) {
		Vuelo vuelo = dao.devolverVuelo(idvuelo);
		if(vuelo !=null) {
		vuelo.setPlazas(vuelo.getPlazas()-plazas);
		dao.actualizarVuelo(vuelo);
		}
	}

	
}
