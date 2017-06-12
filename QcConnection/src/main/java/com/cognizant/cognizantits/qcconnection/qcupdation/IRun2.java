package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{16EF2BF4-8509-475E-B34E-3BF99C221221}")
public abstract interface IRun2
  extends IRun
{
  @DISPID(27)
  @VTID(38)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bpStepParamFactory();
  
  @DISPID(28)
  @VTID(39)
  public abstract int testInstanceID();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IRun2
 * JD-Core Version:    0.7.0.1
 */