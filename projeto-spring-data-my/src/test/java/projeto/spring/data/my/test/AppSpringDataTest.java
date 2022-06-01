package projeto.spring.data.my.test;


import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import projeto.spring.data.my.dao.InterfaceSpringDataUser;
import projeto.spring.data.my.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	//MÉTODO PARA SALVAR UM USUÁRIO NO BANCO DE DADOS
	@Test
	public void insertTest() {
		
		System.out.println("Conexão com o banco, sucesso!");
		
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		
		usuarioSpringData.setNome("João");
		usuarioSpringData.setSobrenome("Horsch");
		usuarioSpringData.setIdade(974);
		usuarioSpringData.setCpf("4512487952");
		usuarioSpringData.setEmail("joao@email.com.br");
		usuarioSpringData.setLogin("joao");
		usuarioSpringData.setPassword("456789");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
		System.out.println("Existem user: " +interfaceSpringDataUser.count());
		
		
	}
	
	//MÉTODO PARA CONSULTAR TODOS OS USUARIOS NO BANCO DE DADOS
	@Test
	public void testeConsultaUsers() {
		
		Iterable<UsuarioSpringData> list = interfaceSpringDataUser.findAll();
		
		for(UsuarioSpringData usuarioSpringData : list) {
			
			System.out.println("Id: " +usuarioSpringData.getId());
			System.out.println("Nome : " +usuarioSpringData.getNome());
			System.out.println("Sobrenome: " +usuarioSpringData.getSobrenome());
			System.out.println("Idade: " +usuarioSpringData.getIdade());
			System.out.println("Cpf: " +usuarioSpringData.getCpf());
			System.out.println("Email: " +usuarioSpringData.getEmail());
			System.out.println("Login: " +usuarioSpringData.getLogin());
			System.out.println("Password: " +usuarioSpringData.getPassword());
			System.out.println("============================================");
			
		}
	}
	
	//MÉTODO PARA BUSCAR UM USUARIO PELO ID
	@Test
	public void testeConsultaId() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);
		
		System.out.println("Id: " +usuarioSpringData.get().getId());
		System.out.println("Nome: " +usuarioSpringData.get().getNome());
		System.out.println("Sobrenome: " +usuarioSpringData.get().getSobrenome());
		System.out.println("Idade: " +usuarioSpringData.get().getIdade());
		System.out.println("CPF: " +usuarioSpringData.get().getCpf());
		System.out.println("Email: " +usuarioSpringData.get().getEmail());
		System.out.println("Login: " +usuarioSpringData.get().getLogin());
		System.out.println("Password: " +usuarioSpringData.get().getPassword());
	}
	
	//MÉTODO PARA ATUALIZAR O USUÁRIO NO BANCO DE DADOS
	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> update = interfaceSpringDataUser.findById(1L);
		
		UsuarioSpringData data = update.get();
		
		data.setNome("Jhon");
		data.setSobrenome("Silva");
		data.setIdade(789);
		data.setCpf("4567894123");
		data.setEmail("jhon@email.com.br");
		data.setLogin("jhonlogin");
		data.setPassword("123456");
		
		if(data != null) {
			
			interfaceSpringDataUser.save(data);
			System.out.println("Update realizado com sucesso!");
		}else {
			System.out.println("Erro ao atualizar");
		}
		
		
	}
	
	//MÉTODO PARA EXCLUIR UM USUÁRIO NO BANCO DE DADOS
	@Test
	public void testeDelete() {
		
		interfaceSpringDataUser.deleteById(3L);
		
		if(true) {
			System.out.println("Excluido com sucesso!");
		}else {
			System.out.println("Erro ao excluir");
		}
	}
	
	@Test
	public void insertTelefoneUser() {
		System.out.println("Criado tabela Telefone");
	}
	
}
