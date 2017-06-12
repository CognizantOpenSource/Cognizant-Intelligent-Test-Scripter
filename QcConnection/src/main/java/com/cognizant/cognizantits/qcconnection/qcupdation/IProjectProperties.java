package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{59A79946-0678-4E59-B4B0-9967E4314CCA}")
public abstract interface IProjectProperties
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int count();
  
  @DISPID(2)
  @VTID(8)
  public abstract String paramValue(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(3)
  @VTID(9)
  public abstract String paramName(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract boolean isParam(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IProjectProperties
 * JD-Core Version:    0.7.0.1
 */