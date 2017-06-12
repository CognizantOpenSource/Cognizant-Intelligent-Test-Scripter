package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{EB180CC0-6FDE-4A1E-A68E-F106EEED5E15}")
public abstract interface IMultiValue
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String text();
  
  @DISPID(1)
  @VTID(8)
  public abstract void text(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract IList list();
  
  @VTID(9)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object list(int paramInt);
  
  @DISPID(2)
  @VTID(10)
  public abstract void list(IList paramIList);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IMultiValue
 * JD-Core Version:    0.7.0.1
 */