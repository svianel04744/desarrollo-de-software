package main.modelo;

public class Nodo<E> {
	private E elemento;
	private Nodo<E> next;
	
	/**
	 * @param elemento
	 * @param next
	 */
	public Nodo(E elemento, Nodo<E> next) {
		super();
		this.elemento = elemento;
		this.next = next;
	}

	public E getElemento() {
		return elemento;
	}

	public Nodo<E> getNext() {
		return next;
	}

	public void setNext(Nodo<E> next) {
		this.next = next;
	}
}
