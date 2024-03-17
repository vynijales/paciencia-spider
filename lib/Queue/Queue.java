package Queue;

public class Fila<T> implements InterfaceFila<T>{
	private int inicio;
	private int fim;
	private int size;
	private T valor;
	private T[] fila;
	
	@SuppressWarnings("unchecked")
	public Fila(int size) {
		this.inicio = -1;
		this.fim = -1;
		this.fila = (T[]) new Object[size];
	}
	
	@Override
	public void add(T element) throws Exception {
		if(isFull()) {
			throw new Exception("A fila está cheia");
		}
		else {
			this.fim = (fim + 1) % size;
			fila[fim] = element;
			if(inicio == -1) {
				inicio = 0;
			}
		}
	}

	@Override
	public T remove() throws Exception {
		if(!isEmpty()){
			if(this.inicio == this.fim) {
				valor = this.fila[this.inicio];
				this.inicio = -1;
				this.fim = -1;
				return valor;
			}
			else {
				valor = this.fila[inicio];
				this.inicio++;
				return valor;
			}
		}
		else
			throw new Exception("A fila está vazia");
	}

	@Override
	public T peek() throws Exception {
		if(!isEmpty())
			return this.fila[this.inicio];
		else
			throw new Exception("A fila não contém elementos");
	}

	@Override
	public boolean isEmpty() {
		return this.inicio == -1;
	}

	@Override
	public boolean isFull() {
		int ultimoElemento = (this.fim + 1) % size;
		return ultimoElemento == inicio;
	}

	@Override
	public void show() {
		if(!isEmpty()) {
			for(int i = inicio; i <= fim; i++) {
				System.out.print(fila[i] + " ");
			}
		}
		else {
			System.out.println("A fila está vazia");
		}
		System.out.println();
	}

}
