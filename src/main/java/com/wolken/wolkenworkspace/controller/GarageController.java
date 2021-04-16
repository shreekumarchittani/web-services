package com.wolken.wolkenworkspace.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenworkspace.dto.VehicleDto;

@RestController
@RequestMapping("/")
public class GarageController {
	
	VehicleDto dto = new VehicleDto();
	List<VehicleDto> dtoList = new ArrayList<VehicleDto>();
	
	
	public GarageController() {
	
	}

@GetMapping("/getAll")
	public List<VehicleDto> getAll()
	{
		return dtoList;
	}

@PostMapping("/save")
public String save(@RequestBody VehicleDto dto)
{
	dtoList.add(dto);
	return "Saved Successfully";
}

@PutMapping("/update")
public String update(@RequestBody VehicleDto dto)
{
	for(VehicleDto listdto: dtoList) {
		if(listdto.getVid() == dto.getVid()) {
			dtoList.set(dtoList.indexOf(listdto), dto);
			return "Updated successfully!!";
		}
	}
	return "No vehicle to update";
}

@DeleteMapping("/delete")
public String del(@RequestBody VehicleDto dto)
{	
	if (dtoList.remove(dto)) {
		return "deleted successfully!!";
	}
	return "Nothing to delete!!";
}
}
