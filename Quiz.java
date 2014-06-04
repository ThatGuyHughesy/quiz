//Quiz game
//Program reads questions from quiz.txt file
//@author Conor Hughes

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Quiz
{
	public static void main (String [] args)
	{
		LoadQuiz q = new LoadQuiz();
		q.PlayQuiz();
	}
}		
	
class LoadQuiz
{
	private int score = 0;
	private int answer = 0;
	private int rightanswer = 0;
	private String question;
	private String[] options = new String[4];
	private File file = new File("quiz.txt");

	void PlayQuiz()
	{
		try 
		{
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine())
			{
				question = scanner.nextLine();
					
				for(int i = 0; i < 4; i++)
				{
					options[i] = scanner.nextLine();
				}
					
				rightanswer = Integer.parseInt(scanner.nextLine());
					
				answer = JOptionPane.showOptionDialog(null, question, "Question", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0])+1;
				
				if(answer == 0)
				{
					System.exit(0);
				}
				
				if(answer ==rightanswer)
				{
					score++;
					JOptionPane.showMessageDialog(null,
					"Correct!\nYour Score: " + score,
					"Correct!",
					JOptionPane.PLAIN_MESSAGE);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,
					"Incorrect!\nThe correct answer:\n" + rightanswer + ") " + options[rightanswer-1] + "\nYour Score: " + score,
					"Incorrect!",
					JOptionPane.PLAIN_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(null,
			"Game over!\nYour Final Score: " + score,
			"Game Over!",
			JOptionPane.PLAIN_MESSAGE);
		}
		catch (FileNotFoundException e) 
		{
		e.printStackTrace();
		}
	}
}	