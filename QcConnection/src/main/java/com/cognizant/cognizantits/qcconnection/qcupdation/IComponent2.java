package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{9C73D97C-604D-4216-BA26-9008C685C108}")
public abstract interface IComponent2
  extends IComponent
{
  @DISPID(31)
  @VTID(42)
  public abstract boolean isChangeDetectable();
  
  @DISPID(32)
  @VTID(43)
  public abstract boolean hasDynamicDateParameterValue();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponent2
 * JD-Core Version:    0.7.0.1
 */