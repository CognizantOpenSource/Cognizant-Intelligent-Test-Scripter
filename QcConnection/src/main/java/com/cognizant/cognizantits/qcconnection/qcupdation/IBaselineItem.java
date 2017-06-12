package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{3401C02A-79DD-4366-81F7-853F490137E7}")
public abstract interface IBaselineItem
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IBaseline baseline();
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject entity();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaselineItem
 * JD-Core Version:    0.7.0.1
 */