public class StringManipulator{

    public String trimAndConcat(String st1, String st2){
        String newString=st1.trim().concat((st2.trim()));
        return newString;
    }

    public Integer getIndexOrNull(String st, char c){
        Integer indexOrNull=st.indexOf(c);
        if (indexOrNull==-1){
            return null;
        }
        else {
            return indexOrNull;
        }
    }

    public Integer getIndexOrNull(String st1, String st2){
        Integer indexOrNull=st1.indexOf(st2);
        if (indexOrNull==-1){
            return null;
        }
        else{
            return indexOrNull;
        }
    }

    public String concatSubstring(String st1, int x, int y, String st2){
        String st3=(st1.substring(x,y)).concat(st2);
        return st3;
    }

}