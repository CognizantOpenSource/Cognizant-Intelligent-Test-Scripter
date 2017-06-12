package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{FCBDBAD5-380A-43F5-B4D4-4CD988B0C924}")
public abstract interface IRuleManager
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getRule(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract IList rules(@Optional @DefaultValue("0") boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IRuleManager
 * JD-Core Version:    0.7.0.1
 */