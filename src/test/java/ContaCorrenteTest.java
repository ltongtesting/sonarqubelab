import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {

    @Test
    public void testDepositarValorComSaldoZero() {
        ContaCorrente conta = new ContaCorrente();
        conta.setSaldo(1000.00);

        double resultado = conta.depositar(10);

        Assert.assertEquals(1010.00, resultado, 0);
    }

    @Test
    public void depositarValorPositivo() {
        ContaCorrente contaCorrente = new ContaCorrente();

        double resultado = contaCorrente.depositar(10);

        Assert.assertEquals(10, resultado, 0);
    }

    @Test
    public void depositarValorNegativo() {
        ContaCorrente contaCorrente = new ContaCorrente();

        double resultado = contaCorrente.depositar(-45);

        Assert.assertEquals(0, resultado, 0);
    }

    @Test
    public void depositarValorMenor10() {
        ContaCorrente contaCorrente = new ContaCorrente();

        double resultado = contaCorrente.depositar(11);

        Assert.assertEquals(0, resultado, 0);
    }
}
