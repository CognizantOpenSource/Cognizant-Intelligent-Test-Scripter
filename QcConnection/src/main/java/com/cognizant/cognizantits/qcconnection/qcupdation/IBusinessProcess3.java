package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{48723D56-A331-45AB-935B-A235AE54CFD1}")
public abstract interface IBusinessProcess3
  extends IBusinessProcess2
{
  @DISPID(126)
  @VTID(74)
  public abstract void alertTestsOnChangeDetected();
  
  @DISPID(127)
  @VTID(75)
  public abstract void deleteChangeDetectionAlert();
  
  @DISPID(128)
  @VTID(76)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getShadowComponent();
  
  @DISPID(129)
  @VTID(77)
  public abstract void unload();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBusinessProcess3
 * JD-Core Version:    0.7.0.1
 */