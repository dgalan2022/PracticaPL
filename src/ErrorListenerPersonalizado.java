import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class ErrorListenerPersonalizado extends BaseErrorListener {

    private final List<String> errores = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int linea,
                            int columna,
                            String msg,
                            RecognitionException e) {

        String causa = msg;
        if (msg.contains("missing")) {
            causa = "Falta un token esperado";
        } else if (msg.contains("extraneous")) {
            causa = "Token inesperado o sobrante";
        } else if (msg.contains("no viable alternative")) {
            causa = "No se reconoce ninguna alternativa sintactica valida";
        } else if (msg.contains("mismatched")) {
            causa = "Token no coincide con lo esperado";
        }

        errores.add("Error en linea " + linea + ", columna " + columna
                + " -> " + causa + " [" + msg + "]");
    }

    public boolean hayErrores() { return !errores.isEmpty(); }

    public void imprimirErrores() {
        for (String err : errores) System.err.println(err);
    }

    public List<String> getErrores() { return errores; }
}