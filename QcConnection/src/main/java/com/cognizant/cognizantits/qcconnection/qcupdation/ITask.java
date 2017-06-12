package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{A646046A-2FCC-4489-9586-A49B9A59FAEA}")
public abstract interface ITask
  extends IBaseField
{
  @DISPID(15)
  @VTID(20)
  public abstract String state();
  
  @DISPID(15)
  @VTID(21)
  public abstract void state(String paramString);
  
  @DISPID(16)
  @VTID(22)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject taskLogFactory();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITask
 * JD-Core Version:    0.7.0.1
 */