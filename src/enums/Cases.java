package src.enums;

public enum Cases {
    VOID_ORDENADO(""),
    VOID_ORDENADO_CONTRARIO(""),
    VOID_ALEATORIO("");

    private final String stringValue;

    Cases(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getPath() {
        return stringValue;
    };
}
