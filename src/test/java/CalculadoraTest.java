import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    Calculadora calculadora = new Calculadora();

    @Test
    void laSumaDeDosNumerosDebeSerConmutativa() {
        assertEquals(5, calculadora.sumar(2,3));
        assertEquals(5, calculadora.sumar(3,2));
    }

    @Test
    void restar() {
        assertEquals(5,calculadora.restar(9,4));
        assertEquals(-5,calculadora.restar(4,9));
    }

    @Test
    void multiplicar() {
        assertEquals(6,calculadora.multiplicar(2,3));
    }

    @Test
    void dividir() {
        fail();
        assertEquals(6,calculadora.dividir(12,2));
    }
}