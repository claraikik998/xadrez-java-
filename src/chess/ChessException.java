package chess;

public class ChessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    //crio minha classe de exceção personalizada para o xadrez
    public ChessException(String msg) {
        super(msg);
    }
     
}
