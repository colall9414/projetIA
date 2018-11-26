package imageProcessing;

import java.util.Random;

import javafx.scene.paint.Color;

public class Chromosomes {
	
	public class Gene{
		   int x,y;
		   Color color;
		   int length;
	}

	public class Protein{
		  int x, y;
		  Color color;
		  int length;
	}
	
	/*
	 * Translate a gene to make a protein
	 * (Return a circle definition made from a gene)
	 */
	
	void translate_gene(Gene gene, int screen_width, int screen_height, Protein protein)
	{
	  protein.x= (int)((float)gene.x / 255 * screen_width);
	  protein.y = (int)((float)gene.y / 255 * screen_height);
	  protein.color = gene.color;
	  //The radius is actually proportional to the half of screen diagonal
	  protein.length = (int)((float)gene.length / 255 * Math.sqrt(screen_width * screen_width + screen_height * screen_height)) / 16; 
	}
	
	/*
	 * Randomize a single gene
	 */
	void randomize_gene(Gene gene)
	{
	  Random ra=new Random();
	  gene.x = ra.nextInt(256);
	  gene.y = ra.nextInt(256);
	  
	  int r = ra.nextInt(256);
	  int g = ra.nextInt(256);
	  int b = ra.nextInt(256);
	  
	  gene.color = Color.rgb(r, g, b);
	  gene.length = ra.nextInt(256);
	}
	
	/*
	 * Mutate a single gene
	 */
	void mutate_gene(Gene gene)
	{
		Random ra=new Random();
		int r=0,g=0,b=0 ;
	    Gene ge = new Gene();
	  if(Math.random() % 1000 == 0 )
	    gene.x = ra.nextInt(256);
	  if(Math.random()% 1000 == 0)  
	    gene.y = ra.nextInt(256);
	 
	  if(Math.random() % 1000 == 0)
	     r = ra.nextInt(256);
	  if(Math.random() % 1000 == 0)
	    g = ra.nextInt(256);
	  if(Math.random() % 1000 == 0)
	    b = ra.nextInt(256);
	  ge.color=Color.rgb(r, g, b);

	  if(Math.random() % 500 == 0)
	    gene.length = ra.nextInt(256);
	}
	
	
}

