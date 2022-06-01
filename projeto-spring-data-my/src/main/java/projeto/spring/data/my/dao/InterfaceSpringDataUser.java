package projeto.spring.data.my.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.my.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends JpaRepository<UsuarioSpringData, Long>{

}
