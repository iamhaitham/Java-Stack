public class ProjectClass{
    // Member Variables
    private String name;
    private String description;
    private double initialCost;

    // 3 Constructors
    public ProjectClass(){ 
        }

    public ProjectClass(String name){ 
        this.name=name;
        }

    public ProjectClass(String name, String description){
        this.name=name;
        this.description=description;
    }

    // Name Setter
    public void setName(String name){
        this.name=name;
    }

    // Description Setter
    public void setDescription(String description){
        this.description=description;
    }

    // initialCost Setter
    public void setInitialCost(double initialCost){
        this.initialCost=initialCost;
    }

    // Name Getter
    public String getName(){
        return this.name;
    }
    
    // Description Getter
    public String getDescription(){
        return this.description;
    }

    // initialCost Getter
    public double getInitialCost(){
        return this.initialCost;
    }

    public String elevatorPitch(){
        return "Name: "+this.name+ "("+ this.initialCost +")" +", Description: "+this.description;
    }

}
