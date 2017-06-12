package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{DB466018-78FF-4645-9B45-B32F823C07F3}")
public abstract interface IBPGroup
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList bpComponents();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object bpComponents(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract void addBPComponent(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(3)
  @VTID(9)
  public abstract void deleteBPComponent(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(4)
  @VTID(10)
  public abstract int id();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBPGroup
 * JD-Core Version:    0.7.0.1
 */