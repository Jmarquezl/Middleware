package com.chipilinsoft.middleware.component;

import java.util.List;

import com.chipilinsoft.middleware.entity.Equipo;

public interface EquipoProvider {
	List<Equipo> getEquipos();
	String saveEquipo(String nombre);
	void deleteEquipo(String id);
	void updateEquipo(String id, String nombre);
}
