// DirectoryManager.java

import java.util.*;

public class DirectoryManager {
    
    private Hashtable<String, FileInfo> T = new Hashtable<String, FileInfo>();
    
    
    void enter(String key, FileInfo file) {
    	T.put(key, file);
    }
    
    FileInfo lookup(String key) {
    	return T.get(key);
    }

};


