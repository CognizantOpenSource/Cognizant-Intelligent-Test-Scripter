package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{FA8C3437-3B5B-4246-B775-523DEEB2734A}")
public abstract interface IHostGroupFactory
  extends IBaseFactory
{
  @DISPID(8)
  @VTID(16)
  public abstract void removeHost(@MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHostGroupFactory
 * JD-Core Version:    0.7.0.1
 */