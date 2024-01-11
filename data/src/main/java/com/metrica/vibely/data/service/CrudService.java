package com.metrica.vibely.data.service;


abstract interface CrudService<DTO, ID> {

    
    DTO getById(ID id);

    
    DTO create(DTO dto);

    
    DTO update(DTO dto);

   
    void deleteById(ID id);

}