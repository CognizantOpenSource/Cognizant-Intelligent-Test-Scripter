package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{9B0DFEB8-0550-44EE-8FB2-7B675009B02F}")
public abstract interface IBaselinedEntity
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList baselines();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object baselines(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaselinedEntity
 * JD-Core Version:    0.7.0.1
 */