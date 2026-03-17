grammar NavasMartinez;

@header {
import java.util.*;
import java.util.regex.*;
}

// Primero se imprime la cabecera HTML Prueba
prog: {
    System.out.println("<!DOCTYPE html>");
    System.out.println("<html>");
    
    System.out.println("<head>");
    System.out.println("<title>MarkDown3HTML</title>");
    System.out.println("<style>");
    System.out.println(".bold {font-weight: bold;}");
    System.out.println(".ital {font-style: italic;}");
    System.out.println("</style>");
    System.out.println("</head>");
    System.out.println("<body>");
    
}
document EOF {
    // Cierra el HTML
    System.out.println("</body>");
    System.out.println("</html>");
} ;

// Documento compuesto por elementos
document: element* ;

// Tipos de elementos posibles
element: heading
       | quote
       | hrule
       | codeblock
       | list
       | textline
       | NEWLINE { System.out.println(); }
       ;

// Encabezados H1-H6
heading: H1 { System.out.println("<H1>" + $H1.text.substring(2).trim() + "</H1>"); }
       | H2 { System.out.println("<H2>" + $H2.text.substring(3).trim() + "</H2>"); }
       | H3 { System.out.println("<H3>" + $H3.text.substring(4).trim() + "</H3>"); }
       | H4 { System.out.println("<H4>" + $H4.text.substring(5).trim() + "</H4>"); }
       | H5 { System.out.println("<H5>" + $H5.text.substring(6).trim() + "</H5>"); }
       | H6 { System.out.println("<H6>" + $H6.text.substring(7).trim() + "</H6>"); }
       ;

// Citas
quote: QUOTE {
    System.out.println("<blockquote>");
    System.out.println($QUOTE.text.substring(2).trim());
    System.out.println("</blockquote>");
} ;

// Línea horizontal
hrule: HRULE { System.out.println("<HR/>"); } ;

// Bloque de código
codeblock: CODEBLOCK {
    String content = $CODEBLOCK.text;
    content = content.substring(4, content.length()-4).trim();
    System.out.println("<code> <pre>");
    System.out.print(content);
    System.out.println("</pre> </code>");
} ;

// Lista no ordenada
list: { System.out.println("<UL>"); }
      (listitem)+
      { System.out.println("</UL>"); }
    ;

// Elemento de lista
listitem: LISTITEM {
    String item = $LISTITEM.text.substring(2).trim();
    System.out.println("<LI>" + item + "</LI>");
} ;

// Línea de texto con formato
textline: textpart+ NEWLINE { System.out.println(); } ;

// Partes de texto: enlaces, negrita, cursiva, etc
textpart: LINK {
        // Extraer texto y URL del enlace
        String full = $LINK.text;
        int urlStart = full.indexOf("](") + 2;
        int urlEnd = full.lastIndexOf(")");
        String linkText = full.substring(1, full.indexOf("]("));
        String url = full.substring(urlStart, urlEnd);

        // Validar formato de URL
        boolean isValid = url.matches("^(http://|https://)[a-zA-Z0-9]+\\.[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*.*$");

        System.out.print("<A HREF=\"" + url + "\">" + linkText);
        if (!isValid) {
            System.out.print("(URL aparentemente incorrecta)");
        }
        System.out.print("</A>");
    }
    | BOLD {
        // Procesar texto en negrita
        String s = $BOLD.text;
        String txt = s.startsWith("**") ? s.substring(2, s.length()-2) : s.substring(2, s.length()-2);
        System.out.print("<SPAN class=\"bold\">" + txt + "</SPAN>");
    }
    | ITALIC {
        // Procesar texto en cursiva
        String s = $ITALIC.text;
        String txt = s.substring(1, s.length()-1);
        System.out.print("<SPAN class=\"ital\">" + txt + "</SPAN>");
    }
    | WS { System.out.print($WS.text); }
    | WORD { System.out.print($WORD.text); }
    ;

// reglas léxicas

// Bloque de código entre ~~~
CODEBLOCK: '~~~' ('\r'? '\n') .*? '~~~' ('\r'? '\n')? ;

// Item de lista con guion
LISTITEM: '-' ' ' ~[\r\n]+ ('\r'? '\n') ;

// Encabezados
H6: '######' ' ' ~[\r\n]+ ('\r'? '\n') ;
H5: '#####' ' ' ~[\r\n]+ ('\r'? '\n') ;
H4: '####' ' ' ~[\r\n]+ ('\r'? '\n') ;
H3: '###' ' ' ~[\r\n]+ ('\r'? '\n') ;
H2: '##' ' ' ~[\r\n]+ ('\r'? '\n') ;
H1: '#' ' ' ~[\r\n]+ ('\r'? '\n') ;

// Cita con >
QUOTE: '>' ' ' ~[\r\n]+ ('\r'? '\n') ;

// Línea horizontal
HRULE: ('***' | '---' | '___') ('\r'? '\n') ;

// Enlace
LINK: '[' ~[\][\r\n]+ '](' ~[)\r\n]+ ')' ;

// Negrita con ** o __
BOLD: ('**' ~[*\r\n]+ '**') | ('__' ~[_\r\n]+ '__') ;

// Cursiva con * o _
ITALIC: ('*' ~[*\r\n]+ '*') | ('_' ~[_\r\n]+ '_') ;

// Espacios y tabuladores
WS: [ \t]+ ;

// Salto de línea
NEWLINE: '\r'? '\n' ;

// Palabra normal
WORD: ~[\r\n\t *_#>~[\-]+ ;
