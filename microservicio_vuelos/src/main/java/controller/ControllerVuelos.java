package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Vuelo;
import service.IServiceVuelos;

@CrossOrigin(origins="*")
@RestController
public class ControllerVuelos {
	

	@Autowired
	IServiceVuelos servicio;
	
	@GetMapping(value = "vuelos/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> obtenerVuelosDisponibles(@PathVariable("plazas") int plazas){
		if(plazas >0) {
			return servicio.obtenerVuelosDisponibles(plazas);
		}
		return null;
		
	}
	
	@PutMapping(value= "vuelos/{idvuelo}/{plazas}")
	public void modificarVuelo(@PathVariable("idvuelo") int idvuelo, @PathVariable("plazas") int plazas) {
		
			servicio.actualizarPlazas(idvuelo, plazas);
		
	}
	
}
