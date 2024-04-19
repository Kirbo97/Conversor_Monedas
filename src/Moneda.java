public record Moneda(String base_code,
                     String target_code,
                       double conversion_result) {

    @Override//aparece cuando esta sobre-escribiendo un metodo y en este caso es el "toString"
    public String toString() {
        return "["+base_code+"] corresponde al valor final de =>> " + conversion_result +" ["+target_code+"]";
    }
}
