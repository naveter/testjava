package common;

import common.annot.ControlledObject;
import common.annot.StartObject;
import common.annot.StopObject;

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
