package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.service.AbstractService;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController<E, DTO, I> {
    protected abstract AbstractService<E, I> getService();

    protected abstract AbstractMapper<E, DTO> getMapper();

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<DTO>> getAll() {
        List<E> entities = getService().getAll();
        List<DTO> dtoObjects = new ArrayList<DTO>();
        for (E entity : entities) {
            dtoObjects.add(getMapper().mapEntityToDto(entity));
        }
        return new ResponseEntity<>(dtoObjects, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<DTO> getById(@PathVariable I id) {
        return new ResponseEntity<>(getMapper().mapEntityToDto(getService().get(id)), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<DTO> create(@RequestBody E entity) {
        return new ResponseEntity<>(getMapper().mapEntityToDto(getService().create(entity)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<DTO> update(@PathVariable I id, @RequestBody E entity) {
        return new ResponseEntity<>(getMapper().mapEntityToDto(getService().update(id, entity)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<DTO> delete(@PathVariable I id) {
        return new ResponseEntity<>(getMapper().mapEntityToDto(getService().delete(id)), HttpStatus.OK);
    }
}
