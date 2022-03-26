package fp.clinico;

import java.time.LocalDateTime;

import java.util.*;

public class Pruebas {

	public static void main(String[] args) {
	
		
		
		
		String dni= "23231332P";
		List<Integer> lista= new ArrayList<Integer>();
		boolean res= false;
		
		if (dni.length() ==9 && Character.isDigit(dni.charAt(0)) && Character.isDigit(dni.charAt(1)) && 
				Character.isDigit(dni.charAt(2))&& Character.isDigit(dni.charAt(3)) &&
				Character.isDigit(dni.charAt(4))&& Character.isDigit(dni.charAt(5)) &&
			Character.isDigit(dni.charAt(6))&& Character.isDigit(dni.charAt(7)) && Character.isLetter(dni.charAt(8)) ) {
			res= true;
			
			}
		System.out.println(res);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for (int i = 0; i < dni.length(); i++) {
//			 boolean res= true;
//			 boolean[] digito= new boolean[9];
//			 List<Boolean>digitos= new ArrayList<Boolean>();
//	            if (!Character.isDigit(dni.charAt(i))) {
//	                res = false;
//	                if (res= false) {
//	                	i=i+1;
//	                }
//	           
//	            }
//	            else {
//	            	res= true;
//	            	 
//	            	
//	            }
	            //digito[i]= res;
//	            digitos.add(res);
//	            System.out.println(digitos.get(0));
	            
	            //System.out.println(res);
//	            if digito
	        }
	        
	    
			
			
			//System.out.println(lista);
			//System.out.println(ent);
		
		
		
		
		
		
		
		
		
		
		
	
		String texto= "34K ; Female;80.";
		String[] paciente= texto.split(",");
		String texto1= paciente[0];
//		String texto2= paciente[1];
//		System.out.println(texto1);
		//Integer dniInt= Integer.parseInt(dni);
		
//		for(int i=0;i <= dni.length()-1;i++) {
//			String res;
//			Integer dniInt= Integer.parseInt(dni.charAt(i));
//			if (dni.charAt(i)==1) {
//				res="True "+i;
//			}
//			else {
//				res="False "+i;
//			}
//			System.out.println(res);
//		}
			
			
//		//List<Integer> lista= new ArrayList<Integer>();
//				for(int i=0;i <= dni.length()-1;i++) {
//					Integer res;
//					if (dni.charAt(i)==1) {
//						res="True "+i;
//					}
//					else {
//						res="False "+i;
//					}
//					System.out.println(res);
//				}
				
	
//		
//		System.out.println(dni.charAt(0));
		
		
//		 for (int i = 0; i < dni.length(); i++) {
//			 boolean res= true;
//	            if (!Character.isDigit(dni.charAt(i))) {
//	                res = false;
//	            }
//	            System.out.println(res);
//	        }
//	        
//	    }

	

}



