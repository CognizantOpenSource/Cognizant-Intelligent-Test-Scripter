package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{B3468A97-FD4C-4A05-9E49-1FD0ED7FD9E2}")
public abstract interface IHostGroup
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String name();
  
  @DISPID(15)
  @VTID(24)
  public abstract void addHost(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(16)
  @VTID(25)
  public abstract void removeHost(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(17)
  @VTID(26)
  public abstract IList newList();
  
  @VTID(26)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object newList(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHostGroup
 * JD-Core Version:    0.7.0.1
 */