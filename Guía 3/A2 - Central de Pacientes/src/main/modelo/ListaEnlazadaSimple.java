package main.modelo;

public class ListaEnlazadaSimple<E> {
	private Nodo<E> inicio;
	
	public ListaEnlazadaSimple() {
		this.inicio = null;
	}
	
	public void add(E elemento) {
		Nodo<E> nuevo = new Nodo<E>(elemento, null);
		
		if(inicio == null) {
			inicio = nuevo;
		} else {
			Nodo<E> ultimo = inicio;
			
			while(ultimo.getNext() != null) {
				ultimo = ultimo.getNext();
			}
			
			ultimo.setNext(nuevo);
		}
	}
	
	public E get(int posicion) throws Exception {
		if(inicio == null) {
			throw new Exception("Posición no existe");
		}
		
		int posicionActual = 0;
		Nodo<E> actual = inicio;		
		while(posicionActual < posicion && actual.getNext() != null) {
			posicionActual++;
			actual = actual.getNext();
		}
		
		if(posicionActual == posicion) {
			return actual.getElemento();
		}
		
		throw new Exception("Posición no existe");
	}
	
	public void remove(int posicion) throws Exception {
		if(inicio == null) {
			throw new Exception("Posición no existe");
		}
		
		int posicionActual = 0;
		Nodo<E> anterior = null;
		Nodo<E> actual = inicio;		
		while(posicionActual < posicion && actual.getNext() != null) {
			posicionActual++;
			anterior = actual;
			actual = actual.getNext();
		}

		if(posicionActual == posicion) {
			if(anterior != null) {
				if(actual.getNext() != null) {
					anterior.setNext(actual.getNext());
				} else {
					anterior.setNext(null);
				}
			} else {
				if(actual.getNext() != null) {
					inicio = actual.getNext();
				} else {
					inicio = null;
				}
			}
			
			return;
		}
		
		throw new Exception("Posición no existe");
	}
	
	public int size() {
		if(inicio == null) {
			return 0;
		}
		
		int tamaño = 1;
		Nodo<E> ultimo = inicio;		
		while(ultimo.getNext() != null) {
			tamaño++;
			ultimo = ultimo.getNext();
		}
		
		return tamaño;
	}
}
