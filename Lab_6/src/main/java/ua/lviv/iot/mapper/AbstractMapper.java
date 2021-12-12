package ua.lviv.iot.mapper;

public abstract class AbstractMapper<E, DTO> {
    public abstract DTO mapEntityToDto(E entity);
}
