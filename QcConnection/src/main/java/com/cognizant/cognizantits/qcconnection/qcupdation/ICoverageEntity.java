package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{BCF7E6D7-4281-40FA-923B-32DFA90715D7}")
public abstract interface ICoverageEntity
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject requirementEntity();
  
  @DISPID(12)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject targetEntity();
  
  @DISPID(13)
  @VTID(22)
  public abstract String coverageType();
  
  @DISPID(14)
  @VTID(23)
  public abstract String status();
  
  @DISPID(15)
  @VTID(24)
  public abstract String name();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICoverageEntity
 * JD-Core Version:    0.7.0.1
 */