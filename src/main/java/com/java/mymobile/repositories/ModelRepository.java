package com.java.mymobile.repositories;



        import com.java.mymobile.domain.entities.Model;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
}
