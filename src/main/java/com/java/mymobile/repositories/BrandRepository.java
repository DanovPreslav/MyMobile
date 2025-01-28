package com.java.mymobile.repositories;


        import com.java.mymobile.domain.entities.Brand;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
}