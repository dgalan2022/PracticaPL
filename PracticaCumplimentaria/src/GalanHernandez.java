import org.antlr.v4.runtime.*;

public class GalanHernandez {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromStream(System.in);
        GalanHernandezLexer lexer = new GalanHernandezLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GalanHernandezParser parser = new GalanHernandezParser(tokens);

        parser.documento();
    }
}
