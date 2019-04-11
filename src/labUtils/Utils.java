package labUtils;

import java.util.Iterator;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}
	
	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>();
			t.addRoot(4);
			
				Position<Integer> rootChild = t.addChild(t.root(), 9);
					t.addChild(rootChild, 7);
					t.addChild(rootChild, 10);
					
				Position<Integer> rootChild2 = t.addChild(t.root(), 20);
					Position<Integer> RootChild210 = t.addChild(rootChild2, 15);
						t.addChild(RootChild210, 12);
						
					Position<Integer> Left = t.addChild(RootChild210, 17);
						t.addChild(Left, 19);
						
					Position<Integer> RootChild220 = t.addChild(rootChild2, 21);
					Position<Integer> Right = t.addChild(RootChild220, 40);
						t.addChild(Right, 30);
						t.addChild(Right, 45);		
		return t; 
	}

	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		t.addRoot(4);
		
			Position<Integer> BaseLeft = t.addLeft(t.root(), 9);
				t.addLeft(BaseLeft, 7);
				t.addRight(BaseLeft, 10);
				
			Position<Integer> BaseRight = t.addRight(t.root(), 20);
				Position<Integer> BaseRightLeft = t.addLeft(BaseRight, 15);
					t.addLeft(BaseRightLeft, 12);
					
					Position<Integer> LastLeft = t.addRight(BaseRightLeft, 17);
						t.addLeft(LastLeft, 19);
						
			Position<Integer> BaseRightRight = t.addRight(BaseRight, 21);
				Position<Integer> LastRight = t.addLeft(BaseRightRight, 40);
					t.addLeft(LastRight, 30);
					t.addRight(LastRight, 45);		
		return t; 
	}

	public static <E> void displayIter(String msg, Iterator<E> iter) { 
		System.out.println(msg); 
		while (iter.hasNext()) 
			System.out.println(iter.next()); 
}


public static LinkedTree<Character> buildTrieAsLinkedTree() { 
   String[] words = {"sal", "sala", "salado", "salto", "si", "u", "un", "uno"}; 

   /*
   String[] words = {"aleluya", "aleluyado", "aleta", "aletas", "alerta", 
        "alertado", "altercado", "altercados", "altura", "alturo", "alturito", 
         "balacera", "bala", "balas", "bala", "balon", "barato"};
   */ 
        
   LinkedTree<Character> t = new LinkedTree<>(); 
   Position<Character> p = t.addRoot('['); 
   for (String s : words)
    addWordToTrie(t, p, s, 0);   // auxiliary method below
            
   return t; 
}
    
private static void addWordToTrie(LinkedTree<Character> t, 
        Position<Character> r, String s, int index) {
   if (index == s.length()) 
    t.addChild(r,  ']'); 
   else { 
      Position<Character> pcc = null;   // position in children of r containing s[index] 
    for (Position<Character> p : t.children(r))
       if (p.getElement().equals(s.charAt(index))) pcc = p; 
    if (pcc == null)
       r = t.addChild(r, s.charAt(index)); 
    else 
       r = pcc;
    addWordToTrie(t, r, s, index+1); 

   }
}




}
