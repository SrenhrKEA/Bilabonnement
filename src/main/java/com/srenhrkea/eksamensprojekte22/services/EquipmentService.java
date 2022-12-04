package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Equipment;

import java.util.List;

public interface EquipmentService {

  Equipment getEquipmentById(int id);

  List<Equipment> getAllEquipment();

  void saveEquipment(Equipment equipment);

  void updateEquipment(Equipment equipment);

  void deleteEquipmentById(int id);

}
