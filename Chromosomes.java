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
	 * Pick a integer between [min;max[
	 */
	static int rand_between(int min, int max) 
	{
	  return (int) (Math.random()%(max-min) +min);
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
	  
	  gene.x = rand_between(0, 256);
	  gene.y = rand_between(0, 256);
	  
	  int r = rand_between(0, 256);
	  int g = rand_between(0, 256);
	  int b = rand_between(0, 256);
	  
	  gene.color = Color.rgb(r, g, b);
	  gene.length = rand_between(0, 256);
	}
	
	/*
	 * Mutate a single gene
	 */
	void mutate_gene(Gene gene)
	{
		int r=0,g=0,b=0 ;
	    Gene ge = new Gene();
	  if(Math.random() % 1000 == 0 )
	    gene.x = rand_between(0,256);
	  if(Math.random()% 1000 == 0)  
	    gene.y = rand_between(0,256);
	 
	  if(Math.random() % 1000 == 0)
	     r = rand_between(0,256);
	  if(Math.random() % 1000 == 0)
	    g = rand_between(0,256);
	  if(Math.random() % 1000 == 0)
	    b = rand_between(0,256);
	  ge.color=Color.rgb(r, g, b);

	  if(Math.random() % 500 == 0)
	    gene.length = rand_between(0, 256);
	}
	
	
}
