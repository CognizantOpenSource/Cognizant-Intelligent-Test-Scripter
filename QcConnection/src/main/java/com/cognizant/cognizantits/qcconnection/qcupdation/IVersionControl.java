package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{5D2F9000-FB53-42D0-AFEF-A98AA3355B3B}")
public abstract interface IVersionControl
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void checkIn(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract void checkOut(String paramString);
  
  @DISPID(3)
  @VTID(9)
  public abstract void undoCheckout();
  
  @DISPID(4)
  @VTID(10)
  public abstract IList versions();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object versions(int paramInt);
  
  @DISPID(5)
  @VTID(11)
  public abstract void checkInAndOverrideLastVersion(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVersionControl
 * JD-Core Version:    0.7.0.1
 */