import br.com.conversor.de.moedas.validar.ValidadorDeMoeda;

public class TesteValidador {
    public static void main(String[] args) {
        ValidadorDeMoeda validadorDeMoeda = new ValidadorDeMoeda();
        validadorDeMoeda.validar("BReL", "ZWL");
    }
}
