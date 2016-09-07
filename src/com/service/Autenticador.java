package com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface Autenticador {
	boolean autenticar(String nome, String senha, HttpServletResponse response) throws IOException;
	void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
	String criptografar(String passwd);
	
}
