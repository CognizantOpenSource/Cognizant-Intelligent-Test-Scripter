package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{A11A2CBD-C066-4E20-9F2B-73F88AB32198}")
public abstract interface IReleaseFactory
  extends IBaseFactoryEx
{
  @DISPID(1610874880)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildCoverageGraph(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReleaseFactory
 * JD-Core Version:    0.7.0.1
 */