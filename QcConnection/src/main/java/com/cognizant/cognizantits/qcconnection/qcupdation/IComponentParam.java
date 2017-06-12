package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{F65AD9CD-D5A3-4EC5-8904-017E4E9D2351}")
public abstract interface IComponentParam
  extends IBaseParam
{
  @DISPID(20)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject component();
  
  @DISPID(21)
  @VTID(31)
  public abstract int isOut();
  
  @DISPID(21)
  @VTID(32)
  public abstract void isOut(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponentParam
 * JD-Core Version:    0.7.0.1
 */