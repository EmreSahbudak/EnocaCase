package com.emre.utility;


import com.emre.entity.Base;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
@Getter
public abstract class ServiceManager<T extends Base, ID> implements IService<T, ID>{
    private final JpaRepository<T, ID> repository;
    @Override
    public T save(T t) {
        t.setCreatedDate(System.currentTimeMillis());
        t.setUpdatedDate(System.currentTimeMillis());
        return repository.save(t);
    }
    @Override
    public T update(T t) {
        t.setUpdatedDate(System.currentTimeMillis());
        return repository.save(t);
    }
    @Override
    public void delete(T t) {
        repository.delete(t);
    }
    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

}
