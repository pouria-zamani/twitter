package base.service.impl;

import base.domain.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;

public abstract class BaseServiceImpl<E extends BaseEntity<ID>, ID, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {
    protected final R repository;

    public BaseServiceImpl(R repository){
        this.repository = repository;
    }
}
