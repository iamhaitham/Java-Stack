import java.util.HashMap;
import java.util.Set;

public class Hashmatique{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("song #1","lyrics for song #1");
        trackList.put("song #2","lyrics for song #2");
        trackList.put("song #3","lyrics for song #3");
        trackList.put("song #4","lyrics for song #4");
        String songName = trackList.get("song #1");
        System.out.println(songName);
        Set<String> keys = trackList.keySet();
        for(String key:keys){
            System.out.println(key+": "+trackList.get(key));
        }
    }
    }