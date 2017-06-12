package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{0F3BB8E6-1740-45C7-97AE-B7DBFD7B8229}")
public abstract interface IParameterGroup
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList members();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object members(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract String name();
  
  @DISPID(3)
  @VTID(9)
  public abstract int id();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IParameterGroup
 * JD-Core Version:    0.7.0.1
 */