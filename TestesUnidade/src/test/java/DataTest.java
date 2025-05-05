import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import nadalete.Data;

public class DataTest {
    @Test
    public void validarConfiguracoesDatasSemParametros(){
        Data cut = new Data();
        LocalDate hoje = LocalDate.now();
        assertEquals(String.format("%s/%s/%s", hoje.getDayOfMonth(), hoje.getMonthValue(), hoje.getYear()), cut.toString());
        LocalDate nextDay = hoje.plusDays(1);
        cut.avancarDia();
        assertEquals(String.format("%s/%s/%s", nextDay.getDayOfMonth(), nextDay.getMonthValue(), nextDay.getYear()), cut.toString());
    }

    @Test
    public void validarConfiguracoesDatasComParametrosParametros(){
        Data cut = new Data(1,2,2025);
        assertEquals("1/2/2025", cut.toString());
        cut.avancarDia();
        assertEquals("2/2/2025", cut.toString());
    }

    @Test
    public void validarConfiguracoesDatasComParametrosParametroDiaErrado(){
        Data cut = new Data(0,1,2025);
        assertEquals("1/1/2000", cut.toString());
        cut.avancarDia();
        assertEquals("2/1/2000", cut.toString());
    }
    @Test
    public void validarConfiguracoesDatasComParametrosParametroMesErrado(){
        Data cut = new Data(1,0,2025);
        assertEquals("1/1/2000", cut.toString());
        cut.avancarDia();
        assertEquals("2/1/2000", cut.toString());
    }

    @Test
    public void validarConfiguracoesDatasComParametrosParametrosAnoBissextoErrado(){
        Data cut = new Data(29,2,2025);
        assertEquals("1/1/2000", cut.toString());
        cut.avancarDia();
        assertEquals("2/1/2000", cut.toString());
    }

    @Test
    public void validarConfiguracoesDatasComParametrosParametrosAnoBissextoValido() {
        Data cut = new Data(29, 2, 2024);
        assertEquals("29/2/2024", cut.toString());
        cut.avancarDia();
        assertEquals("1/3/2024", cut.toString());
    }

}
