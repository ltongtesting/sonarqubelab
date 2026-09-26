import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaMockTest {

    private double valorDep;
    private double valorMaior;
    private double valorNeg;
    private double valorSac;

    @Before
    public void prepareTests() {
        valorDep = 10;
        valorMaior = 12;
        valorNeg = -10.00;
        valorSac = 7.00;
    }

    @Test
    public void testDepositarValorComSaldoZero() {
        ContaMock conta = new ContaMock();

        double resultado = conta.depositarValor(valorDep);

        Assert.assertEquals(10.00, resultado, 0);
    }

    @Test
    public void testSacarValorComSaldoMaiorQueZero() {
        ContaMock conta = new ContaMock();

        conta.depositarValor(valorDep);
        conta.sacarValor(valorSac);

        double resultado = conta.getTotal();

        Assert.assertEquals(3.00, resultado, 0);
    }

    @Test
    public void testDepositoValorMaiorQue10() {
        ContaMock conta = new ContaMock();

        conta.depositarValor(valorDep);
        conta.depositarValor(valorMaior);
        conta.sacarValor(valorSac);

        double resultado = conta.getTotal();

        Assert.assertEquals(3.00, resultado, 0);
    }

    @Test
    public void testDepositarValorComValorNegativo() {
        ContaMock conta = new ContaMock();

        conta.depositarValor(valorDep);
        conta.depositarValor(valorNeg);

        double resultado = conta.getTotal();

        Assert.assertEquals(10.00, resultado, 0);
    }

    @Test
    public void testSacarValorComValorNegativo() {
        ContaMock conta = new ContaMock();

        conta.depositarValor(valorDep);
        conta.sacarValor(valorNeg);

        double resultado = conta.getTotal();

        Assert.assertEquals(10.00, resultado, 0);
    }
}
