package first;

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

   int randomNumber = new Random().nextInt(10) + 1; //x=(int)(10 * Ìath.random());
   int numGuesses = 0;
   String highLow = ""; //èçì
   JTextField textField = new JTextField(10);
   JButton button = new JButton("Check");
   JLabel label = new JLabel(numGuesses + " attempts");
   JButton yesButton = new JButton("Yes");
   JButton noButton = new JButton("No");
   JLabel labelHighLow = new JLabel(highLow);
   
   public GameFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      setTitle("Guess game");
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
			   textField.setText(textField.getText() + " Right!");
			   textField.setEnabled(false); 
			   JLabel dopLabel = new JLabel("Would you like to play again?");
			   remove(labelHighLow);
			   add(dopLabel);
			   
			   add(yesButton);
			   add(noButton);
			   
			   
			   yesButton.addActionListener(this);
			   noButton.addActionListener(this);
			
			   
		   } else {
			   
			   int guess = Integer.parseInt(textField.getText());
			   if (guess < randomNumber)
				   highLow = "My number is higher than " + guess;
			   else 
				   highLow = "My number is lower than " + guess;
			   labelHighLow.setText(highLow);
			   add(labelHighLow);
			   textField.setText("");
			   textField.requestFocus();
		   }

		   numGuesses++;
		   String guessWord = "";
		   //    (numGuesses == 1) ? " guess" : " guesses";
		   if (numGuesses == 1) 
			   guessWord = " attempt";
		   else 
			   guessWord = " attempts"; 
		   //else
			//   guessWord = " ïîïûòîê";
		   
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
    	   textField.setText("write the number");
    	    new java.util.Timer().schedule(new TimerTask(){
    	    	
    	    	//@Override
    	        public void run() {
    	            System.out.println("exciting...");
    	           //your code here 
    	            textField.setText("");
    	            textField.requestFocus();
    	        }
    	    },1000); 

       }
   }
}
