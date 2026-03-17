import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class NavasMartinez {
    public static void main(String[] args) {
        try {
            // Determina entrada entre archivo o stdin
            InputStream is = System.in;
            if (args.length > 0) {
                is = new FileInputStream(args[0]);
            }

            // Configura lexer y parser
            CharStream input = CharStreams.fromStream(is);
            NavasMartinezLexer lexer = new NavasMartinezLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            NavasMartinezParser parser = new NavasMartinezParser(tokens);

            // Desactiva mensajes de error
            parser.removeErrorListeners();

            // Ejecuta el parser
            parser.prog();

            System.out.flush();

        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
