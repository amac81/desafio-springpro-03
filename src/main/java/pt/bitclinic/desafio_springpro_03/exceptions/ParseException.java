package pt.bitclinic.desafio_springpro_03.exceptions;

public class ParseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ParseException(String msg) {
		super(msg);
	}

}