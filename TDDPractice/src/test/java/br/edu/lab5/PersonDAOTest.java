package br.edu.lab5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.edu.lab5.exercicio02.Email;
import br.edu.lab5.exercicio02.Person;
import br.edu.lab5.exercicio02.PersonDAO;

public class PersonDAOTest {
    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarPessona(String nome, int idade, String email, String retornoEsperado, boolean isEmpty) {
        PersonDAO dao = new PersonDAO();
        List<Email> emails = new ArrayList<>();
        if (!isEmpty) {
            emails.add(new Email(1, email));
        }else{
            emails = null;
        }
        Person p = new Person(1, nome, idade, emails);
        dao.save(p);
        assertTrue(dao.getErrors().stream().anyMatch(e -> e.contains(retornoEsperado)));
    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of("Joao Silva", 201, null, "Idade inválida: deve estar entre 1 e 200", true),
                Arguments.of("Joao Silva", -1, "teste@gmail.com", "Idade inválida: deve estar entre 1 e 200", false),
                Arguments.of("Joao Silva", 30, null, "Deve haver ao menos um e-mail associado.", true),
                Arguments.of("Joao Silva", 30, "email@site", "E-mail inválido", false),
                Arguments.of("Joao Silva!", 30, "teste@email.com",
                        "Nome inválido: deve conter ao menos duas partes e apenas letras.", false),
                Arguments.of("Silva1", 30, "teste@email.com",
                        "Nome inválido: deve conter ao menos duas partes e apenas letras.", false),
                Arguments.of("Silva", 30, "teste@email.com", "Nome inválido", false));
    }

}