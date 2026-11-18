import javax.swing.JOptionPane;

public class View{
  public static String getInput(String message){
    return JOptionPane.showInputDialog(message);
  }

  public static void showMessage(String message){
    JOptionPane.showMessageDialog(null, message);
  }

  public static void main(String[] args){
    String name =
      View.getInput("Enter your first name: ");
    View.showMessage("Howdy "+ name + "!");
  }
}
