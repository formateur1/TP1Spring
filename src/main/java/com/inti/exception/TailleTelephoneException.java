package com.inti.exception;

public class TailleTelephoneException extends Exception {
	
	public TailleTelephoneException()
	{
		super("La taille du numéro de téléphone n'est pas respecté !");
	}

}
