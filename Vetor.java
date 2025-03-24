import java.awt.geom.Ellipse2D;

class Vetor {
    String[ ] A; // armazena os elementos do vetor
    int capacity; // capacidade do vetor - length
    int size; // elementos no vetor - qtde elementos
    
    public Vetor(int capacity) {
        A = new String[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
    
    public boolean isEmpty() {
        //verifica se o Vetor está vazio ou não
        if (size==0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        //verifica se o Vetor está cheio
        if (size==capacity)
            return true;
        else
            return false;            
    }
            
    public int size() {
        // retorna a qtde de elementos no Vetor
        return size;
    }
    
    public String get(int i) throws Exception {
        // retorna o elemento da posição i
        if (i<0 || i>=size)
            throw new Exception("Posição inválida!!");
        return A[i];
    }
    
    public void set(int i, String n) throws Exception {
        //substitui o conteúdo da posição i por n
        if (i<0 || i>=size)
            throw new Exception("Posição inválida!!");
        A[i]=n;
    }
    
    public void add(int i, String n) throws Exception {
        //adiciona o elemento n na posição i
        if (isFull()) {
            throw new Exception("A lista está cheia!! Impossível inserir");
        }
        if (i<0 || i > size) {
            throw new Exception("Posição inválida!!");
        }
        for (int p = size; p > i; p--) {
            A[p] = A[p - 1];
        }
        A[i] = n;
        size++;
    }
    
    public void remove(int i) throws Exception {
        //remove o elemento da posição i
        if (isEmpty())
            throw new Exception("A lista está vazia!! Impossível remover");
        if (i<0 || i > size-1) {
            throw new Exception("Posição inválida!!");
        }
        for (int p = i; p<=size-2;p++){
            A[p]=A[p+1];
        }
        size--;
    }
    
    public int search(String n) {
        // busca o valor n na lista - retornando a posição ou -1, se não existir
        for (int i=0;i<size;i++)
            if (A[i].equals(n))
                return i;
        return -1;
    }
    
    public void show() {
       // mostra todo o conteúdo da lista
       for (int i=0;i<size;i++)
           System.out.println(A[i]);
        
       System.out.println("\nFim da lista!!");
    }
}