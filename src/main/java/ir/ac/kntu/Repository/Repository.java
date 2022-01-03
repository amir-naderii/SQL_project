package ir.ac.kntu.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface Repository<Entity,ID extends Serializable> {
    Entity findById(ID id);
    List<Entity> findByIDs(Collections ids);
    List<Entity> findAll();
    Boolean deleteByID(ID id);
    Boolean DeleteByIDs(Collection<ID> ids);
    Entity save(Entity E);
}
