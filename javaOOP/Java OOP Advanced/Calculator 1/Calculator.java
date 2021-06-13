public class Calculator implements java.io.Serializable{
    private double OperandOne;
    private String Operation;
    private double OperandTwo;
    private double result;

    public Calculator(){
        
    }

    public void setOperandOne(double OperandOne){
        this.OperandOne=OperandOne;
    }

    public void setOperation(String Operation){
        this.Operation=Operation;
    }

    public void setOperandTwo(double OperandTwo){
        this.OperandTwo=OperandTwo;
    }

    public void performOperation(){
        if(this.Operation=="+"){
            this.result=this.OperandOne+this.OperandTwo;
        }else if(this.Operation=="-"){
            this.result=this.OperandOne-this.OperandTwo;
        }
    }

    public double getResults(){
        return this.result;
    }
}