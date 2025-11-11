package ma.projet.benchd.repositories;

import ma.projet.benchd.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long> {

    // correspond à /items/search/findByCategoryId?categoryId=1&page=0&size=20
    Page<Item> findByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);
}
