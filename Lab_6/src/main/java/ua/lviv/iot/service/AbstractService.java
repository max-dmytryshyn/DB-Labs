package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "https://mxdmos.pp.ua")
public abstract class AbstractService<E, I> {
    protected abstract JpaRepository<E, I> getRepository();

    public List<E> getAll() {
        return getRepository().findAll();
    }

    public E get(I id) {
        return getRepository().getOne(id);
    }

    public E create(E entity) {
        return getRepository().save(entity);
    }

    public E update(I id, E entity) {
        if (getRepository().findById(id).isPresent()) {
            return getRepository().save(entity);
        }

        return null;
    }

    public E delete(I id) {
        E entityToDelete = null;
        if (getRepository().findById(id).isPresent()) {
            entityToDelete = getRepository().getOne(id);
            getRepository().deleteById(id);
        }

        return entityToDelete;
    }
}
