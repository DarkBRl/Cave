package command;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CaveGame {
	public static int caminho(int posicaox, int posicaoy) {
		/*
		 * returns: 
		 *	000(0) = foward			
		 *	00(0)0 = left
		 *  0(0)00 = back
		 *  (0)000 = right		
		 *
		 * 0  = 0000
		 * 1  = 0001
		 * 2  = 0010
		 * 3  = 0011
		 * 4  = 0100
		 * 5  = 0101
		 * 6  = 0110
		 * 7  = 0111
		 * 8  = 1000
		 * 9  = 1001
		 * 10 = 1010
		 * 11 = 1011
		 * 12 = 1100
		 * 13 = 1101
		 * 14 = 1110
		 * 15 = 1111
		 */
		if(posicaox == 0 && posicaoy == 0) {
			System.out.println("1 - ir à esquerda\n2 - seguir em frente");
			return 3;
		}
		if(posicaox == -1 && posicaoy == 0) {
			System.out.println("1 - ir à esquerda\n2 - seguir em frente\n3 - ir à direita");
			return 11;
		}
		if(posicaox == -2 && posicaoy == 0) {
			System.out.println("1 - ir à esquerda\n3 - ir à direita");
			return 10;
		}
		if(posicaox == -3 && posicaoy == 0) {
			System.out.println("2 - seguir em frente\n3 - ir à direita");
			return 9;
		}
		if(posicaox == -3 && posicaoy == 1) {
			System.out.println("4 - voltar");
			return 4;
		}
		if(posicaox == -1 && posicaoy == 1) {
			System.out.println("2 - seguir em frente\n3 - ir à direita\n4 - voltar");
			return 13;
		}
		if(posicaox == -1 && posicaoy == 2) {
			System.out.println("3 - ir à direita\n4 - voltar");
			return 12;
		}
		if(posicaox == 0 && posicaoy == 1) {
			System.out.println("1 - ir à esquerda\n2 - seguir em frente\n3 - ir à direita\n4 - voltar");
			return 15;
		}
		if(posicaox == 0 && posicaoy == 2) {
			System.out.println("1 - ir à esquerda\n3 - ir à direita\n4 - voltar");
			return 14;
		}
		if(posicaox == 1 && posicaoy == 1) {
			System.out.println("1 - ir à esquerda\n2 - seguir em frente");
			return 3;
		}
		if(posicaox == 1 && posicaoy == 2) {
			System.out.println("1 - ir à esquerda\n3 - ir à direita\n4 - voltar");
			return 14;
		}
		if(posicaox == 2 && posicaoy == 2) {
			System.out.println("1 - ir à esquerda\n2 - seguir em frente");
			return 3;
		}
		if(posicaox == 2 && posicaoy == 3) {
			return 0;
		}
		System.out.println("Não é possível ir para onde você escolheu!");
		return -1;
		
		
	}
	public static int escolhaFunction (Cave cave, int escolha, int check) {
	    Command left = new WalkLeft(cave);
	    Command foward = new WalkFoward(cave);
	    Command right = new WalkRight(cave);
	    Command back = new WalkBack(cave);
		Switch mySwitch = new Switch();
		
		switch(escolha) {
        case 1:
        	if (check == 2||check == 3||check == 6||check == 7||check == 10||check == 11||check == 14||check == 15) {
        		mySwitch.switchExecute(left);
        		return 1;
        	}
        	break;
        	
        case 2:
        	if (check == 1||check == 3||check == 5||check == 7||check == 9||check == 11||check == 13||check == 15) {
        		mySwitch.switchExecute(foward);
        		return 1;
        	}
        	break;
        	
        case 3:
        	if (check == 8||check == 9||check == 10||check == 11||check == 12||check == 13||check == 14||check == 15) {
        		mySwitch.switchExecute(right);
        		return 1;
        	}
        	break;
        	
        case 4: 
        	if (check == 4||check == 5||check == 6||check == 7||check == 12||check == 13||check == 14||check == 15) {
        		mySwitch.switchExecute(back);
        		return 1;
        	}
        	break;
        	
        default:
           System.err.println("Escolha inválida");
           return 0;
           }
		
		System.err.println("Não é possível ir para onde você escolheu!");
		return 0;
	}
	
   public static void main(String[] args) throws InterruptedException{
      // definicao de variaveis
	  Scanner a = new Scanner(System.in);
	  Cave cave = new Cave();
      int posicaox = 0;
      int posicaoy = 0;
      int escolha = 0;
      int check = -1;
      
      //para deixar o jogo mais interessante
      
      System.out.println("  ___ __ ___   _____ \r\n" + 
      		" / __/ _` \\ \\ / / _ \\\r\n" + 
      		"| (_| (_| |\\ V /  __/\r\n" + 
      		" \\___\\__,_| \\_/ \\___|");
      System.out.println("Estava de noite naquele dia, uma noite fria e chuvosa...");
      TimeUnit.SECONDS.sleep(7);
      System.out.println("/ // / /  _.._/  // // / / /");TimeUnit.SECONDS.sleep(1);
      System.out.println(" /   / .' .-'` // / / //  /");TimeUnit.SECONDS.sleep(1);
      System.out.println("/ / / /  /  /  /  /   // / ");TimeUnit.SECONDS.sleep(1);
      System.out.println(" /  / |  | /   ///  / / // /");TimeUnit.SECONDS.sleep(1);
      System.out.println("/ /// \\  \\ /  //   /   /  ");TimeUnit.SECONDS.sleep(1);
      System.out.println("/  / / '._'-._ / // /   /// ");TimeUnit.SECONDS.sleep(1);
      System.out.println(" // /  /  ``` /  /  // /  //");TimeUnit.SECONDS.sleep(1);
      
      System.out.println("Você estava caminhando por entre as montanhas para chegar em sua vila...");
      TimeUnit.SECONDS.sleep(7);
      System.out.println(" / /     /_   /.  , / .      /     ./  /       /     /  /      ");TimeUnit.SECONDS.sleep(1);
      System.out.println("   /  *  / \\_ *  / \\_      _  *  /    *   /\\'__  /     *    ");TimeUnit.SECONDS.sleep(1);
      System.out.println("    /   /    \\  /    \\,   ((      / . /  _/  /  \\  *'.   /  ");TimeUnit.SECONDS.sleep(1);
      System.out.println(" / .   /\\/\\  /\\/ :' __ \\_  `      /   _^/  ^/    `--.    / ");TimeUnit.SECONDS.sleep(1);
      System.out.println("      /    \\/  \\  _/  \\-'\\  /   *    /.' ^_   \\_   .'\\  *");TimeUnit.SECONDS.sleep(1);
      System.out.println("  / /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\  ");TimeUnit.SECONDS.sleep(1);
      System.out.println("   /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-       ");TimeUnit.SECONDS.sleep(1);
      System.out.println("  /        `.  / /       `.~-^=-=~=^=.-'      '-._ `._         ");TimeUnit.SECONDS.sleep(1);
      
      System.out.println("Mas de repente você começa a cair. Tudo está muito escuro, você não consegue ver nada enquanto cai.");
      TimeUnit.SECONDS.sleep(10);
      System.out.println("Depois de um tempo, você acorda e rapidamente pega sua lamparina para ver o que está ao seu redor");
      System.out.println("   _\r\n" + 
    		  "  | |\r\n" + 
    		  " ( # )\r\n" + 
    		  "  |=|-+\r\n" + 
    		  " [___]  ");
      TimeUnit.SECONDS.sleep(7);
      System.out.println("Você percebe que está em uma caverna, e decide tentar escapar");
      
      //funcionamento
      while (check != 0) {
	      //escolha e caminho e verificar se ganhou
	      check = caminho(posicaox, posicaoy);
	      if (check == 0) {
	    	  System.out.println("        ___..-..                    ");TimeUnit.SECONDS.sleep(1);
	          System.out.println("     ._/  __ \\_`-.__               ");TimeUnit.SECONDS.sleep(1);
	          System.out.println("     / .'/##\\_ `-.  \\--.          ");TimeUnit.SECONDS.sleep(1);
	          System.out.println("     .-_/#####\\  /-' `\\_          ");TimeUnit.SECONDS.sleep(1);
	          System.out.println("      /###@@###\\_  \\._   `-       ");TimeUnit.SECONDS.sleep(1);
	          System.out.println("    _|###########\\_`.  -' \\       ");TimeUnit.SECONDS.sleep(1);
	          System.out.println("    \" \"'\"''\"'\"'''\" ''\"'\"''\"");TimeUnit.SECONDS.sleep(1);
	    	  System.out.println("Você finalmente achou a saída. Agora está livre para voltar a sua vila em paz... Ou será que não?");
	    	  TimeUnit.SECONDS.sleep(10);
	    	  System.exit(0);
	      }
	      System.out.print("Escolha qual caminho seguir:");
	      
	      //faz "andar"
	      int wrong = 0;
	      boolean invalidInput = true;
	      while(wrong == 0) {
	    	  while(invalidInput) {
		    	  try {
		    		  escolha = a.nextInt();
		    		  invalidInput = false;
		    	  }
		    	  catch (InputMismatchException e){
		    		  System.out.println("Por algum motivo, você tenta fazer ações incompreensíveis. Provavelmente nem você mesmo sabe o que está fazendo."+
		    	  "\nTente fazer algo normal. Talvez escolher qual caminho seguir. Escolha:");
		    		  a.next();
		    	  }
	    	  }
	    	  invalidInput = true;
	    	  wrong = escolhaFunction(cave, escolha, check);
	      }
	      //muda a posicao
	      switch (escolha) {
	      case 1:
	      	posicaox--;
	      	break;
	      	
	      case 2:
	    	posicaoy++;
	      	break;
	      	
	      case 3:
	    	posicaox++;
	      	break;
	      	
	      case 4: 
	    	posicaoy--;
	      	break;
	      }
      }
   }
}