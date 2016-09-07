package com.autentica;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Usuario;
import com.service.Autenticador;



@WebServlet( value="/loginServlet", name="login")
public class LoginServlet extends HttpServlet implements Autenticador {
	
	private static final long serialVersionUID = -8221009795841861027L;
	private String nomeUsuario ="usuario";
	private String hashSenha = "97BE8849CFEA47F0B889535A1D024DA2";
	private static MessageDigest md = null;

	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet");
    }

    public void destroy() {
        super.destroy();
        log("Destruindo a servlet");
    }
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista
		String nomeUsuario = "";
		String senhaUsuario = ""; //Senha inicial 123salveeu
		String logout = "";
		
		Usuario user = null;
		//Caso tenha os parametros de usuário seta os valores nas variaveis de usuário e senha
		if(request.getParameter("usuario") !=null || request.getParameter("senha") != null){
			nomeUsuario = request.getParameter("usuario");
			senhaUsuario = request.getParameter("senha");
		}
		
		//valida se a requisição de logoff veio preenchida
		if(request.getParameter("logout") != null){
			logout = request.getParameter("logout");
		}
		
		if( (nomeUsuario != null || !nomeUsuario.equals("")) && (senhaUsuario != null || !senhaUsuario.equals(""))){
			try {
				if(autenticar(nomeUsuario,senhaUsuario,response)){
					if(user == null){
						user = new Usuario();
					}
					user.setNome(nomeUsuario);
					session.setAttribute("user", user);
					response.sendRedirect("/autentica/index.jsp");
				} else{
					logout(session,request, response);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(!logout.equals("") || logout !=null) {
			logout(session,request, response);
		}
	}


	@Override
	public boolean autenticar(String nome, String senha, HttpServletResponse response) throws IOException {

		boolean login = false;
		if (nome.equals(nomeUsuario) && criptografar(senha).equals(hashSenha)) {
			login = true;
		} else {
			login = false;
		}
		return login;
	}

	@Override
	public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session.invalidate();
		response.sendRedirect("/autentica");
	}


	@Override
	public String criptografar(String passwd) {
		String hashSenha = "";
		byte messageDigest[];
		try {
			if(md == null){
				md = MessageDigest.getInstance("MD5");
			}
			messageDigest = md.digest(passwd.getBytes());
			
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0XFF & b));
			}
			hashSenha = hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashSenha;
	}
	
}
