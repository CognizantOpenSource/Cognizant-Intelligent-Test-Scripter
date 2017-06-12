package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{C5DF6450-F927-425A-A293-3A5CF0EBE56D}")
public abstract interface ICoverable
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject coverageFactory();
  
  @DISPID(2)
  @VTID(8)
  public abstract void coverRequirementEx(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICoverable
 * JD-Core Version:    0.7.0.1
 */