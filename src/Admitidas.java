import java.util.Map;

public record Admitidas(Map <String,Double> conversion_rates) {

    @Override//aparece cuando esta sobre-escribiendo un metodo y en este caso es el "toString"
    public String toString() {
        return conversion_rates.keySet().toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "");
    }
}