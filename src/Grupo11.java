import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Grupo11 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Uso: java -jar Grupo11.jar <fichero.for>");
                System.exit(1);
            }

            String archivoEntrada = args[0];
            CharStream input = CharStreams.fromFileName(archivoEntrada);

            Grupo11Lexer lexer = new Grupo11Lexer(input);
            lexer.removeErrorListeners();
            ErrorListenerPersonalizado errLex = new ErrorListenerPersonalizado();
            lexer.addErrorListener(errLex);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Grupo11Parser parser = new Grupo11Parser(tokens);
            parser.removeErrorListeners();
            ErrorListenerPersonalizado errPar = new ErrorListenerPersonalizado();
            parser.addErrorListener(errPar);

            Grupo11Parser.ProgContext tree = parser.prog();

            if (errLex.hayErrores() || errPar.hayErrores()) {
                errLex.imprimirErrores();
                errPar.imprimirErrores();
                System.exit(1);
            }

            ValidadorSemantico validador = new ValidadorSemantico();
            validador.validar(tree);

            if (validador.hayErrores()) {
                validador.imprimirErrores();
                System.exit(1);
            }

            TraductorC traductor = new TraductorC(archivoEntrada);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new TraductorListener(traductor), tree);

            String codigoC = traductor.getCodigo();
            Path rutaSalida = Paths.get(traductor.getRutaSalida());
            Files.write(rutaSalida, codigoC.getBytes(StandardCharsets.UTF_8));
            System.out.println("Traduccion generada: " + rutaSalida.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}