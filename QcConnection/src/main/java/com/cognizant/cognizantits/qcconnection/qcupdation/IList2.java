package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;
import com4j.stdole.IEnumVARIANT;

@IID("{68AE0EF9-676C-46B3-B190-ACB1BA06A61A}")
public abstract interface IList2
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  public abstract void item(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(1)
  @VTID(8)
  public abstract void clear();
  
  @DISPID(2)
  @VTID(9)
  public abstract int indexOfItem(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(3)
  @VTID(10)
  public abstract void copyFrom(IEnumVARIANT paramIEnumVARIANT, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IList2
 * JD-Core Version:    0.7.0.1
 */