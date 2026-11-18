public class StudentPreference{
  
  private String firstName;
  private String favoriteIceCream;

  private static int studentCount = 0;
  
  public StudentPreference (String firstName, String favoriteIceCream){
    this.firstName = firstName;
    this.favoriteIceCream = favoriteIceCream;
    studentCount++;
  }

  public String getFirstName(){
    return firstName;
  }

  public String getfavoriteIceCream(){
    return favoriteIceCream;
  }

  public String getDescription(){
    return firstName + " likes " + favoriteIceCream;
  }

  public static int getStudentCount(){
    return studentCount;
  }

  public static void main(String[] args){
    StudentPreference student1 =
      new StudentPreference("Robert", "Chocolate");
    StudentPreference student2 =
      new StudentPreference("Sam", "Strawberry");
    System.out.println(student1.getDescription());
    System.out.println(student2.getDescription());

    System.out.println(
      "Students created: " +
      StudentPreference.getStudentCount()
    );
  }

}
