package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E672B813-30DA-4429-97A7-A1616F0B7D2D}")
public abstract interface IHistoryRecord2
  extends IHistoryRecord
{
  @DISPID(6)
  @VTID(12)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object oldValue();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHistoryRecord2
 * JD-Core Version:    0.7.0.1
 */