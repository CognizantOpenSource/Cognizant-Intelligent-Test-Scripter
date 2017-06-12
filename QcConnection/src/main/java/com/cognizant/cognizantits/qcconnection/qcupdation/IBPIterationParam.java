package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{B40742AD-3BED-40B4-BD58-0F24E41ACDD2}")
public abstract interface IBPIterationParam
  extends IBaseField
{
  @DISPID(20)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bpParameter();
  
  @DISPID(21)
  @VTID(21)
  public abstract String value();
  
  @DISPID(21)
  @VTID(22)
  public abstract void value(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBPIterationParam
 * JD-Core Version:    0.7.0.1
 */