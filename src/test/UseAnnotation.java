package test;

import test.annot.ControlledObject;
import test.annot.StartObject;
import test.annot.StopObject;

import java.lang.reflect.Method;

public class UseAnnotation {

    public static void go() {

        Class cl = null;
        try {
            cl = Class.forName("test.Cookies");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if (cl == null) {
            return;
        }

        if(!cl.isAnnotationPresent(ControlledObject.class)){
            System.err.println("no annotation");
        } else {
            ControlledObject ann = (ControlledObject)cl.getAnnotation(ControlledObject.class);
            System.out.println("class annotated: " + ann.toString());
            System.out.println("ControlledObject.name = " + ann.name());
        }

        boolean hasStart=false;
        boolean hasStop=false;

        Method[] method = cl.getMethods();
        for(Method md: method){
            if(md.isAnnotationPresent(StartObject.class)) {hasStart=true;}
            if(md.isAnnotationPresent(StopObject.class)) {hasStop=true;}
            if(hasStart && hasStop){break;}
        }

        System.out.println("Start annotaton  - " + hasStart + ";  Stop annotation  - " + hasStop );

    }

}
