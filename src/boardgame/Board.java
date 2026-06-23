package boardgame;

public class Board {
    
    private int rows;
    private int columns;
    private Piece[][] pieces;
//contrutor
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("erro criando tabuleiro: é necessário ter pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
        //sera criada na quantidade que eu criar de linhas e colunas
    }

    public int getRows() {
        return rows;
    }
  //tirei o setrows e setcolumns para não poder alterar as colunas e linhas depois de criado o tabuleiro
   

    public int getColumns() {
        return columns;
    }

   

    //me retorna a peça que esta na linha e coluna que eu passar
   public Piece piece(int row, int column) {
    if (!positionExists(row, column)) {
        throw new BoardException("posição não existe no tabuleiro");
    }
    return pieces[row][column];
   }
   //retornar a peça pela posicção
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("posição não existe no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        //dar a peça a posição informada
        if (thereIsAPiece(position)) {
            throw new BoardException("já existe uma peça nessa posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
      //fazer o nosso movie 
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("posição não existe no tabuleiro");
        }
        if (piece(position) == null) {
            return null;// nao tem peça nesaa posição
        }
        Piece aux = piece(position);
        aux.position = null; //tira a peça do tabuleiro
        pieces[position.getRow()][position.getColumn()] = null; //tira a peça da matriz
        return aux;
    }


    private boolean positionExists(int row, int column) {
        //verificar se a posição existe no tabuleiro
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
  public boolean positionExists(Position position) {
      //verificar se a posição existe no tabuleiro
        return positionExists(position.getRow(), position.getColumn());
  }
    public boolean thereIsAPiece(Position position) {
        //ele que verifica se uma posição existe
        if (!positionExists(position)) {
            throw new BoardException("posição não existe no tabuleiro");
        }
        return piece(position) != null;
    }
}



