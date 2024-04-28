package co.edu.unbosque.forrestmback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.forrestmback.model.PistaMusical;

@Repository
public interface PistaMusicalDAO extends JpaRepository<PistaMusical, Integer> {

}
