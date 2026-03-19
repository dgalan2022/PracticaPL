import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Grupo11 {
    public static void main(String[] args) {
        try {
            // Comprueba el archivo de entrada
            if (args.length == 0) {
                System.err.println("Debes indicar un fichero de entrada");
                System.exit(1);
            }

            String archivoEntrada = args[0];
            CharStream input = CharStreams.fromFileName(archivoEntrada);

            // Configura el lexer
            Grupo11Lexer lexer = new Grupo11Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Configura el parser
            Grupo11Parser parser = new Grupo11Parser(tokens);

            // Ejecuta el parser desde el axioma
            ParseTree tree = parser.prog();

            System.out.flush();

        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}