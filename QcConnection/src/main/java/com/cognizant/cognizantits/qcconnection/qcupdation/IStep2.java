package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{5FF530DD-245E-4F97-A59F-3DE69FFCC55E}")
public abstract interface IStep2
  extends IStep
{
  @DISPID(19)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bpStepParamFactory();
  
  @DISPID(20)
  @VTID(31)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject run();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IStep2
 * JD-Core Version:    0.7.0.1
 */