package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{15FBB8D4-7034-413E-A8F0-1E03B7FA4F0B}")
public abstract interface IHistory
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList newList(String paramString);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject filter();
  
  @DISPID(3)
  @VTID(9)
  public abstract void clearHistory(@Optional @DefaultValue("") String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHistory
 * JD-Core Version:    0.7.0.1
 */