import java.util.ArrayList;

public class Main {

  public static void main(String[] args){
    ArrayList<StudentPreference> students = 
      new ArrayList<>();
    students.add(
      new StudentPreference("Maria", "Chocolate"));
    students.add(
      new StudentPreference("Sam", "Cookies and Cream"));
    students.add(
      new StudentPreference("Alex", "Strawberry"));
    //  System.out.println(
    //    "Students created so far: " +
    //    StudentPreference.getStudentCount()
    //  );
    String name = View.getInput("Enter your first name: ");
    String flavor = View.getInput("Enter your favorite flavor: ");
    StudentPreference newStudent = 
      new StudentPreference(name, flavor);
    students.add(newStudent);

    String output =
      "Student Ice Cream Preference\n\n";
    for (StudentPreference student : students){
      output += student.getDescription() + "\n";
    }

    output += "\nTotal Students: " + StudentPreference.getStudentCount();
    View.showMessage(output);
  }
}
