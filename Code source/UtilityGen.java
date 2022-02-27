import java.util.Stack;

public class UtilityGen {
    private Stack<Utility> currentScope = new Stack<Utility>();

    public UtilityGen() {
    }

    public static int getCurrentAddr(){
        return Utility.getCurrentAddr();
    }

    public static void setCurrentAddr(int currentAddr){
        Utility.setCurrentAddr(currentAddr);
    }

    public void addScope() {
        Utility s = null;
        if(currentScope.isEmpty()){
            s =  new Utility(null);
        }else{
            s =  new Utility(currentScope.peek());
        }
        currentScope.add(s);
    }

    public void deleteScope() {
        currentScope.pop();
    }

    public int addVariable(String input) throws ParseException {
        return currentScope.peek().makeAddr(input);
    }

    public int findVariable(String input) throws ParseException {
        return currentScope.peek().findAddr(input);
    }
}

