package boardgame;

public class BoardException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    //crio minha classe de exceção personalizada para o tabuleiro
    public BoardException(String msg) {
        super(msg);
    }


}
