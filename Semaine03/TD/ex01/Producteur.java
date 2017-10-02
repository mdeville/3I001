import java.util.Random;

public class Producteur implements Runnable {
	private Buffer buff;
	private int nbDepots;
	private Random gen = new Random();

	public Producteur(Buffer b)
	{
		nbDepots = b.getTaille();
		buff = b;
	}

	public void run()
	{
		for(int i = 0; i < nbDepots; i++)
		{
			try
			{
				buff.depot(gen.nextInt(20));
			}
			catch (InterruptedException e)
			{
				System.out.println("Couldn't sleep.");
			}
		}
	}
}
