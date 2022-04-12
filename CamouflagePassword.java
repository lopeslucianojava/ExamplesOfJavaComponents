/**
 * @author Luciano Lopes
 *
 */
public class CamouflagePassword {
	
	private static int SALT = 1;
	
	public String criptografar(String senha) {
		
		char [] senhaArray = senha.toCharArray();
		String resultado = "";
		
		for(char c : senhaArray) {
			resultado += Character.toString((char)(c + SALT));
		}
		
		return resultado;
		
	}
	
	public String descriptografar(String senha) {
		
		char [] senhaArray = senha.toCharArray();
		String resultado = "";
		
		for(char c : senhaArray) {
			resultado += Character.toString((char)(c - SALT));
		}
		
		return resultado;
		
	}
	
	public static void main(String[] args) {
		CamouflagePassword c = new CamouflagePassword();
		System.out.println( c.criptografar("teste") );
	}
	
}
