package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{96615E7A-A7C4-4B6F-A00A-418B92070F83}")
public abstract interface IGraphDefinition
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int module();
  
  @DISPID(2)
  @VTID(8)
  public abstract int type();
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object property(int paramInt);
  
  @DISPID(3)
  @VTID(10)
  public abstract void property(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(11)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject filter();
  
  @DISPID(4)
  @VTID(12)
  public abstract void filter(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(5)
  @VTID(13)
  public abstract String text();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IGraphDefinition
 * JD-Core Version:    0.7.0.1
 */