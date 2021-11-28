import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class GameFrame extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;

   int randomNumber = new Random().nextInt(10) + 1; //x=(int)(10 * Мath.random());
   int numGuesses = 0;
   String highLow = "";

   JTextField textField = new JTextField(10);
   JButton button = new JButton("Проверить");
   JLabel label = new JLabel(numGuesses + " попыток");
   JButton yesButton = new JButton("Да");
   JButton noButton = new JButton("Нет");
   JLabel labelHighLow = new JLabel(highLow);
   
   public GameFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      setTitle("Игра в угадайку");
      setSize(new Dimension(330,130));
      add(textField);
      add(button);
      add(label);
      button.addActionListener(this);
      //pack();
      setLocationRelativeTo (null);
      setVisible(true);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
       try {
	   if (e.getSource() == button) {
		   String textFieldText = textField.getText();
		   if (Integer.parseInt(textFieldText)==randomNumber) {
			   button.setEnabled(false);
			   textField.setText(textField.getText() + " Верно!");
			   textField.setEnabled(false); //след строка дополняю
			   JLabel dopLabel = new JLabel("Хотите сыграть ещё раз?");
			   remove(labelHighLow);
			   add(dopLabel);
			   
			   add(yesButton);
			   add(noButton);
			   
			   
			   yesButton.addActionListener(this);
			   noButton.addActionListener(this);
			
			   
		   } else {
			   
			   int guess = Integer.parseInt(textField.getText());
			   if (guess < randomNumber)
				   highLow = "Моё число больше чем это";
			   else 
				   highLow = "Моё число меньше чем это";
			   labelHighLow.setText(highLow);
			   add(labelHighLow);
			   textField.setText("");
			   textField.requestFocus();
		   }

		   numGuesses++;
		   String guessWord = "";
		   //    (numGuesses == 1) ? " guess" : " guesses";
		   if (numGuesses == 1) 
			   guessWord = " попытка";
		   else if (numGuesses > 1)
			   guessWord = " попытки"; 
		   else
			   guessWord = " попыток";
      
		   label.setText(numGuesses + guessWord);   
	   }
	   else if (e.getSource() == yesButton) {
		   setVisible(false);	
		   new GameFrame();
	   }	   
	   else 
		   setVisible(false);
       }
       catch (NumberFormatException i) {
    	   textField.setText("Введите число");
    	    new java.util.Timer().schedule(new TimerTask(){
    	    	//@Override
    	    	
    	        public void run() {
    	            System.out.println("Executed...");
    	           //your code here 
    	            textField.setText("");
    	            textField.requestFocus();
    	        }
    	    },1000); 

       }
   }
}
