package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{F6376DA6-02E6-4A5E-99BB-C8485CEFF72E}")
public abstract interface IVersionItem2
  extends IVersionItem
{
  @DISPID(7)
  @VTID(13)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object dateEx();
  
  @DISPID(8)
  @VTID(14)
  public abstract IList baselines();
  
  @VTID(14)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object baselines(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVersionItem2
 * JD-Core Version:    0.7.0.1
 */