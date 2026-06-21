package boardgame;

 
public class Position {
    
    private int row;
    private int column;
    
//crio meu construtor para receber os valores de linha e coluna 
  public Position(int row, int column) {
    this.row = row;
    this.column = column;
  }
 //crio os meus getters e setters para acessar os valores de linha e coluna
  public int getRow() {
    return row;
  }

  public void setRow(int row) {     
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

//para imprimir a posição na tela
    @Override
    public String toString() {
        return row + ", " + column;
    }
    


}
