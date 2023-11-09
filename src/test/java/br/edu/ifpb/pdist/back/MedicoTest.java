package br.edu.ifpb.pdist.back;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifpb.pdist.back.model.Medico;

@SpringBootTest
class MedicoTest {

	 @Test
    public void NaoDeveAlterarCRMSemDigitos(){
        Medico medico = new Medico("Joao", "123-ABC", "Masculino", "Cardiologista", "123456789");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            medico.setCrm("");
        });
    }

    @Test
    public void NaoDeveAlterarCRMSeNaoHouver7Digitos(){
        Medico medico = new Medico("Joao", "123-ABC", "Masculino", "Cardiologista", "123456789");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            medico.setCrm("123456");
        });
    }

    @Test
    public void DeveAlterarCRM(){
        Medico medico = new Medico("Joao", "123-ABC", "Masculino", "Cardiologista", "123456789");
        medico.setCrm("1234567");
        Assertions.assertEquals("1234567", medico.getCrm());
    }

    @Test
    public void NaoDeveAlterarNomeSeVazio(){
        Medico medico = new Medico("Joao", "123-ABC", "Masculino", "Cardiologista", "123456789");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            medico.setName("");
        });
    }

    @Test
    public void DeveAlterarNome(){
        Medico medico = new Medico("Joao", "123-ABC", "Masculino", "Cardiologista", "123456789");
        medico.setName("Maria");
        Assertions.assertEquals("Maria", medico.getNome());
    }

}
