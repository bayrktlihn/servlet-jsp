package io.bayrktlihn.bookstorewebsite.context;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EntityManagerContextHolder {
    private static final ThreadLocal<EntityManagerContext> local = new ThreadLocal<>();


    @Getter
    @Setter
    @NoArgsConstructor
    private static class EntityManagerContext{
        private EntityManager entityManager;
    }



    public static void setEntityManager(EntityManager entityManager){
        EntityManagerContext entityManagerContext = getContext();
        entityManagerContext.setEntityManager(entityManager);
    }

    public static EntityManagerContext getContext(){
        if(local.get() == null){
            local.set(new EntityManagerContext());
        }
        return local.get();
    }


    public static EntityManager getEntityManager(){
        EntityManagerContext entityManagerContext = getContext();
        return entityManagerContext.getEntityManager();
    }

    public static void clearContext(){
        local.remove();
    }

}
