package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{4A819529-30FB-472C-8DCD-990A8268F956}")
public abstract interface INamedListValue
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String name();
  
  @DISPID(2)
  @VTID(8)
  public abstract IList values();
  
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object values(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.INamedListValue
 * JD-Core Version:    0.7.0.1
 */