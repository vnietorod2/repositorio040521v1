package com.empresa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService service;
	
	@RequestMapping("/verAlumno")
	public String ver() {
		return "registraAlumno";
	}
	
	@RequestMapping("/registroAlumno")
	@ResponseBody
	public Map<String, Object> registra(Alumno obj){
		Map<String, Object> salida = new HashMap<>();
		Alumno objSalida = service.insertaAlumno(obj);
		if (objSalida == null) {
			salida.put("MENSAJE", "Registro erróneo");
		}else {
			salida.put("MENSAJE", "Registro exitoso");
		}
		return salida;
	}
	
	
}
