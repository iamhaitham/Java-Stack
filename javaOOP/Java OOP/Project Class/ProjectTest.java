public class ProjectTest{
    public static void main(String[] args){
        // Using an empty constructor
        ProjectClass project1=new ProjectClass();
        project1.setName("Yummy");
        project1.setDescription("A restaurant app created by Django");
        System.out.println(project1.elevatorPitch());

        // Using a constructor with just a name
        ProjectClass project2=new ProjectClass("NumNumNum");
        System.out.println(project2.getName());
        System.out.println(project2.getDescription()); // Should return null
        project2.setDescription("A restaurant app created by Java");
        System.out.println(project2.getDescription());
        System.out.println(project2.elevatorPitch());
        
        // Using a constructor with a name and a description
        ProjectClass project3=new ProjectClass("YummyNum","A restaurant app created by JavaScript");
        System.out.println(project3.elevatorPitch());
    }
}