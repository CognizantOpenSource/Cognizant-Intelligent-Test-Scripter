package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{860CDC34-7616-4A2B-9005-9FBEF00FEF68}")
public abstract interface IReqCoverageInformation
  extends Com4jObject
{
  @VTID(3)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object getCoverageEntitiesSummary(String paramString, IList paramIList);
  
  @VTID(4)
  public abstract void setCyclesContext(IList paramIList);
  
  @VTID(5)
  public abstract void resetCyclesContext();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReqCoverageInformation
 * JD-Core Version:    0.7.0.1
 */