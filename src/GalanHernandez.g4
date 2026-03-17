grammar GalanHernandez;

@members {
    private String convertirTexto(String texto) {
        if (texto == null) return "";
        texto = texto.trim();

        texto = procesarEnlaces(texto);

        texto = procesarNegrita(texto);
        texto = procesarCursiva(texto);

        return texto;
    }

    private String procesarEnlaces(String texto) {
        java.util.regex.Pattern patron = java.util.regex.Pattern.compile("\\[([^\\]]+)\\]\\(([^)]+)\\)");
        java.util.regex.Matcher buscador = patron.matcher(texto);
        StringBuffer resultado = new StringBuffer();

        while (buscador.find()) {
            String textoEnlace = buscador.group(1);
            String direccionURL = buscador.group(2);
            String htmlFinal;

            if (esURLValida(direccionURL)) {
                htmlFinal = "<a href=\"" + direccionURL + "\">" + textoEnlace + "</a>";
            } else {
                htmlFinal = "<a href=\"" + direccionURL + "\">" + textoEnlace + "</a>(URL enlace aparentemente incorrecta)";
            }
            buscador.appendReplacement(resultado, java.util.regex.Matcher.quoteReplacement(htmlFinal));
        }
        buscador.appendTail(resultado);
        return resultado.toString();
    }

    private boolean esURLValida(String url) {
        return url.matches("https?://[a-zA-Z0-9]+\\.[a-zA-Z0-9]+.*");
    }

    private String procesarNegrita(String texto) {
        texto = texto.replaceAll("\\*\\*([^*]+)\\*\\*", "<b>$1</b>");
        texto = texto.replaceAll("__([^_]+)__", "<b>$1</b>");
        return texto;
    }

    private String procesarCursiva(String texto) {
        texto = texto.replaceAll("\\*([^*]+)\\*", "<i>$1</i>");
        texto = texto.replaceAll("_([^_]+)_", "<i>$1</i>");
        return texto;
    }
}

documento
    : { System.out.println("<!DOCTYPE html>\n<html>\n<head>\n<title>MarkDown3HTML</title>\n</head>\n<body>"); }
      linea*
      { System.out.println("</body>\n</html>"); }
      EOF
    ;

linea
    : encabezado
    | lineaHorizontal
    | cita
    | bloquecodigo
    | lista
    | parrafo
    | NEWLINE
    ;

encabezado
    : H1 contenido=restoLinea { System.out.println("<h1>" + convertirTexto($contenido.text) + "</h1>"); }
    | H2 contenido=restoLinea { System.out.println("<h2>" + convertirTexto($contenido.text) + "</h2>"); }
    | H3 contenido=restoLinea { System.out.println("<h3>" + convertirTexto($contenido.text) + "</h3>"); }
    | H4 contenido=restoLinea { System.out.println("<h4>" + convertirTexto($contenido.text) + "</h4>"); }
    | H5 contenido=restoLinea { System.out.println("<h5>" + convertirTexto($contenido.text) + "</h5>"); }
    | H6 contenido=restoLinea { System.out.println("<h6>" + convertirTexto($contenido.text) + "</h6>"); }
    ;

lineaHorizontal
    : (HR | DOUBLE_HR) NEWLINE { System.out.println("<hr/>"); }
    ;

cita
    : BLOCKQUOTE contenido=restoLinea { System.out.println("<blockquote>" + convertirTexto($contenido.text) + "</blockquote>"); }
    ;

bloquecodigo
    : CODE_BLOCK {
        String textoCompleto = $CODE_BLOCK.text;
        String codigoLimpio = textoCompleto.substring(4, textoCompleto.length()-4).trim();
        System.out.println("<pre><code>");
        System.out.print(codigoLimpio);
        System.out.println("</code></pre>");
    }
    ;

lista
    : { System.out.println("<ul>"); }
      (itemLista)+
      NEWLINE
      { System.out.println("</ul>"); }
    ;

itemLista
    : LIST_START contenido=restoLinea {
        System.out.println("<li>" + convertirTexto($contenido.text) + "</li>");
    }
    ;

parrafo
    : contenido=restoLinea {
        String textoHTML = convertirTexto($contenido.text);
        if (textoHTML != null && !textoHTML.trim().isEmpty()) {
            System.out.println("<p>" + textoHTML + "</p>");
        }
    }
    ;

restoLinea
    : (~NEWLINE)* NEWLINE
    ;

H6 : '###### ' ;
H5 : '##### ' ;
H4 : '#### ' ;
H3 : '### ' ;
H2 : '## ' ;
H1 : '# ' ;

BLOCKQUOTE : '> ' ;

LIST_START : '- ' ;

DOUBLE_HR : '===' ;
HR : ('***' | '---' | '___') ;

CODE_BLOCK : '~~~' '\r'? '\n' .*? '~~~' ;

NEWLINE : '\r'? '\n' ;

ANY : . ;
