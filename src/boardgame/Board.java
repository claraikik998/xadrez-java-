package boardgame;

public class Board {
    
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
        //sera criada na quantidade que eu criar de linhas e colunas
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    //me retorna a peça que esta na linha e coluna que eu passar
   public Piece piece(int row, int column) {
       return pieces[row][column];
   }
   //retornar a peça pela posicção
    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        //dar a peça a posição informada
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
