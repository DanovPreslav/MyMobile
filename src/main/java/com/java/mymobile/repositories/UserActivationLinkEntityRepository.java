package com.java.mymobile.repositories;


        import com.java.mymobile.domain.entities.UserActivationLinkEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationLinkEntityRepository extends JpaRepository<UserActivationLinkEntity, Long> {

}