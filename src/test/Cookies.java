package test;

import test.annot.ControlledObject;
import test.annot.StartObject;
import test.annot.StopObject;

@ControlledObject(name="biscuits")
public class Cookies {

    @StartObject
    public void createCookie(){
        //бизнес логика
    }
    @StopObject
    public void stopCookie(){
        //бизнес логика
    }

}
