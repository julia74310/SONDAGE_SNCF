package com.example.mysncf_250;

import java.util.HashMap;

public class SNCF {

    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();

    public static void initialiser(){
        if (! SNCF.lesEnquetes.containsKey("rerA")){
            SNCF.lesEnquetes.put("rerA", new Enquete());
        }
        if (! SNCF.lesEnquetes.containsKey("rerB")){
            SNCF.lesEnquetes.put("rerB", new Enquete());
        }
        if (! SNCF.lesEnquetes.containsKey("rerC")){
            SNCF.lesEnquetes.put("rerC", new Enquete());
        }
        if (! SNCF.lesEnquetes.containsKey("rerD")){
            SNCF.lesEnquetes.put("rerD", new Enquete());
        }
        if (! SNCF.lesEnquetes.containsKey("rerE")){
            SNCF.lesEnquetes.put("rerE", new Enquete());
        }
    }

    public static Enquete getEnquete(String rer){ return SNCF.lesEnquetes.get(rer);
    }
}
