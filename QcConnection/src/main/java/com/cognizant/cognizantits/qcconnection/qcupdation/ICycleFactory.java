package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{B5C61825-C184-4FBC-89FA-A7CC04EF815D}")
public abstract interface ICycleFactory
  extends IBaseFactoryEx
{
  @DISPID(1610874880)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildCoverageGraph(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICycleFactory
 * JD-Core Version:    0.7.0.1
 */